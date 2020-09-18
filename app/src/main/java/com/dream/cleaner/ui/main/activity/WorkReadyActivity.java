package com.dream.cleaner.ui.main.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.MyPhotoBean;
import com.dream.cleaner.ui.ImagePriview.ImagePreviewActivity;
import com.dream.cleaner.ui.main.GlideEngine;
import com.dream.cleaner.ui.main.adapter.PhotoAdapter;
import com.dream.cleaner.ui.main.contract.WorkReadyActivityContract;
import com.dream.cleaner.ui.main.presenter.WorkReadyActivityPresenter;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.SuperToast;
import com.dream.common.widget.ToolbarBackTitle;
import com.huantansheng.easyphotos.EasyPhotos;
import com.huantansheng.easyphotos.callback.SelectCallback;
import com.huantansheng.easyphotos.models.album.entity.Photo;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * @author : Liyalei
 * date   : 2020/9/15
 * desc   :扫前准备   确认开始服务
 * 扫后拍照  确认完成服务
 */
public class WorkReadyActivity extends BaseActivity<WorkReadyActivityPresenter> implements WorkReadyActivityContract {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_ok)
    TextView tvOk;
    @BindView(R.id.tv_no)
    TextView tvNo;
    @BindView(R.id.my_rv)
    RecyclerView myRv;
    @BindView(R.id.tv_reason_title)
    TextView tvReasonTitle;
    @BindView(R.id.et_reason)
    EditText etReason;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    private PhotoAdapter photoAdapter;
    private int maxSize = 9;
    private ArrayList<File> luBanListAfter = new ArrayList<>();
    private boolean isSuccess = true;
    private int postsPictureIndex;
    private ArrayList<String> luBanList = new ArrayList<>();
    private String orderId = "";
    private String orderStatus = "";
    /**
     * 接口返回的图片地址
     */
    private ArrayList<String> picUrlList = new ArrayList<>();
    private boolean isBefore;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work_ready;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "扫前准备");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        if (getIntent() != null) {
            Intent intent = getIntent();
            isBefore = intent.getBooleanExtra("isBefore", true);
            orderId = intent.getStringExtra("orderId");
            orderStatus = intent.getStringExtra("orderStatus");
        }

        ArrayList<MyPhotoBean> myPhotoBeans = new ArrayList<>();
        myPhotoBeans.add(new MyPhotoBean("1", ""));
        photoAdapter = new PhotoAdapter(myPhotoBeans);
        photoAdapter.addChildClickViewIds(R.id.iv_photo, R.id.iv_close);
        photoAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                MyPhotoBean item = photoAdapter.getItem(position);
                String type = item.getType();
                switch (view.getId()) {
                    case R.id.iv_photo: {
                        if ("1".equals(type)) {
//                            EasyPhotos.createCamera(WorkReadyActivity.this)//参数说明：上下文
//                                    .setFileProviderAuthority(GlobalApp.FILE_PROVIDER)//参数说明：见下方`FileProvider的配置`
//                                    .start(new SelectCallback() {
//                                        @Override
//                                        public void onResult(ArrayList<Photo> photos, boolean isOriginal) {
//                                            if (photos.size()>0) {
//                                                Photo photo = photos.get(0);
//                                                String path = photo.path;
//                                                photoAdapter.addData(0, new MyPhotoBean("2",photo.uri));
//                                            }
//                                        }
//                                    });
                            EasyPhotos.createAlbum(WorkReadyActivity.this, true, GlideEngine.getInstance())//参数说明：上下文
                                    .setFileProviderAuthority(GlobalApp.FILE_PROVIDER)//参数说明：见下方`FileProvider的配置`
                                    .setCount(maxSize - photoAdapter.getPhotoSize() == 0 ? 1 : maxSize - photoAdapter.getPhotoSize())
                                    .setPuzzleMenu(false)
                                    .setGif(false)
                                    .setVideo(false)
                                    .start(new SelectCallback() {
                                        @Override
                                        public void onResult(ArrayList<Photo> photos, boolean isOriginal) {
                                            int size = photos.size();
                                            if (size > 0) {
                                                for (int i = 0; i < size; i++) {
                                                    Photo photo = photos.get(i);
                                                    photoAdapter.addData(0, new MyPhotoBean("2", photo.uri, photo.path));
                                                    if (photoAdapter.getPhotoSize() == maxSize) {
                                                        MyPhotoBean lastItem = photoAdapter.getItem((photoAdapter.getItemCount() - 1));
                                                        if ("1".equals(lastItem.getType())) {
                                                            photoAdapter.remove(lastItem);
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                }

                                            }
                                        }
                                    });
                        } else {
                            //查看大图
                            Intent intent = new Intent(WorkReadyActivity.this, ImagePreviewActivity.class);
                            List<MyPhotoBean> data = photoAdapter.getData();
                            int size = data.size();
                            ArrayList<Uri> strings = new ArrayList<>();
                            for (int i = 0; i < size; i++) {
                                MyPhotoBean myPhotoBean = data.get(i);
                                if ("2".equals(myPhotoBean.getType())) {
                                    strings.add(myPhotoBean.getUri());

                                }
                            }
                            intent.putParcelableArrayListExtra("imageList", strings);
                            intent.putExtra(ImagePreviewActivity.START_ITEM_POSITION, position);
                            intent.putExtra(ImagePreviewActivity.START_IAMGE_POSITION, position);
                            startActivity(intent);
                        }
                    }
                    break;
                    case R.id.iv_close: {
                        photoAdapter.remove(item);
                        int itemCount = photoAdapter.getItemCount();
                        if (itemCount == (maxSize - 1)) {
                            if (!"1".equals(photoAdapter.getItem(maxSize - 2).getType())) {
                                photoAdapter.addData((maxSize - 1), new MyPhotoBean("1", ""));
                            }
                        }
                    }
                    default:
                }
            }
        });
        myRv.setLayoutManager(new GridLayoutManager(this, 4));
        myRv.setAdapter(photoAdapter);
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    private void setMaterielType(boolean isYes) {
        Drawable check = ResourceUtils.getDrawable(R.mipmap.checkbox_login_check);
        check.setBounds(0, 0, check.getMinimumWidth(), check.getMinimumHeight());
        Drawable unCheck = ResourceUtils.getDrawable(R.mipmap.checkbox_login_uncheck);
        unCheck.setBounds(0, 0, unCheck.getMinimumWidth(), unCheck.getMinimumHeight());
        if (isYes) {
            myRv.setVisibility(View.VISIBLE);
            tvOk.setCompoundDrawables(check, null, null, null);
            tvNo.setCompoundDrawables(unCheck, null, null, null);
        } else {
            myRv.setVisibility(View.GONE);
            tvOk.setCompoundDrawables(unCheck, null, null, null);
            tvNo.setCompoundDrawables(check, null, null, null);
        }
    }


    @OnClick({R.id.tv_ok, R.id.tv_no, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_ok:
                setMaterielType(true);
                break;
            case R.id.tv_no:
                setMaterielType(false);
                break;
            case R.id.tv_submit:
                picUrlList.clear();
                FileUtils.createOrExistsDir(getExternalFilesDir("android.os.Environment#DIRECTORY_PICTURES") + "/Icon/");
                luBanList = new ArrayList<>();
                int photoSize = photoAdapter.getPhotoSize();
                for (int i = 0; i < photoSize; i++) {
                    MyPhotoBean item = photoAdapter.getItem(i);
                    luBanList.add(item.getPath());
                }
                final int[] success = {0};
                Luban
                        .with(this)
                        .load(luBanList)
                        .ignoreBy(500)
                        .setTargetDir(getExternalFilesDir("android.os.Environment#DIRECTORY_PICTURES") + "/Icon/")
                        .filter(new CompressionPredicate() {
                            @Override
                            public boolean apply(String path) {
                                return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                            }
                        })
                        .setCompressListener(new OnCompressListener() {
                            @Override
                            public void onStart() {

                            }

                            @Override
                            public void onSuccess(File file) {
                                luBanListAfter.add(file);
                                //全部压缩完成则开始上传图片
                                if (success[0] == (luBanList.size() - 1)) {
                                    postsPictureIndex = 0;
                                    mPresenter.ossUpload(luBanListAfter.get(0));
                                }
                                success[0]++;
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        })
                        .launch();

                break;
            default:
        }
    }

    @Override
    public void returnUpLoadImageStatus(String originalUrl, String constringentUrl) {
        if (isSuccess) {
            if ("失败".equals(originalUrl)) {
                isSuccess = false;
                SuperToast.showShortMessage("上传图片失败，请重新上传");
            } else if ("无网络".equals(originalUrl)) {
                isSuccess = false;
            } else {
                isSuccess = true;
                picUrlList.add(originalUrl);
                //判断是否是最后一张
                if (postsPictureIndex == (luBanList.size() - 1)) {
                    mPresenter.beforeClean(orderId, orderStatus, isBefore, picUrlList, etReason.getText().toString(), "2", "", "", new ArrayList<>());
                } else {
                    postsPictureIndex++;
                    mPresenter.ossUpload(luBanListAfter.get(postsPictureIndex));
                }
            }
        }

    }

    @Override
    public void returnBeforeClean(String s) {

    }
}

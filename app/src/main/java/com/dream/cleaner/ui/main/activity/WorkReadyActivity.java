package com.dream.cleaner.ui.main.activity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.aip.asrwakeup3.core.recog.MyRecognizer;
import com.baidu.aip.asrwakeup3.core.recog.listener.ChainRecogListener;
import com.baidu.aip.asrwakeup3.core.recog.listener.IRecogListener;
import com.baidu.aip.asrwakeup3.core.recog.listener.MessageStatusRecogListener;
import com.baidu.aip.asrwakeup3.core.util.MyLogger;
import com.baidu.aip.asrwakeup3.uiasr.params.CommonRecogParams;
import com.baidu.aip.asrwakeup3.uiasr.params.OnlineRecogParams;
import com.baidu.voicerecognition.android.ui.BaiduASRDigitalDialog;
import com.baidu.voicerecognition.android.ui.DigitalDialogInput;
import com.blankj.utilcode.util.BusUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.blankj.utilcode.util.SPUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.BusBean;
import com.dream.cleaner.beans.MyPhotoBean;
import com.dream.cleaner.ui.ImagePriview.ImagePreviewActivity;
import com.dream.cleaner.ui.main.GlideEngine;
import com.dream.cleaner.ui.main.adapter.PhotoAdapter;
import com.dream.cleaner.ui.main.contract.WorkReadyActivityContract;
import com.dream.cleaner.ui.main.presenter.WorkReadyActivityPresenter;
import com.dream.cleaner.utils.SoftKeyboardFixerForFullscreen;
import com.dream.cleaner.widget.pop.PopTip;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.SuperToast;
import com.dream.common.widget.ToolbarBackTitle;
import com.huantansheng.easyphotos.EasyPhotos;
import com.huantansheng.easyphotos.callback.SelectCallback;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
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
    @BindView(R.id.tv_bu_tui_kuan_title)
    TextView tvBuTuiKuanTitle;
    @BindView(R.id.tv_not_need)
    TextView tvNotNeed;
    @BindView(R.id.tv_need_bu_kuan)
    TextView tvNeedBuKuan;
    @BindView(R.id.tv_need_tui_kuan)
    TextView tvNeedTuiKuan;
    @BindView(R.id.et_price)
    EditText etPrice;
    @BindView(R.id.et_shuo_ming)
    EditText etShuoMing;
    @BindView(R.id.iv_yu_yin)
    ImageView ivYuYin;
    @BindView(R.id.rv_bu_tui_kuan)
    RecyclerView rvBuTuiKuan;
    @BindView(R.id.ll_bu_tui_kuan)
    LinearLayout llBuTuiKuan;
    @BindView(R.id.ll_price)
    LinearLayout llPrice;
    @BindView(R.id.ll_shuo_ming)
    LinearLayout llShuoMing;
    @BindView(R.id.ll_tui_kuan_rv)
    LinearLayout llTuiKuanRv;
    @BindView(R.id.my_examples_rv)
    RecyclerView myExamplesRv;
    /**
     * 扫前或扫后适配器
     */
    private PhotoAdapter photoAdapter;
    /**
     * 补退款说明适配器
     */
    private PhotoAdapter photoAdapter2;
    private int maxSize = 9;
    private ArrayList<File> luBanListAfter = new ArrayList<>();
    private boolean isSuccess = true;
    private int postsPictureIndex;
    private ArrayList<String> luBanList = new ArrayList<>();
    private String orderId = "";
    private String orderStatus = "";
    /**
     * 接口返回的图片地址 扫前 扫后
     */
    private ArrayList<String> picUrlList = new ArrayList<>();
    /**
     * 接口返回的图片地址  补退款说明
     */
    private ArrayList<String> picUrlList2 = new ArrayList<>();
    /**
     * true 扫前准备
     * false 扫后拍照 补退款
     */
    private boolean isBefore;
    private int suppleRefundType;
    private ChainRecogListener chainRecogListener;
    private PopTip popPermissionsTip;
    /**
     * 识别控制器，使用MyRecognizer控制识别的流程
     */
    protected MyRecognizer myRecognizer;
    /**
     * 对话框界面的输入参数
     */
    private DigitalDialogInput input;
    protected boolean running = false;
    private MyHandler handler;
    private ToolbarBackTitle toolbarBackTitle;

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
        toolbarBackTitle = new ToolbarBackTitle(this, "扫前准备");
        return toolbarBackTitle;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        if (getIntent() != null) {
            Intent intent = getIntent();
            isBefore = intent.getBooleanExtra("isBefore", true);
            orderId = intent.getStringExtra("orderId");
            orderStatus = intent.getStringExtra("orderStatus");
        }
        SoftKeyboardFixerForFullscreen.assistActivity(this);
        handler = new MyHandler(this);
        MyLogger.setHandler(handler);
        initPermission();
        setMyPhotoAdapter(true);
        setMyPhotoAdapter(false);
        initVoice();
        if (isBefore) {
            tvTitle.setText("扫前准备");
            llBuTuiKuan.setVisibility(View.GONE);
            tvSubmit.setText("确认开始服务");
            toolbarBackTitle.setTitle("扫前准备");
            tvReasonTitle.setText("服务备注");
            etReason.setHint("请输入服务备注");
            ArrayList<MyPhotoBean> myPhotoBeans = new ArrayList<>();
            myPhotoBeans.add(new MyPhotoBean("4", getMipmapToUri(R.mipmap.bg_da_sao_qian_mi_ni_1), getMipmapToUri(R.mipmap.bg_da_sao_qian_1)));
            myPhotoBeans.add(new MyPhotoBean("4", getMipmapToUri(R.mipmap.bg_da_sao_qian_mi_ni_2), getMipmapToUri(R.mipmap.bg_da_sao_qian_2)));
            myPhotoBeans.add(new MyPhotoBean("4", getMipmapToUri(R.mipmap.bg_da_sao_qian_mi_ni_3), getMipmapToUri(R.mipmap.bg_da_sao_qian_3)));
            setExamplesAdapter(myPhotoBeans);
        } else {
            tvTitle.setText("扫后拍照");
            llBuTuiKuan.setVisibility(View.VISIBLE);
            tvSubmit.setText("确认完成服务");
            toolbarBackTitle.setTitle("完成服务");
            setBuTuiKuan(2);
            tvReasonTitle.setText("服务补充");
            etReason.setHint("请输入服务补充");
            ArrayList<MyPhotoBean> myPhotoBeans = new ArrayList<>();
            myPhotoBeans.add(new MyPhotoBean("4", getMipmapToUri(R.mipmap.bg_da_sao_hou_mi_ni_1), getMipmapToUri(R.mipmap.bg_da_sao_hou_1)));
            myPhotoBeans.add(new MyPhotoBean("4", getMipmapToUri(R.mipmap.bg_da_sao_hou_mi_ni_2), getMipmapToUri(R.mipmap.bg_da_sao_hou_2)));
            myPhotoBeans.add(new MyPhotoBean("4", getMipmapToUri(R.mipmap.bg_da_sao_hou_mi_ni_3), getMipmapToUri(R.mipmap.bg_da_sao_hou_3)));
            setExamplesAdapter(myPhotoBeans);
        }
        BusUtils.register(this);
    }

    /**
     * 设置示例适配器
     *
     * @param myPhotoBeans
     */
    private void setExamplesAdapter(ArrayList<MyPhotoBean> myPhotoBeans) {
        PhotoAdapter examplesAdapter = new PhotoAdapter(myPhotoBeans);
        examplesAdapter.addChildClickViewIds(R.id.iv_photo, R.id.iv_close);
        examplesAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                MyPhotoBean item = examplesAdapter.getItem(position);
                String type = item.getType();
                switch (view.getId()) {
                    case R.id.iv_photo: {
                        if ("1".equals(type)) {
                            getPic(examplesAdapter);
                        } else {
                            //查看大图
                            lookOld(examplesAdapter, position, "4");
                        }
                    }
                    break;
                    case R.id.iv_close: {
                        cleanAdapterItem(examplesAdapter, item);
                    }
                    default:
                }
            }
        });
        myExamplesRv.setLayoutManager(new GridLayoutManager(this, 4));
        myExamplesRv.setAdapter(examplesAdapter);


    }

    private Uri getMipmapToUri(int resId) {

        Resources r = getResources();
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + r.getResourcePackageName(resId) + "/"
                + r.getResourceTypeName(resId) + "/"
                + r.getResourceEntryName(resId));

        return uri;
    }

    private void initPermission() {
        String[] permissions = {
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.INTERNET,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
        };
        Disposable subscribe = new RxPermissions(WorkReadyActivity.this).requestEach(permissions)
                .subscribe(aBoolean -> {
                    if (aBoolean.granted) {
                    } else if (aBoolean.shouldShowRequestPermissionRationale) {
                        initPermission();
                    } else {
                        popPermissionsTip = new PopTip.Builder()
                                .setType(1)
                                .setTitle("提示")
                                .setSubmitText("立即获取")
                                .setMsg("考啦需要以下权限才能正常运行")
                                .setSubmitClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        // 帮跳转到该应用的设置界面，让用户手动授权
                                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        Uri uri = Uri.fromParts("package", WorkReadyActivity.this.getPackageName(), null);
                                        intent.setData(uri);
                                        startActivity(intent);
                                        popPermissionsTip.dismiss();
                                    }
                                }).build(WorkReadyActivity.this);
                    }
                });
    }

    private static class MyHandler extends Handler {
        private WeakReference<WorkReadyActivity> mWeakReference;

        private MyHandler(WorkReadyActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            WorkReadyActivity mActivity = mWeakReference.get();
        }
    }


    private void initVoice() {
        /**
         * 有2个listner，一个是用户自己的业务逻辑，如MessageStatusRecogListener。另一个是UI对话框的。
         * 使用这个ChainRecogListener把两个listener和并在一起
         */
        chainRecogListener = new ChainRecogListener();
//         DigitalDialogInput 输入 ，MessageStatusRecogListener可替换为用户自己业务逻辑的listener
        // 基于DEMO集成第1.1, 1.2, 1.3 步骤 初始化EventManager类并注册自定义输出事件
        // DEMO集成步骤 1.2 新建一个回调类，识别引擎会回调这个类告知重要状态和识别结果
        IRecogListener listener = new MessageStatusRecogListener(handler);
        chainRecogListener.addListener(listener);
        // DEMO集成步骤 1.1 1.3 初始化：new一个IRecogListener示例 & new 一个 MyRecognizer 示例,并注册输出事件
        myRecognizer = new MyRecognizer(this, listener);
        // 替换掉原来的listener
        myRecognizer.setEventListener(chainRecogListener);

    }

    /**
     * @param b true 扫前准备adapter
     */
    private void setMyPhotoAdapter(boolean b) {
        if (b) {
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
                                getPic(photoAdapter);
                            } else {
                                //查看大图
                                lookOld(photoAdapter, position, "");
                            }
                        }
                        break;
                        case R.id.iv_close: {
                            cleanAdapterItem(photoAdapter, item);
                        }
                        default:
                    }
                }
            });
            myRv.setLayoutManager(new GridLayoutManager(this, 4));
            myRv.setAdapter(photoAdapter);
        } else {
            ArrayList<MyPhotoBean> myPhotoBeans = new ArrayList<>();
            myPhotoBeans.add(new MyPhotoBean("1", ""));
            photoAdapter2 = new PhotoAdapter(myPhotoBeans);
            photoAdapter2.addChildClickViewIds(R.id.iv_photo, R.id.iv_close);
            photoAdapter2.setOnItemChildClickListener(new OnItemChildClickListener() {
                @Override
                public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                    MyPhotoBean item = photoAdapter2.getItem(position);
                    String type = item.getType();
                    switch (view.getId()) {
                        case R.id.iv_photo: {
                            if ("1".equals(type)) {
                                getPic(photoAdapter2);
                            } else {
                                //查看大图
                                lookOld(photoAdapter2, position, "");
                            }
                        }
                        break;
                        case R.id.iv_close: {
                            cleanAdapterItem(photoAdapter2, item);
                        }
                        default:
                    }
                }
            });
            rvBuTuiKuan.setLayoutManager(new GridLayoutManager(this, 3));
            rvBuTuiKuan.setAdapter(photoAdapter2);
        }

    }

    private void getPic(PhotoAdapter photoAdapter) {
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
                        int size = (photos == null ? 0 : photos.size());
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
    }

    private void cleanAdapterItem(PhotoAdapter photoAdapter, MyPhotoBean item) {
        photoAdapter.remove(item);
        int itemCount = photoAdapter.getItemCount();
        if (itemCount == (maxSize - 1)) {
            if (!"1".equals(photoAdapter.getItem(maxSize - 2).getType())) {
                photoAdapter.addData((maxSize - 1), new MyPhotoBean("1", ""));
            }
        }

    }

    private void lookOld(PhotoAdapter photoAdapter, int position, String type) {
        Intent intent = new Intent(WorkReadyActivity.this, ImagePreviewActivity.class);
        List<MyPhotoBean> data = photoAdapter.getData();
        int size = data.size();
        ArrayList<Uri> strings = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            MyPhotoBean myPhotoBean = data.get(i);
            if ("2".equals(myPhotoBean.getType()) || "4".equals(myPhotoBean.getType())) {
                strings.add(myPhotoBean.getUri());
            }
        }
        intent.putParcelableArrayListExtra("imageList", strings);
        intent.putExtra("type", type);
        intent.putExtra(ImagePreviewActivity.START_ITEM_POSITION, position);
        intent.putExtra(ImagePreviewActivity.START_IAMGE_POSITION, position);
        startActivity(intent);

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
            myExamplesRv.setVisibility(View.VISIBLE);
            tvOk.setCompoundDrawables(check, null, null, null);
            tvNo.setCompoundDrawables(unCheck, null, null, null);
        } else {
            myRv.setVisibility(View.GONE);
            myExamplesRv.setVisibility(View.GONE);
            tvOk.setCompoundDrawables(unCheck, null, null, null);
            tvNo.setCompoundDrawables(check, null, null, null);
        }
    }


    @OnClick({R.id.tv_ok, R.id.tv_no, R.id.tv_submit, R.id.tv_not_need, R.id.tv_need_bu_kuan, R.id.tv_need_tui_kuan, R.id.iv_yu_yin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_ok:
                setMaterielType(true);
                break;
            case R.id.tv_no:
                setMaterielType(false);
                break;
            case R.id.tv_submit:
                upLoad(true);
                break;
            case R.id.tv_not_need:
                setBuTuiKuan(2);
                break;
            case R.id.tv_need_bu_kuan:
                setBuTuiKuan(1);
                break;
            case R.id.tv_need_tui_kuan:
                setBuTuiKuan(0);
                break;
            case R.id.iv_yu_yin:
                startVoice();

                break;
            default:
        }
    }

    /**
     * @param b true 扫前 扫后拍照   false 补退款说明照片
     */
    private void upLoad(boolean b) {
        FileUtils.createOrExistsDir(getExternalFilesDir("android.os.Environment#DIRECTORY_PICTURES") + "/Icon/");
        luBanList = new ArrayList<>();
        luBanListAfter.clear();
        //true 扫钱准备或扫后拍张 false 服务说明
        if (b) {
            picUrlList.clear();
            int photoSize = photoAdapter.getPhotoSize();
            for (int i = 0; i < photoSize; i++) {
                MyPhotoBean item = photoAdapter.getItem(i);
                luBanList.add(item.getPath());
            }
            if (photoSize == 0) {
                if (isBefore) {
                    mPresenter.beforeClean(orderId, orderStatus, isBefore, picUrlList, etReason.getText().toString(), suppleRefundType + "", etPrice.getText().toString(), etShuoMing.getText().toString(), picUrlList2);
                } else {
                    upLoad(false);
                    return;
                }
            }
        } else {
            picUrlList2.clear();
            int photoSize = photoAdapter2.getPhotoSize();
            for (int i = 0; i < photoSize; i++) {
                MyPhotoBean item = photoAdapter2.getItem(i);
                luBanList.add(item.getPath());
            }
            if (photoSize == 0) {
                mPresenter.confirmFinish(orderId, orderStatus, isBefore, picUrlList, etReason.getText().toString(), suppleRefundType + "", etPrice.getText().toString(), etShuoMing.getText().toString(), picUrlList2);
            }
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
                            mPresenter.ossUpload(luBanListAfter.get(0), b);
                        }
                        success[0]++;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                })
                .launch();
    }

    /**
     * @param index 设置补退款  0，退款，1补款  2 不需要
     */
    private void setBuTuiKuan(int index) {
        suppleRefundType = index;
        Drawable check = ResourceUtils.getDrawable(R.mipmap.checkbox_login_check);
        check.setBounds(0, 0, check.getMinimumWidth(), check.getMinimumHeight());
        Drawable unCheck = ResourceUtils.getDrawable(R.mipmap.checkbox_login_uncheck);
        unCheck.setBounds(0, 0, unCheck.getMinimumWidth(), unCheck.getMinimumHeight());
        tvNotNeed.setCompoundDrawables(index == 2 ? check : unCheck, null, null, null);
        tvNeedBuKuan.setCompoundDrawables(index == 1 ? check : unCheck, null, null, null);
        tvNeedTuiKuan.setCompoundDrawables(index == 0 ? check : unCheck, null, null, null);
        llPrice.setVisibility(index == 2 ? View.GONE : View.VISIBLE);
        llShuoMing.setVisibility(index == 2 ? View.GONE : View.VISIBLE);
        llTuiKuanRv.setVisibility(index == 2 ? View.GONE : View.VISIBLE);
    }

    @Override
    public void returnUpLoadImageStatus(String originalUrl, String constringentUrl, boolean isSaoQianZhunBei) {
        if (isSuccess) {
            if ("失败".equals(originalUrl)) {
                isSuccess = false;
                SuperToast.showShortMessage("上传图片失败，请重新上传");
            } else if ("无网络".equals(originalUrl)) {
                isSuccess = false;
            } else {
                isSuccess = true;
                if (isSaoQianZhunBei) {
                    picUrlList.add(originalUrl);
                } else {
                    picUrlList2.add(originalUrl);
                }
                //判断是否是最后一张
                if (postsPictureIndex == (luBanList.size() - 1)) {
                    //判断是不是扫前准备
                    if (isBefore) {
                        mPresenter.beforeClean(orderId, orderStatus, isBefore, picUrlList, etReason.getText().toString(), suppleRefundType + "", etPrice.getText().toString(), etShuoMing.getText().toString(), picUrlList2);
                    } else {
                        int photoSize = photoAdapter2.getPhotoSize();
                        if (picUrlList2.size() == photoSize) {
                            mPresenter.confirmFinish(orderId, orderStatus, isBefore, picUrlList, etReason.getText().toString(), suppleRefundType + "", etPrice.getText().toString(), etShuoMing.getText().toString(), picUrlList2);
                        } else {
                            upLoad(false);
                        }
                    }
                } else {
                    postsPictureIndex++;
                    mPresenter.ossUpload(luBanListAfter.get(postsPictureIndex), isSaoQianZhunBei);
                }
            }
        }

    }

    @Override
    public void returnBeforeClean(String s) {
        BusBean busBean = new BusBean();
        busBean.setOrderStatus(orderStatus);
        BusUtils.post(GlobalApp.BUS_FRAGMENT_WORK, busBean);
        finish();
    }

    private Map<String, Object> fetchParams() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //  上面的获取是为了生成下面的Map， 自己集成时可以忽略
        OnlineRecogParams onlineRecogParams = new OnlineRecogParams();
        Map<String, Object> params = onlineRecogParams.fetch(defaultSharedPreferences);
        //  集成时不需要上面的代码，只需要params参数。
        return params;
    }


    /**
     * 开始录音，点击“开始”按钮后调用。
     */
    private void startVoice() {
        // 此处params可以打印出来，直接写到你的代码里去，最终的json一致即可。
        final Map<String, Object> params = fetchParams();

        // BaiduASRDigitalDialog的输入参数
        input = new DigitalDialogInput(myRecognizer, chainRecogListener, params);
        // 传递input信息，在BaiduASRDialog中读取,
        BaiduASRDigitalDialog.setInput(input);
        Intent intent = new Intent(this, BaiduASRDigitalDialog.class);

        // 修改对话框样式
        // intent.putExtra(BaiduASRDigitalDialog.PARAM_DIALOG_THEME, BaiduASRDigitalDialog.THEME_ORANGE_DEEPBG);

        running = true;
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        running = false;
        if (requestCode == 2) {
            String message = "";
            if (resultCode == RESULT_OK) {
                ArrayList results = data.getStringArrayListExtra("results");
                if (results != null && results.size() > 0) {
                    message += results.get(0);
                }
            } else {
                message += "没有结果";
            }
            String oldString = etShuoMing.getText().toString();
            String etContent = oldString + message;
            etShuoMing.setText(etContent);
            etShuoMing.setSelection(etContent.length());
            MyLogger.info(message);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!running) {
            if (myRecognizer != null) {
                myRecognizer.release();
            }
        }
        BusUtils.unregister(this);
    }
}

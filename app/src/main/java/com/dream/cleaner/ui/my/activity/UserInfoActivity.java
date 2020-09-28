package com.dream.cleaner.ui.my.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.StringUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.ui.my.contract.UserInfoActivityContract;
import com.dream.cleaner.ui.my.presenter.UserInfoActivityPresenter;
import com.dream.cleaner.utils.ImageLoaderUtils;
import com.dream.cleaner.utils.InfoUtils;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.cleaner.widget.pop.PopTip;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.ToolbarBackTitle;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;

/**
 * @author : liyl
 * date   : 2020/8/23
 * desc   :
 */
public class UserInfoActivity extends BaseActivity<UserInfoActivityPresenter> implements UserInfoActivityContract {
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_mobile)
    TextView tvMobile;
    @BindView(R.id.rb_star)
    RatingBar rbStar;
    @BindView(R.id.cl_user_info)
    ConstraintLayout clUserInfo;
    @BindView(R.id.tv_work_info)
    TextView tvWorkInfo;
    @BindView(R.id.tv_user_id)
    TextView tvUserId;
    @BindView(R.id.tv_work)
    TextView tvWork;
    @BindView(R.id.tv_work_address)
    TextView tvWorkAddress;
    @BindView(R.id.tv_work_year)
    TextView tvWorkYear;
    @BindView(R.id.tv_work_time)
    TextView tvWorkTime;
    @BindView(R.id.tv_work_company)
    TextView tvWorkCompany;
    @BindView(R.id.tv_direct_leadership)
    TextView tvDirectLeadership;
    @BindView(R.id.tv_direct_leadership_mobile)
    TextView tvDirectLeadershipMobile;
    @BindView(R.id.tv_health_certificate)
    TextView tvHealthCertificate;
    @BindView(R.id.tv_health_certificate_date)
    TextView tvHealthCertificateDate;
    @BindView(R.id.tv_call_mobile)
    TextView tvCallMobile;
    private PopTip popTip;
    private PopTip popPermissionsTip;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "个人资料");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCallMobile.setBackground(ShapeUtils.getDiyGradientDrawable(R.color.white, 0, ConvertUtils.dp2px(1), R.color.color_F6B351));
        setInfo();
        mPresenter.userInfo(InfoUtils.getCleanerId());
        tvCallMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = {Manifest.permission.CALL_PHONE};
                Disposable subscribe = new RxPermissions(UserInfoActivity.this).requestEach(permissions)
                        .subscribe(aBoolean -> {
                            if (aBoolean.granted) {
                                callPhone(InfoUtils.getDirectContactPhone());
                            } else if (aBoolean.shouldShowRequestPermissionRationale) {
                                callPhone(InfoUtils.getDirectContactPhone());
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
                                                Uri uri = Uri.fromParts("package", UserInfoActivity.this.getPackageName(), null);
                                                intent.setData(uri);
                                                startActivity(intent);
                                                popPermissionsTip.dismiss();
                                            }
                                        }).build(UserInfoActivity.this);
                            }
                        });
            }
        });
    }

    /**
     * 打电话
     */
    private void callPhone(final String phone) {
        popTip = new PopTip.Builder().
                setType(2).
                setTitle("提示").
                setMsg("确定拨打电话" + phone + "?").
                setSubmitClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popTip.dismiss();
                    }
                }).
                setCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popTip.dismiss();
                    }
                }).
                setYesClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        Uri data = Uri.parse("tel:" + phone);
//                        Uri data = Uri.parse("tel:15733125211"  );
                        intent.setData(data);
                        //不影响程序的运行
                        if (ActivityCompat.checkSelfPermission(UserInfoActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        startActivity(intent);
                        popTip.dismiss();
                    }
                }).build(UserInfoActivity.this);
        popTip.showPopupWindow();
    }


    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void returnUserInfoBean(LoginBean.CleanerBean cleanerBean) {
        InfoUtils.setCleanerBean(cleanerBean);
        setInfo();
    }

    private void setInfo() {
        tvName.setText(InfoUtils.getName());
        tvMobile.setText(InfoUtils.getPhone());
        rbStar.setRight(3);
        tvUserId.setText("员工编号   " + InfoUtils.getCleanerNo());
        tvWork.setText("工作岗位   " + InfoUtils.getServiceAreaName());
        tvWorkAddress.setText("所属区域   " + InfoUtils.getServiceAreaName());
        tvWorkYear.setText("入职时间   " + InfoUtils.getEntryDate());
        tvWorkTime.setText("工作时间   " + InfoUtils.getWorkAge());
        tvWorkCompany.setText("所属公司   " + InfoUtils.getOutSourceName());
        tvDirectLeadership.setText("直属领导   " + InfoUtils.getDirectContactName());
        tvDirectLeadershipMobile.setText("联系电话   " + InfoUtils.getDirectContactPhone());
        tvHealthCertificate.setText("健康证号   " + InfoUtils.getHealthCertNo());
        tvHealthCertificateDate.setText("有效日期   " + InfoUtils.getHealthCertDate());
        ImageLoaderUtils.loadImgCircle(InfoUtils.getHeadIcPath(), ivHead);
        setLevel();

    }

    /**
     * 设置用户星级
     */
    private void setLevel() {
        String userLevel = InfoUtils.getUserLevel();
        if ("一星".equals(userLevel)) {
            rbStar.setRating(1);
        } else if ("二星".equals(userLevel)) {
            rbStar.setRating(2);
        } else if ("三星".equals(userLevel)) {
            rbStar.setRating(3);
        } else if ("四星".equals(userLevel)) {
            rbStar.setRating(4);
        } else if ("五星".equals(userLevel)) {
            rbStar.setRating(5);
        }
    }

}

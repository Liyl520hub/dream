package com.dream.cleaner.ui.login.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.dream.cleaner.BuildConfig;
import com.dream.cleaner.R;
import com.dream.cleaner.base.MyApplication;
import com.dream.cleaner.beans.login.AgreementBean;
import com.dream.cleaner.ui.login.contract.MobileVerificationActivityContract;
import com.dream.cleaner.ui.login.presenter.MobileVerificationActivityPresenter;
import com.dream.cleaner.utils.CodeUtils;
import com.dream.cleaner.utils.HttpUrlConnectionUtil;
import com.dream.cleaner.utils.ImageLoaderUtils;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.cleaner.utils.UiUtil;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.SuperToast;
import com.dream.common.widget.ToolbarBackTitle;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :重置密码
 */
public class MobileVerificationActivity extends BaseActivity<MobileVerificationActivityPresenter> implements MobileVerificationActivityContract {

    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.et_local_code)
    EditText etLocalCode;
    @BindView(R.id.iv_local_code)
    ImageView ivLocalCode;
    @BindView(R.id.ll_verification)
    LinearLayout llVerification;
    @BindView(R.id.et_mobile_code)
    EditText etMobileCode;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.ll_mobile_code)
    LinearLayout llMobileCode;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    private String phone;
    private String localCode;
    private String mobileCode;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_verification_mobile;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "手机验证");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        getLocalCode();
        checkSubmitTv();
        etMobileCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkSubmitTv();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * 输入框不为空则变颜色
     */
    private void checkSubmitTv() {
        boolean b = !StringUtils.isEmpty(etMobileCode.getText().toString());
        tvSubmit.setBackground(ShapeUtils.getDiyGradientDrawable(b ? R.color.color_72BB38 : R.color.color_5072bb38, 0, 0, 0));
        tvSubmit.setClickable(b);
    }

    @OnClick({R.id.iv_local_code, R.id.tv_get_code, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_local_code:
                getLocalCode();
                break;
            case R.id.tv_get_code:
                if (checkEt()) {
                    localCode = etLocalCode.getText().toString();
                    if (StringUtils.isEmpty(localCode)) {
                        SuperToast.showShortMessage("请输入图形验证码");
                        return;
                    }
                    mPresenter.updateCheckLocalCode(phone, localCode);
                }
                break;
            case R.id.tv_submit:
                if (checkEt()) {
                    mobileCode = etMobileCode.getText().toString();
                    if (StringUtils.isEmpty(mobileCode)) {
                        SuperToast.showShortMessage("请输入验证码");
                        return;
                    }
                    mPresenter.updateCheckCode(phone, mobileCode);
                }

                break;
            default:
        }
    }

    private void getLocalCode() {
        String captchaUrl = BuildConfig.HOST_SERVER + "app/cleaner/getImage";
        HttpUrlConnectionUtil.setWallpaper(ivLocalCode, captchaUrl);
    }

    private boolean checkEt() {
        phone = etMobile.getText().toString();
        if (StringUtils.isEmpty(phone)) {
            SuperToast.showShortMessage("请输入手机号");
            return false;
        }
        if (!RegexUtils.isMobileExact(phone)) {
            SuperToast.showShortMessage("手机号格式不正确");
            return false;
        }
        return true;
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {
        if (errorCode == 1) {
            //图形验证码错误，重新获取
            getLocalCode();
        }
    }

    @Override
    public void returnAgreementPhone(String agreementBean, boolean isLocal) {
        if (isLocal) {
            mPresenter.agreementPhone(phone, localCode);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("phone", phone);
            bundle.putString("code", mobileCode);
            UiUtil.openActivity(this, ResetPasswordActivity.class, bundle);
            finish();
        }
    }
}

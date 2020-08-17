package com.dream.cleaner.ui.login.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.ui.login.contract.LoginContract;
import com.dream.cleaner.ui.login.presenter.LoginPresenter;
import com.dream.cleaner.ui.main.MainActivity;
import com.dream.cleaner.utils.H5Activity;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.cleaner.utils.UiUtil;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.HttpCustomDialog;
import com.dream.common.http.error.ErrorType;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_mobile_title)
    TextView tvMobileTitle;
    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.tv_password_title)
    TextView tvPasswordTitle;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_tip)
    TextView tvTip;
    @BindView(R.id.contract_checkbox)
    CheckBox contractCheckbox;
    @BindView(R.id.rl_contract_checkbox)
    RelativeLayout rlContractCheckbox;
    @BindView(R.id.ll_remember)
    LinearLayout llRemember;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_agreement)
    TextView tvAgreement;
    @BindView(R.id.tv_reset_password)
    TextView tvResetPassword;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return null;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        checkSubmitTv();
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showTipOrGone("");
                checkSubmitTv();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        etMobile.addTextChangedListener(textWatcher);
        etPassword.addTextChangedListener(textWatcher);
        if ("1".equals(SPUtils.getInstance().getString(GlobalApp.REMEMBER_PASSWORD))) {
            String mobile = SPUtils.getInstance().getString(GlobalApp.USER_LOGIN_MOBILE,"");
            etMobile.setText(mobile);
            etMobile.setSelection(mobile.length());
            String pwd = SPUtils.getInstance().getString(GlobalApp.USER_LOGIN_PASSWORD,"");
            etPassword.setText(pwd);
            etPassword.setSelection(pwd.length());
            contractCheckbox.setChecked(true);
        } else {
            contractCheckbox.setChecked(false);
        }
        SpannableStringBuilder spannable = new SpannableStringBuilder("登录即表示同意用户协议、隐私条款");
        setMspan(spannable, 7, 12, true);
        setMspan(spannable, 12, 16, false);
        tvAgreement.setText(spannable);
        tvAgreement.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * 输入框不为空则变颜色
     */
    private void checkSubmitTv() {
        boolean b = !StringUtils.isEmpty(etMobile.getText().toString()) && !StringUtils.isEmpty(etPassword.getText().toString());
        tvLogin.setBackground(ShapeUtils.getDiyGradientDrawable(b?R.color.color_72BB38:R.color.color_5072bb38, 0, 0, 0));
        tvLogin.setClickable(b);
    }


    @OnClick({R.id.contract_checkbox, R.id.tv_reset_password, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.contract_checkbox:
                //勾选记住密码

                break;
            case R.id.tv_reset_password:
                //重置密码
                UiUtil.openActivity(this, MobileVerificationActivity.class);
                break;
            case R.id.tv_login:
                //登录
                String mobile = etMobile.getText().toString();
                if (StringUtils.isEmpty(mobile)) {
                    showTipOrGone("请输入手机号");
                    return;
                }
                if (!RegexUtils.isMobileExact(mobile)) {
                    showTipOrGone("请输入正确手机号");
                    return;
                }
                String password = etPassword.getText().toString();
                if (StringUtils.isEmpty(password)) {
                    showTipOrGone("请输入密码");
                    return;
                }
                if (contractCheckbox.isChecked()) {
                    SPUtils.getInstance().put(GlobalApp.USER_LOGIN_MOBILE, mobile);
                    SPUtils.getInstance().put(GlobalApp.USER_LOGIN_PASSWORD, password);
                    SPUtils.getInstance().put(GlobalApp.REMEMBER_PASSWORD, "1");
                } else {
                    SPUtils.getInstance().put(GlobalApp.REMEMBER_PASSWORD, "0");
                }
              mPresenter.userLogin(mobile,password);
                break;
            default:
        }
    }

    /**
     * @param content 文本为空即是隐藏
     */
    private void showTipOrGone(String content) {
        tvTip.setVisibility(StringUtils.isEmpty(content) ? View.INVISIBLE : View.VISIBLE);
        tvTip.setText(content);
    }

    private void setMspan(SpannableStringBuilder spannable, int start, int end, boolean isPrivacy) {
        spannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Bundle bundle = new Bundle();
                bundle.putString("weburl", "content");
                bundle.putString("titleStr", isPrivacy ? "用户协议" : "隐私条款");
                UiUtil.openActivity(LoginActivity.this, H5Activity.class, bundle);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                //设置颜色
                ds.setColor(Color.parseColor("#488AFA"));
                //去掉下划线
                ds.setUnderlineText(true);
            }
        }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    @Override
    public void retrunLoginBean(LoginBean loginBean) {
        UiUtil.openActivity(this, MainActivity.class);
        finish();
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}

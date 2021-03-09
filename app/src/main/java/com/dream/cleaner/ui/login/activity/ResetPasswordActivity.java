package com.dream.cleaner.ui.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.BusUtils;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.BusBean;
import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.ui.login.contract.ResetPasswordActivityContract;
import com.dream.cleaner.ui.login.presenter.ResetPasswordActivityPresenter;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.SuperToast;
import com.dream.common.widget.ToolbarBackTitle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author : admin
 * date   : 2020/8/16
 * desc   :重置密码
 */
public class ResetPasswordActivity extends BaseActivity<ResetPasswordActivityPresenter> implements ResetPasswordActivityContract {
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_password_again)
    EditText etPasswordAgain;
    @BindView(R.id.tv_tip)
    TextView tvTip;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    /**
     * 密码校验
     */
    private String parr = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$";
    private String phone;
    private String code;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reset_password;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "密码重置");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        BusUtils.register(this);
        Intent intent = getIntent();
        if (intent != null) {
            phone = intent.getStringExtra("phone");
            code = intent.getStringExtra("code");
        }
        checkSubmitTv();
        TextWatcher textWatcher = new TextWatcher() {
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
        };
        etPassword.addTextChangedListener(textWatcher);
        etPasswordAgain.addTextChangedListener(textWatcher);
    }

    /**
     * 输入框不为空则变颜色
     */
    private void checkSubmitTv() {
        boolean b = !StringUtils.isEmpty(etPassword.getText().toString()) && !StringUtils.isEmpty(etPasswordAgain.getText().toString());
        tvSubmit.setBackground(ShapeUtils.getDiyGradientDrawable(b ? R.color.color_72BB38 : R.color.color_5072bb38, 0, 0, 0));
        tvSubmit.setClickable(b);

    }

    @OnClick(R.id.tv_submit)
    public void onViewClicked() {
        String pwd = etPassword.getText().toString();
        if (!RegexUtils.isMatch(parr, pwd)) {
            SuperToast.showShortMessage("请输入6-12位密码，仅包含数字或字母");
            return;
        }
        String pwdAgain = etPasswordAgain.getText().toString();
        if (!pwdAgain.equals(pwd)) {
            SuperToast.showShortMessage("两次密码不一致");
            return;
        }
        mPresenter.updatePassword(phone, pwd, code);
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusUtils.unregister(this);
    }

    @Override
    public void returnUpdatePassWordBean(LoginBean loginBean) {
        BusUtils.post(GlobalApp.BUS_LOGIN_ACTIVITY, new BusBean());
        finish();
    }
}

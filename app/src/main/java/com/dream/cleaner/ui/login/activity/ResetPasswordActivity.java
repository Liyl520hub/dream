package com.dream.cleaner.ui.login.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.SuperToast;
import com.dream.common.widget.ToolbarBackTitle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :重置密码
 */
public class ResetPasswordActivity extends BaseActivity {
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
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    /**
     * 密码校验
     */
    private String parr = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reset_password;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "手机号验证");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvSubmit.setBackground(ShapeUtils.getDiyGradientDrawable(R.color.color_0879FC, ConvertUtils.dp2px(4), 0, 0));

    }


    @OnClick(R.id.tv_submit)
    public void onViewClicked() {
        String pwd = etMobile.getText().toString();
        if (!RegexUtils.isMatch(parr, pwd)) {
            SuperToast.showShortMessage("请输入6-12位密码，仅包含数字或字母");
            return;
        }
        String pwdAgain = etPassword.getText().toString();
        if (!pwdAgain.equals(pwd)) {
            SuperToast.showShortMessage("两次密码不一致");
            return;
        }
        finish();
    }
}

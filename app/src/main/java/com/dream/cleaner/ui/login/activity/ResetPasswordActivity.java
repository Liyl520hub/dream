package com.dream.cleaner.ui.login.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reset_password;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "密码重置");
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
        tvSubmit.setBackground(ShapeUtils.getDiyGradientDrawable(b?R.color.color_72BB38:R.color.color_5072bb38, 0, 0, 0));
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
        finish();
    }
}

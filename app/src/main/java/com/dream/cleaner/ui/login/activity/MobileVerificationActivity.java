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
import com.blankj.utilcode.util.StringUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.utils.CodeUtils;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.cleaner.utils.UiUtil;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.SuperToast;
import com.dream.common.widget.ToolbarBackTitle;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :重置密码
 */
public class MobileVerificationActivity extends BaseActivity {

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
    private CodeUtils codeUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_verification_mobile;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "手机验证");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        codeUtils = CodeUtils.getInstance();
        ivLocalCode.setImageBitmap(codeUtils.createBitmap());
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
                ivLocalCode.setImageBitmap(codeUtils.createBitmap());
                break;
            case R.id.tv_get_code:
                break;
            case R.id.tv_submit:
                if (codeUtils.getCode().equals(etLocalCode.getText().toString())) {
                    SuperToast.showShortMessage("验证码不正确");
                    return;
                }
                UiUtil.openActivity(this, ResetPasswordActivity.class);
                finish();
                break;
            default:
        }
    }
}

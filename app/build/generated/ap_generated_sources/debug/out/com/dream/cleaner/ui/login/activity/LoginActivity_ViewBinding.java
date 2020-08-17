// Generated code from Butter Knife. Do not modify!
package com.dream.cleaner.ui.login.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dream.cleaner.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view7f080062;

  private View view7f080144;

  private View view7f080148;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvMobileTitle = Utils.findRequiredViewAsType(source, R.id.tv_mobile_title, "field 'tvMobileTitle'", TextView.class);
    target.etMobile = Utils.findRequiredViewAsType(source, R.id.et_mobile, "field 'etMobile'", EditText.class);
    target.tvPasswordTitle = Utils.findRequiredViewAsType(source, R.id.tv_password_title, "field 'tvPasswordTitle'", TextView.class);
    target.etPassword = Utils.findRequiredViewAsType(source, R.id.et_password, "field 'etPassword'", EditText.class);
    target.tvTip = Utils.findRequiredViewAsType(source, R.id.tv_tip, "field 'tvTip'", TextView.class);
    view = Utils.findRequiredView(source, R.id.contract_checkbox, "field 'contractCheckbox' and method 'onViewClicked'");
    target.contractCheckbox = Utils.castView(view, R.id.contract_checkbox, "field 'contractCheckbox'", CheckBox.class);
    view7f080062 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rlContractCheckbox = Utils.findRequiredViewAsType(source, R.id.rl_contract_checkbox, "field 'rlContractCheckbox'", RelativeLayout.class);
    target.llRemember = Utils.findRequiredViewAsType(source, R.id.ll_remember, "field 'llRemember'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_login, "field 'tvLogin' and method 'onViewClicked'");
    target.tvLogin = Utils.castView(view, R.id.tv_login, "field 'tvLogin'", TextView.class);
    view7f080144 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvAgreement = Utils.findRequiredViewAsType(source, R.id.tv_agreement, "field 'tvAgreement'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_reset_password, "field 'tvResetPassword' and method 'onViewClicked'");
    target.tvResetPassword = Utils.castView(view, R.id.tv_reset_password, "field 'tvResetPassword'", TextView.class);
    view7f080148 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTitle = null;
    target.tvMobileTitle = null;
    target.etMobile = null;
    target.tvPasswordTitle = null;
    target.etPassword = null;
    target.tvTip = null;
    target.contractCheckbox = null;
    target.rlContractCheckbox = null;
    target.llRemember = null;
    target.tvLogin = null;
    target.tvAgreement = null;
    target.tvResetPassword = null;

    view7f080062.setOnClickListener(null);
    view7f080062 = null;
    view7f080144.setOnClickListener(null);
    view7f080144 = null;
    view7f080148.setOnClickListener(null);
    view7f080148 = null;
  }
}

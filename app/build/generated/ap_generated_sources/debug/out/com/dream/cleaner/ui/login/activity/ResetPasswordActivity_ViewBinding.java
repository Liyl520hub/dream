// Generated code from Butter Knife. Do not modify!
package com.dream.cleaner.ui.login.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dream.cleaner.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ResetPasswordActivity_ViewBinding implements Unbinder {
  private ResetPasswordActivity target;

  private View view7f08014a;

  @UiThread
  public ResetPasswordActivity_ViewBinding(ResetPasswordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ResetPasswordActivity_ViewBinding(final ResetPasswordActivity target, View source) {
    this.target = target;

    View view;
    target.tvMobileTitle = Utils.findRequiredViewAsType(source, R.id.tv_mobile_title, "field 'tvMobileTitle'", TextView.class);
    target.etMobile = Utils.findRequiredViewAsType(source, R.id.et_mobile, "field 'etMobile'", EditText.class);
    target.tvPasswordTitle = Utils.findRequiredViewAsType(source, R.id.tv_password_title, "field 'tvPasswordTitle'", TextView.class);
    target.etPassword = Utils.findRequiredViewAsType(source, R.id.et_password, "field 'etPassword'", EditText.class);
    target.tvTip = Utils.findRequiredViewAsType(source, R.id.tv_tip, "field 'tvTip'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'tvSubmit' and method 'onViewClicked'");
    target.tvSubmit = Utils.castView(view, R.id.tv_submit, "field 'tvSubmit'", TextView.class);
    view7f08014a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ResetPasswordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvMobileTitle = null;
    target.etMobile = null;
    target.tvPasswordTitle = null;
    target.etPassword = null;
    target.tvTip = null;
    target.tvSubmit = null;

    view7f08014a.setOnClickListener(null);
    view7f08014a = null;
  }
}

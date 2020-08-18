// Generated code from Butter Knife. Do not modify!
package com.dream.cleaner.ui.login.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dream.cleaner.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MobileVerificationActivity_ViewBinding implements Unbinder {
  private MobileVerificationActivity target;

  private View view7f0800a0;

  private View view7f08014d;

  private View view7f080154;

  @UiThread
  public MobileVerificationActivity_ViewBinding(MobileVerificationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MobileVerificationActivity_ViewBinding(final MobileVerificationActivity target,
      View source) {
    this.target = target;

    View view;
    target.etMobile = Utils.findRequiredViewAsType(source, R.id.et_mobile, "field 'etMobile'", EditText.class);
    target.etLocalCode = Utils.findRequiredViewAsType(source, R.id.et_local_code, "field 'etLocalCode'", EditText.class);
    view = Utils.findRequiredView(source, R.id.iv_local_code, "field 'ivLocalCode' and method 'onViewClicked'");
    target.ivLocalCode = Utils.castView(view, R.id.iv_local_code, "field 'ivLocalCode'", ImageView.class);
    view7f0800a0 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llVerification = Utils.findRequiredViewAsType(source, R.id.ll_verification, "field 'llVerification'", LinearLayout.class);
    target.etMobileCode = Utils.findRequiredViewAsType(source, R.id.et_mobile_code, "field 'etMobileCode'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_get_code, "field 'tvGetCode' and method 'onViewClicked'");
    target.tvGetCode = Utils.castView(view, R.id.tv_get_code, "field 'tvGetCode'", TextView.class);
    view7f08014d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llMobileCode = Utils.findRequiredViewAsType(source, R.id.ll_mobile_code, "field 'llMobileCode'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'tvSubmit' and method 'onViewClicked'");
    target.tvSubmit = Utils.castView(view, R.id.tv_submit, "field 'tvSubmit'", TextView.class);
    view7f080154 = view;
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
    MobileVerificationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etMobile = null;
    target.etLocalCode = null;
    target.ivLocalCode = null;
    target.llVerification = null;
    target.etMobileCode = null;
    target.tvGetCode = null;
    target.llMobileCode = null;
    target.tvSubmit = null;

    view7f0800a0.setOnClickListener(null);
    view7f0800a0 = null;
    view7f08014d.setOnClickListener(null);
    view7f08014d = null;
    view7f080154.setOnClickListener(null);
    view7f080154 = null;
  }
}

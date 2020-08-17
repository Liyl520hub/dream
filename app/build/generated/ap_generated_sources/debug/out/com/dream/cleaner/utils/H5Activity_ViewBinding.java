// Generated code from Butter Knife. Do not modify!
package com.dream.cleaner.utils;

import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.dream.cleaner.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class H5Activity_ViewBinding implements Unbinder {
  private H5Activity target;

  @UiThread
  public H5Activity_ViewBinding(H5Activity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public H5Activity_ViewBinding(H5Activity target, View source) {
    this.target = target;

    target.mHwebview_wb = Utils.findRequiredViewAsType(source, R.id.my_web_view, "field 'mHwebview_wb'", WebView.class);
    target.pb = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'pb'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    H5Activity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mHwebview_wb = null;
    target.pb = null;
  }
}

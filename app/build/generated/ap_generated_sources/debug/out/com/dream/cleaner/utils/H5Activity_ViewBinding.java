// Generated code from Butter Knife. Do not modify!
package com.dream.cleaner.utils;

import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
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

    target.mWebview = Utils.findRequiredViewAsType(source, R.id.my_web_view, "field 'mWebview'", WebView.class);
    target.pb = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'pb'", ProgressBar.class);
    target.tvContent = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'tvContent'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    H5Activity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mWebview = null;
    target.pb = null;
    target.tvContent = null;
  }
}

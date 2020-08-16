package com.dream.cleaner.utils;

import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.StringUtils;
import com.dream.cleaner.R;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarBackTitle;

import butterknife.BindView;


/**
 * Created by Administrator on 2016/12/29 0029.
 *
 * @Description 主要用于展示h5界面的, 并且是没有标题的
 */
public class H5Activity extends BaseActivity {

    @BindView(R.id.my_web_view)
    WebView mHwebview_wb;
    @BindView(R.id.progress_bar)
    ProgressBar pb;
    private String weburl;
    private String titleStr;
    private ToolbarBackTitle toolbarBackTitle;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_h5;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initView();
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        toolbarBackTitle = new ToolbarBackTitle(this, "");
        return toolbarBackTitle;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }


    private void initData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            weburl = bundle.getString("weburl");
            titleStr = bundle.getString("titleStr");
            if (StringUtils.isEmpty(titleStr)) {
                toolbarBackTitle.setTitle("");
            } else {
                toolbarBackTitle.setTitle(titleStr);
            }
        }

        //得到webview设置
        WebSettings webSettings = mHwebview_wb.getSettings();
        //允许使用javascript
        webSettings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webSettings.setDomStorageEnabled(true);
        //加载服务器上的页面
        mHwebview_wb.loadUrl(weburl);
        //加上下面这段代码可以使网页中的链接不以浏览器的方式打开
        mHwebview_wb.setWebViewClient(new WebViewClient() {
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
                return super.shouldInterceptRequest(webView, url);

            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                //                super.onReceivedSslError(view, handler, error);
                handler.proceed();  //接受证书
                //                view.reload();
            }
        });


        mHwebview_wb.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (pb != null) {
                    if (newProgress == 100) {
                        pb.setVisibility(View.INVISIBLE);
                    } else {
                        if (View.INVISIBLE == pb.getVisibility()) {
                            pb.setVisibility(View.VISIBLE);
                        }
                        pb.setProgress(newProgress);
                    }
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    private void initView() {
        mHwebview_wb.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && mHwebview_wb.canGoBack()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            webViewGoBack();
                        }
                    });
                    return true;
                }
                return false;
            }

        });
    }

    private void webViewGoBack() {
        mHwebview_wb.goBack();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHwebview_wb != null) {
            mHwebview_wb.destroy();
        }
    }
}
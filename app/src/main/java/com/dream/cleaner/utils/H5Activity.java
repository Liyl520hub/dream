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
import com.dream.cleaner.base.GlobalApp;
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
    WebView mWebview;
    @BindView(R.id.progress_bar)
    ProgressBar pb;
    @BindView(R.id.tv_content)
    TextView tvContent;
    private String weburl;
    private String titleStr;
    private String htmlContent;
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
            htmlContent = bundle.getString("htmlContent");
            if (StringUtils.isEmpty(titleStr)) {
                toolbarBackTitle.setTitle("");
            } else {
                toolbarBackTitle.setTitle(titleStr);
            }
        }
        if ("content".equals(weburl)) {
            mWebview.setVisibility(View.GONE);
            pb.setVisibility(View.GONE);
            tvContent.setVisibility(View.VISIBLE);
            tvContent.setText(("用户协议".equals(titleStr)) ? GlobalApp.USER_AGREEMENT : GlobalApp.RIGHTS_OF_PRIVACY);
        } if ("html".equals(weburl)) {
            mWebview.setVisibility(View.VISIBLE);
            pb.setVisibility(View.VISIBLE);
            initWebView();
//            mWebview.loadDataWithBaseURL(null, htmlContent, "text/html", "utf-8", null);
            mWebview.loadData(getHtmlData(htmlContent), "text/html; charset=UTF-8", "UTF-8");
        } else {
            tvContent.setVisibility(View.GONE);
            pb.setVisibility(View.VISIBLE);
            mWebview.setVisibility(View.VISIBLE);
            initWebView();
            //加载服务器上的页面
            mWebview.loadUrl(weburl);
        }
    }

    private void initWebView() {
        //得到webview设置
        WebSettings webSettings = mWebview.getSettings();
        //允许使用javascript
        webSettings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webSettings.setDomStorageEnabled(true);

        //加上下面这段代码可以使网页中的链接不以浏览器的方式打开
        mWebview.setWebViewClient(new WebViewClient() {
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


        mWebview.setWebChromeClient(new WebChromeClient() {
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
        mWebview.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebview.canGoBack()) {
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
        mWebview.goBack();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWebview != null) {
            mWebview.destroy();
        }
    }

    /**
     * 富文本适配
     */
    private String getHtmlData(String bodyHTML) {
        String translation = translation(bodyHTML);
        String head = "<head>"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> "
                + "<style>img{max-width: 100%; width:auto; height:auto;}</style>"
                + "<style>video{max-width: 100%; width:auto; height:auto;}</style>"
                + "</head>";
        return "<html>" + head + "<body>" + translation + "</body></html>";
    }

    /**
     *
     * @param content 转义字符替换
     * @return
     */
    private String translation(String content) {
        String replace = content.replace("&lt;", "<");
        String replace1 = replace.replace("&gt;", ">");
        String replace2 = replace1.replace("&amp;", "&");
        String replace3 = replace2.replace("&quot;", "\"");
        return replace3.replace("&copy;", "©");
    }
}

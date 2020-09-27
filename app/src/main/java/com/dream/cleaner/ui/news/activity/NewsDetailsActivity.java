package com.dream.cleaner.ui.news.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.dream.cleaner.R;
import com.dream.cleaner.beans.news.NewsDetailsBean;
import com.dream.cleaner.ui.news.contract.NewsDetailsContract;
import com.dream.cleaner.ui.news.presenter.NewsDetailsPresenter;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.ToolbarBackTitle;

import butterknife.BindView;

/**
 * Create by moying
 * Creation time:2020/8/28
 * Class action:
 */
public class NewsDetailsActivity extends BaseActivity<NewsDetailsPresenter> implements NewsDetailsContract {
    @BindView(R.id.tv_neworder)
    TextView tvNeworder;
    @BindView(R.id.tv_from)
    TextView tvFrom;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_time)
    TextView tvTime;
    private String id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_newsdetails;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "消息详情");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        if (getIntent() != null) {
            id = getIntent().getStringExtra("id");
        }
        mPresenter.newsDetails(id);
        mPresenter.newsDetailsRead(id);
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void returnNewsDetails(NewsDetailsBean newsDetailsBean) {
        tvNeworder.setText(newsDetailsBean.getTitle());
        tvFrom.setText("发件人：" + newsDetailsBean.getMessagePerson());
        tvContent.setText(newsDetailsBean.getMessageContent());
        tvTime.setText(newsDetailsBean.getUpdateTime());
    }

    @Override
    public void returnNewsDetailsRead(String string) {
//        Toast.makeText(mActivity, "" + string, Toast.LENGTH_SHORT).show();
    }
}

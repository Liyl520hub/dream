package com.dream.cleaner.ui.news.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.news.NewsListBean;
import com.dream.cleaner.ui.news.activity.NewsDetailsActivity;
import com.dream.cleaner.ui.news.adapter.NewsAllListAdapter;
import com.dream.cleaner.ui.news.contract.NewsListContract;
import com.dream.cleaner.ui.news.presenter.NewsListPresenter;
import com.dream.cleaner.widget.DataGenerator;
import com.dream.common.base.BaseFragment;
import com.dream.common.http.error.ErrorType;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :消息
 */
public class NewsListFragment extends BaseFragment<NewsListPresenter> implements NewsListContract {
    private static final String TAG = "NewsFragment";
    @BindView(R.id.news_tab_layout)
    TabLayout newsTabLayout;
    @BindView(R.id.recycler_news)
    RecyclerView recyclerNews;
    private NewsAllListAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initPresenter() {
        Log.d(TAG, "initPresenter: ");
        mPresenter.setVM(this);

    }

    @Override
    protected void initView() {

        initTabLayout();
        mPresenter.newsList(1, 0, "");

    }

    private void initTabLayout() {

        newsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setTabState(tab.getPosition());

                //全部
                if (tab.getPosition() == 0) {
                    mPresenter.newsList(1, 0, "");
                } else if (tab.getPosition() == 1) {  //工单
                    mPresenter.newsList(1, 0, "1");
                } else if (tab.getPosition() == 2) {    //公告
                    mPresenter.newsList(1, 0, "2");
                } else {  //请假
                    mPresenter.newsList(1, 0, "3");
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void setTabState(int tabPosition) {
        for (int i = 0; i < newsTabLayout.getTabCount(); i++) {
            TabLayout.Tab tabAt = newsTabLayout.getTabAt(i);
            if (tabAt != null) {
                View view = tabAt.getCustomView();
                if (view != null) {
                    ImageView icon = view.findViewById(R.id.tab_content_image);
                    TextView tabContentText = view.findViewById(R.id.tab_content_text);
                    if (i == tabPosition) {
                        // 选中状态
                        icon.setImageResource(DataGenerator.mNewsRes[i]);
                        tabContentText.setSelected(true);
                    } else {// 未选中状态
                        icon.setImageResource(DataGenerator.mNewsResPressed[i]);
                        tabContentText.setSelected(false);

                    }
                }
            }
        }
    }

    @Override
    public void returnNewsListBean(NewsListBean newsBean) {
        recyclerNews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new NewsAllListAdapter(getActivity(), R.layout.item_activity_news);
        recyclerNews.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
                NewsListBean.RecordsBean recordsBean = (NewsListBean.RecordsBean) adapter.getItem(position);
                intent.putExtra("id", recordsBean.getId());
                startActivity(intent);

            }
        });
//        adapter.setNewInstance(newsBean.getRecords());
        adapter.setList(newsBean.getRecords());
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}

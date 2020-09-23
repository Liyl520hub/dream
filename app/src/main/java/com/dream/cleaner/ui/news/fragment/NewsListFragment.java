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
import com.dream.cleaner.widget.EmptyLayout;
import com.dream.common.base.BaseFragment;
import com.dream.common.http.error.ErrorType;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    @BindView(R.id.my_smart_refresh)
    SmartRefreshLayout mySmartRefresh;
    /**
     * 全部 page
     */
    private int pageOne = 1;
    /**
     * 工单 page
     */
    private int pageTwo = 1;
    /**
     * 公告 page
     */
    private int pageThree = 1;
    /**
     * 请假 page
     */
    private int pageFour = 1;
    private int pageSize = 10;
    private int currentPosition = 0;
    /**
     * 当前page
     */
    private int currentPage = 0;
    private ArrayList<NewsAllListAdapter> newsAllListAdapters;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected void initView() {
        initAdapter();
        initTabLayout();
        mySmartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (currentPosition == 0) {
                    pageOne = 1;
                } else if (currentPosition == 1) {
                    pageTwo = 1;
                } else if (currentPosition == 2) {
                    pageFour = 1;
                } else if (currentPosition == 3) {
                    pageThree = 1;
                }
                getData();
            }
        }).setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (currentPosition == 0) {
                    pageOne++;
                } else if (currentPosition == 1) {
                    pageTwo++;
                } else if (currentPosition == 2) {
                    pageFour++;
                } else if (currentPosition == 3) {
                    pageThree++;
                }
                getData();
            }
        });
        mySmartRefresh.autoRefresh();
    }

    private void getData() {
        if (currentPosition == 0) {
            currentPage = pageOne;
        } else if (currentPosition == 1) {
            currentPage = pageTwo;
        } else if (currentPosition == 2) {
            currentPage = pageThree;
        } else if (currentPosition == 3) {
            currentPage = pageFour;
        }
        // messageType 空全部 1 工单 2 公告 3 请假
        mPresenter.newsList(currentPage, pageSize, currentPosition == 0 ? "" : currentPosition + "");
    }

    private void initAdapter() {
        recyclerNews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        newsAllListAdapters = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            NewsAllListAdapter newsAllListAdapter = new NewsAllListAdapter();
            EmptyLayout emptyLayout = new EmptyLayout(getActivity());
            emptyLayout.setErrorType(3);
            newsAllListAdapter.setEmptyView(emptyLayout);
            newsAllListAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                    Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
                    NewsListBean.RecordsBean recordsBean = (NewsListBean.RecordsBean) adapter.getItem(position);
                    intent.putExtra("id", recordsBean.getId());
                    startActivity(intent);

                }
            });
            if (i == 0) {
                recyclerNews.setAdapter(newsAllListAdapter);
            }
            newsAllListAdapters.add(newsAllListAdapter);
        }
    }

    private void initTabLayout() {

        for (int i = 0; i < 4; i++) {
            newsTabLayout.addTab(newsTabLayout.newTab().setCustomView(DataGenerator.getTabNewsView(getActivity(), i, i == 0)));
        }
        newsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setTabState(tab.getPosition());
                currentPosition = tab.getPosition();
                NewsAllListAdapter newsAllListAdapter = newsAllListAdapters.get(currentPosition);
                recyclerNews.setAdapter(newsAllListAdapter);
                List<NewsListBean.RecordsBean> data = newsAllListAdapter.getData();
                if (data.size() == 0) {
                    mySmartRefresh.autoRefresh();
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
                        icon.setImageResource(DataGenerator.mNewsResSelect[i]);
                        tabContentText.setSelected(true);
                    } else {// 未选中状态
                        icon.setImageResource(DataGenerator.mNewsNoSelect[i]);
                        tabContentText.setSelected(false);

                    }
                }
            }
        }
    }

    @Override
    public void returnNewsListBean(NewsListBean newsBean) {
        NewsAllListAdapter newsAllListAdapter = newsAllListAdapters.get(currentPosition);
        List<NewsListBean.RecordsBean> records = newsBean.getRecords();
        //过滤掉messageType不是 1 2 3 的
        Iterator<NewsListBean.RecordsBean> iterator = records.iterator();
        while (iterator.hasNext()) {
            NewsListBean.RecordsBean next = iterator.next();
            int messageType = next.getMessageType();
            if (messageType < 1 || messageType > 3) {
                iterator.remove();
            }
        }
        if (currentPage == 1) {
            newsAllListAdapter.setNewInstance(records);
            mySmartRefresh.finishRefresh();
        } else {
            newsAllListAdapter.addData(records);
            mySmartRefresh.finishLoadMore();
        }
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {
        if (currentPage == 1) {
            mySmartRefresh.finishRefresh();
        } else {
            mySmartRefresh.finishLoadMore();
        }
    }

}

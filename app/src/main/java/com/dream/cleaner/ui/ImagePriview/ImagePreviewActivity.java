package com.dream.cleaner.ui.ImagePriview;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.dream.cleaner.R;

import java.util.List;


/**
 * 图片预览 Activity
 *
 * @author Liyalei
 */
public class ImagePreviewActivity extends AppCompatActivity {

    private int itemPosition;
    private List<Uri> imageList;
    private CustomViewPager viewPager;
    private LinearLayout main_linear;
    private boolean mIsReturning;
    private int mStartPosition;
    private int mCurrentPosition;
    private String type;
    private ImagePreviewAdapter adapter;
    /**
     * 初始的Item位置
     */
    public static String START_ITEM_POSITION = "start_item_position";
    /**
     * 初始的图片位置
     */
    public static String START_IAMGE_POSITION = "start_item_image_position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getIntentData();
        initView();
        renderView();
        getData();
        setListener();
    }

    private void setListener() {
        if (main_linear.getChildCount() > 0) {
            main_linear.getChildAt(mCurrentPosition).setEnabled(true);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    hideAllIndicator(position);
                    main_linear.getChildAt(position).setEnabled(true);
                    mCurrentPosition = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    final float normalizedposition = Math.abs(Math.abs(position) - 1);
                    page.setScaleX(normalizedposition / 2 + 0.5f);
                    page.setScaleY(normalizedposition / 2 + 0.5f);
                }
            });
        }
    }

    private void hideAllIndicator(int position) {
        for (int i = 0; i < imageList.size(); i++) {
            if (i != position) {
                main_linear.getChildAt(i).setEnabled(false);
            }
        }
    }

    private void initView() {
        viewPager = findViewById(R.id.imageBrowseViewPager);
        main_linear = findViewById(R.id.main_linear);
    }

    private void renderView() {
        if (imageList == null) {
            return;
        }
        if (imageList.size() == 1) {
            main_linear.setVisibility(View.GONE);
        } else {
            main_linear.setVisibility(View.VISIBLE);
        }
        adapter = new ImagePreviewAdapter(this, imageList, itemPosition, type);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(mCurrentPosition);

    }

    private void getIntentData() {
        if (getIntent() != null) {
            mStartPosition = getIntent().getIntExtra(START_IAMGE_POSITION, 0);
            mCurrentPosition = mStartPosition;
            itemPosition = getIntent().getIntExtra(START_ITEM_POSITION, 0);
            imageList = getIntent().getParcelableArrayListExtra("imageList");
            type = getIntent().getStringExtra("type");
        }
    }

    /**
     * 获取数据
     */
    private void getData() {

        View view;
        for (int i = 0; i < imageList.size(); i++) {
            //创建底部指示器(小圆点)
            view = new View(ImagePreviewActivity.this);
            view.setBackgroundResource(R.drawable.indicator);
            view.setEnabled(false);
            //设置宽高
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20, 20);
            //设置间隔
            if (i != 0) {
                layoutParams.leftMargin = 20;
            }
            //添加到LinearLayout
            main_linear.addView(view, layoutParams);
        }
    }

}

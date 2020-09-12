package com.dream.cleaner.ui.news.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.news.NewsListBean;

import org.jetbrains.annotations.NotNull;

/**
 * Create by moying
 * Creation time:2020/8/22
 * Class action:
 */
public class NewsAllListAdapter extends BaseQuickAdapter<NewsListBean.RecordsBean, BaseViewHolder> {

    public Context mContext;
    private static final String TAG = "NewsAllListAdapter";
    public static int wokeOrderType = 1;
    public int newsType = 1;

    public NewsAllListAdapter(Context mContext, int layoutResId) {
        super(layoutResId);
        this.mContext = mContext;
    }


    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, NewsListBean.RecordsBean recordsBean) {
        ImageView imageview = baseViewHolder.getView(R.id.news_image_image);
        TextView content = baseViewHolder.getView(R.id.news_content_text);
        //messageType 1.工单  2公告  3请假
        if (recordsBean.getMessageType() == 1) {
            imageview.setImageResource(R.mipmap.news_neworder);

            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(recordsBean.getTitle() + "  " + recordsBean.getMessageContent());
            //订单类型 文字变色
            int titleLength = recordsBean.getTitle().length();
            setMspan(spannableStringBuilder, 0, titleLength);
            //订单编号 数字变色        因为有的订单编号为null，所以先注释掉，不然会报错
//                int orderNumLenght = recordsBean.getOrderNo().length();
//                int orderNumber = titleLength + 11 + orderNumLenght;
//                setMspan(spannableStringBuilder, titleLength + 10, orderNumber);
            content.setText(spannableStringBuilder);

        } else if (recordsBean.getMessageType() == 2) {
            imageview.setImageResource(R.mipmap.news_notifal);
            content.setText(recordsBean.getMessageContent());

        } else if (recordsBean.getMessageType() == 3) {
            imageview.setImageResource(R.mipmap.news_leave);
            content.setText(recordsBean.getMessageContent());
        }


    }

    /**
     * 数字内的文字变色
     *
     * @param spannable
     * @param start     开始字符位置
     * @param end       结束字符位置
     */
    private void setMspan(SpannableStringBuilder spannable, int start, int end) {
        spannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                //设置颜色
                ds.setColor(Color.parseColor("#72BB38"));
                //去掉下划线
                ds.setUnderlineText(false);
            }
        }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }


}

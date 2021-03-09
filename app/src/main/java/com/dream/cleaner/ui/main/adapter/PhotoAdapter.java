package com.dream.cleaner.ui.main.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.MyPhotoBean;
import com.dream.cleaner.ui.main.GlideEngine;
import com.dream.cleaner.utils.ImageLoaderUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author : admin
 * date   : 2020/9/15
 * desc   :
 */
public class PhotoAdapter extends BaseQuickAdapter<MyPhotoBean, BaseViewHolder> {
    public PhotoAdapter(@Nullable List<MyPhotoBean> data) {
        super(R.layout.item_photo, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, MyPhotoBean item) {
        ImageView ivClose = baseViewHolder.getView(R.id.iv_close);
        ImageView ivPhoto = baseViewHolder.getView(R.id.iv_photo);
        //1 添加 2 显示
        if ("1".equals(item.getType())) {
            ivClose.setVisibility(View.GONE);
            ivPhoto.setImageResource(R.mipmap.icon_add_photo);
        } else if ("3".equals(item.getType())) {
            ivClose.setVisibility(View.GONE);
            GlideEngine.getInstance().loadPhoto(getContext(), item.getUri(), ivPhoto);
        } else if ("4".equals(item.getType())) {
            //加载示例图
            ivClose.setVisibility(View.GONE);
            GlideEngine.getInstance().loadPhoto(getContext(), item.getMiNiUri(), ivPhoto);
        } else {
            ivClose.setVisibility(View.VISIBLE);
            GlideEngine.getInstance().loadPhoto(getContext(), item.getUri(), ivPhoto);
        }

    }


    /**
     * @return 获取显示图片数量
     */
    public int getPhotoSize() {
        int count = 0;
        List<MyPhotoBean> data = getData();
        int size = data.size();
        for (int i = 0; i < size; i++) {
            if ("2".equals(data.get(i).getType())||"4".equals(data.get(i).getType())) {
                count++;
            }
        }
        return count;
    }
}

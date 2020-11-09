package com.dream.cleaner.ui.ImagePriview;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.dream.cleaner.R;
import com.dream.cleaner.ui.ImagePriview.photoview.PhotoView;
import com.dream.cleaner.ui.main.GlideEngine;
import com.dream.cleaner.utils.ShapeUtils;

import java.io.File;
import java.util.List;

/**
 * @Description: 大图预览的vp适配器
 * @Author: Liangchaojie
 * @Create On 2018/3/30 10:33
 */
public class ImagePreviewAdapter extends PagerAdapter {
    private Context context;
    private List<Uri> imageList;
    private int itemPosition;
    private static final int MAX_SIZE = 4096;
    private RequestManager mRequestManager;
    private RequestOptions options;
    private String type;

    public ImagePreviewAdapter(Context context, List<Uri> imageList, int itemPosition, String type) {
        this.context = context;
        this.imageList = imageList;
        this.itemPosition = itemPosition;
        this.type = type;
        mRequestManager = Glide.with(context);
        options = new RequestOptions()
                //加载错误之后的错误图
                .dontAnimate();

    }

    @Override
    public int getCount() {
        return imageList == null ? 0 : imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View inflate = View.inflate(context, R.layout.adapter_image_preview, null);
        SubsamplingScaleImageView scaleImageView = inflate.findViewById(R.id.sub_image_view);
        Uri uri = imageList.get(position);
        if ("3".equals(type)) {
            mRequestManager
                    .asFile()
                    .load(uri)
                    .apply(options)
                    .thumbnail(0.1f)
                    .into(new SimpleTarget<File>() {
                        @Override
                        public void onResourceReady(@NonNull File resource, @Nullable Transition<? super File> transition) {
                            scaleImageView.setVisibility(View.VISIBLE);
                            float scale = getImageScale(context, resource.getAbsolutePath());
                            scaleImageView.setImage(ImageSource.uri(resource.getAbsolutePath()),
                                    new ImageViewState(scale, new PointF(0, 0), 0));
                        }
                    });
        } else if ("4".equals(type)) {
//            android.resource://com.dream.cleaner/mipmap/bg_da_sao_qian_1
            String path = uri.getPath();
            if (!StringUtils.isEmpty(path)) {
                String[] split = path.split("/");
                Resources resources = context.getResources();
                int identifier = resources.getIdentifier(split[split.length - 1], "mipmap", "com.dream.cleaner");
                scaleImageView.setVisibility(View.VISIBLE);
                scaleImageView.setImage(ImageSource.resource(identifier));
            }
        } else {
            scaleImageView.setVisibility(View.VISIBLE);
            scaleImageView.setImage(ImageSource.uri(uri));
        }
        scaleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (context != null) {
                        ((Activity) context).onBackPressed();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        container.addView(inflate);
        return inflate;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
//        photoView = (PhotoView) object;
//        photoView.setTag(Utils.getNameByPosition(itemPosition,position));
//        photoView.setTransitionName(Utils.getNameByPosition(itemPosition,position));
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    /**
     * 计算出图片初次显示需要放大倍数
     *
     * @param imagePath 图片的绝对路径
     */
    public static float getImageScale(Context context, String imagePath) {
        if (TextUtils.isEmpty(imagePath)) {
            return 2.0f;
        }

        Bitmap bitmap = null;

        try {
            bitmap = BitmapFactory.decodeFile(imagePath);
        } catch (OutOfMemoryError error) {
            error.printStackTrace();
        }

        if (bitmap == null) {
            return 2.0f;
        }
        return getImageScaleByBitmap(context, bitmap);
    }

    private static float getImageScaleByBitmap(Context context, Bitmap bitmap) {
        // 拿到图片的宽和高
        int dw = bitmap.getWidth();
        int dh = bitmap.getHeight();

        WindowManager wm = ((Activity) context).getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        float scale = 1.0f;
        //图片宽度大于屏幕，但高度小于屏幕，则缩小图片至填满屏幕宽
        if (dw > width && dh <= height) {
            scale = width * 1.0f / dw;
        }
        //图片宽度小于屏幕，但高度大于屏幕，则放大图片至填满屏幕宽
        if (dw <= width && dh > height) {
            scale = width * 1.0f / dw;
        }
        //图片高度和宽度都小于屏幕，则放大图片至填满屏幕宽
        if (dw < width && dh < height) {
            scale = width * 1.0f / dw;
        }
        //图片高度和宽度都大于屏幕，则缩小图片至填满屏幕宽
        if (dw > width && dh > height) {
            scale = width * 1.0f / dw;
        }
        bitmap.recycle();
        return scale;
    }
}

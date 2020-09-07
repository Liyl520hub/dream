package com.dream.cleaner.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.base.MyApplication;
import com.dream.common.base.BaseApplication;

import java.lang.ref.SoftReference;
import java.security.MessageDigest;

import static com.bumptech.glide.load.resource.bitmap.VideoDecoder.FRAME_OPTION;

/**
 * @author lyl
 * <p>
 * created 2018/9/2
 * <p>
 * class use: Glide图片加载框架用法的工具类
 */
public class ImageLoaderUtils {


    /**
     * @param mActivity    当前activity
     * @param iconUrl      加载的图片url
     * @param loadImagview 加载的view
     */
    public static void loadImage(Context mActivity, String iconUrl, ImageView loadImagview) {
        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(loadImagview);


        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(R.mipmap.video_item_empty)
                .placeholder(R.mipmap.video_item_empty)
                .dontAnimate();

        Glide.with(Utils.getApp())
                .asDrawable()
                .load(iconUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());

    }

    /**
     * @param iconUrl      加载的图片url
     * @param loadImagview 加载的view
     */
    public static void loadImage(String iconUrl, ImageView loadImagview) {
        if (StringUtils.isEmpty(iconUrl)) {
            return;
        }
        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(loadImagview);
        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(R.mipmap.video_item_empty)
                .placeholder(R.mipmap.video_item_empty)
                .dontAnimate();

        Glide.with(Utils.getApp())
                .asDrawable()
                .load(iconUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());

    }

    /**
     * @param iconUrl      加载的图片url
     * @param loadImagview 加载的view
     */
    public static void loadgif(String iconUrl, ImageView loadImagview) {
        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(loadImagview);

        Glide.with(Utils.getApp())
                .asGif()
                .load(iconUrl)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());

    }

    public static void loadImage(Context mActivity, String iconUrl, ImageView loadImagview, int errorrResource) {
        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(loadImagview);


        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(errorrResource)
                .placeholder(R.mipmap.video_item_empty)
                .dontAnimate();

        Glide.with(Utils.getApp())
                .asDrawable()
                .load(iconUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());

    }

    public static void loadAssetsImage(Context mActivity, String iconUrl, ImageView loadImagview) {
        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(loadImagview);

        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(R.mipmap.video_item_empty)
                .placeholder(R.mipmap.video_item_empty)
                .dontAnimate();

        Glide.with(Utils.getApp())
                .asDrawable()
                .load("file:///android_asset/" + iconUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());

    }

    /**
     * @param iconUrl
     * @param loadImagview
     */
    public static void loadSDImage(String iconUrl, ImageView loadImagview) {
        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(loadImagview);

        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(R.mipmap.video_item_empty)
                .placeholder(R.mipmap.video_item_empty)
                .dontAnimate();

        Glide.with(Utils.getApp())
                .asDrawable()
                .load(GlobalApp.DOWNLOAD_PATH + "tikuMediaAndroid/" + iconUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());

    }

    public static void loadAssetsImage(String iconUrl, ImageView loadImagview) {
        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(loadImagview);


        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(R.mipmap.video_item_empty)
                .placeholder(R.mipmap.video_item_empty)
                .dontAnimate();

        Glide.with(Utils.getApp())
                .asDrawable()
                .load("file:///android_asset/" + iconUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());

    }


    /**
     * @param mActivity    当前activity
     * @param iconUrl      加载的图片url
     * @param loadImagview 加载的view
     * @param errorImage   错误图
     */
    public static void loadImage(Context mActivity, String iconUrl, int errorImage, ImageView loadImagview) {

        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(loadImagview);

        RequestOptions options = new RequestOptions()
                .error(errorImage)
                .placeholder(errorImage)
                .dontAnimate();

        Glide.with(Utils.getApp())
                .asDrawable()
                .load(iconUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());


    }


    /**
     * @param mActivity    当前activity
     * @param iconUrl      加载的图片url
     * @param loadImagview 加载的view
     */
    public static void loadImgCircle(Context mActivity, String iconUrl, ImageView loadImagview) {
        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(R.mipmap.video_item_empty)
                .placeholder(R.mipmap.video_item_empty)
                //指定图片的缩放类型为centerCrop （圆形）
                .circleCrop()
                .dontAnimate();

        Glide.with(Utils.getApp())
                .load(iconUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(loadImagview);


    }

    /**
     * @param mActivity    当前activity
     * @param iconUrl      加载的图片url
     * @param loadImagview 加载的view
     */
    public static void loadImgCircle(Context mActivity, String iconUrl, int errodImage, ImageView loadImagview) {
        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(errodImage)
                .placeholder(errodImage)
                //指定图片的缩放类型为centerCrop （圆形）
                .circleCrop()
                //不显示动画
                .dontAnimate();


        Glide.with(Utils.getApp())
                .load(iconUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(loadImagview);


    }


    public static void loadImage(String advertisementUrl, int load_fail_community, ImageView itemView) {

        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(itemView);

        RequestOptions options = new RequestOptions()
                .error(load_fail_community)
                .placeholder(load_fail_community)
                .dontAnimate();

        Glide.with(Utils.getApp())
                .asDrawable()
                .load(advertisementUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());
    }

    /**
     * 社区有圆角图片
     *
     * @param advertisementUrl
     * @param itemView
     */
    public static void loadTransformImage(String advertisementUrl, ImageView itemView, int radius) {
        SoftReference<ImageView> imageViewSoftRefnce = new SoftReference<>(itemView);
        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(R.mipmap.video_item_empty)
                .placeholder(R.mipmap.video_item_empty)
                .transform(new CornerTransform(Utils.getApp(), radius))
                .dontAnimate();
        Glide.with(Utils.getApp())
                .asDrawable()
                .load(advertisementUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftRefnce.get());
    }

    /**
     * 有圆角图片 可定义错误图片 全圆角
     *
     * @param advertisementUrl
     * @param itemView
     */
    public static void loadTransformImage(String advertisementUrl, int load_fail, ImageView itemView, int radius) {
        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(itemView);
        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(load_fail)
                .placeholder(load_fail)
                .transform(new CornerTransform(Utils.getApp(), radius))
                .dontAnimate();
        Glide.with(Utils.getApp())
                .asDrawable()
                .load(advertisementUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());
    }

    /**
     * 有圆角图片 可定义错误图片 全圆角
     * 防止闪烁的方法 （glide的）
     *
     * @param advertisementUrl
     * @param itemView
     */
    public static void loadRoundedImage(String advertisementUrl, int load_fail, ImageView itemView, int radius) {
        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(itemView);
        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(load_fail)
                .placeholder(load_fail)
                .transforms(new CenterCrop(), new RoundedCorners(radius))
                .dontAnimate();
        Glide.with(Utils.getApp())
                .asDrawable()
                .load(advertisementUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());
    }

    /**
     * 有圆角图片 可定义错误图片 全圆角
     * 防止闪烁的方法 （glide的）
     *
     * @param advertisementUrl
     * @param itemView
     */
    public static void loadRoundedImage(String advertisementUrl, ImageView itemView, int radius) {
        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(itemView);
        RequestOptions options = new RequestOptions()
                //加载错误之后的错误图
                .error(R.mipmap.video_item_empty)
                .placeholder(R.mipmap.video_item_empty)
                .transforms(new CenterCrop(), new RoundedCorners(radius))
                .dontAnimate();
        Glide.with(Utils.getApp())
                .asDrawable()
                .load(advertisementUrl)
                .apply(options)
                .thumbnail(0.1f)
                .into(imageViewSoftReference.get());
    }


    /**
     * 加载视频某一帧图片
     * frameTimeMicros 单位 微秒
     */
    public static void loadVideoImage(Context mActivity, String iconUrl, int errorImage, ImageView loadImagview, long frameTimeMicros) {
        SoftReference<ImageView> imageViewSoftReference = new SoftReference<>(loadImagview);

        RequestOptions requestOptions = RequestOptions.frameOf(frameTimeMicros);
        requestOptions.error(errorImage);
        requestOptions.set(FRAME_OPTION, MediaMetadataRetriever.OPTION_CLOSEST);
        requestOptions.transform(new BitmapTransformation() {
            @Override
            protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
                return toTransform;
            }

            @Override
            public void updateDiskCacheKey(MessageDigest messageDigest) {
                try {
                    messageDigest.update((Utils.getApp().getPackageName() + "RotateTransform").getBytes("utf-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Glide.with(Utils.getApp()).load(iconUrl).apply(requestOptions).into(imageViewSoftReference.get());
    }
}

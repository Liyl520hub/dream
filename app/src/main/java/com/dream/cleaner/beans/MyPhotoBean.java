package com.dream.cleaner.beans;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : Liyalei
 * date   : 2020/9/15
 * desc   :扫钱准备适配器bean
 */
public class MyPhotoBean implements Parcelable {

    /**
     * 1 添加图片
     * 2 显示图片
     */
    private String type;
    /**
     * 图片全路径
     */
    private String path;
    /**
     * 图片Uri
     */
    public Uri uri;


    public MyPhotoBean(String type, String path) {
        this.type = type;
        this.path = path;
    }

    public MyPhotoBean(String type, Uri uri) {
        this.type = type;
        this.uri = uri;
    }

    public MyPhotoBean(String type, Uri uri, String path) {
        this.type = type;
        this.uri = uri;
        this.path = path;
    }

    public String getType() {
        return type == null ? "" : type;
    }

    public void setType(String type) {
        this.type = type == null ? "" : type;
    }

    public String getPath() {
        return path == null ? "" : path;
    }

    public void setPath(String path) {
        this.path = path == null ? "" : path;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.path);
        dest.writeParcelable(this.uri, flags);
    }

    protected MyPhotoBean(Parcel in) {
        this.type = in.readString();
        this.path = in.readString();
        this.uri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Parcelable.Creator<MyPhotoBean> CREATOR = new Parcelable.Creator<MyPhotoBean>() {
        @Override
        public MyPhotoBean createFromParcel(Parcel source) {
            return new MyPhotoBean(source);
        }

        @Override
        public MyPhotoBean[] newArray(int size) {
            return new MyPhotoBean[size];
        }
    };
}

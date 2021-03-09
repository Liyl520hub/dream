package com.dream.cleaner.utils;

import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.widget.ImageView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.dream.cleaner.base.GlobalApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author : admin
 * date   : 2020/9/8
 * desc   :
 */
public class HttpUrlConnectionUtil {


    /**
     * 记载图片验证码
     *
     * @param imgUrl
     */
    public static void setWallpaper(ImageView imageView, final String imgUrl) {
        ThreadUtils.executeByIo(new ThreadUtils.Task<Bitmap>() {
            @Override
            public Bitmap doInBackground() throws Throwable {
                Bitmap bitmap = null;
                try {
                    URL httpUrl = new URL(imgUrl);//获取传入进来的url地址  并捕获解析过程产生的异常
                    //使用是Http访问  所以用HttpURLConnection  同理如果使用的是https  则用HttpsURLConnection
                    try {
                        HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();//通过httpUrl开启一个HttpURLConnection对象
                        conn.setReadTimeout(5000);//设置显示超市时间为5秒
                        conn.setRequestMethod("GET");//设置访问方式
                        conn.setDoInput(true);//设置可以获取输入流

                        if (conn.getResponseCode() == 200) {
                            Map<String, List<String>> headerFields = conn.getHeaderFields();
                            List<String> verifyToken = headerFields.get("verifyToken");
                            if (verifyToken != null && verifyToken.size() > 0) {
                                String verifyTokenString = verifyToken.get(0);
                                SPUtils.getInstance().put(GlobalApp.VERIFY_TOKEN, verifyTokenString);
                            }

                            InputStream in = conn.getInputStream();//获取输入流
                            //创建一个写入ID卡的文件对象
                            FileOutputStream out = null;
                            File download = null;
                            String filename = String.valueOf(System.currentTimeMillis());//获取系统时间
                            //判断文件是否存在   Environment.MEDIA_MOUNTEDID卡是否挂载  如果是则创建文件对象
                            File externalCacheDir = Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                            download = new File(externalCacheDir, filename);//在父类的目录下创建一个以当前下载的系统时间为文件名的文件
                            out = new FileOutputStream(download);

                            byte[] b = new byte[2 * 1024];
                            int len;
                            if (out != null) {//id卡如果存在  则写入
                                while ((len = in.read(b)) != -1) {
                                    out.write(b, 0, len);
                                }
                            }

                            //读取该文件中的内容
                            bitmap = BitmapFactory.decodeFile(download.getAbsolutePath());
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                return bitmap;
            }

            @Override
            public void onSuccess(Bitmap result) {
                imageView.setImageBitmap(result);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onFail(Throwable t) {

            }
        });
    }


}

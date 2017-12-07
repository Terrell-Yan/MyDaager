package com.example.seanm.myapplication;

/**
 * Created by SeanM on 2017/12/6.
 */

import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.widget.ImageView;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 图片加载
 */
public class ImageLoade {
    ImageCache imageCache ;//图片缓存
    //线程池，线程数量为CPU的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime
            .getRuntime().availableProcessors());

    public void setImageCache(ImageCache cache) {
        imageCache=cache;
    }


    public void displayImage(final String url, final ImageView imageView) {
        Bitmap bitmap = imageCache.get(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        //图片没缓存，提交到线程池中下载图片
        submitLoadRequest(url,imageView);


    }
    private void submitLoadRequest(final String imgurl,final ImageView imageView){
        imageView.setTag(imgurl);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap1 = downloadImage(imgurl);
                if (bitmap1 != null) {
                    imageView.setImageBitmap(bitmap1);
                    return;
                }
                if (imageView.getTag().equals(imgurl)) {
                    imageView.setImageBitmap(bitmap1);
                }
                imageCache.put(imgurl, bitmap1);
            }
        });
    }

    public Bitmap downloadImage(String imgeurl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imgeurl);
            //利用HttpURLConnection对象从网络中获取网页数据
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = new BitmapFactory().decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (Exception o) {
            o.printStackTrace();
        }
        return bitmap;
    }
}

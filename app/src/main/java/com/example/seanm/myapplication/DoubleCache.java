package com.example.seanm.myapplication;

import android.graphics.Bitmap;

/**
 * 双缓存类
 * Created by SeanM on 2017/12/6.
 */

public class DoubleCache implements ImageCache{
    ImageCache mMemoryCache=new MemoryCache();
    DisCache mDisCache=new DisCache();
    //先从内存缓存中获取图片，如果没有，再从SD卡中获取
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap=mMemoryCache.get(url);
        if (bitmap==null){
            bitmap=mDisCache.get(url);
        }
        return bitmap;
    }

    //将图片缓存到内存和SD卡中

    @Override
    public void put(String url, Bitmap bmp) {
        mMemoryCache.put(url,bmp);
        mDisCache.put(url,bmp);
    }
}

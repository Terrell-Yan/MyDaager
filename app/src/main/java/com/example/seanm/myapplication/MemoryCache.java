package com.example.seanm.myapplication;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * 内存缓存
 * Created by SeanM on 2017/12/6.
 */

public class MemoryCache implements ImageCache {
    LruCache<String, Bitmap> mImageCache;//图片缓存
    public MemoryCache(){
        initImageCache();
    }

    @Override
    public Bitmap get(String url) {
        return mImageCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bmp) {
        mImageCache.put(url,bmp);
    }

    private void initImageCache() {
        //计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一的缓存
        final int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

}

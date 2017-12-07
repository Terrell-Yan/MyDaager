package com.example.seanm.myapplication;

import android.graphics.Bitmap;
import android.util.LruCache;

/**自定义图片缓存的接口
 * Created by SeanM on 2017/12/6.
 */

public interface ImageCache {
   public Bitmap get(String url);
   public void put(String url,Bitmap bmp);
}

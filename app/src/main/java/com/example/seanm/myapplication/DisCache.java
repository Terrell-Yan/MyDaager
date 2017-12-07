package com.example.seanm.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * SD缓存类
 * Created by SeanM on 2017/12/6.
 */

public class DisCache implements ImageCache{
    static String cacheDir="sdcard/cache";

    @Override
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir+url);
    }

    @Override
    public void put(String url, Bitmap bmp) {
        FileOutputStream fileOutputStream=null;
        try{
            fileOutputStream=new FileOutputStream(cacheDir+url);
            bmp.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);

        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if (fileOutputStream!=null){
                try{
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

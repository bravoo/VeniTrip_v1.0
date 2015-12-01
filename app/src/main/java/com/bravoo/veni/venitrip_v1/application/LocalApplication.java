package com.bravoo.veni.venitrip_v1.application;

import android.util.DisplayMetrics;

import com.bravoo.veni.venitrip_v1.exception.BaseExceptionHandler;
import com.bravoo.veni.venitrip_v1.exception.LocalFieldHandler;
import com.bravoo.veni.venitrip_v1.util.JFileKit;

import java.io.File;

/**
 * Created by msi on 2015/12/1.
 */
public class LocalApplication extends BaseApplication {
    private static LocalApplication instance;
    private int screenW=0;
    private int screenH=0;

    /**
     * 单例
     * @return
     */
    public static LocalApplication getInstance(){
        if (instance==null){
            instance=new LocalApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        File appFolder=new File(JFileKit.getDiskCacheDir(this)+"/log");
        if(!appFolder.exists()){
            appFolder.mkdirs();
        }

        instance=this;

        DisplayMetrics dm=getResources().getDisplayMetrics();
        screenW=dm.widthPixels;
        screenH=dm.heightPixels;
    }

    @Override
    public BaseExceptionHandler getDefaultUncaughtExceptionHandler(){
        return new LocalFieldHandler(applicationContext);
    }
}

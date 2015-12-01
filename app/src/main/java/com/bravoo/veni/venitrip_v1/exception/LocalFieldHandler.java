package com.bravoo.veni.venitrip_v1.exception;

import android.content.Context;
import android.os.Looper;

import com.bravoo.veni.venitrip_v1.util.JFileKit;
import com.bravoo.veni.venitrip_v1.util.UIHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;


/**
 * Created by msi on 2015/12/1.
 */
public class LocalFieldHandler extends BaseExceptionHandler {
    private Context context;

    public LocalFieldHandler(Context context){
        this.context=context;
    }

    @Override
    public boolean handleException(Throwable ex) {
        if(ex==null){
            return false;
        }
        new Thread(){
            @Override
            public void run() {
                Looper.prepare();
                UIHelper.showToast("很抱歉，程序出现异常，正在从错误中回复");
                Looper.loop();
            }
        }.start();
        saveLog(ex);
        return true;
    }

    private void saveLog(Throwable ex) {
        File errorFile=new File(JFileKit.getDiskCacheDir(context)+"log/crash.log");

        if(!errorFile.exists()){
            try {
                errorFile.createNewFile();
                OutputStream out=new FileOutputStream(errorFile,true);
                out.write(("\n\n------错误分割线" + dateFormat.format(new Date()) + "------\n\n").getBytes());
                PrintStream stream=new PrintStream(out);
                ex.printStackTrace(stream);
                stream.flush();
                out.flush();
                stream.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

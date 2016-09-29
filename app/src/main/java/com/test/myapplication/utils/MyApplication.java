package com.test.myapplication.utils;

import android.app.Application;
import android.os.Process;
import android.util.Log;

/**
 * @author yanxu
 * @date 2016/8/17.
 */
public class MyApplication extends Application{
    private static final String TAG="MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        String processname=MyUtils.getCurProcessName(getApplicationContext(), Process.myPid());
        Log.e(TAG,"processName"+processname);
    }
}

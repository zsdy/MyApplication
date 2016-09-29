package com.test.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;

import com.test.myapplication.R;

import java.net.URLClassLoader;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

/**
 * @author zhangdaoying
 * @date 2016/9/20.
 */

public class ConstraintlayoutActivity extends Activity {
    /*
    最理想的加载器，四个参数：
        1.dexPath指目标类所在的APK或jar文件的路径.类装载器将从该路径中寻找指定的目标类,
    该类必须是APK或jar的全路径.如果要包含多个路径,路径之间必须使用特定的分割符分隔,
    特定的分割符可以使用System.getProperty(“path.separtor”)获得.
        2.dexOutputDir,由于dex文件被包含在APK或者Jar文件中,因此在装载目标类之前需要先从APK或Jar文件中解压出dex文件,
    该参数就是制定解压出的dex 文件存放的路径.在Android系统中,一个应用程序一般对应一个Linux用户id,
    应用程序仅对属于自己的数据目录路径有写的权限,因此,该参数可以使用该程序的数据路径.
        3.libPath,指目标类中所使用的C/C++库存放的路径
        4.classload,是指该装载器的父装载器,一般为当前执行类的装载器
     */
    DexClassLoader mDexClassLoader;
    PathClassLoader mPathClassLoader;//只能加载已安装的APK，只会读取/data/dalvik-cahe目录下的dex文件
    URLClassLoader mURLClassLoader;//只用于加载jsr文件，但dalvik不能识别jar文件，Android中不使用这个加载器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout);
    }
}

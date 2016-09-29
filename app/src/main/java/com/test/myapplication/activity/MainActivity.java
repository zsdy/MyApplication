package com.test.myapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.test.myapplication.R;

import java.util.List;

public class MainActivity extends Activity {
    //TestCanvas1 mTestCanvas1;
    private TextView show;
    private SensorManager sm;
    private StringBuffer str;
    private List<Sensor> allSensors;
    private Sensor s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        findViewById(R.id.bt1).setOnClickListener(new ButtonListener());
        Log.e("Main","Create");
        show = (TextView) findViewById(R.id.show);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        allSensors = sm.getSensorList(Sensor.TYPE_ALL);// 获得传感器列表

    }
    class ButtonListener implements View.OnClickListener {
        public void onClick(View v) {
            str = new StringBuffer();
            str.append("该手机有" + allSensors.size() + "个传感器,分别是:\n");
            for (int i = 0; i < allSensors.size(); i++) {
                s = allSensors.get(i);
                str.append("设备名称:" + s.getName() + "\n");
                str.append("设备版本:" + s.getVersion() + "\n");
                str.append("通用类型号:" + s.getType() + "\n");
                str.append("设备商名称:" + s.getVendor() + "\n");
                str.append("传感器功耗:" + s.getPower() + "\n");
                str.append("传感器分辨率:" + s.getResolution() + "\n");
                str.append("传感器最大量程:" + s.getMaximumRange() + "\n");
                switch (s.getType()) {
                    case Sensor.TYPE_ACCELEROMETER:
                        str.append(i + "加速度传感器");
                        break;
                    case Sensor.TYPE_GYROSCOPE:
                        str.append(i + "陀螺仪传感器");
                        break;
                    case Sensor.TYPE_LIGHT:
                        str.append(i + "环境光线传感器");
                        break;
                    case Sensor.TYPE_MAGNETIC_FIELD:
                        str.append(i + "电磁场传感器");
                        break;
                    case Sensor.TYPE_ORIENTATION:
                        str.append(i + "方向传感器");
                        break;
                    case Sensor.TYPE_PRESSURE:
                        str.append(i + "压力传感器");
                        break;
                    case Sensor.TYPE_PROXIMITY:
                        str.append(i + "距离传感器");
                        break;
                    case Sensor.TYPE_TEMPERATURE:
                        str.append(i + "温度传感器");
                        break;
                    default:
                        str.append(i + "未知传感器");
                        break;
                }
            }
            show.setText(str);
        }
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("Main","onNewnIntent "+ intent.getLongExtra("time",0));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Main","Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Main","Stop");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("Main","Save");
        outState.putString("ceshi","test");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String test=savedInstanceState.getString("ceshi");
        Log.e("Main","Restore "+test);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Main","Destory");

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("Main","new Config "+newConfig.orientation);
    }
}

package com.test.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.test.myapplication.R;

/**
 * @author zhangdaoying
 * @date 2016/9/26.
 * 测试OnGestureListener
 */

public class TestViewGeActivity extends Activity implements View.OnTouchListener,GestureDetector.OnGestureListener {
    private LinearLayout ge;
    private  GestureDetector gestureDetector;
    public TestViewGeActivity(){
        gestureDetector=new GestureDetector(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_ge);
        Log.e("测试","热修复");
        ge= (LinearLayout) findViewById(R.id.ge);
        ge.setOnTouchListener(this);
        ge.setFocusable(true);
        ge.setClickable(true);
        ge.setLongClickable(true);
        gestureDetector.setIsLongpressEnabled(false);//解决长按屏幕无法拖动的问题

    }


    @Override
    public boolean onDown(MotionEvent e) {
        Log.e("TestViewGeActivity","手指轻触屏幕一瞬间，由一个ACTION_DOWN触发");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.e("TestViewGeActivity","手指轻触屏幕尚未松开或拖动，，由一个ACTION_DOWN触发。注意和OnDown()的区别，" +
                "它强调的是没有松开或拖动状态");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.e("TestViewGeActivity","手指（轻轻触屏幕后）松开，由一个MotionEvent ACTION_UP触发。这是个单击行为");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.e("TestViewGeActivity","手指按下屏幕并拖动，由一个ACTION_DOWN，多个ACTION_MOVE触发。这是拖动行为");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.e("TestViewGeActivity","用户长久按着屏幕不放，即长按");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.e("TestViewGeActivity","手指按下屏幕，快速滑动后松开，由一个ACTION_DOWN，多个ACTION_MOVE和一个ACTION_UP触发。" +
                "这是快速滑动行为");
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}

package com.test.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;

import com.test.myapplication.R;

/**
 * @author zhangdaoying
 * @date 2016/9/23.
 * 网易云音乐歌单列表，点击item,item中的图片浮现，列表消失。图片运动到左上角，背景显示图片的主题颜色
 * 1：ListView和ImageView，点击item，imageView显示在点击item所在的位置，
 * 2：ListView消失，imageView运动到左上角
 */

public class FangWngYiActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wanyi);
    }
}

package com.test.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.test.myapplication.R;
import com.test.myapplication.entity.UserManager;

/**
 * @author yanxu
 * @date 2016/8/17.
 * 测试进程1
 */
public class TestCourse1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testcourse1);
        Log.e("TestCourse","userId  "+ UserManager.getUserId());
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(TestCourse1.this,TestCourse2.class);
                startActivity(i);
            }
        });
    }
}

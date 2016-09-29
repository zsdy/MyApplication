package com.test.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.test.myapplication.R;

/**
 * @author yanxu
 * @date 2016/7/14.
 */
public class ThridActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ThridActivity.this,MainActivity.class);
                startActivity(i);

            }
        });
    }
}

package com.test.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.test.myapplication.R;
import com.test.myapplication.entity.User;
import com.test.myapplication.entity.UserManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author yanxu
 * @date 2016/8/16.
 */
public class TestActivity extends Activity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;
    private Button bt;
    private RelativeLayout mRelativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintest);
        UserManager.setUserId(2);
        Log.e("TestCourse", "userId  " + UserManager.getUserId());
        bt= (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(TestActivity.this, TestCourse1.class);
                startActivity(i);
            }
        });
        mRelativeLayout= (RelativeLayout) findViewById(R.id.real);
        mRelativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //速度追踪
                VelocityTracker velocityTracker=VelocityTracker.obtain();
                velocityTracker.addMovement(event);
                velocityTracker.computeCurrentVelocity(1000);//计算速度  1000ms内移动的距离
                int xVelocityTracker = (int) velocityTracker.getXVelocity();//水平速度
                int yVelocityTracker= (int) velocityTracker.getYVelocity();//垂直速度
                Log.e("TestCourse","xVelocityTracker "+xVelocityTracker);
                Log.e("TestCourse","yVelocityTracker "+yVelocityTracker);
                //不需要时，重置回收内存
                velocityTracker.clear();
                velocityTracker.recycle();
                return true;
            }
        });
        TestView();
        Log.e("Main", "/" + 1 / 5);
        Log.e("Main", "/" + 5 / 5);
        Log.e("Main", "/" + 6 / 5);
        Log.e("Main", "/" + 10 / 5);
        Log.e("Main", "%" + 1 % 5);
        Log.e("Main", "%" + 5 % 5);
        Log.e("Main", "%" + 6 % 5);
        Log.e("Main", "%" + 10 % 5);
        Intent intent = new Intent();
        intent.setClassName("包名", "类名");
        if (getPackageManager().resolveActivity(intent, 0) == null) {
            //说明系统中不存在这个activity
        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
//测试View
    private void TestView(){
        bt.getLeft();//控件左边到父件左边的距离
        bt.getRight();//控件右边到父件右边的距离
        bt.getBottom();//控件下边到父件顶部的距离
        bt.getTop();//控件上边到父件顶部的距离
        int width=bt.getRight()-bt.getLeft();//宽度
        int high=bt.getBottom()-bt.getTop();//高度
        Log.e("TestCourse"," "+ViewConfiguration.get(getApplicationContext()).getScaledTouchSlop());//系统设备固定的最小滑动距离
    }


    //Serializable
    private void UserSer() {
        //序列化
        User user = new User(1, "name", 1);
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("cache.txt"));
            outputStream.writeObject(user);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //反序列化
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("cache.txt"));
            try {
                User user1 = (User) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Test Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        AppIndex.AppIndexApi.start(mClient, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(mClient, getIndexApiAction());
        mClient.disconnect();
    }
}

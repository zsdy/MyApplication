package com.test.myapplication.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.test.myapplication.R;

/**
 * @author yanxu
 * @date 2016/7/15.
 */
public class TestCanvas1 extends View {
    private Paint mPaint;
    private Context mContext;
    private Bitmap mBitmap;
    private int raidu;//圆环半径
    private boolean isClick;
    public TestCanvas1(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        //mPaint.setStyle(Paint.Style.FILL);//设置画笔样式：描边
      //  mPaint.setColor(Color.argb(255,255,128,103));
       // mPaint.setStrokeWidth(10);//设置描边的粗细，尺寸px
        mBitmap= BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 判断是否点击过
                 */
                if(isClick){
                    mPaint.setColorFilter(null);
                    isClick=false;
                }else{
                    mPaint.setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0X00FFFF00));
                    isClick=true;
                }
                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
     //   canvas.drawCircle(300,300,200,mPaint);
        canvas.drawBitmap(mBitmap,200,200,mPaint);
    }


}

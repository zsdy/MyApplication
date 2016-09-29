package com.test.myapplication.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author yanxu
 * @date 2016/7/15.
 */
public class TestCanvas extends View{
    private Paint mPaint;//画笔对象
    private int mViewWidth,mViewHeight;//控件宽高
    public TestCanvas(Context context) {
        super(context);

    }

    public TestCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG| Paint.DITHER_FLAG);//初始化画笔并设置其标识值
    }

    public TestCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth=w;
        mViewHeight=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // canvas.rotate(30);//旋转画布  第一层，上面的画布也一起
        /*
        绘制一个红色矩形
         */
        mPaint.setColor(Color.RED);
        canvas.drawRect(mViewWidth/2F-200,mViewHeight/2F-200,mViewWidth/2F+200,mViewHeight/2F+200,mPaint);
        /**
         * 保存画布填充绿色
         */
        int saveID1=canvas.save(Canvas.CLIP_SAVE_FLAG);
        canvas.clipRect(mViewWidth/2F-200,mViewHeight/2F-200,mViewWidth/2F+200,mViewHeight/2F+200);
        canvas.drawColor(Color.GREEN);
        /**
         * 保存画布，绘制一个蓝色矩形
         */
        //  canvas.save();
      //  canvas.saveLayer(mViewWidth/2F-100,mViewHeight/2F-100,mViewWidth/2F+100,mViewHeight/2F+100,null,Canvas.ALL_SAVE_FLAG);
            int saveID2=canvas.save(Canvas.MATRIX_SAVE_FLAG);
      //  canvas.saveLayerAlpha(mViewWidth/2F-100,mViewHeight/2F-100,mViewWidth/2F+100,mViewHeight/2F+100,0x55,Canvas.ALL_SAVE_FLAG);
        mPaint.setColor(Color.BLUE);
        canvas.rotate(5);//旋转画布 第二层
        canvas.drawRect(mViewWidth/2F-100,mViewHeight/2F-100,mViewWidth/2F+100,mViewHeight/2F+100,mPaint);
       // canvas.restore();
        canvas.restoreToCount(saveID2);
        Log.e("Save","count:"+canvas.getSaveCount());
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(mViewWidth/2F-600,mViewHeight/2F-600,mViewWidth/2F+600,mViewHeight/2F+600,mPaint);
    }
}

package com.test.myapplication.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

import com.test.myapplication.R;

/**
 * @author yanxu
 * @date 2016/7/15.
 */
public class TestCanvas_Bitmap extends View {
    private Bitmap mBitmap;
    private int mViewWidth,mViewHgiht;
    public TestCanvas_Bitmap(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth=w;
        mViewHgiht=h;
        mBitmap=Bitmap.createScaledBitmap(mBitmap,mViewWidth,mViewHgiht,true);//缩放位图与控件一致
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save(Canvas.MATRIX_SAVE_FLAG);
       // canvas.skew(0.5f,0f);
        Matrix matrix=new Matrix();
        matrix.setScale(0.8f,0.35f);
        matrix.postTranslate(100,100);
        canvas.setMatrix(matrix);

        canvas.drawBitmap(mBitmap,0,0,null);
        canvas.restore();
    }
}

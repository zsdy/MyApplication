package com.test.myapplication.activity;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.widget.ImageView;

import com.test.myapplication.R;

/**
 * @author yanxu
 * @date 2016/8/18.
 */
public class TestTint extends Activity {
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tint);
        mImageView= (ImageView) findViewById(R.id.imageView);
        final Drawable originBitmapDrawable = getResources().getDrawable(R.mipmap.anniu);
        mImageView.setImageDrawable(tintDrawable(originBitmapDrawable, ColorStateList.valueOf(Color.GREEN)));
    }

    /**
     * android Tint 改变图片的颜色，不再需要两张图片
     * @param drawable
     * @param colors
     * @return
     */
    public static Drawable tintDrawable(Drawable drawable, ColorStateList colors) {
                final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
                DrawableCompat.setTintList(wrappedDrawable, colors);
                return wrappedDrawable;
            }
}

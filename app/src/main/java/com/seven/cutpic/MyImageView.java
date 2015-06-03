package com.seven.cutpic;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by htyuan on 15-6-3.
 */
public class MyImageView extends ImageView{
    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
/*
    private void configureBounds() {
        if (mDrawable == null || !mHaveFrame) {
            return;
        }

        int dwidth = 138;
        int dheight = 340;

        int vwidth = 138;
        int vheight = 50;


        if (ScaleType.CENTER_CROP == mScaleType) {
            mDrawMatrix = mMatrix;

            float scale;
            float dx = 0, dy = 0;

            if (dwidth * vheight > vwidth * dheight) {
                // dwidth / dheight > vwidth / vheight, 图片进行同比缩放，除相等外肯定会有一个先到达
                // <==> ((vwidth * a) + detaW) / (vheight * a) > vwidth / vheight
                // 从上面的不等式可以看出，当a 满足 vheight * a = vheight 的时候  (vwidth * a) + detaW > vwidth
                // 也就是说 当dheight 缩放到dheight的时候，dwidth 还多一个detaW.用最快到达的的参数作为缩放系数。
                scale = (float) vheight / (float) dheight;
                dx = (vwidth - dwidth * scale) * 0.5f;
            } else {
                scale = (float) vwidth / (float) dwidth;
                dy = (vheight - dheight * scale) * 0.5f;
            }

            mDrawMatrix.setScale(scale, scale);
            mDrawMatrix.postTranslate((int) (dx + 0.5f), (int) (dy + 0.5f));
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mDrawable == null) {
            return; // couldn't resolve the URI
        }

        if (mDrawableWidth == 0 || mDrawableHeight == 0) {
            return;     // nothing to draw (empty bounds)
        }

        if (mDrawMatrix == null && mPaddingTop == 0 && mPaddingLeft == 0) {
            mDrawable.draw(canvas);
        } else {
            int saveCount = canvas.getSaveCount();
            canvas.save();

            if (mDrawMatrix != null) {
                canvas.concat(mDrawMatrix);
            }
            mDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    */
}

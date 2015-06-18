package com.images.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

/**
 * Created by htyuan on 15-6-18.
 */
public class ImageUtil {
    /**
     * 按密等比压缩图片,进行图片压缩，但首要的是用来防止oom
     *
     * @param res
     * @param resId
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    private static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    /**
     * 等比压缩
     * @param bitmap
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap scaleBitmapWithAspectRadio(Bitmap bitmap, int reqWidth, int reqHeight) {
        int dwidth = bitmap.getWidth();
        int dheight = bitmap.getHeight();
        int vwidth = reqWidth;
        int vheight = reqHeight;
        float scale = 1;
        float dx = 0;
        float dy = 0;

        if (dwidth * vheight > vwidth * dheight) {
            // dwidth / dheight > vwidth / vheight, 图片进行同比缩放，除相等外肯定会有一个先到达
            // <==> (dwidth * a) / (dheight * a) > vwidth / vheight
            // 从上面的不等式可以看出，当a 满足 dheight * a == vheight 的时候  dwidth * a > vwidth
            // 也就是说 当dheight 缩放到vheight的时候，dwidth还没有缩放到vwidth.用最快到达的的参数作为缩放系数。
            scale = (float) vheight / (float) dheight;
            dx = Math.abs((vwidth - dwidth * scale) * 0.5f);
        } else {
            scale = (float) vwidth / (float) dwidth;
            dy = Math.abs((vheight - dheight * scale) * 0.5f);
        }

        int width = (int) (dwidth - dx);
        int height = (int) (dheight - dy);
        Matrix m = new Matrix();
        m.setScale(scale, scale);
        return Bitmap.createBitmap(bitmap, (int)dx, (int)dy, width, height, m, true);
    }
}

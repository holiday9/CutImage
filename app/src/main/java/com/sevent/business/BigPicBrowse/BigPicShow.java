package com.sevent.business.BigPicBrowse;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.seven.cutpic.R;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by htyuan on 15-6-5.
 */
public class BigPicShow implements PhotoViewAttacher.OnPhotoTapListener{
    private final Activity mActivity;
    PhotoViewAttacher mAttacher;
    private CustomDialog mImageDialog;

    public BigPicShow(Activity activity) {
        this.mActivity = activity;
    }

    public void setData() {
    }

    public void show(int index) {
        mImageDialog = new CustomDialog(mActivity,R.style.customDialog ,R.layout.dialog_show_big_pic);

        View view = mActivity.getLayoutInflater().inflate(R.layout.dialog_show_big_pic, null);
        mImageDialog.setContentView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        mAttacher = new PhotoViewAttacher(imageView);
        mAttacher.setOnPhotoTapListener(this);


        mImageDialog.show();
    }

    @Override
    public void onPhotoTap(View view, float v, float v1) {
        mImageDialog.dismiss();
        mAttacher.cleanup();
    }
}

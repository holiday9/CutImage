package com.sevent.business.BigPicBrowse;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.seven.cutpic.R;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by htyuan on 15-6-5.
 */
public class BigPicShow {
    private final Activity mActivity;
    PhotoViewAttacher mAttacher;

    public BigPicShow(BigPicBrowseActivity bigPicBrowseActivity) {
        this.mActivity = bigPicBrowseActivity;
    }

    public void setData() {
    }

    public void show(int index) {
        CustomDialog dialog = new CustomDialog(mActivity,R.style.customDialog ,R.layout.show_big_pic);

        View view = mActivity.getLayoutInflater().inflate(R.layout.show_big_pic, null);
        dialog.setContentView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        mAttacher = new PhotoViewAttacher(imageView);


        dialog.show();
    }
}

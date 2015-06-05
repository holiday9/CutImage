package com.sevent.business.BigPicBrowse;

import android.app.Activity;

import com.seven.cutpic.R;

/**
 * Created by htyuan on 15-6-5.
 */
public class BigPicShow {
    private final Activity mActivity;

    public BigPicShow(BigPicBrowseActivity bigPicBrowseActivity) {
        this.mActivity = bigPicBrowseActivity;
    }

    public void setData() {
    }

    public void show(int index) {
        CustomDialog dialog = new CustomDialog(mActivity,R.style.customDialog ,R.layout.show_big_pic);
        dialog.show();
    }
}

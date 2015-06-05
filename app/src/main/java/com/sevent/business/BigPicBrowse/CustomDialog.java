package com.sevent.business.BigPicBrowse;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by htyuan on 15-6-5.
 */
public class CustomDialog extends Dialog {
    private int mCustomViewId;

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int customViewId) {
        super(context);

        this.mCustomViewId = customViewId;
    }

    public CustomDialog(Context context, int theme,int customViewId){
        super(context, theme);
        this.mCustomViewId = customViewId;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (mCustomViewId > 0) {
//            this.setContentView(mCustomViewId);
//        }
//    }
}

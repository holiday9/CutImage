package com.sevent.business.BigPicBrowse;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by htyuan on 15-6-5.
 */
public class CustomDialog extends Dialog {
    private int mCustomViewId;
    private LayoutInflater mLayoutInflater;
    private View mRootView;

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int customViewId) {
        super(context);

        init(customViewId);
    }

    public CustomDialog(Context context, int theme, int customViewId){
        super(context, theme);

        init(customViewId);
    }

    private void init(int customViewId) {
        this.mCustomViewId = customViewId;

        this.mLayoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getContentView() {
        return mRootView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mCustomViewId > 0) {
            mRootView = mLayoutInflater.inflate(mCustomViewId, null);
            this.setContentView(mRootView);
        }
    }
}

package com.sevent.business.BigPicBrowse;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.seven.cutpic.R;

/**
 * Created by htyuan on 15-6-5.
 */
public class BigPicBrowseActivity extends Activity implements View.OnClickListener{
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_browse_bigpic);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.show_big_pic) {
            BigPicShow bigPicShow = new BigPicShow(this);
            bigPicShow.show(0);
        }

    }
}

package com.seven.cutpic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sevent.business.BigPicBrowse.BigPicBrowseActivity;
import com.sevent.oom.OOMActivity;


public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.big_pic_browse_activity) {
           gotoGigPicBrowseActivity();
        } else if (v.getId() == R.id.oom) {
            gotoOOMActivity();
        }

    }

    private void gotoGigPicBrowseActivity() {
        Intent intent = new Intent(this, BigPicBrowseActivity.class);
        startActivity(intent);
    }

    private void gotoOOMActivity() {
        Intent intent = new Intent(MainActivity.this, OOMActivity.class);
        startActivity(intent);
    }
}


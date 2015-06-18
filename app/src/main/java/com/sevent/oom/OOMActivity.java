package com.sevent.oom;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.seven.cutpic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by htyuan on 15-6-18.
 */
public class OOMActivity extends Activity implements View.OnClickListener{
    private TextView mMemInfoView;
    private EditText mAllocateAmountView;
    private ImageView mImageView;
    private List<byte[]> mAllocateMEM = new ArrayList<>();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_oom);

        initView();
    }

    private void initView() {
        mMemInfoView = (TextView) findViewById(R.id.mem_info_view);
        mAllocateAmountView = (EditText) findViewById(R.id.amount);
        mImageView = (ImageView) findViewById(R.id.image);
    }

    @Override
    public void onClick(View v) {
         if (v.getId() == R.id.show_mem_info) {
             updateMemeInfo();
         } else if (v.getId() == R.id.allocate){
             allocateMem();
         } else if (v.getId() == R.id.gc) {
             gc();
         }
    }

    private void gc() {
        mAllocateMEM.clear();
        System.gc();
    }

    private void allocateMem() {
        int amount = Integer.parseInt(mAllocateAmountView.getText().toString());
        mAllocateMEM.add(new byte[amount * 1024 * 1024]);
    }

    private void updateMemeInfo() {
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        StringBuffer sb = new StringBuffer();
        // 单个应用所能使用的内存的最大值
        sb.append("base line mem : " + activityManager.getMemoryClass());
        sb.append("\n");
        // 整个系统所能使用的最大内存
        sb.append("from activity manager : " + "totalMem:" + mi.totalMem + "," + "availMen:" + mi.availMem + ", is low : " + mi.lowMemory);
        sb.append("\n");

        // 当前app申请的内存
        Runtime runTimeinfo = Runtime.getRuntime();
        sb.append("from runtime : " + "totalMem:" + runTimeinfo.totalMemory() + "," + "availMen:" + runTimeinfo.freeMemory());

        mMemInfoView.setText(sb.toString());
    }
}

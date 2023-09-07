package com.insightsurfface.demodemo.business.thread;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import androidx.annotation.Nullable;

public class ThreadSecurityActivity extends BaseActivity implements View.OnClickListener {
    private static int i0 = 0;
    private static volatile int i1 = 0;
    private int i2 = 0;
    private volatile int i3 = 0;
    private volatile AtomicInteger i4=new AtomicInteger(0);
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private TextView resultTv;
    private Button okBtn;

    private void executeRunable() {
        try {
            mExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    i0++;
                    i1++;
                    addI2();
                    addI3();
                    i4.getAndIncrement();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            refreshUI();
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        refreshUI();
    }

    private void refreshUI() {
        StringBuilder sb = new StringBuilder();
        sb.append("normal: ").append(i0).append("\nvolatile: ")
                .append(i1).append("\nsynchronized: ").append(i2)
                .append("\nvolatile&synchronized: ").append(i3)
                .append("\nvolatile+atomic int: ").append(i4);
        resultTv.setText(sb);
    }

    private synchronized void addI3() {
        i3++;
    }

    private synchronized void addI2() {
        i2++;
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-06-01 13:03:58 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == okBtn) {
            // Handle clicks for okBtn
            for (int i = 0; i < 1000; i++) {
                executeRunable();
            }
        }
    }

    @Override
    protected void initUI() {
        resultTv = (TextView) findViewById(R.id.result_tv);
        okBtn = (Button) findViewById(R.id.ok_btn);

        okBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_thread_security;
    }
}

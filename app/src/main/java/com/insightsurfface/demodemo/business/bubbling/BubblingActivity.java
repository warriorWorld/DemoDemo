package com.insightsurfface.demodemo.business.bubbling;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

public class BubblingActivity extends BaseActivity implements View.OnClickListener {
    private TextView bubblingTv;
    private TextView initTv;
    private Button bubblingBtn;
    private int[] list = new int[]{8, 7, 9, 5, 3, 10, 4};

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-01-26 12:03:25 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == bubblingBtn) {
            // Handle clicks for bubblingBtn
            bubbleSort(list);
        }
    }

    private void bubbleSort(final int[] arr) {
        bubblingTv.setText(intArr2String(arr));
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < arr.length; i++) {
                    for (int j = 0; j < arr.length - i; j++) {
                        if (arr[j] > arr[j + 1]) {
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                            try {
                                Thread.sleep(3000);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        bubblingTv.setText(intArr2String(arr));
                                    }
                                });
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }

    private String intArr2String(int[] arrs) {
        StringBuilder sb = new StringBuilder();
        for (int i : arrs) {
            sb.append(i + "  ");
        }
        return sb.toString();
    }

    @Override
    protected void initUI() {
        bubblingTv = (TextView) findViewById(R.id.bubbling_tv);
        bubblingBtn = (Button) findViewById(R.id.bubbling_btn);
        initTv = findViewById(R.id.init_tv);
        initTv.setText(intArr2String(list));
        bubblingBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bubbling;
    }
}

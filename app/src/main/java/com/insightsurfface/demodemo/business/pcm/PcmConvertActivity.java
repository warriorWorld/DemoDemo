package com.insightsurfface.demodemo.business.pcm;

import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;
import com.insightsurfface.demodemo.utils.FileRecorder;

import java.io.File;

/**
 * Created by acorn on 2021/2/3.
 */
public class PcmConvertActivity extends BaseActivity implements View.OnClickListener {
    private Button convertBtn, chooseBtn;
    private String pcmPath = Environment.getExternalStorageDirectory().getPath() + File.separator +
            "pcm" + File.separator + "test0.pcm";
    private String wavPath = Environment.getExternalStorageDirectory().getPath() + File.separator +
            "pcm" + File.separator + "test0.wav";

    @Override
    protected void initUI() {
        convertBtn = findViewById(R.id.convert_pcm_btn);
        chooseBtn = findViewById(R.id.choose_pcm_btn);
        convertBtn.setOnClickListener(this);
        chooseBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pcm;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.convert_pcm_btn:
                FileRecorder.savePcmToWav(new File(pcmPath), new File(wavPath));
                baseToast.showToast("转换完成");
                break;
        }
    }
}

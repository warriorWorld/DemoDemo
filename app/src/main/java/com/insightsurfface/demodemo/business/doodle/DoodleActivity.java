package com.insightsurfface.demodemo.business.doodle;

import android.os.Bundle;
import android.os.Environment;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import java.io.File;
import java.util.HashMap;

import androidx.annotation.Nullable;

public class DoodleActivity extends BaseActivity implements OnLayerClickListener, OnDrawLayersListener {
    private DoodleViewDisposer mDoodleViewDisposer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDoodleView();
    }

    private void setupDoodleView() {
        HashMap<String, String> layersMap = new HashMap<>();
        layersMap.put("test", Environment
                .getExternalStorageDirectory().getAbsolutePath() + File.separator + "aSpider" +
                File.separator + "test.jpg");
        layersMap.put("test1", Environment
                .getExternalStorageDirectory().getAbsolutePath() + File.separator + "aSpider" +
                File.separator + "test1.jpg");
        layersMap.put("test2", Environment
                .getExternalStorageDirectory().getAbsolutePath() + File.separator + "aSpider" +
                File.separator + "test2.jpg");
        mDoodleViewDisposer.initDoodleViewLayers(layersMap);
        mDoodleViewDisposer.setOnLayerClickListener(this);
        mDoodleViewDisposer.setOnDrawLayersListener(this);
    }

    @Override
    protected void initUI() {
        mDoodleViewDisposer = new DoodleViewDisposer();
        mDoodleViewDisposer.initLayout(findViewById(R.id.doodle_layout));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_doodle;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDoodleViewDisposer != null) {
            mDoodleViewDisposer.viewIsAlive(false);
            mDoodleViewDisposer.release();
        }
    }

    @Override
    public void onDrawCompleted() {

    }

    @Override
    public void onLayerClick(String layerResUri) {

    }
}

package com.insightsurfface.demodemo.business.factory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import androidx.annotation.Nullable;

public class FactoryActivity extends BaseActivity implements View.OnClickListener {
    private Button circleBtn;
    private Button squareBtn;
    private ShapeFactory mShapeFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShapeFactory = new ShapeFactory();
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-02-07 19:14:58 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == circleBtn) {
            // Handle clicks for circleBtn
            Shape circle = mShapeFactory.getShape(FactoryActivity.this, ShapeFactory.ShapeType.CIRCLE);
            circle.draw();
        } else if (v == squareBtn) {
            // Handle clicks for squareBtn
            Shape square = mShapeFactory.getShape(FactoryActivity.this, ShapeFactory.ShapeType.SQUARE);
            square.draw();
        }
    }

    @Override
    protected void initUI() {
        circleBtn = (Button) findViewById(R.id.circle_btn);
        squareBtn = (Button) findViewById(R.id.square_btn);

        circleBtn.setOnClickListener(this);
        squareBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_factory;
    }
}

package com.insightsurfface.demodemo.business.factory;

import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

public class FactoryActivity extends BaseActivity implements View.OnClickListener {
    private Button circleBtn;
    private Button squareBtn;

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
            Shape circle = ShapeFactory.getShape(FactoryActivity.this, ShapeFactory.ShapeType.CIRCLE);
            circle.draw();
        } else if (v == squareBtn) {
            // Handle clicks for squareBtn
            Shape square = ShapeFactory.getShape(FactoryActivity.this, ShapeFactory.ShapeType.SQUARE);
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

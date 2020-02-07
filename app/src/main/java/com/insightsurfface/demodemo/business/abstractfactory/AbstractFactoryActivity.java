package com.insightsurfface.demodemo.business.abstractfactory;

import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;
import com.insightsurfface.demodemo.business.factory.ShapeFactory;

public class AbstractFactoryActivity extends BaseActivity implements View.OnClickListener {
    private Button circleBtn;
    private Button squareBtn;
    private Button redBtn;
    private Button greenBtn;

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-02-07 19:40:56 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == circleBtn) {
            // Handle clicks for circleBtn
            FactoryProducer.getFactory(FactoryProducer.FactoryType.SHAPE_FACTORY).getShape(this, ShapeFactory.ShapeType.CIRCLE).draw();
        } else if (v == squareBtn) {
            // Handle clicks for squareBtn
            FactoryProducer.getFactory(FactoryProducer.FactoryType.SHAPE_FACTORY).getShape(this, ShapeFactory.ShapeType.SQUARE).draw();
        } else if (v == redBtn) {
            // Handle clicks for redBtn
            FactoryProducer.getFactory(FactoryProducer.FactoryType.COLOR_FACTORY).getColor(this, ColorFactory.ColorType.RED).fill();
        } else if (v == greenBtn) {
            // Handle clicks for greenBtn
            FactoryProducer.getFactory(FactoryProducer.FactoryType.COLOR_FACTORY).getColor(this, ColorFactory.ColorType.GREEN).fill();
        }
    }

    @Override
    protected void initUI() {
        circleBtn = (Button) findViewById(R.id.circle_btn);
        squareBtn = (Button) findViewById(R.id.square_btn);
        redBtn = (Button) findViewById(R.id.red_btn);
        greenBtn = (Button) findViewById(R.id.green_btn);

        circleBtn.setOnClickListener(this);
        squareBtn.setOnClickListener(this);
        redBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_factory_abstract;
    }
}

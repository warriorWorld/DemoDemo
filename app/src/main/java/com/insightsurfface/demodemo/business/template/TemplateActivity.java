package com.insightsurfface.demodemo.business.template;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import androidx.annotation.Nullable;

public class TemplateActivity extends BaseActivity implements View.OnClickListener {
    private Button teaBtn;
    private Button milkyTeaBtn;
    private Button decoratorBtn;
    private MakeTeaAbstract teaMaker, milkyTeaMaker;
    private MakeTeaDecorator mMakeTeaDecorator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        teaMaker = new MakeTea(this);
        milkyTeaMaker = new MakeMilkyTea(this);
        mMakeTeaDecorator = new MakeTeaDecorator(this, milkyTeaMaker);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-02-02 16:17:21 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == teaBtn) {
            // Handle clicks for teaBtn
            teaMaker.makeTea();
        } else if (v == milkyTeaBtn) {
            // Handle clicks for milkyTeaBtn
            milkyTeaMaker.makeTea();
        } else if (v == decoratorBtn) {
            mMakeTeaDecorator.makeTea();
        }
    }

    @Override
    protected void initUI() {
        teaBtn = (Button) findViewById(R.id.tea_btn);
        milkyTeaBtn = (Button) findViewById(R.id.milky_tea_btn);
        decoratorBtn = findViewById(R.id.decorator_btn);

        decoratorBtn.setOnClickListener(this);
        teaBtn.setOnClickListener(this);
        milkyTeaBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_template;
    }
}

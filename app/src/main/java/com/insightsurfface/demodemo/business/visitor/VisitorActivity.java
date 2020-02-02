package com.insightsurfface.demodemo.business.visitor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import androidx.annotation.Nullable;

public class VisitorActivity extends BaseActivity  {
    private TextView visitorTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BusinessReport businessReport = new BusinessReport();
        businessReport.showReport(new General(visitorTv));
        businessReport.showReport(new Funs(visitorTv));
    }

    @Override
    protected void initUI() {
        visitorTv = (TextView) findViewById(R.id.visitor_tv);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_visitor;
    }
}

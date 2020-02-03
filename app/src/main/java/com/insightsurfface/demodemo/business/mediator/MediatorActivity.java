package com.insightsurfface.demodemo.business.mediator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import androidx.annotation.Nullable;

public class MediatorActivity extends BaseActivity implements View.OnClickListener {
    private Button zhangBtn;
    private Button liBtn;
    private User zhangUser, liUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        zhangUser = new User(this,"张三");
        liUser = new User(this,"李四");
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-02-03 14:44:35 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == zhangBtn) {
            // Handle clicks for zhangBtn
            zhangUser.sendMessage("Hi! Mr li!");
        } else if (v == liBtn) {
            // Handle clicks for liBtn
            zhangUser.sendMessage("Hi! Mr zhang!");
        }
    }

    @Override
    protected void initUI() {
        zhangBtn = (Button) findViewById(R.id.zhang_btn);
        liBtn = (Button) findViewById(R.id.li_btn);

        zhangBtn.setOnClickListener(this);
        liBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mediator;
    }
}

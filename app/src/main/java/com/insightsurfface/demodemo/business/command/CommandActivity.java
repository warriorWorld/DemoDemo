package com.insightsurfface.demodemo.business.command;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import androidx.annotation.Nullable;

public class CommandActivity extends BaseActivity implements View.OnClickListener {
    private Button leftBtn;
    private Button rightBtn;
    private Button rotateBtn;
    private Button getCommandBtn;
    private Button commandBtn;
    private Button pauseBtn;
    private LeftCommand mLeftCommand;
    private RightCommand mRightCommand;
    private RotateCommand mRotateCommand;
    private Commander mCommander;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TetrisMachine tetrisMachine = new TetrisMachine(this);
        mLeftCommand = new LeftCommand(tetrisMachine);
        mRightCommand = new RightCommand(tetrisMachine);
        mRotateCommand = new RotateCommand(tetrisMachine);
        mCommander = new Commander();
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-01-31 15:35:00 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == leftBtn) {
            // Handle clicks for leftBtn
            mCommander.takeCommand(mLeftCommand);
        } else if (v == rightBtn) {
            // Handle clicks for rightBtn
            mCommander.takeCommand(mRightCommand);
        } else if (v == rotateBtn) {
            // Handle clicks for rotateBtn
            mCommander.takeCommand(mRotateCommand);
        } else if (v == getCommandBtn) {
            // Handle clicks for getCommandBtn
            mCommander.getActioned();
        } else if (v == commandBtn) {
            // Handle clicks for rotateBtn
            mCommander.action();
        } else if (v == pauseBtn) {
            // Handle clicks for getCommandBtn
            mCommander.setStop(true);
        }
    }

    @Override
    protected void initUI() {
        leftBtn = (Button) findViewById(R.id.left_btn);
        rightBtn = (Button) findViewById(R.id.right_btn);
        rotateBtn = (Button) findViewById(R.id.rotate_btn);
        getCommandBtn = (Button) findViewById(R.id.get_command_btn);
        commandBtn = findViewById(R.id.command_btn);
        pauseBtn = findViewById(R.id.pause_btn);

        commandBtn.setOnClickListener(this);
        pauseBtn.setOnClickListener(this);
        leftBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
        rotateBtn.setOnClickListener(this);
        getCommandBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_command;
    }
}

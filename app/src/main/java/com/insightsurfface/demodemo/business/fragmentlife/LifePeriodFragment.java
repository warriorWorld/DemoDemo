package com.insightsurfface.demodemo.business.fragmentlife;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.utils.Logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LifePeriodFragment extends BaseFragment {
    private TextView logTv;
    private String TAG = "";
    private StringBuilder sb;

    public LifePeriodFragment(String tag) {
        this.TAG = tag;
        sb = new StringBuilder();
        setText("初始化");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        setText("onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setText("onCreate");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_life_period, null);
        initUI(mainView);
        setText("onCreateView");
        return mainView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setText("onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        setText("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        setText("onResume");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        setText("onHiddenChanged: "+hidden);
    }

    @Override
    public void onPause() {
        super.onPause();
        setText("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        setText("onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        setText("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        setText("onDetach");
    }

    private void setText(String s) {
        Logger.d(TAG + "\n" + s);
        sb.append(s + "\n");
        if (null != logTv) {
            logTv.setText(sb.toString());
        }
    }

    private void initUI(View view) {
        logTv = (TextView) view.findViewById(R.id.log_tv);
        if (!TextUtils.isEmpty(TAG)) {
            logTv.setText(TAG);
        }
    }
}

package com.insightsurfface.demodemo.business.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.adapter.MainAdapter;
import com.insightsurfface.demodemo.base.BaseActivity;
import com.insightsurfface.demodemo.business.bubbling.BubblingActivity;
import com.insightsurfface.demodemo.listener.OnRecycleItemClickListener;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity implements MainContract.View {
    private MainContract.Persenter mPresenter;
    private RecyclerView wordsRcv;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(new MainPresenter(this, this));
        mPresenter.getDemoList();
    }

    @Override
    protected void initUI() {
        wordsRcv = findViewById(R.id.main_rcv);
        wordsRcv.setLayoutManager
                (new LinearLayoutManager
                        (this, LinearLayoutManager.VERTICAL, false));
        wordsRcv.setFocusable(false);
        wordsRcv.setHasFixedSize(true);
        LayoutAnimationController controller = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.recycler_load));
        wordsRcv.setLayoutAnimation(controller);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void displayList(String[] demoList) {
        try {
            if (null == mAdapter) {
                mAdapter = new MainAdapter(this);
                mAdapter.setList(demoList);
                mAdapter.setOnRecycleItemClickListener(new OnRecycleItemClickListener() {

                    @Override
                    public void onItemClick(int position) {
                        Intent intent = null;
                        switch (position) {
                            case 0:
                                intent = new Intent(MainActivity.this, BubblingActivity.class);
                                break;
                        }
                        if (null != intent) {
                            startActivity(intent);
                        }
                    }
                });
                wordsRcv.setAdapter(mAdapter);
            } else {
                mAdapter.setList(demoList);
                mAdapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void setPresenter(MainContract.Persenter presenter) {
        this.mPresenter = presenter;
    }
}

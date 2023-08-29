package com.insightsurfface.demodemo.business.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.adapter.MainAdapter;
import com.insightsurfface.demodemo.base.BaseActivity;
import com.insightsurfface.demodemo.business.abstractfactory.AbstractFactoryActivity;
import com.insightsurfface.demodemo.business.agency.AgencyActivity;
import com.insightsurfface.demodemo.business.assembly.AssemblyActivity;
import com.insightsurfface.demodemo.business.bridge.BridgeActivity;
import com.insightsurfface.demodemo.business.bubbling.BubblingActivity;
import com.insightsurfface.demodemo.business.builder.BuilderActivity;
import com.insightsurfface.demodemo.business.command.CommandActivity;
import com.insightsurfface.demodemo.business.doodle.DoodleActivity;
import com.insightsurfface.demodemo.business.factory.FactoryActivity;
import com.insightsurfface.demodemo.business.fragmentlife.FragmentLifePeriodActivity;
import com.insightsurfface.demodemo.business.mediator.MediatorActivity;
import com.insightsurfface.demodemo.business.observer.ObserverActivity;
import com.insightsurfface.demodemo.business.responsibilitychain.ResponsibilityChainActivity;
import com.insightsurfface.demodemo.business.rxjava.RxjavaActivity;
import com.insightsurfface.demodemo.business.state.StateActivity;
import com.insightsurfface.demodemo.business.strategy.StrategyActivity;
import com.insightsurfface.demodemo.business.template.TemplateActivity;
import com.insightsurfface.demodemo.business.test.TestActivity;
import com.insightsurfface.demodemo.business.test.TestActivity1;
import com.insightsurfface.demodemo.business.thread.ThreadSecurityActivity;
import com.insightsurfface.demodemo.business.touchevent.TouchEventActivity;
import com.insightsurfface.demodemo.business.visitor.VisitorActivity;
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
                            case 1:
                                intent = new Intent(MainActivity.this, BuilderActivity.class);
                                break;
                            case 2:
                                intent = new Intent(MainActivity.this, TouchEventActivity.class);
                                break;
                            case 3:
                                intent = new Intent(MainActivity.this, StrategyActivity.class);
                                break;
                            case 4:
                                intent = new Intent(MainActivity.this, StateActivity.class);
                                break;
                            case 5:
                                intent = new Intent(MainActivity.this, ResponsibilityChainActivity.class);
                                break;
                            case 6:
                                intent = new Intent(MainActivity.this, FragmentLifePeriodActivity.class);
                                break;
                            case 7:
                                intent = new Intent(MainActivity.this, CommandActivity.class);
                                break;
                            case 8:
                                intent = new Intent(MainActivity.this, ObserverActivity.class);
                                break;
                            case 9:
                                intent = new Intent(MainActivity.this, TemplateActivity.class);
                                break;
                            case 10:
                                intent = new Intent(MainActivity.this, VisitorActivity.class);
                                break;
                            case 11:
                                intent = new Intent(MainActivity.this, MediatorActivity.class);
                                break;
                            case 12:
                                intent = new Intent(MainActivity.this, AgencyActivity.class);
                                break;
                            case 13:
                                intent = new Intent(MainActivity.this, AssemblyActivity.class);
                                break;
                            case 14:
                                intent = new Intent(MainActivity.this, BridgeActivity.class);
                                break;
                            case 15:
                                intent = new Intent(MainActivity.this, FactoryActivity.class);
                                break;
                            case 16:
                                intent = new Intent(MainActivity.this, AbstractFactoryActivity.class);
                                break;
                            case 17:
                                intent = new Intent(MainActivity.this, RxjavaActivity.class);
                                break;
                            case 18:
                                intent = new Intent(MainActivity.this, ThreadSecurityActivity.class);
                                break;
                            case 19:
                                intent = new Intent(MainActivity.this, TestActivity.class);
                                break;
                            case 20:
                                intent = new Intent(MainActivity.this, DoodleActivity.class);
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

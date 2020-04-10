package com.insightsurfface.demodemo.business.rxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;
import com.insightsurfface.demodemo.utils.Logger;

import java.util.concurrent.TimeUnit;

import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RxjavaActivity extends BaseActivity implements View.OnClickListener {
    private TextView testTv;
    private Disposable mDisposable;
    private Button payBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        Logger.setTag("rxjava");
//        test();
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-02-03 14:44:35 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pay_btn:
                test1();
                break;
        }
    }

    @Override
    protected void initUI() {
        testTv = findViewById(R.id.test_tv);
        payBtn = findViewById(R.id.pay_btn);

        payBtn.setOnClickListener(this);
    }

    private void test1() {
        final WxClient wxClient = new WxClient();
        Observable
                .create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
                        wxClient.getRawData(new WxClient.OnResponseListener() {
                            @Override
                            public void onGetData(String data) {
                                emitter.onNext(data);
                            }

                            @Override
                            public void onError() {
                                emitter.onError(new Exception("get raw data fail"));
                            }
                        });
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final String s) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<String>() {
                            @Override
                            public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
                                wxClient.getFaceCode(s, new WxClient.OnResponseListener() {
                                    @Override
                                    public void onGetData(String data) {
                                        emitter.onNext(data);
                                    }

                                    @Override
                                    public void onError() {
                                        if (wxClient.isUserCancel()) {
                                            emitter.onError(new Exception("get face code fail"));
                                        } else {
                                            emitter.onError(new Exception("to scan pay"));
                                        }
                                    }
                                });
                            }
                        });
                    }
                })
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final String s) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<String>() {
                            @Override
                            public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
                                wxClient.pay(s, new WxClient.OnResponseListener() {
                                    @Override
                                    public void onGetData(String data) {
                                        emitter.onNext(s);
                                    }

                                    @Override
                                    public void onError() {
                                        emitter.onError(new Exception("pay fail"));
                                    }
                                });
                            }
                        });
                    }
                })
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final String s) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<String>() {
                            @Override
                            public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
                                wxClient.uploadRecord(s, new WxClient.OnResponseListener() {
                                    @Override
                                    public void onGetData(String data) {
                                        emitter.onNext(data);
                                    }

                                    @Override
                                    public void onError() {

                                    }
                                });
                            }
                        });
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        baseToast.showToast("出错了: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        baseToast.showToast("支付成功");
                    }
                });
    }

    private void test() {
//        Observable
//                .create(new ObservableOnSubscribe<Integer>() {
//                    @Override
//                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                        for (int i = 10; i >= 0; i--) {
//                            emitter.onNext(i);
//                            Logger.d("emit " + i);
//                        }
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
//                .map(new Function<Integer, String>() {
//
//                    @Override
//                    public String apply(Integer integer) throws Exception {
//                        Thread.sleep(1000);
//                        Logger.d("map " + integer);
//                        return integer + "秒";
//                    }
//                })
////                .delay(1, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Logger.d("onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Logger.d("onNext: " + s);
//                        testTv.setText(s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Logger.d("onError: " + e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Logger.d("onComplete: ");
//                        testTv.setText("发射");
//                    }
//                });

        final int leftSeconds = 10;
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(Long aLong) throws Exception {
                        return leftSeconds - aLong.intValue();
                    }
                })
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        if (integer == 0) {
                            mDisposable.dispose();
                        }
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        testTv.setText(integer + "秒");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rxjava;
    }
}

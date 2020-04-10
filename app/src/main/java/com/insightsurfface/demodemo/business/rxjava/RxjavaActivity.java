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
        Logger.setTag("rxtest");
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
                                emitter.onComplete();
                                Logger.d("getRawData success");
                            }

                            @Override
                            public void onError() {
                                emitter.onError(new Exception("get raw data fail"));
                                Logger.d("get raw data fail");
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
                                        if ("facecode".equals(data)) {
                                            Logger.d("getFaceCode success");
                                            emitter.onNext(data);
                                            emitter.onComplete();
                                        } else {
                                            Logger.d("user canceled");
                                            emitter.onError(new Exception("user canceled"));
                                        }
                                    }

                                    @Override
                                    public void onError() {
                                        emitter.onError(new Exception("face code fail"));
                                        Logger.d("face code fail");
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
                                    public void onGetData(String data) throws PayException {
                                        if (data.equals("orderId")) {
                                            emitter.onNext(s);
                                            emitter.onComplete();
                                            Logger.d("pay success");
                                        } else {
                                            Logger.d("pay unknow");
                                            throw new PayException(s);
                                        }
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
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends String>>() {
                    @Override
                    public ObservableSource<? extends String> apply(final Throwable throwable) throws Exception {
                        if (!PayException.class.isInstance(throwable)) {
                            return Observable.create(new ObservableOnSubscribe<String>() {
                                @Override
                                public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                                    Logger.d("onErrorResumeNext: " + throwable);
                                    emitter.onError(throwable);
                                }
                            });
                        }
                        return Observable.create(new ObservableOnSubscribe<String>() {
                            @Override
                            public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
                                wxClient.queryPayed(throwable.getMessage(), new WxClient.OnResponseListener() {
                                    @Override
                                    public void onGetData(String data) throws PayException {
                                        if (data.equals("success")) {
                                            Logger.d("queryPayed success");
                                            emitter.onNext("success");
                                            emitter.onComplete();
                                        } else {
                                            Logger.d("queryPayed unknow");
                                            throw new PayException("unknow");
                                        }
                                    }

                                    @Override
                                    public void onError() throws PayException {
                                        throw new PayException("unknow");
                                    }
                                });
                            }
                        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(Observable<Throwable> observable) throws Exception {
                                return observable.delay(1, TimeUnit.SECONDS);
                            }
                        })
                                .timeout(10, TimeUnit.SECONDS, Observable.create(new ObservableOnSubscribe<String>() {
                                    @Override
                                    public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
                                        wxClient.cancelOrder(new WxClient.OnResponseListener() {
                                            @Override
                                            public void onGetData(String data) throws PayException {
                                                Logger.d("cancelOrder success");
                                                emitter.onNext(data);
                                                emitter.onComplete();
                                            }

                                            @Override
                                            public void onError() throws PayException {
                                                Logger.d("cancel fail");
                                                throw new PayException("cancel fail");
                                            }
                                        });
                                    }
                                })).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
                                    @Override
                                    public ObservableSource<?> apply(Observable<Throwable> observable) throws Exception {
                                        return observable.delay(1, TimeUnit.SECONDS);
                                    }
                                })
                                .timeout(10, TimeUnit.SECONDS);
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
                        Logger.d("onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("出错了: " + e.getMessage());
                        testTv.setText("出错了: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Logger.d("支付成功");
                        testTv.setText("支付成功");
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

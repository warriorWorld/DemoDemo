package com.insightsurfface.demodemo.business.strategy;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.listener.OnEditResultListener;
import com.insightsurfface.demodemo.utils.NumberUtil;
import com.insightsurfface.demodemo.utils.UltimateTextSizeUtil;
import com.insightsurfface.demodemo.widget.toast.EasyToast;


public class EarningsCalculatorDialog1 extends Dialog implements View.OnClickListener {
    protected Context context;
    protected TextView calculateResultTv;
    protected EditText investMoneyEt;
    protected EditText investPeriodEt;
    protected EditText interestRateEt;
    protected EditText raiseInterestEt;
    private Button calculateBtn;
    private Button cleanBtn;
    protected TextView invest_money_explain;
    private OnEditResultListener mOnEditResultListener;
    protected float earning;

    public void setOnEditResultListener(OnEditResultListener onEditResultListener) {
        mOnEditResultListener = onEditResultListener;
    }

    private enum CalculatorBtnState {
        CALCULATOR,
        SAVE,
        CLOSE
    }

    private CleanBtnState currentCleanBtnState = CleanBtnState.CLEAN;

    private enum CleanBtnState {
        CLEAN,
        RECALCULATOR
    }

    public EarningsCalculatorDialog1(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        init();

        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        WindowManager wm = ((Activity) context).getWindowManager();
        Display d = wm.getDefaultDisplay(); // 闁兼儳鍢茶ぐ鍥╀沪韫囨挾顔庨悗鐟邦潟閿熸垝绶氶悵顕�鎮介敓锟�
        // lp.height = (int) (d.getHeight() * 0.4); // 濡ゅ倹锚鐎瑰磭鎷嬮崜褏鏋�
//        lp.width = (int) (d.getWidth() * 1); // 閻庣妫勭�瑰磭鎷嬮崜褏鏋�
        lp.width = WindowManager.LayoutParams.FILL_PARENT;
        // window.setGravity(Gravity.LEFT | Gravity.TOP);
        window.setGravity(Gravity.BOTTOM);
        // dialog濮掓稒顭堥鑽や焊鏉堛劍绠抪adding 閻庝絻澹堥崵褎淇婇崒娑氫函濞戞挸绉风换鏍ㄧ▕閸綆鍟庣紓鍐惧枤濞堟垹鎷犻敓锟�
        // dialog婵ɑ鐡曠换娆愮▔瀹ュ牆鍘撮柛蹇嬪妼閻拷
        window.getDecorView().setPadding(0, 0, 0, 0);
        // lp.x = 100; // 闁哄倿顣︾紞鍛磾閻㈡棃宕搁幇顓犲灱
        // lp.y = 100; // 闁哄倿顣︾紞鍛磾閻㈡洟宕搁幇顓犲灱
        // lp.height = 30;
        // lp.width = 20;
        window.setAttributes(lp);

        //
        window.setBackgroundDrawableResource(android.R.color.white);
    }

    protected int getLayoutId() {
        return R.layout.dialog_earnings_calculator5;
    }

    protected void init() {
        calculateResultTv = (TextView) findViewById(R.id.calculate_result_tv);
        calculateResultTv.setText(UltimateTextSizeUtil.getEmphasizedString("0.00元", "元", 13, -1, Typeface.NORMAL));
        investMoneyEt = (EditText) findViewById(R.id.invest_money_et);
        investPeriodEt = (EditText) findViewById(R.id.invest_period_et);
        interestRateEt = (EditText) findViewById(R.id.interest_rate_et);
        interestRateEt.setHint("请输入协议约定利率");
        raiseInterestEt = (EditText) findViewById(R.id.raise_interest_et);
        calculateBtn = (Button) findViewById(R.id.calculate_btn);
        cleanBtn = (Button) findViewById(R.id.clean_btn);
        invest_money_explain = (TextView) findViewById(R.id.invest_money_explain);
        investMoneyEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                limitDot(s.toString(), investMoneyEt);
            }
        });
        interestRateEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                limitDot(s.toString(), interestRateEt);
            }
        });
        raiseInterestEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                limitDot(s.toString(), raiseInterestEt);
            }
        });
        calculateBtn.setOnClickListener(this);
        cleanBtn.setOnClickListener(this);

        final int delayTime = 100;
        investMoneyEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            investMoneyEt.setSelection(investMoneyEt.getText().toString().length());
                        }
                    }, delayTime);//n秒后执行Runnable中的run方法

                }
            }
        });
        investPeriodEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            investPeriodEt.setSelection(investPeriodEt.getText().toString().length());
                        }
                    }, delayTime);//n秒后执行Runnable中的run方法

                }
            }
        });
        interestRateEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            interestRateEt.setSelection(interestRateEt.getText().toString().length());
                        }
                    }, delayTime);//n秒后执行Runnable中的run方法

                }
            }
        });
        raiseInterestEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            raiseInterestEt.setSelection(raiseInterestEt.getText().toString().length());
                        }
                    }, delayTime);//n秒后执行Runnable中的run方法

                }
            }
        });
    }

    public void setInvestMoneyExplainText(String text) {
        invest_money_explain.setText(text);
    }

    protected void limitDot(String s, EditText et) {
        if (!et.isFocused()) {
            return;
        }
        if ("0.00".equals(s)) {
            return;
        }
        try {
            if (TextUtils.isEmpty(s)) {
                return;
            }
            //限制两位小数
            if (!s.equals(NumberUtil.cutNum(s))) {
                //为解决有小数点时 如6.这样的情况会直接被和谐掉的问题
                if (!s.substring(s
                        .length() - 1, s.length()).equals(".")) {
                    if (!s.substring(s
                            .length() - 2, s.length()).equals(".0")) {
                        String res = NumberUtil.cutNum(s);
                        et.setText(res);
                        et.setSelection(res.length());
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    private void addDot(EditText et) {
        String res = et.getText().toString().trim();
        if (TextUtils.isEmpty(res)) {
            return;
        }
        if (res.contains(".")) {
            return;
        }
        et.setText(res + ".00");
    }

    public void setData(String investNum, String investPeriod, String rate, String raiseRate) {
        investMoneyEt.setText(NumberUtil.doubleDecimals(investNum));
        if (TextUtils.isEmpty(investPeriod)) {
            investPeriodEt.setText("");
        } else {
            investPeriodEt.setText(NumberUtil.cutNum(investPeriod));
        }
        if (TextUtils.isEmpty(rate)) {
            interestRateEt.setText("");
        } else {
            interestRateEt.setText(NumberUtil.doubleDecimals(rate));
        }
        if (TextUtils.isEmpty(raiseRate) || Float.valueOf(raiseRate) == 0) {
            raiseInterestEt.setText("0.00");
        } else {
            raiseInterestEt.setText(NumberUtil.doubleDecimals(raiseRate));
        }
    }

    protected void calculateEarning() {
        float couponRate = 0f;
        if (!TextUtils.isEmpty(raiseInterestEt.getText().toString().trim())) {
            couponRate = getEtFloat(raiseInterestEt);
        }
        earning = getEtFloat(investMoneyEt) *
                getEtFloat(investPeriodEt) *
                ((getEtFloat(interestRateEt) + couponRate) / 365 / 100);
        if (TextUtils.isEmpty(raiseInterestEt.getText().toString())) {
            raiseInterestEt.setText("0.00");
        }
    }

    private void toggleCleanBtnState() {
        switch (currentCleanBtnState) {
            case CLEAN:
                cleanBtn.setText("清空");
                break;
            case RECALCULATOR:
                cleanBtn.setText("重新计算");
                break;
        }
    }

    protected float getEtFloat(EditText et) {
        try {
            String str = et.getText().toString().replaceAll(",", "").trim();
            return Float.valueOf(str);
        } catch (Exception e) {
            return 0f;
        }
    }

    protected double getEtDouble(EditText et) {
        try {
            String str = et.getText().toString().replaceAll(",", "").trim();
            return Double.valueOf(str);
        } catch (Exception e) {
            return 0d;
        }
    }

    protected void reset() {
        investMoneyEt.setText("");
        investPeriodEt.setText("");
        interestRateEt.setText("");
        raiseInterestEt.setText("");
        calculateResultTv.setText(UltimateTextSizeUtil.getEmphasizedString("0.00元", "元", 13, -1, Typeface.NORMAL));
    }

    protected boolean checkData() {
        EasyToast baseToast = new EasyToast(context);
        if (TextUtils.isEmpty(investMoneyEt.getText().toString())) {
            baseToast.showToast("请输入出借金额");
            return false;
        }
        if (TextUtils.isEmpty(investPeriodEt.getText().toString())) {
            baseToast.showToast("请输入出借期限");
            return false;
        }
        if (TextUtils.isEmpty(interestRateEt.getText().toString())) {
            baseToast.showToast("请输入协议约定利率");
            return false;
        }
        return true;
    }

    protected void calculateBtnClick() {
        if (checkData()) {
            currentCleanBtnState = CleanBtnState.RECALCULATOR;
            toggleCleanBtnState();
            calculateEarning();
            calculateResultTv.setText(UltimateTextSizeUtil.getEmphasizedString(
                    NumberUtil.toCommaNum(earning + "") + "元", "元", 13, -1, Typeface.NORMAL));
        }
    }

    protected void cleanBtnClick() {
        switch (currentCleanBtnState) {
            case CLEAN:
                reset();
                break;
            case RECALCULATOR:
                if (checkData()) {
                    calculateEarning();
                    calculateResultTv.setText(UltimateTextSizeUtil.getEmphasizedString(
                            NumberUtil.toCommaNum(earning + "") + "元", "元", 13, -1, Typeface.NORMAL));
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calculate_btn:
                calculateBtnClick();
                break;
            case R.id.clean_btn:
                cleanBtnClick();
                break;
            case R.id.invest_money_et:
            case R.id.invest_period_et:
            case R.id.interest_rate_et:
            case R.id.raise_interest_et:

                break;
        }
    }
}

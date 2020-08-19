package com.dream.cleaner.widget.pop;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dream.cleaner.R;

import razerdp.basepopup.BasePopupWindow;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :工单下拉框
 *
 * @author joy
 */
public class PopTip extends BasePopupWindow {

    private TextView tvCancel;
    private TextView tvYes;
    private TextView tvSubmit;
    private TextView tvMsg;
    private LinearLayout llDouble;

    public PopTip(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        tvCancel = findViewById(R.id.tv_cancel);
        tvYes = findViewById(R.id.tv_yes);
        tvSubmit = findViewById(R.id.tv_submit);
        tvMsg = findViewById(R.id.tv_msg);
        llDouble = findViewById(R.id.ll_double);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public TextView getTvCancel() {
        return tvCancel;
    }

    public TextView getTvYes() {
        return tvYes;
    }

    public TextView getTvSubmit() {
        return tvSubmit;
    }

    public TextView getTvMsg() {
        return tvMsg;
    }

    public LinearLayout getLlDouble() {
        return llDouble;
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.pop_tip);
    }


    public static class Builder {
        private String msg;
        private int type;
        private View.OnClickListener cancelClickListener;
        private View.OnClickListener submitClickListener;
        private View.OnClickListener yesClickListener;


        public Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder setType(int type) {
            this.type = type;
            return this;
        }

        public Builder setCancelClickListener(View.OnClickListener cancelClickListener) {
            this.cancelClickListener = cancelClickListener;
            return this;
        }

        public Builder setSubmitClickListener(View.OnClickListener submitClickListener) {
            this.submitClickListener = submitClickListener;
            return this;
        }

        public Builder setYesClickListener(View.OnClickListener yesClickListener) {
            this.yesClickListener = yesClickListener;
            return this;
        }

        public PopTip build(Context context) {
            PopTip popTip = new PopTip(context);
            popTip.getTvMsg().setText(msg);
            LinearLayout llDouble = popTip.getLlDouble();
            TextView tvSubmit = popTip.getTvSubmit();
            TextView tvCancel = popTip.getTvCancel();
            TextView tvYes = popTip.getTvYes();
            llDouble.setVisibility(type == 2 ? View.VISIBLE : View.GONE);
            tvSubmit.setVisibility(type == 1 ? View.VISIBLE : View.GONE);
            if (yesClickListener != null) {
                tvYes.setOnClickListener(yesClickListener);
            }
            if (cancelClickListener != null) {
                tvCancel.setOnClickListener(cancelClickListener);
            }
            if (submitClickListener != null) {
                tvSubmit.setOnClickListener(submitClickListener);
            }
            return popTip;
        }

    }
}

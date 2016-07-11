package com.test.zlm.leakcanarydemo;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by zhaoliming on 2016/7/11.
 */
public class MyHelper {
    private Context mCtx;
    private TextView mTextView;

    private static MyHelper ourInstance = null;

    public static MyHelper getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new MyHelper(context);
        }
        return ourInstance;
    }

    public void setRetainedTextView(TextView tv){
        this.mTextView = tv;
        mTextView.setText(mCtx.getString(android.R.string.ok));
    }

    public void removeTextView(){
        mTextView = null;
    }

    private MyHelper() {
    }

    private MyHelper(Context context) {
        this.mCtx = context;
    }
}

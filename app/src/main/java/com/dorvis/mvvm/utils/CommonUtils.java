package com.dorvis.mvvm.utils;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
    private static ProgressDialog mProgressDialog;
    private ProgressDialog progressDialog;
    private Context context;

    public static void startProgressBarDialog(Context context, String message){
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(message);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    public static void stopProgressBarDialog(){
        mProgressDialog.dismiss();
    }

    public static String todayDate(String  separator){
        try {
            String day, month, year;
            day = "dd";
            month = "MM";
            year = "yyyy";
            Date dNow = new Date();
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat ft = new SimpleDateFormat(day + separator + month + separator + year);
            return ft.format(dNow);
        } catch (Exception e) {
            throw e;
        }
    }

    public static String todayDateDiffFormat(String separator) {
        try {
            String day, month, year;
            day = "dd";
            month = "MM";
            year = "yyyy";
            Date dNow = new Date();
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat ft = new SimpleDateFormat(year + separator + month + separator + day);
            return ft.format(dNow);
        } catch (Exception e) {
            throw e;
        }
    }

    public void restrictSensativeData(EditText editText){
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    if (!Character.isLetterOrDigit(source.charAt(i))) {
                        return "";
                    }
                }
                return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

    public void showProgressDialog(String str) {
        if (this.progressDialog == null) {
            this.progressDialog = ProgressDialog.show(context, null, str, true, false, null);
            return;
        }
        this.progressDialog.setMessage(str);
        this.progressDialog.show();
    }

    public void hideProgressDialog() {
        if (this.progressDialog != null) {
            this.progressDialog.cancel();
        }
    }
}


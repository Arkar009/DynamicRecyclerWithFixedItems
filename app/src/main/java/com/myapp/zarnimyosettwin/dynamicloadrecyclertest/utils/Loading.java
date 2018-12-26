package com.myapp.zarnimyosettwin.dynamicloadrecyclertest.utils;

import android.content.Context;

import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.R;

import dmax.dialog.SpotsDialog;

/**
 * Created by ZNMSW on 01-Jun-18.
 */
public class Loading {
    static SpotsDialog progressDialog;

    public static void showLoading(Context context) {
        // Set up progress before call
        progressDialog = new SpotsDialog(context, R.style.Custom);
        progressDialog.show();
    }
    public static void showLoadingForLogin(Context context) {
        // Set up progress before call
        progressDialog = new SpotsDialog(context, R.style.Custom);
        progressDialog.show();
    }

    public static void hideLoading(Context context) {
        progressDialog.dismiss();
    }
}

package com.cacttuseducation_21_22.util;

import android.app.Activity;
import android.content.Context;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class Util {
    public static void hideKeyboard(Activity activity, EditText editText) {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}

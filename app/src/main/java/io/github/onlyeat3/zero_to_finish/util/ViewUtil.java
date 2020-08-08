package io.github.onlyeat3.zero_to_finish.util;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.lang.reflect.Field;

public class ViewUtil {
    private ViewUtil(){}

    public static void hideAllInputMethod(Activity act) {
        InputMethodManager inputMethodManager = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            inputMethodManager.toggleSoftInput(0,InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void hideOneInputMethod(Activity act, View view){
        InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

    public static int getMaxLength(EditText et){
        try {
            for (InputFilter filter : et.getFilters()) {
                Class<? extends InputFilter> clazz = filter.getClass();
                if ("android.text.InputFilter$LengthFilter".equals(clazz.getName())) {
                    Field fieldMMax = clazz.getDeclaredField("mMax");
                    if (fieldMMax != null) {
                        fieldMMax.setAccessible(true);
                        return (int)fieldMMax.get(filter);
                    }
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
}

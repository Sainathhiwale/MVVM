package com.dorvis.mvvm.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @LayoutRes
    protected  abstract int layoutRes();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        ButterKnife.bind(this);
    }

    //show keyboard
    protected void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(getCurrentFocus() , InputMethodManager.SHOW_IMPLICIT);
        }
    }
    //hide keyword
    protected void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
    protected void replaceFragment(@NonNull Fragment fragment, @IdRes int id, boolean addToStack){
        if (addToStack){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(id,fragment)
                    .addToBackStack(null)
                    .commit();
        }else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(id, fragment)
                    .commit();
        }
    }
}

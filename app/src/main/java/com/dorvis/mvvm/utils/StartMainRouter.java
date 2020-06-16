package com.dorvis.mvvm.utils;

import android.content.Context;
import android.content.Intent;

import com.dorvis.mvvm.MainActivity;

import androidx.annotation.NonNull;

public class StartMainRouter {

    public void open(@NonNull Context context, boolean clearStack){
        Intent intent = new Intent(context, MainActivity.class);
        if (clearStack) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        context.startActivity(intent);
    }

}

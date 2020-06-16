package com.dorvis.mvvm.ui.login;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dorvis.mvvm.MainActivity;
import com.dorvis.mvvm.R;
import com.dorvis.mvvm.base.BaseActivity;
import com.dorvis.mvvm.data.prefs.SharedPrefsHelper;
import com.dorvis.mvvm.data.model.User;
import com.dorvis.mvvm.utils.NetworkUtils;
import com.dorvis.mvvm.utils.Validation;
import com.dorvis.mvvm.utils.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    @BindView(R.id.llloginLayout)
    CoordinatorLayout llloginLayout;
    @BindView(R.id.tvBackArrow)
    TextView tvBackArrow;
    @BindView(R.id.tvAppTitle)
    TextView tvAppTitle;
    @BindView(R.id.etUserEmail)
    EditText etUserEmail;
    @BindView(R.id.etUserPassword)
    EditText etUserPassword;
    @BindView(R.id.btnSignIn)
    Button btnSignIn;
    @BindView(R.id.linear_layout)
    LinearLayout linearLayout;
    private SharedPrefsHelper sharedPrefsHelper;
    private LoginViewModel loginViewModel;

    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected int layoutRes() {
        return R.layout.activity_login;

    }

    @Override
    protected void onResume() {
        super.onResume();
        loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);
        sharedPrefsHelper = new SharedPrefsHelper(LoginActivity.this);
        if (sharedPrefsHelper.getLoggedInMode()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @OnClick(R.id.btnSignIn)
    public void onViewClicked(View view) {
        if (view.getId() == R.id.btnSignIn) {
            if (checkValidation()) {
                if (NetworkUtils.isNetworkAvailable(getApplicationContext())) {
                    saveUser();
                } else {
                    Snackbar snackbar = Snackbar
                            .make(llloginLayout, "No internet connection!", Snackbar.LENGTH_LONG);
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(com.google.android.material.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    snackbar.show();
                }
            } else {
                Snackbar snackbar = Snackbar.make(llloginLayout, "Please enter those field!", Snackbar.LENGTH_SHORT);
                View view1 = snackbar.getView();
                TextView textView = (TextView) view1.findViewById(com.google.android.material.R.id.snackbar_text);
                textView.setTextColor(Color.RED);
                snackbar.show();
            }
        }
    }

    private void saveUser() {
        User user = new User();
        user.setUserName(etUserEmail.getText().toString().trim());
        user.setPassword(etUserPassword.getText().toString().trim());
        loginViewModel.callLoginUser(user);
        sharedPrefsHelper.putUserEmail(user.getUserName());
        sharedPrefsHelper.setLoggedInMode(true);
        loginViewModel.getUseDto().observe(this,user1 -> {
            if (user.getUserName()!=null){
                Snackbar snackbar = Snackbar.make(llloginLayout, "Login Successfully!", Snackbar.LENGTH_SHORT);
                View view1 = snackbar.getView();
                TextView textView = (TextView) view1.findViewById(com.google.android.material.R.id.snackbar_text);
                textView.setTextColor(Color.GREEN);
                snackbar.show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }else {
                Snackbar snackbar = Snackbar.make(llloginLayout, "Something went Wrong!", Snackbar.LENGTH_SHORT);
                View view1 = snackbar.getView();
                TextView textView = (TextView) view1.findViewById(com.google.android.material.R.id.snackbar_text);
                textView.setTextColor(Color.RED);
            }
        });

    }

    private boolean checkValidation() {
        boolean valid = true;
        if (!new Validation().hasText(etUserEmail)) valid = false;
        if (!new Validation().hasText(etUserPassword)) valid = false;
        return valid;
    }





}

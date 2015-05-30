package com.mredrock.date.home.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;

/**
 * Created by Mr.Jude on 2015/5/29.
 */
public class LoginActivityVu extends BaseActivityVu {

    private EditText tvNumber;
    private EditText tvPassword;
    private Button btnLogin;
    @Override
    protected void onCreate() {
        setView(R.layout.activity_login);
        tvNumber = $(R.id.number);
        tvPassword = $(R.id.password);
        btnLogin = $(R.id.login);
    }

    public void setOnClickListener(View.OnClickListener listener){
        btnLogin.setOnClickListener(listener);
    }
}

package com.mredrock.date.home.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.util.Utils;

/**
 * Created by Mr.Jude on 2015/5/29.
 */
public class LoginActivityVu extends BaseActivityVu implements View.OnFocusChangeListener{
    public ImageView img;
    public EditText tvNumber;
    public EditText tvPassword;
    private Button btnLogin;

    @Override
    protected void onCreate() {
        setView(R.layout.activity_login);
        tvNumber = $(R.id.number);
        tvPassword = $(R.id.password);
        btnLogin = $(R.id.login);
        img = $(R.id.img);
        img.post(new Runnable() {
            @Override
            public void run() {
                initAnimation();
            }
        });
        tvNumber.setOnFocusChangeListener(this);
        tvPassword.setOnFocusChangeListener(this);
        getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.requestFocus();
            }
        });
    }

    public void setOnClickListener(View.OnClickListener listener){
        btnLogin.setOnClickListener(listener);
    }
    private boolean isShrink = false;
    private ValueAnimator animator;
    public void initAnimation(){
        animator = ValueAnimator.ofInt(img.getHeight(),0);
        animator.setDuration(300);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int height = (int) animation.getAnimatedValue();
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height);
                img.setLayoutParams(params);
            }
        });
    }
    public void startAnimator(){
        if (isShrink){
            animator.reverse();
        }else{
            animator.start();
        }
        isShrink=!isShrink;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!(tvNumber.hasFocus()||tvPassword.hasFocus())&&isShrink){
            startAnimator();
        }if ((tvNumber.hasFocus()||tvPassword.hasFocus())&&!isShrink){
            startAnimator();
        }
    }
}

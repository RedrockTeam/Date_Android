package com.mredrock.date.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mredrock.date.R;
import com.mredrock.date.util.Utils;

public class LoveView extends LinearLayout {
    private ImageView[] loveImags;
    private int number;
    private int radius;

    public LoveView(Context context) {
        super(context);
    }

    public LoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.love);
        number = a.getInt(R.styleable.love_number, 0);
        radius = (int) a.getDimension(R.styleable.love_radius, 0);
        Log.i("cao", radius + "13");
        init(context);
    }

    public LoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context) {
        setOrientation(HORIZONTAL);
        loveImags = new ImageView[number];
        for (int i = 0; i < number; i++) {
            ImageView loveImag = new ImageView(context);
            loveImag.setImageResource(R.drawable.star_null);
            loveImag.setPadding(Utils.dip2px(2), Utils.dip2px(2), Utils.dip2px(2), Utils.dip2px(2));
            loveImag.setLayoutParams(new ViewGroup.LayoutParams(radius, radius));
            loveImags[i] = loveImag;
            addView(loveImag);
        }
    }

    public void setStart(double score) {
        if (score <= number) {
            double scoreX = Math.abs(score - Math.floor(score));
            int number = 0;
            if (scoreX > 0.2 && scoreX < 0.8) {
                number = (int) (Math.ceil(score) - 1);
                loveImags[number].setImageResource(R.drawable.star_half);
            } else if (scoreX <= 0.2 && scoreX >= 0){
                number = (int) (Math.floor(score) - 1);
                if (number >= 0) {
                    loveImags[number].setImageResource(R.drawable.star_all);
                }
            } else {
                number = (int) (Math.ceil(score) - 1);
                loveImags[number].setImageResource(R.drawable.star_all);
            }
            for (int i = 0; i < number; i++) {
                loveImags[i].setImageResource(R.drawable.star_all);
            }
        } else {
            for (int i = 0; i < number; i++) {
                loveImags[i].setImageResource(R.drawable.star_all);
            }
        }
    }

}

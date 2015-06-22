package com.mredrock.date.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mredrock.date.R;
import com.mredrock.date.util.Utils;

public class LoveView extends LinearLayout {
    private ImageView[] loveImags;
    private int numbers;
    private int radius;

    private int leftPosition;
    private int rightPosition;
    private int topPosition;
    private int bottomPosition;
    private double score = 0;

    private boolean isScroll;

    public LoveView(Context context) {
        super(context);
    }

    public LoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.love);
        numbers = a.getInt(R.styleable.love_number, 0);
        radius = (int) a.getDimension(R.styleable.love_radius, 0);
        isScroll = a.getBoolean(R.styleable.love_scroll, false);
        init(context);
    }

    public LoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context) {
        setOrientation(HORIZONTAL);
        loveImags = new ImageView[numbers];
        for (int i = 0; i < numbers; i++) {
            ImageView loveImag = new ImageView(context);
            loveImag.setImageResource(R.drawable.star_null);
            loveImag.setPadding(Utils.dip2px(2), Utils.dip2px(2), Utils.dip2px(2), Utils.dip2px(2));
            loveImag.setLayoutParams(new ViewGroup.LayoutParams(radius, radius));
            loveImags[i] = loveImag;
            addView(loveImag);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        leftPosition = getPaddingLeft();
        rightPosition = getMeasuredWidth() - getPaddingRight();
        topPosition = getPaddingTop();
        bottomPosition = getMeasuredHeight() - getPaddingBottom();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isScroll) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (x > leftPosition && x < rightPosition && y > topPosition && y < bottomPosition) {
                double baseWidth = (rightPosition - leftPosition) / (double) (numbers * 2);
                double coutX = event.getX() / baseWidth - Math.floor(event.getX() / baseWidth);
                int n = (int) (event.getX() / baseWidth);
                if (coutX > 0.5) {
                    n++;
                }
                score = (double) n * 0.5;
                setStart(score);
            }
            return true;
        } else {
            return super.onTouchEvent(event);
        }
    }

    public void setStart(double score) {
        if (score <= numbers) {
            double scoreX = Math.abs(score - Math.floor(score));
            int number = 0;
            if (scoreX > 0.2 && scoreX < 0.8) {
                number = (int) (Math.ceil(score) - 1);
                loveImags[number].setImageResource(R.drawable.star_half);
            } else if (scoreX <= 0.2 && scoreX >= 0){
                number = (int) (Math.floor(score) - 1);
                if (number >= 0) {
                    loveImags[number].setImageResource(R.drawable.star_all);
                } else {
                    number = 0;
                }
            } else {
                number = (int) (Math.ceil(score) - 1);
                loveImags[number].setImageResource(R.drawable.star_all);
            }
            for (int i = 0; i < number; i++) {
                loveImags[i].setImageResource(R.drawable.star_all);
            }
            for (int j = number + 1; j < numbers; j++) {
                loveImags[j].setImageResource(R.drawable.star_null);
            }
        } else {
            for (int i = 0; i < numbers; i++) {
                loveImags[i].setImageResource(R.drawable.star_all);
            }
        }
    }

    public double getScore() {
        return score;
    }
}

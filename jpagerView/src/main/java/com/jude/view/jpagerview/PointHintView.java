package com.jude.view.jpagerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PointHintView extends LinearLayout implements HintView {
	private ImageView[] mdots;
	private int length = 0;
	private int lastPosition = 0;
	
	private GradientDrawable dot_normal;
	private GradientDrawable dot_focus;	
	
	public PointHintView(Context context){
		super(context);
	}
	
	public PointHintView(Context context, AttributeSet attrs) {
		
		super(context, attrs);
	}

	@Override
	public void initView(int length, int gravity) {
        removeAllViews();
		setOrientation(HORIZONTAL);
		switch (gravity) {
		case 0:
			setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
			break;
		case 1:
			setGravity(Gravity.CENTER);
			break;
		case 2:
			setGravity(Gravity.RIGHT|Gravity.CENTER_VERTICAL);
			break;
		}
		
		this.length = length;
		mdots = new ImageView[length];  
		
		dot_focus = new GradientDrawable();
		dot_focus.setColor(Color.parseColor("#E3AC42"));
		dot_focus.setCornerRadius(Util.dip2px(getContext(), 4));
		dot_focus.setSize(Util.dip2px(getContext(), 8), Util.dip2px(getContext(), 8));
		
		dot_normal = new GradientDrawable();
		dot_normal.setColor(Color.WHITE);
		dot_normal.setAlpha(125);
		dot_normal.setCornerRadius(Util.dip2px(getContext(), 4));
		dot_normal.setSize(Util.dip2px(getContext(), 8), Util.dip2px(getContext(), 8));
		
		
		
        for (int i = 0; i < length; i++) {  
        	mdots[i]=new ImageView(getContext());
        	LinearLayout.LayoutParams dotlp = new LinearLayout.LayoutParams(
        			LinearLayout.LayoutParams.WRAP_CONTENT, 
        			LinearLayout.LayoutParams.WRAP_CONTENT);
        	dotlp.setMargins(10, 0, 10, 0); 
        	mdots[i].setLayoutParams(dotlp);
        	mdots[i].setBackgroundDrawable(dot_normal);
        	addView(mdots[i]);  
        }

        setCurrent(0);
	}

	@Override
	public void setCurrent(int current) {
		if (current < 0 || current > length - 1) {  
            return;  
        } 
        mdots[lastPosition].setBackgroundDrawable(dot_normal);
        mdots[current].setBackgroundDrawable(dot_focus);
        lastPosition = current;  
	}
}

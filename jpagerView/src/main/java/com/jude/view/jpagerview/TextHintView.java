package com.jude.view.jpagerview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

public class TextHintView extends TextView implements HintView {
	private int lenght;
	
	public TextHintView(Context context){
		super(context);
	}
	
	public TextHintView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void initView(int lenght, int gravity) {
		this.lenght = lenght;
		setTextColor(Color.WHITE);
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

        setCurrent(0);
	}

	@Override
	public void setCurrent(int current) {
		setText(current+1+"/"+lenght);
	}
}

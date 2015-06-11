package com.mredrock.date.setting.view;

import android.widget.EditText;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;

/**
 * Created by zhuchenxi on 15/6/10.
 */
public class FeedbackActivityVu extends BaseActivityVu {
    private EditText content;
    @Override
    protected void onCreate() {
        setView(R.layout.activity_feedback2);
        content = $(R.id.content);
    }

    public String getContent(){
        return content.getText().toString();
    }
}

package com.mredrock.date.home.view;

import android.widget.EditText;
import android.widget.TextView;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;

/**
 * Created by zhuchenxi on 15/4/30.
 */
public class EditActivityVu extends BaseActivityVu{
    private EditText tvContent;
    @Override
    protected void onCreate() {
        setView(R.layout.activity_edit);
        tvContent = $(R.id.content);
    }
    public String getContent(){
        return tvContent.getText().toString();
    }
}

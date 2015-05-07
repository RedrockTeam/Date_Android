package com.mredrock.date.letter.view;

import android.view.ViewGroup;

import com.mredrock.date.R;
import com.mredrock.date.model.bean.Letter;
import com.mredrock.date.widget.BaseViewHolder;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterViewHolder extends BaseViewHolder<Letter>{
    public LetterViewHolder(ViewGroup parent) {
        super(parent, R.layout.abc_action_menu_layout);
    }

    @Override
    public void setData(Letter data) {
        super.setData(data);

    }
}

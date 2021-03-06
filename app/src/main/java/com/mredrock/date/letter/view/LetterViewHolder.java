package com.mredrock.date.letter.view;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.letter.presenter.LetterActivityPresenter;
import com.mredrock.date.letter.presenter.LetterDetailActivityPresenter;
import com.mredrock.date.model.bean.Letter;
import com.mredrock.date.widget.BaseViewHolder;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterViewHolder extends BaseViewHolder<Letter> implements View.OnClickListener{
    private SimpleDraweeView sdvAvatar;
    private TextView tvUserName;
    private TextView tvContent;

    public LetterViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_letter);
    }

    public void setData(final Letter data, final int position) {
        super.setData(data);
        initView();
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), LetterDetailActivityPresenter.class);
                intent.putExtra("letter", data);
                intent.putExtra("position", position);
                ((LetterActivityPresenter)itemView.getContext()).startActivityForResult(intent, LetterActivityPresenter.REQUEST_LETTER);
            }
        });
        sdvAvatar.setImageURI(Uri.parse(data.getUserAvatar()));
        tvUserName.setText(data.getUserName());
        tvContent.setText(data.getContent());
    }

    private void initView() {
        sdvAvatar = $(R.id.sdv_avatar);
        tvUserName = $(R.id.tv_user_name);
        tvContent = $(R.id.tv_content);
        sdvAvatar.setOnClickListener(this);
        tvUserName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sdv_avatar:
            case R.id.tv_user_name:
                break;
            case R.id.tv_content:
                break;
        }
    }
}

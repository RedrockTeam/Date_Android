package com.mredrock.date.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.home.presenter.EditActivityPresent;
import com.mredrock.date.information.view.presenter.InfoActivityPresenter;
import com.mredrock.date.model.bean.Detail;
import com.mredrock.date.util.Utils;

public class DetailViewHolder extends BaseViewHolder<Detail.Join[]> implements View.OnClickListener {
    private SimpleDraweeView reprotFace1;
    private SimpleDraweeView reprotFace2;
    private SimpleDraweeView reprotFace3;
    private SimpleDraweeView reprotFace4;
    private LinearLayout llJoined;

    private Intent intent;
    private Context context;

    public DetailViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_detail);
        context = parent.getContext();
        reprotFace1 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail1);
        reprotFace2 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail2);
        reprotFace3 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail3);
        reprotFace4 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail4);
        llJoined = (LinearLayout) itemView.findViewById(R.id.include_joined_detail);

        intent = new Intent();
        intent.setClass(context, InfoActivityPresenter.class);
    }

    @Override
    public void setData(final Detail.Join[] data) {
        super.setData(data);
        if (data.length != 0) {
            llJoined.setVisibility(View.VISIBLE);
            if (data[0] != null) {
                reprotFace1.setImageURI(Uri.parse(data[0].getHead()));
                reprotFace1.setOnClickListener(this);
            }
            if (data[1] != null) {
                reprotFace2.setImageURI(Uri.parse(data[1].getHead()));
                reprotFace2.setOnClickListener(this);
            }
            if (data[2] != null) {
                reprotFace3.setImageURI(Uri.parse(data[2].getHead()));
                reprotFace3.setOnClickListener(this);
            }
            if (data[3] != null) {
                reprotFace4.setImageURI(Uri.parse(data[3].getHead()));
                reprotFace4.setOnClickListener(this);
            }
        } else {
            llJoined.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.author_report_face_detail1:
                context.startActivity(intent);
                break;
            case R.id.author_report_face_detail2:
                context.startActivity(intent);
                break;
            case R.id.author_report_face_detail3:
                context.startActivity(intent);
                break;
            case R.id.author_report_face_detail4:
                context.startActivity(intent);
                break;

        }
    }
}

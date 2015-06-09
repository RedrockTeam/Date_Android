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
    private SimpleDraweeView joinedFace1;
    private SimpleDraweeView joinedFace2;
    private SimpleDraweeView joinedFace3;
    private SimpleDraweeView joinedFace4;
    private LinearLayout llJoined;

    private Intent intent;
    private Context context;

    public DetailViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_detail);
        context = parent.getContext();
        joinedFace1 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail1);
        joinedFace2 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail2);
        joinedFace3 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail3);
        joinedFace4 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail4);
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
                joinedFace1.setVisibility(View.VISIBLE);
                joinedFace1.setImageURI(Uri.parse(data[0].getHead()));
                joinedFace1.setOnClickListener(this);
            } else {
                joinedFace1.setVisibility(View.INVISIBLE);
            }
            if (data[1] != null) {
                joinedFace2.setVisibility(View.VISIBLE);
                joinedFace2.setImageURI(Uri.parse(data[1].getHead()));
                joinedFace2.setOnClickListener(this);
            }else {
                joinedFace2.setVisibility(View.INVISIBLE);
            }
            if (data[2] != null) {
                joinedFace3.setVisibility(View.VISIBLE);
                joinedFace3.setImageURI(Uri.parse(data[2].getHead()));
                joinedFace3.setOnClickListener(this);
            }else {
                joinedFace3.setVisibility(View.INVISIBLE);
            }
            if (data[3] != null) {
                joinedFace4.setVisibility(View.VISIBLE);
                joinedFace4.setImageURI(Uri.parse(data[3].getHead()));
                joinedFace4.setOnClickListener(this);
            }else {
                joinedFace4.setVisibility(View.INVISIBLE);
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

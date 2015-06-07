package com.mredrock.date.widget;

import android.net.Uri;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.model.bean.Detail;

public class DetailViewHolder extends BaseViewHolder<Detail.Join[]> {
    private SimpleDraweeView reprotFace1;
    private SimpleDraweeView reprotFace2;
    private SimpleDraweeView reprotFace3;
    private SimpleDraweeView reprotFace4;

    public DetailViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_detail);
        reprotFace1 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail1);
        reprotFace2 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail2);
        reprotFace3 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail3);
        reprotFace4 = (SimpleDraweeView) itemView.findViewById(R.id.author_report_face_detail4);
    }

    @Override
    public void setData(final Detail.Join[] data) {
        super.setData(data);
        if (data[0] != null) {
            reprotFace1.setImageURI(Uri.parse(data[0].getHead()));
        }
        if (data[1] != null) {
            reprotFace2.setImageURI(Uri.parse(data[1].getHead()));
        }
        if (data[2] != null) {
            reprotFace3.setImageURI(Uri.parse(data[2].getHead()));
        }
        if (data[3] != null) {
            reprotFace4.setImageURI(Uri.parse(data[3].getHead()));
        }
    }
}

package com.mredrock.date.widget;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.config.C;
import com.mredrock.date.detail.presenter.DetailActivityPresenter;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.util.RecentDateFormater;
import com.mredrock.date.util.TimeTransform;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class AppointmentViewHolder extends BaseViewHolder<Appointment> {
    private TextView authorName;
    private TextView authorSign;
    private ImageView authorGender;
    private TextView title;
    private TextView address;
    private TextView date;
    private TextView cost;
    private TextView releaseTime;
    private SimpleDraweeView authorFace;
    private Appointment data;
    public AppointmentViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_appointment);
        authorName = (TextView) itemView.findViewById(R.id.author_name);
        authorSign = (TextView) itemView.findViewById(R.id.author_sign);
        title = (TextView) itemView.findViewById(R.id.title);
        address = (TextView) itemView.findViewById(R.id.address);
        date = (TextView) itemView.findViewById(R.id.date);
        cost = (TextView) itemView.findViewById(R.id.cost);
        releaseTime = (TextView) itemView.findViewById(R.id.releaseTime);
        authorFace = (SimpleDraweeView) itemView.findViewById(R.id.author_face);
        authorGender = (ImageView) itemView.findViewById(R.id.author_gender);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(itemView.getContext(), DetailActivityPresenter.class);
                i.putExtra(C.DETAIL_TAG, JSON.toJSONString(data));
                itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public void setData(Appointment data) {
        super.setData(data);
        this.data = data;
        authorName.setText(data.getNickname());
        authorSign.setText(data.getSignature());
        authorFace.setImageURI(Uri.parse(data.getHead()));
        authorGender.setImageResource(data.getGender()==1?R.drawable.ic_man:R.drawable.ic_woman);
        title.setText(data.getTitle());
        address.setText(data.getPlace());
        date.setText(new TimeTransform(data.getDate_at()).toString(new RecentDateFormater()));
        cost.setText(itemView.getContext().getResources().getStringArray(R.array.cost)[data.getCost_model()]);
        releaseTime.setText(new TimeTransform(data.getCreated_at()).toString(new RecentDateFormater()));
    }
}

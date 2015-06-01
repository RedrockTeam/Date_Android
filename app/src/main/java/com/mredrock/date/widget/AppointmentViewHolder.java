package com.mredrock.date.widget;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
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
    }

    @Override
    public void setData(final Appointment data) {
        super.setData(data);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(itemView.getContext(), DetailActivityPresenter.class);
                i.putExtra(C.DETAIL_TAG, new Gson().toJson(data));
                itemView.getContext().startActivity(i);
            }
        });
        authorName.setText("");
        authorSign.setText("");
        authorFace.setImageURI(Uri.parse(""));
        authorGender.setImageResource(data.getGender()==0?R.drawable.ic_man:R.drawable.ic_woman);
        title.setText(data.getTitle());
        address.setText(data.getPlace());
        date.setText(new TimeTransform(data.getDate_at()).toString(new RecentDateFormater()));
        cost.setText(Appointment.COSTMODEL[data.getCost_model() - 1]);
        releaseTime.setText(new TimeTransform(data.getCreated_at()).toString(new RecentDateFormater()));
    }
}

package com.mredrock.date.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.mredrock.date.model.bean.Appointment;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class AppointmentArrayAdapter extends RecyclerArrayAdapter<Appointment> {

    public AppointmentArrayAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new AppointmentViewHolder(parent);
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.setData(getItem(position));
    }
}

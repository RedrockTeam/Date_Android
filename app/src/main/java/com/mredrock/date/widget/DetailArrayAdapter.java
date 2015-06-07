package com.mredrock.date.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.model.bean.Detail;

public class DetailArrayAdapter extends RecyclerArrayAdapter<Detail.Join[]> {

    public DetailArrayAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailViewHolder(parent);
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.setData(getItem(position));
    }
}

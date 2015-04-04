package com.mredrock.date.widget;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

abstract public class BaseViewHolder<M> extends RecyclerView.ViewHolder{
        public BaseViewHolder(View itemView) {
            super(itemView);
        }

        public BaseViewHolder(ViewGroup parent,int res) {
            super(LayoutInflater.from(parent.getContext()).inflate(res, parent, false));
        }

        public void setData(M data){};
    }
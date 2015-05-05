package com.mredrock.date.app;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.date.R;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public abstract class BaseActivityVu implements IVu{
    public Context context;
    private LayoutInflater inflater;
    private Toolbar toolbar;
    protected View rootView;

    @Override
    public final void init(LayoutInflater inflater, ViewGroup container) {
        this.inflater = inflater;
        context = inflater.getContext();
        onCreate();
    }
    protected abstract void onCreate();

    protected final void setView(View view){
        rootView = view;
        initToolbar();
    };

    protected final void setView(@LayoutRes int res){
        rootView = inflater.inflate(res,null);
        initToolbar();
    };

    protected final <E extends View> E $(View view,@IdRes int id){
        return (E)view.findViewById(id);
    }
    protected final <E extends View> E $(@IdRes int id){
        return (E)rootView.findViewById(id);
    }

    private final void initToolbar(){
        toolbar = $(rootView,R.id.toolbar);
        ActionBarActivity act = (ActionBarActivity)context;
        if (toolbar!=null){
            act.setSupportActionBar(toolbar);
            act.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        onToolbarInit(act, toolbar);
    }

    protected void onToolbarInit(ActionBarActivity act, Toolbar toolbar){
    }

    @Override
    public View getView() {
        return rootView;
    }

    protected final Context getContext() {
        return context;
    }

    protected final LayoutInflater getInflater() {
        return inflater;
    }

    protected final Toolbar getToolbar() {
        return toolbar;
    }

}

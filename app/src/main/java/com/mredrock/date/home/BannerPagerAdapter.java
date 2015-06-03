package com.mredrock.date.home;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.view.jpagerview.JStatePagerAdapter;
import com.mredrock.date.model.BannerModel;
import com.mredrock.date.model.bean.Banner;
import com.mredrock.date.setting.presenter.FeedbackActivity;
import com.mredrock.date.util.Utils;
import com.mredrock.date.widget.OnDataCallback;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class BannerPagerAdapter extends JStatePagerAdapter {
    BannerModel model = new BannerModel();

    public BannerPagerAdapter(){
        model.getBannerListFromServer(new OnDataCallback<Banner>() {
            @Override
            public void callback(Banner... banners) {
                notifyDataSetChanged();
            }

            @Override
            public void error(String info) {

            }
        });
    }

    @Override
    public View getView(final ViewGroup container, final int position) {
        SimpleDraweeView view = new SimpleDraweeView(container.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setImageURI(Uri.parse(model.getBanner(position).getSrc()));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container.getContext().startActivity(new Intent(container.getContext(), FeedbackActivity.class));
            }
        });
        return view;
    }

    @Override
    public void onBind(View view, int position) {
        //((SimpleDraweeView)view).setImageURI(Uri.parse(model.getBanner(position).getSrc()));
    }

    @Override
    public int getCount() {
        return model.getBannerLenght();
    }


}

package com.mredrock.date.home.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.view.jpagerview.JStatePagerAdapter;
import com.mredrock.date.app.IPresenter;
import com.mredrock.date.home.view.BannerPagerAdapterVu;
import com.mredrock.date.model.BannerModel;
import com.mredrock.date.model.bean.Banner;
import com.mredrock.date.util.Utils;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class BannerPagerAdapterPresenter extends JStatePagerAdapter implements IPresenter<BannerPagerAdapterVu>{
    BannerModel model = new BannerModel();

    public BannerPagerAdapterPresenter(){
        model.getBannerListFromServer(new BannerModel.onBannerCallback() {
            @Override
            public void callback(Banner[] banners) {
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        BannerPagerAdapterVu vu = null;
        try {
            vu = getVuClass().newInstance();
            vu.init(LayoutInflater.from(container.getContext()), container);
            vu.setImage(model.getBanner(position).getImg());
            vu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Utils.Toast("呵呵"+position);
                }
            });
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return vu.getView();
    }

    @Override
    public int getCount() {
        return model.getBannerLenght();
    }

    @Override
    public Class<BannerPagerAdapterVu> getVuClass() {
        return BannerPagerAdapterVu.class;
    }

    @Override
    public void onBindVu() {
    }

    @Override
    public void onDestroyVu() {
    }
}

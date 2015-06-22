package com.mredrock.date.information.view.presenter;

import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.app.BaseActivityVu;

/**
 * Created by Administrator on 2015/6/20.
 */
public class UploadFaceActivityVu extends BaseActivityVu implements View.OnClickListener{
    private SimpleDraweeView face;
    private LinearLayout camera;
    private LinearLayout photo;
    private LinearLayout net;
    private UploadFaceActivityPresenter presenter;

    @Override
    protected void onCreate() {
        setView(R.layout.activity_upload_face);
        initView();
        setListener();
    }

    public void initView(){
       face =$(R.id.upload_face);
        camera =$(R.id.camera_layout);
        photo =$(R.id.photo_layout);
        net =$(R.id.net_layout);
    }
    public void setPresenter(UploadFaceActivityPresenter presenter){
        this.presenter=presenter;
    }
    public void setListener(){
        camera.setOnClickListener(this);
        photo.setOnClickListener(this);
        net.setOnClickListener(this);
    }
    public void setImageURI(Uri uri){

        face.setImageURI(uri);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera_layout:
                presenter.getImageFromCamera();
            break;
            case R.id.photo_layout:
                presenter.getImageFromAlbum();
            break;
            case R.id.net_layout:
                presenter.getImageFromNet();
            break;
        }
    }
}

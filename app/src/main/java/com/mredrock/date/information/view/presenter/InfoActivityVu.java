package com.mredrock.date.information.view.presenter;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.model.bean.PersonInformatin;

/**
 * Created by Administrator on 2015/5/27.
 */
public class InfoActivityVu extends BaseActivityVu{
    private SimpleDraweeView face;
    private TextView name;
    private TextView sign;
    private TextView xueYuan;
    private TextView grade;
    private TextView tel;
    private TextView qq;
    private TextView weixin;
    @Override
    protected void onCreate() {
        setView(R.layout.activity_information);
        face =$(R.id.infor_face);
        name =$(R.id.info_name);
        sign =$(R.id.info_sign);
        xueYuan =$(R.id.info_school);
        grade =$(R.id.info_grade);
        tel =$(R.id.info_tel);
        qq =$(R.id.info_qq);
        weixin =$(R.id.info_weixin);

    }

    @Override
    protected void onToolbarInit(ActionBarActivity act, Toolbar toolbar) {
        super.onToolbarInit(act, toolbar);
        toolbar.setTitle("个人中心");
    }
    public void setPersonInformation(PersonInformatin personInfo){
        face.setImageURI(Uri.parse(personInfo.getFace()));
        name.setText(personInfo.getName());
        sign.setText(personInfo.getSign());
        grade.setText(personInfo.getGrade()+"");
        xueYuan.setText(personInfo.getXueyuan());
        tel.setText(personInfo.getTel());
        qq.setText(personInfo.getQq());
        weixin.setText(personInfo.getWeixin());

    }
}

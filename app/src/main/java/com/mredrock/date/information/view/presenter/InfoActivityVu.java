package com.mredrock.date.information.view.presenter;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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
    private TextView tel_edit;
    private TextView qq_edit;
    private TextView weixin_edit;
    @Override
    protected void onCreate() {
        setView(R.layout.activity_information);
        face =$(R.id.infor_face);
        name =$(R.id.info_name);
        sign =$(R.id.info_sign);
        xueYuan =$(R.id.info_school);
        grade =$(R.id.info_grade);
        tel =$(R.id.info_tel);
        tel_edit=$(R.id.info_tel_eidt);
        qq =$(R.id.info_qq);
        qq_edit =$(R.id.info_qq_eidt);
        weixin =$(R.id.info_weixin);
        weixin_edit =$(R.id.info_wexin_eidt);

    }

    @Override
    protected void onToolbarInit(ActionBarActivity act, Toolbar toolbar) {
        super.onToolbarInit(act, toolbar);
        toolbar.setTitle("个人中心");
    }
    public void setPersonInformation(PersonInformatin personInfo) {
        face.setImageURI(Uri.parse(personInfo.getFace()));
        name.setText(personInfo.getName());
        sign.setText(personInfo.getSign());
        grade.setText(personInfo.getGrade() + "");
        xueYuan.setText(personInfo.getXueyuan());
        tel.setText(personInfo.getTel());
        qq.setText(personInfo.getQq());
        weixin.setText(personInfo.getWeixin());
    }


    public void showEditBtn(){
        if(!tel.getText().toString().equals("")){
            tel_edit.setText("修改");
        }
        if(!qq.getText().toString().equals("")){
            qq_edit.setText("修改");
        }
        if(!weixin.getText().toString().equals("")){
            weixin_edit.setText("修改");
        }
        setVisible();
    }
    public void hideEidtBtn(){
        tel_edit.setVisibility(View.GONE);
        qq_edit.setVisibility(View.GONE);
        weixin_edit.setVisibility(View.GONE);
    }

    private void setVisible() {
        tel_edit.setVisibility(View.VISIBLE);
        qq_edit.setVisibility(View.VISIBLE);
        weixin_edit.setVisibility(View.VISIBLE);
    }
}

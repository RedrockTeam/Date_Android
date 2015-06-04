package com.mredrock.date.information.view.presenter;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.model.bean.Information;
import com.mredrock.date.model.bean.PersonInformatin;

/**
 * Created by Administrator on 2015/5/27.
 */
public class InfoActivityVu extends BaseActivityVu{
    private SimpleDraweeView face;
    private ImageView gender;
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
    private TextView gender_edit;
    @Override
    protected void onCreate() {
        setView(R.layout.activity_information);
        initView();


    }
   public void  initView(){
       gender=$(R.id.info_gender);
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
       gender_edit=$(R.id.info_gender_eidt);
   }
    public void setListener(View.OnClickListener listener ){
        tel_edit.setOnClickListener(listener);
        qq_edit.setOnClickListener(listener);
        weixin_edit.setOnClickListener(listener);
        gender_edit.setOnClickListener(listener);

    }
    @Override
    protected void onToolbarInit(ActionBarActivity act, Toolbar toolbar) {
        super.onToolbarInit(act, toolbar);
        toolbar.setTitle("个人资料");
    }
        public void setPersonInformation(Information personInfo) {
            if(personInfo.getHead()!=null){
                face.setImageURI(Uri.parse(personInfo.getHead()));
            }
            if(personInfo.getNickname()!=null){
                name.setText(personInfo.getNickname());
            }
            if(personInfo.getSignature()!=null){
                sign.setText(personInfo.getSignature());
            }
            if(personInfo.getGrade()!=null){
                grade.setText(personInfo.getGrade());
            }
            if(personInfo.getAcademy()!=null){
                xueYuan.setText(personInfo.getAcademy());
            }
            if(personInfo.getTelephone()!=null){
                tel.setText(personInfo.getTelephone());
            }
            if(personInfo.getQq()!=null){
                qq.setText(personInfo.getQq());
            }
            if(personInfo.getWeixin()!=null){
                weixin.setText(personInfo.getWeixin());
            }

            if(personInfo.getGender()==null||personInfo.getGender().equals("1")){
                gender.setImageResource(R.drawable.ic_man);
            }else {
                gender.setImageResource(R.drawable.ic_woman);
            }
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
        gender_edit.setVisibility(View.GONE);
    }

    private void setVisible() {
        tel_edit.setVisibility(View.VISIBLE);
        qq_edit.setVisibility(View.VISIBLE);
        weixin_edit.setVisibility(View.VISIBLE);
        gender_edit.setVisibility(View.VISIBLE);
    }


}

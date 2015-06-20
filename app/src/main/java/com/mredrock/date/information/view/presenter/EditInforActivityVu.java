package com.mredrock.date.information.view.presenter;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.model.bean.Information;
import com.mredrock.date.util.Utils;

/**
 * Created by Administrator on 2015/6/19.
 */
public class EditInforActivityVu extends BaseActivityVu implements View.OnClickListener{
    private SimpleDraweeView face;
    private RelativeLayout face_edit;
    private TextView name;
    private RelativeLayout name_edit;
    private TextView sign;
    private RelativeLayout sign_edit;
    private TextView xueYuan;
    private RelativeLayout xueYuan_edit;
    private TextView grade;
    private RelativeLayout grade_edit;
    private TextView tel;
    private TextView qq;
    private TextView weixin;
    private RelativeLayout tel_edit;
    private RelativeLayout qq_edit;
    private RelativeLayout weixin_edit;
    private RelativeLayout gender_edit;
    private TextView gender;
    private Information information;
    @Override
    protected void onCreate() {
        setView(R.layout.activity_ediinfo);
        initView();
        setListener();

    }

    private void initView() {
        face_edit = $(R.id.edit_touxiang_layout);
        face =$(R.id.edit_touxiang_img);
        name_edit=$(R.id.edit_name_layout);
        name=$(R.id.edit_name_tv);
        sign_edit=$(R.id.edit_sign_layout);
        sign=$(R.id.edit_sign_tv);
        gender_edit=$(R.id.edit_gender_layout);
        gender=$(R.id.edit_gender_tv);
        xueYuan_edit=$(R.id.edit_academy_layout);
        xueYuan=$(R.id.edit_academy_tv);
        grade=$(R.id.edit_grade_tv);
        grade_edit=$(R.id.edit_grade_layout);
        tel_edit=$(R.id.edit_tel_layout);
        tel=$(R.id.edit_tel_tv);
        qq=$(R.id.edit_qq_tv);
        qq_edit=$(R.id.edit_qq_layout);
        weixin=$(R.id.edit_wexin_tv);
        weixin_edit=$(R.id.edit_weixin_layout);

    }
    public void setPersonInformation(Information personInfo) {
        information=personInfo;
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
        if(personInfo.getGender()==null){
                gender.setText("女");
        }
        else if(personInfo.getGender().equals("1")){
            gender.setText("男");
        }else {
            gender.setText("女");
        }
    }
    public void setListener(){
        face_edit.setOnClickListener(this);
        name_edit.setOnClickListener(this);
        sign_edit.setOnClickListener(this);
        gender_edit.setOnClickListener(this);
        xueYuan_edit.setOnClickListener(this);
        grade_edit.setOnClickListener(this);
        tel_edit.setOnClickListener(this);
        qq_edit.setOnClickListener(this);
        weixin_edit.setOnClickListener(this);
    }

    @Override
    protected void onToolbarInit(ActionBarActivity act, Toolbar toolbar) {
        super.onToolbarInit(act, toolbar);
        toolbar.setTitle("资料编辑");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit_name_layout:
                new MaterialDialog.Builder(getContext())
                        .title("输入称昵")
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                name.setText(input);
                                information.setNickname(input.toString());

                            }
                        }).show();
                break;
            case R.id.edit_sign_layout:
                new MaterialDialog.Builder(getContext())
                        .title("输入个性签名")
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                sign.setText(input);
                                information.setSignature(input.toString());

                            }
                        }).show();
                break;
            case R.id.edit_academy_layout:
                new MaterialDialog.Builder(getContext())
                        .title("输入所在学院")
                        .items(R.array.college_edit)
                        .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                //  ((TextView)v).setText(text);
                                xueYuan.setText(text);
                                // appointment.setGender_limit(which);
                                information.setAcademy_id(which+1+"");
                                return true;
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
                break;
            case R.id.edit_grade_layout:
                new MaterialDialog.Builder(getContext())
                        .title("输入所在年级")
                        .items(R.array.grade_edit)
                        .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                //  ((TextView)v).setText(text);
                                grade.setText(text);
                                // appointment.setGender_limit(which);
                                information.setGrade_id(which+1+"");
                                return true;
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
                break;
            case R.id.edit_tel_layout:
                new MaterialDialog.Builder(getContext())
                        .title("输入手机号")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                if (!(input.toString().startsWith("1")&&input.toString().length()==11)){
                                    Utils.Toast("手机号输入错误");
                                    return;
                                }
                                tel.setText(input);
                                information.setTelephone(input.toString());

                            }
                        }).show();
                break;
            case R.id.edit_qq_layout:
                new MaterialDialog.Builder(getContext())
                        .title("输入QQ号")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                qq.setText(input);
                                information.setQq(input.toString());

                            }
                        }).show();
                break;
            case R.id.edit_weixin_layout:
                new MaterialDialog.Builder(getContext())
                        .title("输入微信号")
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                weixin.setText(input);
                                information.setWeixin(input.toString());
                            }
                        }).show();
                break;
            case R.id.edit_gender_layout:
                new MaterialDialog.Builder(getContext())
                        .title("修改性别（注:只能修改一次）")
                        .items(R.array.gender_edit)
                        .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                gender.setText(text);
                                information.setGender(which+1+"");
                                return true;
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
                break;
        }
    }
}

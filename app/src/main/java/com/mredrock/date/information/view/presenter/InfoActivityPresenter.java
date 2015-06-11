package com.mredrock.date.information.view.presenter;

import android.content.Intent;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.mredrock.date.R;
import com.mredrock.date.app.APP;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.model.EditInfomationModel;
import com.mredrock.date.model.InformationModel;
import com.mredrock.date.model.bean.Information;
import com.mredrock.date.util.Utils;

/**
 * Created by Administrator on 2015/5/27.
 */
public class InfoActivityPresenter extends BaseActivityPresenter<InfoActivityVu> implements View.OnClickListener{
    private String name_edit="";
    private String sign_edit="";
    private String xueyuan_edit="";
    private String grade_edit="";
    private String gender_edit="";
    private String tel_edit="";
    private String qq_edit="";
    private String weixin_edit="";
    private Information information;
    //private InformationModel mInformationModel = new InformationModel();
    @Override
    public Class<InfoActivityVu> getVuClass() {
        return InfoActivityVu.class;
    }

    @Override
    public void onBindVu() {
        vu.setListener(this);
        //1 nasdfnldssdaf 1
        getInformation();
    //    vu.setPersonInformation(mPersonModel.getUserPersonInformation() );
        //mInformationModel.getInformation();
        super.onBindVu();
    }
    public void getInformation(){
        InformationModel.getInformation(APP.getInstence().getUID(), new InformationModel.InforCallback() {
            @Override
            public void onSuccess(String info, Information data) {
                information = data;
                vu.setPersonInformation(data);
            }

            @Override
            public void onError(String errorInfo) {
                Utils.Toast(errorInfo);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_information, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == R.id.infor_edit){
            //startActivity(new Intent(this,EditActivityPresent.class));
            if(item.getTitle().toString().equals("编辑")){
                item.setTitle("保存");
                vu.showEditBtn();
            }else {
                if (name_edit.isEmpty()&&sign_edit.isEmpty()&&xueyuan_edit.isEmpty()&&grade_edit.isEmpty()&&gender_edit.isEmpty() && tel_edit.isEmpty() && qq_edit.isEmpty() && weixin_edit.isEmpty()) {
                    Utils.Toast("未修改任何信息!");
                    }else{
                    final MaterialDialog dialog = new MaterialDialog.Builder(this)
                            .title("正在修改")
                            .content("请稍后")
                            .progress(true, 100)
                            .cancelable(false)
                            .show();
                    isEmpty();
                    EditInfomationModel.edit(name_edit,sign_edit,gender_edit,grade_edit,xueyuan_edit,tel_edit, qq_edit, weixin_edit, new EditInfomationModel.EditCallback() {
                        @Override
                        public void onSuccess(String info) {
                            Utils.Toast(info);
                            dialog.dismiss();
                            item.setTitle("编辑");
                            vu.hideEidtBtn();
                            getInformation();

                        }

                        @Override
                        public void onError(String errorInfo) {
                            Utils.Toast(errorInfo);
                            dialog.dismiss();
                        }
                    });

                }
                }


    }


        return super.onOptionsItemSelected(item);
    }

    private void isEmpty() {
        if(name_edit.isEmpty()&&information.getNickname()!=null){
            name_edit=information.getNickname();
        }
        if(sign_edit.isEmpty()&&information.getSignature()!=null){
            sign_edit = information.getSignature();
        }
        if(xueyuan_edit.isEmpty()&&information.getAcademy_id()!=null){
            xueyuan_edit= information.getAcademy_id();
        }
        if(grade_edit.isEmpty()&&information.getGrade_id()!=null){
            grade_edit =information.getGrade_id();
        }
        if(gender_edit.isEmpty()&&information.getGender()!=null){
            gender_edit=information.getGender();
        }
        if(tel_edit.isEmpty()&&information.getTelephone()!=null){
            tel_edit=information.getTelephone();
        }if(qq_edit.isEmpty()&&information.getQq()!=null){
            qq_edit=information.getQq();
        }if(weixin_edit.isEmpty()&&information.getWeixin()!=null){
            weixin_edit=information.getWeixin();
        }
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()){
            case R.id.info_name_eidt:
                new MaterialDialog.Builder(this)
                        .title("输入称昵")
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                ((TextView)v).setText(input);
                                name_edit=input.toString();

                            }
                        }).show();
                break;
            case R.id.info_sign_eidt:
                new MaterialDialog.Builder(this)
                        .title("输入个性签名")
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                ((TextView)v).setText(input);
                                sign_edit=input.toString();

                            }
                        }).show();
                break;
            case R.id.info_grade_eidt:
                new MaterialDialog.Builder(this)
                        .title("输入所在年级")
                        .items(R.array.grade)
                        .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                //  ((TextView)v).setText(text);
                                ((TextView) (v)).setText(text);
                                // appointment.setGender_limit(which);
                                grade_edit=which+1+"";
                                return true;
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
                break;
            case R.id.info_tel_eidt:
                new MaterialDialog.Builder(this)
                        .title("输入手机号")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                ((TextView)v).setText(input);
                                tel_edit=input.toString();

                            }
                        }).show();
                break;
            case R.id.info_qq_eidt:
                new MaterialDialog.Builder(this)
                        .title("输入QQ号")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                ((TextView)v).setText(input);
                                qq_edit=input.toString();

                            }
                        }).show();
                break;
            case R.id.info_wexin_eidt:
                new MaterialDialog.Builder(this)
                        .title("输入微信号")
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                ((TextView)v).setText(input);
                                weixin_edit=input.toString();
                            }
                        }).show();
                break;
            case R.id.info_gender_eidt:
                new MaterialDialog.Builder(this)
                        .title("修改性别（注:只能修改一次）")
                        .items(R.array.gender_edit)
                        .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                //  ((TextView)v).setText(text);
                                ((TextView) (v)).setText(text);
                                // appointment.setGender_limit(which);
                                gender_edit=which+1+"";
                                return true;
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
                break;
        }
    }
}

package com.mredrock.date.information.view.presenter;

import android.content.Intent;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.presenter.EditActivityPresent;
import com.mredrock.date.model.InformationModel;
import com.mredrock.date.model.PersonModel;
import com.mredrock.date.model.bean.Information;
import com.mredrock.date.util.Utils;

/**
 * Created by Administrator on 2015/5/27.
 */
public class InfoActivityPresenter extends BaseActivityPresenter<InfoActivityVu> implements View.OnClickListener{
    private PersonModel mPersonModel = new PersonModel();
    //private InformationModel mInformationModel = new InformationModel();
    @Override
    public Class<InfoActivityVu> getVuClass() {
        return InfoActivityVu.class;
    }

    @Override
    public void onBindVu() {
        vu.setListener(this);
        InformationModel.getInformation("1", "nasdfnldssdaf", "1", new InformationModel.InforCallback() {
            @Override
            public void onSuccess(String info, Information data) {
                vu.setPersonInformation(data);
            }

            @Override
            public void onError(String errorInfo) {
                Utils.Toast(errorInfo);
            }
        });
    //    vu.setPersonInformation(mPersonModel.getUserPersonInformation() );
        //mInformationModel.getInformation();
        super.onBindVu();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_information, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.infor_edit){
            //startActivity(new Intent(this,EditActivityPresent.class));
            if(item.getTitle().toString().equals("编辑")){
                item.setTitle("保存");
                vu.showEditBtn();
            }else{
                vu.hideEidtBtn();
            }

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(final View v) {
        switch (v.getId()){
            case R.id.info_tel_eidt:
                new MaterialDialog.Builder(this)
                        .title("输入手机号")
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                ((TextView)v).setText(input);

                            }
                        }).show();
                break;
            case R.id.info_qq_eidt:
                new MaterialDialog.Builder(this)
                        .title("输入QQ号")
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                ((TextView)v).setText(input);

                            }
                        }).show();
                break;
            case R.id.info_weixin:
                new MaterialDialog.Builder(this)
                        .title("输入微信号")
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog materialDialog, CharSequence input) {
                                ((TextView)v).setText(input);

                            }
                        }).show();
                break;
        }
    }
}

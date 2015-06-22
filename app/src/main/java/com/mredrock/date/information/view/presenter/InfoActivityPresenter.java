package com.mredrock.date.information.view.presenter;

import android.content.Intent;
import android.os.Bundle;
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
public class InfoActivityPresenter extends BaseActivityPresenter<InfoActivityVu> {
    public static  Information information;
    @Override
    public Class<InfoActivityVu> getVuClass() {
        return InfoActivityVu.class;
    }

    private int getUid(){
        return  getIntent().getIntExtra("uid", Integer.parseInt(APP.getInstence().getUID()));
    }

    @Override
    public void onBindVu() {
        getInformation();
        super.onBindVu();
    }
    public void getInformation(){
        InformationModel.getInformation(getUid()+"", new InformationModel.InforCallback() {
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
        if (getUid() == Integer.parseInt(APP.getInstence().getUID()))
            getMenuInflater().inflate(R.menu.menu_information, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == R.id.infor_edit){
            if(information!=null){
                Intent intent = new Intent();
                //intent.putExtra("edit_info",information);
                intent.setClass(this,EditInformationActivityPresenter.class);
                startActivityForResult(intent,2);
            }else{
                Utils.Toast("获取个人资料失败无法编辑");
            }
    }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2){
            if(resultCode==200){
                getInformation();
            }else if(resultCode==100){
                vu.setPersonInformation(information);
            }

        }
    }
}

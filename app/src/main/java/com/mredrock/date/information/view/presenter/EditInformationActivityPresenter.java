package com.mredrock.date.information.view.presenter;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.mredrock.date.R;
import com.mredrock.date.app.APP;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.model.EditInfomationModel;
import com.mredrock.date.model.bean.Information;
import com.mredrock.date.util.Utils;

/**
 * Created by Administrator on 2015/6/19.
 */
public class EditInformationActivityPresenter extends BaseActivityPresenter<EditInforActivityVu> {
    Information infomation;
    @Override
    public Class<EditInforActivityVu> getVuClass() {
        return EditInforActivityVu.class;
    }

    @Override
    public void onBindVu() {
        super.onBindVu();
        vu.setPresenter(this);
         infomation=InfoActivityPresenter.information;
        vu.setPersonInformation(infomation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.meu_edti_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.infor_edit){
            final MaterialDialog dialog = new MaterialDialog.Builder(this)
                    .title("正在修改")
                    .content("请稍后")
                    .progress(true, 100)
                    .cancelable(false)
                    .show();
            EditInfomationModel.edit(infomation, new EditInfomationModel.EditCallback() {
                @Override
                public void onSuccess(String info) {
                    dialog.dismiss();
                    setResult(200);
                    EditInformationActivityPresenter.this.finish();
                }

                @Override
                public void onError(String errorInfo) {
                    Utils.Toast(errorInfo);
                    dialog.dismiss();

                }
            });
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==99&&resultCode==200){
                vu.setImgUrl(data.getAction());
                infomation.setHead(data.getAction());
                setResult(100);
        }
    }

    public void openEditFaceActivity(){
        Intent intent =new Intent(this,UploadFaceActivityPresenter.class);
        intent.putExtra("img_url",infomation.getHead());
       startActivityForResult(intent,99);
    }
}

package com.mredrock.date.information.view.presenter;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.presenter.EditActivityPresent;
import com.mredrock.date.model.PersonModel;

/**
 * Created by Administrator on 2015/5/27.
 */
public class InfoActivityPresenter extends BaseActivityPresenter<InfoActivityVu>{
    private PersonModel mPersonModel = new PersonModel();
    @Override
    public Class<InfoActivityVu> getVuClass() {
        return InfoActivityVu.class;
    }

    @Override
    public void onBindVu() {
        vu.setPersonInformation(mPersonModel.getUserPersonInformation() );
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
            startActivity(new Intent(this,EditActivityPresent.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

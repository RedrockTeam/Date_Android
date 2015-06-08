package com.mredrock.date.home.presenter;

import android.view.View;

import com.mredrock.date.app.BaseFragmentPresenter;
import com.mredrock.date.home.view.DrawerFragmentVu;
import com.mredrock.date.model.AppointmentModel;
import com.mredrock.date.model.LetterModel;
import com.mredrock.date.model.PersonModel;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.widget.OnDataCallback;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class DrawerFragmentPresenter extends BaseFragmentPresenter<DrawerFragmentVu> implements View.OnClickListener{
    private PersonModel mPersonModel = new PersonModel();
    private AppointmentModel mAppointmentModel = new AppointmentModel();
    private LetterModel mLetterModerl = new LetterModel();
    @Override
    public Class<DrawerFragmentVu> getVuClass() {
        return DrawerFragmentVu.class;
    }

    @Override
    public void onBindVu() {
        vu.setPerson(mPersonModel.getUserPersonBrief());
        mAppointmentModel.getJoinFromServer(new OnDataCallback<Appointment>() {
            @Override
            public void callback(Appointment... list) {
                vu.setRecordCount(list.length);
            }

            @Override
            public void error(String info) {

            }
        });
        mAppointmentModel.getCollectionFromServer(new OnDataCallback<Appointment>() {
            @Override
            public void callback(Appointment... list) {
                vu.setCollectionCount(list.length);
            }

            @Override
            public void error(String info) {

            }
        });
        mLetterModerl.letterstatus(new OnDataCallback<Integer>() {
            @Override
            public void callback(Integer... list) {
                vu.setMessageCountCount(list[0]);
            }

            @Override
            public void error(String info) {
                vu.setMessageCountCount(0);
            }
        });

    }

    @Override
    public void onDestroyVu() {

    }


    @Override
    public void onClick(View v) {

    }
}

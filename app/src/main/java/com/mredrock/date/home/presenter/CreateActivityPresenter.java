package com.mredrock.date.home.presenter;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.view.CreateActivityVu;
import com.mredrock.date.model.AppointmentModel;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.widget.OnDataCallback;

/**
 * Created by zhuchenxi on 15/6/10.
 */
public class CreateActivityPresenter extends BaseActivityPresenter<CreateActivityVu> {
    private AppointmentModel mAppointmentModel = new AppointmentModel();
    @Override
    public void onBindVu() {

        mAppointmentModel.getCreateFromServer(new OnDataCallback<Appointment>() {
            @Override
            public void callback(Appointment... list) {
                if (vu != null)
                    vu.setAppointment(list);
            }

            @Override
            public void error(String info) {

            }
        });

    }


    @Override
    public Class<CreateActivityVu> getVuClass() {
        return CreateActivityVu.class;
    }
}

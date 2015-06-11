package com.mredrock.date.home.presenter;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.view.RecordActivityVu;
import com.mredrock.date.model.AppointmentModel;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.widget.OnDataCallback;

/**
 * Created by Mr.Jude on 2015/4/29.
 */
public class JoinActivityPresenter extends BaseActivityPresenter<RecordActivityVu> {
    private AppointmentModel mAppointmentModel = new AppointmentModel();
    @Override
    public void onBindVu() {
        mAppointmentModel.getJoinFromServer(new OnDataCallback<Appointment>() {
            @Override
            public void callback(Appointment... list) {
                if (vu!=null)
                    vu.setAppointment(list);
            }

            @Override
            public void error(String info) {

            }
        });

    }

    @Override
    public Class<RecordActivityVu> getVuClass() {
        return RecordActivityVu.class;
    }
}

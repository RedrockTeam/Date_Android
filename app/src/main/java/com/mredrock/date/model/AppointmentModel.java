package com.mredrock.date.model;

import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.widget.OnDataCallback;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class AppointmentModel {

    public void getAppointmentFromServer(int page,OnDataCallback<Appointment> callback){
        callback.callback(new Appointment[]{
                new Appointment(),
                new Appointment(),
                new Appointment(),
                new Appointment(),
                new Appointment(),
                new Appointment(),
                new Appointment(),
                new Appointment(),
                new Appointment(),
                new Appointment(),
                new Appointment(),
                new Appointment(),
        });
    }

}

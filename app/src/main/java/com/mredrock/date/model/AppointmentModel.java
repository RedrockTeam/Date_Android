package com.mredrock.date.model;

import android.os.Handler;

import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.widget.OnDataCallback;


/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class AppointmentModel {

    public void getAppointmentFromServer(int page, final OnDataCallback<Appointment> callback){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
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
                });
            }
        }).start();

    }

}

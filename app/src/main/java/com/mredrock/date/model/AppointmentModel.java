package com.mredrock.date.model;

import com.android.http.RequestManager;
import com.mredrock.date.app.ResultRequestCallback;
import com.mredrock.date.app.SimpleRequestCallback;
import com.mredrock.date.app.TokenParams;
import com.mredrock.date.config.Api;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.model.bean.Detail;
import com.mredrock.date.widget.OnDataCallback;


/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class AppointmentModel {

    public void getAppointmentFromServer(int page, int dateType,int order,final OnDataCallback<Appointment> callback){
        TokenParams params = new TokenParams();
        params.put(Api.Key.DATE_TYPE,dateType+"");
        params.put(Api.Key.PAGE,page+"");
        params.put(Api.Key.SIZE,30+"");
        params.put(Api.Key.ORDER,order+"");
            RequestManager.getInstance().post(Api.Url.DateList, params, new SimpleRequestCallback<Appointment[]>(Appointment[].class) {
            @Override
            public void success(String info, Appointment[] data) {
                callback.callback(data);
            }

            @Override
            public void error(String errorInfo) {
                callback.error(errorInfo);
            }
        });
    }

    public void getCollectionFromServer(final OnDataCallback<Appointment> callback){
        RequestManager.getInstance().post(Api.Url.CollectionList, new TokenParams(), new SimpleRequestCallback<Appointment[]>(Appointment[].class) {
            @Override
            public void success(String info, Appointment[] data) {
                callback.callback(data);
            }

            @Override
            public void error(String errorInfo) {
                callback.error(errorInfo);
            }
        });
    }

    public void getJoinFromServer(final OnDataCallback<Appointment> callback){
        RequestManager.getInstance().post(Api.Url.JoinList, new TokenParams(), new SimpleRequestCallback<Appointment[]>(Appointment[].class) {
            @Override
            public void success(String info, Appointment[] data) {
                callback.callback(data);
            }

            @Override
            public void error(String errorInfo) {
                callback.error(errorInfo);
            }
        });
    }

    public void postAppointmentToServer(Detail appointment,final OnDataCallback<String> callback){
        TokenParams params = new TokenParams();
        params.put("date_type",appointment.getDate_type()+"");
        params.put("title",appointment.getTitle());
        params.put("content",appointment.getContent());
        params.put("date_time",appointment.getDate_at()+"");
        params.put("date_place",appointment.getPlace());
        params.put("date_people",appointment.getPeople_limit()+"");
        params.put("gender_limit",appointment.getGender_limit()+"");
        if (appointment.getGrade_limit()!=null)
            for (int i:appointment.getGrade_limit()){
                params.put("grade_limit[]",i+"");
            }
        params.put("academy_select_model","1");
        params.put("grade_select_model","1");
        params.put("cost_model",appointment.getCost_model()+"");
        RequestManager.getInstance().post(Api.Url.CollectionList, params, new ResultRequestCallback() {
            @Override
            public void success(String info) {
                callback.callback(info);
            }

            @Override
            public void error(String errorInfo) {
                callback.error(errorInfo);
            }
        });
    }

}

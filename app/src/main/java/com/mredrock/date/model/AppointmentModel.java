package com.mredrock.date.model;

import android.os.Handler;

import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.model.bean.PersonBrief;
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
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/2168/216844/myface.jpg","王尼玛","王尼玛我要给你生猴子",0),"挺进大别山","大别山",1430452800,"888元","大一",0,"不限",8,1429675200),
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/1228/122879/myface.jpg","赵日天","我的名字叫赵日天",1),"飞跃疯人院","疯人院",1430452800,"80元包吃住","不限",0,"不限",8,1430175600),
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/2168/216844/myface.jpg","王尼玛","王尼玛我要给你生猴子",0),"挺进大别山","大别山",1430452800,"888元","大一",0,"不限",8,1430118000),
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/1228/122879/myface.jpg","赵日天","我的名字叫赵日天",1),"飞跃疯人院","疯人院",1430452800,"80元包吃住","不限",0,"不限",8,1430362800),
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/2168/216844/myface.jpg","王尼玛","王尼玛我要给你生猴子",0),"挺进大别山","大别山",1430452800,"888元","大一",0,"不限",8,1429675200),
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/2168/216844/myface.jpg","王尼玛","王尼玛我要给你生猴子",0),"挺进大别山","大别山",1430452800,"888元","大一",0,"不限",8,1429675200),
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/1228/122879/myface.jpg","赵日天","我的名字叫赵日天",1),"飞跃疯人院","疯人院",1430452800,"80元包吃住","不限",0,"不限",8,1430175600),
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/2168/216844/myface.jpg","王尼玛","王尼玛我要给你生猴子",0),"挺进大别山","大别山",1430452800,"888元","大一",0,"不限",8,1429675200),
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/1228/122879/myface.jpg","赵日天","我的名字叫赵日天",1),"飞跃疯人院","疯人院",1430452800,"80元包吃住","不限",0,"不限",8,1430175600),
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/2168/216844/myface.jpg","王尼玛","王尼玛我要给你生猴子",0),"挺进大别山","大别山",1430452800,"888元","大一",0,"不限",8,1429675200),
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/2168/216844/myface.jpg","王尼玛","王尼玛我要给你生猴子",0),"挺进大别山","大别山",1430452800,"888元","大一",0,"不限",8,1429675200),
                                new Appointment(new PersonBrief("http://i0.hdslb.com/user/2168/216844/myface.jpg","王尼玛","王尼玛我要给你生猴子",0),"挺进大别山","大别山",1430452800,"888元","大一",0,"不限",8,1429675200),
                        });
                    }
                });
            }
        }).start();

    }

}

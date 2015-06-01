package com.mredrock.date.detail.view;

import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.model.DetailMode;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.model.bean.Detail;
import com.mredrock.date.util.RecentDateFormater;
import com.mredrock.date.util.TimeTransform;
import com.mredrock.date.widget.LoveView;
import com.mredrock.date.widget.OnDataCallbackT;

public class DetailActivityVu extends BaseActivityVu {
    private SimpleDraweeView authorFace;
    private LoveView socreLove;
    private TextView authorName;
    private ImageView authorGender;
    private TextView title;
    private TextView content;
    private TextView place;
    private TextView time;
    private TextView cost;
    private TextView grade;
    private TextView sex;
    private TextView number;

    private DetailMode detailMode = new DetailMode();
    @Override
    protected void onCreate() {
        setView(R.layout.activity_detail);
        authorFace = (SimpleDraweeView) rootView.findViewById(R.id.author_face_detail);
        socreLove = (LoveView) rootView.findViewById(R.id.user_star_container);
        authorName = (TextView) rootView.findViewById(R.id.author_name_detail);
        authorGender = (ImageView) rootView.findViewById(R.id.author_gender_detail);
        title = (TextView) rootView.findViewById(R.id.title_detail);
        content = (TextView) rootView.findViewById(R.id.content_detail);
        place = (TextView) rootView.findViewById(R.id.address_detail);
        time = (TextView) rootView.findViewById(R.id.date_detail);
        cost = (TextView) rootView.findViewById(R.id.cost_detail);
        grade = (TextView) rootView.findViewById(R.id.grade_detail);
        sex = (TextView) rootView.findViewById(R.id.sex_detail);
        number = (TextView) rootView.findViewById(R.id.number_detail);
    }

    public void setView(String json) {
        if (json != null) {
            Appointment data = new Gson().fromJson(json, Appointment.class);
            setDetailView(data.getDate_id());
            authorFace.setImageURI(Uri.parse(data.getHead()));
            authorName.setText(data.getNickname());
            authorGender.setImageResource(data.getGender() == 0 ? R.drawable.ic_man : R.drawable.ic_woman);
            title.setText(data.getTitle());
            content.setText(data.getContent());
            place.setText(data.getPlace());
            time.setText(new TimeTransform(data.getDate_at()).toString(new RecentDateFormater()));
            cost.setText(Appointment.COSTMODEL[data.getCost_model() - 1]);
        }
    }

    public void setDetailView(String date_Id) {
        detailMode.getDetailFromServer(date_Id, new OnDataCallbackT<Detail>() {
            @Override
            public void callback(Detail list) {
                String grade_limit = "";
                if (list.getGrade_limit() != null) {
                    for (int i = 0; i < list.getGrade_limit().length; i++) {
                        grade_limit += Detail.GRADE[list.getGrade_limit()[i]];
                    }
                } else {
                    grade_limit = Detail.GRADE[0];
                }
                grade.setText(grade_limit);
                sex.setText(Detail.SEX[list.getGender_limit()]);
                number.setText(list.getPeople_limit() + "");
                Log.i("cao", grade_limit + "12");
                socreLove.setStart(3.4);
                if (list.getUser_score() != null) {
                    socreLove.setStart(Double.valueOf(list.getUser_score()).doubleValue());
                }
            }

            @Override
            public void error(String info) {

            }
        });
    }
}

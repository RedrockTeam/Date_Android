package com.mredrock.date.detail.view;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.model.DetailMode;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.model.bean.Detail;
import com.mredrock.date.util.RecentDateFormater;
import com.mredrock.date.util.TimeTransform;
import com.mredrock.date.util.Utils;
import com.mredrock.date.widget.LoveView;
import com.mredrock.date.widget.OnDataCallback;

public class DetailActivityVu extends BaseActivityVu implements View.OnClickListener{
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
    private TextView collectionBtn;
    private TextView reportBtn;

    private Appointment data;
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
        collectionBtn = (TextView) rootView.findViewById(R.id.collection_detail);
        reportBtn = (TextView) rootView.findViewById(R.id.report_detail);

        collectionBtn.setOnClickListener(this);
        reportBtn.setOnClickListener(this);
    }

    public void loadView(String json) {
        if (json != null) {
            data = JSON.parseObject(json, Appointment.class);
            setDetailView(data.getDate_id());
            authorFace.setImageURI(Uri.parse(data.getHead()));
            authorName.setText(data.getNickname());
            authorGender.setImageResource(data.getGender() == 0 ? R.drawable.ic_man : R.drawable.ic_woman);
            title.setText(data.getTitle());
            content.setText(data.getContent());
            place.setText(data.getPlace());
            time.setText(new TimeTransform(data.getDate_at()).toString(new RecentDateFormater()));
            cost.setText(Appointment.COSTMODEL[data.getCost_model()]);
        }
    }

    public void setDetailView(String date_Id) {
        detailMode.getDetailFromServer(date_Id, new OnDataCallback<Detail>() {
            @Override
            public void callback(Detail... list) {
                String grade_limit = "";
                if (list[0].getGrade_limit() != null) {
                    for (int i = 0; i < list[0].getGrade_limit().length; i++) {
                        grade_limit += Detail.GRAD[list[0].getGrade_limit()[i]] + " ";
                    }
                } else {
                    grade_limit = "无限制";
                }
                if (grade_limit.equals("")) {
                    grade_limit = "无限制";
                }
                grade.setText(grade_limit);
                sex.setText(Detail.SEX[list[0].getGender_limit()]);
                number.setText(list[0].getPeople_limit() + "");
                socreLove.setStart(list[0].getUser_score());
                collectionBtn.setText(Detail.COLLECTION[list[0].getCollection_status()]);
                if (list[0].getCollection_status() != 0) {
                    collectionBtn.setClickable(false);
                }
                reportBtn.setText(Detail.REPORT[list[0].getApply_status()]);
                if (list[0].getApply_status() != 0) {
                    reportBtn.setClickable(false);
                }
            }

            @Override
            public void error(String info) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.collection_detail:
                detailMode.getCollectionFromServer(data.getDate_id(), new OnDataCallback<String>() {
                    @Override
                    public void callback(String... list) {
                        Utils.Toast(list[0]);
                        collectionBtn.setText(Detail.COLLECTION[1]);
                        collectionBtn.setClickable(false);
                    }

                    @Override
                    public void error(String info) {
                        Utils.Toast(info);
                    }
                });
                break;
            case R.id.report_detail:
                detailMode.getReportFromService(data.getDate_id(), new OnDataCallback<String>() {
                    @Override
                    public void callback(String... list) {
                        Utils.Toast(list[0]);
                        reportBtn.setText(Detail.REPORT[1]);
                        reportBtn.setClickable(false);
                    }

                    @Override
                    public void error(String info) {
                        Utils.Toast(info);
                    }
                });
                break;
        }
    }
}

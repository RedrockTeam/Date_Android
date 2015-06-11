package com.mredrock.date.detail.view;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.detail.presenter.DetailActivityPresenter;
import com.mredrock.date.detail.presenter.DetailJoinedDialog;
import com.mredrock.date.information.view.presenter.InfoActivityPresenter;
import com.mredrock.date.model.DetailMode;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.model.bean.Detail;
import com.mredrock.date.util.RecentDateFormater;
import com.mredrock.date.util.TimeTransform;
import com.mredrock.date.util.Utils;
import com.mredrock.date.widget.LoveView;
import com.mredrock.date.widget.OnDataCallback;

import java.util.ArrayList;
import java.util.List;

public class DetailActivityVu extends BaseActivityVu implements View.OnClickListener {
    private SimpleDraweeView joinedFace1;
    private SimpleDraweeView joinedFace2;
    private SimpleDraweeView joinedFace3;
    private SimpleDraweeView joinedFace4;

    private TextView joinedName1;
    private TextView joinedName2;
    private TextView joinedName3;
    private TextView joinedName4;

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
    private TextView more;
    private TextView collectionBtn;
    private TextView reportBtn;
    private LinearLayout llJoined;

    private Intent intent;
    private Appointment data;
    private DetailMode detailMode = new DetailMode();
    private List<Detail.Join[]> joined = new ArrayList<Detail.Join[]>();

    @Override
    protected void onCreate() {
        setView(R.layout.activity_detail);
        intent = new Intent();
        intent.setClass(context, InfoActivityPresenter.class);

        joinedFace1 = (SimpleDraweeView) rootView.findViewById(R.id.author_report_face_detail1);
        joinedFace2 = (SimpleDraweeView) rootView.findViewById(R.id.author_report_face_detail2);
        joinedFace3 = (SimpleDraweeView) rootView.findViewById(R.id.author_report_face_detail3);
        joinedFace4 = (SimpleDraweeView) rootView.findViewById(R.id.author_report_face_detail4);

        joinedName1 = (TextView) rootView.findViewById(R.id.author_report_name_detail1);
        joinedName2 = (TextView) rootView.findViewById(R.id.author_report_name_detail2);
        joinedName3 = (TextView) rootView.findViewById(R.id.author_report_name_detail3);
        joinedName4 = (TextView) rootView.findViewById(R.id.author_report_name_detail4);

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
        more = (TextView) rootView.findViewById(R.id.more_detail);

        collectionBtn = (TextView) rootView.findViewById(R.id.collection_detail);
        reportBtn = (TextView) rootView.findViewById(R.id.report_detail);
        llJoined = (LinearLayout) rootView.findViewById(R.id.include_joined_detail);
        $(R.id.header_detail).setOnClickListener(this);
        joinedFace1.setOnClickListener(this);
        joinedFace2.setOnClickListener(this);
        joinedFace3.setOnClickListener(this);
        joinedFace4.setOnClickListener(this);
        authorFace.setOnClickListener(this);
        more.setOnClickListener(this);
        collectionBtn.setOnClickListener(this);
        reportBtn.setOnClickListener(this);
    }

    /**
     * 得到json转为Appointment data
     *
     * @param json
     */
    public void setLoadDetail(String json) {
        if (json != null) {
            data = JSON.parseObject(json, Appointment.class);
        }
        setDetailView(data.getDate_id());
        authorFace.setImageURI(Uri.parse(data.getHead()));
        authorName.setText(data.getNickname());
        authorGender.setImageResource(data.getGender() == 0 ? R.drawable.ic_man : R.drawable.ic_woman);
        title.setText(data.getTitle());
        place.setText(data.getPlace());
        time.setText(new TimeTransform(data.getDate_at()).toString(new RecentDateFormater()));
        cost.setText(Appointment.COSTMODEL[data.getCost_model()]);
    }

    /**
     * 对详情的请求
     *
     * @param date_Id
     */
    private void setDetailView(String date_Id) {
        detailMode.getDetailFromServer(date_Id, new OnDataCallback<Detail>() {
            @Override
            public void callback(Detail... list) {

                String grade_limit = "";
                if (list[0].getGrade_limit() != null) {
                    for (int i = 0; i < list[0].getGrade_limit().length; i++) {
                        grade_limit += Detail.GRAD[list[0].getGrade_limit()[i]] + " ";
                    }
                } else {
                    grade_limit = "无�1" +
                            "���?";
                }
                if (grade_limit.equals("")) {
                    grade_limit = "无限�?";
                }
                grade.setText(grade_limit);
                sex.setText(Detail.SEX[list[0].getGender_limit()]);
                number.setText(list[0].getPeople_limit() + "");
                socreLove.setStart(list[0].getUser_score());
                content.setText(list[0].getContent());

                collectionBtn.setText(Detail.COLLECTION[list[0].getCollection_status()]);
                reportBtn.setText(Detail.REPORT[list[0].getApply_status()]);
                if (list[0].getApply_status() != 0) {
                    reportBtn.setClickable(false);
                }
                List<Detail.Join[]> listJoins = new ArrayList<Detail.Join[]>();
                for (int j = 0; j < (list[0].getJoined().size() % 4 == 0 ? list[0].getJoined().size() / 4 : list[0].getJoined().size() / 4 + 1); j++) {
                    Detail.Join[] join = new Detail.Join[4];
                    for (int k = 0; k < 4; k++) {
                        if ((j * 4 + k) < list[0].getJoined().size()) {
                            join[k] = list[0].getJoined().get(j * 4 + k);
                        }
                    }
                    listJoins.add(join);
                }
                setjoined(listJoins);
            }

            @Override
            public void error(String info) {

            }
        });
    }

    private void setjoined(List<Detail.Join[]> joined) {
        if (joined.size() > 0) {
            llJoined.setVisibility(View.VISIBLE);
            this.joined = joined;
            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0:
                        if (joined.get(0)[i] != null) {
                            joinedFace1.setVisibility(View.VISIBLE);
                            joinedName1.setVisibility(View.VISIBLE);
                            joinedName1.setText(joined.get(0)[i].getNickname());
                            joinedFace1.setImageURI(Uri.parse(joined.get(0)[i].getHead()));
                        } else {
                            joinedFace1.setVisibility(View.INVISIBLE);
                            joinedName1.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 1:
                        if (joined.get(0)[i] != null) {
                            joinedFace2.setVisibility(View.VISIBLE);
                            joinedName2.setVisibility(View.VISIBLE);
                            joinedName2.setText(joined.get(0)[i].getNickname());
                            joinedFace2.setImageURI(Uri.parse(joined.get(0)[i].getHead()));
                        } else {
                            joinedFace2.setVisibility(View.INVISIBLE);
                            joinedName2.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 2:
                        if (joined.get(0)[i] != null) {
                            joinedFace3.setVisibility(View.VISIBLE);
                            joinedName3.setVisibility(View.VISIBLE);
                            joinedName3.setText(joined.get(0)[i].getNickname());
                            joinedFace3.setImageURI(Uri.parse(joined.get(0)[i].getHead()));
                        } else {
                            joinedFace3.setVisibility(View.INVISIBLE);
                            joinedName3.setVisibility(View.INVISIBLE);
                        }
                        break;
                    case 3:
                        if (joined.get(0)[i] != null) {
                            joinedFace4.setVisibility(View.VISIBLE);
                            joinedName4.setVisibility(View.VISIBLE);
                            joinedName4.setText(joined.get(0)[i].getNickname());
                            joinedFace4.setImageURI(Uri.parse(joined.get(0)[i].getHead()));
                        } else {
                            joinedFace4.setVisibility(View.INVISIBLE);
                            joinedName4.setVisibility(View.INVISIBLE);
                        }
                        break;
                }
            }
        } else {
            llJoined.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.author_report_face_detail1:
                intent.putExtra("uid", (joined.get(0)[0].getUser_id()));
                context.startActivity(intent);
                break;
            case R.id.author_report_face_detail2:
                intent.putExtra("uid", (joined.get(0)[1].getUser_id()));
                context.startActivity(intent);
                break;
            case R.id.author_report_face_detail3:
                intent.putExtra("uid", (joined.get(0)[2].getUser_id()));
                context.startActivity(intent);
                break;
            case R.id.author_report_face_detail4:
                intent.putExtra("uid", (joined.get(0)[3].getUser_id()));
                context.startActivity(intent);
                break;
            case R.id.header_detail:
                intent.putExtra("uid", Integer.valueOf(data.getUser_id()));
                context.startActivity(intent);
                break;
            case R.id.collection_detail:
                if (collectionBtn.getText().toString().equals(Detail.COLLECTION[0])) {
                    detailMode.getCollectionFromServer(data.getDate_id(), new OnDataCallback<String>() {
                        @Override
                        public void callback(String... list) {
                            Utils.Toast(list[0]);
                            collectionBtn.setText(Detail.COLLECTION[1]);
                        }

                        @Override
                        public void error(String info) {
                            Utils.Toast(info);
                        }
                    });
                } else {
                    detailMode.getCancelCollectionFromService(data.getDate_id(), new OnDataCallback<String>() {
                        @Override
                        public void callback(String... list) {
                            Utils.Toast(list[0]);
                            collectionBtn.setText(Detail.COLLECTION[0]);
                        }

                        @Override
                        public void error(String info) {
                            Utils.Toast(info);
                        }
                    });
                }
                break;
            case R.id.report_detail:
                detailMode.getReportFromService(data.getDate_id(), new OnDataCallback<String>() {
                    @Override
                    public void callback(String... list) {
                        reportBtn.setText(Detail.REPORT[1]);
                        reportBtn.setClickable(false);
                    }

                    @Override
                    public void error(String info) {
                        Utils.Toast(info);
                    }
                });
                break;
            case R.id.more_detail:
                new DetailJoinedDialog(joined).show(((DetailActivityPresenter) context).getFragmentManager(), "detail");
                break;
        }
    }

}

package com.mredrock.date.detail.view;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.model.DetailMode;
import com.mredrock.date.model.bean.Appointment;
import com.mredrock.date.model.bean.Detail;
import com.mredrock.date.util.RecentDateFormater;
import com.mredrock.date.util.TimeTransform;
import com.mredrock.date.widget.LoveView;
import com.mredrock.date.widget.OnDataCallback;
import com.mredrock.date.widget.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetailHeader implements RecyclerArrayAdapter.HeaderView {
    private View view;
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

    private Appointment data;
    private  DetailActivityVu detailVu;
    private DetailMode detailMode = new DetailMode();

    public DetailHeader(Appointment data, DetailActivityVu detailVu) {
        this.data = data;
        this.detailVu = detailVu;
    }
    @Override
    public View onCreateView(ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_detail, parent, false);
        initView();
        return view;
    }

    @Override
    public void onBindView(View headerView) {
        if (data != null) {
            setDetailView(data.getDate_id());
            authorFace.setImageURI(Uri.parse(data.getHead()));
            authorName.setText(data.getNickname());
            authorGender.setImageResource(data.getGender() == 0 ? R.drawable.ic_man : R.drawable.ic_woman);
            title.setText(data.getTitle());
            place.setText(data.getPlace());
            time.setText(new TimeTransform(data.getDate_at()).toString(new RecentDateFormater()));
            cost.setText(Appointment.COSTMODEL[data.getCost_model()]);
        }
    }

    private void initView() {
        authorFace = (SimpleDraweeView) view.findViewById(R.id.author_face_detail);
        socreLove = (LoveView) view.findViewById(R.id.user_star_container);
        authorName = (TextView) view.findViewById(R.id.author_name_detail);
        authorGender = (ImageView) view.findViewById(R.id.author_gender_detail);
        title = (TextView) view.findViewById(R.id.title_detail);
        content = (TextView) view.findViewById(R.id.content_detail);
        place = (TextView) view.findViewById(R.id.address_detail);
        time = (TextView) view.findViewById(R.id.date_detail);
        cost = (TextView) view.findViewById(R.id.cost_detail);
        grade = (TextView) view.findViewById(R.id.grade_detail);
        sex = (TextView) view.findViewById(R.id.sex_detail);
        number = (TextView) view.findViewById(R.id.number_detail);
    }

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
                    grade_limit = "无限制";
                }
                if (grade_limit.equals("")) {
                    grade_limit = "无限制";
                }
                grade.setText(grade_limit);
                sex.setText(Detail.SEX[list[0].getGender_limit()]);
                number.setText(list[0].getPeople_limit() + "");
                socreLove.setStart(list[0].getUser_score());
                content.setText(list[0].getContent());
                for(int i = 0; i < 10; i++){
                    if (list[0].getJoined().size() != 0) {
                        list[0].getJoined().add(list[0].getJoined().get(0));
                    }
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
                detailVu.headBackView(list[0].getCollection_status(), list[0].getApply_status(), listJoins);
            }

            @Override
            public void error(String info) {

            }
        });
    }
}

package com.mredrock.date.home.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.R;
import com.mredrock.date.app.APP;
import com.mredrock.date.app.IVu;
import com.mredrock.date.home.presenter.CollectionActivityPresenter;
import com.mredrock.date.home.presenter.LoginActivityPresenter;
import com.mredrock.date.home.presenter.RecordActivityPresenter;
import com.mredrock.date.information.view.presenter.InfoActivityPresenter;
import com.mredrock.date.letter.presenter.LetterActivityPresenter;
import com.mredrock.date.model.bean.PersonBrief;
import com.mredrock.date.util.Utils;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class DrawerFragmentVu implements IVu ,View.OnClickListener{
    private View view;
    private Context ctx;
    private SimpleDraweeView tvFace;
    private TextView tvName;
    private ListPopupWindow pop;
    private TextView tvRecordCount;
    private TextView tvCollectCount;
    private TextView tvMessageCount;
    private View vDropdown;
    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        ctx = inflater.getContext();
        view = inflater.inflate(R.layout.fragment_drawer,container,false);
        final View containerFace = view.findViewById(R.id.container_face);
        containerFace.post(new Runnable() {
            @Override
            public void run() {
                int width = Utils.getScreenWidth()-Utils.dip2px(56);
                containerFace.setLayoutParams(new LinearLayout.LayoutParams(width, width * 9 / 16));
            }
        });
        tvFace = (SimpleDraweeView) view.findViewById(R.id.face);
        tvName = (TextView) view.findViewById(R.id.name);
        vDropdown = view.findViewById(R.id.dropdownbtn);
        tvRecordCount = (TextView) view.findViewById(R.id.record_count);
        tvCollectCount = (TextView) view.findViewById(R.id.collection_count);
        tvMessageCount = (TextView) view.findViewById(R.id.message_count);
        view.findViewById(R.id.record).setOnClickListener(this);
        view.findViewById(R.id.collection).setOnClickListener(this);
        view.findViewById(R.id.message).setOnClickListener(this);
        view.findViewById(R.id.information).setOnClickListener(this);
        view.findViewById(R.id.logout).setOnClickListener(this);
        view.findViewById(R.id.setting).setOnClickListener(this);
        initDropDown();
    }

    private void initDropDown(){
        pop = Utils.creatTextListPopupWindows(view.getContext(),new String[]{"修改头像","修改昵称","修改签名"},new Utils.PopupListener() {
            @Override
            public void onListenerPop(ListPopupWindow listp) {

            }

            @Override
            public void onListItemClickBack(ListPopupWindow popwindow, View parent, int position) {
                pop.dismiss();
                switch (position){
                    case 0:
                        ctx.startActivity(new Intent(ctx, LetterActivityPresenter.class));
                        break;
                    case 1:
                        //ctx.startActivity(new Intent(ctx, PersonNameEditActivity.class));
                        break;
                    case 2:
                        //ctx.startActivity(new Intent(ctx, PersonSignEditActivity.class));
                        break;
                }
            }
        });
        pop.setAnchorView(vDropdown);
        pop.setWidth(Utils.dip2px(112));
        pop.setHorizontalOffset(-Utils.dip2px(108));
        pop.setVerticalOffset(-Utils.dip2px(32));
        vDropdown.setOnClickListener(this);
    }

    public void setRecordCount(int count){
        tvRecordCount.setText(count+"");
    }
    public void setCollectionCount(int count){
        tvCollectCount.setText(count+"");
    }
    public void setMessageCountCount(int count){
        if (count == 0){
            tvMessageCount.setVisibility(View.GONE);
        }else{
            tvMessageCount.setVisibility(View.VISIBLE);
            tvMessageCount.setText(count+"");
        }

    }


    public void setPerson(PersonBrief user){
        tvFace.setImageURI(Uri.parse(user.getFace()));
        tvName.setText(user.getName());
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dropdownbtn:
                pop.show();
                break;
            case R.id.record:
                ctx.startActivity(new Intent(ctx, RecordActivityPresenter.class));
                break;
            case R.id.collection:
                ctx.startActivity(new Intent(ctx, CollectionActivityPresenter.class));
                break;
            case R.id.message:
                ctx.startActivity(new Intent(ctx, LetterActivityPresenter.class));
                break;
            case R.id.logout:
                APP.getInstence().setToken("");
                ctx.startActivity(new Intent(ctx, LoginActivityPresenter.class));
                ((Activity)ctx).finish();
                break;
            case R.id.setting:
                break;
            case R.id.information:
                ctx.startActivity(new Intent(ctx, InfoActivityPresenter.class));
                break;
        }
    }
}

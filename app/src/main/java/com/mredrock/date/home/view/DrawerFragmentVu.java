package com.mredrock.date.home.view;

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
import com.mredrock.date.app.IVu;
import com.mredrock.date.home.presenter.CollectionActivityPresenter;
import com.mredrock.date.home.presenter.CreateActivityPresenter;
import com.mredrock.date.home.presenter.JoinActivityPresenter;
import com.mredrock.date.information.view.presenter.UploadFaceActivityPresenter;
import com.mredrock.date.model.bean.Information;
import com.mredrock.date.setting.presenter.SettingActivityPresenter;
import com.mredrock.date.information.view.presenter.InfoActivityPresenter;
import com.mredrock.date.letter.presenter.LetterActivityPresenter;
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
    private TextView tvCreateCount;
    private View vDropdown;
    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        ctx = inflater.getContext();
        view = inflater.inflate(R.layout.fragment_drawer,container,false);
        tvFace = (SimpleDraweeView) view.findViewById(R.id.face);
        tvName = (TextView) view.findViewById(R.id.name);
        vDropdown = view.findViewById(R.id.dropdownbtn);
        tvRecordCount = (TextView) view.findViewById(R.id.record_count);
        tvCollectCount = (TextView) view.findViewById(R.id.collection_count);
        tvMessageCount = (TextView) view.findViewById(R.id.message_count);
        tvCreateCount = (TextView) view.findViewById(R.id.create_count);
        view.findViewById(R.id.container_face).setOnClickListener(this);
        view.findViewById(R.id.create).setOnClickListener(this);
        view.findViewById(R.id.record).setOnClickListener(this);
        view.findViewById(R.id.collection).setOnClickListener(this);
        view.findViewById(R.id.message).setOnClickListener(this);
        view.findViewById(R.id.information).setOnClickListener(this);
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
    public void setCreateCount(int count){
        tvCreateCount.setText(count + "条约");
    }
    public void setRecordCount(int count){
        tvRecordCount.setText(count+"条约");
    }
    public void setCollectionCount(int count){
        tvCollectCount.setText(count+"条约");
    }
    public void setMessageCountCount(int count){
        if (count == 0){
            tvMessageCount.setVisibility(View.GONE);
        }else{
            tvMessageCount.setVisibility(View.VISIBLE);
            tvMessageCount.setText(count+"");
        }

    }


    public void setPerson(Information user){
        tvFace.setImageURI(Uri.parse(user.getHead()));
        tvName.setText(user.getNickname());
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
            case R.id.create:
                ctx.startActivity(new Intent(ctx, CreateActivityPresenter.class));
                break;
            case R.id.record:
                ctx.startActivity(new Intent(ctx, JoinActivityPresenter.class));
                break;
            case R.id.collection:
                ctx.startActivity(new Intent(ctx, CollectionActivityPresenter.class));
                break;
            case R.id.message:
                ctx.startActivity(new Intent(ctx, LetterActivityPresenter.class));
                break;
            case R.id.setting:
                ctx.startActivity(new Intent(ctx, SettingActivityPresenter.class));
                break;
            case R.id.container_face:
            case R.id.information:
                ctx.startActivity(new Intent(ctx, InfoActivityPresenter.class));
                break;
        }
    }
}

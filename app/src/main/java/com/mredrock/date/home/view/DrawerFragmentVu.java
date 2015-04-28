package com.mredrock.date.home.view;

import android.content.Context;
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
        view.findViewById(R.id.record).setOnClickListener(this);
        view.findViewById(R.id.collection).setOnClickListener(this);
        view.findViewById(R.id.message).setOnClickListener(this);
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
                        //ctx.startActivity(new Intent(ctx, PersonFaceEditActivity.class));
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
                break;
            case R.id.collection:
                break;
            case R.id.message:
                break;
            case R.id.setting:
                break;
        }
    }
}

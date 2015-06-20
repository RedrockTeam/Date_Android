package com.mredrock.date.detail.presenter;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mredrock.date.R;
import com.mredrock.date.model.DetailMode;
import com.mredrock.date.util.Utils;
import com.mredrock.date.widget.LoveView;
import com.mredrock.date.widget.OnDataCallback;

@SuppressLint("ValidFragment")
public class CommentDialog extends DialogFragment implements View.OnClickListener{
    private LoveView love;
    private Button sureBtn;
    private DetailMode detailMode = new DetailMode();
    private String date_id;

    public CommentDialog(String date_id) {
        this.date_id = date_id;
    }

    @Override
    public void onResume() {
        super.onResume();
        getDialog().getWindow().setLayout(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detail_commmet, container, false);
        
        initVie(root);
        return root;
    }

    private void initVie(View root) {
        love = (LoveView) root.findViewById(R.id.comment_love);
        sureBtn = (Button) root.findViewById(R.id.comment_sure_btn);
        sureBtn.setOnClickListener(this);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.comment_sure_btn:
                detailMode.getCommentFromServer(date_id, love.getScore() + "", new OnDataCallback<String>() {
                    @Override
                    public void callback(String... list) {
                        Utils.Toast(list[0]);
                        dismiss();
                    }

                    @Override
                    public void error(String info) {
                        Utils.Toast(info);
                        dismiss();
                    }
                });
                break;
        }
    }
}

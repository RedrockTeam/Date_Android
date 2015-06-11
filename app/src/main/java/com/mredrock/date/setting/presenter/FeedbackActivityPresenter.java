package com.mredrock.date.setting.presenter;

import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.http.RequestManager;
import com.android.http.RequestMap;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.app.ResultRequestCallback;
import com.mredrock.date.app.TokenParams;
import com.mredrock.date.config.Api;
import com.mredrock.date.setting.view.FeedbackActivityVu;
import com.mredrock.date.util.Utils;

/**
 * Created by zhuchenxi on 15/6/10.
 */
public class FeedbackActivityPresenter extends BaseActivityPresenter<FeedbackActivityVu> {

    @Override
    public void onBindVu() {
        super.onBindVu();

    }

    @Override
    public Class<FeedbackActivityVu> getVuClass() {
        return FeedbackActivityVu.class;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.send){
            if (vu.getContent().trim().isEmpty()){
                Utils.Toast("请输入内容");
            }else{
                final MaterialDialog dialog = new MaterialDialog.Builder(this)
                        .title("提交中")
                        .content("请稍后")
                        .progress(true, 100)
                        .cancelable(false)
                        .show();
                RequestManager.getInstance().post(Api.Url.Advice, new TokenParams("content", vu.getContent()), new ResultRequestCallback() {
                    @Override
                    public void success(String info) {
                        dialog.dismiss();
                        Utils.Toast("谢谢你的反馈");
                        finish();
                    }

                    @Override
                    public void error(String errorInfo) {
                        dialog.dismiss();
                        Utils.Toast(errorInfo);
                    }
                });
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

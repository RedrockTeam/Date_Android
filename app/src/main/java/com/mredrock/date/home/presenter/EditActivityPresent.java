package com.mredrock.date.home.presenter;

import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.view.EditActivityVu;

/**
 * Created by zhuchenxi on 15/4/30.
 */
public class EditActivityPresent extends BaseActivityPresenter<EditActivityVu> {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit,menu);
        return true;
    }

    public void onClick(final View v) {
        switch (v.getId()){
            case R.id.btn_style:
                new MaterialDialog.Builder(this)
                        .title(R.string.edit_title_style)
                        .items(R.array.style)
                        .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                vu.setStyle(text.toString());
                                return true;
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
                break;
            case R.id.btn_gender:
                new MaterialDialog.Builder(this)
                        .title(R.string.edit_title_gender)
                        .items(R.array.gender)
                        .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                ((TextView)v).setText(text);
                                return true;
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
                break;
            case R.id.btn_grade:
                new MaterialDialog.Builder(this)
                        .title(R.string.edit_title_grade)
                        .items(R.array.grade)
                        .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                ((TextView)v).setText(text);
                                return true;
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
                break;
            case R.id.btn_college:
                new MaterialDialog.Builder(this)
                        .title(R.string.edit_title_college)
                        .items(R.array.college)
                        .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                ((TextView)v).setText(text);
                                return true;
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
                break;
            case R.id.btn_cost:
                new MaterialDialog.Builder(this)
                        .title(getString(R.string.edit_title_cost))
                        .items(R.array.cost)
                        .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                ((TextView)v).setText(text);
                                return true;
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
                break;
            case R.id.btn_title:
                new MaterialDialog.Builder(this)
                        .title("输入标题")
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .inputMaxLength(30)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                ((TextView)v).setText(input);
                            }
                        }).show();
                break;
            case R.id.btn_address:
                new MaterialDialog.Builder(this)
                        .title("输入约会地点")
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                ((TextView)v).setText(input);
                            }
                        }).show();
                break;
            case R.id.btn_count:
                new MaterialDialog.Builder(this)
                        .title("输入约会人数")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .input("", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                ((TextView)v).setText(input);
                            }
                        }).show();
                break;
        }
    }

    @Override
    public Class<EditActivityVu> getVuClass() {
        return EditActivityVu.class;
    }
}

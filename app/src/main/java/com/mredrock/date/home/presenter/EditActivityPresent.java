package com.mredrock.date.home.presenter;

import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.view.EditActivityVu;
import com.mredrock.date.model.AppointmentModel;
import com.mredrock.date.model.bean.DateType;
import com.mredrock.date.model.bean.Detail;
import com.mredrock.date.util.RecentDateFormater;
import com.mredrock.date.util.TimeTransform;
import com.mredrock.date.util.Utils;
import com.mredrock.date.widget.OnDataCallback;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by zhuchenxi on 15/4/30.
 */
public class EditActivityPresent extends BaseActivityPresenter<EditActivityVu> {
    AppointmentModel model = new AppointmentModel();
    Detail appointment = new Detail();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.send){
            if (appointment.getDate_type() == 0){
                Utils.Toast("请选择约会类型");
                return true;
            }
            if (appointment.getTitle()==null||appointment.getTitle().trim().isEmpty()){
                Utils.Toast("请输入标题");
                return true;
            }
            if (appointment.getDate_at() == 0){
                Utils.Toast("请输入约会时间");
                return true;
            }
            if (appointment.getPlace()==null||appointment.getPlace().trim().isEmpty()){
                Utils.Toast("请输入约会地点");
                return true;
            }
            if (appointment.getPeople_limit() == 0){
                Utils.Toast("请输入约会人数");
                return true;
            }
            if (appointment.getCost_model() == -1){
                Utils.Toast("请选择花费模式");
                return true;
            }
            appointment.setContent(vu.getContent());
            final MaterialDialog dialog = new MaterialDialog.Builder(this)
                    .title("发布中")
                    .content("请稍后")
                    .progress(true, 100)
                    .cancelable(false)
                    .show();
            model.postAppointmentToServer(appointment, new OnDataCallback<String>() {
                @Override
                public void callback(String... list) {
                    dialog.dismiss();
                    setResult(RESULT_OK);
                    finish();
                    Utils.Toast("发布成功");
                }

                @Override
                public void error(String info) {
                    dialog.dismiss();
                    Utils.Toast(info);
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(final View v) {
        switch (v.getId()){
            case R.id.btn_time:
                final Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
                                now.set(i, i1, i2);
                                TimePickerDialog tpd = TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(RadialPickerLayout radialPickerLayout, int i, int i1) {
                                        now.set(Calendar.HOUR_OF_DAY,i);
                                        now.set(Calendar.MINUTE,i1);
                                        ((TextView)v).setText(new TimeTransform(now.getTimeInMillis() / 1000).toString(new RecentDateFormater()));
                                        appointment.setDate_at(now.getTimeInMillis() / 1000);
                                    }
                                },
                                now.get(Calendar.HOUR_OF_DAY),
                                now.get(Calendar.MINUTE),
                                true);
                                tpd.show(getFragmentManager(), "请选择时间");
                                Utils.Log("A:" + i + "  B:" + i1 + "  C:" + i2);
                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "请选择日期");
                break;
            case R.id.btn_style:
                final DateType[] dateTypes = model.getDateType();
                String[] dateStrs = new String[dateTypes.length];
                for (int i = 0 ; i < dateTypes.length ; i++){
                    dateStrs[i] = dateTypes[i].getType();
                }
                new MaterialDialog.Builder(this)
                        .title(R.string.edit_title_style)
                        .items(dateStrs)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                vu.setStyle(dateTypes[which].getType()+"");
                                appointment.setDate_type(dateTypes[which].getId());
                            }
                        })
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
                                appointment.setGender_limit(which);
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
                        .itemsCallbackMultiChoice(new Integer[0],new MaterialDialog.ListCallbackMultiChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog materialDialog, Integer[] integers, CharSequence[] charSequences) {
                                StringBuilder sb = new StringBuilder();
                                for (CharSequence t:charSequences){
                                    sb.append(t.toString());
                                }
                                ((TextView) v).setText(sb.toString());
                                int[] r = new int[integers.length];
                                for (int i = 0 ; i < integers.length ; i++){
                                    r[i] = integers[i];
                                }
                                appointment.setGrade_limit(r);
                                return false;
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
                                appointment.setCost_model(which+1);
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
                                appointment.setTitle(input.toString());
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
                                appointment.setPlace(input.toString());
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
                                appointment.setPeople_limit(Integer.parseInt(input.toString()));
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

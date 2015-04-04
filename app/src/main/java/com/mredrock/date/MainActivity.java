package com.mredrock.date;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.http.RequestManager;
import com.android.http.RequestMap;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RequestManager.getInstance().init(this);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView) findViewById(R.id.text);
        ImageView img = (ImageView) findViewById(R.id.img);
        RequestMap params = new RequestMap();
        params.put("key", "value");
        RequestManager.getInstance().post("http://blog.csdn.net/",params,new RequestManager.RequestListener() {
            @Override
            public void onRequest() {

            }

            @Override
            public void onSuccess(String response, String url) {
                tv.setText(response);
            }

            @Override
            public void onError(String errorMsg, String url) {

            }
        });
        RequestManager.getInstance().img("http://img3.douban.com/lpic/s10299848.jpg",img);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

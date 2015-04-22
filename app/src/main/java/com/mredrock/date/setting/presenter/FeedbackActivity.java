package com.mredrock.date.setting.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.mredrock.date.R;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.fragment.FeedbackFragment;
import com.umeng.message.PushAgent;

/**
 * Created by Mr.Jude on 2015/3/1.
 */
public class FeedbackActivity extends ActionBarActivity {
    private FeedbackFragment mFeedbackFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushAgent.getInstance(this).onAppStart();
        setContentView(R.layout.activity_feedback);

        new FeedbackAgent(this).setWelcomeInfo("你好，我是吐槽经理,来尽情释放你的吐槽能量吧！");
        if (savedInstanceState == null) {
            String conversation_id = new FeedbackAgent(this).getDefaultConversation().getId();
            mFeedbackFragment = FeedbackFragment.newInstance(conversation_id);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container,mFeedbackFragment,"feedback")
                    .commit();
        }
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        mFeedbackFragment.refresh();
    }


}

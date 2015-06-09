package com.mredrock.date.util;

/**
 * Created by Mr.Jude on 2015/2/12.
 */
import java.util.LinkedList;
import android.app.Activity;
import android.text.TextUtils;


public class JActivityManager {
    private static LinkedList<Activity> activityStack;
    private static JActivityManager instance;

    private JActivityManager() {
    }

    public static JActivityManager getInstance() {
        if (instance == null) {
            instance = new JActivityManager();
        }
        return instance;
    }

    /**
     * 退出Activity
     *
     * @param activity
     */
    public void popActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            Utils.Log("Activity管理", activity.getClass().getSimpleName() + "弹出栈");
            activity.finish();
            activity = null;
        }
    }

    /**
     * 获得当前栈顶Activity
     *
     * @return
     */
    public Activity currentActivity() {
        Activity activity = null;
        if (activityStack != null && !activityStack.isEmpty())
            activity = activityStack.get(activityStack.size() - 1);
        return activity;
    }

    /**
     * 将当前Activity推入栈中
     *
     * @param activity
     */
    public void pushActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new LinkedList<Activity>();
        }
        activityStack.add(activity);
        Utils.Log("Activity管理", activity.getClass().getSimpleName() + "加入栈中");
    }

    /**
     * 退出栈中所有Activity
     */
    public void popAllActivityExceptOne() {
        while (true) {
            Activity activity = currentActivity();
            if (null == activity) {
                break;
            }
            popActivity(activity);
        }
    }

    public void popAllActivity() {
        while (true) {
            Activity activity = currentActivity();
            if (null == activity) {
                break;
            }
            popActivity(activity);
        }
    }

    /**
     * 退出指定名字的activity
     */
    public void popPointNameActivity(String name) {
        while (true) {
            Activity activity = currentActivity();
            if (null == activity) {
                break;
            }

            String activityName = activity.getComponentName().getClassName().toString();
            if (TextUtils.equals(name, activityName)) {
                continue;
            }
            popActivity(activity);
        }
    }

    /**
     * 获得当前ACTIVITY 名字
     */
    public String getCurrentActivityName() {
        Activity activity = currentActivity();
        String name = "";
        if (activity != null) {
            name = activity.getComponentName().getClassName().toString();
        }
        return name;
    }

}


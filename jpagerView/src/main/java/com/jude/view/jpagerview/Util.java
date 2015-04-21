package com.jude.view.jpagerview;

import android.content.Context;

class Util {
	/** 
     * dpתpx
     * 
     */  
    public static int dip2px(Context ctx,float dpValue) {  
        final float scale = ctx.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    } 
 
  
    /** 
     *	pxתdp
     */  
    public static int px2dip(Context ctx,float pxValue) {  
        final float scale = ctx.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }
    
}

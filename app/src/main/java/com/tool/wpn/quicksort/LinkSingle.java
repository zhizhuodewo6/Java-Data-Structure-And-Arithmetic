package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/7/30.
 * 单链表中链结点
 */

public class LinkSingle {
    public int iData;
    public double dData;
    public LinkSingle next;
    public LinkSingle(int id,double dd){
        iData=id;
        dData=dd;
    }

    /**
     * 展示链接点
     */
    public void displayLink(){
        Log.i("LinkSingle","{"+iData+","+dData+"}");
    }

}

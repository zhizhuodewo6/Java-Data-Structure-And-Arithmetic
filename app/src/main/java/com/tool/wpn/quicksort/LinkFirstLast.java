package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/7/30.
 * 双端链表中链结点
 */

public class LinkFirstLast {
    public double dData;
    public LinkFirstLast next;//下一个结点
    public LinkFirstLast(double dd){
        dData=dd;
    }

    /**
     * 展示链接点
     */
    public void displayLink(){
        Log.i("LinkFirstLast",dData+"");
    }

}

package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by XiJie on 2017/8/1.
 * 双向链表中的结点
 */

public class LinkDouble {
    public double dData;
    public LinkDouble next;//下一个结点
    public LinkDouble previous;//上一个结点
    public LinkDouble(double dd){
        dData=dd;
    }
    public void displayLink(){
        Log.i("LinkDouble",dData+"");
    }

}

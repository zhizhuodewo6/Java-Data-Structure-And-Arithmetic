package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by XiJie on 2017/8/1.
 * 使用链表实现栈中的链表结点
 */

public class LinkStack {
    public double dData;
    public LinkStack next;//下一个结点
    public LinkStack(double dd){
        dData=dd;
    }

    /**
     * 展示链接点
     */
    public void displayLink(){
        Log.i("LinkStack",dData+"");
    }

}

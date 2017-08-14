package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/7/30.
 * 使用链表实现栈中的链表
 */

public class LinkListStack {
    private static final String TAG="LinkListStack";
    private LinkStack first;//单链表的第一个元素
    public LinkListStack(){
        first=null;
    }

    /**
     * 在链表链首插入元素
     * @param dd
     */
    public void insertFirst(double dd){
        LinkStack newLink=new LinkStack(dd);//创建一个新链接点
        newLink.next=first;//将原先的首连接点排到新链接点后面
        first=newLink;//链表新元首连接点为新插入的链接点
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty(){
        return first==null;
    }

    /**
     * 删除连接点，从链表首删除
     */
    public double deleteFirst(){
        LinkStack temp=first;
        first=first.next;
        return temp.dData;
    }

    /**
     * 展示链表
     */
    public void displayList(){
        Log.i(TAG,"List (first-->last):");
        LinkStack current=first;
        while(current!=null){
            current.displayLink();
            current=current.next;
        }
    }

}

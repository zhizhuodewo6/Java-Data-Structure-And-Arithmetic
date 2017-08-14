package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/7/30.
 * 双端链表实现队列的链表
 */

public class LinkListQueue {
    private static final String TAG="LinkListQueue";
    private LinkFirstLast first;//链表的first标志结点，即首结点
    private LinkFirstLast last;//链表的last标志结点，即末尾结点
    public LinkListQueue(){
        first=null;
        last=null;
    }

    /**
     * 在链表链尾插入元素
     */
    public void insertLast(double dd){
        LinkFirstLast newLink=new LinkFirstLast(dd);//创建一个新链接点
        if(isEmpty()){//如果是空链表
            first=newLink;
        }else{
            last.next=newLink;
        }
        last=newLink;
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
        double temp=first.dData;
        if(first.next==null){
            last=null;
        }
        first=first.next;
        return temp;
    }

    /**
     * 展示链表
     */
    public void displayList(){
        Log.i(TAG,"List (first-->last):");
        LinkFirstLast current=first;
        while(current!=null){
            current.displayLink();
            current=current.next;
        }
    }

}

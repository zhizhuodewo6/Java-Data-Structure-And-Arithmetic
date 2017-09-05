package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/8/1.
 * 使用链表实现队列的队列
 */

public class QueueLink {
    private LinkListQueue theList;
    public QueueLink(){
        theList=new LinkListQueue();
    }
    public boolean isEmpty(){
        return theList.isEmpty();
    }
    public void insert(double dd){
        theList.insertLast(dd);
    }
    public double remove(){
        return theList.deleteFirst();
    }
    public void displayQueue(){
        Log.v("QueueLink","QueueLink (front-->rear):");
        theList.displayList();
    }
}

package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/7/30.
 * 有序链表
 */

public class LinkListOrderly {
    private static final String TAG="LinkListOrderly";
    private LinkFirstLast first;//单链表的第一个元素
    public LinkListOrderly(){
        first=null;
    }

    /**
     * 插入元素
     * @param dd
     */
    public void insert(double dd){
        LinkFirstLast newLind=new LinkFirstLast(dd);
        LinkFirstLast previous=null;//前一个元素
        LinkFirstLast current=first;
        while(current!=null&&dd>current.dData){//当前元素小于要插入的元素，继续找
            previous=current;
            current=current.next;
        }
        if(previous==null) {
            first = newLind;
        }else {
            previous.next = newLind;
        }
        newLind.next=current;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty(){
        return first==null;
    }

    /**
     * 删除元素
     * @return
     */
    public LinkFirstLast remove(){
        LinkFirstLast temp=first;
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

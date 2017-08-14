package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/8/1.
 * 用链表实现栈
 */

public class StackLink {
    private LinkListStack theList;
    public StackLink(){
        theList=new LinkListStack();
    }

    /**
     * 添加元素
     */
    public void push(double dd){
        theList.insertFirst(dd);
    }

    /**
     * 取出元素
     */
    public double pop(){
        return theList.deleteFirst();
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty(){
        return theList.isEmpty();
    }

    /**
     * 展示栈
     */
    public void displayStack(){
        Log.v("StackLink","StackLink (top-->bottom):");
        theList.displayList();
    }
}

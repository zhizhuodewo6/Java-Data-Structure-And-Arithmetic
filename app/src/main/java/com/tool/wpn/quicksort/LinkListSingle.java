package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/7/30.
 * 单链表
 */

public class LinkListSingle {
    private static final String TAG="LinkListSingle";
    private LinkSingle first;//单链表的第一个元素
    public LinkListSingle(){
        first=null;
    }

    /**
     * 在链表链首插入元素
     * @param id
     * @param dd
     */
    public void insertFirst(int id,double dd){
        LinkSingle newLink=new LinkSingle(id,dd);//创建一个新链接点
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
    public LinkSingle deleteFirst(){
        LinkSingle temp=first;
        first=first.next;
        return temp;
    }

    /**
     * 查找连结点
     */
    public LinkSingle find(int key){
        LinkSingle current=first;
        while(current.iData!=key){//循环找
            if(current.next==null){//未找到，返回null
                return null;
            }else{
                current=current.next;
            }
        }
        return current;//找到返回
    }

    /**
     * 删除对应的结点
     */
    public LinkSingle delete(int key){
        LinkSingle current=first;
        LinkSingle previous=first;//上一个结点，用于当找到要删除的结点，好将该节点与别删除结点的下一个结点链接。
        while(current.iData!=key){//查找被删除的结点
            if(current.next==null){//未找到要删除的结点返回null
                return null;
            }else{
                previous=current;
                current=current.next;
            }
        }
        if(current==first)first=first.next;//被删除的结点为元首结点
        else previous.next=current.next;
        return current;
    }

    /**
     * 展示链表
     */
    public void displayList(){
        Log.i(TAG,"List (first-->last):");
        LinkSingle current=first;
        while(current!=null){
            current.displayLink();
            current=current.next;
        }
        Log.i(TAG,"");
    }

}

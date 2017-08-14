package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by XiJie on 2017/8/1.
 * 双向链表
 */

public class LinkListDouble {
    private LinkDouble first;
    private LinkDouble last;
    public LinkListDouble(){
        first=null;
        last=null;
    }
    public boolean isEmpty(){
        return first==null;
    }

    /**
     * 从首插入一个结点
     * @param dd
     */
    public void insertFirst(double dd){
        LinkDouble newLink=new LinkDouble(dd);
        if(isEmpty()){
            last=newLink;
        }else{
            first.previous=newLink;
        }
        newLink.next=first;
        first=newLink;
    }

    /**
     * 从尾插入一个结点
     * @param dd
     */
    public void insertLast(double dd){
        LinkDouble newLink=new LinkDouble(dd);
        if(isEmpty()){
            first=newLink;
        }else{
            last.next=newLink;
            newLink.previous=last;
        }
        last=newLink;
    }

    /**
     * 删除第一个结点
     * @return
     */
    public LinkDouble deleteFirst(){
        LinkDouble temp=first;
        if(first.next==null){//删完以后，整个链表没有元素了
            last=null;
        }else{
            first.next.previous=null;//将下一个元素的previous至为空，由于First元素以被删除
        }
        first=first.next;
        return temp;
    }

    /**
     * 删除最后一个结点
     * @return
     */
    public LinkDouble deleteLast(){
        LinkDouble temp=last;
        if(first.next==null){//删完以后，整个链表没有元素了
            first=null;
        }else{
            last.previous.next=null;
        }
        last=last.previous;
        return temp;
    }

    /**
     * 插入到指定项的后面
     * kk即为要找的数据项，dd就插在它的后面
     * 正常情况下需要修改四个引用，及新插入结点的previous、next，新结点的上一个结点的next，新结点下一个结点的previous
     * @return
     */
    public boolean insertAfter(double key,double dd){
        LinkDouble current=first;
        while(current.dData!=key){
            current=current.next;
            if(current==null){
                return false;//退出方法，插入失败
            }
        }
        LinkDouble newLink=new LinkDouble(dd);
        if(current==last){
            newLink.next=null;
            last=newLink;
        }else{
            newLink.next=current.next;//修改新插入结点的next引用
            current.next.previous=newLink;//修改新插入结点下一个结点的previous引用
        }
        newLink.previous=current;//修改新插入结点的previous引用
        current.next=newLink;//修改新插入结点上一个结点的next引用。
        return true;
    }

    /**
     * 删除链表的指定项
     */
    public LinkDouble deleteKey(double key){
        LinkDouble current=first;
        while(current.dData!=key){
            current=current.next;
            if(current==null){
                return null;//没有找到，退出方法
            }
        }
        if(current==first){//如果被删除的结点是第一个
            first=current.next;
        }else{
            current.previous.next=current.next;
        }
        if(current==last){//如果被删除的结点是最后一个
            last=current.previous;
        }else{
            current.next.previous=current.previous;
        }
        return current;
    }

    /**
     * 从前向后显示
     */
    public void displayFroward(){
        Log.v("LinkListDouble","list(first-->last):");
        LinkDouble current=first;
        while(current!=null){
            current.displayLink();
            current=current.next;
        }
    }

    /**
     * 从后向前显示
     */
    public void displayBackword(){
        Log.v("LinkListDouble","list(last-->first):");
        LinkDouble current=last;
        while(current!=null){
            current.displayLink();
            current=current.previous;
        }
    }
}

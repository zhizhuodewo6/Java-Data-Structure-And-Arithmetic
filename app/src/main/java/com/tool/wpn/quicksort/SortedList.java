package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/8/16.
 * 有序链表，链地址式哈希表所用
 * 按LindHash 的key 值大小进行有序排序
 */

public class SortedList {
    private final String TAG="SortedList";
    private LinkHash first;//第一个元素
    public SortedList(){
        first=null;
    }
    public void insert(LinkHash theLink){
        int key=theLink.getKey();
        LinkHash previous=null;
        LinkHash current=first;
        while(current!=null&&key>current.getKey()){//当前元素不为空，且需添加的元素大于当前元素，继续寻找位置
            previous=current;
            current=current.next;
        }
        //找到该放的位置
        if(previous==null){//即该链表无元素
            first=theLink;
        }else{
            previous.next=theLink;
            theLink.next=current;
        }
    }

    public void delete(int key){
        LinkHash previous=null;
        LinkHash current=first;
        while(current!=null&&key!=current.getKey()){
            previous=current;
            current=current.next;
        }
        if(previous==null){//若要删除的元素为第一个
            first=first.next;
        }else{
            previous.next=current.next;
        }
    }

    public LinkHash find(int key){
        LinkHash current=first;
        while(current!=null&&current.getKey()<=key){
            if(current.getKey()==key){
                return current;//找到
            }
            current=current.next;
        }
        return null;
    }

    public void display(){
        StringBuilder sb=new StringBuilder();
        sb.append("SortedList{");
        LinkHash current=first;
        while(current!=null){
            sb.append(current.getKey());
            sb.append(",");
            current=current.next;
        }
        sb.append("}");
        Log.v(TAG,sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("{");
        LinkHash current=first;
        while(current!=null){
            sb.append(current.getKey());
            sb.append(",");
            current=current.next;
        }
        sb.append("}");
        return sb.toString();
    }
}

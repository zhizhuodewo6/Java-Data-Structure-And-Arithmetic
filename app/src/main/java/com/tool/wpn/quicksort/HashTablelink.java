package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/8/16.
 * 链地址式哈希表
 */

public class HashTablelink {
    private final String TAG="HashTablelink";
    private SortedList[] hashArray;
    private int arraySize;
    public HashTablelink(int size){
        arraySize=size;
        hashArray=new SortedList[arraySize];
        for(int i=0;i<arraySize;i++){
            hashArray[i]=new SortedList();
        }
    }

    public void displayTable(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int j=0;j<arraySize;j++){
            sb.append(hashArray[j].toString());
            sb.append(",");
        }
        sb.append("]");
        Log.v(TAG,"HastTableLink的值为："+sb.toString());
    }

    /**
     * 首次哈希
     * 将传入的key经过hash算法，这里使用的普通除以数组大小求余的方法，而实际不是这么简单
     * @param key
     * @return
     */
    public int hashFunc(int key){
        return key%arraySize;
    }

    /**
     * 插入元素
     */
    public void insert(LinkHash item){
        int key=item.getKey();
        int hashVal=hashFunc(key);//哈希到的下标位置
        hashArray[hashVal].insert(item);
    }

    /**
     * 删除元素
     */
    public void delete(int key){
        int hashVal=hashFunc(key);//哈希到的下标位置
        hashArray[key].delete(key);
    }

    /**
     * 查找元素
     */
    public LinkHash find(int key){
        int hashVal=hashFunc(key);//哈希到的下标位置
        LinkHash theLink=hashArray[hashVal].find(key);
        return theLink;
    }

}

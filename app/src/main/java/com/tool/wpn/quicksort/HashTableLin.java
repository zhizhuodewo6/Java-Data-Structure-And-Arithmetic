package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/8/15.
 * 线性探测哈希表
 */

public class HashTableLin {
    private final String TAG="HashTableLin";
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;//无元素，由于底层使用的数组，在真正删除元素时，也不是真正删除该内存空间，而是将其所含值改变，代表删除该元素
    public HashTableLin(int size){
        arraySize=size;
        hashArray=new DataItem[arraySize];
        nonItem=new DataItem(-1);
    }

    public void displayTable(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<arraySize;i++){
            if(i==arraySize-1){
                if(hashArray[i]!=null) {
                    sb.append(hashArray[i].getKey() + "");
                }else {
                    sb.append("** ");
                }
            }
            else {
                if(hashArray[i]!=null) {
                    sb.append(hashArray[i].getKey() + "");
                }else {
                    sb.append("** ");
                }
                sb.append(",");
            }
        }
        sb.append("]");
        Log.v("HashTableLin",sb.toString());
    }

    /**
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
    public void insert(DataItem item){
        int key=item.getKey();
        int hashVal=hashFunc(key);
        while(hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1){//位置被占用
            //继续寻找位置
            hashVal++;
            hashVal=hashVal%arraySize;
        }
        hashArray[hashVal]=item;//找到位置
    }

    /**
     * 删除元素
     */
    public DataItem delete(int key){
        int hashVal=hashFunc(key);
        while(hashArray[hashVal]!=null){
            if(hashArray[hashVal].getKey()==key){//找到要删除的数据
                DataItem temp=hashArray[hashVal];
                hashArray[hashVal]=nonItem;
                return temp;
            }
            hashVal++;
            hashVal=hashVal%arraySize;
        }
        return null;//没有找到
    }

    /**
     * 查找元素
     */
    public DataItem find(int key){
        int hashVal=hashFunc(key);
        while(hashArray[hashVal]!=null){
            if(hashArray[hashVal].getKey()==key){
                return hashArray[hashVal];//找到元素
            }
            hashVal++;
            hashVal=hashVal%arraySize;
        }
        return null;//没有找到
    }




}

package com.tool.wpn.quicksort;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by XiJie on 2017/8/12.
 * 有序数组二分查找
 */

public class ArrayOrderBinary {
    private long[] orderArray;//有序数组
    private int nElems;//数组里元素数量，没插入一个才会增加
    public ArrayOrderBinary(int max){
        orderArray=new long[max];
        nElems=0;
    }

    /**
     * 数组中元素数量
     * @return
     */
    public int size(){
        return nElems;
    }

    /**
     * 查找指定元素的位置
     * @return
     */
    public int find(long searchKey){
        int lowerBound=0;
        int upperBound=nElems-1;
        int curIn;
        while(true){
            curIn=(lowerBound+upperBound)/2;
            if(orderArray[curIn]==searchKey)//找到了，正是curIn
                return curIn;
            else if(lowerBound>upperBound)///没找到
                return nElems;//返回大于最大索引整数
            else{
                if(orderArray[curIn]<searchKey)//往后查找
                    lowerBound=curIn+1;
                else//往前查找
                    upperBound=curIn-1;
            }
        }
    }

    /**
     * 插入元素
     */
    public void insert(long value){
        int inseartLoc;//别插入的位置
        for(inseartLoc=0;inseartLoc<nElems;inseartLoc++)
            if(orderArray[inseartLoc]>value)break;//若当前数组元素大于被插入元素，则继续往后移动，寻找位置，直到找到位置
        for(int k=nElems;k>inseartLoc;k--){//将inseartLoc后面的元素都往后移动一位
            orderArray[k]=orderArray[k-1];
        }
        orderArray[inseartLoc]=value;
        nElems++;
    }

    /**
     * 展示有序数组
     */
    public void display(){
        Log.i("ArrayOrderBinary","orderArray值为："+ Arrays.toString(orderArray));
    }
}

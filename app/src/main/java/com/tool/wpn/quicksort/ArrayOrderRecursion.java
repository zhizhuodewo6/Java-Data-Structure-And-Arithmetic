package com.tool.wpn.quicksort;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by XiJie on 2017/8/12.
 * 递归二分查找
 */

public class ArrayOrderRecursion {
    private long[] orderArray;//有序数组
    private int nElems;//数组里元素数量，没插入一个才会增加
    public ArrayOrderRecursion(int max){
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
        return recFind(searchKey,0,nElems-1);
    }

    /**
     * 递归查找方法
     * @param serachKey 被查找元素
     * @param lowerRound 最小范围，即查找起点
     * @param upperRound 最大范围，即查找尾端
     * @return
     */
    private int recFind(long serachKey,int lowerRound,int upperRound){
        int curIn;//中间位置
        curIn=(lowerRound+upperRound)/2;
        if(orderArray[curIn]==serachKey)//若中间位置正是要查找的元素
            return curIn;
        else if(lowerRound>upperRound)//若最小起点大于最大尾端，则表明没有找到指定元素
            return nElems;
        else{//继续递归查找
            if(orderArray[curIn]>serachKey)//中间位置元素大于被查找的元素，则从中间位置左边的范围继续递归查找
                return recFind(serachKey,lowerRound,curIn-1);
            else//若中间位置的元素小于被查找的元素，则从中间位置右侧继续递归查找元素
                return recFind(serachKey,curIn+1,upperRound);
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
        Log.i("ArrayOrderRecursion","orderArray值为："+ Arrays.toString(orderArray));
    }
}

package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by XiJie on 2017/8/13.
 * 快速排序
 */

public class ArrayQuick {
    private long[] theArray;//需排序的数组
    private int nElems;//数组所函元素大小
    public ArrayQuick(int max){
        theArray=new long[max];
        nElems=0;
    }

    /**
     * 插入元素
     * @param value
     */
    public void insert(long value){
        theArray[nElems]=value;
        nElems++;
    }

    /**
     * 展示数组
     */
    public void display(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<nElems;i++){
            if(i==nElems-1)
                sb.append(theArray[i]);
            else {
                sb.append(theArray[i]);
                sb.append(",");
            }
        }
        sb.append("]");
        Log.v("ArrayQuick",sb.toString());
    }

    /**
     * 快速排序
     */
    public void quickSort(){
        recQuickSort(0,nElems-1);
    }

    /**
     * 用递归和划分技术进行快速排序
     */
    public void recQuickSort(int left,int right){
        int size=right-left+1;

        if(size<=10){//如果需排序的数量小于10，则使用插入排序，提高效率
            insertionSort(left,right);
        }else{
            long pivot=medianOf3(left,right);//取分隔点值
            int partition=partitionIt(left,right,pivot);
            recQuickSort(left,partition-1);//递归 前一部分再划分
            recQuickSort(partition+1,right);//递归 后一部分再划分
        }
    }

    /**
     * 三项数据取中，并将中间的数放到数组最右侧用于后面的比较基数
     */
    private long medianOf3(int left,int right){//三项数组取中
        int center=(left+right)/2;
        if(theArray[left]>theArray[center])swap(left,center);
        if(theArray[left]>theArray[right])swap(left,right);
        if(theArray[center]>theArray[right])swap(center,right);
        swap(center,right-1);
        return theArray[right-1];
    }

    /**
     * 按照pivot比较基数，开始从左到右，与从右到左开始对数据进行比较交换
     * @param left
     * @param right
     * @param pivot
     * @return
     */
    private int partitionIt(int left,int right,long pivot){
        int leftPtr=left;
        int rightPtr=right-1;
        while(true){
            while(theArray[++leftPtr]<pivot);//从左侧找大于基数的数
            while(theArray[--rightPtr]>pivot);//从右侧找小于基数的数
            if(leftPtr>=rightPtr)break;//未找到，退出
            else swap(leftPtr,rightPtr);//以找到，左右交换
        }
        swap(leftPtr,right-1);//将比较基数放到中间位置
        return  leftPtr;
    }

    /**
     * 插入排序，
     */
    public void insertionSort(int left,int right){
        int in,out;
        for(out=left+1;out<=right;out++){
            long temp=theArray[out];
            in=out;
            while(in>left && theArray[in-1]>temp){
                theArray[in]=theArray[in-1];
                --in;
            }
            theArray[in]=temp;
        }
    }

    /**
     * 交换俩元素
     * @param m
     * @param n
     */
    private void swap(int m, int n) {
        long temp = theArray[m];
        theArray[m] = theArray[n];
        theArray[n] = temp;
    }


}

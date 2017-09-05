package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/8/13.
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
     * 参数为数组中的下标
     */
    public void recQuickSort(int left,int right){
        int size=right-left+1;
        if(size<=10){//如果需排序的数量小于10，则使用插入排序，提高效率
            insertionSort(left,right);
        }else{
            medianOf3(left,right);//取分隔点值,将最左边坐标的数设为为分割值
            if(left<right){
                int i=left,j=right;//i,j分别为左右移动标志
                long temp=theArray[i];//分割值，咱存起来，因为要用他所在下标空间作为空间用于小大俩数的交换
                while(i<j){
                    //从右向左找小于基准值theArray[i]的元素
                    while(i<j&&theArray[j]>temp)
                        j--;
                    if(i<j)
                        theArray[i++]=theArray[j];//找到小于基准数的元素，将其放到数组中的空位置，第一次为基准数的位置
                    //从左向右找大于基准值theArray[i]d的元素
                    while(i<j&&theArray[i]<temp)
                        i++;
                    if(i<j)
                        theArray[j--]=theArray[i];//找到大于基准数的元素
                }
                //将基准数填入最后的坑中
                theArray[i]=temp;
                //递归调用，分治法的思想
                recQuickSort(left,i-1);
                recQuickSort(i+1,right);
            }
        }
    }

    /**
     * 三项数据取中，并将中间的数放到数组最左侧用于后面的比较基数
     * 参数为数组中的下标
     */
    public void medianOf3(int left,int right){//三项数组取中
        int center=(left+right+1)/2;
        if(theArray[center]>theArray[left])swap(center,left);
        if(theArray[center]>theArray[right])swap(center,right);
        if(theArray[left]>theArray[right])swap(left,right);
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

package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by XiJie on 2017/8/12.
 * 归并排序
 */

public class ArrayMerge {
    private long[] theArray;//需排序的数组
    private int nElems;//数组所函元素大小
    public ArrayMerge(int max){
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
        Log.v("ArrayMerge",sb.toString());
    }

    /**
     * 归并开始排序
     */
    public void mergeSort(){
        long[] workSpace=new long[nElems];//创建一个数组空间，用户归并排序使用
        recMergeSort(workSpace,0,nElems-1);
    }

    /**
     *左右拆分数组与归并
     * 界限范围都使用的是数组下标
     */
    private void recMergeSort(long[] workSpace,int lowerBound,int upperBound){
        if(lowerBound==upperBound)return;//若左边界==右边界，退出，即以划分为最小部分，无法再左右划分
        else{
            int mid=(lowerBound+upperBound)/2;
            recMergeSort(workSpace,lowerBound,mid);//递归前半部分排序处理
            recMergeSort(workSpace,mid+1,upperBound);//递归后半部分排序处理
            merge(workSpace,lowerBound,mid+1,upperBound);
        }
    }

    /**
     * 将左右排序完的数组合并成一个
     * @param workspace
     * @param lowPtr
     * @param highPtr
     * @param upperBound
     */
    private void merge(long[] workspace,int lowPtr,int highPtr,int upperBound){
        int j=0;
        int lowerBound=lowPtr;
        int mid=highPtr-1;
        int n=upperBound-lowerBound+1;//要归并的数量，由于lowerBound代表的数组下角标，所以需要加1
        while(lowPtr<=mid&&highPtr<=upperBound){//从左半部分的起点，又半部分起点，开始比对大小，直到左半部分或右半部分元素比对完即结束循环
            if(theArray[lowPtr]<theArray[highPtr])
                workspace[j++]=theArray[lowPtr++];
            else
                workspace[j++]=theArray[highPtr++];
        }
        while(lowPtr<=mid)//若左半部分未循环比较完，则将剩下的部分元素添加排序完的数组中
            workspace[j++]=theArray[lowPtr++];
        while(highPtr<=upperBound)//若右半部分未循环比较完，则将剩下的元素添加到排序完的数组中
            workspace[j++]=theArray[highPtr++];
        for(j=0;j<n;j++)
            theArray[lowerBound+j]=workspace[j];//将排序完毕的元素复制到theArry真正在的位置中
    }
}

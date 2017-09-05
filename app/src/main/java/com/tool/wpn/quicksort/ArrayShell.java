package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/8/13.
 * 希尔排序
 */

public class ArrayShell {
    private long[] theArray;
    private int nElems;
    public ArrayShell(int max){
        theArray=new long[max];
        nElems=0;
    }
    public void insert(long value){
        theArray[nElems]=value;
        nElems++;
    }
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
        Log.v("ArrayShell",sb.toString());
    }

    /**
     * 希尔排序
     */
    public void shellSort(){
        int inner,outer;
        long temp;
        int h=1;//俩数比较的间隔，插入排序是1，从头比较到尾，而希尔排序不是，是从大间隔到小间隔变化
        while(h<=nElems/3)//计算最大间隔,如果100个数据，则n=40
            h=h*3+1;//1 4 13 40
        while(h>0){//循环间隔进行间隔有序排序，依次按40、13、4、1间隔来进行插入排序
            for(outer=h;outer<nElems;outer++){//进行间隔排序，每次进行左右各一个数进行交换，他们的间隔是h
                temp=theArray[outer];
                inner=outer;
                while(inner>h-1 && theArray[inner-h]>=temp){//如果左边数大于右边数进行交换
                    theArray[inner]=theArray[inner-h];
                    inner-=h;
                }
                theArray[inner]=temp;//如果左边数不大于右边数就不用交换
            }
            h=(h-1)/3;//调整间隔
        }
    }
}

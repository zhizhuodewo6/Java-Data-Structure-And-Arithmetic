package com.tool.wpn.quicksort;

import android.util.Size;

/**
 * Created by Xi on 2017/7/29.
 * 队列-图广度搜索用
 */

public class QueueGraph {
    private int[] queArray;
    private int maxSize;//队列最大值
    private int front;//队首
    private int rear;//队尾
    public QueueGraph(int size){//用户指定队列最大数
        maxSize=size;
        queArray=new int[maxSize];
        front=0;//默认对首为0，因为队列里没有元素
        rear=-1;//默认队尾为-1
    }

    /**
     * 插入元素，调用该接口之前需判断队列是否已满。
     */
    public void insert(int element){
        if(rear==maxSize-1)
            rear=-1;//若元素以插到数组最后一位，则重置rear;
        queArray[++rear]=element;
    }

    /**
     * 删除元素，调用该接口之前需判断队列是否有元素
     */
    public int remove(){
        int temp=queArray[front++];//取出被删除的元素放入临时变量中，
        if(front==maxSize)
            front=0;//若以将队列中元素删除完，就重置front;
        return temp;
    }

    /**
     * 访问元素
     */
    public long peekFront(){
        return queArray[front];
    }

    /**
     * 队列是否为空
     */
    public boolean isEmpty(){
        return (rear+1==front||front+ maxSize-1==rear);
    }

}

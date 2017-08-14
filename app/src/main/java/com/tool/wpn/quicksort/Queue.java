package com.tool.wpn.quicksort;

/**
 * 该队列底层是通过数组实现的，可指定大小。
 * 是通过front与rear指针来实现元素的添加与删除，每次添加与删除不会真正的移动数组元素的位置。
 * Created by Xi on 2017/7/29.
 */

public class Queue {
    private long[] queArray;
    private int maxSize;//队列最大值
    private int front;//队首
    private int rear;//队尾
    private int nItems;//以有元素总数
    public Queue(int size){//用户指定队列最大数
        maxSize=size;
        queArray=new long[maxSize];
        front=0;//默认对首为0，因为队列里没有元素
        rear=-1;//默认队尾为-1
        nItems=0;
    }

    /**
     * 插入元素，调用该接口之前需判断队列是否已满。
     */
    public void insert(long element){
        if(rear==maxSize-1)rear=-1;//若元素以插到数组最后一位，则重置rear;
        queArray[++rear]=element;
        nItems++;
    }

    /**
     * 删除元素，调用该接口之前需判断队列是否有元素
     */
    public long remove(){
        long temp=queArray[front++];//取出被删除的元素放入临时变量中，
        if(front==maxSize)front=0;//若以将队列中元素删除完，就重置front;
        nItems--;
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
        return nItems==0;
    }

    /**
     * 判断队列是否以满
     */
    public boolean isFull(){
        return nItems==maxSize;
    }
}

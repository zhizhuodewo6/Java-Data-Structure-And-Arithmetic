package com.tool.wpn.quicksort;

/**
 * Created by Xi on 2017/7/29.
 * 优先级队列，及队列中的元素是有顺序的。跟普通队列相比，主要是插入元素时，需找到对应的位置才能插。
 */

public class PriorQueue {
    private long[] queArray;
    private int maxSize;//队列最大值
    private int nItems;//以有元素总数
    public PriorQueue(int size){//用户指定队列最大数
        maxSize=size;
        queArray=new long[maxSize];
        nItems=0;
    }

    /**
     * 插入元素，调用该接口之前需判断队列是否已满。
     */
    public void insert(long element){
        int loc;//要插入的位置
        if(nItems==0){//队列为空，没有元素
            queArray[nItems++]=element;
        }else{//以有元素，需要找对应的位置
            for(loc=nItems-1;loc>=0;loc--){//开始循环，从上往下找，
                if(element>queArray[loc]){//未找到，将元素上移
                    queArray[loc+1]=queArray[loc];// 2
                }else{
                    break;
                }
            }
            queArray[loc+1]=element;//由于loc位置有元素，而且loc+1位置的元素以通过上述2处上移，所以直接插入
            nItems++;
        }
    }

    /**
     * 删除元素，调用该接口之前需判断队列是否有元素
     */
    public long remove(){
        return queArray[--nItems];
    }

    /**
     * 访问元素
     */
    public long peekMin(){
        return queArray[nItems-1];
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

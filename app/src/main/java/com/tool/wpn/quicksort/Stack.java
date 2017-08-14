package com.tool.wpn.quicksort;

/**
 * Created by Xi on 2017/7/29.
 * 栈
 */

public class Stack {
    private long[] stackArray;
    private int maxSize;//栈最大容量
    private int top;//栈顶
    public Stack(int size){
        maxSize=size;
        stackArray=new long[maxSize];
        top=-1;
    }

    /**
     * 添加元素
     */
    public void push(long element){
        stackArray[++top]=element;
    }

    /**
     * 查看并删除
     */
    public long pop(){
        return stackArray[top--];
    }

    /**
     * 查看
     */
    public long peek(){
        return stackArray[top];
    }

    /**
     * 是否为空
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * 是否以满
     */
    public boolean isFull(){
        return top==maxSize-1;
    }
}

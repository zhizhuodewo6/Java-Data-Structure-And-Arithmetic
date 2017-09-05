package com.tool.wpn.quicksort;

/**
 * Created by Xi on 2017/7/29.
 * 栈-图深度搜索用
 */

public class StackGraph {
    private int[] stackArray;
    private int maxSize;//栈最大容量
    private int top;//栈顶
    public StackGraph(int size){
        maxSize=size;
        stackArray=new int[maxSize];
        top=-1;
    }

    /**
     * 添加元素
     */
    public void push(int element){
        stackArray[++top]=element;
    }

    /**
     * 查看并删除
     */
    public int pop(){
        return stackArray[top--];
    }

    /**
     * 查看
     */
    public int peek(){
        return stackArray[top];
    }

    /**
     * 是否为空
     */
    public boolean isEmpty(){
        return top==-1;
    }
}

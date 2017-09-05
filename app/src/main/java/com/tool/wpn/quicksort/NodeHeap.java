package com.tool.wpn.quicksort;

/**
 * Created by Xi on 2017/8/17.
 * 堆节点
 */

public class NodeHeap {
    private int iData;
    public NodeHeap(int key){
        iData=key;
    }
    public int getKey(){
        return iData;
    }
    public void setKey(int id){
        iData=id;
    }

}

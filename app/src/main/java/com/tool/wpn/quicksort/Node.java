package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by XiJie on 2017/8/13.
 * 树中结点
 */

public class Node {
    public int iData;//结点id
    public double dData;//结点值
    public Node leftChild;//左子结点
    public Node rightChild;//右子结点
    public void displayNode(){
        StringBuilder sb=new StringBuilder();
        sb.append("{").append(iData).append(",").append(dData).append("}");
        Log.v("Node",sb.toString());
    }
}

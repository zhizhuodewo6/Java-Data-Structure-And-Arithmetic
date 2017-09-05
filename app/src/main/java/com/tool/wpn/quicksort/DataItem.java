package com.tool.wpn.quicksort;

/**
 * Created by Xi on 2017/8/15.
 * 哈希表所使用元素
 */

public class DataItem {
    private int iData;
    public DataItem(int key){
        iData=key;
    }
    public int getKey(){
        return iData;
    }

    @Override
    public String toString() {
        return "DataItem-key值为："+iData;
    }
}

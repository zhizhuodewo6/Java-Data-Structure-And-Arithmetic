package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/8/16.
 * 链地址哈希表中的链表
 */

public class LinkHash {
    private int iData;
    public LinkHash next;
    public LinkHash(int it){
        iData=it;
    }
    public int getKey(){
        return iData;
    }
    public void displayLink(){
        Log.v("LinkHash","iData:"+iData);
    }
}

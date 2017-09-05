package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by Xi on 2017/8/15.
 * 再哈希法哈希表
 */

public class HashTableAgain {
    private final String TAG="HashTableAgain";
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;//无元素，由于底层使用的数组，在真正删除元素时，也不是真正删除该内存空间，而是将其所含值改变，代表删除该元素
    public HashTableAgain(int size){
        arraySize=size;
        hashArray=new DataItem[arraySize];
        nonItem=new DataItem(-1);
    }

    public void displayTable(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<arraySize;i++){
            if(i==arraySize-1){
                if(hashArray[i]!=null) {
                    sb.append(hashArray[i].getKey() + "");
                }else {
                    sb.append("** ");
                }
            }
            else {
                if(hashArray[i]!=null) {
                    sb.append(hashArray[i].getKey() + "");
                }else {
                    sb.append("** ");
                }
                sb.append(",");
            }
        }
        sb.append("]");
        Log.v(TAG,sb.toString());
    }

    /**
     * 首次哈希
     * 将传入的key经过hash算法，这里使用的普通除以数组大小求余的方法，而实际不是这么简单
     * @param key
     * @return
     */
    public int hashFunc(int key){
        return key%arraySize;
    }

    /**
     * 二次哈希，即再次哈希
     */
    public int hashFunc2(int key){
        //再次哈希原则 sepSize=constant-(key%constant);
        //constant是质数，且小于数组容量
        return 5-key%5;
    }

    /**
     * 插入元素
     */
    public void insert(DataItem item){
        int key=item.getKey();
        int hashVal=hashFunc(key);//首次哈希到的下标位置
        int stepSize=hashFunc2(key);//再次哈希得到的探测步长
        while(hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1){//位置被占用
            //继续寻找位置
            hashVal+=stepSize;
            hashVal=hashVal%arraySize;
        }
        hashArray[hashVal]=item;//找到位置
    }

    /**
     * 删除元素
     */
    public DataItem delete(int key){
        int hashVal=hashFunc(key);//首次哈希到的下标位置
        int stepSize=hashFunc2(key);//再次哈希得到探测步长
        while(hashArray[hashVal]!=null){
            if(hashArray[hashVal].getKey()==key){//找到要删除的数据
                DataItem temp=hashArray[hashVal];
                hashArray[hashVal]=nonItem;
                return temp;
            }
            hashVal+=stepSize;
            hashVal=hashVal%arraySize;
        }
        return null;//没有找到
    }

    /**
     * 查找元素
     */
    public DataItem find(int key){
        int hashVal=hashFunc(key);//首次哈希到的下标位置
        int stepSize=hashFunc2(key);//再次哈希得到探测步长
        while(hashArray[hashVal]!=null){
            if(hashArray[hashVal].getKey()==key){
                return hashArray[hashVal];//找到元素
            }
            hashVal+=stepSize;
            hashVal=hashVal%arraySize;
        }
        return null;//没有找到
    }




}

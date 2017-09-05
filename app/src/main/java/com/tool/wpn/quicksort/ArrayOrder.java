package com.tool.wpn.quicksort;

/**
 * 有序数组的Java代码
 */

/**
 * 对于数组这种数据结构，
 * 线性查找的话，时间复杂度为O(N)，
 * 二分查找的话时间为O(longN)，
 * 数组插入的时间复杂度为O(N)，例如：你插入的是第一位，你需要将后续元素移动。
 * 删除操作的时间复杂度均为O(N)。
 * @author dream
 *
 */
public class ArrayOrder {

    private long[] a;
    private int size;   //数组的大小
    private int nElem;  //数组中有多少项

    public ArrayOrder(int max){   //初始化数组
        this.a = new long[max];
        this.size = max;
        this.nElem = 0;
    }

    public int size(){   //返回数组实际有多少值
        return this.nElem;
    }

    /**
     * 二分查找
     * @param searchNum
     * @return
     */
    public int find(long searchNum){
        int lower = 0;
        int upper = nElem - 1;//最大位置
        int curr;
        while (true) {
            curr = (lower + upper) / 2;//得到中间位置
            if(a[curr] == searchNum){
                return curr;
            }else if(lower > upper){
                return -1;
            }else {
                if(a[curr] < searchNum){
                    lower = curr + 1;
                }else {
                    upper = curr - 1;
                }
            }
        }
    }


    public boolean insert(long value){   //插入某个值
        if(nElem == size){
            System.out.println("数组已满!");
            return false;
        }
        int j;
        for(j = 0; j < nElem; j++){
            if(a[j] > value){//找到该插入的位置
                break;
            }
        }

        for(int k = nElem; k > j; k++){//将大于j位置的数往后依次排，为j位置腾空
            a[k] = a[k-1];
        }
        a[j] = value;
        nElem++;
        return true;
    }



    public boolean delete(long value){   //删除某个值
        int j = find(value);
        if(j == -1){
            System.out.println("没有该元素!");
            return false;
        }

        if(nElem == size){
            for(int k = j; k < nElem - 1; k++){
                a[k] = a[k+1];
            }
            a[nElem-1] = 0;
        }else {
            for(int k = j; k < nElem; k++){
                a[k] = a[k+1];
            }
        }
        nElem--;
        return true;
    }


    public void display(){   //打印整个数组
        for(int i = 0; i < nElem; i++){
            System.out.println(a[i] + " ");
        }
        System.out.println("");
    }
}

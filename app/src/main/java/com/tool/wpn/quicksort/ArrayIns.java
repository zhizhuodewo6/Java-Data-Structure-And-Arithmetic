package com.tool.wpn.quicksort;

/**
 * Created by XiJie on 2017/7/26.
 */

public class ArrayIns{
    private long[] theArray;
    public int mElems;//控制为数组添加元素的角标，若数组大小为16，则这个值为15
    public ArrayIns(int max){
        theArray=new long[max];
        mElems=0;
    }

    /**
     * 添加元素
     */
    public void insert(long value){
        theArray[mElems]=value;
        mElems++;
    }

    /**
     * 展示数组
     */
    public void display(){
        System.out.println("Array=");
        for(int i=0;i<mElems;i++){
            System.out.print(theArray[i]+" ");
        }
        System.out.println("");
    }

    /**
     * 快速排序
     */
    public void quickSort(){
        recQucikSort(0,mElems-1);//0,14
    }

    /**
     * 用递归和划分技术进行快速排序
     */
    public void recQucikSort(int left,int right){
        int size=right-left+1;//获取数组大小
        if(size<=3){//如果小于3位就手动排序
            manualSort(left,right);
        }else{//大于3位使用递归排序
            long median=medianOf3(left,right);//获得中间位数，用这个树而对元素进行划分
            int partition=partitionIt(left,right,median);
            recQucikSort(left,partition-1);
            recQucikSort(partition+1,right);
        }
    }

    /**
     * 从三个值中取2中间值
     */
    public long medianOf3(int left,int right){
        int center=(left+right)/2;
        if(theArray[left]>theArray[center])swap(left,center);
        if(theArray[left]>theArray[right])swap(left,right);
        if(theArray[center]>theArray[right])swap(center,right);
        swap(center,right-1);//将取到的中间值放到最后一位
        return theArray[right-1];//返回中间值
    }

    /**
     * 手动排序
     */
    private void manualSort(int left,int right){
        int size=right-left+1;//要排序的元素的数量
        if(size<=1)return;
        if(size==2){
            if(theArray[left]>theArray[right])swap(left,right);
            return;
        }else{
            if(theArray[left]>theArray[right-1])swap(left,right-1);//第一个与第二个比
            if(theArray[left]>theArray[right])swap(left,right);//第一个与第三个比
            if(theArray[right-1]>theArray[right])swap(right-1,right);//第二个与第三个比
        }
    }

    /**
     * 根据中间数pivot，去找左右可以替换的位置
     */
    public int partitionIt(int left,int right,long pivot){
        int leftPtr=left-1;
        int rightPtr=right;
        while(true){
            while(theArray[++leftPtr]<pivot);
            while(rightPtr>0&&theArray[--rightPtr]>pivot);
            if(leftPtr>=rightPtr)break;
            else swap(leftPtr,rightPtr);//交换
        }
        swap(leftPtr,rightPtr);
        return leftPtr;
    }

    /**
     * 俩数进行交换
     */
    private void swap(int left ,int right){
        long temp=theArray[left];
        theArray[left]=theArray[right];
        theArray[right]=temp;
    }

}

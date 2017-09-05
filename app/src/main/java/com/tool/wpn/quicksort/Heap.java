package com.tool.wpn.quicksort;

/**
 * Created by Xi on 2017/8/17.
 * 堆，数据结构是树，底层用数组实现
 */

public class Heap {
    private NodeHeap[] heapArray;
    private int maxSize;//最大容纳元素个数
    private int currentSize;//当前现有元素个数
    public Heap(int max){
        maxSize=max;
        currentSize=0;
        heapArray=new NodeHeap[maxSize];
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        return currentSize==0;
    }

    /**
     * 插入节点
     */
    public boolean insert(int key){
        if(currentSize==maxSize)return false;//满了
        NodeHeap newNode=new NodeHeap(key);
        heapArray[currentSize]=newNode;//新节点放到数组最后位置，即数最底层
        trickleUP(currentSize);//把新节点进行比较向上调整
        currentSize++;//数据项数量增加一个
        return true;
    }
    /**
     * 向上调整节点，将其放到应该在的位置，因为子节点必须的小于父节点
     */
    private void trickleUP(int index){
        int parent=(index-1)/2;//index节点的父节点
        NodeHeap bottom=heapArray[index];//暂存index节点数据
        while(index>0&&heapArray[parent].getKey()<bottom.getKey()){//若未到根节点，并且父节点值小于子节点值，则做调整
            heapArray[index]=heapArray[parent];
            index=parent;//子父节点做颠倒调整
            parent=(parent-1)/2;//从求父节点位置
        }
        heapArray[index]=bottom;
    }

    /**
     * 删除根节点
     */
    public NodeHeap remove(){
        NodeHeap root=heapArray[0];
        heapArray[0]=heapArray[--currentSize];//把最后一个数据项移到根
        trickleDown(0);//把新的根位置的数据项进行比较向下调整
        return root;
    }

    /**
     * 向下调整
     * 即从根往下一层一层的寻找该在的位置
     */
    private void trickleDown(int index){
        int largerChild;//最大的子节点的位置
        NodeHeap top=heapArray[index];//暂存要向下调整的节点对象
        while(index<currentSize/2){//从根往下走，直到最底的一层
            int leftChild=2*index+1;//左子节点
            int rightChild=leftChild+1;//右子节点
            if(rightChild<currentSize&&heapArray[leftChild].getKey()<heapArray[rightChild].getKey()){//左子点小于右子节点
                largerChild=rightChild;
            }else{//右子节点小于左子节点
                largerChild=leftChild;
            }
            //找到位置，停止循环
            if(top.getKey()>=heapArray[largerChild].getKey())break;
            //未找到位置，继续循环找
            heapArray[index]=heapArray[largerChild];//将大的子节点的值赋给他的根节点，即上移
            index=largerChild;
        }
        heapArray[index]=top;//将top值赋给最终找到的位置
    }

    /**
     * 修改节点值
     * @param index
     * @param newValue
     * @return
     */
    public boolean change(int index,int newValue){
        if(index<0||index>=currentSize){//无效位置
            return false;
        }
        int oldValue=heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if(oldValue<newValue){
            trickleUP(index);
        }else{
            trickleDown(index);
        }
        return true;
    }

    public void displayHeap(){
        //以树状方式显示
        int nBlanks=32;
        int itemsPerRow=1;
        int colum=0;
        int j=0;
        String dots="................................";
        System.out.println(dots+dots);
        while(currentSize>0){
            if(colum==0){
                for(int k=0;k<nBlanks;k++)
                    System.out.print(' ');
            }
            System.out.print(heapArray[j].getKey());
            if(++j==currentSize)break;//全部打印完成
            if(++colum==itemsPerRow){//这层数据须打印完
                nBlanks/=2;
                itemsPerRow*=2;
                colum=0;
                System.out.println();
            }else{
                for(int k=0;k<nBlanks*2-2;k++)System.out.print(' ');
            }
        }
        System.out.println("\n"+dots+dots);
    }

}

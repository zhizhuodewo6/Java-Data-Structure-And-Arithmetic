package com.tool.wpn.quicksort;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;

public class MainActivity extends Activity implements View.OnClickListener {
    private final String TAG = "MainActivity";
    private Button btn_orderarry_binarysearch,btn_simple_sort_bubble,btn_simple_sort_select,btn_simple_sort_insert,btn_queue, btn_stack, btn_queue_prior, btn_link_single,btn_link_firtlast,btn_link_stack,
            btn_link_orderly,btn_link_queue,btn_link_double,btn_find_recursion,btn_tower_recursion,btn_sort_merge,btn_sort_shell,
            btn_sort_quick,btn_sort_radix;
    private ImageView iv_radix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_orderarry_binarysearch = (Button) findViewById(R.id.btn_orderarry_binarysearch);
        btn_simple_sort_bubble = (Button) findViewById(R.id.btn_simple_sort_bubble);
        btn_simple_sort_select = (Button) findViewById(R.id.btn_simple_sort_select);
        btn_simple_sort_insert = (Button) findViewById(R.id.btn_simple_sort_insert);
        btn_queue = (Button) findViewById(R.id.btn_queue);
        btn_stack = (Button) findViewById(R.id.btn_stack);
        btn_queue_prior = (Button) findViewById(R.id.btn_queue_prior);
        btn_link_single = (Button) findViewById(R.id.btn_link_single);
        btn_link_firtlast = (Button) findViewById(R.id.btn_link_firtlast);
        btn_link_stack = (Button) findViewById(R.id.btn_link_stack);
        btn_link_queue = (Button) findViewById(R.id.btn_link_queue);
        btn_link_orderly = (Button) findViewById(R.id.btn_link_orderly);
        btn_link_double = (Button) findViewById(R.id.btn_link_double);
        btn_find_recursion = (Button) findViewById(R.id.btn_find_recursion);
        btn_tower_recursion = (Button) findViewById(R.id.btn_tower_recursion);
        btn_sort_merge = (Button) findViewById(R.id.btn_sort_merge);
        btn_sort_shell = (Button) findViewById(R.id.btn_sort_shell);
        btn_sort_quick = (Button) findViewById(R.id.btn_sort_quick);
        btn_sort_radix = (Button) findViewById(R.id.btn_sort_radix);
        iv_radix = (ImageView) findViewById(R.id.iv_radix);
        btn_orderarry_binarysearch.setOnClickListener(this);
        btn_simple_sort_bubble.setOnClickListener(this);
        btn_simple_sort_select.setOnClickListener(this);
        btn_simple_sort_insert.setOnClickListener(this);
        btn_queue.setOnClickListener(this);
        btn_stack.setOnClickListener(this);
        btn_queue_prior.setOnClickListener(this);
        btn_link_single.setOnClickListener(this);
        btn_link_firtlast.setOnClickListener(this);
        btn_link_stack.setOnClickListener(this);
        btn_link_queue.setOnClickListener(this);
        btn_link_orderly.setOnClickListener(this);
        btn_link_double.setOnClickListener(this);
        btn_find_recursion.setOnClickListener(this);
        btn_tower_recursion.setOnClickListener(this);
        btn_sort_merge.setOnClickListener(this);
        btn_sort_shell.setOnClickListener(this);
        btn_sort_quick.setOnClickListener(this);
        btn_sort_radix.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int[] array;//需排序数组
        switch (view.getId()) {
            case R.id.btn_orderarry_binarysearch://有序数组二分查找
                orderarryBinarySearch();
                break;
            case R.id.btn_simple_sort_bubble://简单排序-冒泡排序
                array=new int[]{3,2,4,1,0,5,7,6,20,15,18,8,12,13,11,9,10,16,17};
                sortSimpleBubble(array);
                break;
            case R.id.btn_simple_sort_select://简单排序-选择排序
                array=new int[]{3,2,4,1,0,5,7,6,20,15,18,8,12,13,11,9,10,16,17};
                sortSimpleSelect(array);
                break;
            case R.id.btn_simple_sort_insert://简单排序-插入排序
                array=new int[]{3,2,4,1,0,5,7,6,20,15,18,8,12,13,11,9,10,16,17};
                sortSimpleInsert(array);
                break;
            case R.id.btn_queue://队列
                queue();
                break;
            case R.id.btn_queue_prior://优先级队列
                queuePrior();
                break;
            case R.id.btn_stack://栈
                stack();
                break;
            case R.id.btn_link_single://单链表
                link_single();
                break;
            case R.id.btn_link_firtlast://双端链表
                link_firtlast();
                break;
            case R.id.btn_link_stack://用单链表实现栈
                link_stack();
                break;
            case R.id.btn_link_queue://用双端链表实现栈
                link_queue();
                break;
            case R.id.btn_link_orderly://有序链表
                link_orderly();
                break;
            case R.id.btn_link_double://双向链表
                link_double();
                break;
            case R.id.btn_find_recursion://递归二分查找
                find_recursion();
                break;
            case R.id.btn_tower_recursion://递归解决汉诺塔问题
                int nDisks=3;//塔层数，即盘数
                tower_recursion(nDisks,'A','B','C');
                break;
            case R.id.btn_sort_merge://归并排序
                sortMerge();
                break;
            case R.id.btn_sort_shell://希尔排序
                sortShell();
                break;
            case R.id.btn_sort_quick://快速排序
                sortQuick();
                break;
            case R.id.btn_sort_radix://基数排序
                iv_radix.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    /**
     * 有序数组二分查找
     */
    private void orderarryBinarySearch(){
        ArrayOrderBinary orderArray=new ArrayOrderBinary(20);
        orderArray.insert(12);
        orderArray.insert(55);
        orderArray.insert(2);
        orderArray.insert(3);
        orderArray.insert(5);
        orderArray.insert(88);
        orderArray.insert(13);
        int searchKey=55;
        if(orderArray.find(searchKey)!=orderArray.size())//找到
            Log.v(TAG,"Found"+searchKey);
        else
            Log.v(TAG,"Can't find"+searchKey);
    }

    /**
     * 简单排序-冒泡排序
     *
     * @param array
     */
    private void sortSimpleBubble(int[] array) {
        int count = 0;
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = size - 1; j > i; j--) {
                count++;
                if (array[j] < array[j - 1]) {
                    swapArray(array, j, j - 1);
                }
            }
        }

        Log.v(TAG, "array值为：" + Arrays.toString(array) + ";count值为：" + count);
    }

    /**
     * 简单排序-选择排序
     */
    private void sortSimpleSelect(int[] array) {
        int minIndex = 0;
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {//循环比较的数，从左往右走
            minIndex = i;//作为标志记住每次比出来的最小的数位置
            for (int j = i + 1; j < size; j++) {//被比较的数
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {//如果minIndex!=i说明找到了比i小的数
                swapArray(array, minIndex, i);
            }
        }
        Log.v(TAG, "array值为：" + Arrays.toString(array));
    }

    /**
     * 简单排序-插入排序
     */
    private void sortSimpleInsert(int[] array) {
        int length = array.length;
        int in, out;
        for (out = 1; out < length; out++) {//假设第一个位置的数是正确的，从第二个数开始插入比较
            in = out;
            int temp = array[out];
            while (in > 0 && array[in - 1] > temp) {//如果in数据大于temp，说明temp应插在in位置前面，所以可以断定in前面还有可能有比temp大，而比in位置数小的数，所及继续循环
                array[in] = array[in - 1];//交换位置数据
                in--;
            }
            array[in] = temp;//最终找到out该在的位置
        }

        Log.v(TAG, "array值为：" + Arrays.toString(array));
    }

    /**
     * 调用队列
     */
    private void queue() {
        int size = 3;
        Queue queue = new Queue(size);
        if (!queue.isFull()) queue.insert(10);//插入元素
        if (!queue.isFull()) queue.insert(40);
        if (!queue.isFull()) queue.insert(50);
        if (!queue.isFull()) queue.insert(60);

        while (!queue.isEmpty()) {//移除元素
            long remove = queue.remove();
            Log.v(TAG, "被移除的元素为：" + remove);
        }
        if (!queue.isFull()) queue.insert(70);
        if (!queue.isFull()) queue.insert(80);
        if (!queue.isEmpty()) {//取出元素
            long l = queue.peekFront();
            Log.v(TAG, "看到的元素为：" + l);
        }
    }

    /**
     * 优先级队列
     */
    private void queuePrior() {
        int size = 3;
        PriorQueue queue = new PriorQueue(size);
        if (!queue.isFull()) queue.insert(10);//插入元素
        if (!queue.isFull()) queue.insert(40);
        if (!queue.isFull()) queue.insert(20);
        if (!queue.isFull()) queue.insert(30);

        while (!queue.isEmpty()) {//移除元素
            long remove = queue.remove();
            Log.v(TAG, "被移除的元素为：" + remove);
        }
        if (!queue.isFull()) queue.insert(70);
        if (!queue.isFull()) queue.insert(80);
        if (!queue.isEmpty()) {//取出元素
            long l = queue.peekMin();
            Log.v(TAG, "看到的元素为：" + l);
        }
    }

    /**
     * 调用栈
     */
    private void stack() {
        Stack stack = new Stack(4);
        if (!stack.isFull()) stack.push(10);
        if (!stack.isFull()) stack.push(20);
        if (!stack.isFull()) stack.push(30);
        if (!stack.isFull()) stack.push(40);
        if (!stack.isFull()) stack.push(50);
        while (!stack.isEmpty()) {
            long pop = stack.pop();
            Log.v(TAG, "取出删除的元素为：" + pop);
        }
        if (!stack.isFull()) stack.push(60);
        if (!stack.isFull()) stack.push(70);
        if (!stack.isEmpty()) {
            long peek = stack.peek();
            Log.v(TAG, "取出元素为：" + peek);
        }
    }

    /**
     * 单链表
     */
    private void link_single() {
        //创建链表，并添加结点。
        LinkListSingle theList = new LinkListSingle();
        theList.insertFirst(11, 1.99);
        theList.insertFirst(22, 2.99);
        theList.insertFirst(33, 3.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(55, 5.99);
        theList.displayList();
        //循环删除结点，直到删光
        Log.i(TAG,"Deleted ");
        while (!theList.isEmpty()) {
            LinkSingle aLink = theList.deleteFirst();
            aLink.displayLink();
        }
        //添加结点
        theList.insertFirst(66, 6.99);
        theList.insertFirst(77, 7.99);
        //寻找结点
        LinkSingle linkSingle = theList.find(66);
        if(linkSingle!=null)Log.v(TAG,"Found link with key"+linkSingle.iData);
        else Log.v(TAG,"Can't find Link");
        //删除结点
        LinkSingle delete = theList.delete(66);
        if(delete!=null)Log.v(TAG,"Deleted link with key"+ delete.iData);
        else Log.v(TAG,"Can't delete link");

    }

    /**
     * 双端链表
     */
    public void link_firtlast(){
        //创建链表，并添加结点。
        LinkListFirstLast theList = new LinkListFirstLast();
        theList.insertFirst(11);
        theList.insertFirst(22);
        theList.insertFirst(33);
        theList.insertFirst(44);
        theList.insertLast(55);
        theList.displayList();
        //循环删除结点，直到删光
        Log.i(TAG,"Deleted ");
        while (!theList.isEmpty()) {
            double dd = theList.deleteFirst();
            Log.i(TAG,"Deleted data"+dd);
        }
    }

    /**
     * 用链表实现栈
     */
    public void link_stack(){
        StackLink theStack=new StackLink();
        theStack.push(20);
        theStack.push(30);
        theStack.displayStack();
        theStack.push(40);
        theStack.push(50);
        theStack.displayStack();
        theStack.pop();
        theStack.pop();
        theStack.displayStack();
    }

    /**
     * 用双端链表实现队列
     */
    public void link_queue(){
        QueueLink theQueue=new QueueLink();
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.displayQueue();
        theQueue.insert(40);
        theQueue.insert(50);
        theQueue.displayQueue();
        theQueue.remove();
        theQueue.remove();
        theQueue.displayQueue();
    }

    /**
     * 有序链表
     */
    public void link_orderly(){
        LinkListOrderly theLink=new LinkListOrderly();
        theLink.insert(20);
        theLink.insert(40);
        theLink.displayList();
        theLink.insert(30);
        theLink.insert(60);
        theLink.displayList();
        theLink.remove();
        theLink.displayList();
    }

    /**
     * 双向链表
     */
    private void link_double(){
        LinkListDouble theLink=new LinkListDouble();
        theLink.insertFirst(22);
        theLink.insertFirst(33);
        theLink.insertFirst(44);
        theLink.insertLast(55);
        theLink.insertLast(66);
        theLink.insertLast(77);
        theLink.displayFroward();
        theLink.displayBackword();
        theLink.deleteFirst();
        theLink.displayFroward();
        theLink.deleteLast();
        theLink.displayFroward();
        theLink.deleteKey(55);
        theLink.displayFroward();
    }

    /**
     * 递归二分查找
     */
    private void find_recursion(){
        ArrayOrderRecursion orderArray=new ArrayOrderRecursion(100);
        orderArray.insert(70);
        orderArray.insert(50);
        orderArray.insert(93);
        orderArray.insert(10);
        orderArray.insert(110);
        orderArray.insert(112);
        orderArray.insert(80);
        orderArray.insert(120);
        orderArray.insert(180);
        orderArray.display();
        long searchKey=1;
        if(orderArray.find(searchKey)!=orderArray.size())//找到
            Log.v(TAG,"二分递归查找找到指定元素");
        else
            Log.v(TAG,"二分递归查找未找到指定元素");
    }

    /**
     * 递归解决汉诺塔问题
     * @param topN 第几层盘子
     * @param from 原柱
     * @param inter 临时柱
     * @param to 目标柱
     */
    private void tower_recursion(int topN,char from,char inter,char to){
        if(topN==1)//若为塔底（最底层的盘子），即则将其直接挪到目标柱
            Log.v(TAG,"Disk 1 from "+from+" to "+to);
        else{
            tower_recursion(topN-1,from,to,inter);//先放到临时柱
            Log.v(TAG,"Disk "+topN+" from "+from+" to "+to);
            tower_recursion(topN-1,inter,from,to);//然后从临时柱放到目标柱
        }
    }

    /**
     * 归并排序，使用递归
     * 原理为：使用递归原理，将数组从中间分为两部分，然后分别对左右两部分进行排序，然后再将左右两部分进行合并。
     * 具体步骤就是，先将数组从中间利用递归分为左右，直到分成最小的左右部分，即左1个元素，右一个元素。
     * 然后再将划分的最小部分进行合并，合并成有序。
     * 按照上一步的合并办法，从小范围到大范围，最终合并成有序的数组。
     * 时间复杂度为：O(N*logN)，即需排序的数组大小为10000，则需要40000
     */
    private void sortMerge(){
        ArrayMerge array=new ArrayMerge(20);
        array.insert(20);
        array.insert(10);
        array.insert(30);
        array.insert(40);
        array.insert(5);
        array.insert(7);
        array.insert(50);
        array.insert(90);
        array.insert(110);
        array.insert(8);
        array.insert(130);
        array.insert(70);
        array.display();
        array.mergeSort();
        array.display();
    }

    /**
     * 希尔排序
     * 是在插入排序的基础上的升级。是带有间隔的插入排序。
     * 首先按照
     */
    private void sortShell(){
        int maxSize=20;
        ArrayShell array=new ArrayShell(maxSize);
        for(int i=0;i<maxSize;i++){//随机赋值
            long num=(int)(Math.random()*99);
            array.insert(num);
        }
        array.display();
        array.shellSort();//调用希尔排序
        array.display();
    }

    /**
     * 快速排序
     */
    private void sortQuick(){
        int maxSize=50;
        ArrayQuick array=new ArrayQuick(maxSize);
        for(int i=0;i<maxSize;i++){//随机赋值
            long num=(int)(Math.random()*99);
            array.insert(num);
        }
        array.display();
        array.quickSort();//调用快速排序
        array.display();
    }

    /**
     * 交换俩元素
     * @param array
     * @param m
     * @param n
     */
    private void swapArray(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }

}

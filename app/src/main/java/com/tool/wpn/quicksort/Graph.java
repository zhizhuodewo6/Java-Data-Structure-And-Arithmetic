package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by xi on 2017/8/19.
 * 图
 */

public class Graph {
    private final int MAX_VERTS=20;//最大顶点树
    private Vertex[] vertexList;//顶点数组
    private int adjMat[][];//邻接矩阵，即顶点之间的关系矩阵
    private int nVerts;//当前顶点数量
    private StackGraph theStack;//深度优先搜索用的栈
    private QueueGraph theQueue;//广度优先搜索用的队列
    public Graph(){
        //初始化上述对象
        vertexList=new Vertex[MAX_VERTS];
        adjMat=new int[MAX_VERTS][MAX_VERTS];
        for(int j=0;j<MAX_VERTS;j++){
            for(int k=0;k<MAX_VERTS;k++){
                adjMat[j][k]=0;
            }
        }
        theStack=new StackGraph(MAX_VERTS);
        theQueue=new QueueGraph(MAX_VERTS);
    }

    /**
     * 添加顶点
     */
    public void addVertex(char lab){
        vertexList[nVerts++]=new Vertex(lab);
    }

    /**
     * 添加边
     */
    public void addEdge(int start,int end){
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }

    /**
     * 展示顶点
     */
    public void displayVertex(int v){
        Log.v("Graph",vertexList[v].label+"");
    }

    /**
     * 获取指定顶点相邻的一个未被访问过的顶点
     * @param v
     * @return
     */
    private int getAdjUnvisitedVertex(int v){
        for(int j=0;j<nVerts;j++)
            if(adjMat[v][j]==1&&vertexList[j].wasVisited==false)
                return j;//找到一个与v顶点相邻接的未访问的顶点位置
        return -1;//未找到
    }

    /**
     * 深度优化搜索
     */
    public void dfs(){
        vertexList[0].wasVisited=true;//第一个顶点被访问后将标志修改为访问过
        displayVertex(0);//显示访问的顶点
        theStack.push(0);//将访问过的顶点放入栈中
        while(!theStack.isEmpty()){//栈不为空
            int v=getAdjUnvisitedVertex(theStack.peek());
            if(v==-1)//未找到
                theStack.pop();//从栈中移除
            else{
                vertexList[v].wasVisited=true;
                displayVertex(v);
                theStack.push(v);//添加到栈中，继续找
            }
        }
        //深度搜索完毕后，将图中各个顶点状态恢复为未被访问过
        for(int j=0;j<nVerts;j++){
            vertexList[j].wasVisited=false;
        }
    }


    /**
     * 广度优先搜索
     */
    public void bfs(){
        vertexList[0].wasVisited=true;//第一个顶点被访问后将标志修改为访问过
        displayVertex(0);//显示访问的顶点
        theQueue.insert(0);//将访问过的顶点放入栈中
        int v2;
        while(!theQueue.isEmpty()){//队列不为空
            int v1=theQueue.remove();
            while((v2=getAdjUnvisitedVertex(v1))!=-1){
                vertexList[v2].wasVisited=true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        //广度搜索完毕后，将图中各个顶点状态恢复为未被访问过
        for(int j=0;j<nVerts;j++){
            vertexList[j].wasVisited=false;
        }
    }

    /**
     * 最小生成树
     */
    public void mst(){
        vertexList[0].wasVisited=true;
        theStack.push(0);
        while(!theStack.isEmpty()){
            int currentVertex=theStack.peek();
            int v=getAdjUnvisitedVertex(currentVertex);
            if(v==-1)//没有找到邻接的没有访问过的顶点
                theStack.pop();
            else{
                vertexList[v].wasVisited=true;
                theStack.push(v);
                displayVertex(currentVertex);
                displayVertex(v);
                Log.v("Graph"," ");
            }
        }
        //最小生成树完毕后，将图中各个顶点状态恢复为未被访问过
        for(int j=0;j<nVerts;j++){
            vertexList[j].wasVisited=false;
        }

    }

}

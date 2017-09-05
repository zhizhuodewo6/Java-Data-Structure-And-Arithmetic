package com.tool.wpn.quicksort;

import android.util.Log;

/**
 * Created by xi on 2017/8/19.
 * 图-有向图、拓扑排序
 */

public class GraphTopo {
    private final int MAX_VERTS=20;//最大顶点树
    private Vertex[] vertexList;//顶点数组
    private int adjMat[][];//邻接矩阵，即顶点之间的关系矩阵
    private int nVerts;//当前顶点数量
    private char[] sortedArray;//排序完后的字符数组
    public GraphTopo(){
        //初始化上述对象
        vertexList=new Vertex[MAX_VERTS];
        adjMat=new int[MAX_VERTS][MAX_VERTS];
        for(int j=0;j<MAX_VERTS;j++){
            for(int k=0;k<MAX_VERTS;k++){
                adjMat[j][k]=0;
            }
        }
        sortedArray=new char[MAX_VERTS];
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
    }

    /**
     * 展示顶点
     */
    public void displayVertex(int v){
        Log.v("Graph",vertexList[v].label+"");
    }

    /**
     * 拓扑排序
     */
    public void topo(){
        int orig_nVerts=nVerts;
        while(nVerts>0){
            int currentVertex=noSuccessors();
            if(currentVertex==-1){//找不到没有后继顶点的顶点了
                Log.v("GraphTopo","Error:GraphTopo has cycles");
                return;//退出方法
            }
            sortedArray[nVerts-1]=vertexList[currentVertex].label;
            deleteVertex(currentVertex);//从图中删除当前顶点
        }
        Log.v("GraphTopo","Topologically sorted order");
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int j=0;j<orig_nVerts;j++){
            sb.append(sortedArray[j]).append(",");
        }
        sb.append("]");
        Log.v("GraphTopo","sortedArray值为："+sb.toString());
    }

    /**
     * 查看图中没有后继顶点的顶点
     * 通过矩阵中顶点之间的关系来寻找，即一个顶点与其他顶点的关系全为0，即无关系
     * @return
     */
    private int noSuccessors(){
        boolean isEdge;
        for(int row=0;row<nVerts;row++){//行
            isEdge=false;
            for(int col=0;col<nVerts;col++){//列
                if(adjMat[row][col]>0){
                    isEdge=true;
                    break;
                }
            }
            if(!isEdge){
                return row;//找到一个无后继顶点的顶点。
            }
        }
        return -1;
    }

    /**
     * 从矩阵中将相关的列、行删除
     * @param delVert
     */
    private void deleteVertex(int delVert){
        if(delVert!=nVerts-1){//要删除的顶点不是最后一个就要处理邻接矩阵
            for(int j=delVert;j<nVerts-1;j++){
                vertexList[j]=vertexList[j+1];
            }
            for(int row=delVert;row<nVerts-1;row++){//把邻接矩阵中删除行后面行向上移动
                moveRowUp(row,nVerts);
            }
            for(int col=delVert;col<nVerts-1;col++){//把列左移
                moveColLeft(col,nVerts-1);
            }
        }
        nVerts--;//数量递减
    }

    /**
     * 将行上移
     * @param row
     * @param length
     */
    private void moveRowUp(int row,int length){
        for(int col=0;col<length;col++)
            adjMat[row][col]=adjMat[row+1][col];
    }

    /**
     * 列左移
     * @param col
     * @param lenght
     */
    private void moveColLeft(int col,int lenght){
        for(int row=0;row<lenght;row++){
            adjMat[row][col]=adjMat[row][col+1];
        }
    }
}

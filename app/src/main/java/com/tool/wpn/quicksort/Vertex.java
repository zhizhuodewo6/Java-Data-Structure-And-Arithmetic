package com.tool.wpn.quicksort;

/**
 * Created by xi on 2017/8/19.
 * 图元素，这里叫顶点
 */

public class Vertex {
    public char label;//顶点标签，即值
    public boolean wasVisited;//有无被访问过
    public Vertex(char lab){
        label=lab;
        wasVisited=false;
    }
}

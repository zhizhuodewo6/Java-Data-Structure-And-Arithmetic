package com.tool.wpn.quicksort;

import android.util.Log;

import java.util.Stack;

import static android.content.ContentValues.TAG;

/**
 * Created by XiJie on 2017/8/29.
 * 二叉树
 * 左子节点 < 父节点 < 右子节点
 */

public class Tree {
    private Node root;
    public Tree(){
        root=null;
    }

    /**
     * 插入一个节点
     * 树中，右子节点大于根节点，根节点大于左子节点。
     * @param id
     * @param dd
     */
    public void insert(int id,double dd){
        Node newNode=new Node();
        newNode.iData=id;
        newNode.dData=dd;
        if(root==null)//树是空的
            root=newNode;
        else{
            Node current=root;
            Node parent;
            while(true){
                parent=current;
                if(id<current.iData){//要插入的节点小于父节点，则插入左子树中
                    current=current.leftChild;
                    if(current==null){
                        parent.leftChild=newNode;
                        return;
                    }
                }else{//插入右子树中
                    current=current.rightChild;
                    if(current==null){
                        parent.rightChild=newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 删除节点
     */
    public boolean delete(int key){
        Node current=root;
        Node parent=root;
        boolean isLeftChild=true;
        while(current.iData!=key){//查找节点
            parent=current;
            if(key<current.iData){
                isLeftChild=true;
                current=current.leftChild;
            }else{
                isLeftChild=false;
                current=current.rightChild;
            }
            if(current==null)return false;//没有找到要删除的节点。
        }
        if(current.leftChild==null&&current.rightChild==null){//删除的是叶子节点
            if(current==root)root=null;//删除的是根节点，并且没有子节点
            else if(isLeftChild){//删除的叶子节点是父节点的左子节点
                parent.leftChild=null;
            }else{
                parent.rightChild=null;
            }
        }else if(current.rightChild==null){//要删除的节点只有一个左子节点
            if(current==root)root=current.leftChild;//要删除的是根节点
            else if(isLeftChild)parent.leftChild=current.leftChild;//要删除的节点是父节点的左子节点
            else parent.rightChild=current.leftChild;//要删除的节点是父节点的右子节点
        }else if(current.leftChild==null){//要删除的节点只有一个右子节点
            if(current==root)root=current.leftChild;//要删除的是根节点
            else if(isLeftChild)parent.leftChild=current.rightChild;//要删除的节点是父节点的左子节点
            else parent.rightChild=current.rightChild;//要删除的节点是父节点的右子节点
        }else{//要删除的节点有两个子节点。找到被删除节点的右子节点，若右子节点有左子节点，则用用该左子节点替代被删除的节点，否则直接用该右子节点替代要删除的节点。
            Node successor=getSuccessor(current);//找新的节点替代要被删除的节点
            if(current==root)root=successor;//要删除的是根节点
            else if(isLeftChild)parent.leftChild=successor;//要删除的节点是父节点的左子节点
            else parent.rightChild=successor;
            successor.leftChild=current.leftChild;//由于successor替代了被删除的节点，所以被删除节点的左子节点称为了新节点的左子节点。
        }
        return true;
    }

    /**
     * 向下子节找继承者节点，
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode){
        Node successorParent=delNode;
        Node successor=delNode;
        Node current=delNode.rightChild;//从被删除节点的右子节点开始找，因为右子节点大于父节点
        while(current!=null){//循环找最小左子节点，直到找到被删除节点下子节点的最小左子节点为止。
            successorParent=successor;
            successor=current;
            current=current.leftChild;
        }
        if(successor!=delNode.rightChild){//若新替代节点不是被删除节点的右子树节点，即被删除节点的下面子节点有左子节点
            successorParent.leftChild=successor.rightChild;//新节点的右子节点交给他父亲管理
            successor.rightChild=delNode.rightChild;//新节点接替被删除节点的右子节点。
        }
        return successor;
    }

    /**
     * 找节点
     * @param key
     * @return
     */
    public Node find(int key){
        Node current=root;
        while(current.iData!=key){
            if(key<current.iData){
                current=current.leftChild;
            }else{
                current=current.rightChild;
            }
            if(current==null)return null;
        }
        return current;
    }

    /**
     * 遍历树
     * @param traverseType
     */
    public void traverse(int traverseType){
        StringBuilder sb;
        switch (traverseType){
            case 1://从上至下，从左至右
                sb=new StringBuilder();
                sb.append("{");
                preOrder(root,sb);
                sb.append("}");
                Log.v(TAG,"pre traverse="+sb.toString());
                break;
            case 2:
                sb=new StringBuilder();
                sb.append("{");
                inOrder(root,sb);
                sb.append("}");
                Log.v(TAG,"in traverse="+sb.toString());
                break;
            case 3:
                sb=new StringBuilder();
                sb.append("{");
                postOrder(root,sb);
                sb.append("}");
                Log.v(TAG,"poset traverse="+sb.toString());
                break;
            default:
                break;
        }
    }



    /**
     * 从上至下，从左至右的遍历
     * @param localRoot
     */
    private void preOrder(Node localRoot,StringBuilder sb){

        if(localRoot!=null){
            sb.append(localRoot.iData+",");
            preOrder(localRoot.leftChild,sb);
            preOrder(localRoot.rightChild,sb);
        }
    }

    /**
     * 从下至上，从左至右（从小到大）
     */
    private void inOrder(Node localRoot,StringBuilder sb){
        if(localRoot!=null){
            inOrder(localRoot.leftChild,sb);
            sb.append(localRoot.iData+",");
            inOrder(localRoot.rightChild,sb);
        }
    }

    /**
     * 从下至上，从右至左
     */
    private void postOrder(Node localRoot,StringBuilder sb){
        if(localRoot!=null){
            postOrder(localRoot.rightChild,sb);
            postOrder(localRoot.leftChild,sb);
            sb.append(localRoot.iData+",");
        }
    }

    public void displayTree(){
        java.util.Stack globalStack=new Stack();
        globalStack.push(root);
        int nBlanks=32;
        boolean isRowEmpth=false;
        System.out.println("..............................");
        while(isRowEmpth==false){
            Stack localStack=new Stack();
            isRowEmpth=true;
            for(int j=0;j<nBlanks;j++){
                System.out.print(" ");
            }
            while(globalStack.isEmpty()==false){
                Node temp=(Node)globalStack.pop();
                if(temp!=null){
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild!=null||temp.rightChild!=null){
                        isRowEmpth=false;
                    }
                }else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0;j<nBlanks*2-2;j++){
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks/=2;
            while(localStack.isEmpty()==false){
                globalStack.push(localStack.pop());
            }
        }
        System.out.println(".......................................");
    }
}

package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchNoInBT 
{

    private static treenode root;

    public static class treenode 
    {

        private int data;
        private treenode left, right;

        public treenode(int data) {
            this.data = data;
        }
    }

    public static void createbinary()
    {
        treenode first = new treenode(15);
        treenode second = new treenode(20);
        treenode third = new treenode(75);
        treenode fourth = new treenode(98);
        treenode fivth = new treenode(10);
        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fivth;
    }
    
    public static void getNo(treenode root,int value)
    {
        if(root==null)
            return;
        Queue<treenode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            treenode temp=queue.poll();
            if(value==temp.data)
                System.out.println("Number is present in BT");
             if(temp.left!=null)
                 queue.offer(temp.left);
             if(temp.right!=null)
                 queue.offer(temp.right);
        }
        System.out.println("Number not present");
    }
    public static void main(String[] args) {
        SearchNoInBT.createbinary();
        SearchNoInBT.getNo(root,75);
    }
}

package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfTree {

    private static treenode root;

    public static class treenode {

        private treenode left;
        private treenode right;
        private int data;

        public treenode(int data) {
            this.data = data;
        }
    }

    public static int sizeoftree(treenode root) {
        if (root == null) {
            return 0;
        }
        Queue<treenode> q = new LinkedList<>();
        q.add(root);
        int count=1;
        while (!q.isEmpty()) {
            treenode temp = q.poll();
            if (temp.left != null) {
                q.add(temp.left);
                count++;
            }
            if (temp.right != null) {
                q.add(temp.right);
                count++;
            }
        }
        return count;

    }
    
     public static void main(String[] args) {
        treenode first=new treenode(10);
            treenode second=new treenode(20);
            treenode third=new treenode(34);
            treenode fourth=new treenode(85);
            treenode fivth=new treenode(43);
            root=first;
            first.left=second;
            first.right=third;
            second.left=fourth;
            second.right=fivth;
           int n= SizeOfTree.sizeoftree(root);
            System.out.println("The size of tree is :"+n);

}
}

package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reversetree {

    private static treenode root;

    public static class treenode {

        private treenode left;
        private treenode right;
        private int data;

        public treenode(int data) {
            this.data = data;
        }
    }

    public static void reversetreenode(treenode root) {
        if (root == null) {
            return;
        }
        Queue<treenode> q = new LinkedList<>();
        Stack<treenode> s = new Stack<treenode>();
        q.add(root);
        while (!q.isEmpty())
        {
            treenode temp = q.poll();
            if (temp.left != null) {
                q.add(temp.left);

            }
            if (temp.right != null) {
                q.add(temp.right);
            }
            s.push(temp);
        }
        while(!s.isEmpty())
        {
            System.out.print(s.pop().data+" ");
        }
        

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
            reversetree.reversetreenode(root);
            

}
}


package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ReverseBT {
    private static treenode root;
    public static class treenode
    {
        private int data;
        private treenode left,right;
        public treenode(int data)
        {
            this.data=data;
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
      public static void reversetree(treenode root)
      {
          if(root==null)
              return;
          Stack<treenode> stack=new Stack<>();
          Queue<treenode> q=new LinkedList<>();
          q.offer(root);
          while(!q.isEmpty())
          {
            
              treenode temp=q.poll();
                stack.push(temp);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
                
          }
          while(!stack.isEmpty())
          {
              treenode temp=stack.pop();
              System.out.print(temp.data+"--");
          }
      }
      public static void main(String[] args) {
        ReverseBT.createbinary();
        ReverseBT.reversetree(root);
    }
    
}

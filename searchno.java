
package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class searchno {
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
   
   public static boolean searchno(treenode root,int value)
   {
       if(root==null)
           return false;
       
       Queue<treenode> q=new LinkedList<>();
       q.add(root);
       while(!q.isEmpty())
       {
           treenode temp=q.poll();
           if(temp.data==value)
               return true;
           if(temp.left!=null)
               q.add(temp.left);
           if(temp.right!=null)
               q.add(temp.right);
       }
       return false;
       
   }
   
    public static void main(String[] args) {
        treenode first=new treenode(10);
            treenode second=new treenode(20);
            treenode third=new treenode(34);
            treenode fourth=new treenode(85);
            treenode fivth=new treenode(43);
            searchno.root=first;
            first.left=second;
            first.right=third;
            second.left=fourth;
            second.right=fivth;
            
            boolean avail=searchno.searchno(root, 4);
            System.out.println(avail);
            
            
    }
            
    
}

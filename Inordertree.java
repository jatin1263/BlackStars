
public class Inordertree {
    private treenode root;
    private class treenode{
        private treenode left;
        private treenode right;
        private int data;
        public treenode(int data)
        {
            this.data=data;
        }
    }
    
    public void createbinarytree()
    {
        treenode first=new treenode(10);
        treenode second =new treenode(20);
        treenode third=new treenode(30);
        treenode fourth=new treenode(40);
        treenode fivth=new treenode(50);
        treenode sixth=new treenode(60);
        root=first;
        first.left=second;
        first.right=third;
        second.left=fourth;
        second.right=fivth;
        third.left=sixth;
        
    }
    
    public void preorder(treenode root)
    {
        if(root==null)
        { 
            
            return;
        }
        System.out.print(root.data+"--");
        preorder(root.left);
        preorder(root.right);
        
    }
    
    public static void main(String[] args) {
        Inordertree tree=new Inordertree();
        tree.createbinarytree();
        tree.preorder(tree.root);
        
    }
    
}

public class linkedlist
{
    public static class listnode
    {
        private listnode next;
        private int data;
        public listnode(int data)
        {
            this.data=data;
            this.next=next;
        }
    }
    
    public void print(listnode head)
    {
        if(head==null)
        {
            System.out.println("list is empty");
            return;
        }
        listnode current=head;
        while(current!=null)
        {
            System.out.print(current.data+"-->");
            current=current.next;
        }
        System.out.println("null");
    }
    
    public listnode insertbeg(listnode head,int value)
    {
        listnode temp=new listnode(value);
        if(head==null)
        {
            head=temp;
            return head;
        }
        temp.next=head;
        return temp;
    }
    
    public void insertend(listnode head, int value)
    {
        listnode temp=new listnode (value);
        if(head==null)
        {
            head=temp;
            return;
        }
        listnode current=head;
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next=temp;
    }
    
    
    public static void main(String args[])
    {
        listnode first=new listnode(10);
        listnode second=new listnode(20);
        listnode third=new listnode(30);
        listnode fourth=new listnode(40);
      
        first.next=second;
        second.next=third;
        third.next=fourth;
      
        linkedlist single=new linkedlist();
        single.print(first);
        listnode newnode= single.insertbeg(first,5);
        single.print(newnode);
        single.insertend(first, 50);
        single.print(first);
    }
}
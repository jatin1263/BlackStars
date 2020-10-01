
import java.util.ArrayList;


class student
{
    int roll;
    String name;
}


public class Listdemo{
    public static void main(String args[]){
     ArrayList<String> list1=new ArrayList<String>();
     ArrayList list2=new ArrayList();
     student s1=new student();
     s1.roll=20;
     s1.name="Amay";
     
        list1.add("john");
        list1.add("jack");
        list1.add("jenni");
        list1.add("joe");
        
        list2.add("john");
        list2.add("jack");
        list2.add("jenni");
        list2.add(10);
        list2.add(2.2);
        list2.add(s1);
        
        System.out.println("list 1 is:"+list1);
        System.out.println("list 2 is :"+list2);
        
        String name=list1.get(2);
        System.out.println("name is :"+name);
        
        Object o=list2.get(3);
        System.out.println("number is :"+o);
        
        list1.set(1,"amay");
        System.out.println("New list is :"+list1);
        
        
        
        
        
     
        
    }
}
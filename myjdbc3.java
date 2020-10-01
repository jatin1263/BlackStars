
package amay.jdbc;
import java.sql.*;
import java.util.Scanner;


public class myjdbc3 {
     public  static void main(String args[])
    {
        Connection conn=null;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully !!");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//D919HZB2:1521/xe","system","amay");
            System.out.println("Connection opened !!");
            PreparedStatement ps=conn.prepareStatement("Insert into allbooks values (?,?,?,?)");
            Scanner sc =new Scanner(System.in);
            
            System.out.println("Enter book id");
            int bid=sc.nextInt();
            
            System.out.println("Enter book name");
            sc.nextLine();
            String bname=sc.nextLine();
            
            System.out.println("Enter book price");
            double amt=sc.nextDouble();
            
            System.out.println("Enter subject");
            sc.nextLine();
            String sub=sc.nextLine();
            
           
            
            
            ps.setString(2,bname);
            ps.setInt(1, bid);
            ps.setString(3, sub);
            ps.setDouble(4, amt);
            
            
            int ans=ps.executeUpdate();
            if(ans==0)
            {
                System.out.println("Sorry No book inserted");
            }
            else
                
            System.out.println("Record Inserted :"+ans);
       
        }
         catch(ClassNotFoundException cnf)
        {
            System.out.println("Cant found Class"+cnf);
        }
        catch(SQLException sql)
        {
            System.out.println("Problem in DB :"+sql);
        }
        
        finally
        {
            if(conn!=null)
            {
                try
                {
                    conn.close();
                    System.out.println("Connection closed !!");
                }
                catch(SQLException sql)
                {
                    System.out.println("Cant closed  :"+sql);
                }
            }
        }
        
    }
    
}


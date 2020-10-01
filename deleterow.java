
package amay.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class deleterow {
    public static void main(String args[])
    {
        Connection conn=null;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded!!!");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//D919HZB2:1521/xe","system","amay");
            System.out.println("Connection opened!!!");
            Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=st.executeQuery("Select bookid,bookname from allbooks");
            Scanner sc=new Scanner(System.in);
            int count=0;
            while(rs.next())
            {
                int bid=rs.getInt(1);
                String bname=rs.getString(2);
                System.out.println(bid+"---"+bname);
                System.out.println("Do you want to delete this book (y/n)");
                String choice=sc.nextLine();
                if(choice.equalsIgnoreCase("y"))
                {
                    rs.deleteRow();
                    count++;
                }
            }
            
            System.out.println("No of books deleted:"+count);
            
        }
          catch(ClassNotFoundException cnf)
        {
            System.out.println("Cant load driver !!"+cnf);
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
                    System.out.println("Connection closed !!!");
                }
                catch(SQLException sql)
                {
                    System.out.println("Cant close connection");
                }
            }
        }
            
    }
    
}

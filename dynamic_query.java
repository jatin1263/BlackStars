
package amay.jdbc;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class dynamic_query {
    public static void main(String[] args)  {
         Connection conn=null;
         try
         {
             Class.forName("oracle.jdbc.OracleDriver");
             System.out.println("Driver Loaded Successfully!!");
             conn=DriverManager.getConnection("jdbc:oracle:thin:@//D919HZB2:1521/xe","system","amay");
             System.out.println("Connection opened!!");
             PreparedStatement ps=conn.prepareStatement("Insert into emp values(?,?,?,?)");
             Scanner sc=new Scanner(System.in);
             System.out.println("Enter Emp id");
             int empid=sc.nextInt();
             System.out.println("Enter Emp name");
             sc.nextLine();
             String empname=sc.nextLine();
             System.out.println("Enter hire date (dd-MMM-YYYY)");
             String hdate=sc.nextLine();
             System.out.println("Enter sal");
             double sal=sc.nextDouble();
             ps.setInt(1, empid);
             ps.setString(2,empname);
             
             SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-YYYY");
             java.util.Date d1=sdf.parse(hdate);
             long ms=d1.getTime();
             java.sql.Date d2=new java.sql.Date(ms);
             
           
             ps.setDate(3,d2);
             ps.setDouble(4, sal);
             int ans=ps.executeUpdate();
             System.out.println("Record Inserted : "+ans);
             
             
         }
         catch(ParseException pe)
         {
             System.out.println("Error in Date conversion"+pe);
         }
         
         catch(ClassNotFoundException cnf)
         {
             System.out.println("Class Not loaded"+cnf);
         }
         catch(SQLException sql)
         {
             System.out.println("Sql Error");
             System.out.println(sql.getMessage());
         }
         finally
         {
             if(conn!=null)
             {
                 try 
                 {
                     conn.close();
                     System.out.println("Connection closed Successfully!!!");
                 }
                 catch(SQLException sql)
                 {
                     System.out.println("SQL Eroor "+sql);
                 }
             }
         }
    }
    
}

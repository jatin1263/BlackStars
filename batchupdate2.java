
package amay.jdbc;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class batchupdate2 {
     public static void main(String[] args) {
        Connection conn=null;
        boolean status=true;
        String choice=null;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully ");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//D919HZB2:1521/xe","system","amay");
            System.out.println("Connection opened");
            PreparedStatement ps=conn.prepareStatement("Insert into allbooks values(?,?,?,?)");
            conn.setAutoCommit(false);
            Scanner sc=new Scanner(System.in);
            do
            {
                System.out.println("Enter Book id");
                int bid=sc.nextInt();
                System.out.println("Enter book name");
                sc.nextLine();
                String bname=sc.nextLine();
                System.out.println("Enter subject");
                String subj=sc.nextLine();
                System.out.println("Enter price");
                double amt=sc.nextDouble();
                ps.setInt(1,bid);
                ps.setString(2,bname);
                ps.setString(3, subj);
                ps.setDouble(4,amt);
                ps.addBatch();
                System.out.println("Any more Insertion want ??(Yes/No)");
                choice=sc.next();
               
            }while(choice.equalsIgnoreCase("yes"));
            int arr []=ps.executeBatch();
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]==Statement.EXECUTE_FAILED)
                {
                    status=false;
                }
                System.out.println("Query"+(i+1)+"inserted"+arr[i]+"rows");
            }
            
        }
        catch(BatchUpdateException bue)
        {
            int array[]=bue.getUpdateCounts();
            int count=array.length+1;
            System.out.println("Query"+count+"gave exception");
            System.out.println(bue.getMessage());
            status=false;
        }
        catch(SQLException sql)
        {
            System.out.println("Sorry Problem in DB");
            System.out.println(sql.getMessage());
            status=false;
        } catch (ClassNotFoundException ex)
        {
            System.out.println("Class Not Found"+ex);
        }
        finally
        {
            if(conn!=null)
            {
                try
                {
                    if(status)
                    {
                        System.out.println("Everything is perfect committing changes");
                        conn.commit();
                    }
                    else
                    {
                        System.out.println("Something went wrong rollbacking changes");
                        conn.rollback();
                    }
                    conn.close();
                    System.out.println("Connection closed successfully");
                }
                catch(SQLException sql)
                {
                    System.out.println("Connection not closed"+sql);
                }
            }
        }
    }
    
    
}

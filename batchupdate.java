
package amay.jdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class batchupdate {
    public static void main(String[] args) {
        Connection conn=null;
        boolean status=true;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully ");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//D919HZB2:1521/xe","system","amay");
            System.out.println("Connection opened");
            Statement st=conn.createStatement();
            conn.setAutoCommit(false);
            st.addBatch("delete from allbooks where bookid>=110 ");
            st.addBatch("update employee set sal=sal+1000 where empid>=103");
            st.addBatch("insert into department values(40,'Management',30000)");
            int arr []=st.executeBatch();
            for (int i=0;i<arr.length;i++)
            {
                if(arr[i]==Statement.EXECUTE_FAILED)
                {
                    status=false;
                }
                System.out.println("Query"+(i+1)+"Effected"+arr[i]+"rows");
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

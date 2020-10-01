
package amay.jdbc;

import java.sql.*;
import java.util.Scanner;

public class myjdbc5 {
    public static void main(String args[])
    {
        Connection conn=null;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded!!!");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//D919HZB2:1521/xe","system","amay");
            System.out.println("Connection Opened !!!");
            PreparedStatement ps=conn.prepareStatement("Insert into allbooks values(?,?,?,?)");
           
            
            ps.setString(2,"MATLAB Book");
            ps.setInt(1, 111);
            ps.setString(3, "MATLAB");
            ps.setDouble(4, 400);
            
            ps.executeUpdate();
            
            
        }
        
        catch(ClassNotFoundException cnf)
        {
            System.out.println("Class not found:"+cnf);
        }
        catch(SQLException sql)
        {
            System.out.println("Problem in DB:"+sql);
        }
        
        finally
        {
            if(conn!=null)
            {
                try
                {
                    conn.close();
                    System.out.println("Connection closed!!!");
                }
                catch(SQLException ex)
                {
                    System.out.println("cant closed connection"+ex);
                }
            }
        }
    }
    
}

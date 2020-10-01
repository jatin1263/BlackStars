
package amay.jdbc;

import java.sql.*;

public class myjdbc2 
{
    public  static void main(String args[])
    {
        Connection conn=null;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully !!");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//D919HZB2:1521/xe","system","amay");
            System.out.println("Connection opened !!");
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("Select bookname,bookprice from allbooks");
            while(rs.next())
            {
                String bname=rs.getString(1);
                double amt=rs.getDouble(2);
                System.out.println(bname+"-->"+amt);
                System.out.println("======");
            }
            
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

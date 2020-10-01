
package amay.jdbc;
import java.sql.*;

public class myjdbc1 {
    public static void main(String args[])
    {
        Connection conn=null;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded !!");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//D919HZB2:1521/xe","system","amay");
            System.out.println("Connection Opened !!");
            Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=st.executeQuery("Select subject,bookprice from allbooks");
            int count=0;            
            while(rs.next())
            {
              String subject=rs.getString(1);
                  if(subject.equalsIgnoreCase("c++"))
                {
                    double amt=rs.getDouble(2);
                    amt=amt+amt*0.1;
                    rs.updateDouble(2,amt);
                    rs.updateRow();
                    count++;
                }
            }
            System.out.println("Books Updated   "+count);
            System.out.println(count);
            
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


package sit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
    public static Connection createConnection
        (String url, String username, String psw) 
        throws SQLException, ClassNotFoundException{
            
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//        System.out.println("Driver class registed successfully");
        
        Connection cn = DriverManager.getConnection(url,username, psw);
        System.out.println("Driver class registed successfully");
        return cn;
    }
        
    public static void closeConnection(Connection cn) throws SQLException{
        cn.close();
    }
        
}

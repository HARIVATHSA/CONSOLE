package Modal;

import java.sql.*;


public class Connect {
    protected static Connection conn;
    protected static Statement statement;

    public static void getConnection() throws SQLException{
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacy","root","hari2644");
            statement = conn.createStatement();
        }
        catch(Exception err) {
            System.out.println("Connection Error" + err);
        }
        
    }
        
    
}

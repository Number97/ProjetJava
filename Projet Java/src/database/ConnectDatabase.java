/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.cj.jdbc.StatementImpl;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sLaDer_pH
 */
public class ConnectDatabase {
    
    private static Connection conn; // Connector to database.
    private final StatementImpl exec; // Sql executor.
    
    public ConnectDatabase(String log, String pass) throws SQLException, ClassNotFoundException {
        
        conn = DriverManager.getConnection("jdbc:mysql://localhost/databaseprojetjava?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", log, pass); // Get connection.
        
        exec = (StatementImpl) conn.createStatement(); // Create statement to use later.
        
    }
    
    public ArrayList<String> execute(String sql) {
        
        ArrayList<String> strs = new ArrayList<>();
        
        try {
            ResultSet res = exec.executeQuery("Select * from utilisateur;");
            int nb_col = res.getMetaData().getColumnCount();

            while (res.next()) {
                String str = res.getString(1);

                for (int i = 0; i < nb_col; i++) {
                    str += ", " + res.getString(i + 1);
                }

                strs.add(str);
            }
        } catch (SQLException sqle) {
            System.out.println("Erreur sql !");
            sqle.printStackTrace();
        }
        
        return strs;
    }
    
}

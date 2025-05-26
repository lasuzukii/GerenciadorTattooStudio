
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Banco {
    private static Connection connection; 
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, utils.Constants.MSG_DRIVE, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        
        if(connection == null){
            try {
                connection = DriverManager.getConnection(utils.Constants.URL, utils.Constants.USER, utils.Constants.PASSWORD);
            } catch (SQLException ex) {
                Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, utils.Constants.MSG_BANCO_CONECTION, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return connection;
    }
}

package Code;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class mysqlConnection {
    public Connection conexion(){
        Connection con=null;

        try {
             con= DriverManager.getConnection("jdbc:mysql://127.0.1/cafeteria", "root", "");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en la conexion"+e.getMessage(),"Error con la base de datos",JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        System.out.println("Conectado");

        return con;
    }
}

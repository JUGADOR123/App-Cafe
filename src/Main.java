import Code.mysqlConnection;
import forms.Login;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        mysqlConnection conexion = new mysqlConnection();
        Connection con = conexion.conexion();
        new Login(con);

    }
}

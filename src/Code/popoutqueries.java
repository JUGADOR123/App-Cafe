package Code;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class popoutqueries {
    public DefaultTableModel mostrarProductosCategoria(Connection con, String categoria) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Producto", "Precio"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM productos WHERE categoria=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, categoria);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("codigo");
                registros[1] = rs.getString("producto");
                registros[2] = rs.getString("precio");
                modelo.addRow(registros);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return modelo;
    }


}

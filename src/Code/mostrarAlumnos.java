package Code;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class mostrarAlumnos {

    public DefaultTableModel execute(Connection con){
        String[]titulos = { "Codigo", "Nombre", "Grado", "Saldo" };
        String[] registros = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM estudiantes");
            int i=0;
            while(rs.next()){
                registros[0] = rs.getString("cod");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("grado");
                registros[3] = rs.getString("saldo");
                modelo.addRow(registros);


            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return modelo;
    }
    public DefaultTableModel filter(Connection con,String[]textos){
        String[]titulos = { "Codigo", "Nombre", "Grado", "Saldo" };
        String[] registros = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try{
            String sql = "SELECT * FROM estudiantes WHERE  `cod` LIKE ? AND `nombre` LIKE ? AND `grado` LIKE ?";
            PreparedStatement pst =con.prepareStatement(sql);
            pst.setString(1,"%"+textos[0]+"%");
            pst.setString(2,"%"+textos[1]+"%");
            pst.setString(3,"%"+textos[2]+"%");
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                registros[0] = rs.getString("cod");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("grado");
                registros[3] = rs.getString("saldo");
                modelo.addRow(registros);
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return modelo;
    }
}

package Code;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlqueries {

    public DefaultTableModel showAlumnos(Connection con) {
        //create table model for the student table
        String[] titulos = {"Codigo", "Nombre", "Grado", "Saldo"};
        String[] registros = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM estudiantes");

            while (rs.next()) {
                registros[0] = rs.getString("cod");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("grado");
                registros[3] = rs.getString("saldo");
                modelo.addRow(registros);


            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return modelo;
    }

    public DefaultTableModel filterAlumnos(Connection con, String[] textos) {
        //filter the student table model
        String[] titulos = {"Codigo", "Nombre", "Grado", "Saldo"};
        String[] registros = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            String sql = "SELECT * FROM estudiantes WHERE  `cod` LIKE ? AND `nombre` LIKE ? AND `grado` LIKE ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + textos[0] + "%");
            pst.setString(2, "%" + textos[1] + "%");
            pst.setString(3, "%" + textos[2] + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("cod");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("grado");
                registros[3] = rs.getString("saldo");
                modelo.addRow(registros);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return modelo;
    }

    public DefaultTableModel showUsuarios(Connection con) {
        //create table model for the accounts table
        String[] titulos = {"Codigo", "Nombre Completo", "Usuario", "Contraseña", "Tipo de Usuario"};
        String[] registros = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                registros[0] = rs.getString("codusuario");
                registros[1] = rs.getString("nomcompleto");
                registros[2] = rs.getString("user");
                registros[3] = rs.getString("contra");
                if (rs.getString("type").equals("1")) {
                    registros[4] = "Usuario";
                } else {
                    registros[4] = "Administrador";
                }
                modelo.addRow(registros);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return modelo;
    }

    public DefaultTableModel filterUsuarios(Connection con, String[] textos) {
        //filter the table
        String[] titulos = {"Codigo", "Nombre Completo", "Usuario", "Contraseña", "Tipo de Usuario"};
        String[] registros = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            String sql = "SELECT * FROM usuarios WHERE  `codusuario` LIKE ? AND `nomcompleto` LIKE ? AND `user` LIKE ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + textos[0] + "%");
            pst.setString(2, "%" + textos[1] + "%");
            pst.setString(3, "%" + textos[2] + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("codusuario");
                registros[1] = rs.getString("nomcompleto");
                registros[2] = rs.getString("user");
                registros[3] = rs.getString("contra");
                if (rs.getString("type").equals("1")) {
                    registros[4] = "Usuario";
                } else {
                    registros[4] = "Administrador";
                }
                modelo.addRow(registros);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return modelo;
    }

    public void updateUsuarios(Connection con, String[] textos) {
        //update a row on the table
        try {
            String sql = "UPDATE usuarios SET nomcompleto=?,user=?,contra=?,type=? WHERE codusuario=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, textos[1]);
            pst.setString(2, textos[2]);
            pst.setString(3, textos[3]);
            pst.setString(4, textos[4]);
            pst.setString(5, textos[0]);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteUsuarios(Connection con, String[] textos) {
        //delete a row on the table
        try {
            String sql = "DELETE FROM usuarios WHERE codusuario=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, textos[0]);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void crearUsuario(Connection con, String[] textos) {
        //add row on the table
        try {
            String sql = "INSERT INTO usuarios (codusuario,nomcompleto,user,contra,type) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, textos[0]);
            pst.setString(2, textos[1]);
            pst.setString(3, textos[2]);
            pst.setString(4, textos[3]);
            pst.setString(5, textos[4]);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
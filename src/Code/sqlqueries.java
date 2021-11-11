package Code;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

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
                registros[4] = rs.getString("type");
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
                registros[4] = rs.getString("type");
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
            String sql = "INSERT INTO usuarios (nomcompleto,user,contra,type) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, textos[1]);
            pst.setString(2, textos[2]);
            pst.setString(3, textos[3]);
            pst.setString(4, textos[4]);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void abonarSaldo(Connection con, String[] textos) {
        //create factura
        try {
            String sql = "INSERT INTO shortfactura (codalumno,accion,date,saldoinicial,cobro,saldofinal) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, textos[0]);
            pst.setString(2, "Abono a saldo");
            pst.setDate(3, new Date(System.currentTimeMillis()));
            pst.setString(4, textos[3]);
            pst.setString(5, textos[4]);
            pst.setString(6, textos[5]);
            pst.execute();
        } catch (Exception e) {
            System.out.println("Error al crear factura: " + e.getMessage());
        }
        try {
            String sql = "UPDATE estudiantes SET saldo=? where cod=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, textos[5]);
            pst.setString(2, textos[0]);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar saldo: " + e.getMessage());
        }
    }

    public DefaultTableModel mostrarFacturasShort(Connection con, String codigo) {
        //select facturas where codalumno=?
        String[] titulos = {"Codigo", "Fecha", "Accion", "Balance Inicial", "Total", "Balance Final"};
        String[] registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {

            String sql = "SELECT * FROM shortfactura WHERE codalumno=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("nofactura");
                registros[1] = rs.getString("date");
                registros[2] = rs.getString("accion");
                registros[3] = rs.getString("saldoinicial");
                registros[4] = rs.getString("cobro");
                registros[5] = rs.getString("saldofinal");
                modelo.addRow(registros);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return modelo;
    }

    public DefaultTableModel filterFacturaShort(Connection con, String codigo, String date) {
        //select facturas where codalumno=? and date=?
        String[] titulos = {"Codigo", "Fecha", "Accion", "Balance Inicial", "Total", "Balance Final"};
        String[] registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {

            String sql = "SELECT * FROM shortfactura WHERE codalumno=? and date=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, codigo);
            pst.setString(2, date);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("nofactura");
                registros[1] = rs.getString("date");
                registros[2] = rs.getString("accion");
                registros[3] = rs.getString("saldoinicial");
                registros[4] = rs.getString("cobro");
                registros[5] = rs.getString("saldofinal");
                modelo.addRow(registros);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return modelo;
    }
    public DefaultTableModel showProductos(Connection con){
        String[] titulos={"Codigo","Producto","Precio","Categoria"};
        String[] registros=new String[4];
        DefaultTableModel modelo=new DefaultTableModel(null,titulos);
        try {
            String sql="SELECT * FROM productos";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                registros[0]=rs.getString("codigo");
                registros[1]=rs.getString("producto");
                registros[2]=("$"+rs.getString("precio"));
                registros[3]=rs.getString("categoria");
                modelo.addRow(registros);
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return modelo;
    }
    public DefaultTableModel filterProductos(Connection con,String[] textos){
        String[] titulos={"Codigo","Producto","Precio","Categoria"};
        String[] registros=new String[4];
        DefaultTableModel modelo=new DefaultTableModel(null,titulos);
        try {
            String sql="SELECT * FROM productos WHERE codigo LIKE ? AND  producto LIKE ? AND categoria LIKE ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,"%"+ textos[0]+"%");
            pst.setString(2,"%"+ textos[1]+"%");
            pst.setString(3, "%"+textos[3]+"%");
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                registros[0]=rs.getString("codigo");
                registros[1]=rs.getString("producto");
                registros[2]=("$"+rs.getString("precio"));
                registros[3]=rs.getString("categoria");
                modelo.addRow(registros);
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return modelo;
    }
    public DefaultTableModel createProductos(Connection con,String[] textos){
        String[] titulos={"Codigo","Producto","Precio","Categoria"};
        String[] registros=new String[4];
        DefaultTableModel modelo=new DefaultTableModel(null,titulos);
        try {
            String sql="INSERT INTO productos (producto,precio,categoria) VALUES (?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, textos[1]);
            pst.setString(2, textos[2]);
            pst.setString(3, textos[3]);
            pst.executeUpdate();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return modelo;
    }


}
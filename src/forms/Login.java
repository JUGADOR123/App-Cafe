package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends  JFrame{
    public void init(){

       setTitle("Login");
        setContentPane(PanelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public Login(Connection con) {
        init();
        login_btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String sql="select * from usuarios where user=? && contra=?";
                    PreparedStatement pst=con.prepareStatement(sql);
                    pst.setString(1,login_txt_user.getText());
                    pst.setString(2,String.valueOf(login_txt_pass.getPassword()));
                    ResultSet response=pst.executeQuery();
                    if(response.next()){
                        System.out.println("Bienvenido");
                        Component button=(Component) e.getSource();
                        SwingUtilities.getWindowAncestor(button).dispose();

                        App main=new App(response.getInt(5),con);
                    }else{
                        JOptionPane.showMessageDialog(null,"Nombre de usuario o Contraseña incorrecto","Error de login",JOptionPane.WARNING_MESSAGE);
                        login_txt_user.setText("");
                        login_txt_pass.setText("");
                    }
                    }catch (SQLException ex){
                    System.out.println("Error: " + ex.getMessage());
                }

            }
        });
        login_btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component button=(Component) e.getSource();
                SwingUtilities.getWindowAncestor(button).dispose();
            }
        });
    }



    private JPanel PanelPrincipal;
    private JLabel logo;
    private JPanel TopBar;
    private JPanel LoginPanel;
    private JTextField login_txt_user;
    private JLabel login_label_titulo;
    private JLabel login_titulo;
    private JLabel login_label_pass;
    private JPasswordField login_txt_pass;
    private JButton login_btn_login;
    private JButton login_btn_cancelar;
}

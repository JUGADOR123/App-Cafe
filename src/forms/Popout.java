package forms;

import Code.popoutqueries;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Popout extends JFrame{
    popoutqueries pt = new popoutqueries();
    private JPanel PopoutPrincipal;
    private JPanel PopoutTopBar;
    private JLabel PopoutLogo;
    private JLabel PopoutCategoria;
    private JPanel PopoutPanelPrincipal;
    private JButton PopoutBtnCancelar;
    private JButton PopoutBtnAceptar;
    private JSpinner PopoutSpinner;
    private JPanel PopoutPanelControles;
    private JTable PopoutProductos;
    private JScrollPane PopoutScroll;
    private JLabel PopoutLabelCantidad;

    public Popout(Connection con, String categoria) {
        init();
        PopoutCategoria.setText("Productos "+categoria);
        PopoutProductos.setModel(pt.mostrarProductosCategoria(con, categoria));
        PopoutSpinner.setModel(new SpinnerNumberModel(1, 1, 50, 1));
        PopoutSpinner.getComponent(0).setPreferredSize(new Dimension(100, 80));
        PopoutBtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component button = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(button).dispose();
            }
        });
    }
    public void  init(){
        setUndecorated(true);
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){};
        setContentPane(PopoutPrincipal);
        setIconImage(new ImageIcon("imagenes/logo_colegio.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(600, 850);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

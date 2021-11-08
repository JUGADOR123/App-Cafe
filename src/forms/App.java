package forms;

import Code.mostrarAlumnos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class App {
    mostrarAlumnos mn=new mostrarAlumnos();
    public App(int AccountType, Connection con) {
        if (AccountType==1){
            System.out.println("Cuenta de tipo usuario");
        }else{
            System.out.println("Cuenta de tipo Admin");
        }
        init();

        createTable(con);


        VentasAlumnosTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row=VentasAlumnosTable.getSelectedRow();
                VentasTxtCodigo.setText(VentasAlumnosTable.getValueAt(row,0).toString());
                VentasTxtNombre.setText(VentasAlumnosTable.getValueAt(row,1).toString());
                VentasTxtGrado.setText(VentasAlumnosTable.getValueAt(row,2).toString());
                VentasTxtSaldo.setText(VentasAlumnosTable.getValueAt(row,3).toString());
                if (Double.parseDouble(VentasTxtSaldo.getText().toString())<5){
                    VentasTxtSaldo.setBackground(Color.ORANGE);
                }else{
                    VentasTxtSaldo.setBackground(Color.GREEN);
                }
            }
        });
        VentasTxtCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                VentasAlumnosTable.setModel(mn.filter(con,dataVentas()));

            }
        });
        VentasTxtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                VentasAlumnosTable.setModel(mn.filter(con,dataVentas()));
            }
        });
        VentasTxtGrado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                VentasAlumnosTable.setModel(mn.filter(con,dataVentas()));
            }
        });
        VentasBtnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
                VentasAlumnosTable.setModel(mn.execute(con));
            }
        });
        VentasBtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
                VentasAlumnosTable.setModel(mn.execute(con));
                VentasFacturaActualTable.setModel(new DefaultTableModel(null,new String[]{"Codigo","Nombre","Cantidad","Total"}));

            }
        });
        AbonosTxtCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                AbonoTablealumnos.setModel(mn.filter(con,dataAbonos()));
            }
        });
        AbonosTxtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                AbonoTablealumnos.setModel(mn.filter(con,dataAbonos()));
            }
        });
        AbonosTxtGrado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                AbonoTablealumnos.setModel(mn.filter(con,dataAbonos()));
            }
        });
        AbonoTablealumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row=AbonoTablealumnos.getSelectedRow();
                AbonosTxtCodigo.setText(AbonoTablealumnos.getValueAt(row,0).toString());
                AbonosTxtNombre.setText(AbonoTablealumnos.getValueAt(row,1).toString());
                AbonosTxtGrado.setText(AbonoTablealumnos.getValueAt(row,2).toString());
                AbonosTxtSaldoActual.setText(AbonoTablealumnos.getValueAt(row,3).toString());
                if (Double.parseDouble(AbonosTxtSaldoActual.getText().toString())<5){
                    AbonosTxtSaldoActual.setBackground(Color.ORANGE);
                }else{
                    AbonosTxtSaldoActual.setBackground(Color.GREEN);
                }

            }
        });
        AbonoBtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
                AbonoTablealumnos.setModel(mn.execute(con));

            }
        });
    }
    void init(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception ignored){}
        JFrame frame = new JFrame();

        frame.setTitle("Sistema Cafeteria");
        frame.setContentPane(AppPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,600);
        frame.setVisible(true);

    }

    private JPanel AppPrincipal;
    private JPanel AppTopBar;
    private JLabel AppLogo;
    private JLabel AppTitulo;
    private JPanel AppPanelPrincipal;
    private JTabbedPane AppPestanas;
    private JPanel VentasDatosAlumnos;
    private JTextField VentasTxtCodigo;
    private JTextField VentasTxtNombre;
    private JTextField VentasTxtGrado;
    private JTextField VentasTxtSaldo;
    private JLabel VentasCodigoAlumno;
    private JLabel VentasNombre;
    private JLabel VentasGrado;
    private JLabel VentasSaldo;
    private JTable VentasAlumnosTable;
    private JScrollPane VentasAlumnosScroll;
    private JPanel VentasFacturaActual;
    private JScrollPane VentasFacturaActualScroll;
    private JTable VentasFacturaActualTable;
    private JButton VentasBtnCancelar;
    private JButton VentasBtnBorrar;
    private JButton VentasBtnCobrar;
    private JTextField VentasTxtTotalActual;
    private JLabel VentasLabelTotal;
    private JLabel VentasLabelProductos;
    private JButton VentasBtnDesayunos;
    private JButton VentasBtnOtros;
    private JButton VentasBtnAlmuerzos;
    private JButton VentasBtnBebidas;
    private JButton VentasBtnSnacks;
    private JButton VentasBtnPostres;
    private JPanel VentasPanelProductos;
    private JPanel VentasPanelBotones;
    private JPanel VentasPanelFacturaControles;
    private JButton VentasBtnLimpiar;
    private JPanel AppPanelVentas;
    private JPanel AppPanelAbonos;
    private JPanel AbonosRegistroMain;
    private JPanel AbonosDatosPanelMain;
    private JLabel AbonosLabelDatos;
    private JPanel AbonosDatosPanel;
    private JTextField AbonosTxtCodigo;
    private JTextField AbonosTxtNombre;
    private JTextField AbonosTxtGrado;
    private JTextField AbonosTxtSaldoActual;
    private JTextField AbonosTxTAbonar;
    private JTextField AbonosTxtSaldoFinal;
    private JLabel AbonosLabelCodigo;
    private JLabel AbonosLabelNombre;
    private JLabel AbonosLabelGrado;
    private JLabel AbonosLabelSaldoActual;
    private JLabel AbonosLabelAbonar;
    private JLabel AbonosLabelSaldoFinal;
    private JButton AbonoBtnAbonar;
    private JButton AbonoBtnCancelar;
    private JTable AbonoTablealumnos;
    private JPanel AbonoPanelControles;
    private JScrollPane AbonoScrollalumnos;
    private JLabel VentasLabelFactura;


    private void createTable(Connection con) {

        VentasAlumnosTable.setModel(mn.execute(con));
        VentasAlumnosTable.setDefaultEditor(Object.class,null);
        AbonoTablealumnos.setModel(mn.execute(con));
        AbonoTablealumnos.setDefaultEditor(Object.class,null);
        //VentasAlumnosTable.setModel(new DefaultTableModel(null, new String[]{"Codigo", "Nombre", "Grado", "Saldo"}));
        VentasFacturaActualTable.setModel(new DefaultTableModel(null,new String[]{"Codigo","Nombre","Cantidad","Total"}));

    }
    public String[] dataVentas(){
        String data[]={
          VentasTxtCodigo.getText(),
          VentasTxtNombre.getText(),
          VentasTxtGrado.getText()
        };
        return data;
    }
    public String[] dataAbonos(){
        String data[]={
                AbonosTxtCodigo.getText(),
                AbonosTxtNombre.getText(),
                AbonosTxtGrado.getText()
        };
        return data;
    }
    public void limpiar(){
        VentasTxtCodigo.setText("");
        VentasTxtNombre.setText("");
        VentasTxtGrado.setText("");
        VentasTxtSaldo.setText("");
        VentasTxtSaldo.setBackground(Color.white);
        VentasTxtTotalActual.setText("");
        VentasTxtTotalActual.setBackground(Color.white);
        AbonosTxtCodigo.setText("");
        AbonosTxtNombre.setText("");
        AbonosTxtGrado.setText("");
        AbonosTxtSaldoActual.setText("");
        AbonosTxtSaldoActual.setBackground(Color.white);
        AbonosTxTAbonar.setText("");
        AbonosTxtSaldoFinal.setText("");
    }
}

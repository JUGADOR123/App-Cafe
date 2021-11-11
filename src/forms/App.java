package forms;

import Code.sqlqueries;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class App extends JFrame{
    sqlqueries mn = new sqlqueries();
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
    private JPanel AppPanelHistorial;
    private JPanel HistorialPanelDatos;
    private JPanel HistorialPanelShortFactura;
    private JScrollPane HistorialScrollShortFactura;
    private JTable HistorialTableShortFactura;
    private JPanel HistorialPanelFactura;
    private JScrollPane HistorialScrollFactura;
    private JTable HistorialTableFactura;
    private JLabel HistorialLabelCalendario;
    private JLabel HsitorialLabelFactura;
    private JLabel HistorialLabelFacturaShort;
    private JLabel HistorialLabelDatos;
    private JPanel HistorialPanelMDatos;
    private JTextField HistorialTxtCodigo;
    private JTextField HistorialTxtNombre;
    private JTextField HistorialTxtGrado;
    private JTextField HistorialTxtSaldo;
    private JLabel HistorialLabelCodigo;
    private JLabel HistorialLabelNombre;
    private JLabel HistorialLabelGrado;
    private JLabel HistorialLabelSaldo;
    private JPanel HistorialPanelAlumnos;
    private JScrollPane HistorialScrollAlumnos;
    private JTable HistorialTableAlumnos;
    private JButton UsuariosBtnGuardar;
    private JButton UsuariosBtnActualizar;
    private JButton UsuariosBtnBorrar;
    private JTable UsuariosTableLista;
    private JTextField UsuariosTxtUser;
    private JTextField UsuariosTxtNombre;
    private JTextField UsuariosTxTcodigo;
    private JComboBox UsuariosComboTipo;
    private JPanel AppPanelCrearUsuarios;
    private JPanel UsuariosDatosPanel;
    private JLabel UsuariosLabelCodigo;
    private JLabel UusuariosLabelNombre;
    private JLabel UsuariosLabelUsuarios;
    private JPasswordField UsuariosTxtContra;
    private JLabel UsuarioLabelContra;
    private JLabel UsuariosLabelTipo;
    private JPanel UsuariosPanelLista;
    private JPanel UsuariosPanelControles;
    private JScrollPane UsuariosScrollLista;
    private JButton UsuariosBtnCancelar;
    private JButton AppBtnCerrarSesion;
    private JButton HistorialBtnLimpiar;
    private JTextField HistorialTxTYear;
    private JComboBox HistorialComboMes;
    private JComboBox HistorialComboDia;
    private JPanel AppPanelProductos;
    private JTable ProductosTable;
    private JTextField ProductosTxTCodigo;
    private JTextField ProductosTxtNombre;
    private JTextField ProductosTxtPrecio;
    private JComboBox ProductosComboCategoria;
    private JPanel ProductosPanelDatos;
    private JLabel ProductosLabelCodigo;
    private JLabel ProductosLabelNombre;
    private JLabel ProductosLabelPrecio;
    private JLabel ProductosLabelTipo;
    private JPanel ProductosPanelTable;
    private JPanel ProductosPanelControles;
    private JScrollPane ProductosScroll;
    private JButton ProductosBtnGuardar;
    private JButton ProductosBtnEditar;
    private JButton ProductosBtnBorrar;
    private JButton ProductosBtnCancelar;
    private Connection conn;


    public App(String AccountType, Connection con) {
        conn=con;
        System.out.println("Tipo de Cuenta: " + AccountType);
        init();
        if (AccountType.equals("Usuario")) {
            AppPestanas.setEnabledAt(3, false);
            AppPestanas.setEnabledAt(4, false);
        }
        createTable(con);


        VentasAlumnosTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = VentasAlumnosTable.getSelectedRow();
                VentasTxtCodigo.setText(VentasAlumnosTable.getValueAt(row, 0).toString());
                VentasTxtNombre.setText(VentasAlumnosTable.getValueAt(row, 1).toString());
                VentasTxtGrado.setText(VentasAlumnosTable.getValueAt(row, 2).toString());
                VentasTxtSaldo.setText(VentasAlumnosTable.getValueAt(row, 3).toString());
                if (Double.parseDouble(VentasTxtSaldo.getText()) < 5) {
                    VentasTxtSaldo.setBackground(Color.ORANGE);
                } else {
                    VentasTxtSaldo.setBackground(Color.GREEN);
                }
            }
        });
        VentasTxtCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                VentasAlumnosTable.setModel(mn.filterAlumnos(con, dataVentas()));

            }
        });
        VentasTxtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                VentasAlumnosTable.setModel(mn.filterAlumnos(con, dataVentas()));
            }
        });
        VentasTxtGrado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                VentasAlumnosTable.setModel(mn.filterAlumnos(con, dataVentas()));
            }
        });
        VentasBtnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();

            }
        });
        VentasBtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
                VentasFacturaActualTable.setModel(new DefaultTableModel(null, new String[]{"Codigo", "Nombre", "Cantidad", "Total"}));

            }
        });
        AbonosTxtCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                AbonoTablealumnos.setModel(mn.filterAlumnos(con, dataAbonos()));
            }
        });
        AbonosTxtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                AbonoTablealumnos.setModel(mn.filterAlumnos(con, dataAbonos()));
            }
        });
        AbonosTxtGrado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                AbonoTablealumnos.setModel(mn.filterAlumnos(con, dataAbonos()));
            }
        });
        AbonoTablealumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = AbonoTablealumnos.getSelectedRow();
                AbonosTxtCodigo.setText(AbonoTablealumnos.getValueAt(row, 0).toString());
                AbonosTxtNombre.setText(AbonoTablealumnos.getValueAt(row, 1).toString());
                AbonosTxtGrado.setText(AbonoTablealumnos.getValueAt(row, 2).toString());
                AbonosTxtSaldoActual.setText(AbonoTablealumnos.getValueAt(row, 3).toString());
                if (Double.parseDouble(AbonosTxtSaldoActual.getText()) < 5) {
                    AbonosTxtSaldoActual.setBackground(Color.ORANGE);
                } else {
                    AbonosTxtSaldoActual.setBackground(Color.GREEN);
                }

            }
        });
        AbonoBtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();

            }
        });
        HistorialTxtCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                HistorialTableAlumnos.setModel(mn.filterAlumnos(con, dataHistorial()));
            }
        });
        HistorialTxtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                HistorialTableAlumnos.setModel(mn.filterAlumnos(con, dataHistorial()));
            }
        });
        HistorialTxtGrado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                HistorialTableAlumnos.setModel(mn.filterAlumnos(con, dataHistorial()));
            }
        });
        HistorialTableAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = HistorialTableAlumnos.getSelectedRow();
                HistorialTxtCodigo.setText(HistorialTableAlumnos.getValueAt(row, 0).toString());
                HistorialTxtNombre.setText(HistorialTableAlumnos.getValueAt(row, 1).toString());
                HistorialTxtGrado.setText(HistorialTableAlumnos.getValueAt(row, 2).toString());
                HistorialTxtSaldo.setText(HistorialTableAlumnos.getValueAt(row, 3).toString());
                if (Double.parseDouble(HistorialTxtSaldo.getText()) < 5) {
                    HistorialTxtSaldo.setBackground(Color.ORANGE);

                } else {
                    HistorialTxtSaldo.setBackground(Color.GREEN);
                }

            }
        });
        UsuariosTxTcodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                UsuariosTableLista.setModel(mn.filterUsuarios(con, dataUsuarios()));
            }
        });
        UsuariosTableLista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = UsuariosTableLista.getSelectedRow();
                UsuariosTxTcodigo.setText(UsuariosTableLista.getValueAt(row, 0).toString());
                UsuariosTxtNombre.setText(UsuariosTableLista.getValueAt(row, 1).toString());
                UsuariosTxtUser.setText(UsuariosTableLista.getValueAt(row, 2).toString());
                UsuariosTxtContra.setText(UsuariosTableLista.getValueAt(row, 3).toString());
                if (UsuariosTableLista.getValueAt(row, 4).toString().equals("Administrador")) {
                    UsuariosComboTipo.setSelectedIndex(1);
                } else {
                    UsuariosComboTipo.setSelectedIndex(0);
                }

            }
        });
        UsuariosBtnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mn.updateUsuarios(con, dataUsuarios());
                UsuariosTableLista.setModel(mn.showUsuarios(con));
                limpiar();
            }
        });
        UsuariosTxtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                UsuariosTableLista.setModel(mn.filterUsuarios(con, dataUsuarios()));
            }
        });
        UsuariosTxtUser.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                UsuariosTableLista.setModel(mn.filterUsuarios(con, dataUsuarios()));
            }
        });
        UsuariosTxtContra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                UsuariosTableLista.setModel(mn.filterUsuarios(con, dataUsuarios()));
            }
        });
        UsuariosComboTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UsuariosTableLista.setModel(mn.filterUsuarios(con, dataUsuarios()));
            }
        });
        UsuariosBtnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mn.deleteUsuarios(con, dataUsuarios());
                limpiar();
                UsuariosTableLista.setModel(mn.showUsuarios(con));

            }
        });
        UsuariosBtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mn.crearUsuario(con, dataUsuarios());
                limpiar();
                UsuariosTableLista.setModel(mn.showUsuarios(con));

            }
        });
        UsuariosBtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
                UsuariosTableLista.setModel(mn.showUsuarios(con));
            }
        });
        AppBtnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component button = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(button).dispose();
                new Login(con);
            }
        });
        AbonosTxTAbonar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                //if abonar is not a decimal number, empty string or negative number
                if (!AbonosTxTAbonar.getText().matches("^[0-9]*\\.?[0-9]*$") || AbonosTxTAbonar.getText().equals("") || Double.parseDouble(AbonosTxTAbonar.getText()) < 0) {
                    AbonosTxtSaldoFinal.setText("");
                    AbonoBtnAbonar.setEnabled(false);
                } else {
                    double saldo = Double.parseDouble(AbonosTxtSaldoActual.getText());
                    double abonar = Double.parseDouble(AbonosTxTAbonar.getText());
                    double saldoFinal = saldo + abonar;
                    AbonosTxtSaldoFinal.setText(String.valueOf(saldoFinal));
                    AbonoBtnAbonar.setEnabled(true);
                }


            }
        });
        AbonoBtnAbonar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mn.abonarSaldo(con, dataAbonos());
                limpiar();
            }
        });
        HistorialTableAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String codigo = HistorialTableAlumnos.getValueAt(HistorialTableAlumnos.getSelectedRow(), 0).toString();
                HistorialTableShortFactura.setModel(mn.mostrarFacturasShort(con, codigo));
            }
        });
        HistorialBtnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
        HistorialComboMes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if ComboDia and ComboMes and year are not empty
                if (HistorialComboDia.getSelectedIndex() != 0 && HistorialComboMes.getSelectedIndex() != 0 && HistorialTxTYear.getText().length() == 4) {
                    System.out.println("entro");
                    HistorialTableShortFactura.setModel(mn.filterFacturaShort(con, HistorialTxtCodigo.getText(), date()));
                }
            }
        });
        HistorialComboDia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if ComboDia and ComboMes and year are not empty
                if (HistorialComboDia.getSelectedIndex() != 0 && HistorialComboMes.getSelectedIndex() != 0 && HistorialTxTYear.getText().length() == 4) {
                    System.out.println("entro");
                    HistorialTableShortFactura.setModel(mn.filterFacturaShort(con, HistorialTxtCodigo.getText(), date()));
                }
            }
        });
        HistorialTxTYear.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                //if ComboDia and ComboMes and year are not empty
                if (HistorialComboDia.getSelectedIndex() != 0 && HistorialComboMes.getSelectedIndex() != 0 && HistorialTxTYear.getText().length() == 4) {
                    System.out.println("entro");
                    HistorialTableShortFactura.setModel(mn.filterFacturaShort(con, HistorialTxtCodigo.getText(), date()));
                }
            }
        });
        ProductosComboCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductosTable.setModel(mn.filterProductos(con, dataProductos()));
            }
        });
        VentasBtnOtros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Popout pop=new Popout(con,"Otros");
            }
        });
        ProductosTxTCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                ProductosTable.setModel(mn.filterProductos(con, dataProductos()));
            }
        });
        ProductosTxtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                ProductosTable.setModel(mn.filterProductos(con, dataProductos()));
            }
        });
        ProductosTxtPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                ProductosTable.setModel(mn.filterProductos(con, dataProductos()));
            }
        });
        ProductosTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = ProductosTable.getSelectedRow();
                ProductosTxTCodigo.setText(ProductosTable.getValueAt(row, 0).toString());
                ProductosTxtNombre.setText(ProductosTable.getValueAt(row, 1).toString());
                ProductosTxtPrecio.setText(ProductosTable.getValueAt(row, 2).toString());
                ProductosComboCategoria.setSelectedItem(ProductosTable.getValueAt(row, 3).toString());
                ProductosBtnGuardar.setEnabled(true);
                ProductosBtnEditar.setEnabled(true);
            }
        });
        ProductosBtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mn.createProductos(con,dataProductos());
                limpiar();
            }
        });
        VentasBtnDesayunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Popout pop=new Popout(con,"Desayunos");
            }
        });
        VentasBtnAlmuerzos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Popout pop=new Popout(con,"Almuerzos");
            }
        });
        VentasBtnSnacks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Popout pop=new Popout(con,"Snacks");
            }
        });
        VentasBtnBebidas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Popout pop=new Popout(con,"Bebidas");
            }
        });
        VentasBtnPostres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Popout pop=new Popout(con,"Postres");
            }
        });
    }

    void init() {
        setUndecorated(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        setIconImage(new ImageIcon("imagenes/logo_colegio.png").getImage());

        setTitle("Sistema Cafeteria");
        setContentPane(AppPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(1000, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    private void createTable(Connection con) {

        VentasAlumnosTable.setModel(mn.showAlumnos(con));
        VentasAlumnosTable.setDefaultEditor(Object.class, null);
        AbonoTablealumnos.setModel(mn.showAlumnos(con));
        AbonoTablealumnos.setDefaultEditor(Object.class, null);
        VentasFacturaActualTable.setModel(new DefaultTableModel(null, new String[]{"Codigo", "Nombre", "Cantidad", "Total"}));
        VentasFacturaActualTable.setDefaultEditor(Object.class, null);
        HistorialTableAlumnos.setModel(mn.showAlumnos(con));
        HistorialTableAlumnos.setDefaultEditor(Object.class, null);
        HistorialTableShortFactura.setModel(new DefaultTableModel(null, new String[]{"Codigo", "Fecha", "Accion", "Balance Inicial", "Total", "Balance Final"}));
        HistorialTableShortFactura.setDefaultEditor(Object.class, null);
        UsuariosTableLista.setModel(mn.showUsuarios(con));
        UsuariosTableLista.setDefaultEditor(Object.class, null);
        ProductosTable.setModel(mn.showProductos(con));
        ProductosTable.setDefaultEditor(Object.class, null);

    }

    public String[] dataVentas() {
        String[] data = {
                VentasTxtCodigo.getText(),
                VentasTxtNombre.getText(),
                VentasTxtGrado.getText()
        };
        return data;
    }

    public String[] dataAbonos() {
        String[] data = {
                AbonosTxtCodigo.getText(),
                AbonosTxtNombre.getText(),
                AbonosTxtGrado.getText(),
                AbonosTxtSaldoActual.getText(),
                AbonosTxTAbonar.getText(),
                AbonosTxtSaldoFinal.getText()

        };
        return data;
    }

    public String[] dataHistorial() {
        String[] data = {
                HistorialTxtCodigo.getText(),
                HistorialTxtNombre.getText(),
                HistorialTxtGrado.getText(),
                HistorialTxtSaldo.getText()

        };
        return data;
    }

    public String[] dataUsuarios() {
        String[] data = {
                UsuariosTxTcodigo.getText(),
                UsuariosTxtUser.getText(),
                UsuariosTxtNombre.getText(),
                String.valueOf(UsuariosTxtContra.getPassword()),
                UsuariosComboTipo.getSelectedItem().toString()
        };
        return data;
    }
    public String[] dataProductos(){
        if(ProductosComboCategoria.getSelectedIndex()==0){
            String[] data = {
                    ProductosTxTCodigo.getText(),
                    ProductosTxtNombre.getText(),
                    ProductosTxtPrecio.getText(),
                    "",

            };
            return data;
        }else {
            String[] data = {
                    ProductosTxTCodigo.getText(),
                    ProductosTxtNombre.getText(),
                    ProductosTxtPrecio.getText(),
                    ProductosComboCategoria.getSelectedItem().toString(),
            };
            if(!data[3].equals("")&& !ProductosTxtNombre.getText().equals("")&& ProductosTxtPrecio.getText().matches("^[0-9]*\\.?[0-9]*$")){
                ProductosBtnEditar.setEnabled(true);
                ProductosBtnGuardar.setEnabled(true);
            }else {
                ProductosBtnEditar.setEnabled(false);
                ProductosBtnGuardar.setEnabled(false);
            }
            return data;
        }
    }


    public void limpiar() {
        //clear all ventas  fields
        VentasTxtCodigo.setText("");
        VentasTxtNombre.setText("");
        VentasTxtGrado.setText("");
        VentasTxtSaldo.setText("");
        VentasTxtSaldo.setBackground(Color.white);
        VentasTxtTotalActual.setText("");
        VentasTxtTotalActual.setBackground(Color.white);

        //clear all abonos  fields
        AbonosTxtCodigo.setText("");
        AbonosTxtNombre.setText("");
        AbonosTxtGrado.setText("");
        AbonosTxtSaldoActual.setText("");
        AbonosTxtSaldoActual.setBackground(Color.white);
        AbonosTxTAbonar.setText("");
        AbonosTxtSaldoFinal.setText("");

        //clear all usuarios  fields
        UsuariosTxTcodigo.setText("");
        UsuariosTxtUser.setText("");
        UsuariosTxtNombre.setText("");
        UsuariosTxtContra.setText("");
        UsuariosComboTipo.setSelectedIndex(0);

        //clear all historial fields
        HistorialTableShortFactura.setModel(new DefaultTableModel(null, new String[]{"Codigo", "Fecha", "Accion", "Balance inicial", "Total", "Balance Final"}));
        HistorialTxtCodigo.setText("");
        HistorialTxtNombre.setText("");
        HistorialTxtGrado.setText("");
        HistorialTxtSaldo.setText("");
        HistorialTxtSaldo.setBackground(Color.white);
        HistorialComboMes.setSelectedIndex(0);
        HistorialTxTYear.setText("");
        HistorialComboDia.setSelectedIndex(0);

        //clear all productos fields
        ProductosTxTCodigo.setText("");
        ProductosTxtNombre.setText("");
        ProductosTxtPrecio.setText("");
        ProductosComboCategoria.setSelectedIndex(0);
        ProductosBtnEditar.setEnabled(false);
        ProductosBtnGuardar.setEnabled(false);

        //update the tables if data is changed
        VentasAlumnosTable.setModel(mn.showAlumnos(conn));
        AbonoTablealumnos.setModel(mn.showAlumnos(conn));
        HistorialTableAlumnos.setModel(mn.showAlumnos(conn));



    }

    public String date() {
        String date = "";
        date = (HistorialTxTYear.getText() + "-" + HistorialComboMes.getSelectedIndex()) + "-" + HistorialComboDia.getSelectedIndex();
        return date;
    }
}

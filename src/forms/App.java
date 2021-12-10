package forms;

import Code.popoutqueries;
import Code.sqlqueries;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class App extends JFrame {
    private final Connection conn;
    sqlqueries mn = new sqlqueries();
    popoutqueries pt = new popoutqueries();

    private JPanel AppPrincipal;
    private JTabbedPane AppPestanas;
    private JTextField VentasTxtCodigo;
    private JTextField VentasTxtNombre;
    private JTextField VentasTxtGrado;
    private JTextField VentasTxtSaldo;
    private JTable VentasAlumnosTable;
    private JTable VentasFacturaActualTable;
    private JButton VentasBtnCancelar;
    private JTextField VentasTxtTotalActual;
    private JButton VentasBtnDesayunos;
    private JButton VentasBtnOtros;
    private JButton VentasBtnAlmuerzos;
    private JButton VentasBtnBebidas;
    private JButton VentasBtnSnacks;
    private JButton VentasBtnPostres;
    private JButton VentasBtnLimpiar;
    private JTextField AbonosTxtCodigo;
    private JTextField AbonosTxtNombre;
    private JTextField AbonosTxtGrado;
    private JTextField AbonosTxtSaldoActual;
    private JTextField AbonosTxTAbonar;
    private JTextField AbonosTxtSaldoFinal;
    private JButton AbonoBtnAbonar;
    private JButton AbonoBtnCancelar;
    private JTable AbonoTablealumnos;
    private JTable HistorialTableShortFactura;
    private JTextField HistorialTxtCodigo;
    private JTextField HistorialTxtNombre;
    private JTextField HistorialTxtGrado;
    private JTextField HistorialTxtSaldo;
    private JTable HistorialTableAlumnos;
    private JButton UsuariosBtnGuardar;
    private JButton UsuariosBtnActualizar;
    private JButton UsuariosBtnBorrar;
    private JTable UsuariosTableLista;
    private JTextField UsuariosTxtUser;
    private JTextField UsuariosTxtNombre;
    private JTextField UsuariosTxTcodigo;
    private JComboBox<String> UsuariosComboTipo;
    private JPasswordField UsuariosTxtContra;
    private JButton UsuariosBtnCancelar;
    private JButton AppBtnCerrarSesion;
    private JButton HistorialBtnLimpiar;
    private JTextField HistorialTxTYear;
    private JComboBox HistorialComboMes;
    private JComboBox HistorialComboDia;
    private JTable ProductosTable;
    private JTextField ProductosTxTCodigo;
    private JTextField ProductosTxtNombre;
    private JTextField ProductosTxtPrecio;
    private JComboBox ProductosComboCategoria;
    private JButton ProductosBtnGuardar;
    private JButton ProductosBtnEditar;
    private JPanel AppCard;
    private JPanel AppTopBar;
    private JLabel AppLogo;
    private JLabel AppTitulo;
    private JPanel AppPanelPrincipal;
    private JPanel AppPanelVentas;
    private JPanel VentasDatosAlumnos;
    private JLabel VentasCodigoAlumno;
    private JLabel VentasNombre;
    private JLabel VentasGrado;
    private JLabel VentasSaldo;
    private JScrollPane VentasAlumnosScroll;
    private JPanel VentasFacturaActual;
    private JScrollPane VentasFacturaActualScroll;
    private JPanel VentasPanelFacturaControles;
    private JButton VentasBtnBorrar;
    private JButton VentasBtnCobrar;
    private JLabel VentasLabelTotal;
    private JLabel VentasLabelFactura;
    private JPanel VentasPanelProductos;
    private JPanel VentasPanelBotones;
    private JLabel VentasLabelProductos;
    private JPanel AppPanelAbonos;
    private JPanel AbonosRegistroMain;
    private JScrollPane AbonoScrollalumnos;
    private JPanel AbonoPanelControles;
    private JPanel AbonosDatosPanelMain;
    private JPanel AbonosDatosPanel;
    private JLabel AbonosLabelCodigo;
    private JLabel AbonosLabelNombre;
    private JLabel AbonosLabelGrado;
    private JLabel AbonosLabelSaldoActual;
    private JLabel AbonosLabelAbonar;
    private JLabel AbonosLabelSaldoFinal;
    private JLabel AbonosLabelDatos;
    private JPanel AppPanelHistorial;
    private JPanel HistorialPanelDatos;
    private JLabel HistorialLabelDatos;
    private JPanel HistorialPanelMDatos;
    private JLabel HistorialLabelCodigo;
    private JLabel HistorialLabelNombre;
    private JLabel HistorialLabelGrado;
    private JLabel HistorialLabelSaldo;
    private JLabel HistorialLabelCalendario;
    private JPanel HistorialPanelShortFactura;
    private JScrollPane HistorialScrollShortFactura;
    private JLabel HistorialLabelFacturaShort;
    private JPanel HistorialPanelFactura;
    private JScrollPane HistorialScrollFactura;
    private JTable HistorialTableFactura;
    private JLabel HsitorialLabelFactura;
    private JPanel HistorialPanelAlumnos;
    private JScrollPane HistorialScrollAlumnos;
    private JPanel AppPanelCrearUsuarios;
    private JPanel UsuariosDatosPanel;
    private JLabel UsuariosLabelCodigo;
    private JLabel UsuariosLabelNombre;
    private JLabel UsuariosLabelUsuarios;
    private JLabel UsuariosLabelTipo;
    private JLabel UsuarioLabelContra;
    private JPanel UsuariosPanelLista;
    private JPanel UsuariosPanelControles;
    private JScrollPane UsuariosScrollLista;
    private JPanel AppPanelProductos;
    private JPanel ProductosPanelDatos;
    private JLabel ProductosLabelCodigo;
    private JLabel ProductosLabelNombre;
    private JLabel ProductosLabelPrecio;
    private JLabel ProductosLabelTipo;
    private JPanel ProductosPanelTable;
    private JPanel ProductosPanelControles;
    private JButton ProductosBtnBorrar;
    private JButton ProductosBtnCancelar;
    private JScrollPane ProductosScroll;
    private JPanel PopoutPrincipal;
    private JPanel PopoutTopBar;
    private JLabel PopoutLogo;
    private JLabel PopoutCategoria;
    private JPanel PopoutPanelPrincipal;
    private JScrollPane PopoutScroll;
    private JTable PopoutProductos;
    private JPanel PopoutPanelControles;
    private JButton PopoutBtnCancelar;
    private JButton PopoutBtnAceptar;
    private JSpinner PopoutSpinner;
    private JLabel PopoutLabelCantidad;


    public App(String AccountType, Connection con) {
        //create the connection
        conn = con;
        //set the cards
        AppCard.setLayout(new CardLayout());
        AppCard.add("principal", AppPrincipal);
        AppCard.add("popout", PopoutPrincipal);
        CardLayout cl = (CardLayout) AppCard.getLayout();
        cl.show(AppCard, "principal");
        //check account type
        System.out.println("Tipo de Cuenta: " + AccountType);
        init();
        fonts();
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
                VentasBtnAlmuerzos.setEnabled(true);
                VentasBtnBebidas.setEnabled(true);
                VentasBtnDesayunos.setEnabled(true);
                VentasBtnOtros.setEnabled(true);
                VentasBtnSnacks.setEnabled(true);
                VentasBtnPostres.setEnabled(true);

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
                    HistorialTableShortFactura.setModel(mn.filterFacturaShort(con, HistorialTxtCodigo.getText(), date()));
                }
            }
        });
        HistorialComboDia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if ComboDia and ComboMes and year are not empty
                if (HistorialComboDia.getSelectedIndex() != 0 && HistorialComboMes.getSelectedIndex() != 0 && HistorialTxTYear.getText().length() == 4) {
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
                ProductosBtnBorrar.setEnabled(true);
            }
        });
        ProductosBtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mn.createProductos(con, dataProductos());
                limpiar();
            }
        });
        VentasBtnDesayunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize_popout(con, "Desayunos");
                cl.show(AppCard, "popout");
            }
        });
        VentasBtnAlmuerzos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize_popout(con, "Almuerzos");
                cl.show(AppCard, "popout");

            }
        });
        VentasBtnSnacks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize_popout(con, "Snacks");
                cl.show(AppCard, "popout");
            }
        });
        VentasBtnBebidas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize_popout(con, "Bebidas");
                cl.show(AppCard, "popout");
            }
        });
        VentasBtnPostres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize_popout(con, "Postres");
                cl.show(AppCard, "popout");
            }
        });
        VentasBtnOtros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize_popout(con, "Otros");
                cl.show(AppCard, "popout");
            }
        });
        PopoutBtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PopoutBtnAceptar.setEnabled(false);
                cl.show(AppCard, "principal");
            }
        });
        PopoutProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = PopoutProductos.getSelectedRow();
                if (row != -1) {
                    PopoutBtnAceptar.setEnabled(true);
                }
            }
        });
        PopoutBtnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = PopoutProductos.getSelectedRow();
                String[] data = {
                        PopoutProductos.getValueAt(row, 0).toString(),
                        PopoutProductos.getValueAt(row, 1).toString(),
                        PopoutSpinner.getValue().toString(),
                        String.valueOf(Math.round(Double.parseDouble(PopoutProductos.getValueAt(row, 2).toString()) * Double.parseDouble(PopoutSpinner.getValue().toString()) * 100.0) / 100.0)

                };
                //append data as a row  to VentasFacturaActual
                DefaultTableModel model = (DefaultTableModel) VentasFacturaActualTable.getModel();
                model.addRow(data);
                //add up all values in the column 4
                double sum = 0;
                for (int i = 0; i < VentasFacturaActualTable.getRowCount(); i++) {
                    sum += Double.parseDouble(VentasFacturaActualTable.getValueAt(i, 3).toString());
                }
                sum = Math.round(sum * 100.0) / 100.0;
                VentasTxtTotalActual.setText(String.valueOf(sum));
                if (sum > Double.parseDouble(VentasTxtSaldo.getText())) {
                    VentasBtnCobrar.setEnabled(false);
                    VentasTxtTotalActual.setBackground(Color.red);
                } else {
                    VentasBtnCobrar.setEnabled(true);
                    VentasTxtTotalActual.setBackground(Color.GREEN);
                }
                PopoutBtnAceptar.setEnabled(false);
                cl.show(AppCard, "principal");


            }
        });
        VentasFacturaActualTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = VentasFacturaActualTable.getSelectedRow();
                if (row != -1) {
                    VentasBtnBorrar.setEnabled(true);
                }
            }
        });
        VentasBtnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = (DefaultTableModel) VentasFacturaActualTable.getModel();
                model.removeRow(VentasFacturaActualTable.getSelectedRow());

                VentasBtnBorrar.setEnabled(false);
                double sum = 0;
                for (int i = 0; i < VentasFacturaActualTable.getRowCount(); i++) {
                    sum += (Double.parseDouble(VentasFacturaActualTable.getValueAt(i, 3).toString()));
                }
                sum = (double) Math.round(sum * 100.0) / 100.0;
                VentasTxtTotalActual.setText(Double.valueOf(sum).toString());
                if (sum > Double.parseDouble(VentasTxtSaldo.getText())) {
                    VentasBtnCobrar.setEnabled(false);
                    VentasTxtTotalActual.setBackground(Color.red);
                } else if (sum == 0) {
                    VentasBtnCobrar.setEnabled(false);
                    VentasTxtTotalActual.setBackground(Color.WHITE);
                } else {
                    VentasBtnCobrar.setEnabled(true);
                    VentasTxtTotalActual.setBackground(Color.GREEN);
                }

            }
        });
        VentasBtnCobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mn.createFactura(con, dataVentas(), idProductos(), cantidadesProductos());
                limpiar();
            }
        });
        ProductosBtnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mn.deleteProducto(con, dataProductos());
                limpiar();
            }
        });
        ProductosBtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
        HistorialTableShortFactura.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = HistorialTableShortFactura.getSelectedRow();
                //get the first letter of the 4th column
                String accion = HistorialTableShortFactura.getValueAt(row, 2).toString();
                if (row != -1) {
                    String codigo = HistorialTableShortFactura.getValueAt(row, 0).toString();
                    if (accion.equals("Compra")) {
                        HistorialTableFactura.setModel(mn.showDetalleFactura(con, codigo));
                    } else {
                        HistorialTableFactura.setModel(new DefaultTableModel(null, new String[]{"Categoria", "Producto", "Cantidad", "Precio", "Subtotal"}));
                    }
                }
            }
        });
    }

    public void init() {

        setUndecorated(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        setIconImage(new ImageIcon("imagenes/logo_colegio.png").getImage());
        setTitle("Sistema Cafeteria");
        setContentPane(AppCard);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(1000, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    private void createTable(Connection con) {

        VentasAlumnosTable.setModel(mn.showAlumnos(con));
        VentasAlumnosTable.setDefaultEditor(Object.class, null);
        VentasAlumnosTable.setFont(new Font("Montserrat", Font.PLAIN, 20));
        VentasAlumnosTable.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 20));
        VentasAlumnosTable.setRowHeight(VentasAlumnosTable.getFont().getSize() + VentasAlumnosTable.getRowMargin());
        AbonoTablealumnos.setModel(mn.showAlumnos(con));
        AbonoTablealumnos.setDefaultEditor(Object.class, null);
        AbonoTablealumnos.setFont(new Font("Montserrat", Font.PLAIN, 20));
        AbonoTablealumnos.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 20));
        AbonoTablealumnos.setRowHeight(AbonoTablealumnos.getFont().getSize() + AbonoTablealumnos.getRowMargin());
        VentasFacturaActualTable.setModel(new DefaultTableModel(null, new String[]{"Codigo", "Nombre", "Cantidad", "Total"}));
        VentasFacturaActualTable.setDefaultEditor(Object.class, null);
        VentasFacturaActualTable.setFont(new Font("Montserrat", Font.PLAIN, 20));
        VentasFacturaActualTable.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 20));
        VentasFacturaActualTable.setRowHeight(VentasFacturaActualTable.getFont().getSize() + VentasFacturaActualTable.getRowMargin());
        HistorialTableAlumnos.setModel(mn.showAlumnos(con));
        HistorialTableAlumnos.setDefaultEditor(Object.class, null);
        HistorialTableAlumnos.setFont(new Font("Montserrat", Font.PLAIN, 20));
        HistorialTableAlumnos.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 20));
        HistorialTableAlumnos.setRowHeight(HistorialTableAlumnos.getFont().getSize() + HistorialTableAlumnos.getRowMargin());
        HistorialTableShortFactura.setModel(new DefaultTableModel(null, new String[]{"Codigo", "Fecha", "Accion", "Balance Inicial", "Total", "Balance Final"}));
        HistorialTableShortFactura.setDefaultEditor(Object.class, null);
        HistorialTableShortFactura.setFont(new Font("Montserrat", Font.PLAIN, 20));
        HistorialTableShortFactura.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 20));
        HistorialTableShortFactura.setRowHeight(HistorialTableShortFactura.getFont().getSize() + HistorialTableShortFactura.getRowMargin());
        HistorialTableFactura.setModel(new DefaultTableModel(null, new String[]{"Categoria", "Producto", "Cantidad", "Precio", "Subtotal"}));
        HistorialTableFactura.setDefaultEditor(Object.class, null);
        HistorialTableFactura.setFont(new Font("Montserrat", Font.PLAIN, 20));
        HistorialTableFactura.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 20));
        HistorialTableFactura.setRowHeight(HistorialTableFactura.getFont().getSize() + HistorialTableFactura.getRowMargin());
        UsuariosTableLista.setModel(mn.showUsuarios(con));
        UsuariosTableLista.setDefaultEditor(Object.class, null);
        UsuariosTableLista.setFont(new Font("Montserrat", Font.PLAIN, 20));
        UsuariosTableLista.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 20));
        UsuariosTableLista.setRowHeight(UsuariosTableLista.getFont().getSize() + UsuariosTableLista.getRowMargin());
        ProductosTable.setModel(mn.showProductos(con));
        ProductosTable.setDefaultEditor(Object.class, null);
        ProductosTable.setFont(new Font("Montserrat", Font.PLAIN, 20));
        ProductosTable.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 20));
        ProductosTable.setRowHeight(ProductosTable.getFont().getSize() + ProductosTable.getRowMargin());


    }

    private void initialize_popout(Connection con, String categoria) {
        PopoutCategoria.setText("Productos " + categoria);
        PopoutProductos.setModel(pt.mostrarProductosCategoria(con, categoria));
        PopoutProductos.setFont(new Font("Montserrat", Font.PLAIN, 20));
        PopoutProductos.setRowHeight(PopoutProductos.getFont().getSize() + PopoutProductos.getRowMargin());
        PopoutProductos.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 20));
        PopoutSpinner.setModel(new SpinnerNumberModel(1, 1, 50, 1));
        PopoutSpinner.getComponent(0).setPreferredSize(new Dimension(300, 100));
        //set the font of the spinner to match the size of the table
        PopoutSpinner.setFont(new Font("Montserrat", Font.PLAIN, 50));
        ((JSpinner.DefaultEditor) PopoutSpinner.getEditor()).getTextField().setEditable(false);
    }

    public String[] dataVentas() {
        return new String[]{
                VentasTxtCodigo.getText(),
                VentasTxtNombre.getText(),
                VentasTxtGrado.getText(),
                VentasTxtSaldo.getText(),
                VentasTxtTotalActual.getText(),
        };
    }

    public String[] idProductos() {
        //get  the values from  the first collumn of all the rows in ventasFacturaActualTable
        String[] ids = new String[VentasFacturaActualTable.getRowCount()];
        for (int i = 0; i < VentasFacturaActualTable.getRowCount(); i++) {
            ids[i] = VentasFacturaActualTable.getValueAt(i, 0).toString();
        }
        return ids;
    }

    public String[] cantidadesProductos() {
        String[] cantidades = new String[VentasFacturaActualTable.getRowCount()];
        for (int i = 0; i < VentasFacturaActualTable.getRowCount(); i++) {
            cantidades[i] = VentasFacturaActualTable.getValueAt(i, 2).toString();
        }
        return cantidades;
    }

    public String[] dataAbonos() {
        return new String[]{
                AbonosTxtCodigo.getText(),
                AbonosTxtNombre.getText(),
                AbonosTxtGrado.getText(),
                AbonosTxtSaldoActual.getText(),
                AbonosTxTAbonar.getText(),
                AbonosTxtSaldoFinal.getText()

        };
    }

    public String[] dataHistorial() {
        return new String[]{
                HistorialTxtCodigo.getText(),
                HistorialTxtNombre.getText(),
                HistorialTxtGrado.getText(),
                HistorialTxtSaldo.getText()

        };
    }

    public String[] dataUsuarios() {
        return new String[]{
                UsuariosTxTcodigo.getText(),
                UsuariosTxtUser.getText(),
                UsuariosTxtNombre.getText(),
                String.valueOf(UsuariosTxtContra.getPassword()),
                UsuariosComboTipo.getSelectedItem().toString()
        };
    }

    public String[] dataProductos() {
        if (ProductosComboCategoria.getSelectedIndex() == 0) {
            return new String[]{
                    ProductosTxTCodigo.getText(),
                    ProductosTxtNombre.getText(),
                    ProductosTxtPrecio.getText(),
                    "",

            };
        } else {
            String[] data = {
                    ProductosTxTCodigo.getText(),
                    ProductosTxtNombre.getText(),
                    ProductosTxtPrecio.getText(),
                    ProductosComboCategoria.getSelectedItem().toString(),
            };
            if (!data[3].equals("") && !ProductosTxtNombre.getText().equals("") && ProductosTxtPrecio.getText().matches("^[0-9]*\\.?[0-9]*$")) {
                ProductosBtnEditar.setEnabled(true);
                ProductosBtnGuardar.setEnabled(true);
            } else {
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
        VentasTxtSaldo.setText("0.0");
        VentasTxtSaldo.setBackground(Color.white);
        VentasTxtTotalActual.setText("0.0");
        VentasTxtTotalActual.setBackground(Color.white);
        VentasFacturaActualTable.setModel(new DefaultTableModel(null, new String[]{"Codigo", "Nombre", "Cantidad", "Total"}));

        //bloquear botones ventas
        VentasBtnAlmuerzos.setEnabled(false);
        VentasBtnBebidas.setEnabled(false);
        VentasBtnDesayunos.setEnabled(false);
        VentasBtnOtros.setEnabled(false);
        VentasBtnSnacks.setEnabled(false);
        VentasBtnPostres.setEnabled(false);

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
        HistorialTableFactura.setModel(new DefaultTableModel(null, new String[]{"Categoria", "Producto", "Cantidad", "Precio", "Subtotal"}));
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
        ProductosBtnBorrar.setEnabled(false);

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

    void fonts() {
        Font font = new Font("Monserrat", Font.PLAIN, 20);
        AppTitulo.setFont(font);
        AppBtnCerrarSesion.setFont(font);
        //All Ventas' labels
        VentasCodigoAlumno.setFont(font);
        VentasNombre.setFont(font);
        VentasGrado.setFont(font);
        VentasSaldo.setFont(font);
        VentasGrado.setFont(font);
        VentasLabelFactura.setFont(font);
        VentasLabelTotal.setFont(font);
        VentasLabelProductos.setFont(font);
        //All ventas text boxes
        VentasTxtCodigo.setFont(font);
        VentasTxtNombre.setFont(font);
        VentasTxtGrado.setFont(font);
        VentasTxtSaldo.setFont(font);
        VentasTxtTotalActual.setFont(font);
        //All ventas buttons
        VentasBtnLimpiar.setFont(font);
        VentasBtnCancelar.setFont(font);
        VentasBtnBorrar.setFont(font);
        VentasBtnCobrar.setFont(font);
        //All Abono's labels
        AbonosLabelCodigo.setFont(font);
        AbonosLabelNombre.setFont(font);
        AbonosLabelGrado.setFont(font);
        AbonosLabelSaldoActual.setFont(font);
        AbonosLabelAbonar.setFont(font);
        AbonosLabelSaldoFinal.setFont(font);
        //All abonos text boxes
        AbonosTxtCodigo.setFont(font);
        AbonosTxtNombre.setFont(font);
        AbonosTxtGrado.setFont(font);
        AbonosTxtSaldoActual.setFont(font);
        AbonosTxTAbonar.setFont(font);
        AbonosTxtSaldoFinal.setFont(font);
        //All abonos buttons
        AbonoBtnCancelar.setFont(font);
        AbonoBtnAbonar.setFont(font);
        //All historial labels
        HistorialLabelCodigo.setFont(font);
        HistorialLabelNombre.setFont(font);
        HistorialLabelGrado.setFont(font);
        HistorialLabelSaldo.setFont(font);
        HistorialLabelCalendario.setFont(font);
        HistorialLabelFacturaShort.setFont(font);
        HsitorialLabelFactura.setFont(font);
        //All historial text boxes
        HistorialTxtCodigo.setFont(font);
        HistorialTxtNombre.setFont(font);
        HistorialTxtGrado.setFont(font);
        HistorialTxtSaldo.setFont(font);
        HistorialTxTYear.setFont(font);
        HistorialComboDia.setFont(font);
        HistorialComboMes.setFont(font);
        //Historial Btns
        HistorialBtnLimpiar.setFont(font);
        //All usuarios labels
        UsuariosLabelCodigo.setFont(font);
        UsuariosLabelUsuarios.setFont(font);
        UsuariosLabelNombre.setFont(font);
        UsuarioLabelContra.setFont(font);
        UsuariosLabelTipo.setFont(font);
        //All usuarios text fields
        UsuariosTxTcodigo.setFont(font);
        UsuariosTxtUser.setFont(font);
        UsuariosTxtNombre.setFont(font);
        UsuariosTxtContra.setFont(font);
        UsuariosComboTipo.setFont(font);
        //All usuarios buttons
        UsuariosBtnGuardar.setFont(font);
        UsuariosBtnBorrar.setFont(font);
        UsuariosBtnActualizar.setFont(font);
        UsuariosBtnCancelar.setFont(font);
        UsuariosBtnCancelar.setFont(font);
        //All Productos labels
        ProductosLabelCodigo.setFont(font);
        ProductosLabelNombre.setFont(font);
        ProductosLabelPrecio.setFont(font);
        ProductosLabelTipo.setFont(font);
        //All Productos text fields
        ProductosTxTCodigo.setFont(font);
        ProductosTxtNombre.setFont(font);
        ProductosTxtPrecio.setFont(font);
        ProductosComboCategoria.setFont(font);
        //All Productos buttons
        ProductosBtnGuardar.setFont(font);
        ProductosBtnEditar.setFont(font);
        ProductosBtnCancelar.setFont(font);
        ProductosBtnBorrar.setFont(font);


    }
}

package vistas;

import com.itextpdf.text.log.Logger;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger.Level;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class JInternalFrame_ingresos extends javax.swing.JInternalFrame {

    Conexion con = new Conexion();
    java.sql.Connection cn = con.Conexion();
    
    ComboProductos cb = new ComboProductos();
    ComboProveedores cp = new ComboProveedores();
    NumeroEntradas ne = new NumeroEntradas();
    Date date = new Date();
    private DefaultTableModel dtm;
    private Object[] o = new Object[16];

    public JInternalFrame_ingresos() {

        initComponents();

        cb.rellenarcombos("productos", "nombre", this.ComboProductos);
        cp.rellenarcomboproveedores("proveedores", "razonsocial", this.ComboProveedor);
        ne.numerosEntradas("entradas", "entrada", this.txtEntrada);

        txtEntrada.setVisible(false);

        int entrada = Integer.parseInt(txtEntrada.getText());
        int entradaIncrementada = entrada + 1;
        txtEntrada1.setText(String.valueOf(entradaIncrementada));

        ComboProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) ComboProductos.getSelectedItem();
                if (selectedItem != null) {
                    String[] detalles = cb.obtenerDetalles("productos", selectedItem, "formafarmaceutica", "presentacioncomercial");
                    txtFormafarmaceutica.setText(detalles[0]);
                    txtPresentacion.setText(detalles[1]);
                }
            }
        });

        dtm = (DefaultTableModel) tablaEntradaswing.getModel();

        DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        txtFecha.setText(formateador.format(date));
        tamano();
    }

    private void tamano() {
        TableColumnModel columnModel = this.tablaEntradaswing.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(180);
        columnModel.getColumn(7).setPreferredWidth(150);
        columnModel.getColumn(8).setPreferredWidth(80);
        columnModel.getColumn(9).setPreferredWidth(180);
        columnModel.getColumn(10).setPreferredWidth(200);
        columnModel.getColumn(11).setPreferredWidth(200);
        columnModel.getColumn(12).setPreferredWidth(200);
        columnModel.getColumn(13).setPreferredWidth(200);
        columnModel.getColumn(14).setPreferredWidth(200);
    }

    void limpiarcampos() {

        ComboProductos.setSelectedIndex(0);
        txtFormafarmaceutica.setText("");
        txtPresentacion.setText("");
        txtCantidad.setText("");
        txtLaboratorio.setText("");
        txtLote.setText("");
        txtFechavencimiento.setText("");
        ComboEstadoresgistro.setSelectedIndex(0);
        txtRegistroinvima.setText("");
        ComboCadenafrio.setSelectedIndex(0);
        txtTemperatura.setText("");
        ComboCondicionesfidicas.setSelectedIndex(0);
    }
    
    void crearpdf(){
         try {
              JasperReport reporte = JasperCompileManager.compileReport("reportes\\Reporte_entrada.jrxml");
              JasperPrint print = JasperFillManager.fillReport(reporte, null, JInternalFrame_ingresos.this.cn);
              JasperViewer view = new JasperViewer(print, false);
              view.setVisible(true);
            } catch (JRException ex) {
    //          Logger.getLogger(JInternalFrame_ingresos.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
              JOptionPane.showMessageDialog(null, ex);  
            } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntradaswing = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ComboProveedor = new javax.swing.JComboBox<>();
        ComboProductos = new javax.swing.JComboBox<>();
        txtFormafarmaceutica = new javax.swing.JTextField();
        txtPresentacion = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtLaboratorio = new javax.swing.JTextField();
        txtRegistroinvima = new javax.swing.JTextField();
        txtFechavencimiento = new javax.swing.JTextField();
        txtLote = new javax.swing.JTextField();
        ComboEstadoresgistro = new javax.swing.JComboBox<>();
        ComboCadenafrio = new javax.swing.JComboBox<>();
        txtTemperatura = new javax.swing.JTextField();
        ComboCondicionesfidicas = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ComboDonacion = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtEntrada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        txtEntrada1 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Recepcion / Ingresos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setName(""); // NOI18N

        tablaEntradaswing.setAutoCreateRowSorter(true);
        tablaEntradaswing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Entrada", "Proveedor", "Donacion", "Descripción", "Forma Farmaceutica", "Presentacion Comercial", "Cantidad", "Laboratorio", "Lote", "Fecha Vencimiento", "Estado", "Registro", "C. Frio", "T°", "Condiciones", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEntradaswing);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Proveedor");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("Donacion");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Descrpcion");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("forma farmaceutica");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Presentacion comercial");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("laboratorio");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel8.setText("lote");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("Cadena de frio");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel10.setText("estado del registro");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel11.setText("Registro invima");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel12.setText("fecha vencimiento");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel13.setText("Cantidad");

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel14.setText("temperatura");

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel15.setText("condiciones fisicas");

        ComboProveedor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ComboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        ComboProductos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ComboProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        ComboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboProductosActionPerformed(evt);
            }
        });

        txtFormafarmaceutica.setEditable(false);
        txtFormafarmaceutica.setBackground(new java.awt.Color(204, 204, 204));
        txtFormafarmaceutica.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N

        txtPresentacion.setEditable(false);
        txtPresentacion.setBackground(new java.awt.Color(204, 204, 204));
        txtPresentacion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N

        txtCantidad.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N

        txtLaboratorio.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N

        txtRegistroinvima.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N

        txtFechavencimiento.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N

        txtLote.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N

        ComboEstadoresgistro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ComboEstadoresgistro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Vigente", "En tramite", "Proximo a Vencer", "Otro" }));

        ComboCadenafrio.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ComboCadenafrio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\"", "Si", "No" }));
        ComboCadenafrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCadenafrioActionPerformed(evt);
            }
        });

        txtTemperatura.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N

        ComboCondicionesfidicas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ComboCondicionesfidicas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Bueno", "Malo", "Regular" }));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButton2.setText("eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButton3.setText("agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ComboDonacion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ComboDonacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\"\"", "Si", "No" }));

        jButton5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButton5.setText("Crear Entrada");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButton6.setText("Exportar PDF");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButton4.setText("Limpiar Campos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 55, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFormafarmaceutica, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPresentacion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLaboratorio, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(70, 70, 70))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(55, 55, 55)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ComboEstadoresgistro, 0, 270, Short.MAX_VALUE)
                                            .addComponent(txtRegistroinvima)
                                            .addComponent(txtLote)
                                            .addComponent(txtFechavencimiento)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboCondicionesfidicas, 0, 270, Short.MAX_VALUE)
                                    .addComponent(ComboCadenafrio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTemperatura))))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)))
                        .addGap(6, 6, 6))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ComboDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(txtRegistroinvima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFormafarmaceutica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(ComboEstadoresgistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(ComboCadenafrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15)
                            .addComponent(ComboCondicionesfidicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechavencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(13, 13, 13)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        txtEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("Entrada");

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jLabel17.setText("Recepciones / Ingresos");

        txtFecha.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtFecha.setText("jLabel18");

        txtEntrada1.setBackground(new java.awt.Color(102, 255, 204));
        txtEntrada1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtEntrada1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEntrada1.setEnabled(false);
        txtEntrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntrada1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtFecha)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void ComboCadenafrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCadenafrioActionPerformed
    }//GEN-LAST:event_ComboCadenafrioActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (txtCantidad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Digite la cantidad a Ingresar");
        } else {
            Object[] o = new Object[16];
            o[0] = txtEntrada1.getText().trim();
            o[1] = ComboProveedor.getSelectedItem();
            o[2] = ComboDonacion.getSelectedItem();
            o[3] = ComboProductos.getSelectedItem();
            o[4] = txtFormafarmaceutica.getText().trim();
            o[5] = txtPresentacion.getText().trim();
            o[6] = txtCantidad.getText().trim();
            o[7] = txtLaboratorio.getText().trim();
            o[8] = txtLote.getText().trim();
            o[9] = txtFechavencimiento.getText().trim();
            o[10] = txtRegistroinvima.getText().trim();
            o[11] = ComboEstadoresgistro.getSelectedItem();
            o[12] = ComboCadenafrio.getSelectedItem();
            o[13] = txtTemperatura.getText().trim();
            o[14] = ComboCondicionesfidicas.getSelectedItem();
            o[15] = txtFecha.getText().trim();

            dtm.addRow(o);
            limpiarcampos();

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntradaActionPerformed

    private void ComboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboProductosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tablaEntradaswing.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado un registro de la tabla", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            dtm.removeRow(tablaEntradaswing.getSelectedRow());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limpiarcampos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            for (int i = 0; i < tablaEntradaswing.getRowCount(); i++) {
                PreparedStatement ps = (PreparedStatement) cn.prepareStatement("INSERT INTO basedatos(descripcion,formafarmaceutica,presentacioncomercial,laboratorio,lote,fechaingreso,cantidad)VALUES(?,?,?,?,?,?,?)");
                ps.setString(1, tablaEntradaswing.getValueAt(i, 3).toString());
                ps.setString(2, tablaEntradaswing.getValueAt(i, 4).toString());
                ps.setString(3, tablaEntradaswing.getValueAt(i, 5).toString());
                ps.setString(4, tablaEntradaswing.getValueAt(i, 7).toString());
                ps.setString(5, tablaEntradaswing.getValueAt(i, 8).toString());
                ps.setString(6, tablaEntradaswing.getValueAt(i, 15).toString());
                ps.setString(7, tablaEntradaswing.getValueAt(i, 6).toString());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            JOptionPane.showConfirmDialog(rootPane, "Error al registrar, verifique nuevamente");
        }

        try {
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement("INSERT INTO entradas(entrada,proveedor,donacion,descripcion,formafarmaceutica,presentacion,cantidad,laboratorio,lote,fechavencimiento,registroinvima,estadoresgistro,cadenafrio,temperatura,condicionesfisicas,fechaingreso)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            for (int i = 0; i < tablaEntradaswing.getRowCount(); i++) {
                ps.setString(1, tablaEntradaswing.getValueAt(i, 0).toString());
                ps.setString(2, tablaEntradaswing.getValueAt(i, 1).toString());
                ps.setString(3, tablaEntradaswing.getValueAt(i, 2).toString());
                ps.setString(4, tablaEntradaswing.getValueAt(i, 3).toString());
                ps.setString(5, tablaEntradaswing.getValueAt(i, 4).toString());
                ps.setString(6, tablaEntradaswing.getValueAt(i, 5).toString());
                ps.setString(7, tablaEntradaswing.getValueAt(i, 6).toString());
                ps.setString(8, tablaEntradaswing.getValueAt(i, 7).toString());
                ps.setString(9, tablaEntradaswing.getValueAt(i, 8).toString());
                ps.setString(10, tablaEntradaswing.getValueAt(i, 9).toString());
                ps.setString(11, tablaEntradaswing.getValueAt(i, 10).toString());
                ps.setString(12, tablaEntradaswing.getValueAt(i, 11).toString());
                ps.setString(13, tablaEntradaswing.getValueAt(i, 12).toString());
                ps.setString(14, tablaEntradaswing.getValueAt(i, 13).toString());
                ps.setString(15, tablaEntradaswing.getValueAt(i, 14).toString());
                ps.setString(16, tablaEntradaswing.getValueAt(i, 15).toString());
                ps.executeUpdate();
            }
            JOptionPane.showConfirmDialog(rootPane, "Entradas Guardadas correctamente, ¿Desea Imprimir?", "NOTIFICACION", JOptionPane.YES_NO_OPTION);
            dtm.setRowCount(0);
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            JOptionPane.showConfirmDialog(rootPane, "Error al registrar, verifique nuevamente");
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtEntrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntrada1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntrada1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboCadenafrio;
    private javax.swing.JComboBox<String> ComboCondicionesfidicas;
    private javax.swing.JComboBox<String> ComboDonacion;
    private javax.swing.JComboBox<String> ComboEstadoresgistro;
    private javax.swing.JComboBox<String> ComboProductos;
    private javax.swing.JComboBox<String> ComboProveedor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEntradaswing;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtEntrada1;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JTextField txtFechavencimiento;
    private javax.swing.JTextField txtFormafarmaceutica;
    private javax.swing.JTextField txtLaboratorio;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtPresentacion;
    private javax.swing.JTextField txtRegistroinvima;
    private javax.swing.JTextField txtTemperatura;
    // End of variables declaration//GEN-END:variables
}

package vistas;

import com.mysql.jdbc.PreparedStatement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import modelo.*;

public class JinternalFrame_salidas extends javax.swing.JInternalFrame {

    Conexion con = new Conexion();
    java.sql.Connection cn = con.Conexion();
    String atributo = "id";

    private TableRowSorter trsfiltro;

    Date date = new Date();

    private DefaultTableModel dtm;
    private Object[] o = new Object[9];

    NumeroSalidas ne = new NumeroSalidas();

    public JinternalFrame_salidas() {
        initComponents();
        ne.numerosSalidas("salidas", "idsalidas", this.txtSalida);
        txtSalida.setVisible(false);
        txtresultado.setVisible(false);
        txtId.setVisible(false);

        int salida = Integer.parseInt(txtSalida.getText());
        int entradaIncrementada = salida + 1;
        txtSalida1.setText(String.valueOf(entradaIncrementada));
        mostrartabla1("");
        tamañocolumnas();
       // tamañocolumnas1();
        DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        txtFecha.setText(formateador.format(date));

        dtm = (DefaultTableModel) tablaSalida.getModel();

    }

    void mostrartabla1(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Forma Farmaceutica");
        modelo.addColumn("Presentacion");
        modelo.addColumn("Laboratorio");
        modelo.addColumn("Lote");
        modelo.addColumn("Fecha Ingreso");
        modelo.addColumn("Cantidad");
        tablaProducto.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM basedatos";
        } else {
            sql = "SELECT * FROM basedatos WHERE " + atributo + "='" + valor + "'";
        }
        String datos[] = new String[8];
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                modelo.addRow(datos);
            }
            tablaProducto.setModel(modelo);

        } catch (SQLException ex) {
            Logger.getLogger(JinternalFrame_salidas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    void tamañocolumnas() {
        TableColumnModel columnModel = this.tablaProducto.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(0);
        columnModel.getColumn(1).setPreferredWidth(270);
        columnModel.getColumn(2).setPreferredWidth(170);
        columnModel.getColumn(3).setPreferredWidth(120);
        columnModel.getColumn(4).setPreferredWidth(150);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(80);
    }

//    void tamañocolumnas1() {
//        TableColumnModel columnModel = this.tablaSalida.getColumnModel();
//        columnModel.getColumn(0).setMaxWidth(2);
//        columnModel.getColumn(1).setMaxWidth(2);
//        columnModel.getColumn(2).setMaxWidth(270);
//        columnModel.getColumn(3).setMaxWidth(100);
//        columnModel.getColumn(4).setMaxWidth(100);
//        columnModel.getColumn(5).setMaxWidth(100);
//        columnModel.getColumn(6).setMaxWidth(100);
//        columnModel.getColumn(7).setMaxWidth(80);
//        columnModel.getColumn(8).setMaxWidth(100);
//        columnModel.getColumn(9).setMaxWidth(80);
//    }

    void actualizartabla() {
        int cantidadViejaInt = Integer.parseInt(cantidadVieja.getText().trim());
        int cantidadSalidaInt = Integer.parseInt(cantidadSalida.getText().trim());
        int resultado = cantidadViejaInt - cantidadSalidaInt;
        txtresultado.setText(Integer.toString(resultado));

        try {
            PreparedStatement pps = (PreparedStatement) cn.prepareStatement("UPDATE basedatos SET cantidad='" + txtresultado.getText() + "'WHERE id='" + txtId.getText() + "'");
            pps.executeUpdate();
            mostrartabla1("");
            tamañocolumnas();
        } catch (SQLException ex) {
            Logger.getLogger(JInternalFrame_proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void filtro() {
        this.trsfiltro.setRowFilter(RowFilter.regexFilter(this.buscador.getText(), new int[]{
            1, 2, 3, 4, 5, 6, 7}));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtFecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSalida = new javax.swing.JTextField();
        txtSalida1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtresultado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtResponsable = new javax.swing.JTextField();
        comboMunicipio = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSalida = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cantidadVieja = new javax.swing.JTextField();
        cantidadSalida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buscador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Salidas");

        jPanel2.setBackground(new java.awt.Color(51, 204, 0));

        txtFecha.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtFecha.setText("jLabel18");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 48)); // NOI18N
        jLabel1.setText("Salida");

        txtSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalidaActionPerformed(evt);
            }
        });

        txtSalida1.setBackground(new java.awt.Color(102, 255, 204));
        txtSalida1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtSalida1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSalida1.setText("1");
        txtSalida1.setEnabled(false);
        txtSalida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalida1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel6.setText("Salida");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txtresultado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalida1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtFecha)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSalida1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtresultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRODUCTO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaProducto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaProducto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMACION ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jLabel2.setText("Responsable");

        jLabel3.setText("Municipio");

        comboMunicipio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hato Corozal", "Pore", "SAcama", "La Salina", "Paz de Ariporo", "San luis de Palenque", "Nunchia", "La Yopalosa", "Tamara", "Trinidad", "Bocas del Pauto", "Orocue", "Sabanalarga", "Chameza", "Mani", "Monterrey", "Recetor", "Villanueva" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(comboMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(comboMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMACION DE LA SALIDA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        tablaSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "I", "I", "Descripcion", "Forma Farmaceutica", "Presentacion", "Laboratorio", "Lote", "Cantidad", "Municipio", "Fecha Salida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaSalida);

        jButton2.setText("eLIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Generar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Existencias");

        jLabel5.setText("Cantidad Salida");

        buscador.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                buscadorComponentAdded(evt);
            }
        });
        buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorActionPerformed(evt);
            }
        });
        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscadorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscadorKeyTyped(evt);
            }
        });

        jLabel7.setText("Buscador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(271, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2))
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(16, 16, 16))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cantidadSalida, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cantidadVieja, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel4)))
                                .addGap(15, 15, 15))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(cantidadVieja, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidadSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalidaActionPerformed

    private void txtSalida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalida1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalida1ActionPerformed

    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked
        // TODO add your handling code here:
        int fila = tablaProducto.getSelectedRow();
        if (fila >= 0) {
            txtId.setText(tablaProducto.getValueAt(fila, 0).toString());
            cantidadVieja.setText(tablaProducto.getValueAt(fila, 7).toString());

        } else {
            JOptionPane.showMessageDialog(null, "fila no seleccionada");
        }
        tamañocolumnas();
    }//GEN-LAST:event_tablaProductoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (cantidadSalida.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Digite la cantidad que desea sacar");
        } else {
            try {
                int cantidadViejaInt = Integer.parseInt(cantidadVieja.getText().trim());
                int cantidadSalidaInt = Integer.parseInt(cantidadSalida.getText().trim());
                if (cantidadViejaInt < cantidadSalidaInt) {
                    JOptionPane.showMessageDialog(rootPane, "No hay cantidad suficiente de insumos. Pruebe con una cantidad menor o complete con el mismo producto de otro lote.");
                } else {
                    int[] selectedRows = tablaProducto.getSelectedRows();

                    if (selectedRows.length > 0) {
                        for (int i = 0; i < selectedRows.length; i++) {
                            Object[] o = new Object[10];
                            o[1] = txtSalida1.getText().trim();
                            o[0] = tablaProducto.getValueAt(selectedRows[i], 0);
                            o[2] = tablaProducto.getValueAt(selectedRows[i], 1);
                            o[3] = tablaProducto.getValueAt(selectedRows[i], 2);
                            o[4] = tablaProducto.getValueAt(selectedRows[i], 3);
                            o[5] = tablaProducto.getValueAt(selectedRows[i], 4);
                            o[6] = tablaProducto.getValueAt(selectedRows[i], 5);
                            o[8] = comboMunicipio.getSelectedItem();
                            o[7] = cantidadSalida.getText().trim();
                            o[9] = txtFecha.getText().trim();
                            actualizartabla();
                            dtm.addRow(o);
                        }
                        cantidadSalida.setText("");
                        cantidadVieja.setText("");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Seleccione al menos una fila del producto");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Por favor, ingrese cantidades válidas");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tablaSalida.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado un registro de la tabla", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            int selectedRow = tablaSalida.getSelectedRow();
            // Recuperar la cantidad eliminada y el ID del producto
            int cantidadEliminada = Integer.parseInt(tablaSalida.getValueAt(selectedRow, 7).toString());
            int idProducto = Integer.parseInt(tablaSalida.getValueAt(selectedRow, 0).toString());

            // Recuperar la cantidad actual del producto de la tabla 1
            int cantidadActual = 0;
            for (int i = 0; i < tablaProducto.getRowCount(); i++) {
                if (Integer.parseInt(tablaProducto.getValueAt(i, 0).toString()) == idProducto) {
                    cantidadActual = Integer.parseInt(tablaProducto.getValueAt(i, 7).toString());
                    break;
                }
            }

            // Sumar la cantidad eliminada a la cantidad actual
            int nuevaCantidad = cantidadActual + cantidadEliminada;

            // Actualizar la base de datos con la nueva cantidad
            try {
                PreparedStatement pps = (PreparedStatement) cn.prepareStatement("UPDATE basedatos SET cantidad=? WHERE id=?");
                pps.setInt(1, nuevaCantidad);
                pps.setInt(2, idProducto);
                pps.executeUpdate();
                mostrartabla1("");
                tamañocolumnas();
            } catch (SQLException ex) {
                Logger.getLogger(JInternalFrame_proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Eliminar la fila de la tabla 2
            dtm.removeRow(selectedRow);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement("INSERT INTO salidas(salida,descripcion,formafarmaceutica,presentacion,laboratorio,lote,cantidad,municipio,fechasalida)VALUES(?,?,?,?,?,?,?,?,?)");
            for (int i = 0; i < tablaSalida.getRowCount(); i++) {
                ps.setString(1, tablaSalida.getValueAt(i, 1).toString());
                ps.setString(2, tablaSalida.getValueAt(i, 2).toString());
                ps.setString(3, tablaSalida.getValueAt(i, 3).toString());
                ps.setString(4, tablaSalida.getValueAt(i, 4).toString());
                ps.setString(5, tablaSalida.getValueAt(i, 5).toString());
                ps.setString(6, tablaSalida.getValueAt(i, 6).toString());
                ps.setString(7, tablaSalida.getValueAt(i, 7).toString());
                ps.setString(8, tablaSalida.getValueAt(i, 8).toString());
                ps.setString(9, tablaSalida.getValueAt(i, 9).toString());
                ps.executeUpdate();
            }
            JOptionPane.showConfirmDialog(rootPane, "Salidas Guardadas correctamente, ¿Desea Imprimir?", "NOTIFICACION", JOptionPane.YES_NO_OPTION);
            dtm.setRowCount(0);
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            JOptionPane.showConfirmDialog(rootPane, "Error al registrar, verifique nuevamente");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorActionPerformed

    private void buscadorComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_buscadorComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorComponentAdded

    private void buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_buscadorKeyReleased

    private void buscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyTyped
        // TODO add your handling code here:
        this.buscador.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String cadena = JinternalFrame_salidas.this.buscador.getText();
                JinternalFrame_salidas.this.buscador.setText(cadena);
                JinternalFrame_salidas.this.filtro();
            }
        });
        this.trsfiltro = new TableRowSorter<>(this.tablaProducto.getModel());
        this.tablaProducto.setRowSorter(this.trsfiltro);

    }//GEN-LAST:event_buscadorKeyTyped

    private void buscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_buscadorKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscador;
    private javax.swing.JTextField cantidadSalida;
    private javax.swing.JTextField cantidadVieja;
    private javax.swing.JComboBox<String> comboMunicipio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTable tablaSalida;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtResponsable;
    private javax.swing.JTextField txtSalida;
    private javax.swing.JTextField txtSalida1;
    private javax.swing.JTextField txtresultado;
    // End of variables declaration//GEN-END:variables
}

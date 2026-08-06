
package mvcguifinal;

import controller.ventasController; // <-- Agrega este import arriba de todo

public class menu_ventas extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(menu_ventas.class.getName());

    // Declaración del controlador
    private ventasController control;

    /**
     * Creates new form menu_ventas
     */
    public menu_ventas() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        // Instancia el controlador
        this.control = new ventasController(this);
    }    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminarClie = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFechaVenta = new javax.swing.JTextField();
        txtTotalVenta = new javax.swing.JTextField();
        cbxClienteId = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();
        btnAgregarVentas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxFormaPago1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        btnEliminarClie1 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizarCli = new javax.swing.JButton();

        btnEliminarClie.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarClie.setText("Eliminar");
        btnEliminarClie.addActionListener(this::btnEliminarClieActionPerformed);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Menu Ventas");

        jLabel2.setText("Fecha de venta");

        jLabel3.setText("Total de venta");

        jLabel4.setText("Forma de pago");

        btnSalir.setText("Regresar");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        btnAgregarVentas.setText("Guardar");
        btnAgregarVentas.addActionListener(this::btnAgregarVentasActionPerformed);

        jLabel5.setText("Cliente");

        cbxFormaPago1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta", "Efectivo" }));

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "IdCliente", "FechaVenta", "TotalVenta", "FormaPago"
            }
        ));
        tblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVentas);

        btnEliminarClie1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarClie1.setText("Eliminar");
        btnEliminarClie1.addActionListener(this::btnEliminarClie1ActionPerformed);

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        btnActualizarCli.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizarCli.setText("Actualizar");
        btnActualizarCli.addActionListener(this::btnActualizarCliActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSalir)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregarVentas)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarClie1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizarCli))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbxClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxFormaPago1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxFormaPago1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnAgregarVentas)
                    .addComponent(btnEliminarClie1)
                    .addComponent(btnLimpiar)
                    .addComponent(btnActualizarCli)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVentasActionPerformed
        // TODO add your handling code here:
        if (control != null) {
        control.insertarVentas();
    }
    }//GEN-LAST:event_btnAgregarVentasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        Menu inicio=new Menu();
        inicio.setVisible(true);

        this.dispose();
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentasMouseClicked
        int fila = tblVentas.getSelectedRow();
    
    if (fila >= 0 && tblVentas.getValueAt(fila, 0) != null) {
        // Asignación con los índices correctos según tu tabla:
        String idVenta = tblVentas.getValueAt(fila, 0).toString();
        String idCliente = tblVentas.getValueAt(fila, 1) != null ? tblVentas.getValueAt(fila, 1).toString() : "";
        String fechaVenta = tblVentas.getValueAt(fila, 2) != null ? tblVentas.getValueAt(fila, 2).toString() : "";
        String totalVenta = tblVentas.getValueAt(fila, 3) != null ? tblVentas.getValueAt(fila, 3).toString() : "";
        String formaPago = tblVentas.getValueAt(fila, 4) != null ? tblVentas.getValueAt(fila, 4).toString() : "";

        // 1. Cargar datos en los campos de texto
        txtFechaVenta.setText(fechaVenta);
        txtTotalVenta.setText(totalVenta);

        // 2. Cargar datos en los ComboBox
        if (cbxFormaPago1 != null) {
            cbxFormaPago1.setSelectedItem(formaPago);
        }

        // 3. Seleccionar el cliente correspondiente en el ComboBox
        for (int i = 0; i < cbxClienteId.getItemCount(); i++) {
            String item = cbxClienteId.getItemAt(i);
            if (item != null && item.startsWith(idCliente + " - ")) {
                cbxClienteId.setSelectedIndex(i);
                break;
            }
        }
    }
    }//GEN-LAST:event_tblVentasMouseClicked

    private void btnEliminarClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClieActionPerformed
        // TODO add your handling code here:
        ventasController control = new ventasController(this);
        control.eliminarVentas();
        limpiar();
    }//GEN-LAST:event_btnEliminarClieActionPerformed

    private void btnEliminarClie1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClie1ActionPerformed
        // TODO add your handling code here:
        ventasController control = new ventasController(this);
        control.eliminarVentas();
        limpiar();
    }//GEN-LAST:event_btnEliminarClie1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActualizarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCliActionPerformed
        if (control != null) {
        // 1. Primero actualiza (lee los datos que seleccionaste en la pantalla)
        control.actualizarVentas();
        
        // 2. DESPUÉS de actualizar, si quieres, limpias los campos
        limpiar(); 
    }
    }//GEN-LAST:event_btnActualizarCliActionPerformed

    /**
     * @param args the command line arguments
     */
    public void limpiar() {
        // 1. Limpiar campos de texto
        txtFechaVenta.setText("");
        txtTotalVenta.setText("");

        // 2. Reiniciar ComboBoxes
        if (cbxClienteId.getItemCount() > 0) {
            cbxClienteId.setSelectedIndex(0);
        }

        if (cbxFormaPago1.getItemCount() > 0) {
            cbxFormaPago1.setSelectedIndex(0);
        }

        // 3. Quitar selección de la tabla
        tblVentas.clearSelection();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // ...
        java.awt.EventQueue.invokeLater(() -> new menu_ventas().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarCli;
    private javax.swing.JButton btnAgregarVentas;
    public javax.swing.JButton btnEliminarClie;
    public javax.swing.JButton btnEliminarClie1;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cbxClienteId;
    public javax.swing.JComboBox<String> cbxFormaPago1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblVentas;
    public javax.swing.JTextField txtFechaVenta;
    public javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables
}

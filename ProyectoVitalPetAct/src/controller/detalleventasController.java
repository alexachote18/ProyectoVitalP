package controller;

import dao.detalleventaDAO;
import dao.ventasDAO;
import dao.productosDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.detalleventa;
import modelo.ventas;
import modelo.producto;
import mvcguifinal.menu_detalle_ventas;

public class detalleventasController {
    private menu_detalle_ventas vista;
    private detalleventaDAO dao;
    private ventasDAO vDao;
    private productosDAO pDao;

    public detalleventasController(menu_detalle_ventas vista) {
        this.vista = vista;
        this.dao = new detalleventaDAO();
        this.vDao = new ventasDAO();
        this.pDao = new productosDAO();
    }

    public detalleventasController() {
        this.dao = new detalleventaDAO();
        this.vDao = new ventasDAO();
        this.pDao = new productosDAO();
    }

    public void cargarComboVentas() {
        if (vista != null) {
            vista.cbxVentaId.removeAllItems();
            List<ventas> listaVentas = vDao.ListarVentas();
            for (ventas v : listaVentas) {
                vista.cbxVentaId.addItem(v.getIdVenta() + " - Total: $" + v.getTotalVenta());
            }
        }
    }

    public void cargarComboProductos() {
        if (vista != null) {
            vista.cbxProductoId.removeAllItems();
            List<producto> listaProductos = pDao.ListarProductos();
            for (producto p : listaProductos) {
                vista.cbxProductoId.addItem(p.getIdPro() + " - " + p.getNombrePro());
            }
        }
    }

  public void insertarDetalle() {
    try {
        String idVentaSel = vista.cbxVentaId.getSelectedItem().toString();
        int fkIdVenta = Integer.parseInt(idVentaSel.split(" - ")[0].trim());

        String idProductoSel = vista.cbxProductoId.getSelectedItem().toString();
        int fkIdProducto = Integer.parseInt(idProductoSel.split(" - ")[0].trim());

        int cantidad = Integer.parseInt(vista.txtCantidad.getText().trim());
        double precio = Double.parseDouble(vista.txtPrecio.getText().trim());
        double subtotal = cantidad * precio; // Cálculo automático directo

        detalleventa dv = new detalleventa();
        dv.setCantidadDetalle(cantidad);
        dv.setPrecioDetalle(precio);
        dv.setSubtotalDetalle(subtotal);
        dv.setFkIdVenta(fkIdVenta);
        dv.setFkIdProducto(fkIdProducto);

        if (dao.insertarDetalle(dv)) {
            JOptionPane.showMessageDialog(null, "Detalle agregado con éxito");
            listarDetalles();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar el detalle");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Por favor ingrese cantidad y precio válidos");
    }
}

    public void actualizarDetalle() {
        int fila = vista.tblDetalleVentas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la tabla para actualizar");
            return;
        }

        try {
            int idDetalle = Integer.parseInt(vista.tblDetalleVentas.getValueAt(fila, 0).toString());

            String idVentaSel = vista.cbxVentaId.getSelectedItem().toString();
            int fkIdVenta = Integer.parseInt(idVentaSel.split(" - ")[0].trim());

            String idProductoSel = vista.cbxProductoId.getSelectedItem().toString();
            int fkIdProducto = Integer.parseInt(idProductoSel.split(" - ")[0].trim());

            int cantidad = Integer.parseInt(vista.txtCantidad.getText());
            double precio = Double.parseDouble(vista.txtPrecio.getText());
            double subtotal = cantidad * precio;

            detalleventa dv = new detalleventa();
            dv.setIdDetalle(idDetalle);
            dv.setCantidadDetalle(cantidad);
            dv.setPrecioDetalle(precio);
            dv.setSubtotalDetalle(subtotal);
            dv.setFkIdVenta(fkIdVenta);
            dv.setFkIdProducto(fkIdProducto);

            if (dao.actualizarDetalle(dv)) {
                JOptionPane.showMessageDialog(null, "Detalle actualizado con éxito");
                listarDetalles();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el detalle");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void listarDetalles() {
    if (vista != null) {
        DefaultTableModel modelo = (DefaultTableModel) vista.tblDetalleVentas.getModel();
        modelo.setRowCount(0);
        List<detalleventa> lista = dao.ListarDetalles();
        for (detalleventa dv : lista) {
            Object[] fila = {
                dv.getIdDetalle(),      // Columna 0: id Detalle
                dv.getFkIdVenta(),      // Columna 1: id Venta
                dv.getFkIdProducto(),   // Columna 2: id Producto
                dv.getCantidadDetalle(),// Columna 3: Cantidad
                dv.getPrecioDetalle(),  // Columna 4: Precio Unitario
                dv.getSubtotalDetalle() // Columna 5: Subtotal
            };
            modelo.addRow(fila);
        }
    }
}

    public void eliminarDetalle() {
        int fila = vista.tblDetalleVentas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la tabla");
            return;
        }
        int opc = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar este detalle?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.YES_OPTION) {
            int idDetalle = Integer.parseInt(vista.tblDetalleVentas.getValueAt(fila, 0).toString());
            if (dao.eliminarDetalle(idDetalle)) {
                JOptionPane.showMessageDialog(null, "Eliminado con éxito");
                listarDetalles();
                limpiarCampos();
            }
        }
    }

    public void limpiarCampos() {
    if (vista != null) {
        vista.txtCantidad.setText("");
        vista.txtPrecio.setText("");
        vista.txtSubtotal.setText(""); 
        if (vista.cbxVentaId.getItemCount() > 0) vista.cbxVentaId.setSelectedIndex(0);
        if (vista.cbxProductoId.getItemCount() > 0) vista.cbxProductoId.setSelectedIndex(0);
    }
}
    public void cargarDatosDesdeTabla() {
    int fila = vista.tblDetalleVentas.getSelectedRow();
    if (fila != -1) {
        // Tomar cantidad (columna 3), precio (columna 4) y subtotal (columna 5)
        vista.txtCantidad.setText(vista.tblDetalleVentas.getValueAt(fila, 3).toString());
        vista.txtPrecio.setText(vista.tblDetalleVentas.getValueAt(fila, 4).toString());
        vista.txtSubtotal.setText(vista.tblDetalleVentas.getValueAt(fila, 5).toString());

        // Seleccionar FK de Venta (columna 1) en el ComboBox
        String fkVenta = vista.tblDetalleVentas.getValueAt(fila, 1).toString();
        for (int i = 0; i < vista.cbxVentaId.getItemCount(); i++) {
            if (vista.cbxVentaId.getItemAt(i).startsWith(fkVenta + " -")) {
                vista.cbxVentaId.setSelectedIndex(i);
                break;
            }
        }

        // Seleccionar FK de Producto (columna 2) en el ComboBox
        String fkProducto = vista.tblDetalleVentas.getValueAt(fila, 2).toString();
        for (int i = 0; i < vista.cbxProductoId.getItemCount(); i++) {
            if (vista.cbxProductoId.getItemAt(i).startsWith(fkProducto + " -")) {
                vista.cbxProductoId.setSelectedIndex(i);
                break;
            }
        }
    }
    }
    public void calcularSubtotalAutomatico() {
    try {
        String cantStr = vista.txtCantidad.getText().trim();
        String precStr = vista.txtPrecio.getText().trim();

        if (!cantStr.isEmpty() && !precStr.isEmpty()) {
            int cantidad = Integer.parseInt(cantStr);
            double precio = Double.parseDouble(precStr);
            double subtotal = cantidad * precio;

            // Muestra el resultado automáticamente en la casilla
            vista.txtSubtotal.setText(String.valueOf(subtotal));
        } else {
            vista.txtSubtotal.setText("");
        }
    } catch (NumberFormatException e) {
        // Si el usuario escribe una letra o un formato inválido, limpia el subtotal
        vista.txtSubtotal.setText("");
    }
}
}
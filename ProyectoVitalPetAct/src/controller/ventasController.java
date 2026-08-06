package controller;

import dao.ventasDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.clientes;
import modelo.ventas;
import mvcguifinal.menu_ventas;


public class ventasController {
    private menu_ventas vista;
    private ventasDAO dao;

    public ventasController(menu_ventas vista) {
        this.vista = vista;
        this.dao = new ventasDAO();
        llenarComboClientes(); // Llena el ComboBox al abrir la pantalla
    }

    public ventasController() {
        this.dao = new ventasDAO();
    }

    // Carga los clientes en el cbxClienteId con el formato: "ID - Nombre Apellido"
    public void llenarComboClientes() {
        if (vista != null) {
            vista.cbxClienteId.removeAllItems();
            List<clientes> lista = dao.obtenerClientesCBX();
            for (clientes c : lista) {
                vista.cbxClienteId.addItem(c.getId() + " - " + c.getNombre() + " " + c.getApellido());
            }
        }
    }

    public void insertarVentas() {
        try {
            if (vista.cbxClienteId.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente");
                return;
            }

            ventas v = new ventas();
            v.setFechaVenta(vista.txtFechaVenta.getText());
            v.setTotalVenta(Double.parseDouble(vista.txtTotalVenta.getText()));
            v.setFormaPago(vista.cbxFormaPago1.getSelectedItem().toString());

            // Extrae correctamente el ID seleccionado del cliente (lo que está antes del ' - ')
            String clienteSeleccionado = vista.cbxClienteId.getSelectedItem().toString();
            int idCliente = Integer.parseInt(clienteSeleccionado.split(" - ")[0].trim());
            
            v.setIdCliente(idCliente);

            if (dao.insertarVenta(v)) {
                JOptionPane.showMessageDialog(null, "Venta Agregada");
                ListarVentas();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar la venta");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor revise los campos ingresados: " + e.getMessage());
        }
    }

    public void ListarVentas() {
        if (vista != null) {
            DefaultTableModel modelo = (DefaultTableModel) vista.tblVentas.getModel();
            modelo.setRowCount(0);
            List<ventas> lista = dao.ListarVentas();
            for (ventas v : lista) {
                Object[] fila = {
                    v.getIdVenta(),   // Columna 1: Id Venta
                    v.getIdCliente(), // Columna 2: IdCliente seleccionado
                    v.getFechaVenta(),// Columna 3: Fecha
                    v.getTotalVenta(),// Columna 4: Total
                    v.getFormaPago()  // Columna 5: Forma de pago
                };
                modelo.addRow(fila);
            }
        }
    }

    public void eliminarVentas() {
        int fila = vista.tblVentas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {
            int opc = JOptionPane.showConfirmDialog(null, "¿Deseas Eliminar este registro?", "Confirmar Accion", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.YES_OPTION) {
                int id_venta = Integer.parseInt(vista.tblVentas.getValueAt(fila, 0).toString());
                if (dao.eliminarVentas(id_venta)) {
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    ListarVentas();
                }
            }
        }
    }

   public void actualizarVentas() {
    int fila = vista.tblVentas.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        return;
    }
    try {
        ventas v = new ventas();
        v.setIdVenta(Integer.parseInt(vista.tblVentas.getValueAt(fila, 0).toString()));
        v.setFechaVenta(vista.txtFechaVenta.getText());
        v.setTotalVenta(Double.parseDouble(vista.txtTotalVenta.getText()));
        v.setFormaPago(vista.cbxFormaPago1.getSelectedItem().toString());

        // Captura del ComboBox
        String clienteSeleccionado = vista.cbxClienteId.getSelectedItem().toString();
        int idCliente = Integer.parseInt(clienteSeleccionado.split(" - ")[0].trim());
        
        // DEPURACIÓN: Ver qué ID se extrajo exactamente
        System.out.println("-> Texto ComboBox: " + clienteSeleccionado);
        System.out.println("-> ID Cliente extraído: " + idCliente);

        v.setIdCliente(idCliente);

        if (dao.actualizarVentas(v)) {
            JOptionPane.showMessageDialog(null, "Venta Actualizada");
            ListarVentas();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error en los datos ingresados: " + e.getMessage());
    }
}
}
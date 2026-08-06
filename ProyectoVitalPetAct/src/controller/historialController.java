package controller;

import dao.ventasDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.historialVenta;
import mvcguifinal.historialventas;

public class historialController {
    private historialventas vista;
    private ventasDAO vDao;

    public historialController(historialventas vista) {
        this.vista = vista;
        this.vDao = new ventasDAO();
    }

    public void cargarHistorial() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tblHistorial.getModel();
        modelo.setRowCount(0);
        
        List<historialVenta> lista = vDao.listarHistorial();
        for (historialVenta hv : lista) {
            Object[] fila = {
                hv.getFecha(),          // Columna 0: Fecha
                hv.getIdDetalle(),      // Columna 1: ID Detalle
                hv.getIdVenta(),        // Columna 2: ID Venta
                hv.getIdProducto(),     // Columna 3: ID Producto
                hv.getCantidad(),       // Columna 4: Cantidad
                hv.getPrecioUnitario(), // Columna 5: Precio Unitario
                hv.getSubtotal()        // Columna 6: Subtotal
            };
            modelo.addRow(fila);
        }
    }
}
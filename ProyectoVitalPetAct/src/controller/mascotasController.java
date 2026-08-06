package controller;

import dao.clientesDAO;
import dao.especiesDAO;
import dao.mascotasDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.clientes;
import modelo.especies;
import modelo.mascotas;
import mvcguifinal.menu_mascotas;

public class mascotasController {

    private menu_mascotas vista;
    private mascotasDAO dao;
    private especiesDAO espDao;
    private clientesDAO cliDao;

    private List<especies> listaEspecies;
    private List<clientes> listaClientes;

    public mascotasController(menu_mascotas vista) {
        this.vista = vista;
        this.dao = new mascotasDAO();
        this.espDao = new especiesDAO();
        this.cliDao = new clientesDAO();
        
        cargarComboEspecies();
        cargarComboClientes();
    }

    public void cargarComboEspecies() {
        listaEspecies = espDao.ListarEspecies();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (listaEspecies != null) {
            for (especies e : listaEspecies) {
                model.addElement(e.getNombreEsp());
            }
        }
        vista.getCbxEspecie().setModel(model);
    }

    public void cargarComboClientes() {
        listaClientes = cliDao.ListarClientes();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (listaClientes != null) {
            for (clientes c : listaClientes) {
                model.addElement(c.getNombre() + " " + (c.getApellido() != null ? c.getApellido() : ""));
            }
        }
        vista.getCbxCliente().setModel(model);
    }

    public void cargarDatosFormulario() {
        int fila = vista.tblMascotas.getSelectedRow();
        if (fila != -1) {
            vista.txtNombreMa.setText(vista.tblMascotas.getValueAt(fila, 1).toString());
            vista.txtRazaMa.setText(vista.tblMascotas.getValueAt(fila, 2) != null ? vista.tblMascotas.getValueAt(fila, 2).toString() : "");
            vista.txtNacimientoMa.setText(vista.tblMascotas.getValueAt(fila, 3) != null ? vista.tblMascotas.getValueAt(fila, 3).toString() : "");

            if (vista.tblMascotas.getValueAt(fila, 4) != null) {
                vista.cbxSexoMa.setSelectedItem(vista.tblMascotas.getValueAt(fila, 4).toString());
            }

            int idEspecie = Integer.parseInt(vista.tblMascotas.getValueAt(fila, 5).toString());
            int idCliente = Integer.parseInt(vista.tblMascotas.getValueAt(fila, 6).toString());

            // Seleccionar Especie en el combo según la lista original
            if (listaEspecies != null) {
                for (int i = 0; i < listaEspecies.size(); i++) {
                    if (listaEspecies.get(i).getIdEsp() == idEspecie) {
                        vista.getCbxEspecie().setSelectedIndex(i);
                        break;
                    }
                }
            }

            // Seleccionar Cliente en el combo según la lista original
            if (listaClientes != null) {
                for (int i = 0; i < listaClientes.size(); i++) {
                    if (listaClientes.get(i).getId() == idCliente) {
                        vista.getCbxCliente().setSelectedIndex(i);
                        break;
                    }
                }
            }
        }
    }

    public void insertarMascotas() {
    if (!validarCampos()) return;

    // Obtener la especie y cliente seleccionados en texto
    String nombreEspecie = vista.getCbxEspecie().getSelectedItem().toString();
    String comboCliente = vista.getCbxCliente().getSelectedItem().toString();

    int idEspecieReal = 1;
    int idClienteReal = 1;

    // Buscar ID de la especie seleccionada
    if (listaEspecies != null) {
        for (especies e : listaEspecies) {
            if (e.getNombreEsp().trim().equalsIgnoreCase(nombreEspecie.trim())) {
                idEspecieReal = e.getIdEsp(); // Obtiene el ID real de la especie
                break;
            }
        }
    }

    // Buscar ID del cliente seleccionado
    if (listaClientes != null) {
        for (clientes c : listaClientes) {
            String nombreCompleto = (c.getNombre() + " " + (c.getApellido() != null ? c.getApellido() : "")).trim();
            if (nombreCompleto.equalsIgnoreCase(comboCliente.trim())) {
                idClienteReal = c.getId(); // Obtiene el ID real del cliente
                break;
            }
        }
    }

    mascotas m = new mascotas();
    m.setNombre_mas(vista.txtNombreMa.getText().trim());
    m.setRaza_mas(vista.txtRazaMa.getText().trim());
    m.setFecha_nacimiento_mas(vista.txtNacimientoMa.getText().trim());
    m.setSexo_mas(vista.cbxSexoMa.getSelectedItem().toString());
    m.setId_especie(idEspecieReal);
    m.setId_cliente(idClienteReal);

    if (dao.insertarMascotas(m)) {
        JOptionPane.showMessageDialog(null, "Mascota agregada correctamente con ID Especie: " + idEspecieReal);
        ListarMascotas();
        LimpiarTextos();
    } else {
        JOptionPane.showMessageDialog(null, "Error al insertar mascota");
    }
}

    public void ListarMascotas() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tblMascotas.getModel();
        modelo.setRowCount(0);
        List<mascotas> lista = dao.ListarMascotas();
        if (lista != null) {
            for (mascotas m : lista) {
                Object[] fila = {
                    m.getId_mas(),
                    m.getNombre_mas(),
                    m.getRaza_mas(),
                    m.getFecha_nacimiento_mas(),
                    m.getSexo_mas(),
                    m.getId_especie(),
                    m.getId_cliente()
                };
                modelo.addRow(fila);
            }
        }
    }

    public void actualizarMascotas() {
        int fila = vista.tblMascotas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla para actualizar");
            return;
        }

        if (!validarCampos()) return;

        int idxEsp = vista.getCbxEspecie().getSelectedIndex();
        int idxCli = vista.getCbxCliente().getSelectedIndex();

        int idEspecieReal = listaEspecies.get(idxEsp).getIdEsp();
        int idClienteReal = listaClientes.get(idxCli).getId();

        mascotas m = new mascotas();
        m.setId_mas(Integer.parseInt(vista.tblMascotas.getValueAt(fila, 0).toString()));
        m.setNombre_mas(vista.txtNombreMa.getText().trim());
        m.setRaza_mas(vista.txtRazaMa.getText().trim());
        m.setFecha_nacimiento_mas(vista.txtNacimientoMa.getText().trim());
        m.setSexo_mas(vista.cbxSexoMa.getSelectedItem().toString());
        m.setId_especie(idEspecieReal);
        m.setId_cliente(idClienteReal);

        if (dao.actualizarMascotas(m)) {
            JOptionPane.showMessageDialog(null, "Mascota actualizada correctamente");
            ListarMascotas();
            LimpiarTextos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }

    public void eliminarMascotas() {
        int fila = vista.tblMascotas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else {
            int opc = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar esta mascota?", "Confirmar Acción", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.YES_OPTION) {
                int id_mas = Integer.parseInt(vista.tblMascotas.getValueAt(fila, 0).toString());
                if (dao.eliminarMascotas(id_mas)) {
                    JOptionPane.showMessageDialog(null, "Eliminado con éxito");
                    ListarMascotas();
                    LimpiarTextos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
    }

    private boolean validarCampos() {
        if (vista.txtNombreMa.getText().trim().isEmpty() ||
            vista.txtRazaMa.getText().trim().isEmpty() ||
            vista.txtNacimientoMa.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos (Nombre, Raza, Fecha de Nacimiento).");
            return false;
        }
        return true;
    }

    public void LimpiarTextos() {
        vista.txtNombreMa.setText("");
        vista.txtRazaMa.setText("");
        vista.txtNacimientoMa.setText("");
        vista.cbxSexoMa.setSelectedIndex(0);
        if (vista.getCbxEspecie().getItemCount() > 0) vista.getCbxEspecie().setSelectedIndex(0);
        if (vista.getCbxCliente().getItemCount() > 0) vista.getCbxCliente().setSelectedIndex(0);
        vista.tblMascotas.clearSelection();
    }
}
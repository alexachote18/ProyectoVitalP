/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.especiesDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.especies;
import mvcguifinal.menu_especies;
/**
 *
 * @author ASUS
 */
public class especiesController {
    private menu_especies vista;
    private especiesDAO dao;

    public especiesController(menu_especies vista) {
        this.vista = vista;
        dao = new especiesDAO();
}
    // Insertar Especie
    public void insertarEspecies() {
        especies e = new especies();
        e.setNombreEsp(vista.txtNombreEsp.getText());
        e.setDescripcionEsp(vista.txtDescripcionEsp.getText());

        if (dao.insertarEspecies(e)) { // Si retorna boolean en tu DAO
            JOptionPane.showMessageDialog(null, "Especie Agregada");
            ListarEspecies();
        } else {
            JOptionPane.showMessageDialog(null, "Error al insertar especie");
        }
    }

    // Listar Especies
    public void ListarEspecies() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tblEspecies.getModel();
        modelo.setRowCount(0);
        List<especies> lista = dao.ListarEspecies();
        for (especies e : lista) {
            Object[] fila = {
                e.getIdEsp(),
                e.getNombreEsp(),
                e.getDescripcionEsp()
            };
            modelo.addRow(fila);
        }
    }

    // Eliminar Especie
    public void eliminarEspecies() {
        int fila = vista.tblEspecies.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
        } else {
            int opc = JOptionPane.showConfirmDialog(null, "¿Deseas Eliminar este registro?", "Confirmar Accion", JOptionPane.YES_NO_OPTION);
            if (opc != JOptionPane.YES_OPTION) {
                return;
            } else {
                int id_especie = Integer.parseInt(vista.tblEspecies.getValueAt(fila, 0).toString());
                if (dao.eliminarEspecies(id_especie)) {
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    ListarEspecies();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
    }

    // Actualizar Especie
    public void actualizarEspecies() {
        int fila = vista.tblEspecies.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            return;
        }
        especies e = new especies();
        e.setIdEsp(Integer.parseInt(vista.tblEspecies.getValueAt(fila, 0).toString()));
        e.setNombreEsp(vista.txtNombreEsp.getText());
        e.setDescripcionEsp(vista.txtDescripcionEsp.getText());

        if (dao.actualizarEspecies(e)) {
            JOptionPane.showMessageDialog(null, "Especie Actualizada");
            ListarEspecies();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }
}

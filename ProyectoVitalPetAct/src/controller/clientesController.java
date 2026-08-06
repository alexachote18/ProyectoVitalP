/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.clientesDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.clientes;
import mvcguifinal.menu_clientes;

/**
 *
 * @author alexa
 */
public class clientesController {
    private menu_clientes vista ;
    private clientesDAO dao ;
    public  clientesController(menu_clientes vista){
        this.vista = vista ;
        dao = new clientesDAO();
    }
    
    public void insertarClientes(){
        clientes c =new clientes ();
        c.setCedula(vista.txtCedulaCli.getText());
        c.setNombre(vista.txtNombreCli.getText());
        c.setApellido(vista.txtApellidoCli.getText());
        c.setEmail(vista.txtEmailCli.getText());
        c.setGenero(vista.cbxGeneroCli.getSelectedItem().toString());
        c.setEstado(vista.cbxEstadoCli.getSelectedItem().toString());
        c.setDireccion(vista.txtADireccionCli.getText());
        
        if(dao.insertarClientes(c)!=null){
            JOptionPane.showMessageDialog(null,"Cliente Agregado");
            ListarClientes();
            
        }else{
            JOptionPane.showMessageDialog(null,"Error");
        }
        
       
    }
    public void ListarClientes(){
        DefaultTableModel modelo = (DefaultTableModel)vista.tblClientes.getModel();
        modelo.setRowCount(0);
        List<clientes> lista = dao.ListarClientes();
        for(clientes c :lista){
            Object [] fila = {
                c.getId(),
                c.getCedula(),
                c.getNombre(),
                c.getApellido(),
                c.getEmail(),
                c.getGenero(),
                c.getEstado(),
                c.getDireccion()};
            modelo.addRow(fila);
            
    }
    
    
    }
    public void eliminarClientes(){
        int fila = vista.tblClientes.getSelectedRow();
        if ( fila == -1){
            JOptionPane.showMessageDialog(null,"Debe seleccionar un registro ");
            
        }else{
            int opc = JOptionPane.showConfirmDialog(null,"¿Deseas Eliminar este registro?","Confirmar Accion",JOptionPane.YES_NO_OPTION);
            if(opc!=JOptionPane.YES_OPTION){
            return ;
        }else{
                int id_usu = Integer.parseInt(vista.tblClientes.getValueAt(fila,0).toString());
                if(dao.eliminarClientes(id_usu)){
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    ListarClientes();
                }
    }
}
}
    public void actualizarClientes(){
        int fila = vista.tblClientes.getSelectedRow();
        if ( fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            return ;
        }  
        clientes c = new clientes ();
        c.setId(Integer.parseInt(vista.tblClientes.getValueAt(fila, 0).toString()));
        c.setCedula(vista.txtCedulaCli.getText());
        c.setNombre(vista.txtNombreCli.getText());
        c.setApellido(vista.txtApellidoCli.getText());
        c.setEmail(vista.txtEmailCli.getText());
        c.setGenero(vista.cbxGeneroCli.getSelectedItem().toString());
        c.setEstado(vista.cbxEstadoCli.getSelectedItem().toString());
        c.setDireccion(vista.txtADireccionCli.getText());
        
        if(dao.actualizarClientes(c)){
            JOptionPane.showMessageDialog(null,"Cliente Actualizado ");
            ListarClientes();
        }else{
            JOptionPane.showMessageDialog(null,"Error al actualizar");
        }
        
  
        
        
            }
}

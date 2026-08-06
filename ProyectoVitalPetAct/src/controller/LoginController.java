/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.clientesDAO;
import javax.swing.JOptionPane;
import modelo.clientes;
import mvcguifinal.Login;
import mvcguifinal.Menu;


/**
 *
 * @author alexa
 */
public class LoginController {
    private Login mvcguifinal;
    private clientesDAO dao ;
    public LoginController(Login vista){
        this.mvcguifinal = vista ;
        dao = new clientesDAO() ; 
    }
    public void entrarSesion(){
        String clientes =mvcguifinal.txtClientes.getText();
        String password =mvcguifinal.txtPassword.getText();
        clientes c = dao.Login(clientes, password);
        
        if(c!=null){
            if (c.getRol().equalsIgnoreCase("Cliente")){
                JOptionPane.showMessageDialog(null,"Acceso denegado los clientes no pueden iniciar sesion");
                return ;
            }
            JOptionPane.showMessageDialog(null,"BIENVENIDO  " +c.getNombre());
            
            Menu m =new Menu();
            m.setVisible(true);
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Login incorrecto");
        }
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvcguifinal;
import java.sql.Connection;
import modelo.conexionBase;

/**
 *
 * @author alexa
 */
public class MVCGUIFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        conexionBase conn =new conexionBase ();
        Connection con = conn.getConnection();
        if(con!=null){
            Login login = new Login ();
            login.setVisible(true);
            System.out.println("Conexion exitosa");
        }else{
            System.out.println("Error de conexion");
        }
        
    }
    
}

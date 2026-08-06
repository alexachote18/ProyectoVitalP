
package modelo;
import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.SQLException ;

public class conexionBase {
    private static final String URL ="jdbc:mysql://192.168.0.10:3306/proyectofinal";
    private static final String USER = "admin";
    private static final String PASSWORD = "123";
    private Connection con ;
    
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conexion exitosa ");
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion"+e.getMessage());
        }
        return con ;
    }
    
    
}

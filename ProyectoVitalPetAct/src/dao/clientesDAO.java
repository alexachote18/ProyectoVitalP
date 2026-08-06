
package dao;
import java.util.List;
import java.sql.Connection ;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.clientes;
import modelo.conexionBase;


public class clientesDAO {
    conexionBase cn = new conexionBase ();
    Connection con ;
    PreparedStatement ps ;
    ResultSet rs ;
    
    public clientes Login (String clientes , String password ){
        clientes c = null;
        String sql ="SELECT * FROM clientes Where cedula_usu=? AND password_usu=? AND estado_usu='activo' ";
        try{
            con =cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,clientes);
            ps.setString(2, password);
            rs=ps.executeQuery();
            
            if(rs.next()){
                c= new clientes();
                c.setId(rs.getInt("id_usu"));
                c.setCedula(rs.getString("cedula_usu"));
                c.setNombre(rs.getString("nombre_usu"));
                c.setApellido(rs.getString("apellido_usu"));
                c.setEmail(rs.getString("email_usu"));
                c.setGenero(rs.getString("genero_usu"));
                c.setRol(rs.getString("rol_usu"));
            
            }
            
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return c ;
    }
    public Boolean insertarClientes (clientes c ){
        String sql="INSERT INTO clientes (cedula_usu,nombre_usu,apellido_usu , email_usu, genero_usu,estado_usu ,direccion_usu, password_usu,rol_usu) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try{
            con=cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCedula());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getGenero());
            ps.setString(6, c.getEstado());
            ps.setString(7, c.getDireccion());
            ps.setString(8, c.getCedula());
            ps.setString(9, "cliente"); 
            
            ps.executeUpdate();
            return true;
                    
                    
        }catch(Exception e){
            System.out.println("Error"+e.toString());
            return false;
        }  
    }
    public List<clientes> ListarClientes(){
        List<clientes> lista = new ArrayList<>();
        String sql ="SELECT * FROM clientes";
        try{
            con = cn.getConnection();
            ps =con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                clientes c = new clientes();
                c.setId(rs.getInt("id_usu"));
                c.setCedula(rs.getString("cedula_usu"));
                c.setNombre(rs.getString("nombre_usu"));
                c.setApellido(rs.getString("apellido_usu"));
                c.setEmail(rs.getString("email_usu"));
                c.setGenero(rs.getString("genero_usu"));
                c.setEstado(rs.getString("estado_usu"));
                c.setDireccion(rs.getString("direccion_usu"));
                
                lista.add (c);
                
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return lista ;
        
    }
    public boolean eliminarClientes(int id_usu){
        String  sql ="DELETE FROM clientes WHERE id_usu = ? ";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_usu);
            ps.executeUpdate();
            return true;
            
            
        }catch(Exception e ){
            System.out.println("Error"+e.toString());
            return false;
        }
    }
    public boolean actualizarClientes(clientes c){
        String sql ="UPDATE clientes SET cedula_usu=?,nombre_usu=?,apellido_usu=? , email_usu=?, genero_usu=?,estado_usu=? ,direccion_usu=? WHERE id_usu=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,c.getCedula());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4,c.getEmail());
            ps.setString(5, c.getGenero());
            ps.setString(6, c.getEstado());
            ps.setString(7, c.getDireccion());
            ps.setInt(8, c.getId());
            
            ps.executeUpdate();
            
            return true ;
            
        }catch(Exception e ){
            System.out.println("Error"+e.toString());
        }
        return false ;
    }
    
}

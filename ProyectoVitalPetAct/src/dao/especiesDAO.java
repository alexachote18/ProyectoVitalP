
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.conexionBase;
import modelo.especies;
/**
 *
 * @author ASUS
 */
public class especiesDAO {
    
    conexionBase cn = new conexionBase();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Insertar Especies
    public Boolean insertarEspecies(especies e) {
        String sql = "INSERT INTO especies (nombre_especie, descripcion_especie) VALUES(?,?)";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombreEsp());
            ps.setString(2, e.getDescripcionEsp());
            
            ps.executeUpdate();
            return true;
            
        }catch (Exception ex){
            System.out.println("Error" + ex.toString());
            return false;
        }  
    }

    // Listar Especies
    
    public List<especies> ListarEspecies() {
        List<especies> lista = new ArrayList<>();
        // Ajusta los nombres de columnas según tu DB en phpMyAdmin (ej: fk_id_especies o id_especies)
        String sql = "SELECT * FROM especies"; 
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
    especies e = new especies();
    e.setIdEsp(rs.getInt("id_especie")); // O rs.getInt("id_esp") o la columna 1: rs.getInt(1)
    e.setNombreEsp(rs.getString("nombre_especie"));
    lista.add(e);
}
        } catch (Exception ex) {
            System.out.println("Error al listar especies: " + ex.toString());
        }
        return lista;
    }
    // Eliminar Especies
    public boolean eliminarEspecies(int id_especie) {
        String sql = "DELETE FROM especies WHERE id_especie = ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_especie);
            ps.executeUpdate();
            return true;
            
        } catch(Exception ex) {
            System.out.println("Error" + ex.toString());
            return false;
        }
    }

    // Actualizar Especies
    public boolean actualizarEspecies(especies e) {
        String sql = "UPDATE especies SET nombre_especie=?, descripcion_especie=? WHERE id_especie=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombreEsp());
            ps.setString(2, e.getDescripcionEsp());
            ps.setInt(3, e.getIdEsp());
            
            ps.executeUpdate();
            return true;
            
        } catch(Exception ex) {
            System.out.println("Error" + ex.toString());
        }
        return false;
    }
}


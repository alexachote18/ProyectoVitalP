package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.conexionBase;
import modelo.producto;


public class productosDAO {
    conexionBase cn = new conexionBase();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Insertar Producto
    public Boolean insertarProductos(producto p) {
        String sql = "INSERT INTO productos (nombre_prod, categoria_prod, precio_prod, stock_prod, fechavence_prod) VALUES(?,?,?,?,?)";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombrePro());
            ps.setString(2, p.getCategoriaPro());
            ps.setDouble(3, p.getPrecioPro());
            ps.setInt(4, p.getStockPro());
            ps.setString(5, p.getFechaVencimientoPro());
            
            ps.executeUpdate();
            return true;
            
        } catch(Exception e) {
            System.out.println("Error" + e.toString());
            return false;
        }  
    }

    // Listar Productos
    public List<producto> ListarProductos() {
        List<producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                producto p = new producto();
                p.setIdPro(rs.getInt("id_prod"));
                p.setNombrePro(rs.getString("nombre_prod"));
                p.setCategoriaPro(rs.getString("categoria_prod"));
                p.setPrecioPro(rs.getDouble("precio_prod"));
                p.setStockPro(rs.getInt("stock_prod"));
                p.setFechaVencimientoPro(rs.getString("fechavence_prod"));
                
                lista.add(p);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    // Eliminar Producto
    public boolean eliminarProductos(int id_producto) {
        String sql = "DELETE FROM productos WHERE id_prod = ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_producto);
            ps.executeUpdate();
            return true;
            
        } catch(Exception e) {
            System.out.println("Error" + e.toString());
            return false;
        }
    }

    // Actualizar Producto
    public boolean actualizarProductos(producto p) {
        String sql = "UPDATE productos SET nombre_prod=?, categoria_prod=?, precio_prod=?, stock_prod=?, fechavence_prod=? WHERE id_prod=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombrePro());
            ps.setString(2, p.getCategoriaPro());
            ps.setDouble(3, p.getPrecioPro());
            ps.setInt(4, p.getStockPro());
            ps.setString(5, p.getFechaVencimientoPro());
            ps.setInt(6, p.getIdPro());
            
            ps.executeUpdate();
            return true;
            
        } catch(Exception e) {
            System.out.println("Error" + e.toString());
        }
        return false;
    }
}
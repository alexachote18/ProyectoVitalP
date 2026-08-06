
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.conexionBase;
import modelo.detalleventa;

public class detalleventaDAO {

    conexionBase cn = new conexionBase();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Insertar detalle en la tabla de la BD (detalleventas)
    public boolean insertarDetalle(detalleventa d) {
        String sql = "INSERT INTO detalleventas(cantadid_detalle, precio_detalle, subtotal_detalle, fk_id_venta, fk_id_producto) VALUES(?, ?, ?, ?, ?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, d.getCantidadDetalle());
            ps.setDouble(2, d.getPrecioDetalle());
            ps.setDouble(3, d.getSubtotalDetalle());
            ps.setInt(4, d.getFkIdVenta());
            ps.setInt(5, d.getFkIdProducto());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error al insertar detalle: " + e.toString());
            return false;
        }
    }

    // Listar todos los registros de la tabla detalleventas
    public List<detalleventa> ListarDetalles() {
        List<detalleventa> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalleventas";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                detalleventa d = new detalleventa();
                d.setIdDetalle(rs.getInt("id_detalle"));
                d.setCantidadDetalle(rs.getInt("cantadid_detalle"));
                d.setPrecioDetalle(rs.getDouble("precio_detalle"));
                d.setSubtotalDetalle(rs.getDouble("subtotal_detalle"));
                d.setFkIdVenta(rs.getInt("fk_id_venta"));
                d.setFkIdProducto(rs.getInt("fk_id_producto"));

                lista.add(d);
            }

        } catch (Exception e) {
            System.out.println("Error al listar detalles: " + e.toString());
        }

        return lista;
    }

    // Actualizar un registro existente
    public boolean actualizarDetalle(detalleventa d) {
        String sql = "UPDATE detalleventas SET cantadid_detalle = ?, precio_detalle = ?, subtotal_detalle = ?, fk_id_venta = ?, fk_id_producto = ? WHERE id_detalle = ?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, d.getCantidadDetalle());
            ps.setDouble(2, d.getPrecioDetalle());
            ps.setDouble(3, d.getSubtotalDetalle());
            ps.setInt(4, d.getFkIdVenta());
            ps.setInt(5, d.getFkIdProducto());
            ps.setInt(6, d.getIdDetalle()); // WHERE id_detalle = ?

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar detalle: " + e.toString());
            return false;
        }
    }

    // Eliminar un registro
    public boolean eliminarDetalle(int idDetalle) {
        String sql = "DELETE FROM detalleventas WHERE id_detalle = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDetalle);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar detalle: " + e.toString());
            return false;
        }
    }
}
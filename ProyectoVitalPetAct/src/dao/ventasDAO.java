
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import modelo.historialVenta;

import modelo.ventas;
import modelo.clientes;
import modelo.conexionBase;


public class ventasDAO {
    conexionBase cn = new conexionBase();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Método para insertar venta coincidiendo con la BD
    public Boolean insertarVenta(ventas v) {
        String sql = "INSERT INTO ventas (nombreCliente, total_venta, forma_pago, fk_id_usu) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getFechaVenta()); // Pasa el valor a nombreCliente / fecha
            ps.setDouble(2, v.getTotalVenta());
            ps.setString(3, v.getFormaPago());
            ps.setInt(4, v.getIdCliente()); // Clave foránea correcta
            
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al insertar venta: " + e.toString());
            return false;
        }
    }

    // Listar las ventas registradas
  public List<ventas> ListarVentas() {
    List<ventas> lista = new ArrayList<>();
    String sql = "SELECT * FROM ventas";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            ventas v = new ventas();
            v.setIdVenta(rs.getInt("id_venta"));
            v.setFechaVenta(rs.getString("nombreCliente")); // Lee la fecha/nombre
            v.setTotalVenta(rs.getDouble("total_venta"));
            v.setFormaPago(rs.getString("forma_pago"));
            v.setIdCliente(rs.getInt("fk_id_usu"));         // <-- DEBE LEER fk_id_usu
            
            lista.add(v);
        }
    } catch (Exception e) {
        System.out.println("Error al listar ventas: " + e.toString());
    }
    return lista;
}
    // Eliminar venta
    public boolean eliminarVentas(int id_venta) {
        String sql = "DELETE FROM ventas WHERE id_venta = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_venta);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar venta: " + e.toString());
            return false;
        }
    }

    // Actualizar venta
   public boolean actualizarVentas(ventas v) {
    // IMPORTANTE: nombreCliente recibe la fecha, fk_id_usu recibe el ID del cliente
    String sql = "UPDATE ventas SET nombreCliente = ?, total_venta = ?, forma_pago = ?, fk_id_usu = ? WHERE id_venta = ?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, v.getFechaVenta());  // 1: Fecha
        ps.setDouble(2, v.getTotalVenta()); // 2: Total
        ps.setString(3, v.getFormaPago());  // 3: Forma de pago
        ps.setInt(4, v.getIdCliente());     // 4: ID del cliente (fk_id_usu)
        ps.setInt(5, v.getIdVenta());       // 5: ID de la venta (WHERE)
        
        ps.executeUpdate();
        return true;
    } catch (Exception e) {
        System.out.println("Error al actualizar venta: " + e.toString());
        return false;
    }
}

    // Método para obtener la lista de clientes y cargarlos en el JComboBox
    public List<clientes> obtenerClientesCBX() {
        List<clientes> lista = new ArrayList<>();
        String sql = "SELECT id_usu, nombre_usu, apellido_usu, cedula_usu FROM clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clientes c = new clientes();
                c.setId(rs.getInt("id_usu"));
                c.setNombre(rs.getString("nombre_usu"));
                c.setApellido(rs.getString("apellido_usu"));
                c.setCedula(rs.getString("cedula_usu"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar clientes para CBX: " + e.toString());
        }
        return lista;
    }
   public List<historialVenta> listarHistorial() {
    List<historialVenta> lista = new ArrayList<>();
    String sql = "SELECT v.nombreCliente AS fecha, d.id_detalle, d.fk_id_venta, d.fk_id_producto, "
               + "d.cantadid_detalle, d.precio_detalle, d.subtotal_detalle "
               + "FROM detalleventas d "
               + "INNER JOIN ventas v ON d.fk_id_venta = v.id_venta";

    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            historialVenta hv = new historialVenta();
            hv.setFecha(rs.getString("fecha"));
            hv.setIdDetalle(rs.getInt("id_detalle"));
            hv.setIdVenta(rs.getInt("fk_id_venta"));
            hv.setIdProducto(rs.getInt("fk_id_producto"));
            hv.setCantidad(rs.getInt("cantadid_detalle"));
            hv.setPrecioUnitario(rs.getDouble("precio_detalle"));
            hv.setSubtotal(rs.getDouble("subtotal_detalle"));

            lista.add(hv);
        }

    } catch (Exception e) {
        System.out.println("Error al obtener historial: " + e.getMessage());
    }

    return lista;
}
}
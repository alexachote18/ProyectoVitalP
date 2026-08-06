package dao;

import modelo.conexionBase;
import modelo.mascotas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class mascotasDAO {

    conexionBase cn = new conexionBase();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertarMascotas(mascotas m) {
        String sql = "INSERT INTO mascotas (nombre_mas, raza_mas, nacimiento_mas, sexo_mas, fk_id_especies, fk_id_usu) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, m.getNombre_mas());
            ps.setString(2, m.getRaza_mas());
            ps.setString(3, m.getFecha_nacimiento_mas());
            ps.setString(4, m.getSexo_mas());
            ps.setInt(5, m.getId_especie()); // Pasa el ID real seleccionado
            ps.setInt(6, m.getId_cliente()); // Pasa el ID real seleccionado

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al insertar mascota: " + e.toString());
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.toString());
            }
        }
    }

    public List<mascotas> ListarMascotas() {
        List<mascotas> lista = new ArrayList<>();
        String sql = "SELECT * FROM mascotas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                mascotas m = new mascotas();
                m.setId_mas(rs.getInt("id_mas"));
                m.setNombre_mas(rs.getString("nombre_mas"));
                m.setRaza_mas(rs.getString("raza_mas"));
                m.setFecha_nacimiento_mas(rs.getString("nacimiento_mas"));
                m.setSexo_mas(rs.getString("sexo_mas"));
                m.setId_especie(rs.getInt("fk_id_especies"));
                m.setId_cliente(rs.getInt("fk_id_usu"));

                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error al listar mascotas: " + e.toString());
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.toString());
            }
        }
        return lista;
    }

    public boolean actualizarMascotas(mascotas m) {
        String sql = "UPDATE mascotas SET nombre_mas=?, raza_mas=?, nacimiento_mas=?, sexo_mas=?, fk_id_especies=?, fk_id_usu=? WHERE id_mas=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, m.getNombre_mas());
            ps.setString(2, m.getRaza_mas());
            ps.setString(3, m.getFecha_nacimiento_mas());
            ps.setString(4, m.getSexo_mas());
            ps.setInt(5, m.getId_especie());
            ps.setInt(6, m.getId_cliente());
            ps.setInt(7, m.getId_mas());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar mascota: " + e.toString());
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.toString());
            }
        }
    }

    public boolean eliminarMascotas(int id) {
        String sql = "DELETE FROM mascotas WHERE id_mas=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar mascota: " + e.toString());
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.toString());
            }
        }
    }
}
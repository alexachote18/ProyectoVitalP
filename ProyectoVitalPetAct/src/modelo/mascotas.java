
package modelo;

/**
 *
 * @author DELL
 */
public class mascotas {
    private int id_mas;
    private String nombre_mas;
    private String raza_mas;
    private String fecha_nacimiento_mas;
    private String sexo_mas;
    private int id_especie;
    private int id_cliente;

    public int getId_mas() {
        return id_mas;
    }

    public String getNombre_mas() {
        return nombre_mas;
    }

    public String getRaza_mas() {
        return raza_mas;
    }

    public String getFecha_nacimiento_mas() {
        return fecha_nacimiento_mas;
    }

    public String getSexo_mas() {
        return sexo_mas;
    }

    public int getId_especie() {
        return id_especie;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_mas(int id_mas) {
        this.id_mas = id_mas;
    }

    public void setNombre_mas(String nombre_mas) {
        this.nombre_mas = nombre_mas;
    }

    public void setRaza_mas(String raza_mas) {
        this.raza_mas = raza_mas;
    }

    public void setFecha_nacimiento_mas(String fecha_nacimiento_mas) {
        this.fecha_nacimiento_mas = fecha_nacimiento_mas;
    }

    public void setSexo_mas(String sexo_mas) {
        this.sexo_mas = sexo_mas;
    }

    public void setId_especie(int id_especie) {
        this.id_especie = id_especie;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
}

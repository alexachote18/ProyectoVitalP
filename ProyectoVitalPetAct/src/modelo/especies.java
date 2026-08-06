
package modelo;

public class especies {
    
    private int idEsp;
    private String nombreEsp;
    private String descripcionEsp;

    public especies() {
    }

    public int getIdEsp() {
        return idEsp;
    }

    public String getNombreEsp() {
        return nombreEsp;
    }

    public String getDescripcionEsp() {
        return descripcionEsp;
    }

    public void setIdEsp(int idEsp) {
        this.idEsp = idEsp;
    }

    public void setNombreEsp(String nombreEsp) {
        this.nombreEsp = nombreEsp;
    }

    public void setDescripcionEsp(String descripcionEsp) {
        this.descripcionEsp = descripcionEsp;
    }
@Override
public String toString() {
    return this.nombreEsp; // O el nombre del atributo donde guardas el nombre de la especie
}
    
}

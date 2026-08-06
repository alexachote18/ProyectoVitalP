
package modelo;

public class clientes {
    private int id ;
    private String cedula ;
    private String nombre ;
    private String apellido ;
    private String email ;
    private String rol ;
    private String direccion ;
    private String genero ;
    private String estado;

    public void setId(int id) {
        this.id = id;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getGenero() {
        return genero;
    }

    public String getEstado() {
        return estado;
    }
@Override
public String toString() {
        // Muestra Nombre y Apellido en el ComboBox mientras conserva el ID real internamente
        return (this.nombre != null ? this.nombre : "") + " " + (this.apellido != null ? this.apellido : "");
    }
    
}

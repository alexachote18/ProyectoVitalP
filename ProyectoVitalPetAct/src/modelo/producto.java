
package modelo;

/**
 *
 * @author HP
 */
public class producto {
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    private String fechaVencimiento;

    public producto() {
    }

    public void setIdPro(int id) {
        this.id = id;
    }

    public void setNombrePro(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoriaPro(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecioPro(double precio) {
        this.precio = precio;
    }

    public void setStockPro(int stock) {
        this.stock = stock;
    }

    public void setFechaVencimientoPro(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdPro() {
        return id;
    }

    public String getNombrePro() {
        return nombre;
    }

    public String getCategoriaPro() {
        return categoria;
    }

    public double getPrecioPro() {
        return precio;
    }

    public int getStockPro() {
        return stock;
    }

    public String getFechaVencimientoPro() {
        return fechaVencimiento;
    }
    
    
}

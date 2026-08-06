package modelo;

/**
 *
 * @author alexa
 */
public class ventas {
    private int idVenta;
    private String fechaVenta;
    private Double totalVenta;
    private String formaPago;
    private int idCliente; // Agregado

    public ventas() {}

    public ventas(int idVenta, String fechaVenta, Double totalVenta, String formaPago, int idCliente) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.formaPago = formaPago;
        this.idCliente = idCliente; // Agregado
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public void setIdCliente(int idCliente) { // Agregado
        this.idCliente = idCliente;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public int getIdCliente() { // Agregado
        return idCliente;
    }
}
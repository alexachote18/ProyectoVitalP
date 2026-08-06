package modelo;

public class detalleventa{
    private int idDetalle;
    private int cantidadDetalle;
    private double precioDetalle;
    private double subtotalDetalle;
    private int fkIdVenta;
    private int fkIdProducto;

    public detalleventa() {
    }

    public detalleventa(int idDetalle, int cantidadDetalle, double precioDetalle, double subtotalDetalle, int fkIdVenta, int fkIdProducto) {
        this.idDetalle = idDetalle;
        this.cantidadDetalle = cantidadDetalle;
        this.precioDetalle = precioDetalle;
        this.subtotalDetalle = subtotalDetalle;
        this.fkIdVenta = fkIdVenta;
        this.fkIdProducto = fkIdProducto;
    }

    public int getIdDetalle() { return idDetalle; }
    public void setIdDetalle(int idDetalle) { this.idDetalle = idDetalle; }

    public int getCantidadDetalle() { return cantidadDetalle; }
    public void setCantidadDetalle(int cantidadDetalle) { this.cantidadDetalle = cantidadDetalle; }

    public double getPrecioDetalle() { return precioDetalle; }
    public void setPrecioDetalle(double precioDetalle) { this.precioDetalle = precioDetalle; }

    public double getSubtotalDetalle() { return subtotalDetalle; }
    public void setSubtotalDetalle(double subtotalDetalle) { this.subtotalDetalle = subtotalDetalle; }

    public int getFkIdVenta() { return fkIdVenta; }
    public void setFkIdVenta(int fkIdVenta) { this.fkIdVenta = fkIdVenta; }

    public int getFkIdProducto() { return fkIdProducto; }
    public void setFkIdProducto(int fkIdProducto) { this.fkIdProducto = fkIdProducto; }
}
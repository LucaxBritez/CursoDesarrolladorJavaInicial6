public class ItemCarrito {

    private int cantidad;
    private Producto producto;

    public ItemCarrito(int cantidad, Producto producto){
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Double subtotal(){
        return this.producto.getPrecio() * this.cantidad;
    }

}

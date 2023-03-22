import java.time.LocalDateTime;

public class Producto {

    private String nombre;
    private double precio;
    private LocalDateTime fecha;
    private static final double minPrecio = 0.1;

    public Producto(String nombre1){
        this.nombre = nombre1;
        this.fecha = LocalDateTime.now();
        this.precio = minPrecio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString(){
        return "Producto: " + this.nombre;
    }
}

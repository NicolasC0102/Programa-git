package clases;

public class Sabores {

    private String nombre = "";
    private int cantidad = 0;
    private double precio = 0;
    // crear CONTRUCTOR

    public Sabores(String nombre, int cantidad, double precio) {

        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean vendido(int numero) {

        if (numero <= cantidad) {

            numero -= cantidad;
        } else {
            System.out.println("- No hay suficientes unidades -");

            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sabores{" + "NOMBRE:" + nombre + ", CANTIDAD:" + cantidad + ", PRECIO:" + precio + '$';
    }

}

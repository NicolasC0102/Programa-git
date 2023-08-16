
package clases;


public class Adicionales {
    
    private String nombre="";
    private double precio=0;
    private double cantidad=0;

    public Adicionales(String nombre, double precio , double cantidad) {
        
        this.nombre=nombre;
        this.precio=precio;
        this.cantidad=cantidad;  
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    } 
    
    
}

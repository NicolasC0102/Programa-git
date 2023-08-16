package clases;

import java.util.Enumeration;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Hashtable;

public class Principal {

    String Productonombre;

    static Hashtable<String, Sabores> lista = new Hashtable<>();

    public Principal(String nombre) {
        this.Productonombre = nombre;
    }
//Ingresar articulo

    public void inserta(Sabores a) {

        String clave = a.getNombre();

        if (!lista.containsKey(clave)) {
            lista.put(clave, a);
            System.out.println("\n Se ha Añadido correctamente");
        } else {
            System.out.println("\n Error,El Producto ya existe");

        }

    }
// buscar producto 

    public Sabores busca(String nombre) {

        Sabores a;

        if (lista.containsKey(nombre)) {
            a =  lista.get(nombre);

            System.out.println("Producto encontrado");

            return a;
        } else {
            System.out.println("Producto no encontrado");
        }
        return null;
    }

    public double vende(String nombre, int numero) {
        Sabores a = busca(nombre);
        double vendido = 0;

        if (a == null) {
            System.out.println("Producto no encontrado");
            vendido = -1;
        } else if (a.vendido(numero)) {
            vendido = numero * a.getPrecio();

            if (a.getCantidad() == 0) {
                lista.remove(nombre);

            }
        }
        return vendido;
    }

    public static void menu() {
        System.out.println("1. Añadir Producto.");
        System.out.println("2. Mostrar los articulos.");
        System.out.println("3. Buscar producto.");
        System.out.println("4. Ventas");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opción.");
    }

    public static void salir() {
        System.out.println("Saliendo del sistema...");
    }

    public static void main(String[] args) {

        System.out.println("- - - SISTEMA DE GESTIÓN - - -");
        System.out.println("- - - - - - - - - - - - - - - ");
        Scanner entrada = new Scanner(System.in);
        Principal Deja_Vu = new Principal("Deja Vu \n ice cocktails");
        int opcion = 0;

        do {
            try {
                menu();
                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1: {
                        String cad;
                        entrada.nextLine();
                        System.out.println("Nombre del producto.");
                        String nombre = entrada.nextLine();

                        System.out.println("Cantidad");
                        cad = entrada.nextLine();
                        int cantidad = Integer.parseInt(cad);

                        System.out.println("- Precio -");
                        cad = entrada.nextLine();
                        double precio = Double.parseDouble(cad);

                        Sabores aux = new Sabores(nombre, cantidad, precio);
                        Deja_Vu.inserta(aux);

                        break;

                    }
                    case 2: {
                        Object clave;
                        Sabores sabores;
                        Enumeration e = lista.keys();

                        System.out.println("\nArticulos ");

                        while (e.hasMoreElements()) {
                            clave = e.nextElement();
                            sabores = lista.get(clave);
                            System.out.println(sabores.getSabores());
                        }
                        break;
                    }
                    case 3: {
                        String cad;
                        entrada.nextLine();
                        System.out.println("Nombre:");
                        cad = entrada.nextLine();

                        Sabores producto = Deja_Vu.busca(cad);
                        if (producto != null) {
                            System.out.println("Nombre: " + producto.getNombre() + ", Cantidad: " + producto.getCantidad() + ", Precio:" + producto.getPrecio() + " $. ");
                            System.out.println("");
                        }
                        break;
                    }
                    case 4: {
                        String cad;
                        entrada.nextLine();
                        System.out.println("Nombre:");
                        cad = entrada.nextLine();

                        System.out.println("Cantidad: ");
                        int cantidad = entrada.nextInt();

                        double venta = Deja_Vu.vende(cad, cantidad);

                        if (venta != 0 && venta != 1) {
                            System.out.println("Total venta:" + venta + " $. ");
                        }
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                entrada.nextLine();
                System.err.println("Error de entrada \n teclear una opción correcta.");
            }

        } while (opcion != 5);
        salir();
    }

}

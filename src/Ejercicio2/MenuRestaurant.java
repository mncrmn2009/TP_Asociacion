package Ejercicio2;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuRestaurant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Plato> platomenu = new ArrayList<>();

        System.out.println("Ingrese la cantidad de platos a cargar: ");
        int cantidadPlatos = sc.nextInt();

        for (int i = 0; i < cantidadPlatos; i++) {
            System.out.println("\nCargando plato #" + (i + 1));

            // Datos del plato
            System.out.print("Nombre del plato: ");
            String nombrePlato = sc.nextLine();
            System.out.print("Precio: ");
            double precio = sc.nextDouble();
            System.out.print("¿Es bebida? (true/false): ");
            boolean esBebida = sc.nextBoolean();


            // Crear el plato
            Plato plato = new Plato(nombrePlato, precio, esBebida);

            // Si no es bebida, se solicitan ingredientes
            if (!esBebida) {
                System.out.print("¿Cuántos ingredientes tiene el plato? ");
                int cantidadIngredientes = sc.nextInt();


                for (int j = 0; j < cantidadIngredientes; j++) {
                    System.out.println("Cargando ingrediente #" + (j + 1));
                    System.out.print("Nombre del ingrediente: ");
                    String nombreIngrediente = sc.nextLine();
                    System.out.print("Cantidad: ");
                    double cantidadIngrediente = sc.nextDouble();

                    System.out.print("Unidad de medida: ");
                    String unidadDeMedida = sc.nextLine();

                    // Crear el ingrediente y agregarlo al plato
                    Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidadIngrediente, unidadDeMedida);
                    plato.agregarIngredientes(ingrediente);
                }
            }

            // Agregar el plato al menú
            platomenu.add(plato);
        }

        // Mostrar el menú del restaurant
        System.out.println("\nMENÚ DEL RESTAURANT:");
        for (Plato plato : platomenu) {
            System.out.println("\n" + plato.getNombreCompleto());
            System.out.println("Precio: $ " + plato.getPrecio());

            if (!plato.isEsBebida()) {
                System.out.println("Ingredientes:");
                System.out.println("Nombre\t\tCantidad\tUnidad de Medida");
                for (Ingrediente ingrediente : plato.getIngredientes()) {
                    System.out.println(ingrediente.getNombre() + "\t" + ingrediente.getCantidad() + "\t" + ingrediente.getUnidadDeMedida());
                }
            }
        }

        sc.close();
    }
}
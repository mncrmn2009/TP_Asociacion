package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class CargaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        // Cargar alumnos
        System.out.print("Ingrese la cantidad de alumnos a cargar: ");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("\nCargando alumno #" + (i + 1));

            // Datos del alumno
            System.out.print("Nombre completo: ");
            String nombreCompleto = scanner.nextLine();
            System.out.print("Legajo: ");
            long legajo = scanner.nextLong();
            scanner.nextLine();  // Limpiar buffer

            Alumno alumno = new Alumno(nombreCompleto, legajo);

            // Cargar notas del alumno
            System.out.print("¿Cuántas notas desea ingresar para este alumno? ");
            int cantidadNotas = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.println("Cargando nota #" + (j + 1));
                System.out.print("Cátedra: ");
                String catedra = scanner.nextLine();
                System.out.print("Nota del examen: ");
                double notaExamen = scanner.nextDouble();
                scanner.nextLine();  // Limpiar buffer

                // Crear una nueva nota y agregarla al alumno
                Nota nota = new Nota(catedra, notaExamen);
                alumno.agregarNota(nota);
            }

            // Agregar el alumno a la lista de alumnos
            alumnos.add(alumno);
        }

        // Mostrar los resultados
        System.out.println("\nInformación de los alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println("\nAlumno: " + alumno.getNombreCompleto());
            System.out.println("Legajo: " + alumno.getLegajo());
            System.out.println("Notas:");
            for (Nota nota : alumno.getNotas()) {
                System.out.println("- " + nota.getCatedra() + ": " + nota.getNotaExamen());
            }
            System.out.println("Promedio de notas: " + alumno.calcularPromedio());
        }

        scanner.close();
    }
}

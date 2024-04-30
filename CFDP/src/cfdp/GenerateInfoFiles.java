package cfdp;

import cfdp.clases.Producto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import cfdp.clases.Vendedor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GenerateInfoFiles {
    
    private static final String rutaDatos = "src/cfdp/datos"; //Ruta a los datos
    private static final String archivoVendedores = "vendedores.csv"; //Nombre del archivo de datos de los vendedores
    private static final String archivoProductos = "productos.csv"; //Nombre del archivo de datos de los productos

    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        boolean estado = true; // Variable booleana para determinar si el programa debe seguir en ejecución
        
        while(estado == true){ // Bucle para repetir la ejecución del programa
            System.out.println("Que desea hacer?");
            System.out.println("1. Crear productos");
            System.out.println("2. Crear vendedores");
            System.out.println("3. Generar registros aleatorios");
            System.out.println("4. Salir");
            System.out.println("");

            int opcion = scanner.nextInt(); // Variable para almacenar la opción que seguirá el programa

            switch (opcion) { // Swicth que permitirá ir a la función predeterminada de cada opción
                case 1 -> {
                    scanner.nextLine();
                    crearProducto(scanner);
                }
                case 2 -> {
                    scanner.nextLine();
                    crearVendedor(scanner);
                }
                case 3 -> {
                    scanner.nextLine();
                    generar();

                }
                case 4 -> {
                    estado = false;
                }
                default -> System.out.println("Opción no válida.");
            }
            
        }
    }
    /**
    * Metodo que pregunta y crea el registro en el archivo CSV de productos
    */
    private static void crearProducto(Scanner scanner) throws IOException {
        System.out.println("Ingrese el ID del producto:");
        int idProducto = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el precio del producto:");
        double precioUnidad = scanner.nextDouble();
        scanner.nextLine();
        
        Producto producto = new Producto(idProducto, nombre, precioUnidad);
        
        File archivo = new File(rutaDatos, archivoProductos); // Se escriben los datos recibidos en el archivo
        try (FileWriter escritor = new FileWriter(archivo, true)) {
            escritor.append(String.valueOf(producto.getIdProducto()) + ";");
            escritor.append(producto.getNombre() + ";");
            escritor.append(String.valueOf(producto.getPrecioUnidad()) + "\n");
        }
        System.out.println("\n\n");
        System.out.println("Producto creado!");
        System.out.println("\n\n");
    }   
    /**
    * Metodo que pregunta y crea el registro en el archivo CSV de vendedores
    */
    private static void crearVendedor(Scanner scanner) throws IOException {
        System.out.println("Ingrese el tipo de documento (CC, CE, P):");
        String tipoDocumento = scanner.nextLine();

        System.out.println("Ingrese el número de documento:");
        int numeroDocumento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese los nombres:");
        
        String nombresVendedor = scanner.nextLine();

        System.out.println("Ingrese los apellidos:");
        
        String apellidosVendedor = scanner.nextLine();

        Vendedor vendedor = new Vendedor(tipoDocumento, numeroDocumento, nombresVendedor, apellidosVendedor);
        
        File archivo = new File(rutaDatos, archivoVendedores);
        
        try (FileWriter escritor = new FileWriter(archivo, true)) {// Se escriben los datos recibidos en el archivo
            escritor.append(vendedor.getTipoDocumento() + ";");
            escritor.append(vendedor.getNumeroDocumento() + ";");
            escritor.append(vendedor.getNombres() + ";");
            escritor.append(vendedor.getApellidos() + "\n");
        }
        System.out.println("\n\n");
        System.out.println("Vendedor creado!");
        System.out.println("\n\n");
    }
    /**
    * Metodo que genera al azar las ventas por cada vendedor registrado
    */
    private static void generar() throws FileNotFoundException, IOException{
        BufferedReader vendedores = new BufferedReader(new FileReader(rutaDatos+"/"+archivoVendedores));
        String lineaVendedores;
        while ((lineaVendedores = vendedores.readLine()) != null) {
            
            String[] columnasVendedores = lineaVendedores.split(";");
            File archivo = new File(rutaDatos+"/info", columnasVendedores[1]+".csv");
            
//            Comprobar si el archivo existe
            if(archivo.exists()){
                archivo.delete();
                archivo.createNewFile();
            }else{
                archivo.createNewFile();
            }
            try (FileWriter escritor = new FileWriter(archivo, true)) {
                escritor.append(columnasVendedores[0] + ";");
                escritor.append(columnasVendedores[1] + "\n");
            }
            BufferedReader productos = new BufferedReader(new FileReader(rutaDatos+"/"+archivoProductos));
            String lineaProductos;
            while ((lineaProductos = productos.readLine()) != null) {
                String[] columnasProductos = lineaProductos.split(";");
                double numeroAleatorio = Math.random();
                int cantidad = (int) (numeroAleatorio * 100);
                try (FileWriter escritor = new FileWriter(archivo, true)) {
                        escritor.append(columnasProductos[0] + ";");
                        escritor.append(cantidad + "\n");
                }
            }
        }
        System.out.println("\n\n");
        System.out.println("Archivos generados!");
        System.out.println("\n\n");
    }     
}
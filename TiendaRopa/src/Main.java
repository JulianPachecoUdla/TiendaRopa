import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        boolean salir = false;

        System.out.println("Bienvenido a 'Prendas para el Corazón'.");

        while (!salir) {
            System.out.println("\nMenu de opciones:");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Registrar una venta");
            System.out.println("3. Registrar una donacion");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    inventario.mostrarInventario();
                    break;

                case 2:
                    realizarVenta(sc, inventario);
                    break;

                case 3:
                    registrarDonacion(sc, inventario);
                    break;

                case 4:
                    salir = true;
                    System.out.println("Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }

    private static void realizarVenta(Scanner sc, Inventario inventario) {
        System.out.println("\nIngrese los datos del cliente para la venta:");
        sc.nextLine(); // Limpiar buffer
        System.out.print("Cédula: ");
        String cedula = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        Cliente cliente = new Cliente(cedula, nombre, telefono, correo);

        Venta venta = new Venta(cliente);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione una prenda para vender:");
            System.out.println("1. Pantalones\n2. Camisetas\n3. Chompas\n4. Zapatos");
            System.out.print("Opción: ");
            int opcionPrenda = sc.nextInt();

            String prenda = switch (opcionPrenda) {
                case 1 -> "pantalones";
                case 2 -> "camisetas";
                case 3 -> "chompas";
                case 4 -> "zapatos";
                default -> null;
            };

            if (prenda == null) {
                System.out.println("Opción no válida.");
                continue;
            }

            System.out.print("Ingrese la cantidad: ");
            int cantidad = sc.nextInt();

            System.out.println("Seleccione el estado de la prenda:");
            System.out.println("1. Nuevo ($" + Venta.obtenerPrecios(prenda, true) + ")");
            System.out.println("2. Usado ($" + Venta.obtenerPrecios(prenda, false) + ")");
            System.out.print("Opción: ");
            int estadoPrenda = sc.nextInt();

            boolean esNuevo = (estadoPrenda == 1);

            if (inventario.venderPrenda(prenda, cantidad)) {
                venta.agregarArticulo(prenda, cantidad, esNuevo);
                System.out.println("Venta registrada.");
            } else {
                System.out.println("No hay suficiente stock de " + prenda + ".");
            }

            System.out.println("¿Desea continuar con otra prenda?");
            System.out.println("1. Sí\n2. No");
            System.out.print("Opción: ");
            int continuarOpcion = sc.nextInt();
            continuar = (continuarOpcion == 1);
        }

        System.out.println("\nDetalle de la venta:");
        venta.mostrarDetalle();
    }


    private static void registrarDonacion(Scanner sc, Inventario inventario) {
        System.out.println("\nIngrese los datos del cliente para la donacion:");
        sc.nextLine();
        System.out.print("Cedula: ");
        String cedula = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Telefono: ");
        String telefono = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        Cliente cliente = new Cliente(cedula, nombre, telefono, correo);

        Donacion donacion = new Donacion(cliente);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione una prenda para donar:");
            System.out.println("1. Pantalones\n2. Camisetas\n3. Chompas\n4. Zapatos");
            System.out.print("Opcion: ");
            int opcionPrenda = sc.nextInt();

            String prenda = switch (opcionPrenda) {
                case 1 -> "pantalones";
                case 2 -> "camisetas";
                case 3 -> "chompas";
                case 4 -> "zapatos";
                default -> null;
            };

            if (prenda == null) {
                System.out.println("Opcion no válida.");
                continue;
            }

            System.out.print("Ingrese la cantidad: ");
            int cantidad = sc.nextInt();

            inventario.actualizarCantidad(prenda, cantidad);
            donacion.agregarDonacion(prenda, cantidad);

            System.out.println("Donacion registrada.");
            System.out.println("¿Desea continuar con otra prenda?");
            System.out.println("1. Si\n2. No");
            System.out.print("Opcion: ");
            int continuarOpcion = sc.nextInt();
            continuar = (continuarOpcion == 1);
        }

        System.out.println("\nDetalle de la donación:");
        donacion.mostrarDetalle();
    }
}


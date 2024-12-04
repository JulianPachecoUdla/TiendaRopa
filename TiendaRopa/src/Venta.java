import java.util.ArrayList;

public class Venta {
    private Cliente cliente;
    private ArrayList<String> prendasVendidas;
    private ArrayList<Integer> cantidadesVendidas;
    private ArrayList<Double> preciosVendidos;

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.prendasVendidas = new ArrayList<>();
        this.cantidadesVendidas = new ArrayList<>();
        this.preciosVendidos = new ArrayList<>();
    }

    public void agregarArticulo(String prenda, int cantidad, boolean esNuevo) {
        double precio = obtenerPrecios(prenda, esNuevo);
        prendasVendidas.add(prenda);
        cantidadesVendidas.add(cantidad);
        preciosVendidos.add(precio * cantidad);
    }

    public void mostrarDetalle() {
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Detalle de la venta:");
        for (int i = 0; i < prendasVendidas.size(); i++) {
            System.out.println("- " + cantidadesVendidas.get(i) + " " + prendasVendidas.get(i) + " (Precio total: $" + preciosVendidos.get(i) + ")");
        }
    }

    public static double obtenerPrecios(String prenda, boolean esNuevo) {
        if (esNuevo) {
            return switch (prenda) {
                case "pantalones" -> 35.0;
                case "camisetas" -> 15.0;
                case "chompas" -> 25.0;
                case "zapatos" -> 40.0;
                default -> 0.0;
            };
        } else {
            return switch (prenda) {
                case "pantalones" -> 20.0;
                case "camisetas" -> 7.0;
                case "chompas" -> 12.0;
                case "zapatos" -> 23.0;
                default -> 0.0;
            };
        }
    }
}

public class Inventario {
    private String[] prendas = {"pantalones", "camisetas", "chompas", "zapatos"};
    private int[] cantidades = {20, 60, 54, 14};

    public int getCantidad(String prenda) {
        for (int i = 0; i < prendas.length; i++) {
            if (prendas[i].equalsIgnoreCase(prenda)) {
                return cantidades[i];
            }
        }
        return 0;
    }

    public void actualizarCantidad(String prenda, int cantidad) {
        for (int i = 0; i < prendas.length; i++) {
            if (prendas[i].equalsIgnoreCase(prenda)) {
                cantidades[i] += cantidad;
                return;
            }
        }
    }

    public boolean venderPrenda(String prenda, int cantidad) {
        for (int i = 0; i < prendas.length; i++) {
            if (prendas[i].equalsIgnoreCase(prenda)) {
                if (cantidad <= cantidades[i]) {
                    cantidades[i] -= cantidad;
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrarInventario() {
        System.out.println("Inventario actual:");
        for (int i = 0; i < prendas.length; i++) {
            System.out.println(prendas[i] + ": " + cantidades[i]);
        }
    }
}

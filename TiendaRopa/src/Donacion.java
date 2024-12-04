public class Donacion {
    private Cliente cliente;
    private String[] prendasDonadas = new String[10];
    private int[] cantidadesDonadas = new int[10];
    private int contador = 0;

    public Donacion(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarDonacion(String prenda, int cantidad) {
        prendasDonadas[contador] = prenda;
        cantidadesDonadas[contador] = cantidad;
        contador++;
    }

    public void mostrarDetalle() {
        System.out.println("Donación realizada por: " + cliente.getNombre());
        for (int i = 0; i < contador; i++) {
            System.out.println(prendasDonadas[i] + " x" + cantidadesDonadas[i]);
        }
    }
}

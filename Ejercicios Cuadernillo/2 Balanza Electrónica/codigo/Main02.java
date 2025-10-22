package ejercicio2;

public class Main02 {
    public static void main(String[] args) {

        Balanza b = new Balanza();
        b.ponerEnCero();

        Producto p1 = new Producto();
        p1.setDescripcion("Banana");
        p1.setPrecioPorKilo(20);
        p1.setPeso(1.500);

        b.agregarProducto(p1);

        Producto p2 = new Producto();
        p2.setDescripcion("Frutillas");
        p2.setPrecioPorKilo(30);
        p2.setPeso(2.000);

        b.agregarProducto(p2);

        Ticket t1 = b.emitirTicket();
        System.out.println(t1.toString());
    }
}

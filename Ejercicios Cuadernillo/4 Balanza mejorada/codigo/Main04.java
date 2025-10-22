package ejercicio4;

import ejercicio2.Producto;
import ejercicio2.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Main04 {
    public static void main(String[] args) {

        BalanzaMejorada bm = new BalanzaMejorada();

        Producto p1 =new Producto();
        p1.setDescripcion("Banana");
        p1.setPrecioPorKilo(20);
        p1.setPeso(1.500);

        bm.agregarProducto(p1);

        Producto p2 =new Producto();
        p2.setDescripcion("Frutillas");
        p2.setPrecioPorKilo(30);
        p2.setPeso(2.000);

        bm.agregarProducto(p2);

        System.out.println();

        Ticket ticket = bm.emitirTicket();
        System.out.println(ticket);

        //cual es la mejor forma de hacerlo ?
        //List<Producto> copiadeproductos= new ArrayList<Producto>(bm.getProductos());

        System.out.println("LISTA DE PRODUCTOS:");
//        for(Producto p : copiadeproductos){
//            System.out.println();
//            System.out.println(p);
//        }

        for(Producto p : bm.getProductos()){
            System.out.println();
            System.out.println(p);
        }

        bm.ponerEnCero();

    }
}

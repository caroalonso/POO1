package ejercicio3;


public class Main03 {
    public static void main(String[] args) {

        Presupuesto p = new Presupuesto("Juan Perez");

        Item it1 = new Item();
        it1.setCantidad(2);
        it1.setCostoUnitario(50);
        it1.setDetalle(" ");

        p.agregarItem(it1);

        Item it2 =new Item();
        it2.setCantidad(3);
        it2.setCostoUnitario(30);
        it2.setDetalle(" ");

        p.agregarItem(it2);

        System.out.println("El costo de todos los items es: $ " + p.calcularTotal());


    }
}

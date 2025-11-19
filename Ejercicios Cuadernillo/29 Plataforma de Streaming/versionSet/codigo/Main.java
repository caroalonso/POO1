package ejercicio29Set;

public class Main {
    public static void main(String[] args) {

        Grupal grupal= new Grupal(6);
        Individual individual= new Individual(40);
        ReproduccionVideos reproduccionVideos= new ReproduccionVideos("1",60,10);
        SesionJuegos seccionJuegos= new SesionJuegos("2",60);
        Item item= new Item("daño aumentado",2,1000);
        seccionJuegos.agregarItem(item);

        Cliente cliente= new Cliente("Caro",grupal);
        cliente.agregarActividad(reproduccionVideos);
        cliente.agregarActividad(seccionJuegos);

        cliente.cambioDePlan(individual);

    }
}

package ejercicio26;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {

    private String nombreCarpeta;
    private List<Email> emails;

    public Carpeta(String nombreCarpeta) {
        this.nombreCarpeta = nombreCarpeta;
        this.emails = new ArrayList<>();
    }

    public void agregarEmail(Email email) {
        this.emails.add(email);
    }

    public void mover(Email email, Carpeta destino) {
        destino.agregarEmail(email);
    }

    public Email buscar(String nombre){
        return this.emails.stream()
                .filter(e -> e.contieneTexto(nombre))
                .findFirst()
                .orElse(null);
    }


    public int espacioOcupado(){
        return this.emails.stream()
                .mapToInt(e -> e.espacioOcupado())
                .sum();
    }

    public String getNombre() {
        return this.nombreCarpeta;
    }

    //NUEVO
    public int cantidadEmails(){
        return this.emails.size();
    }

    //NUEVO
    public Bag categoriasTamanio(){

        Bag<String> bag = new Bag<>(); // creo bag clave string
        this.emails.stream()
        .map(categoria->categoria.categoriaEmail())  // recorro todos los mails y obtengo su categoría (String)
        .forEach(categoria-> bag.add(categoria));  // agrego cada categoría al Bag (incrementando su contador si ya existe)

       return bag;
    }

    //----- metodos para implementacion de Test

    public List<Email> getEmails(){
        return this.emails;
    }

}

package ejercicio15;

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

    //----- metodos para implementacion de Test

    public List<Email> getEmails(){
        return this.emails;
    }

}

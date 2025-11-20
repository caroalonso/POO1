package ejercicio26;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {

    private Carpeta inbox;
    private List<Carpeta> carpetas;

    public ClienteDeCorreo() {
        this.inbox = new Carpeta("Inbox");
        this.carpetas = new ArrayList<>();
    }

    public void agregarCarpeta(Carpeta carpeta) {
        this.carpetas.add(carpeta);
    }

    public void recibir(Email email) {
        this.inbox.agregarEmail(email);
    }

    public Email buscar(String texto){

        Email email = this.inbox.buscar(texto);

        if (email == null)
            return this.buscarTextoEnCarpetas(texto);
        return email;
    }

    private Email buscarTextoEnCarpetas(String texto){
        return this.carpetas.stream()
                .map(c -> c.buscar(texto))
                .filter(e -> e != null)
                .findFirst()
                .orElse(null);
    }

    public int espacioOcupado(){
        return this.carpetas.stream()
                .mapToInt(c-> c.espacioOcupado())
                .sum() + this.inbox.espacioOcupado();
    }

    //NUEVO
    public int cantidadTotalDeEmailsCliente(){
        return this.carpetas.stream()
                .mapToInt(c->c.cantidadEmails())
                .sum() + this.inbox.cantidadEmails();
    }

    //----- metodos para implementacion de Test

    public List<Carpeta> getCarpetas(){
        return this.carpetas;
    }

    public Carpeta getInbox(){
        return this.inbox;
    }

}

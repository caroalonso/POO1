package ejercicio9;

import java.util.ArrayList;
import java.util.List;


public class Farola {

    private boolean estado = false;// Indica si la farola está encendida (true) o apagada (false)
    private List<Farola> vecinas;

    public Farola() {
        this.vecinas = new ArrayList<>();
    }

    // Conecta esta farola con otra, de forma bidireccional.
    // Si ya son vecinas, no hace nada.
    public void pairWithNeighbor(Farola otraFarola) {
        if (!this.vecinas.contains(otraFarola)) {
            this.vecinas.add(otraFarola);
            otraFarola.pairWithNeighbor(this); // asegura la relación mutua
        }
    }

    // Retorna una copia inmutable de la lista de farolas vecinas.
    public List<Farola> getNeighbors() {
        return List.copyOf(this.vecinas);
    }

    // Enciende esta farola y propaga la acción a todas las vecinas conectadas.
    public void turnOn() {
        if (!this.estado) {
            this.estado = true;
            for (Farola f : vecinas)
                f.turnOn();
        }
    }

    // Apaga esta farola y propaga la acción a todas las vecinas conectadas.
    public void turnOff() {
        if (this.estado) {
            this.estado = false;
            for (Farola f : vecinas)
                f.turnOff();
        }
    }

    // Indica si la farola está encendida.
    // true si está encendida, false si está apagada.
    public boolean isOn() {
        return this.estado;
    }
}








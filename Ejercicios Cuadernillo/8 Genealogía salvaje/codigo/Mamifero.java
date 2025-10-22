package ejercicio8;

import java.time.LocalDate;

public class Mamifero {
    private String identificador;
    private String especie;
    private LocalDate fechaNacimiento;
    private Mamifero padre;
    private Mamifero madre;

    public Mamifero() {
    }

    public Mamifero(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mamifero getPadre() {
        return padre;
    }

    public void setPadre(Mamifero padre) {
        this.padre = padre;
    }

    public Mamifero getMadre() {
        return madre;
    }

    public void setMadre(Mamifero madre) {
        this.madre = madre;
    }

    public Mamifero getAbuelaPaterna() {
        return this.padre == null || this.padre.getMadre() == null ? null : this.padre.getMadre();
    }

    public Mamifero getAbueloPaterno() {
        return this.padre == null || this.padre.getPadre() == null ? null : this.padre.getPadre();
    }

    public Mamifero getAbuelaMaterna() {
        return this.madre == null || this.madre.getMadre() == null ? null : this.madre.getMadre();
    }


    public Mamifero getAbueloMaterno() {
        return this.madre == null || this.madre.getPadre() == null ? null : this.madre.getPadre();
    }

    /*
    tieneComoAncestroA(Mamifero unMamifero):
    Verifica si un mamífero dado aparece en la línea de ascendencia
    (madre o padre, directa o indirectamente) del mamífero actual.
    Primero compara si la madre o el padre inmediato coinciden con el mamífero buscado.
    Si no, busca recursivamente en la ascendencia materna y paterna hasta encontrarlo
    o llegar a un punto sin más ancestros.
    Devuelve true si lo encuentra y false en caso contrario.
    */
    public boolean tieneComoAncestroA(Mamifero unMamifero) {

        if (this.madre == unMamifero || this.padre == unMamifero)
            return true;

        if (this.madre != null && this.madre.tieneComoAncestroA(unMamifero))
            return true;

        if (this.padre != null && this.padre.tieneComoAncestroA(unMamifero))
            return true;

        return false;
    }

}


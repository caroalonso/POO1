package ParcialDebate;

public class Impopular extends Reaccion{

    public Impopular(){}

    @Override
    public int cantidadReacciones(Publicacion publicacion){
        return publicacion.getDislike();
    }
}

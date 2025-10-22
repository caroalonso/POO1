package ParcialDebate;

public class Popular extends Reaccion{

    public Popular(){}

    @Override
    public int cantidadReacciones(Publicacion publicacion){
        return publicacion.getLike();
    }
}

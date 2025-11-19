package ejercicio29Set;

public class ReproduccionVideos extends Actividad{
    private int duracionPublicidad;
    public static final int DIEZ=10;

    public ReproduccionVideos (String ip, int duracionTotal, int duracionPublicidad){
        super(ip,(duracionTotal-duracionPublicidad));
        this.duracionPublicidad=duracionPublicidad;
    }

    @Override
    double montoPorActividad() {
        return this.getDuracion()*DIEZ;
    }
}

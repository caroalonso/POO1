package ParcialMyCarBoxesCorregir;

public class Empleado {
    private String nombre;
    private double costoPorHora;

    public Empleado(String nombre, double costoPorHora) {
        this.nombre = nombre;
        this.costoPorHora = costoPorHora;
    }

    public double costoPorHora(){
        return  this.costoPorHora;
    }
}

package ejercicio14;

public class Esfera extends Pieza {

    private double radio;
    private static final double CUATRO_TERCIOS = 4.0 / 3.0;
    private static final int DOS = 2;
    private static final int TRES = 3;
    private static final int CUATRO = 4;

    public Esfera(String material, String color,double radio) {
        super(material, color);
        if (radio < 0)
            throw new IllegalArgumentException("El valor de radio debe ser un numero positivo");
        this.radio=radio;
    }

    @Override
    public double volumen() {
        return CUATRO_TERCIOS * this.calculoEnComun(this.radio, TRES);
    }

    @Override
    public double superficie() {
        return CUATRO * this.calculoEnComun(this.radio, DOS);
    }

}


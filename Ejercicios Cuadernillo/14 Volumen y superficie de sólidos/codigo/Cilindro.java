package ejercicio14;

public class Cilindro extends Pieza {

    private double radio;
    private double altura;
    private static final int UNO = 1;
    private static final int DOS = 2;

    public Cilindro(String material, String color, double radio, double altura) {
        super(material, color);
        if (radio < 0)
            throw new IllegalArgumentException("El valor de radio debe ser un numero positivo");
        if(altura < 0)
            throw new IllegalArgumentException("El valor de altura  debe ser un numero positivo");
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double volumen() {
        return this.calculoEnComun(this.radio, DOS) * this.altura;
    }

    @Override
    public double superficie() {
        return DOS * this.calculoEnComun(this.radio, UNO) * this.altura + DOS * this.calculoEnComun(this.radio, DOS);
    }

}

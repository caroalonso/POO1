package ejercicio14;

public class PrismasRectangulares extends Pieza {

    private double ladoMenor;
    private double ladoMayor;
    private double altura;
    private static final int DOS = 2;

    public PrismasRectangulares(String material, String color, double ladoMenor, double ladoMayor, double altura) {
        super(material, color);
        if(ladoMenor < 0)
            throw new IllegalArgumentException("El valor de ladoMenor  debe ser un numero positivo");
        if(ladoMayor < 0)
            throw new IllegalArgumentException("El valor de ladoMayor  debe ser un numero positivo");
        if(altura < 0)
            throw new IllegalArgumentException("El valor de altura  debe ser un numero positivo");
        this.ladoMenor = ladoMenor;
        this.ladoMayor = ladoMayor;
        this.altura = altura;
    }

    @Override
    public double volumen() {
        return this.ladoMenor * this.ladoMayor * this.altura;
    }

    @Override
    public double superficie() {
        double base = this.ladoMayor * this.ladoMenor;
        double lateralMayor = this.ladoMayor * this.altura;
        double lateralMenor = this.ladoMenor * this.altura;

        return DOS * (base + lateralMayor + lateralMenor);
    }

}

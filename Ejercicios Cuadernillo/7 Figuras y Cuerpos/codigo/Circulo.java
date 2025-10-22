package ejercicio5;

public class Circulo implements Figura {
    private double radio;
    private double diametro;

    public Circulo(){}

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getRadio() {
        return this.radio;
    }


    public double getDiametro() {
        return this.radio * 2;
    }

    @Override
    public double getArea(){
        return Math.PI * (this.radio * this.radio); // Area: pi x radio al cuadrado
    }

    @Override
    public double getPerimetro(){
        return 2 * Math.PI * this.radio; // Perimetro: 2 x pi x radio
    }

}

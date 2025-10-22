package ejercicio5;

public class Cuerpo3D {

    private Figura carabasal;
    private double altura;

    public Cuerpo3D(){}

    public void setCaraBasal(Figura carabasal) {
        this.carabasal = carabasal;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }


    public double getAltura() {
        return altura;
    }

    public double getVolumen(){
        return this.carabasal.getArea()*this.altura;

    }

    public double getSuperficieExterior(){
        return 2 * this.carabasal.getArea() + this.carabasal.getPerimetro() * this.altura;

    }
}




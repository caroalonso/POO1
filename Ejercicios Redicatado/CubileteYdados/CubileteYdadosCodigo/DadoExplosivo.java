package CubileteYdados;

public class DadoExplosivo extends Dado {

    public DadoExplosivo(int dadoMax) {
        super(dadoMax);
    }

    private boolean esMax(int valor) {
        return this.getDadoMax() == valor;
    }

    @Override
    public int valorDeDadoEnLanzamiento() {
        int suma = 0;
        int valor;
        do {
            valor = this.numeroRandomInteger();
            suma += valor;
        } while (this.esMax(valor));
        return suma;
    }

}

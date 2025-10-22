package CubileteYdados;

import java.util.Random;

public abstract class Dado {
    private int valorDado;
    private int dadoMax;
    private final static Random RANDOM = new Random();

    public Dado(int dadoMax) {
        this.valorDado = 0;
        this.dadoMax = dadoMax;
    }

    public Dado lanzamientoDado() {
        this.valorDado = this.valorDeDadoEnLanzamiento();
        return this;
    }

    protected int numeroRandomInteger() {
        return RANDOM.nextInt(this.dadoMax) + 1;
    }

    protected double numeroRandomDouble(double totalPeso) {
        return RANDOM.nextDouble() * totalPeso;
    }

    public int getDadoMax(){
        return this.dadoMax;
    }

    public int getValorDado(){
        return this.valorDado;
    }

    abstract int valorDeDadoEnLanzamiento();
}

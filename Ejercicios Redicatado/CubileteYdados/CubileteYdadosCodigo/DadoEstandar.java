package CubileteYdados;

public class DadoEstandar extends Dado {
    public DadoEstandar(){
        super(6);
    }

    @Override
    public int valorDeDadoEnLanzamiento(){
        return this.numeroRandomInteger();
    }
}

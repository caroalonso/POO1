package CubileteYdados;

public class DadoModificador extends DadoEstandar {
    private int valorFijoDado;

    public DadoModificador(int valorFijoDado){
        super();
        this.valorFijoDado=valorFijoDado;
    }

    @Override
    public int valorDeDadoEnLanzamiento(){
        return super.valorDeDadoEnLanzamiento() + this.valorFijoDado;
    }
}

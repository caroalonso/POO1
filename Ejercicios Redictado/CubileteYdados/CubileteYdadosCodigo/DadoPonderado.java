package CubileteYdados;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class DadoPonderado extends Dado{
    private NavigableMap<Double,Integer> pesoYvalor = new TreeMap<>();
    private double totalPeso=0;

    public DadoPonderado(Map<Integer,Double> valorYpeso , int dadoMax){
        super(dadoMax);

        for (Map.Entry<Integer,Double> entry: valorYpeso.entrySet()){
            this.totalPeso= entry.getValue();
            this.pesoYvalor.put(this.totalPeso, entry.getKey());
        }
    }

    @Override
    public int valorDeDadoEnLanzamiento(){
        double valor = this.numeroRandomDouble(this.totalPeso);
        return this.pesoYvalor.ceilingEntry(valor).getValue();
    }
}

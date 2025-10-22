package CubileteYdados;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cubilete {
    private List<Dado> dados;
    private List<Resultado> resultados;

    public Cubilete() {
        this.dados = new ArrayList<>();
        this.resultados = new ArrayList<>();
    }

    public void agregarDado(Dado dado) {
        this.dados.add(dado);
    }

    public void realizarLanzamientoConCubilete() {
        this.resultados.add(new Resultado(this.lanzamientoDeDados()));
        this.dados.clear();
    }

    private List<Dado> lanzamientoDeDados() {
        return this.dados.stream()
                .map(d -> d.lanzamientoDado())
                .collect(Collectors.toList());
    }

    public int sumaTotalDeResultados() {
        return this.resultados.stream()
                .mapToInt(r -> r.contarValorDeDados())
                .sum();
    }

}

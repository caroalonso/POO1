package CubileteYdados;

import java.time.LocalDateTime;
import java.util.List;

public class Resultado {
    private LocalDateTime fechaHora;
    private List<Dado> dados;

    public Resultado(List<Dado> dados) {
        this.fechaHora = LocalDateTime.now();
        this.dados = dados;
    }

    public int contarValorDeDados() {
        return this.dados.stream()
                .mapToInt(d -> d.getValorDado())
                .sum();
    }

    public LocalDateTime getFechaHora() {
        return this.fechaHora;
    }
}

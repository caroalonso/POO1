package ejercicio21;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

    private String nombre;
    private String direccion;
    private int numeroIdentificador;
    private List <Envio> envios;

    public Cliente (String nombre,String direccion,int numeroIdentificador){
        this.nombre=nombre;
        this.direccion=direccion;
        this.numeroIdentificador=numeroIdentificador;
        this.envios= new ArrayList<>();
    }

    public void agregarEnvio (Envio envio){
        this.envios.add(envio);
    }

    public double montoApagarDentroDeUnPeriodo (DateLapse dateLapse){
        return this.envios.stream()
                .filter(e->e.dentroDePeriodo(dateLapse))
                .mapToDouble(e->e.costo())
                .sum();
    }
}

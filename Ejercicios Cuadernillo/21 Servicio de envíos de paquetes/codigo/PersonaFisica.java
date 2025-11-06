package ejercicio21;

public class PersonaFisica extends Cliente{

    public static final double DESCUENTO=0.10;

    public PersonaFisica(String nombre,String direccion,int dni){
        super(nombre,direccion,dni);
    }

    public double montoApagarDentroDeUnPeriodo (DateLapse dateLapse){
        return super.montoApagarDentroDeUnPeriodo(dateLapse) * (1 - DESCUENTO);
    }
}

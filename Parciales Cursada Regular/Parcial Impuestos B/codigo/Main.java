package ParcialImpuestosBcorregir;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Agencia agencia = new Agencia();

        Contribuyente contribuyente = agencia.altaContribuyente("CARLOS", "35.334.765", "CARLOS@GMAIL.COM", "LA PLATA");

        Inmueble inmueble = agencia.altaInmueble(586, 50.000, 30.000, contribuyente);

        Automotor automotor = agencia.altaAutomotor("AFJ584", "marca", "modelo", 50.000, LocalDate.of(2021, 5, 23), contribuyente);

        Embarcacion embarcacion = agencia.altaEmbarcacion("LOP487", "nombre", 80.000, LocalDate.of(2020, 4, 12), contribuyente);

        System.out.println(contribuyente.calcularImpuestos());

        List<Contribuyente> contribuyentes = agencia.contribuyentesConMaxImpuestos(5, "LA PLATA");

    }
}

package ParcialViviendas;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
      Empresa empresa = new Empresa();

      Cliente cliente = empresa.agregarCliente("Carolina","calle falsa 123");

      ServicioLimpieza servicioLimpieza = empresa.agregarServicioLimpieza(500,5, 200);

      ServicioParquizacion servicioParquizacion= empresa.agregarServicioParquizacion(500,5,4,200);

      cliente.agregarContratoUnico(LocalDate.now(),servicioLimpieza);

      cliente.agregarContratoProlongado(LocalDate.now(),5,servicioParquizacion);

      System.out.println(cliente.obtenerMonto());
      System.out.println(empresa.serviciosConMontosMayorAvalor(4));

    }
}

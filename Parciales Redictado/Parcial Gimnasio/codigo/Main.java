package ParcialGimnasio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //creacion de Entrenador
        Entrenador entrenador= new Entrenador("nombre Entrenador", LocalDate.of(1980,5,6),3000,4000);

        //creacion de 3 Socios
        Socio socio1= new Socio("nombre Socio1",LocalDate.of(1990,1,1));
        Socio socio2= new Socio("nombre Socio1",LocalDate.of(1991,2,2));
        Socio socio3= new Socio("nombre Socio1",LocalDate.of(1992,3,3));

        //creacion de clase Personalizada para socio1
        Personalizada personalizada = new Personalizada(LocalDate.of(2025,2,5),entrenador,LocalTime.of(7,0),socio1);
        socio1.agregarServicio(personalizada);

        //creacion de clase Libre para socio2
        Libre libre = new Libre(LocalDate.of(2025,2,2),socio2,2);
        socio2.agregarServicio(libre);

        //crecion de Listas de Socios p ara clases Grupales
        List<Socio> listaSocios = new ArrayList<>();
        listaSocios.add(socio1);
        listaSocios.add(socio2);
        listaSocios.add(socio3);

        //creacion de clase Grupal
        Grupal grupal= new Grupal(LocalDate.of(2025,4,17),entrenador,LocalTime.of(7,0),listaSocios);

        //calcular Servicio de Clase Personalizada para socio1
        System.out.println("costo de servicio para clase personalizada de socio1 : $" + personalizada.costoDeServicio());

        //calcular Servicio de Clase Libre para socio2
        System.out.println("costo de servicio para clase libre de socio2 : $" + libre.costoDeServicio());

        //calcular Servicio de Clases Grupales para listasocios
        System.out.println("costo de servicio para clases grupales de los socios : $" + grupal.costoDeServicio());

        System.out.println();

        //dada una fecha retorna el monto que debe abonar el socio1 por sus servicios
        System.out.println(socio1.montoApagarPorFecha(LocalDate.of(2025,2,5)));

    }
}

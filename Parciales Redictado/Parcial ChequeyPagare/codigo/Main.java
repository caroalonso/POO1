package ParcialChequeyPagare;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();

        Pagare pagare = new Pagare(120, "Caro", "Ramon", LocalDate.now(), LocalDate.now().plusDays(30));

        Cheque cheque = new Cheque(160, "Carlos", "Juan", LocalDate.now());

        banco.agregarCheque(cheque);
        banco.agregarPagare(pagare);

        //suma de monto de los cheques que NO estan vencidos y los pagarés vencidos.
        System.out.println(banco.valorLiquido());
    }
}

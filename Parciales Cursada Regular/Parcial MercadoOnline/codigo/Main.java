package ParcialMercadoOnlineCorregir;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Mercado mercado = new Mercado();
        Usuario usuario= mercado.agregarUsuario("email@gmail.com","La Plata");
        Producto productoNuevo = usuario.agregarProductoNuevo("mesa","material madera",35.000,3,new EntregaExpress());
        Producto productoUsado = usuario.agregarProductoUsado("silla","color blanca",5.000);
        Servicio servicio = usuario.agregarServicio("Fotografia","foto retrato", 25.000);
        List<Publicacion> diezMasCaros = mercado.diezMasCaros("Quilmes");
    }
}

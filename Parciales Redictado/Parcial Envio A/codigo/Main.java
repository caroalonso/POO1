package ParcialEnvioA;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 3 Productos MIN
        Producto p1Min = new Producto(300, 400);
        Producto p2Min = new Producto(250, 300);
        Producto p3Min = new Producto(200, 350);
        // Lista de prodcutos Minimos
        List<Producto> productosMin = new ArrayList<>();
        productosMin.add(p1Min);
        productosMin.add(p2Min);
        productosMin.add(p3Min);

        // 3 Productos NORMAL
        Producto p1Normal = new Producto(1000, 3000);
        Producto p2Normal = new Producto(1200, 2500);
        Producto p3Normal = new Producto(1500, 2000);
        // Lista de productos Normales
        List<Producto> productosNormal = new ArrayList<>();
        productosNormal.add(p1Normal);
        productosNormal.add(p2Normal);
        productosNormal.add(p3Normal);

        // 3 Productos MAX
        Producto p1Max = new Producto(4000, 7000);
        Producto p2Max = new Producto(5000, 8000);
        Producto p3Max = new Producto(3500, 6000);
        // Lista de productos Maximos
        List<Producto> productosMax = new ArrayList<>();
        productosMax.add(p1Max);
        productosMax.add(p2Max);
        productosMax.add(p3Max);

        // Crecion de los 3 tipos de Paquetes
        Paquete paqueteMin = new Min(LocalDate.now(), "La Plata", productosMin);
        Paquete paqueteNormal = new Normal(LocalDate.now(), "Mar del Plata", productosNormal);
        Paquete paqueteMax = new Max(LocalDate.now(), "Bahía Blanca", productosMax);

        // Creacion de lista de Paquetes
        List<Paquete> paquetes = new ArrayList<>();
        paquetes.add(paqueteMin);
        paquetes.add(paqueteNormal);
        paquetes.add(paqueteMax);

       // Validar paquete y Cargar camion
        Camion camion = new Camion(50000,30000);
        camion.cargarCamion(paquetes);
    }
}
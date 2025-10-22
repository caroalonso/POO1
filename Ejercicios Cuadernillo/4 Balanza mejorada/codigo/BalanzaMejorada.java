package ejercicio4;

import ejercicio2.Producto;
import ejercicio2.Ticket;

import java.util.ArrayList;
import java.util.List;

public class BalanzaMejorada {

    private List<Producto> productos;

    public BalanzaMejorada() {
        this.productos= new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }

    public void ponerEnCero(){
        this.productos.clear();
    }

   public int getCantidadDeProductos(){
        return this.productos.size();
   }

   public double getPrecioTotal(){
        return this.productos.stream()
                .mapToDouble(productos->productos.getPrecio())
                .sum();
   }

   public double getPesoTotal(){
        return this.productos.stream()
               .mapToDouble(productos->productos.getPeso())
               .sum();
   }

   public List<Producto> getProductos(){
        return this.productos;
    }

    public Ticket emitirTicket(){
        return new Ticket(this.getCantidadDeProductos() ,this.getPesoTotal(), this.getPrecioTotal());
    }

}

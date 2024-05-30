
package sinThreads;

import domain.ClienteProducto;
import domain.Producto;
import java.util.ArrayList;
import java.util.List;

public class CajeraProductoMain {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        setProductos(productos);
        ClienteProducto cliente1  = new ClienteProducto("alexis", productos, "CAJERA");
        ClienteProducto cliente2  = new ClienteProducto("valentina", productos, "CAJERA");
        ClienteProducto cliente3  = new ClienteProducto("jorge", productos, "CAJERA");
        
        long initialTime = System.currentTimeMillis();
        System.out.println(initialTime);
        CajeraProducto cajera1 = new CajeraProducto("verónica");
        CajeraProducto cajera2 = new CajeraProducto("Andrea");
        CajeraProducto cajera3 = new CajeraProducto("Tatiana");
    
        cajera1.procesarCompra(cliente1, initialTime);
        cajera2.procesarCompra(cliente2, initialTime);
        cajera3.procesarCompra(cliente3, initialTime);
    }
   
    private static void setProductos(List<Producto> productos){
        Producto producto1 = new Producto("Zapato", 500, 1);
        Producto producto2 = new Producto("Camisa", 40, 2);
        Producto producto3 = new Producto("Yiyos", 12, 4);
        
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
    }
    
}

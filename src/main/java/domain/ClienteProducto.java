
package domain;

import java.util.List;

public class ClienteProducto {
     
    private final String nombre;
    private final List<Producto> productos;
    private final String cajeroAsign;

    public ClienteProducto(String nombre, List<Producto> productos, String cajero) {
        this.nombre = nombre;
        this.productos = productos;
        this.cajeroAsign = cajero;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String getCajeroAsign() {
        return cajeroAsign;
    }
    
}

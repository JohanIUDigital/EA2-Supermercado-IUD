package sinThreads;

import domain.ClienteProducto;
import domain.Producto;

public class CajeraProducto {

    private String nombreCajera;

    public CajeraProducto(String nombreCajera) {
        this.nombreCajera = nombreCajera;
    }

    public void procesarCompra(ClienteProducto cliente, long timestamp) {
        System.out.println("La cajera " + this.nombreCajera + " inicia compra del cliente "
                + cliente.getNombre() + " a las " + ((System.currentTimeMillis() - timestamp) / 1000) + " seg");

        int contProd = 1;
        float totalpagar = 0;
        for (Producto producto : cliente.getProductos()) {
            System.out.println("====================================== Proceso de Producto =======================================");
            this.waitInSeconds();
            System.out.println("   Nombre de Cliente: " + cliente.getNombre() + "\n"
                    + " Nombre Producto (" + contProd + "): " + producto.getNombre() + "\n"
                    + "   Precio por unidad: " + producto.getPrecio() + "\n"
                    + "   Cantidad a llevar: " + producto.getCantidad() + "\n"
                    + "               Total: " + producto.getCantidad() * producto.getPrecio() + "\n"
                    + " Tiempo de ejecución: " + ((System.currentTimeMillis() - timestamp) / 1000) + " seg");
            contProd++;
            totalpagar += (producto.getCantidad() * producto.getPrecio());
        }
        System.out.println("======================================== Resumen de Venta ========================================");
        System.out.println("          Nombre de Cajero: " + this.nombreCajera + "\n"
                + "         Nombre de cliente: " + cliente.getNombre() + "\n"
                + "             Total a Pagar: " + totalpagar + "\n"
                + " Tiempo total de ejecución: " + ((System.currentTimeMillis() - timestamp) / 1000) + " seg ");

    }

    private void waitInSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

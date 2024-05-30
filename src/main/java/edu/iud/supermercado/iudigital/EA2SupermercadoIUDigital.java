package edu.iud.supermercado.iudigital;

import concurrency.RunnableClass;
import concurrency.ThreadClass;
import domain.ClienteProducto;
import domain.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sinThreads.CajeraProducto;
import conThreads.CajeraProductoThread;

public class EA2SupermercadoIUDigital {

    public static void main(String[] args) {
        ThreadClass tc = new ThreadClass();
        RunnableClass rc = new RunnableClass();
        Thread hilo = new Thread(rc);
        //tc.start();
        //hilo.start();

        String[] cajeros = {"Juan", "María", "Carlos", "Lucía", "Pedro", "Ana", "José", "Marta", "Luis", "Elena",
            "Fernando", "Laura", "Miguel", "Carmen", "Jorge", "Patricia", "Raúl", "Isabel", "Daniel", "Sofía"};
         List<ClienteProducto> listaClientes = new ArrayList<>();

        String dato = JOptionPane.showInputDialog(null, "¿Cuantos clientes vamos a atender el dia de hoy?", "Supermercado IUDigital", JOptionPane.QUESTION_MESSAGE);
        int cantiCl = Integer.parseInt(dato);
        for (int i = 0; i < cantiCl; i++) {

            Random random = new Random();
            // Obtenemos un índice aleatorio del array
            int iRandom = random.nextInt(cajeros.length);
            // Obtenemos el nombre en el índice aleatorio
            String cajeroRandom = cajeros[iRandom];
            // Crear un panel para contener los componentes del formulario
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            // Crear campos de texto y etiquetas
            JLabel cajeroLabel = new JLabel("Cajero asignado:");
            JTextField cajeroField = new JTextField(cajeroRandom);
            cajeroField.setEditable(false);
            JLabel nombreLabel = new JLabel("Nombre del Cliente " + (i + 1) + " :");
            JTextField nombreField = new JTextField(10);
            JLabel cantiLabel = new JLabel("Cantidad de productos:");
            JTextField cantiField = new JTextField(10);
            // Añadir componentes al panel
            panel.add(cajeroLabel);
            panel.add(cajeroField);
            panel.add(nombreLabel);
            panel.add(nombreField);
            panel.add(cantiLabel);
            panel.add(cantiField);
            // Mostrar el panel en un cuadro de diálogo
            JOptionPane.showConfirmDialog(null, panel, "Supermercado IUDigital", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE);
            String nombre = nombreField.getText();
            String canti = cantiField.getText();
            List<Producto> listProductos = new ArrayList<>();
            for (int j = 0; j < Integer.parseInt(canti); j++) {
                // Crear un panel para contener los componentes del formulario
                JPanel panel2 = new JPanel();
                panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
                // Crear campos de texto y etiquetas
                JLabel prodLabel = new JLabel("Nombre del " + (j + 1) + " Producto:");
                JTextField prodField = new JTextField(10);
                JLabel cantiPLabel = new JLabel("Cantidad del " + (j + 1) + " Producto:");
                JTextField cantiPField = new JTextField(10);
                JLabel precioLabel = new JLabel("Precio del " + (j + 1) + " Producto:");
                JTextField precioField = new JTextField(10);
                // Añadir componentes al panel
                panel2.add(prodLabel);
                panel2.add(prodField);
                panel2.add(precioLabel);
                panel2.add(precioField);
                panel2.add(cantiPLabel);
                panel2.add(cantiPField);

                // Mostrar el panel en un cuadro de diálogo
                JOptionPane.showConfirmDialog(null, panel2, "Productos de " + nombre, JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE);
                String prod = prodField.getText();
                String precio = precioField.getText();
                String cantiP = cantiPField.getText();

                Producto producto = new Producto(prod, Float.parseFloat(precio), Integer.parseInt(cantiP));
                listProductos.add(producto);
            }
            ClienteProducto cliente = new ClienteProducto(nombre, listProductos, cajeroRandom);
            listaClientes.add(cliente);
            //long initialTime = System.currentTimeMillis();
            //cajero.procesarCompra(cliente, initialTime);
        }
        
        long initialTime = System.currentTimeMillis();
         for (ClienteProducto cliente : listaClientes) {
            //CON THREAD 
            CajeraProductoThread cajeroThread = new CajeraProductoThread(cliente.getCajeroAsign(), cliente, initialTime);
            cajeroThread.start();
            
            //SIN THREAD
            //CajeraProducto cajero = new CajeraProducto(cliente.getCajeroAsign());
            //cajero.procesarCompra(cliente, initialTime);
        }
    }

}

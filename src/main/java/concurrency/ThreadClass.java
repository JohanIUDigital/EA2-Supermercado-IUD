
package concurrency;

public class ThreadClass extends Thread{
    
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hola soy un hilo o thread " + i);
        }
    }
}


package concurrency;

public class RunnableClass implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hola soy runnable " + i);
        }
    }
    
}

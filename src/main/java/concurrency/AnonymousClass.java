package concurrency;

public class AnonymousClass {

    public static void main(String[] args) {
        //RunnableClass rc = new RunnableClass();
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hola soy runnable " + i);
                }
            }
        });
        hilo.start();
        System.out.println("anonimus start thread");
        System.out.println("anonimus finish");
        System.out.println("======================");
        
    }

}

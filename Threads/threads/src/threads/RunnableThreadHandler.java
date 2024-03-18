package threads;

public class RunnableThreadHandler {
    
    public void startHandler(){
        SingleThreadRunnable newT1 = new SingleThreadRunnable(0);

        Thread thread = new Thread(newT1);

        thread.start();
    }

}

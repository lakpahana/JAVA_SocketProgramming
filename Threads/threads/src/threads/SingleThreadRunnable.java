package threads;

public class SingleThreadRunnable implements Runnable {

    private int threadNumber = 0; 

    public SingleThreadRunnable(int ThreadNumber){
        this.threadNumber = ThreadNumber;
    }

    @Override
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("from "+threadNumber+" printing "+i);

            if (threadNumber == 1) {
                throw new RuntimeException();                
            }

            try {
                Thread.sleep(1000);
                
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    
    
}

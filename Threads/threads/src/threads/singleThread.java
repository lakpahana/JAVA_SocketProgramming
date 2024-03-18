package threads;

public class singleThread extends Thread {

    private int threadNumber = 0; 

    public singleThread(int ThreadNumber){
        this.threadNumber = ThreadNumber;
    }


    @Override
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("from "+threadNumber+" printing "+i);
            try {
                Thread.sleep(1000);
                
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    
}

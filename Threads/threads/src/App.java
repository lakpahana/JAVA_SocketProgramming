import threads.singleThread;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        singleThread newThread = new singleThread(1);
        singleThread newThread2 = new singleThread(2);

        newThread.start();
        newThread2.start();

    }
}

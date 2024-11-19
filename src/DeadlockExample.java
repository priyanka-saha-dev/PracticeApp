import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Resource {
    public synchronized void methodA(Resource r) {
        System.out.println(Thread.currentThread().getName() + " is executing methodA");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.methodB(this);
    }

    public synchronized void methodB(Resource r) {
        System.out.println(Thread.currentThread().getName() + " is executing methodB");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.methodA(this);
    }
}

public class DeadlockExample {
    public static void main(String[] args) {

        Resource r1 = new Resource();
        Resource r2 = new Resource();

        //Option 1 to create/handle Threads
        Thread t1 = new Thread(() -> r1.methodA(r2), "Thread 1");
        Thread t2 = new Thread(() -> r2.methodB(r1), "Thread 2");

        t1.start();
        t2.start();

        //Option 2 to create/handle Threads
//        ExecutorService s1 = Executors.newSingleThreadExecutor();
//        s1.submit(() -> r1.methodA(r2));
//        ExecutorService s2 = Executors.newSingleThreadExecutor();
//        s2.submit(() -> r2.methodB(r1));
//
//        s1.shutdown();
//        s2.shutdown();

    }
}

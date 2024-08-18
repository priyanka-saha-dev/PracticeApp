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

        Thread t1 = new Thread(() -> r1.methodA(r2), "Thread 1");
        Thread t2 = new Thread(() -> r2.methodB(r1), "Thread 2");

        t1.start();
        t2.start();
    }
}

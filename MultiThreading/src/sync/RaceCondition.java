package sync;

class Counter  implements Runnable{
    private int c = 0; // shared variable c is giving wrong values.

    public void increment() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c++;
    }

    public void decrement() {    
        c--;
    }

    public int getValue() {
        //System.out.println("in getValue method ");
        
        return c;
    }
    
    @Override
    public void run() {
        //incrementing
        this.increment();
        System.out.println("Value for Thread After increment " 
        + Thread.currentThread().getName() + " " + this.getValue());
        //decrementing
        this.decrement();
        System.out.println("Value for Thread at last " 
        + Thread.currentThread().getName() + " " + this.getValue());
        
    }
}

public class RaceCondition{
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }    
}
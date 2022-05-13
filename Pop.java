package multithreading;

import java.util.ArrayList;

public class Pop extends Thread {

    ArrayList<Integer>  Queue;
    public Pop(ArrayList<Integer> Queue) {
        this.Queue= Queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                consumeDosa();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private void consumeDosa()throws InterruptedException{
        synchronized (Queue){
            while (Queue.isEmpty()){
                System.out.println("Conatiner is empty,... please wait");
                Queue.wait();
            }
            Thread.sleep(3000);
            Queue.remove(0);
            System.out.println("pop"+Queue);
            Queue.notifyAll();
        }
    }
}

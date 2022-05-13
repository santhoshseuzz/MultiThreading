package multithreading;

import java.util.ArrayList;

public class Push extends Thread{
    ArrayList<Integer> Queue;
    public Push(ArrayList<Integer> Queue) {
        this.Queue= Queue;
    }
    int capacity = 10;
    int counter=0;

    Push(){

    }
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        super.run();
        int counter=0;
        while (true){
            try {
                produceDosa(counter++);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private void produceDosa(int i)throws InterruptedException{
        synchronized (Queue){
            while (Queue.size()==capacity){
                System.out.println("Dosa is Full");
                Queue.wait();
            }
            Thread.sleep(200);
            Queue.add(i);
            System.out.println("push"+Queue);
            Queue.notifyAll();
        }
    }
}

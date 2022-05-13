package multithread;
public class WaitMain {
    public static void main(String[] args) {
        Wait obj = new Wait();
        obj.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj) {
            try {
                obj.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(obj.tot);
    }
}
class  Wait extends Thread {
    int tot = 1;

    @Override
    public void run() {
        super.run();
        synchronized (this) {
            for (int i = 1; i <= 100; i++) {
                tot = tot + i;
            }
            this.notify();
        }
    }
}

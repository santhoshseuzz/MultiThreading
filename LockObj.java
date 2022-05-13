package multithread;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class LockObj {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        ArrayList<Integer> integerList = new ArrayList<>();
        //ArrayList<Integer> integerList1 = new ArrayList<>();
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        integerList.add(0);
        System.out.println("Seats Available:"+integerList);

        seatBooks o1= new seatBooks(lock,integerList);
        seatBooks o2= new seatBooks(lock,integerList);
        seatBooks o3= new seatBooks(lock,integerList);
        seatBooks o4= new seatBooks(lock,integerList);
        seatBooks o5= new seatBooks(lock,integerList);
        seatBooks o6= new seatBooks(lock,integerList);
        seatBooks o7= new seatBooks(lock,integerList);
        seatBooks o8= new seatBooks(lock,integerList);
        //second class....
        seatBooks1 obj1= new seatBooks1(lock,integerList);
        seatBooks1 oj1= new seatBooks1(lock,integerList);
        seatBooks1 oj2= new seatBooks1(lock,integerList);
        seatBooks1 oj3= new seatBooks1(lock,integerList);
        seatBooks1 oj4= new seatBooks1(lock,integerList);

        o1.start();
        obj1.start();
        o2.start();
        o3.start();
        oj1.start();
        o4.start();
        o5.start();
        oj3.start();
        o6.start();
        o7.start();
        o8.start();
        //Thread.sleep(10000);
        while (Thread.activeCount()!=1){

        }

        System.out.println(Thread.activeCount());
        System.out.println("If Locked : "+lock.isLocked());
    }
}

class  seatBooks extends Thread {
    ReentrantLock lock;
    ArrayList<Integer> list;

    seatBooks(ReentrantLock lock, ArrayList<Integer> list) {
        this.lock = lock;
        this.list = list;
    }

    public void run() {
        lock.lock();
        if (list.contains(0)) {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 0) {
                    list.set(i, 1);
                    break;
                }

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("1 : ");
            System.out.println(list);
            lock.unlock();

        }
        else {
            System.out.println("Seats are not available......");
            lock.unlock();
        }


    }
}
class seatBooks1 extends Thread{
    ReentrantLock lock;
    ArrayList<Integer> list;
    seatBooks1(ReentrantLock lock,ArrayList<Integer> list){
        this.lock= lock;
        this.list=list;
    }

    public void run() {
        lock.lock();
        if (list.contains(0)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 0) {
                    list.set(i, 2);
                    break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("2 : ");
            System.out.println(list);
            lock.unlock();
        }
        else{
            if(lock.isLocked()) {
              //  System.out.println("True...........");
                lock.unlock();
            }

        }
    }
}








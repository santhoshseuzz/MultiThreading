package ticket;

import java.util.LinkedList;
import java.util.Random;

import static java.util.concurrent.ForkJoinTask.invokeAll;

public class TicketData  extends  Thread {
    private String customername;
    private  int age;
    private  int status;
    private  int seats;
    Ticketmethods ticketmethods;
    LinkedList<TicketData> list = new LinkedList<>();
    TicketData(){

    }
    TicketData(LinkedList<TicketData> ticketData){
        this.list = ticketData;
    }

    public Ticketmethods getTicketmethods() {
        return ticketmethods;
    }

    public void setTicketmethods(Ticketmethods ticketmethods) {
        this.ticketmethods = ticketmethods;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
     static int count=0;
    //ketData data =  new TicketData();
    Random random = new Random();
     int i=0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public synchronized void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Vip Customer....");
        }
        ticketmethods.counter(customername,age,status);
    }
    void invoke(){
        invokeAll();
    }
}

package ticket;

import java.util.LinkedList;
import java.util.Scanner;

public class Ticketmethods extends Thread {
    LinkedList<TicketData> list = new LinkedList<>();
    Scanner get = new Scanner(System.in);
    String name;
    String threadname;
    TicketData listdata= new TicketData(list);
    static int seats = 10;

    void addCustomers(){
        TicketData data= new TicketData();
        Ticketmethods ticketmethods= new Ticketmethods();
        System.out.print("Enter the name:");
        String name = get.next();
        data.setCustomername(name);
        System.out.print("Enter the age:");
        int age= get.nextInt();
        data.setAge(age);
        System.out.print("Enter 1 or 2 or3:");
        int status= get.nextInt();
       // data.setI(list.size());
        data.setStatus(status);
        data.setTicketmethods(ticketmethods);
        list.add(data);
    }
    TicketData seatssetup= new TicketData();
     synchronized void listRun() throws InterruptedException {
        for(int i =0;i< list.size();i++){
            if(list.get(i).getAge()>80){
                list.get(i).start();
                list.get(i).yield();
            }
            else if(list.get(i).getAge()<18){
                list.get(i).setPriority(1);
                list.get(i).start();
            }
            else if(list.get(i).getStatus()==2) {
                list.get(i).setPriority(10);
                list.get(i).start();
            }
            else if(list.get(i).getStatus()==3){
                list.get(i).start();
                list.get(i).interrupt();
                list.get(i).join();
            }
            else {
                list.get(i).start();
            }
        }
    }
    static int count=0;

    synchronized void  counter(String  name,int age,int status){
        if (seats != 0 ) {
            seats = seats - 2;
            seatssetup.setSeats(seats);
            System.out.println("name:" + name + " age:" + age + " status:" + status + " seatsavailable:" + seats);
        } else {
            System.out.println("seats are not booked");
            return;
        }
    }

}
package ticket;

import java.util.Scanner;

public class TicketMain  extends Thread{
    public static void main(String[] args) {
        Ticketmethods obj = new Ticketmethods();
        Scanner get= new Scanner(System.in);

        System.out.print("Enter no of customers  :: ");
        int choice= get.nextInt();
        int count =0;


        while (choice !=count) {
           obj.addCustomers();
           count++;
        }
            try {
                obj.listRun();
               // obj.notityThread();
            } catch (InterruptedException e) {
                System.out.println("ex3");
            }

        try {
            Thread.sleep(10000);
            TicketData a = new TicketData();
            a.invoke();
          //  obj.notityThread();
            System.out.println(Thread.activeCount());
            System.out.println(Thread.activeCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

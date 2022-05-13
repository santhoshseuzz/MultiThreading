package multithreading;

import java.util.ArrayList;

public class PushPop {
    public static void main(String[] args) {
        ArrayList<Integer> Queue = new ArrayList<>();
        Push push = new Push(Queue);
        Pop pop = new Pop(Queue);
        Pop pop2= new Pop(Queue);
        push.start();
        pop.start();
        //pop2.start();

    }
}

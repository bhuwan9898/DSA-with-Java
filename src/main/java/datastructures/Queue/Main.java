package main.java.datastructures.Queue;

public class Main {

    public static void main(String[] args) {

        Queue myQueue = new Queue(4);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();

        System.out.println("\nQueue:");
        myQueue.printQueue();

    }
}

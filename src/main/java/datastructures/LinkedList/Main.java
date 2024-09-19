package main.java.datastructures.LinkedList;

public class Main{
    public static void main(String[] args){
        LinkedList myLinkedList = new LinkedList(1);
        for (int i = 2;i<5;i++){
            myLinkedList.append(i);
        }
        myLinkedList.printList();
        myLinkedList.removeLast();
        myLinkedList.printList();
    }
}

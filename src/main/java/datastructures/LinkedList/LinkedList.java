package main.java.datastructures.LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    //this has O(n) time complexity
    public Node removeLast(){
        if (length == 0)return null;
        Node temp = head;
        Node prev = head;
        while(temp.next!= null){
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        length--;
        if(length==0){
            head = null;
            tail = null;
        }
        return temp;
    }
    public void prepend(int value){
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }
    public Node removeFirst(){
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0){
            tail = null;
        }
        return temp;
    }
    public Node get(int index){
        if (index <0||index >= length){
            return null;
        }
        if(length == 0) return null;
        Node temp = head;
        for(int i= 0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }
    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp !=null){
            temp.value = value;
            return true;
        }
        return false;
    }
    public boolean insert(int index, int value){
        if (index<0 || index >length)return false;
        if (index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node prev = get(index-1);
        newNode.next = prev.next;
        prev.next = newNode;
        length++;
        return true;
    }
    public Node remove(int index){
        if(index <0 || index>length) return null;
        if (index ==0) {
           return removeFirst();
        };
        if (index == length-1){
            return removeLast();
        }

        Node prev = get(index-1);
        Node thisNode = prev.next;
        prev.next =thisNode.next;
        thisNode.next = null;
        length--;
        return thisNode;
    }
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    public Node mergeTwoLists(Node head1, Node head2){
        Node startNode = head1;
        if(head1.value>head2.value){
            startNode = head2;
        }
        Node temp;
        Node node1 = head1;
        Node node2 = head2;
        while(node1 != null && node2 !=null){
            if(node2.value>=node1.value){
                temp = node1.next;
                node1.next = node2;
                node1 = temp;
            }
            else{
                temp = node2;
                node2.next = node1;
                node2 = temp;
            }

        }
        return startNode;

    }
}

package linkedlist;

public class LinkedList {

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }

    }

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void printList() {
        Node temp = this.head;
        System.out.print("LinkedList#printList() :: ");
        while (temp != null) {
            print(temp);
            temp = temp.next;
        }
        System.out.println();
    }

    private static void print(Node temp) {
        System.out.print(temp.value);
        if(temp.next != null) {
            System.out.print(" >> "); // To avoid printing after the last element
        }
    }

    public void append(int value) {
        Node node = new Node(value);
        if(this.length == 0 && this.head == null && this.tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.length++;
    }

    public Node removeLast() {

        if(this.length == 0 && this.head == null && this.tail == null) { // Edge case for Empty LinkedList
            return null;
        }

        Node temp = this.head;
        Node pre = this.head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        this.tail = pre;
        this.tail.next = null;
        this.length--;
        if(this.length == 0) { //Edge case with only 1 node
            this.head = null;
            this.tail = null;
        }

        return temp;

    }

    public void insertFirst(int value) {
        Node node = new Node(value);

        if(this.length == 0 && this.head == null && this.tail == null) { // Edge case for Empty LinkedList
            this.head = node;
            this.tail = node;
        } else {
            Node temp = this.head;
            this.head = node;
            this.head.next = temp;

            // OR
            // node.next = this.head;
            // this.head = node;
        }
        this.length++;
    }

    public Node removeFirst() {

        if(this.length == 0 && this.head == null && this.tail == null) { // Edge case for Empty LinkedList
            return null;
        }

        Node temp = this.head;
        this.head = temp.next;
        temp.next = null;
        this.length--;

        return temp;
    }

    public Node removeFirst(int index) {
        if(index < 0 || index >= this.length) {
            return null;
        }

        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;

    }

    public void getHead() {
        System.out.println("Head :: " + this.head.value);
    }

    public void getTail() {
        System.out.println("Tail :: " + this.tail.value);
    }

    public void getLength() {
        System.out.println("Length :: " + this.length);
    }
}



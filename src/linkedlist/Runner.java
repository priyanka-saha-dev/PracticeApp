package linkedlist;

public class Runner {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(4);
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);

        list.printList();

        LinkedList.Node removedLastNode = list.removeLast();
        System.out.println("Runner#LinkedList#removeLast() : " + removedLastNode);

        list.printList();

        list.insertFirst(3);

        list.printList();

        LinkedList.Node removedFirstNode = list.removeFirst();
        System.out.println("Runner#LinkedList#removeFirst() : " + removedFirstNode);

        list.printList();
    }
}

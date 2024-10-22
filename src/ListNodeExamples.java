import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ListNodeExamples {

    public static void main(String[] args) {
        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
//        ListNode head = new ListNode(10);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(13);
//        head.next.next.next = new ListNode(40);
//        head.next.next.next.next = new ListNode(5);
//
//        // Print the original linked list
//        System.out.println("Given Linked list:");
//        printList(head);
//
//        // Function call to return the reversed list
////        head = reverseList(head);
//
//        // Function call to return the reversed list in K Groups
//        head = reverseKGroup(head, 2);
//
//        // Print the reversed linked list
//        System.out.print("\nReversed Linked List:");
//        printList(head);

        // Create a hard-coded linked list:
        // 2 -> 4 -> 8 -> 9
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(8);
        first.next.next.next = new ListNode(9);

        // Create another hard-coded linked list:
        // 1 -> 3 -> 8 -> 10
        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(8);
        second.next.next.next = new ListNode(10);

        ListNode head = mergeTwoSortedList(first, second);

        printList(head);
    }

    // This function prints the contents
    // of the linked list starting from the head
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(" " + node.val);
            node = node.next;
        }
        System.out.println("");
    }

    private static ListNode reverseList(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            nodes.add(temp.val);
            temp = temp.next;
        }

        Collections.reverse(nodes);

        ListNode headR = new ListNode(0);
        ListNode current = headR;

        for (Integer i : nodes) {
            ListNode t = new ListNode(i);
            current.next = t;
            current = current.next;
        }

        return headR.next;

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> nodes = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            nodes.add(temp.val);
            temp = temp.next;
        }

        for (int i = 0; i < nodes.size() - k; i+=k) {
            reverseInKGroups(i, i+k-1, nodes);
        }

        ListNode headR = new ListNode(0);
        ListNode current = headR;
        for (Integer i : nodes) {
            ListNode tempR = new ListNode(i);
            current.next = tempR;
            current = current.next;
        }

        return headR.next;
    }

    private static void reverseInKGroups(int left, int right, List<Integer> list) {

        while (left < right) {

            Integer leftElement = list.get(left);
            Integer rightElement = list.get(right);

            list.set(left, rightElement);
            list.set(right, leftElement);

            ++left;
            --right;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>();
        for (ListNode list : lists) {

            ListNode temp = list;
            while(temp != null) {
                nodes.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(nodes);

        ListNode headR = new ListNode(0);
        ListNode temp = headR;
        for (Integer i : nodes) {
            ListNode t = new ListNode(i);
            temp.next = t;
            temp = t.next;
        }

        return headR.next;
    }

    public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {

        List<Integer> nodes1 = new ArrayList<>();
        ListNode current1 = l1;
        while(current1 != null) {
            nodes1.add(current1.val);
            current1 = current1.next;
        }

        List<Integer> nodes2 = new ArrayList<>();
        ListNode current2 = l2;
        while(current2 != null) {
            nodes2.add(current2.val);
            current2 = current2.next;
        }

        List<Integer> nodes = Stream.of(nodes1, nodes2).flatMap(Collection::stream).sorted().toList();
//        List<Integer> nodes = Stream.concat(nodes1.stream(), nodes2.stream()).toList();

        ListNode headR = new ListNode(0);
        ListNode temp = headR;
        for (Integer i : nodes) {
            ListNode t = new ListNode(i);
            temp.next = t;
            temp = temp.next;
        }

        return headR.next;

    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode() {}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// Java program to detect and remove loop in linked list
  
class LinkedList {
  
    static Node head;
  
    static class Node {
  
        int data;
        Node next;
  
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
  
    // Function that detects loop in the list
    int detectAndRemoveLoop(Node node)
    {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
  
            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }
  
    // Function to remove loop
    void removeLoop(Node loop, Node head)
    {
        Node ptr1 = loop;
        Node ptr2 = loop;
  
        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }
  
        // Fix one pointer to head
        ptr1 = head;
  
        // And the other pointer to k nodes after head
        ptr2 = head;
        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }
  
        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
  
        // Get pointer to the last node
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
  
        /* Set the next node of the loop ending node
         to fix the loop */
        ptr2.next = null;
    }
  
    // Function to print the linked list
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
  
    // Driver program to test above functions
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);
  
        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
}


// Java program for reversing the linked list
 
class LinkedList {
 
    static Node head;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    /* Function to reverse the linked list */
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
 
    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
         
        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}

// Java Program to Merge Two Sorted
// Linked Lists in New List
// Iteratively
 
import java.io.*;
 
public class ListNode {
 
    int val;
    ListNode next;
 
    ListNode() {}
    ListNode(int val) { this.val = val; }
 
    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}
 
class GFG {
    public static ListNode mergeTwoLists(ListNode l1,
                                         ListNode l2)
    {
        // New List
        ListNode result = new ListNode(-1);
 
        // variable to point the last node of the list.
        ListNode p = result;
 
        // Iterate the loop
        while (l1 != null && l2 != null) {
            // Find the smaller element and append it to the
            // list.
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            }
 
            else {
                p.next = l2;
                l2 = l2.next;
            }
 
            // Update the variable
            p = p.next;
        }
 
        // If anyone list become empty append the remaining
        // list element of othe list.
        if (l1 == null) {
            p.next = l2;
        }
 
        else if (l2 == null) {
            p.next = l1;
        }
 
        // Return the resultant list without first extra
        // node
        return result.next;
    }
 
    // A utility function to print linked list
    static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
 
    // Driver code
    public static void main(String[] args)
    {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
 
        // 1->3->5 LinkedList created
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);
 
        // 0->2->4 LinkedList created
        ListNode mergedhead = mergeTwoLists(head1, head2);
 
        printList(mergedhead);
    }
}

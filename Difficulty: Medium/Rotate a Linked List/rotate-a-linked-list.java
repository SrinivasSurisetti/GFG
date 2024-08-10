//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/
class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // Base cases
        if (head == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the list and the last node
        Node cur = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        
        // Step 2: Adjust k if greater than or equal to length
        k = k % len;
        if (k == 0) {
            return head; // No rotation needed
        }

        // Step 3: Traverse the list to find the (k-1)th node
        cur = head;
        for (int i = 1; i < k; i++) {
            cur = cur.next;
        }
        
        // Step 4: Set the new head and break the list
        Node newhead = cur.next;
        cur.next = null;

        // Step 5: Link the end of the new list to the original head
        Node temp = newhead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        // Return the new head of the rotated list
        return newhead;
    }
}



//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}

// } Driver Code Ends
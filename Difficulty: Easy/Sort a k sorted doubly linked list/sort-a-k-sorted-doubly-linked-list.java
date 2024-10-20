//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Main {
    public static void push(DLLNode tail, int new_data) {
        DLLNode newNode = new DLLNode(new_data);
        newNode.next = null;
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }
    }

    public static void printList(DLLNode head) {
        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] arr = br.readLine().trim().split(" ");
            int k = Integer.parseInt(br.readLine().trim());

            DLLNode head = new DLLNode(Integer.parseInt(arr[0]));
            DLLNode tail = head;

            for (int i = 1; i < arr.length; i++) {
                push(tail, Integer.parseInt(arr[i]));
                tail = tail.next;
            }

            Solution obj = new Solution();
            DLLNode sorted_head = obj.sortAKSortedDLL(head, k);
            printList(sorted_head);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Code hereif (head == null) return null;
        
        // Create a priority queue (min-heap)
        PriorityQueue<DLLNode> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);
        
        DLLNode newHead = null, last = null;
        
        // Add the first k+1 elements to the heap
        DLLNode current = head;
        for (int i = 0; current != null && i <= k; i++) {
            minHeap.add(current);
            current = current.next;
        }
        
        // Process the heap and build the sorted list
        while (!minHeap.isEmpty()) {
            // Extract the smallest element from the heap
            DLLNode smallest = minHeap.poll();
            
            // If the newHead is not set, set it to the smallest element
            if (newHead == null) {
                newHead = smallest;
                newHead.prev = null;
                last = newHead;
            } else {
                last.next = smallest;
                smallest.prev = last;
                last = smallest;
            }
            
            // Add the next element from the list to the heap
            if (current != null) {
                minHeap.add(current);
                current = current.next;
            }
        }
        
        // Ensure the last node's next pointer is null
        if (last != null) {
            last.next = null;
        }
        
        return newHead;
    }
}
// File: UseCase8PalindromeCheckerApp.java
public class Palindrome {
    static class Node {
        char data;
        Node next;
        Node(char d) { data = d; }
    }

    public static void main(String[] args) {
        String word = "madam";
        Node head = buildList(word);

        if (isPalindrome(head)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }

    static Node buildList(String str) {
        Node head = new Node(str.charAt(0));
        Node current = head;
        for (int i = 1; i < str.length(); i++) {
            current.next = new Node(str.charAt(i));
            current = current.next;
        }
        return head;
    }

    static boolean isPalindrome(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    static Node reverse(Node head) {
        Node prev = null, current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
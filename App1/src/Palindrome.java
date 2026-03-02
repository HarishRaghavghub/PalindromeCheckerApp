import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Palindrome git h{
    public static void main(String[] args) {
        String word = "madam";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            queue.add(word.charAt(i));   // enqueue
            stack.push(word.charAt(i));  // push
        }

        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            char fromQueue = queue.remove(); // dequeue
            char fromStack = stack.pop();    // pop
            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}
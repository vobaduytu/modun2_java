
import java.util.Arrays;
import java.util.Stack;

public class ReverseStringArr {
    public static void main(String[] args) {
        String word = "toi ten la tu!";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length();i++){
            stack.push(word.charAt(i));
        }
        StringBuilder what = new StringBuilder();
        for (int i = 0; i < word.length();i++){
            what.append(stack.pop());
        }
        System.out.println(what.toString());
    }
}
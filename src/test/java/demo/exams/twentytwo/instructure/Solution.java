package demo.exams.twentytwo.instructure;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        // sample input:
        // 5 3 2 * + 1 -
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String[] RPNs = expression.split(" ");

        Solution solution = new Solution();
        int result = solution.setback(RPNs);
        System.out.println(result);

    }

    private int setback(String[] tokens) {

        Stack<String> stack = new Stack<>();
        int x, y;
        String result = "";
        int get = 0;
        String choice;
        int value = 0;
        String p = "";
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("+") && !tokens[i].equals("-")
                    && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                stack.push(tokens[i]);
                continue;
            } else {
                choice = tokens[i];
            }
            switch (choice) {
                case "+":
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x + y;
                    result = p + value;
                    stack.push(result);
                    break;
                case "-":
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y - x;
                    result = p + value;
                    stack.push(result);
                    break;
                case "*":
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x * y;
                    result = p + value;
                    stack.push(result);
                    break;
                case "/":
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y / x;
                    result = p + value;
                    stack.push(result);
                    break;
                default:
                    continue;
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

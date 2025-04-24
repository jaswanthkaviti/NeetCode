package org.example;

import java.util.Stack;

public class StackIsValidParantheses {
    public static void main(String[] args){
        String s ="([{}])";
        boolean answer = isValid(s);//it checks pallindrome , waste
        System.out.println(answer);
        boolean correctAnswer = correctIsValid(s);
        System.out.println(correctAnswer);
    }

    private static boolean correctIsValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isValid(String s) {
        char[] original = s.toCharArray();
        Stack<Character> originalStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(Character ch : original){
            originalStack.push(ch);
        }
        while (!originalStack.isEmpty()){
            sb.append(originalStack.pop());
        }
        if (!s.contentEquals(sb)) {
            return false;
        }
        return true;
        }
    }

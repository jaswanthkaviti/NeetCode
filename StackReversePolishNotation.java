package org.example;

import java.util.Optional;
import java.util.Stack;

public class StackReversePolishNotation {

    public static void main(String[] args){
        String[] tokens = {"1","2","+","3","*","4","-"};
        int output = reversePolishNotation(tokens);
        System.out.println(output);
    }

    private static int reversePolishNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str:tokens){
            if(str.chars().allMatch(Character::isDigit)|| (str.charAt(0) == '-' && str.length() > 1)){
                stack.push(Integer.parseInt(str));
            }
            else{
                int b = stack.pop();
                int a = stack.pop();

                switch (str) {
                    case "+":
                        stack.push(a + b);
                        break;

                    case "-":
                        stack.push(a - b);
                        break;

                    case "*":
                        stack.push(a * b);
                        break;

                    case "/":
                        stack.push(a / b);
                        break;

                    default:
                        break;
                }
            }
        }

        return stack.pop();
        }
    }


package com.hwp.study.algorithems;

import java.util.Stack;

public class Parentheses {
    private final char LEFT_PARENTHESES = '(';
    private final char RIGHT_PARENTHESES = ')';
    private final char LEFT_BRACKET = '[';
    private final char RIGHT_BRACKET = ']';
    private final char LEFT_BIG_PARENTHESES = '{';
    private final char RIGHT_BIG_PARENTHESES = '}';

    public boolean isBalanced(String strs){
        char[] chars = strs.toCharArray();

        if ((chars.length % 2) != 0){
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '{'){
                stack.push('{');
            }

            if(chars[i] == '['){
                stack.push('[');
            }

            if(chars[i] == '('){
                stack.push('(');
            }

            if(chars[i] == ')'){
                if(stack.isEmpty()){
                    return false;
                }

                if (stack.pop() != '('){
                    return false;
                }
            }

            if(chars[i] == ']'){
                if(stack.isEmpty()){
                    return false;
                }

                if (stack.pop() != '['){
                    return false;
                }
            }

            if(chars[i] == '}'){
                if(stack.isEmpty()){
                    return false;
                }

                if (stack.pop() != '{'){
                    return false;
                }
            }
        }

        return stack.isEmpty();


    }
}

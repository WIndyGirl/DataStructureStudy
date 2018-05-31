package com.hwp.study.algorithems;

import java.util.Stack;

public class TenToBinary {
    public void toBinary(int num){
        Stack<Integer> stack = new Stack<Integer>();

        int tmp = num;
        while(tmp > 0){
            stack.push(tmp % 2);
            tmp = tmp / 2;
        }

        while(! stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args){
        TenToBinary transform = new TenToBinary();

        transform.toBinary(50);
        System.out.println(" ");
        transform.toBinary(128);
    }
}

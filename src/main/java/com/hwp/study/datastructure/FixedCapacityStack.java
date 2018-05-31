package com.hwp.study.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<Item> implements Iterable<Item> {
    private int MAX_SIZE = 50;
    private final Item[] elements;
    private int size = 0;

    public FixedCapacityStack(){
        elements = (Item[])new Object[MAX_SIZE];
    }

    public FixedCapacityStack(int size){
        MAX_SIZE = size;

        elements = (Item[])new Object[MAX_SIZE];
    }

    public Iterator<Item> iterator() {
        return new reverseArrayIterator();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    public Item pop(){
        Item item = elements[--size];
        elements[size] = null;

        return item;
    }

    public void push(Item item){
        elements[size++] = item;
    }

    public Item peek(){
        if (size == 0){
            throw new NoSuchElementException();
        }
        Item item = elements[size - 1];

        return item;
    }

    public class reverseArrayIterator implements Iterator<Item>{
        int N = size;
        public boolean hasNext(){
            return N > 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return elements[--N];
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        FixedCapacityStack<String> stack1 = new FixedCapacityStack<String>(20);

        String[] strs = {"a", "ab", "abc", "abcd", "abcde", "abcedef", "abcdefg"};
        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            stack1.push(str);
        }

        System.out.println(stack1.isEmpty());

        Iterator<String> it = stack1.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

        for(String str: stack1){
            System.out.print(str + " ");
        }

        System.out.println(stack1.isEmpty());
    }
}

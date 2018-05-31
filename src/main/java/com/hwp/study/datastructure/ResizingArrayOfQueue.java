package com.hwp.study.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayOfQueue<Item> implements Iterable<Item>{
    private int MAX_SIZE = 2;
    private int size;
    private int first = 0;
    private int last = 0;
    private Item[] elements;

    public ResizingArrayOfQueue(){
        elements = (Item[]) new Object[MAX_SIZE];
    }

    public ResizingArrayOfQueue(int capacity){
        MAX_SIZE = capacity;
        elements = (Item[]) new Object[MAX_SIZE];
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(Item item){
        if (isFull()){
            reSize(2 * MAX_SIZE);
        }

        elements[last++] = item;
        size++;

        if (last == elements.length){
            last = 0;
        }
    }

    private void reSize(int capacity){

        MAX_SIZE = capacity;
        Item[] newElements = (Item[])new Object[MAX_SIZE];

        for(int i = 0; i < size; i++){
            newElements[i] = elements[(i + first) % elements.length];
        }

        elements = newElements;
        first = 0;
        last = size;
    }

    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue Underflow");
        }

        Item item = elements[first];
        elements[first++] = null;
        size--;

        if (first == elements.length){
            first = 0;
        }

        if (size > 0 && size <= MAX_SIZE / 4){
            reSize(MAX_SIZE / 2);
        }

        return item;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<Item>{
        private int i = 0;
        public boolean hasNext(){
            return i < size;
        }

        public Item next(){
            if (isEmpty()){
                throw new UnsupportedOperationException();
            }

            Item item = elements[(i + first) % elements.length];

            i++;

            return item;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        ResizingArrayOfQueue<String> queue = new ResizingArrayOfQueue<String>();

        String[] strs = {"a", "ab", "abc", "abcd", "abcde", "abcedef", "abcdefg"};
        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            queue.enqueue(str);
        }

        System.out.println(queue.size());

        Iterator<String> it = queue.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

        System.out.println(" ");

        int size = queue.size();
        for(int i = 0; i < 4; i++){
            String str = queue.dequeue();
            System.out.print(str + " ");
        }

        queue.enqueue("abcdefgh");
        queue.enqueue("abcdefghi");

        System.out.println(queue.size());

        it = queue.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}

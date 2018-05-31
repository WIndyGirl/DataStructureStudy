package com.hwp.study.datastructure;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int size = 0;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public Stack(Stack<Item> s){
        if (s == null){
            throw new IllegalArgumentException();
        }

        Iterator<Item> it = s.iterator();

        while(it.hasNext()){
            this.push(it.next());
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }

    public void push(Item item){
        Node<Item> node = new Node<Item>();
        node.item = item;

        if (first == null){
            first = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public Item pop(){
        if (first == null){
            throw new NoSuchElementException();
        }

        Item item = first.item;
        Node<Item> node = first.next;
        first.item = null;
        first.next = null;
        first = node;
        size--;

        return item;
    }

    public Item peek(){
        if (first == null){
            throw new NoSuchElementException();
        }

        return first.item;
    }

    public String toString(){
        StringBuilder strs = new StringBuilder();

        for(Item item: this){
            strs.append(item.toString()).append(" ");
        }

        return strs.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator<Item> implements Iterator<Item>{
        private int freezeSize = size;
        private Node<Item> node;

        public LinkedIterator(Node<Item> first){
            node = first;
        }

        public boolean hasNext(){
            if (freezeSize != size){
                throw new ConcurrentModificationException();
            }

            return node != null;
        }

        public Item next(){
            if (freezeSize != size){
                throw new ConcurrentModificationException();
            }

            if (! hasNext()){
                throw new NoSuchElementException();
            }

            Item item = node.item;
            node = node.next;

            return item;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}

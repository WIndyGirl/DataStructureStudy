package com.hwp.study.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {
    private Node first = null;
    private int size = 0;

    private static class Node<Item>{
        Node<Item> next = null;
        Item item = null;

        Node(Item item){
            item = item;
        }
    }

    public class LinkedListIterator<Item> implements Iterator<Item> {
        private int i = 0;
        private Node<Item> node = first;
        public void remove(){
            throw new UnsupportedOperationException();
        }

        public boolean hasNext(){
            return node != null;
        }

        public Item next(){
            Item item = node.item;
            node = node.next;

            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator<Item>();
    }

    public void add(Item item){
        Node node = new Node(item);

        if (first == null){
            first = node;
        } else {
            Node temp = first;
            while(temp.next != null){
                temp = temp.next;
            }

            temp.next = node;
        }
        size++;
    }

    public void remove(Item item){
        if (first == null){
            throw new NoSuchElementException("List is underflow");
        }

        if (first.item.equals(item)){
            first = first.next;
        }

        Node temp = first.next;
        Node pre = first;
        while(temp != null){
            if (temp.item.equals(item)){
                pre.next = temp.next;
                temp.item = null;
                break;
            } else {
                pre = temp;
                temp = temp.next;
            }
        }

        size--;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}

/*
 Josephus problem. In the Josephus problem from antiquity,
 N people are in dire straits and agree to the following strategy to reduce the population.
 They arrange themselves in a circle (at positions numbered from 0 to N-1) and proceed around the circle,
 eliminating every Mth person until only one person is left.
 Legend has it that Josephus figured out where to sit to avoid being eliminated
 */

package com.hwp.study.algorithems;

import java.util.Iterator;

public class JosephusQueue implements Iterable<Integer> {
    private int size;
    private int deadNum;
    private Node<Integer> first;
    private Node<Integer> last;

    private class Node<Integer>{
        Integer num;
        Node<Integer> next;
    }

    public JosephusQueue(Integer totalNum, int deadNum){
        if (totalNum < 2){
            throw new IllegalArgumentException("totalNum should be larger than 1");
        }

        if (deadNum < 1){
            throw new IllegalArgumentException("deadNum should be larger than 0");
        }

        for(int i = 0; i < totalNum; i++){
            enqueue(i);
        }

        this.deadNum = deadNum;
    }

    public void enqueue(Integer num){
        Node<Integer> node = new Node<Integer>();
        node.num = num;
        node.next = first;

        if (size == 0){
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public Integer dequeue(){
        Integer num = first.num;
        first.num = null;
        first = first.next;
        last.next = first;
        size--;

        return num;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        StringBuilder strs = new StringBuilder();
        Iterator<Integer> it = this.iterator();

        Integer tmp = null;
        while(it.hasNext()){
            tmp = it.next();
            strs.append(tmp).append(" ");
        }

        return strs.toString();
    }

    public Iterator<Integer> iterator(){
        return new LinkedListIterator(first);
    }

    public class LinkedListIterator implements Iterator<Integer>{
        Node<Integer> current;
        int n = 0;

        public LinkedListIterator(Node<Integer> first){
            current = first;
        }

        public boolean hasNext(){
            return current != null && n < size;
        }

        public Integer next(){
            Integer num = current.num;
            current = current.next;
            n++;
            return num;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public void eliminate(){
        Node<Integer> current = first;
        Node<Integer> pre = null;

        int num = 0;
        while(size > 1){
            num++;
            if(num == deadNum) {
                System.out.println(current.num);
                pre.next = current.next;
                current.next = null;
                current = pre.next;

                size--;
                num = 0;
            } else {
                pre = current;
                current = current.next;
            }
        }

        System.out.println(current.num);
    }

    public static void main(String[] args){
        JosephusQueue queue = new JosephusQueue(7, 2);
        System.out.println(queue.toString());
        queue.eliminate();
    }
}

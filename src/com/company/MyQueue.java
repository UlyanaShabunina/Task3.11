package com.company;

public class MyQueue<T> implements Queue<T>, Collection {
    public class Node<T>{

        T value;

        Node<T> next;
        public Node(T val){
            value = val;
        }
    }
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MyQueue(){
        head = null;
        tail = null;
    }
    public int size() {
        return size;
    }

    @Override
    public void add(T o) {
        Node<T> node = new Node(o);
        if(isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public T peek() {
        if(head == null)
            throw new NullPointerException();
        return head.value;
    }

    @Override
    public T poll() throws NullPointerException{
        if(head == null){throw new NullPointerException();}
        Node<T> node = head;
        node.value = head.value;
        head = head.next;
        return node.value;
    }

    private boolean isEmpty(){ return head == null; }

    @Override
    public Iterator getIterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator{

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public Object next() {
            Node<T> node = head;
            head = head.next;
            return node.value;
        }
    }

}


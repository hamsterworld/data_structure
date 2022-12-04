package collections.List.linkedlist;

import java.util.NoSuchElementException;

public class LinkedListImpl<E> {
    static class Node<E>{
        E data;
        Node<E> nextToNode;

        public Node(E data) {
            this.data = data;
        }

        public Node<E> getNextToNode() {
            return nextToNode;
        }

        public void setNextToNode(Node<E> nextToNode) {
            this.nextToNode = nextToNode;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;


    public LinkedListImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<E> search(int index){

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> nextToNode = head;
        for(int i = 0; i<index; i++){
            nextToNode = nextToNode.getNextToNode();
        }

        return nextToNode;
    }

    public void addFirst(E data){

        Node<E> newNode = new Node<>(data);
        newNode.setNextToNode(head);
        head = newNode;
        size++;

        if(head.nextToNode == null){
            head = tail;
        }
    }

    public void addLast(E data){

        Node<E> newNode = new Node<>(data);

        if(size == 0 ){
            addFirst(data);
            return;
        }
        tail.setNextToNode(newNode);
        tail = newNode;
        size++;

    }

    public void add(int index,E data){

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            addFirst(data);
            return;
        }

        if(index == size){
            addLast(data);
            return;
        }

        Node<E> searchNode = search(index);
        Node<E> beforeNode = search(index-1);
        Node<E> newNode = new Node<>(data);
        beforeNode.setNextToNode(newNode);
        newNode.setNextToNode(searchNode);
        size++;

    }

    public void remove(){

        if(head == null){
            throw new NoSuchElementException();
        }

        Node<E> nextToNode = head.nextToNode;
        head = nextToNode;

        size--;

        if(size == 0){
            tail = null;
        }

    }

    public void remove(int index){

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            remove();
            return;
        }

        if(index == size){
            Node<E> beforeSearch = search(index-1);
            beforeSearch.setNextToNode(null);
            tail = beforeSearch;
            size--;
            return;
        }

        Node<E> afterSearch = search(index+1);
        Node<E> beforeSearch = search(index-1);
        beforeSearch.setNextToNode(afterSearch);
        size--;

    }

    public static void main(String[] args) {

    }
}

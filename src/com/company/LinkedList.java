package com.company;

public class LinkedList<E> {

    //Properties
    Node head;
    int count;

    //Constructors
    public LinkedList(){
        head = null;
        count = 0;
    }

    public LinkedList(Node newHead){
        head = newHead;
        count+=1;
    }

    public static void inOrder(java.util.LinkedList<String> linkedList) {

    }

    //Methods
        //add
        public void add(String newData){
            Node temp = new Node(newData);
            if(head == null){
                head = temp;
                count = 1;
                return;
            }
            Node current = head;

            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(temp);
            count++;
        }

    public void add(int index, String newData) {
        Node temp = new Node(newData);
        if (head == null) {
            head = temp;
            count = 1;
            return;
        }
        Node current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        count++;
    }

        //display
        public void displayList(){
            System.out.println("Linked List: ");

            Node current = head;

            while(current != null){
                System.out.println(current.data + " ");

                current = current.next;
            }
            System.out.println();
        }

        //get
        public String get(int index) {
            if (index <= 0){
                return null;
            }
            Node current = head;
            for(int i = 1; i<index; i++){
                current = current.getNext();
            }
            return current.getString();
        }

        //size
        public int size(){
            return count;
        }

        //isEmpty
        public boolean isEmpty(){
            return head == null;
        }

        //empty
        public void remove(){
            //Remove from the back of the list
            Node current = head;
            while(current.getNext().getNext() != null){
                current = current.getNext();
            }
            current.setNext(null);
            count--;
        }

    public String getByIndex(int index) {
        if (index < 0) {
            return null;
            }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getString();
    }
}

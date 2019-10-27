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

        //Sorted Merge
        /*public Node sortedMerge(Node a, Node b){
            Node result = null;
            //Base cases
            if(a == null){
                return b;
            }
            if(b == null){
                return a;
            }

            //Pick either b or a and recurring
            if(a.data <= b.data){
                result = a;
                result.next = sortedMerge(a.next, b);
            }
            else{
                result = b;
                result.next = sortedMerge(a, b.next);
            }
            return result;
        }

        //Merge Sort
        public Node mergeSort(Node h){
        //Base case: if head is null
            if(h == null || h.next == null){
                return h;
            }

            Node middle = getMiddle(h);
            Node nextOfMiddle = middle.next;

            middle.next = null;

            Node left = mergeSort(h);

            Node right = mergeSort(nextOfMiddle);

            Node sortedList = sortedMerge(left, right);
            return sortedList;
        }

        public static Node getMiddle(Node head){
            if(head == null){
                return head;
            }
            Node slow = head;
            Node fast = head;

            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }*/

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

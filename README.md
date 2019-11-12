# PairProgramming
> This project is brought to you by Marlene Lantz and Ignacio Gonzalez

## Table of Contents:
 1) The Requisites
 2) How the Code Works
  2.1) Binary Tree Method
   2.1.1) Node Class
   2.1.2) Binary Tree Class
   2.1.3) Main Class
  2.2) LinkedList Method
   2.2.1) Node Class
   2.2.2) LinkedList Class
   2.2.3) Main Class
 3) Testing *please consult README file in Repository named BinaryTreeTest: https://github.com/lantzmarlene/BinaryTreeTest*
 4) Coding Principles *please consult README file in Repository named BinaryTreePrinciples: *

## 1) The Requisites:

> "You have to create in pairs a JAVA project to manage a dictionary built using Linked lists"

1. The application will be able to open a file called “unsorteddict.txt”
2. This file will be a collection of words where each line contains a word
3. The application will read the file line by line, in other words, it will read a new word each time a new line is read
  ** Each time a new line is read, the new word will be inserted in the correct position of a data structure called “dictionary” that will be of a Linked list type
  ** Therefore , this “dictionary” will be a sorted list of all the words read from the file
4. After the “unsorteddict.txt” has been fully read, the application will create another file called “sorteddict.txt” which will contain all the words (one word per line) alphabetically ordered
5. The application will also accept command line arguments, i.e. it could be executed as java LinkDictionary 23 butterfly
  ** The application will accept a minimum of 0 arguments and a maximum of 10 arguments
  ** If the argument is a number, the corresponding word placed in that position in the ordered linked list “dictionary” should be printed out on the console
  ** If the argument is a word, the application should print out in the console the number that represent the order of that word inside the dictionary. If it doesn’t exist, it should write “-1”.
 
## 2) How the Code Works:

Our code is comprised of three classes in both the faster and the normal method. In this document, we will explain the faster method as it works better and is more efficient. Later on in this document, we will explain the LinkedList method of sorting through the documents and how it works. 

#### 2.1) BinaryTree Method --

Essentially, a Main class (where the actual programme is run), a Node class and a Binary Tree class was created.

##### 2.1.1) Node Class:
To start let's take a look at our Node class:

    package com.company;
    // TreeNode: simple node in a binary search tree

    public class Node {
        public String data;  // data at each node
        public Node left, right; //Node to the left of and right of current node

    public Node(String word) { // Construction of a node
            data = word;
            left = right = null;
        }

        //Getter methods
        public String getString(){
            return data;
        }

        public Node getLeft(){
            return left;
        }

        public Node getRight(){
            return right;
        }

}

In the above code, we are simply establishing the functionality of the Node for implementation and use within the BinaryTree class itself. 

We start by setting up our properties:

    public class Node {
        public String data;  // data at each node
        public Node left, right; //Node to the left of and right of current node

Here we are simply stating that a Node will have properties like a String called data and then we set up two Nodes. This is so that we have a pointer to the left of our current node and a pointer to the right of our current node. This will help us later on when we wish to sort our data fast. 

Next we create a constructor: 

    public Node(String word) { // Construction of a node
            data = word;
            left = right = null;
        }

Here we tell Java that when a Node object is used, a String should be passed as an argument, and that this creation will null values for the left and right node. 

Lastly as a good practice we set up getter methods, although our variables are public and not private. In hindsight, it would have been better to make our variables private so that they can only be altered or gotten through these getter methods. We should have also created setter methods as well. 


    //Getter methods
        public String getString(){
            return data;
        }

        public Node getLeft(){
            return left;
        }

        public Node getRight(){
            return right;
        }


##### 2.1.2) BinaryTree Class:

    package com.company;

    import java.io.*;

    public class BinaryTree {

    // Tree: simplest possible binary search tree
    private Node root; // hidden root node

    // insert: if new entry, insert in tree
    public void insert(String word) {
        if (root == null) { // must handle case of empty tree first
            root = new Node(word);
            return;
        }
        Node loc = root; // start search downward at root
        while (true) {
            if (word.compareToIgnoreCase(loc.data) < 0) { // look left
                if (loc.left != null) loc = loc.left;
                else { loc.left = new Node(word); break; }
            }
            else if (word.compareToIgnoreCase(loc.data) > 0) { // look right
                if (loc.right != null) loc = loc.right;
                else { loc.right = new Node(word); break; }
            }
            else break; // found! Don't insert
        }
    }

    // inorderTraversal: need because root is hidden
    public void inorderTraversal(PrintWriter writer) {
        inorderT(root, writer);
    }

    // inorderT: recursive function that does the work
    private void inorderT(Node node, PrintWriter writer) {
        if (node != null) {
            inorderT(node.left, writer);
            System.out.println(node.data+" ");
            writer.println(node.data);
            inorderT(node.right, writer);
        }
    }

    //size: because root is hidden
    public int size()
    {
        return size(root);
    }

    //gets the size of the Binary Tree
    public int size(Node node)
    {
        if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
    }

    }

This Binary Tree class has some methods to help to put the list in order. An object of the BinaryTree class will then be created and the proper methods called to help to put the dictionary into proper order. 

I will explain the most important method here:

    // inorderT: recursive function that does the work
    private void inorderT(Node node, PrintWriter writer) {
        if (node != null) {
            inorderT(node.left, writer);
            System.out.println(node.data+" ");
            writer.println(node.data);
            inorderT(node.right, writer);
        }
    }

This method is what actually allows the content you choose to be sorted. Essentially what it is doing is it is visiting the left "tree" and calling the inOrterT method, it then visits the root Node and then does the same to the right "tree" by calling the inOrderT method. It is essentially a recursive function. 

##### 2.1.3) Main Class:

    package com.company;

    import java.io.*;
    import java.util.LinkedList;
    import java.util.Scanner;

    public class Main {

    private static Scanner scan;

    public static void readFile() throws FileNotFoundException {
        File file = new File("Resources\\unsorteddict.txt");
        scan = new Scanner(file);
    }

    public static void linkedDictionaryCreatorInputer() throws FileNotFoundException, UnsupportedEncodingException {
        //Creation of linked list and line variable
        String fileContents = "";
        LinkedList<String> linkedList = new LinkedList<>();
        BinaryTree tree = new BinaryTree();

        while(scan.hasNextLine()){
            fileContents = scan.nextLine();
            if (linkedList.size() == 0) {
                linkedList.add(0, fileContents);
            }
            else {
                for (int i = 0; i < linkedList.size(); i++) {
                    tree.insert(fileContents);
                }
            }
        }
        PrintWriter writer = new PrintWriter("Resources\\sorteddict.txt", "UTF-8");
        tree.inorderTraversal(writer); //Calls method and writes to a file

    }
    public static void main(String ... args) throws IOException {
        readFile();
        linkedDictionaryCreatorInputer();


    }
    }

Here two methods were created within the Main class and then implemented within the main method so as to let the code run and process the data. 

    public static void readFile() throws FileNotFoundException {
    File file = new File("Resources\\unsorteddict.txt");
        scan = new Scanner(file);
    }

Here we are gaining access, locating and reading from the file that contains the data we wish to process.

    public static void linkedDictionaryCreatorInputer() throws FileNotFoundException, UnsupportedEncodingException {
        //Creation of linked list and line variable
        String fileContents = "";
        LinkedList<String> linkedList = new LinkedList<>();
        BinaryTree tree = new BinaryTree();

        while(scan.hasNextLine()){
            fileContents = scan.nextLine();
            if (linkedList.size() == 0) {
                linkedList.add(0, fileContents);
            }
            else {
                for (int i = 0; i < linkedList.size(); i++) {
                    tree.insert(fileContents);
                }
            }
        }
        PrintWriter writer = new PrintWriter("Resources\\sorteddict.txt", "UTF-8");
        tree.inorderTraversal(writer); //Calls method and writes to a file

    }

In this method we are doing several things. First we are creating a String value called fileContents and setting it equal to nothing. Then we are actually creating our LinkedList object and then our BinaryTree object. We then establish a while loop and here we are telling Java that while there is a nextLine within the file we are reading to execute the following code. We are then setting our empty variable of fileContents to the line within the file and we add that element to the our LinkedList. This is only if there is no other content in the LinkedList, however if there is content in the LinkedList then we insert our fileContents into our Binary tree. Lastly we want to output what we have essentially inserted into our Tree to another file. At this stage our two files are the same until the next method (tree.inorderTraversal) is called. Here is where we actually start sorting our output and this method takes a parameter to determine where it should output the content, in this case it is within our PrintWriter object where it will store the content in a file we create called sorteddict.txt.

#### 2.2) LinkedList Method --
Again, a Main class (where the actual programme is run), and Node class and a LinkedList class was created. We understand that Java has its own LinkedList object that could be used, however we wanted to add additional functionality to our LinkedList object as well as gain a fundamental understanding of how LinkedLists actually work. For this reason we decided it would be better to code it from scratch.

##### 2.2.1) Node Class:

    package com.company;

    import java.io.File;

        public class Node {
        
        // Properties
         Node next;
         String data;
         int i;

       //Constructors
        public Node(String newData) {
            data = newData;
            next = null;
        }

        public Node(int newData) {
            i = newData;
            next = null;
        }

        public Node(String newData, Node newNext) {
            data = newData;
            next = newNext;
        }

        public Node(int newData, Node newNext) {
            i = newData;
            next = newNext;
        }


       //Getters and Setters
        public String getString() {
            return data;
        }

        public void setString(String newData) {
            data = newData;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node newNode) {
            next = newNode;
        }

        public int getData() {
            return i;
        }

        public void setData(int newData) {
            i = newData;
        }
    }
 
Again, in the above code, we are simply establishing the functionality of the Node for implementation and use within the LinkedList class itself. 

We start by setting up our properties:
   
     public class Node {    
        // Properties
         Node next;
         String data;
         int i;

Again, we are stating what properties a Node holds, that is it can either hold an int or String which will be our data, and it will also hold a Node that points to the next Node within the LinkedList. This will be touched upon later on.

Next we create a constructor: 
    
    //Constructors
        public Node(String newData) {
            data = newData;
            next = null;
        }

        public Node(int newData) {
            i = newData;
            next = null;
        }

        public Node(String newData, Node newNext) {
            data = newData;
            next = newNext;
        }

        public Node(int newData, Node newNext) {
            i = newData;
            next = newNext;
        }

Here we add multiple constructors to allow flexibility of what kind of data and what types of ways the Node can be used within our LinkedList class. 

Again, as a good practice we set up our getter and setter methods so that we may later or gather the data pertaining to our nodes. Like in the BinaryTree Node, we did not set our variables to private so in reality we did not actually need these methods. Again, in hindsight we should have made the variables private. 

    //Getters and Setters
        public String getString() {
            return data;
        }

        public void setString(String newData) {
            data = newData;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node newNode) {
            next = newNode;
        }

        public int getData() {
            return i;
        }

        public void setData(int newData) {
            i = newData;
        }
    }



##### 2.2.2) LinkedList Class:
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


##### 2.2.3) Main Class:
package com.company;

    import java.io.*;
    import java.util.LinkedList;
    import java.util.Scanner;

    public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Starting");
        File file = new File("C:\\Users\\Marlene\\Workspace\\LinkedDict\\src\\com\\company\\testInput.txt");
        Scanner scan = new Scanner(file);

        //Creation of linked list and line variable
        String fileContents = "";
        LinkedList<String> linkedList = new LinkedList<>();
        int lineNum = 0;

        //Writing contents into a file
        FileWriter writer = new FileWriter("C:\\Users\\Marlene\\Workspace\\LinkedDict\\src\\com\\company\\testOutput.txt");

        while(scan.hasNextLine()){
            fileContents = scan.nextLine();
            lineNum++;
            int x = 0;
            if (linkedList.size() == 0) {
                linkedList.add(0, fileContents);
            } else
                for (x = 0; x < linkedList.size(); x++) {
                    if (linkedList.get(x).compareToIgnoreCase(fileContents) > 0) {
                        linkedList.add(x, fileContents);
                        break;
                    }
                }
            if (x == linkedList.size()) {
                linkedList.add(fileContents);
            }
            System.out.println(lineNum);

        }

        for (int i = 0; i < linkedList.size(); i++) {

            System.out.println(linkedList.get(i));
            writer.write(linkedList.get(i) + "\n");
        }

        //Close Writer
        writer.close();

        System.out.println("Ended");
        
          //Get arguments from user... at least I tried... :(
        if(args.length == 0){
            System.out.println("No arguments given");
        }
        else{
            for(int z = 0; z<10; z++){
                System.out.println("Your arguments were: "+args[z]);
                int x = Integer.parseInt(args[z]);
                if(x == z){
                    String a = linkedList.get(z);
                    System.out.println(z);
                }
            }
        }
      }
    }

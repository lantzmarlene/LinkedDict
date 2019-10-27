package com.company;

import java.io.File;

public class Node {
    //Properties
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


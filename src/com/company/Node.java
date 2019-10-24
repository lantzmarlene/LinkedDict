package com.company;

import java.io.File;

public class Node {
    //Properties
    Node next;
    int data;
    String str;

    //Constructors
    public Node(String newData){
        str = newData;
        next = null;
    }

    public Node(int newData, Node newNext){
        data = newData;
        next = newNext;
    }

    public Node(String newData, Node newNext) {
        str = newData;
        next = newNext;
    }


    //Getters and Setters

    public int getData(){
        return data;
    }

    public Node getNext(){
        return next;
    }

    public String getStr(){
        return str;
    }

    public void setStr(String newData){
        str = newData;
    }

    public void setData(int newData){
        data = newData;
    }

    public void setNext(Node newNode){
        next = newNode;
    }


}

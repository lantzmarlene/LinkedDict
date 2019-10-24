package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //Access the contents of a file
        File file = new File("C:\\Users\\Marlene\\Workspace\\LinkedDict\\src\\com\\company\\unsorteddict.txt");
        Scanner scan = new Scanner(file);

        //Creation of linked list and line variable
        String fileContents = "";
        LinkedList<String> linkedList = new LinkedList<>();
        int lineNum = 0;

        //Writing contents into a file
        FileWriter writer = new FileWriter("C:\\Users\\Marlene\\Workspace\\LinkedDict\\src\\com\\company\\sorteddict.txt");

        while(scan.hasNextLine()){
            fileContents = scan.nextLine();
            linkedList.add(fileContents);
            linkedList.head = linkedList.mergeSort(linkedList.head);
            lineNum++;
        }

        //Close Writer
        writer.write(linkedList.toString());
        writer.close();
    }
}

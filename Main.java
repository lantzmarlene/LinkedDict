package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //Access the contents of a file
        File file = new File("C:\\Users\\Marlene\\Workspace\\IHATELIFE\\src\\com\\company\\testInput.txt");
        Scanner scan = new Scanner(file);

        //Creation of Linked list and Line Variable
        String fileContents = "";
        LinkedList linkedList = new LinkedList();
        int lineNum = 0;

        //Writing contents into a file
        FileWriter writer = new FileWriter("C:\\Users\\Marlene\\Workspace\\IHATELIFE\\src\\com\\company\\testOutput.txt");

        while(scan.hasNext()){
            fileContents = scan.nextLine();
            linkedList.add(fileContents);
            lineNum++;
        }

        for(int i = 0; i<lineNum; i++){
            if(fileContents.compareTo(linkedList.getByIndex(i))>0){
                linkedList.add(i, fileContents);
            }
        }

        linkedList.displayList();
        System.out.println(lineNum);

    }
}

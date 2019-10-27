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

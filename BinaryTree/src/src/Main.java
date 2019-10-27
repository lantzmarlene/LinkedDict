package src;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import src.Node;
import src.BinaryTree;

public class Main {

    public static void main(String ... args) throws IOException {

        System.out.println("Starting");
        File file = new File("C:\\Users\\Marlene\\Workspace\\LinkedDict\\BinaryTree\\src\\src\\unsorteddict.txt");
        Scanner scan = new Scanner(file);

        //Creation of linked list and line variable
        String fileContents = "";
        LinkedList<String> linkedList = new LinkedList<>();
        BinaryTree tree = new BinaryTree();
        int lineNum = 0;

        //Writing contents into a file
        PrintWriter writer = new PrintWriter("C:\\Users\\Marlene\\Workspace\\LinkedDict\\BinaryTree\\src\\src\\sorteddict.txt", "UTF-8");

        while(scan.hasNextLine()){
            fileContents = scan.nextLine();
            lineNum++;
            int x = 0;
            if (linkedList.size() == 0) {
                linkedList.add(0, fileContents);
            }
            else {
                for (int i = 0; i < linkedList.size(); i++) {
                    tree.insert(fileContents);
                }
            }
        }

        tree.inorderTraversal(writer); //Calls method and writes to a file

        System.out.println("Ended");

       /* for(int z = 0; z<args.length; z++){
            System.out.println(args[z]);

            if(args[1].equals(z)){
                linkedList.get(z);
            }
        }*/
    }
}

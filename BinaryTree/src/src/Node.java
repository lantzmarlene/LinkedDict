package src;

import java.io.BufferedWriter;

public class Node {
    // TreeNode: simple node in a binary search tree
    public String data;  // data at each node
    public Node left, right;

    public Node(String word) { // construct leaf node
        data = word;
        left = right = null;
    }

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



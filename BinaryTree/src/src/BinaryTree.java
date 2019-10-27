package src;

import java.io.*;
import src.Node;

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
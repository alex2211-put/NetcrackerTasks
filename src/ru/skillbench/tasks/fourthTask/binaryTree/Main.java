package ru.skillbench.tasks.fourthTask.binaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(2);
        tree.add(5);
        tree.add(1);
        System.out.println(tree.height(tree.getRoot()));
        System.out.println(tree.containsNode(5));
        System.out.println(tree.containsNode(0));
        tree.delete(5);
        System.out.println(tree.containsNode(5));
        tree.add(5);
        tree.add(10);
        tree.add(-1);
        tree.inOrder(tree.getRoot()); System.out.println();
        tree.preOrder(tree.getRoot()); System.out.println();
        tree.postOrder(tree.getRoot()); System.out.println();
    }
}

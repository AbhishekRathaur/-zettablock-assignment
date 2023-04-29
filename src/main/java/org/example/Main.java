package org.example;

import org.example.command.Command;
import org.example.ds.TreeNode;
import org.example.ds.Trie;
import org.example.factory.CommandFactory;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("output.txt");
        file.delete();
        TreeNode treeNode = new TreeNode("root", "root");
        Trie trie = new Trie(treeNode);
        CommandFactory commandFactory = new CommandFactory(trie);

        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                Command command = commandFactory.getCommand(line);
                command.execute();
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}

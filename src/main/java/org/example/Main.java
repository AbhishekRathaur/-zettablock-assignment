package org.example;

import org.example.command.Command;
import org.example.ds.TreeNode;
import org.example.factory.CommandFactory;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandFactory commandFactory = new CommandFactory();

        TreeNode treeNode = new TreeNode("");
        try {
            File myObj = new File("filename.txt");
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

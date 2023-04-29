package org.example.factory;


import org.example.command.*;
import org.example.ds.TreeNode;
import org.example.ds.Trie;
import org.example.exception.NotValidCommandException;

import java.io.IOException;

public class CommandFactory {
    Trie trie ;
    public CommandFactory(Trie trie){
        this.trie = trie;
    }
    public Command getCommand(String line) throws NotValidCommandException, IOException {
           if(line.isBlank())
               throw new NotValidCommandException("line is empty");
           String commands[] = line.split("\\s+");
           if(commands[0].equals("dir")){
               return new DirectoryCommand(trie);
           }
           else if(commands[0].equals("up")){
               return new UpCommand(trie);
           }
           else if(commands.length==2){
               if(commands[0].equals("cd")){
                   return new CDCommand(trie , commands[1]);
               }
               else if(commands[0].equals("mkdir")){
                   return new MkDirCommand(trie, commands[1]);
               }
           }
           else{
               throw  new NotValidCommandException("Invalid line");
           }
           return new InvalidCommand();
    }
}

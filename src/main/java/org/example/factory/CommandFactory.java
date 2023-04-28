package org.example.factory;


import org.example.command.*;
import org.example.ds.TreeNode;

public class CommandFactory {
    TreeNode curr ;
    public Command getCommand(String line) throws NotValidCommandException{
           if(line.isBlank())
               throw new NotValidCommandException("line is empty");
           String commands[] = line.split(" ");
           if(commands[0].equals("dir")){
               return new DirectoryCommand(curr);
           }
           else if(commands[0].equals("up")){
               return new UpCommand(curr);
           }
           else if(commands.length==2){
               if(commands[0].equals("cd")){
                   return new CDCommand(curr , commands[1]);
               }
               else if(commands[0].equals("mkdir")){
                   return new MkDirCommand(curr, commands[1]);
               }
           }
           else{
               throw  new NotValidCommandException("Invalid line");
           }
           return new InvalidCommand();
    }
}

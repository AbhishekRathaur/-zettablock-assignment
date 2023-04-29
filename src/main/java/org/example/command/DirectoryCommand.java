package org.example.command;


import org.example.ds.Trie;
import org.example.logging.FileLogger;

import java.io.IOException;
import java.util.Set;

public class DirectoryCommand extends FileLogger implements Command {

    Trie trie ;
    public DirectoryCommand(Trie trie) throws IOException {
        super();
        this.trie = trie;
    }

    @Override
    public void execute() {
        log("Command: dir");
        log("Directory of "+ trie.getCurrent().getCurrentPath()+":");
        Set<String> children = trie.getCurrent().getChildren();
        if(children.size()==0)
            log("No subdirectories");
        else{
//            Iterator itr = hs.iterator();
//
//            // check element is present or not. if not loop will
//            // break.
//            while (itr.hasNext()) {
//                System.out.println(itr.next());
//            }
            // will format this later according to output
            log(children.toString());
        }
    }
}

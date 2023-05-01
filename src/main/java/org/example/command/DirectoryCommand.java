package org.example.command;


import org.example.ds.Trie;
import org.example.logging.FileLogger;

import java.io.IOException;
import java.util.*;

public class DirectoryCommand extends FileLogger implements Command {

    Trie trie ;
    public DirectoryCommand(Trie trie) throws IOException {
        super();
        this.trie = trie;
    }

    @Override
    public void execute() {
        log("Command: dir");
        log("Directory of "+ trie.getCurrent().getFullPath()+":");
        List<String> children = new ArrayList<>(trie.getCurrent().getChildrenKeys());
        Collections.sort(children);
        if(children.size()==0)
            log("No subdirectories");
        else{
            Iterator itr = children.iterator();

            StringBuilder result = new StringBuilder();
            while (itr.hasNext()) {
                result.append(itr.next()+ "   ");
            }
            log(result.toString());
        }
        close();

    }
}

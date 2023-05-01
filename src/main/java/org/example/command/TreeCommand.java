package org.example.command;

import org.example.command.Command;
import org.example.ds.Trie;
import org.example.logging.FileLogger;

import java.io.IOException;
import java.util.List;

public class TreeCommand extends FileLogger implements Command {

    private Trie trie;
    public TreeCommand(Trie trie) throws IOException {
        super();
        this.trie = trie ;
    }
    @Override
    public void execute() {
        log("Command: tree");
        log("Tree of "+trie.getCurrent().getFullPath());
        try{
            List<StringBuilder> trieTreeStructure= trie.getTreeStructure();
            for (StringBuilder sb: trieTreeStructure
                 ) {
                log(sb.toString());
            }
        }catch (Exception Ex){

        }
        close();
    }
}

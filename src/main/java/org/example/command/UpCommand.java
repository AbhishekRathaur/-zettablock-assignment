package org.example.command;

import org.example.ds.TreeNode;
import org.example.ds.Trie;
import org.example.logging.FileLogger;

import java.io.IOException;

public class UpCommand extends FileLogger implements Command {
    private Trie trie;
    public UpCommand(Trie trie) throws IOException {
        super();
        this.trie = trie ;
    }

    @Override
    public void execute() {
        TreeNode parent = trie.getCurrent().getParent();
        log("Command: up");
        if(parent==null)
            log("Cannot move up from root directory");
        else{
            trie.moveUp();
        }
    }
}

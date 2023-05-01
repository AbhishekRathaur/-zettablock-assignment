package org.example.command;

import org.example.ds.Trie;
import org.example.logging.FileLogger;

import java.io.IOException;
import java.util.Set;

public class MkDirCommand extends FileLogger implements Command {
    private final Trie trie;
    private final String command;

    public MkDirCommand(Trie trie, String command) throws IOException {
        super();
        this.trie = trie ;
        this.command = command;
    }

    @Override
    public void execute() {
        log("Command: mkdir "+command);
        Set<String> children = trie.getCurrent().getChildrenKeys();
        if(children.size()!=0 && children.contains(command))
            log("Subdirectory already exists");
        else{
            trie.addChildren(command);
        }
        close();

    }
}

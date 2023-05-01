package org.example.command;

import org.example.ds.Trie;
import org.example.logging.FileLogger;

import java.io.IOException;
import java.util.Set;

public class CDCommand extends FileLogger implements Command {
    private final String command;
    private final Trie trie;
    public CDCommand(Trie trie, String command) throws IOException {
        super();
        this.trie = trie ;
        this.command = command;
    }

    @Override
    public void execute() {
        log("Command: cd "+command);
        Set<String> children = trie.getCurrent().getChildrenKeys();
        if(children.size()==0 || !children.contains(command))
            log("Subdirectory does not exist");
        else{
            trie.moveDir(command);
        }
        close();
    }
}

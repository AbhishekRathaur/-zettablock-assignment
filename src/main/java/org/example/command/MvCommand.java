package org.example.command;

import org.example.ds.TreeNode;
import org.example.ds.Trie;
import org.example.exception.DirAllReadyPresentException;
import org.example.logging.FileLogger;

import java.io.IOException;
import java.util.Map;

public class MvCommand extends FileLogger implements Command{
    private final Trie trie;
    private final String srcDir;
    private final String desDir;

    public MvCommand(Trie trie, String srcDir, String desDir) throws IOException {
        super();
        this.trie = trie;
        this.srcDir = srcDir;
        this.desDir = desDir ;
    }

    @Override
    public void execute() {
        log("Command: mv "+srcDir+" "+desDir);
          try{
//              Map<String, TreeNode> srcNodes = trie.getSourceDir(srcDir);
              trie.mvsrcToDesDir(srcDir , desDir);
          }catch (DirAllReadyPresentException Ex){
              log("Subdirectory already exists");

          }catch (Exception Ex){

          }
        close();
    }
}

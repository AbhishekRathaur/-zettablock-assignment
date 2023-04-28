package org.example.ds;

import java.util.Map;

public class TreeNode {
    TreeNode parent ;
    Map<String, TreeNode> children ;
    String currentPath ;
    String totalPath ;
    public TreeNode(String currentPath){
        this.currentPath = currentPath;
    }
}

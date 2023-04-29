package org.example.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TreeNode {
    private  TreeNode parent ;
    Map<String, TreeNode> children ;
    private final String currentPath ;
    private final String totalPath ;
    public TreeNode(String currentPath, String totalPath){
        this.currentPath = currentPath;
        this.totalPath = totalPath;
        this.children = new HashMap<>();
    }

    public String getCurrentPath(){
        return currentPath;
    }

    public Set<String> getChildren() {
        return children.keySet();
    }

    public void addChildren(TreeNode treeNode) {
        children.put(treeNode.getCurrentPath(), treeNode);
    }

    public void setParent(TreeNode curr) {
        this.parent = curr;
    }

    public TreeNode getParent() {
        return this.parent ;
    }

    public String getFullPath() {
        return this.totalPath ;
    }
}

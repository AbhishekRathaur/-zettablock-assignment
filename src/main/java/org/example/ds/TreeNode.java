package org.example.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TreeNode {
    private  TreeNode parent ;
    private Map<String, TreeNode> children ;
    private final String currentPath ;

    private String fullPath;
    public TreeNode(String currentPath, String totalPath){
        this.currentPath = currentPath;
        this.fullPath = totalPath;
        this.children = new HashMap<>();
    }

    public String getCurrentPath(){
        return currentPath;
    }

    public Set<String> getChildrenKeys() {
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
        return this.fullPath;
    }

    public void setChildren(Map<String, TreeNode> children) {
        this.children = children;
    }

    public Map<String, TreeNode> getChildren() {
        return this.children ;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }
}

package org.example.ds;


public class Trie {
    TreeNode root ;
    TreeNode curr;
    public Trie(TreeNode treeNode){
        this.root = treeNode;
        this.curr = treeNode ;
    }

    TreeNode getRoot(){
        return this.root;
    }

    public TreeNode getCurrent() {
        return curr;
    }

    public void moveDir(String command) {
        if(curr.children.containsKey(command)){
            curr = curr.children.get(command);
        }
    }

    public void addChildren(String path) {
        TreeNode treeNode = new TreeNode(path, this.curr.getFullPath()+ "\\"+ path);
        curr.addChildren(treeNode);
        treeNode.setParent(curr);
    }

    public void moveUp() {
        curr = curr.getParent();
    }
}

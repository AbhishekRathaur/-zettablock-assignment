package org.example.ds;


import org.example.exception.DirAllReadyPresentException;
import org.example.exception.DirNotFoundException;

import java.util.*;

public class Trie {
    TreeNode root;
    TreeNode curr;

    public Trie(TreeNode treeNode) {
        this.root = treeNode;
        this.curr = treeNode;
    }

    TreeNode getRoot() {
        return this.root;
    }

    public TreeNode getCurrent() {
        return curr;
    }

    public void moveDir(String command) {
        if (curr.getChildren().containsKey(command)) {
            curr = curr.getChildren().get(command);
        }
    }

    public void addChildren(String path) {
        TreeNode treeNode = new TreeNode(path, this.curr.getFullPath() + "\\" + path);
        curr.addChildren(treeNode);
        treeNode.setParent(curr);
    }

    public void moveUp() {
        curr = curr.getParent();
    }

    public Map<String, TreeNode> getSourceDir(String srcDir) throws Exception {
//        String[] subDir = srcDir.split("/");
//        TreeNode tmp = curr;
//        for (int i = 0 ; tmp!=null && i < subDir.length ; i++
//             ) {
//            String currDir = subDir[i];
//            if(tmp.getChildrenKeys().contains(currDir))
//                tmp =tmp.getChildren().get(currDir);
//        }
        // currently source dir is not relative
        if (curr == null)
            throw new DirNotFoundException();
        else {

            Map<String, TreeNode> children = curr.getChildren();
            curr.setChildren(new HashMap<>());
            return children;
        }
    }

    public void mvsrcToDesDir(String srcDir, String desDir) throws Exception {
        String[] subDir = desDir.split("\\\\");
        TreeNode tmp = curr;
        boolean rootDir = false;
        for (int i = 0; tmp != null && i < subDir.length-1; i++) {
            String currDir = subDir[i];
            if (currDir.equals("..")) {
                tmp = tmp.getParent();
                tmp = tmp.getChildren().get(subDir[i+1]);
                i++;
                rootDir = true ;
            } else if (!currDir.equals(".")) {
                    tmp = tmp.getChildren().get(currDir);
                    rootDir = false ;
            }
        }
        if (tmp == null)
            throw new DirAllReadyPresentException();
        else {
            TreeNode srcNode = curr.getChildren().get(srcDir);
            curr.getChildren().remove(srcDir);
                if(tmp.getChildren().containsKey(desDir)){
                    throw  new DirAllReadyPresentException();
                }
                else {

                    if(rootDir) {
                        TreeNode destNode = new TreeNode(srcDir, tmp.getFullPath() + "\\" + srcDir);
                        destNode.setChildren(srcNode.getChildren());
                        destNode.setParent(tmp);
                        tmp.getChildren().put(srcDir, destNode);
                    }
                    else {
                        TreeNode destNode = new TreeNode(subDir[subDir.length - 1], tmp.getFullPath() + "\\" + subDir[subDir.length - 1]);
                        destNode.setChildren(srcNode.getChildren());
                        destNode.setParent(tmp);
                        tmp.getChildren().put(subDir[subDir.length - 1], destNode);
                    }
                }
        }
    }

    public List<StringBuilder> getTreeStructure() {
        return renderDirectoryTreeLines(curr);
    }

    public  List<StringBuilder> renderDirectoryTreeLines(TreeNode tree) {
        List<StringBuilder> result = new LinkedList<>();
        result.add(new StringBuilder().append(tree.getCurrentPath()));
        Iterator<String> iterator = tree.getChildrenKeys().iterator();
        while (iterator.hasNext()) {
            List<StringBuilder> subtree = renderDirectoryTreeLines(tree.getChildren().get(iterator.next()));
            if (iterator.hasNext()) {
                addSubtree(result, subtree);
            } else {
                addLastSubtree(result, subtree);
            }
        }
        return result;
    }

    private static void addSubtree(List<StringBuilder> result, List<StringBuilder> subtree) {
        Iterator<StringBuilder> iterator = subtree.iterator();
        //subtree generated by renderDirectoryTreeLines has at least one line which is tree.getData()
        result.add(iterator.next().insert(0, "├── "));
        while (iterator.hasNext()) {
            result.add(iterator.next().insert(0, "│   "));
        }
    }

    private static void addLastSubtree(List<StringBuilder> result, List<StringBuilder> subtree) {
        Iterator<StringBuilder> iterator = subtree.iterator();
        //subtree generated by renderDirectoryTreeLines has at least one line which is tree.getData()
        result.add(iterator.next().insert(0, "└── "));
        while (iterator.hasNext()) {
            result.add(iterator.next().insert(0, "    "));
        }
    }
}

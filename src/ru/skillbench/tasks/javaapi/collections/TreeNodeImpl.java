package ru.skillbench.tasks.javaapi.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TreeNodeImpl implements TreeNode {
    private TreeNode parent = null;
    private Set<TreeNode> children = new HashSet<>();
    private boolean expanded = false;
    private Object data = null;

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {
        if (this.getParent() == null) {
            return null;
        } else {
            TreeNode t = this.parent;
            while (t.getParent() != null) {
                t = t.getParent();
            }
            return t;
        }
    }

    @Override
    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    @Override
    public int getChildCount() {
        return this.children.size();
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        return this.children.iterator();
    }

    @Override
    public void addChild(TreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    @Override
    public boolean removeChild(TreeNode child) {
        child.setParent(null);
        return this.children.remove(child);
    }

    @Override
    public boolean isExpanded() {
        return this.expanded;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        if (this.children.isEmpty()) {
            return;
        }
        for (TreeNode e : this.children) {
            e.setExpanded(expanded);
        }
    }

    @Override
    public Object getData() {
        return this.data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getTreePath() {
        if (this.parent == null) {
            return this.data == null ? "empty" : this.data.toString();
        }
        return this.parent.getTreePath() + "->" + (this.data == null ? "empty" : this.data.toString());
    }

    @Override
    public TreeNode findParent(Object data) {
        if (this.data.equals(data)) {
            return this;
        }
        if (this.parent == null) {
            return null;
        }
        return this.parent.findParent(data);
    }

    @Override
    public TreeNode findChild(Object data) {

        for (TreeNode t : this.children) {
            if (data == null && t.getData() == null) {
                return t;
            }
            if (t.getData() != null && t.getData().equals(data)) {
                return t;
            }
            return t.findChild(data);
        }
        return null;
    }
}

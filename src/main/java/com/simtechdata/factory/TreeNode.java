package com.simtechdata.factory;

public class TreeNode {
    private String name;
    private boolean selected = true;
    private boolean checkBoxNode;

    public TreeNode(String name, boolean checkBoxNode) {
        this.name = name;
        this.checkBoxNode = checkBoxNode;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isCheckBoxNode() {
        return checkBoxNode;
    }

    @Override
    public String toString() {
        return name;
    }
}

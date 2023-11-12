package com.simtechdata.factory;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TreeCell;

public class CellFactory extends TreeCell<TreeNode> {
    private CheckBox checkBox;

    public CellFactory() {
        checkBox = new CheckBox();
        checkBox.setOnAction(event -> {
            TreeNode item = getItem();
            if (item != null) {
                item.setSelected(checkBox.isSelected());
            }
        });

        itemProperty().addListener(((observable, oldValue, treeNode) -> {
            if (treeNode != null) {
                checkBox.setVisible(treeNode.isCheckBoxNode());
            }
        }));
    }

    @Override
    protected void updateItem(TreeNode treeNode, boolean empty) {
        super.updateItem(treeNode, empty);
        if (empty || treeNode == null) {
            setGraphic(null);
        }
        else {
            checkBox.setSelected(treeNode.isSelected());
            setText(treeNode.toString());
            setGraphic(checkBox);
        }
    }
}

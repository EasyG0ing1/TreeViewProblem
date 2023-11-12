package com.simtechdata;

import com.simtechdata.factory.CellFactory;
import com.simtechdata.factory.TreeNode;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private TreeItem<TreeNode> root;
    private Random random = new Random(System.currentTimeMillis());


    @Override
    public void start(Stage stage) throws Exception {
        root = new TreeItem<>(new TreeNode("Root", false));
        TreeView<TreeNode> treeView = new TreeView<>(root);
        treeView.setCellFactory(param -> new CellFactory());
        treeView.setShowRoot(false);
        ScrollPane scrollPane = new ScrollPane(treeView);
        double width = 500;
        double height = 800;
        AnchorPane ap = new AnchorPane(scrollPane);
        Scene scene = new Scene(ap);
        stage.setScene(scene);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setOnCloseRequest(e->{
            Platform.exit();
            System.exit(0);
        });
        treeView.setPrefWidth(width);
        treeView.setPrefHeight(height);
        ap.setPrefWidth(width);
        ap.setPrefHeight(height);
        AnchorPane.setRightAnchor(scrollPane, 0.0);
        AnchorPane.setLeftAnchor(scrollPane, 0.0);
        AnchorPane.setTopAnchor(scrollPane, 30.0);
        AnchorPane.setBottomAnchor(scrollPane, 0.0);
        stage.show();
        new Thread(buildTree()).start();
    }

    private String getName() {
        int low = 100;
        int high = 9999;
        return "Node(" + random.nextInt(low, high) + ")";
    }

    private Runnable buildTree() {
        return ()->{
            for (int x = 0; x < 100; x++) {
                boolean checkBoxNode = x % 2 == 0;
                root.getChildren().add(new TreeItem<>(new TreeNode(getName(), checkBoxNode)));
                sleep(500);
            }
        };
    }

    private void sleep(long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        }
        catch (InterruptedException ignored) {
        }
    }
}

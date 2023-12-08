package com.jukomu.exercise2;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * @Description:
 * @Author：Jukomu
 * @Package：com.jukomu.exercise2
 * @Project：Exercise2
 * @name：Right
 * @Date：2023/12/8 10:35
 * @Filename：Right
 */
public class Right extends VBox {
    String currentDescription;

    public Right() {
        Label label1 = new Label("UAR component description:");
        Label label2 = new Label("Found at: ");
        TextArea area = new TextArea();
        this.getChildren().addAll(label1,area,label2);
    }
}

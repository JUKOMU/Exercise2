package com.jukomu.exercise2;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // 两栏，左边为UAR components names，右边为UAR component description
        HBox main = new HBox();
        // 将列的宽度与窗口宽度绑定
        DoubleBinding columnWidthBinding = Bindings.createDoubleBinding(() -> stage.getWidth() / 2, stage.widthProperty());
        Left _left = new Left();
        _left.prefWidthProperty().bind(columnWidthBinding);
        Right _right = new Right();
        _right.prefWidthProperty().bind(columnWidthBinding);
        main.getChildren().addAll(_left,_right);
        // 设置窗口大小
        Scene scene = new Scene(main,870,475);
        // 设置窗口标题
        stage.setTitle("UAR Components");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
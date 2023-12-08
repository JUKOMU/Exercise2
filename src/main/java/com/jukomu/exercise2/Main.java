package com.jukomu.exercise2;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // 两栏，左边为UAR components names，右边为UAR component description
        HBox mainHbox = new HBox();
        // 将列的宽度与窗口宽度绑定
        DoubleBinding columnWidthBinding = Bindings.createDoubleBinding(() -> stage.getWidth() / 2, stage.widthProperty());
        Left _left = new Left();
        _left.prefWidthProperty().bind(columnWidthBinding);
        Right _right = new Right();
        _right.prefWidthProperty().bind(columnWidthBinding);
        mainHbox.getChildren().addAll(_left, _right);
        // 设置窗口大小
        Scene scene = new Scene(mainHbox, 870, 475);
        // 设置窗口标题
        stage.setTitle("UAR Components");
        stage.setScene(scene);
        stage.show();

        /* 设置按钮事件 */
        // display按钮
        _left.displayBtn.setOnAction(event -> {
            int number = _left.getNumber();
            if (number != -1) {
                _right.setCurrentDescription(number);
                _left.searchField.requestFocus();
            } else {
                // 创建一个Alert对象
                Alert alert = new Alert(Alert.AlertType.WARNING);

                // 设置标题
                alert.setTitle("Search String");
                alert.setHeaderText(null); // 不显示头部标题
                // 设置ContentText
                alert.setContentText("Please enter values between 1 and 7");

                // 添加确定按钮
                ButtonType okButton = new ButtonType("确定");
                alert.getButtonTypes().setAll(okButton);
                // 获取对话框面板(DialogPane)，并设置面板的大小
                alert.getDialogPane().setPrefSize(300, 100);
                // 显示弹窗，并等待用户关闭
                alert.showAndWait();
            }
        });
        // search按钮
        _left.searchBtn.setOnAction(event -> {
            if (_right.currentDescription.isEmpty()){
                // 创建一个Alert对象
                Alert alert = new Alert(Alert.AlertType.WARNING);
                // 设置标题
                alert.setTitle("Search String");
                alert.setHeaderText(null); // 不显示头部标题
                // 设置ContentText
                alert.setContentText("Please select text");

                // 添加确定按钮
                ButtonType okButton = new ButtonType("确定");
                alert.getButtonTypes().setAll(okButton);
                // 获取对话框面板(DialogPane)，并设置面板的大小
                alert.getDialogPane().setPrefSize(200, 100);
                // 显示弹窗，并等待用户关闭
                alert.showAndWait();
                _left.numberField.requestFocus();
                return;
            }
            if (_left.isSearchStringEmpty()) {
                // true则继续对当前字符串查找，否则清空
                if (_right.searchString(_left.searchField.getText())) {
                    _left.searchField.requestFocus();
                    _left.searchField.selectAll();
                } else {
                    _right.clearDisplay();
                    _right.clearFoundString();
                    _left.numberField.setText("");
                    _left.searchField.setText("");
                }
            } else {
                // 创建一个Alert对象
                Alert alert = new Alert(Alert.AlertType.WARNING);
                // 设置标题
                alert.setTitle("Search String");
                alert.setHeaderText(null); // 不显示头部标题
                // 设置ContentText
                alert.setContentText("Please enter a search string");

                // 添加确定按钮
                ButtonType okButton = new ButtonType("确定");
                alert.getButtonTypes().setAll(okButton);
                // 获取对话框面板(DialogPane)，并设置面板的大小
                alert.getDialogPane().setPrefSize(300, 100);
                // 显示弹窗，并等待用户关闭
                alert.showAndWait();
            }
        });
        /* 添加监听器 */
        // 改变内容则清空display
        _left.numberField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Textfield changed from " + oldValue + " to " + newValue);
            _right.clearDisplay();
            _right.clearFoundString();
            _left.searchField.setText("");
        });
        _left.searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Textfield changed from " + oldValue + " to " + newValue);
            _right.clearFoundString();
        });
        _left.numberField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                int number = _left.getNumber();
                if (number != -1) {
                    _right.setCurrentDescription(number);
                    _left.searchField.requestFocus();
                } else {
                    // 创建一个Alert对象
                    Alert alert = new Alert(Alert.AlertType.WARNING);

                    // 设置标题
                    alert.setTitle("Search String");
                    alert.setHeaderText(null); // 不显示头部标题
                    // 设置ContentText
                    alert.setContentText("Please enter values between 1 and 7");

                    // 添加确定按钮
                    ButtonType okButton = new ButtonType("确定");
                    alert.getButtonTypes().setAll(okButton);
                    // 获取对话框面板(DialogPane)，并设置面板的大小
                    alert.getDialogPane().setPrefSize(300, 100);
                    // 显示弹窗，并等待用户关闭
                    alert.showAndWait();
                }
            }
        });

        _left.searchField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER){
                if (_right.currentDescription.isEmpty()) {
                    // 创建一个Alert对象
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    // 设置标题
                    alert.setTitle("Search String");
                    alert.setHeaderText(null); // 不显示头部标题
                    // 设置ContentText
                    alert.setContentText("Please select text");

                    // 添加确定按钮
                    ButtonType okButton = new ButtonType("确定");
                    alert.getButtonTypes().setAll(okButton);
                    // 获取对话框面板(DialogPane)，并设置面板的大小
                    alert.getDialogPane().setPrefSize(200, 100);
                    // 显示弹窗，并等待用户关闭
                    alert.showAndWait();
                    _left.numberField.requestFocus();
                    return;
                }
                if (_left.isSearchStringEmpty()) {
                    // true则继续对当前字符串查找，否则清空
                    if (_right.searchString(_left.searchField.getText())) {
                        _left.searchField.requestFocus();
                        _left.searchField.selectAll();
                    } else {
                        _right.clearDisplay();
                        _right.clearFoundString();
                        _left.numberField.setText("");
                        _left.searchField.setText("");
                    }
                } else {
                    // 创建一个Alert对象
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    // 设置标题
                    alert.setTitle("Search String");
                    alert.setHeaderText(null); // 不显示头部标题
                    // 设置ContentText
                    alert.setContentText("Please enter a search string");

                    // 添加确定按钮
                    ButtonType okButton = new ButtonType("确定");
                    alert.getButtonTypes().setAll(okButton);
                    // 获取对话框面板(DialogPane)，并设置面板的大小
                    alert.getDialogPane().setPrefSize(300, 100);
                    // 显示弹窗，并等待用户关闭
                    alert.showAndWait();
                }
            }
        });
    }
    public static void main(String[] args) {
        launch();
    }
}
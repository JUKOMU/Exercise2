package com.jukomu.exercise2;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author：Jukomu
 * @Package：com.jukomu.exercise2
 * @Project：Exercise2
 * @name：Left
 * @Date：2023/12/8 10:35
 * @Filename：Left
 */
public class Left extends VBox {
    Button displayBtn = new Button("Display");
    Button searchBtn = new Button("Search");
    TextField numberField = new TextField();
    TextField searchField = new TextField();

    public Left() {
        /* UAR components names */
        Label label = new Label("UAR components names:");
        Label label1 = new Label("1.  UAR Identifier");
        Label label2 = new Label("2.  Succinct Description of the Usability Aspect");
        Label label3 = new Label("3.  Evidence for the Aspect");
        Label label4 = new Label("4.  Explanation of the Aspect");
        Label label5 = new Label("5.  Severity of the Problem or Benefit of the Good Feature");
        Label label6 = new Label("6.  Possible Solutions and Potential Trade-offs");
        Label label7 = new Label("7.  Relationship to Other Usability Aspects");
        /* 操作部分 */
        Label numberLabel = new Label("Enter a number:");
        Label searchLabel = new Label("Enter a search string:");

        numberField.setStyle("-fx-border-color: rgba(0,0,0,0.6);-fx-font-size: 11;-fx-focus-color: rgba(0,0,0,0.6); -fx-faint-focus-color: transparent;");
        searchField.setStyle("-fx-border-color: rgba(0,0,0,0.6);-fx-font-size: 11;-fx-focus-color: rgba(0,0,0,0.6); -fx-faint-focus-color: transparent;");
        displayBtn.setPrefSize(100,20);
        searchBtn.setPrefSize(100,20);


        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.getChildren().addAll(numberLabel,numberField,displayBtn);
        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(searchLabel,searchField,searchBtn);

        this.getChildren().addAll(label,label1,label2,label3,label4,label5,label6,label7,hBox1,hBox2);

        this.setSpacing(15);

        /* 设置组件边距和字体 */
        Insets insets = new Insets(0, 0, 0, 19);
        Font font = new Font(11);
        for (Node node : this.getChildren()) {
            if (node instanceof Label) {
                ((Label) node).setPadding(insets);
                ((Label) node).setFont(font);
            }
            if (node instanceof HBox) {
                ((HBox)node).setPadding(insets);
                node.setStyle("-fx-font-size: 11");
            }
        }

        label.setStyle("-fx-font-weight: bold;-fx-font-size: 12px");
        label.setPadding(new Insets(9,0,0,18));
        label7.setPadding(new Insets(0,0,70,20));

        /* 设置操作部分的样式 */
        numberLabel.setPadding(new Insets(0,55,0,5));
        searchLabel.setPadding(new Insets(0,30,0,5));

    }
    public int getNumber() {
        try {
            String str = numberField.getText();
            String integerRegex = "\\d+";
            int number;
            // 判断字符串是否匹配整数的正则表达式
            if (Pattern.matches(integerRegex, str)) {
                 number = Integer.parseInt(str);
            } else {
                throw new Exception();
            }
            if (number >= 1 && number <= 7) {
                return number;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            return -1;
        }
    }
    public boolean isSearchStringEmpty() {
        String str = searchField.getText();
        return !Objects.equals(str, "") && str != null;
    }
}

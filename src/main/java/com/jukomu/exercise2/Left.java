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
    private final String _1 = "This should be a unique identifier for the purposes of filing. If more than one person is working on the project or more than one analysis technique is being used, this identifier could contain letters and numbers. For example, if Chris Smith and Jan Koo are both doing an analysis, the identifier might be CS1 or JK75. If both a heuristic evaluation and a think-aloud usability study were used, the identifiers might be HE6 or TA89. Follow the unique identifier with the word 'Problem,' if the report pertains to a usability problem of the interface, or the words 'Good Feature,' if it describes an aspect of the interface you feel should be preserved in any redesign.";
    private final String _2 = "This description will be used as the 'name' of this UAR when you talk about its relation to other UARs. Make the name as short as possible (about three to five words) but still descriptive and distinguishable from other aspects of the system. If this UAR is about a problem (as opposed to a good feature), make sure you have a name that describes the problem, rather than a solution.";
    private final String _3 = "This is the objective supporting material that justifies your identifying the aspect as worthy of report. This section needs to contain enough information for a reader of this UAR to understand what triggered the report. For an HE report, for instance, this could be an image of a cluttered screen and the heuristic about aesthetics and minimalist design. In a think-aloud study this is usually what was on the screen (a screen shot or description), what the user did (keystrokes, mouse movements), what the system did in response to any user actions, and what the user said. You need to include enough pertinent information about the identification of an aspect for the reader to understand what the analyst was thinking when the aspect was identified (for HE) or what the user was trying to do when the aspect either hindered or facilitated his or her progress.";
    private final String _4 = "This is your interpretation of the evidence. That is, for a think-aloud usability test, why you think what happened happened, or, for an HE, why you think the aspect was designed the way it was. You need to provide enough content in this explanation for the reader to understand the problem-even if they do not know the system or domain as well as you do.";
    private final String _5 = "This is your reasoning about how important it is to either fix this problem or preserve this good feature. This includes how frequently the users will experience this aspect, whether they are likely to learn how it works, whether it will affect new users, casual users, experienced users, etc.";
    private final String _6 = "If this aspect is a problem (as opposed to a good feature to be preserved in the next version of the software), this is the place to propose a solution. It is not necessary to have a solution as soon as you identify a problem-you might find after analyzing the whole interface that many problems are related and can all be fixed by making a single broad change instead of making several small changes. However, if you do propose a possible solution, report any potential design trade-offs that you see";
    private final String _7 = "It is often the case that UARs are related to each other. This is where you record which UARs this one is related to and a statement about how it is related. Make sure that all the related UARs point to each other. It is a common mistake to enter the pointer into a newly created UAR, but neglect to go back to the previous ones that it relates to and update their UARs.";

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
        TextField numberField = new TextField();
        TextField searchField = new TextField();
        Button displayBtn = new Button("Display");
        displayBtn.setPrefSize(100,20);
        Button searchBtn = new Button("Search");
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
}

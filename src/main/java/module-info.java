module com.jukomu.exercise2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.jukomu.exercise2 to javafx.fxml;
    exports com.jukomu.exercise2;
}
module src.main.java.ca.uqo.restoplex {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens src.main.java.ca.uqo.restoplex to javafx.fxml;
    exports src.main.java.ca.uqo.restoplex;
    exports src.main.java.ca.uqo.restoplex.presentation;
}
module ca.uqo.restoplex {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens ca.uqo.restoplex to javafx.fxml;
    exports ca.uqo.restoplex;
    exports ca.uqo.restoplex.presentation;
}
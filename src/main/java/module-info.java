module ca.uqo.restoplex {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
	requires ormlite.jdbc;


	opens ca.uqo.restoplex to javafx.fxml;
    opens ca.uqo.restoplex.presentation to javafx.fxml;
    exports ca.uqo.restoplex;
    exports ca.uqo.restoplex.presentation;
	exports ca.uqo.restoplex.presentation.controller;
	opens ca.uqo.restoplex.presentation.controller to javafx.fxml;
}
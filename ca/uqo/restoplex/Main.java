package ca.uqo.restoplex;
import ca.uqo.restoplex.presentation.KouizineOverviewGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static java.lang.System.exit;

public class Main extends Application {
  @Override
  public void start(Stage stage) {
//    new RestoPlex().start(stage);
//    new LoginPageGUI().start(stage);


    var tablesBtn = new Button("Voir les tables");
    tablesBtn.setOnAction(event -> {
      var secondStage = new Stage();

      Parent root1;

      try {
        root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ca/uqo/restoplex/presentation/Tablee.fxml")));
      } catch(IOException e) {
        System.err.println(e.getMessage());
        exit(1);
        return;
      }


      Scene scene1 = new Scene(root1);

      Parent root2;

      try {
        root2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ca/uqo/restoplex/presentation/MenuCommande.fxml")));
      } catch(IOException e) {
        System.err.println(e.getMessage());
        exit(1);
        return;
      }

      Scene scene2 = new Scene(root2);

      scene2.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/ca/uqo/restoplex/presentation/application.css")).toExternalForm());
      secondStage.setScene(scene2);

      scene1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/ca/uqo/restoplex/presentation/application.css")).toExternalForm());
      secondStage.setScene(scene1);

      secondStage.show();
    });

    var kouizineBtn = new Button("Voir la Cuisine");
    kouizineBtn.setOnAction(event -> new KouizineOverviewGUI().stage().show());

    var vbox = new VBox(5); // 5 is the spacing between elements in the VBox
    vbox.getChildren().addAll(tablesBtn, kouizineBtn);

    var root = new StackPane();
    root.getChildren().add(vbox);
    StackPane.setAlignment(vbox, Pos.CENTER);
    stage.setScene(new Scene(root, 800, 600));
    stage.show();
  }
}

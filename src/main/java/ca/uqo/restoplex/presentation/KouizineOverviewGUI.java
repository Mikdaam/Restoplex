package ca.uqo.restoplex.presentation;
import ca.uqo.restoplex.data.Cookable;
import ca.uqo.restoplex.data.OrderableDescription;
import ca.uqo.restoplex.domain.Factory;
import ca.uqo.restoplex.domain.Kouizine;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public final class KouizineOverviewGUI extends Application {
  private final Kouizine kouizine = Factory.getKouizineInstance();
  private final ListView<Cookable> toCookListView = kouizine.bindListViewWithToCookCookables();
  private final ListView<Cookable> inPreparationListView = kouizine.bindListViewWithInPreparationCookables();

  private Cookable toCookSelectedCookable;
  private Cookable inPreparationSelectedCookable;

  @Override
  public void start(Stage stage) {
    toCookListView.getSelectionModel().selectedItemProperty().addListener(
            (observableValue, oldValue, newValue) -> toCookSelectedCookable = newValue
    );
    inPreparationListView.getSelectionModel().selectedItemProperty().addListener(
            (observableValue, oldValue, newValue) -> inPreparationSelectedCookable = newValue
    );


    var btn = new Button("Test");
    var random = new Random();
    btn.setOnAction(event -> {
      var name = "" + random.nextInt();
      var description = new OrderableDescription.ItemDescription(new OrderableDescription.OrderableDescriptionData(42L, name, 12.5F), null, null);
      var cookable = new Cookable((short) 12, description, null);
      kouizine.test(cookable);
    });

    var acceptBtn = new Button("Accept");
    acceptBtn.setOnAction(__ -> {
      if(toCookSelectedCookable == null) {
        return;
      }

      kouizine.prepareCookable(toCookSelectedCookable);
    });
    var readyBtn = new Button("Ready");
    readyBtn.setOnAction(__ -> {
      if(inPreparationSelectedCookable == null) {
        return;
      }

      kouizine.notifyReadyCookable(inPreparationSelectedCookable);
    });

    var vbox = new VBox(5); // 5 is the spacing between elements in the VBox
    vbox.getChildren().addAll(toCookListView, inPreparationListView, btn, acceptBtn, readyBtn);

    var root = new StackPane();
    root.getChildren().add(vbox);
    StackPane.setAlignment(vbox, Pos.CENTER);

    stage.setScene(new Scene(root));
    stage.show();
  }
}

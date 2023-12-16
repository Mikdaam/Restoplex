package src.main.java.ca.uqo.restoplex;
import src.main.java.ca.uqo.restoplex.presentation.TableOverviewGUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage stage) {
    new TableOverviewGUI().start(stage);
//    new LoginPageGUI().start(stage);
  }

  public static void main(String[] args) {
    // TODO code des tests
    launch(args);
  }
}

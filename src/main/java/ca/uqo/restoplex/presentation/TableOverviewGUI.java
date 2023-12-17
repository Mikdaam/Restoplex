package src.main.java.ca.uqo.restoplex.presentation;
import javafx.application.Application;
import javafx.stage.Stage;
import src.main.java.ca.uqo.restoplex.domain.Factory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class TableOverviewGUI implements Initializable{
	@FXML
	private Button table1;
	@FXML
	private Button table2;
	@FXML
	private Button table3;
	@FXML
	private Button table4;
	@FXML
	private Button table5;
	@FXML
	private Button table6;
	@FXML
	private Button table7;
	@FXML
	private Button table8;
	@FXML
	private Button table9;
	@FXML
	private Button table10;
	@FXML
	private Button table11;
	@FXML
	private Button table12;
	@FXML
	private Button table13;
	@FXML
	private Button table14;
	@FXML
	private Button table15;
	@FXML
	private Button table16;
	@FXML
	private Button table17;
	@FXML
	private Button table18;
	@FXML
	private Button table19;
	@FXML
	private Button table20;
	@FXML
	private Button table21;
	@FXML
	private Button table22;
	@FXML
	private Button table23;
	@FXML
	private Button table24;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(",,,,,,,");
		var tableController = Factory.getTablesControllerInstance();
		var tableList = tableController.tables();
		
		if(table1 != null) {
			table1.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(0));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		
		if(table2 != null) {
			table2.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(1));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table3 != null) {
			table3.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(2));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table4 != null) {
			table4.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(3));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table5 != null) {
			table5.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(4));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table6 != null) {
			table6.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(5));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table7 != null) {
			table7.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(6));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table8 != null) {
			table8.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(7));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table9 != null) {
			table9.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(8));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table10 != null) {
			table10.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(9));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table11 != null) {
			table11.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(10));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table12 != null) {
			table12.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(11));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table13 != null) {
			table13.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(12));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table14 != null) {
			table14.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(13));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table15 != null) {
			table15.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(14));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table16 != null) {
			table16.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(15));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table17 != null) {
			table17.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(16));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table18 != null) {
			table18.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(17));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table19 != null) {
			table19.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(18));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table20 != null) {
			table20.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(19));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table21 != null) {
			table21.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(20));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table22 != null) {
			table22.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(21));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table23 != null) {
			table23.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(22));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		if(table24 != null) {
			table24.setOnAction(event -> {
				try {
					ClassController.switchToMenuCommande(event, tableList.get(23));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(1);
					return;
				}
			});
		}
		
	}
	
	
	
	
//	public static void main(String[] args) {
//		launch(args);
//	}
}

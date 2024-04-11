package pediasync;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{
	//public UserInterface UI;
	
	public void start(Stage primary_stage) 
	{
		new LoginInterface();
		
		//ViewsInterface patientView = new ViewsInterface("Patient View", "leotran");

		/*Pane pane = new Pane();
		
		UI = new UserInterface(pane);
		
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		
		primary_stage.setScene(scene);
		
		primary_stage.show();*/
	}
	public static void main(String[] args) 
	{
		launch(args);
	}
}

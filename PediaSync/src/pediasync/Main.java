package pediasync;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{
	public void start(Stage primary_stage) 
	{
		Pane pane = new Pane();
		
		Scene scene = new Scene(pane, 620, 400);
		
		primary_stage.setScene(scene);
		
		primary_stage.show();
	}
	public static void main(String[] args) 
	{
		launch(args);
	}
}

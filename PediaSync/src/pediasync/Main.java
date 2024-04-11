package pediasync;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// Class for launching the program
public class Main extends Application
{	
	// Method that calls the class LoginInterface() which extends the current Stage
	public void start(Stage primary_stage) 
	{
		new LoginInterface();
	}
	public static void main(String[] args) 
	{
		launch(args);
	}
}
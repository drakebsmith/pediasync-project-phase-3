package pediasync;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class ViewsInterface extends Stage
{
	
	public ViewsInterface(String viewName, Stage stage) {
		//test
        Scene newScene;
        
        switch (viewName) {
            case "Patient View":
                newScene = patientView(stage);
                break;
            case "Receptionist View":
                newScene = receptionistView(stage);
                break;
            case "Doctor View":
                newScene = technicianView(stage);
                break;
            default:
                newScene = null;
                break;
                
        }

        if (newScene != null) {
            stage.setScene(newScene);
            stage.show();
            
        }
    }
	
	private Scene patientView(Stage stage) {
		Pane pane = new Pane();
		
	    Label label = new Label("Patient View");
	    pane.getChildren().add(label);
	    Scene scene = new Scene(pane, 800, 400);
	    return scene;
	}

	private Scene receptionistView(Stage stage) {
		Pane pane = new Pane();
		
	    Label label = new Label("Receptionist View");
	    pane.getChildren().add(label);
	    Scene scene = new Scene(pane, 800, 400);
	    return scene;
	}

	private Scene technicianView(Stage stage) {
		Pane pane = new Pane();
		
	    Label label = new Label("Doctor View");
	    pane.getChildren().add(label);
	    Scene scene = new Scene(pane, 800, 400);
	    
	    return scene;
	}
}

package pediasync;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class ViewsInterface extends Stage
{
	
	public ViewsInterface(String viewName) {
		//test
        Scene newScene;
        
        switch (viewName) {
            case "Patient View":
                newScene = patientView();
                break;
            case "Receptionist View":
                newScene = receptionistView();
                break;
            case "Doctor View":
                newScene = technicianView();
                break;
            default:
                newScene = null;
                break;
                
        }

        if (newScene != null) {
            this.setScene(newScene);
            this.show();
            
        }
    }
	
	private Scene patientView() {
		Pane pane = new Pane();
		
	    Label label = new Label("Patient View");
	    pane.getChildren().add(label);
	    Scene scene = new Scene(pane, 800, 400);
	    return scene;
	}

	private Scene receptionistView() {
		Pane pane = new Pane();
		
	    Label label = new Label("Receptionist View");
	    pane.getChildren().add(label);
	    Scene scene = new Scene(pane, 800, 400);
	    return scene;
	}

	private Scene technicianView() {
		Pane pane = new Pane();
		
	    Label label = new Label("Doctor View");
	    pane.getChildren().add(label);
	    Scene scene = new Scene(pane, 800, 400);
	    
	    return scene;
	}
}

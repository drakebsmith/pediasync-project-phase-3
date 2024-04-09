package pediasync;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ViewsInterface extends Stage
{
	private String patientName;
	private String nurseName;
	private String doctorLastName;
	
	public ViewsInterface(String viewName, String name) {
		//test
        Scene newScene;
        
        switch (viewName) {
            case "Patient View":
            	this.patientName = name;
                newScene = patientView();
                break;
            case "Nurse View":
            	this.nurseName = name;
                newScene = nurseView();
                break;
            case "Doctor View":
            	this.doctorName = name;
                newScene = doctorView();
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

	    Label pediaSyncLabel = new Label("PediaSync");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    Label welcomeLabel = new Label("Welcome, " + patientName + " !");
	    welcomeLabel.setFont(new Font(24));
	    welcomeLabel.setLayoutX(40);
	    welcomeLabel.setLayoutY(80);
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);




	    Button patientInformationButton = new Button("Patient Information");
	    Button patientPortalMessagesButton = new Button("Patient Portal Messages");
	    Button visitSummaryButton = new Button("Visit Summary");
	    
	    patientInformationButton.setPrefWidth(200);
	    patientPortalMessagesButton.setPrefWidth(200);
	    visitSummaryButton.setPrefWidth(200);
	    
	    patientInformationButton.setPrefHeight(30);
	    patientPortalMessagesButton.setPrefHeight(30);
	    visitSummaryButton.setPrefHeight(30);
	    
	    patientInformationButton.setLayoutX(300);
	    patientInformationButton.setLayoutY(160);

	    patientPortalMessagesButton.setLayoutX(300);
	    patientPortalMessagesButton.setLayoutY(200);

	    visitSummaryButton.setLayoutX(300);
	    visitSummaryButton.setLayoutY(240);


	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,welcomeLabel,patientInformationButton,patientPortalMessagesButton,visitSummaryButton);
	    
	    Scene scene = new Scene(pane, 800, 400);

	    return scene;
	}

	private Scene nurseView() {
		Pane pane = new Pane();
		
		Label pediaSyncLabel = new Label("PediaSync");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    Label welcomeLabel = new Label("Welcome, Nurse " + nurseName + " !");
	    welcomeLabel.setFont(new Font(24));
	    welcomeLabel.setLayoutX(40);
	    welcomeLabel.setLayoutY(80);
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
		
	    
	    
	    Button addPatientInformationButton = new Button("Add Patient Information");
	    Button patientInformationButton = new Button("Patient Information");
	    Button patientPortalMessagesButton = new Button("Patient Portal Messagesy");
	    
	    addPatientInformationButton.setPrefWidth(200);
	    patientInformationButton.setPrefWidth(200);
	    patientPortalMessagesButton.setPrefWidth(200);
	    
	    addPatientInformationButton.setPrefHeight(30);
	    patientInformationButton.setPrefHeight(30);
	    patientPortalMessagesButton.setPrefHeight(30);
	    
	    addPatientInformationButton.setLayoutX(300);
	    addPatientInformationButton.setLayoutY(160);

	    patientInformationButton.setLayoutX(300);
	    patientInformationButton.setLayoutY(200);

	    patientPortalMessagesButton.setLayoutX(300);
	    patientPortalMessagesButton.setLayoutY(240);
	    
	    
	    
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,welcomeLabel,addPatientInformationButton,patientInformationButton,patientPortalMessagesButton);
	    Scene scene = new Scene(pane, 800, 400);
	    return scene;
	}

	private Scene doctorView() {
		Pane pane = new Pane();
		
		Label pediaSyncLabel = new Label("PediaSync");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    Label welcomeLabel = new Label("Welcome, Dr. " + doctorLastName + " !");
	    welcomeLabel.setFont(new Font(24));
	    welcomeLabel.setLayoutX(40);
	    welcomeLabel.setLayoutY(80);
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
		

	    
	    
	    Button addPatientInformationButton = new Button("Add Patient Information");
	    Button visitSummaryButton = new Button("Visit Summary");
	    Button patientInformationButton = new Button("Patient Information");
	    Button patientPortalMessagesButton = new Button("Patient Portal Messages");
	    
	    addPatientInformationButton.setPrefWidth(200);
	    visitSummaryButton.setPrefWidth(200);
	    patientInformationButton.setPrefWidth(200);
	    patientPortalMessagesButton.setPrefWidth(200);
	    
	    addPatientInformationButton.setPrefHeight(30);
	    visitSummaryButton.setPrefHeight(30);
	    patientInformationButton.setPrefHeight(30);
	    patientPortalMessagesButton.setPrefHeight(30);
	    
	    addPatientInformationButton.setLayoutX(300);
	    addPatientInformationButton.setLayoutY(160);

	    visitSummaryButton.setLayoutX(300);
	    visitSummaryButton.setLayoutY(200);

	    patientInformationButton.setLayoutX(300);
	    patientInformationButton.setLayoutY(240);
	    
	    patientPortalMessagesButton.setLayoutX(300);
	    patientPortalMessagesButton.setLayoutY(280);
	    
	    
	    
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,welcomeLabel,addPatientInformationButton,visitSummaryButton,patientInformationButton,patientPortalMessagesButton);
	    Scene scene = new Scene(pane, 800, 400);
	    
	    return scene;
	}
}

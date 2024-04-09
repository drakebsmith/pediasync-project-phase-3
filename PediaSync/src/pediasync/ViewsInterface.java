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
            	this.doctorLastName = name;
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
	
//--------------------------------------Patient View----------------------------------------//
	
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
	    patientInformationButton.setOnAction(e -> this.setScene(patient_patientInformationScene()));
	    Button patientPortalMessagesButton = new Button("Patient Portal Messages");
	    patientPortalMessagesButton.setOnAction(e -> this.setScene(patient_portalMessagesScene()));
	    Button visitSummaryButton = new Button("Visit Summary");
	    visitSummaryButton.setOnAction(e -> this.setScene(patient_visitSummaryScene()));
	    
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
	
	private Scene patient_patientInformationScene() {
		Pane pane = new Pane();

	    Label pediaSyncLabel = new Label("Patient Information");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(patientView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton);
	    
	    return new Scene(pane, 800, 400);
	    
	}

	private Scene patient_portalMessagesScene() {
		Pane pane = new Pane();

	    Label pediaSyncLabel = new Label("Patient Portal Messages");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(patientView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton);
	    
	    return new Scene(pane, 800, 400);
	}

	private Scene patient_visitSummaryScene() {
		Pane pane = new Pane();

	    Label pediaSyncLabel = new Label("Visit Summary");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(patientView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton);
	    
	    return new Scene(pane, 800, 400);
	}
	


//--------------------------------------Patient View----------------------------------------//
	
	
//--------------------------------------Nurse View----------------------------------------//

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
	    addPatientInformationButton.setOnAction(e -> this.setScene(nurse_addPatientInformationScene()));
	    Button patientInformationButton = new Button("Patient Information");
	    patientInformationButton.setOnAction(e -> this.setScene(nurse_patientInformationScene()));
	    Button patientPortalMessagesButton = new Button("Patient Portal Messagesy");
	    patientPortalMessagesButton.setOnAction(e -> this.setScene(nurse_portalMessagesScene()));
	    
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
	
	private Scene nurse_addPatientInformationScene() {
		Pane pane = new Pane();

	    Label pediaSyncLabel = new Label("Add Patient Information");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(nurseView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton);
	    
	    return new Scene(pane, 800, 400);
	}
	
	private Scene nurse_patientInformationScene() {
		Pane pane = new Pane();

	    Label pediaSyncLabel = new Label("Patient Information");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(nurseView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton);
	    
	    return new Scene(pane, 800, 400);
	}
	
	private Scene nurse_portalMessagesScene() {
		Pane pane = new Pane();

	    Label pediaSyncLabel = new Label("Patient Portal Messages");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(nurseView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton);
	    
	    return new Scene(pane, 800, 400);
	}
	
	
	
//--------------------------------------Nurse View----------------------------------------//
	
//--------------------------------------Doctor View----------------------------------------//

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
	    addPatientInformationButton.setOnAction(e -> this.setScene(doctor_addPatientInformationScene()));
	    Button visitSummaryButton = new Button("Visit Summary");
	    visitSummaryButton.setOnAction(e -> this.setScene(doctor_visitSummaryScene()));
	    Button patientInformationButton = new Button("Patient Information");
	    patientInformationButton.setOnAction(e -> this.setScene(doctor_patientInformationScene()));
	    Button patientPortalMessagesButton = new Button("Patient Portal Messages");
	    patientPortalMessagesButton.setOnAction(e -> this.setScene(doctor_portalMessagesScene()));
	    
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
	
	private Scene doctor_addPatientInformationScene() {
		Pane pane = new Pane();

	    Label pediaSyncLabel = new Label("Add Patient Information");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(doctorView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton);
	    
	    return new Scene(pane, 800, 400);
	}
	
	private Scene doctor_visitSummaryScene() {
		Pane pane = new Pane();

	    Label pediaSyncLabel = new Label("Visit Summary");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(doctorView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton);
	    
	    return new Scene(pane, 800, 400);
	}
	
	private Scene doctor_patientInformationScene() {
		Pane pane = new Pane();

	    Label pediaSyncLabel = new Label("Patient Information");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(doctorView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton);
	    
	    return new Scene(pane, 800, 400);
	}
	
	private Scene doctor_portalMessagesScene() {
		Pane pane = new Pane();

	    Label pediaSyncLabel = new Label("Patient Portal Messages");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    
	    Rectangle crossVertical = new Rectangle(0, 12, 10, 30);
	    crossVertical.setFill(Color.RED);

	    Rectangle crossHorizontal = new Rectangle(-10, 22, 30, 10);
	    crossHorizontal.setFill(Color.RED);

	    Group crossGroup = new Group(crossVertical, crossHorizontal);

	    crossGroup.setLayoutX(50);
	    crossGroup.setLayoutY(12);
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(doctorView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton);
	    
	    return new Scene(pane, 800, 400);
	}
	
	
	
//--------------------------------------Doctor View----------------------------------------//
}

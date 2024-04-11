package pediasync;

import javafx.stage.Stage;

import java.util.ArrayList;

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
	//String username = "";
	
	private String username;
	
	private ArrayList<String> information;
	
	String patientName = "";
	String birthdate = "";
	String patientContact = "";
	String patientEmergencyContact = "";
	String patientAllergiesHealthConcerns = "";
	String patientImmunization = "";
	String patientHistory = "";
	String patientPrescription = "";
	String patientVitals = "";
	String visitSummary = "";
	
	String date = "4/9/2004";
	
	
	private String nurseName = "";
	private String doctorLastName = "";
	
	public Filer file; // Tester
	
	
	

	
	public ViewsInterface(String viewName, String username) {
		//test
		this.username = username;
		
        //readFile();
        Scene newScene;
        
        switch (viewName) {
            case "Patient View":
                newScene = patientView();
                break;
            case "Nurse View":
                newScene = nurseView();
                break;
            case "Doctor View":
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
	
	/*private void readFile() {
	    Filer filer = new Filer();
	    ArrayList<String> patientInfo = filer.readFile(this.username);

	    if (patientInfo.size() >= 9) {
	        patientName = patientInfo.get(1);
	        birthdate = patientInfo.get(2);
	        patientContact = patientInfo.get(3);
	        patientEmergencyContact = patientInfo.get(4);
	        patientAllergiesHealthConcerns = patientInfo.get(5);
	        patientImmunization = patientInfo.get(6);
	        patientHistory = patientInfo.get(7);
	        patientPrescription = patientInfo.get(8);
	        patientVitals = patientInfo.get(9);
	        visitSummary = patientInfo.get(10);
	    }
	}*/
	
//--------------------------------------Patient View----------------------------------------//
	
	private Scene patientView() {
		
		file = new Filer();
		
		information = file.readFile(username);
		
		patientName = information.get(2);
		
		Pane pane = new Pane();

	    Label pediaSyncLabel = new Label("PediaSync");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    Label welcomeLabel = new Label("Welcome, " + patientName + "!");
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
	    
	    
	    Label contactLabel = new Label("Contact: " + patientContact);
	    contactLabel.setFont(new Font(12));
	    contactLabel.setLayoutX(250);
	    contactLabel.setLayoutY(100);
	    
	    Label emergencyContactLabel = new Label("Emergency Contact: " + patientEmergencyContact);
	    emergencyContactLabel.setFont(new Font(12));
	    emergencyContactLabel.setLayoutX(250);
	    emergencyContactLabel.setLayoutY(130);
	    
	    Label allergiesHealthConcernsLabel = new Label("Allergies and Health Concerns: " + patientAllergiesHealthConcerns);
	    allergiesHealthConcernsLabel.setFont(new Font(12));
	    allergiesHealthConcernsLabel.setLayoutX(250);
	    allergiesHealthConcernsLabel.setLayoutY(160);
	    
	    Label immunizationHistoryLabel = new Label("Immunization History: " + patientImmunization);
	    immunizationHistoryLabel.setFont(new Font(12));
	    immunizationHistoryLabel.setLayoutX(250);
	    immunizationHistoryLabel.setLayoutY(190);
	    
	    Label patientHistoryLabel = new Label("Patient History: " + patientHistory);
	    patientHistoryLabel.setFont(new Font(12));
	    patientHistoryLabel.setLayoutX(250);
	    patientHistoryLabel.setLayoutY(220);
	    
	    Label prescriptionLabel = new Label("Prescription: " + patientPrescription);
	    prescriptionLabel.setFont(new Font(12));
	    prescriptionLabel.setLayoutX(250);
	    prescriptionLabel.setLayoutY(250);
	    
	    Label vitalsLabel = new Label("Vitals: " + patientVitals);
	    vitalsLabel.setFont(new Font(12));
	    vitalsLabel.setLayoutX(250);
	    vitalsLabel.setLayoutY(280);
	    
	    Button addContactButton = new Button("+");
	    addContactButton.setLayoutX(500);
	    addContactButton.setLayoutY(100);
	    
	    Button addEmergencyContactButton = new Button("+");
	    addEmergencyContactButton.setLayoutX(500);
	    addEmergencyContactButton.setLayoutY(130);
	    
	    
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(patientView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton,contactLabel,emergencyContactLabel,allergiesHealthConcernsLabel,immunizationHistoryLabel,patientHistoryLabel,prescriptionLabel,vitalsLabel, addContactButton, addEmergencyContactButton);
	    
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
	    
	    
	    Label visitSummaryLabel = new Label(date + ": " + visitSummary);
	    visitSummaryLabel.setFont(new Font(12));
	    visitSummaryLabel.setLayoutX(100);
	    visitSummaryLabel.setLayoutY(100);
	    
	    
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(patientView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton, visitSummaryLabel);
	    
	    return new Scene(pane, 800, 400);
	}
	


//--------------------------------------Patient View----------------------------------------//
	
	
//--------------------------------------Nurse View----------------------------------------//

	private Scene nurseView() {
		
		file = new Filer();
		
		information = file.readFile(username);
		
		nurseName = information.get(3);
		
		Pane pane = new Pane();
		
		Label pediaSyncLabel = new Label("PediaSync");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    Label welcomeLabel = new Label("Welcome, Nurse " + nurseName + "!");
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
	    
	    
	    Label vitalsLabel = new Label("Vitals: " + patientVitals);
	    vitalsLabel.setFont(new Font(12));
	    vitalsLabel.setLayoutX(250);
	    vitalsLabel.setLayoutY(100);
	    
	    Label allergiesHealthConcernsLabel = new Label("Allergies and Health Concerns: " + patientAllergiesHealthConcerns);
	    allergiesHealthConcernsLabel.setFont(new Font(12));
	    allergiesHealthConcernsLabel.setLayoutX(250);
	    allergiesHealthConcernsLabel.setLayoutY(130);
	    
	    Label immunizationHistoryLabel = new Label("Immunization History: " + patientImmunization);
	    immunizationHistoryLabel.setFont(new Font(12));
	    immunizationHistoryLabel.setLayoutX(250);
	    immunizationHistoryLabel.setLayoutY(160);
	    
	    Label patientHistoryLabel = new Label("Patient History: " + patientHistory);
	    patientHistoryLabel.setFont(new Font(12));
	    patientHistoryLabel.setLayoutX(250);
	    patientHistoryLabel.setLayoutY(190);
	    
	    Button addVitalsButton = new Button("+");
	    addVitalsButton.setLayoutX(500);
	    addVitalsButton.setLayoutY(100);
	    
	    Button addAllergiesAndHealthButton = new Button("+");
	    addAllergiesAndHealthButton.setLayoutX(500);
	    addAllergiesAndHealthButton.setLayoutY(130);
	    
	    Button addImmunizationButton = new Button("+");
	    addImmunizationButton.setLayoutX(500);
	    addImmunizationButton.setLayoutY(160);
	    
	    Button addPatientHistoryButton = new Button("+");
	    addPatientHistoryButton.setLayoutX(500);
	    addPatientHistoryButton.setLayoutY(190);
	    
	    
	    
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(nurseView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton,addVitalsButton,addAllergiesAndHealthButton,addImmunizationButton,addPatientHistoryButton,vitalsLabel,allergiesHealthConcernsLabel,immunizationHistoryLabel,patientHistoryLabel);
	    
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
	    
	    
	    
	    Label contactLabel = new Label("Contact: " + patientContact);
	    contactLabel.setFont(new Font(12));
	    contactLabel.setLayoutX(250);
	    contactLabel.setLayoutY(100);
	    
	    Label emergencyContactLabel = new Label("Emergency Contact: " + patientEmergencyContact);
	    emergencyContactLabel.setFont(new Font(12));
	    emergencyContactLabel.setLayoutX(250);
	    emergencyContactLabel.setLayoutY(130);
	    
	    Label allergiesHealthConcernsLabel = new Label("Allergies and Health Concerns: " + patientAllergiesHealthConcerns);
	    allergiesHealthConcernsLabel.setFont(new Font(12));
	    allergiesHealthConcernsLabel.setLayoutX(250);
	    allergiesHealthConcernsLabel.setLayoutY(160);
	    
	    Label immunizationHistoryLabel = new Label("Immunization History: " + patientImmunization);
	    immunizationHistoryLabel.setFont(new Font(12));
	    immunizationHistoryLabel.setLayoutX(250);
	    immunizationHistoryLabel.setLayoutY(190);
	    
	    Label patientHistoryLabel = new Label("Patient History: " + patientHistory);
	    patientHistoryLabel.setFont(new Font(12));
	    patientHistoryLabel.setLayoutX(250);
	    patientHistoryLabel.setLayoutY(220);
	    
	    Label prescriptionLabel = new Label("Prescription: " + patientPrescription);
	    prescriptionLabel.setFont(new Font(12));
	    prescriptionLabel.setLayoutX(250);
	    prescriptionLabel.setLayoutY(250);
	    
	    Label vitalsLabel = new Label("Vitals: " + patientVitals);
	    vitalsLabel.setFont(new Font(12));
	    vitalsLabel.setLayoutX(250);
	    vitalsLabel.setLayoutY(280);
	    
	    
	    
	    
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(nurseView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton,contactLabel,emergencyContactLabel,allergiesHealthConcernsLabel,immunizationHistoryLabel,patientHistoryLabel,prescriptionLabel,vitalsLabel);
	    
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
		
		file = new Filer();
		
		information = file.readFile(username);
		
		doctorLastName = information.get(3);
		
		Pane pane = new Pane();
		
		Label pediaSyncLabel = new Label("PediaSync");
	    pediaSyncLabel.setFont(new Font(24));
	    pediaSyncLabel.setLayoutX(80);
	    pediaSyncLabel.setLayoutY(20);
	    
	    Label welcomeLabel = new Label("Welcome, Dr. " + doctorLastName + "!");
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
	    
	    
	    Label vitalsLabel = new Label("Vitals: " + patientVitals);
	    vitalsLabel.setFont(new Font(12));
	    vitalsLabel.setLayoutX(250);
	    vitalsLabel.setLayoutY(100);
	    
	    Label allergiesHealthConcernsLabel = new Label("Allergies and Health Concerns: " + patientAllergiesHealthConcerns);
	    allergiesHealthConcernsLabel.setFont(new Font(12));
	    allergiesHealthConcernsLabel.setLayoutX(250);
	    allergiesHealthConcernsLabel.setLayoutY(130);
	    
	    Label immunizationHistoryLabel = new Label("Immunization History: " + patientImmunization);
	    immunizationHistoryLabel.setFont(new Font(12));
	    immunizationHistoryLabel.setLayoutX(250);
	    immunizationHistoryLabel.setLayoutY(160);
	    
	    Label patientHistoryLabel = new Label("Patient History: " + patientHistory);
	    patientHistoryLabel.setFont(new Font(12));
	    patientHistoryLabel.setLayoutX(250);
	    patientHistoryLabel.setLayoutY(190);
	    
	    Label prescriptionLabel = new Label("Prescription: " + patientPrescription);
	    prescriptionLabel.setFont(new Font(12));
	    prescriptionLabel.setLayoutX(250);
	    prescriptionLabel.setLayoutY(220);
	    
	    Button addVitalsButton = new Button("+");
	    addVitalsButton.setLayoutX(500);
	    addVitalsButton.setLayoutY(100);
	    
	    Button addAllergiesAndHealthButton = new Button("+");
	    addAllergiesAndHealthButton.setLayoutX(500);
	    addAllergiesAndHealthButton.setLayoutY(130);
	    
	    Button addImmunizationButton = new Button("+");
	    addImmunizationButton.setLayoutX(500);
	    addImmunizationButton.setLayoutY(160);
	    
	    Button addPatientHistoryButton = new Button("+");
	    addPatientHistoryButton.setLayoutX(500);
	    addPatientHistoryButton.setLayoutY(190);
	    
	    Button addPrescriptionButton = new Button("+");
	    addPrescriptionButton.setLayoutX(500);
	    addPrescriptionButton.setLayoutY(220);
	    
	    
	    
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(doctorView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton,addVitalsButton,addAllergiesAndHealthButton,addImmunizationButton,addPatientHistoryButton,addPrescriptionButton,allergiesHealthConcernsLabel,immunizationHistoryLabel,patientHistoryLabel,prescriptionLabel,vitalsLabel);
	    
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
	    
	    
	    Label visitSummaryLabel = new Label(date + ": " + visitSummary);
	    visitSummaryLabel.setFont(new Font(12));
	    visitSummaryLabel.setLayoutX(100);
	    visitSummaryLabel.setLayoutY(100);
	    
	    Button addVisitSummaryButton = new Button("+");
	    addVisitSummaryButton.setLayoutX(750);
	    addVisitSummaryButton.setLayoutY(350);
	    
	    
	    
	    
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(doctorView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton,visitSummaryLabel,addVisitSummaryButton);
	    
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
	    
	    
	    Label contactLabel = new Label("Contact: " + patientContact);
	    contactLabel.setFont(new Font(12));
	    contactLabel.setLayoutX(250);
	    contactLabel.setLayoutY(100);
	    
	    Label emergencyContactLabel = new Label("Emergency Contact: " + patientEmergencyContact);
	    emergencyContactLabel.setFont(new Font(12));
	    emergencyContactLabel.setLayoutX(250);
	    emergencyContactLabel.setLayoutY(130);
	    
	    Label allergiesHealthConcernsLabel = new Label("Allergies and Health Concerns: " + patientAllergiesHealthConcerns);
	    allergiesHealthConcernsLabel.setFont(new Font(12));
	    allergiesHealthConcernsLabel.setLayoutX(250);
	    allergiesHealthConcernsLabel.setLayoutY(160);
	    
	    Label immunizationHistoryLabel = new Label("Immunization History: " + patientImmunization);
	    immunizationHistoryLabel.setFont(new Font(12));
	    immunizationHistoryLabel.setLayoutX(250);
	    immunizationHistoryLabel.setLayoutY(190);
	    
	    Label patientHistoryLabel = new Label("Patient History: " + patientHistory);
	    patientHistoryLabel.setFont(new Font(12));
	    patientHistoryLabel.setLayoutX(250);
	    patientHistoryLabel.setLayoutY(220);
	    
	    Label prescriptionLabel = new Label("Prescription: " + patientPrescription);
	    prescriptionLabel.setFont(new Font(12));
	    prescriptionLabel.setLayoutX(250);
	    prescriptionLabel.setLayoutY(250);
	    
	    Label vitalsLabel = new Label("Vitals: " + patientVitals);
	    vitalsLabel.setFont(new Font(12));
	    vitalsLabel.setLayoutX(250);
	    vitalsLabel.setLayoutY(280);
	    
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(doctorView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton,contactLabel,emergencyContactLabel,allergiesHealthConcernsLabel,immunizationHistoryLabel,patientHistoryLabel,prescriptionLabel,vitalsLabel);
	    
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

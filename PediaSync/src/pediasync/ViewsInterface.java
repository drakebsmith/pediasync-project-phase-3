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
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


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
	
	int flag = 0;
	
	
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
		//fix
        
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
		
		if(flag == 1) {
			
	        patientContact = information.get(5);
	        patientEmergencyContact = information.get(6);
	        patientAllergiesHealthConcerns = information.get(7);
	        patientImmunization = information.get(8);
	        patientVitals = information.get(9);
	        patientPrescription = information.get(10);this.setScene(patientView());
		}
		else {
			this.setScene(patientView());
		}

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
	    
	    
	    
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(patientView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton,contactLabel,emergencyContactLabel,allergiesHealthConcernsLabel,immunizationHistoryLabel,patientHistoryLabel,prescriptionLabel);
	    
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
		
		if(flag == 1) {
			
	        patientContact = information.get(5);
	        patientEmergencyContact = information.get(6);
	        patientAllergiesHealthConcerns = information.get(7);
	        patientImmunization = information.get(8);
	        patientVitals = information.get(9);
	        patientPrescription = information.get(10);this.setScene(patientView());
		}
		else {
			this.setScene(nurseView());
		}

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
	    
	    TextField contactField = new TextField(patientContact);
	    contactField.setFont(new Font(12));
	    contactField.setLayoutX(250);
	    contactField.setLayoutY(100);
	    
	    TextField emergencyContactField = new TextField(patientEmergencyContact);
	    emergencyContactField.setFont(new Font(12));
	    emergencyContactField.setLayoutX(250);
	    emergencyContactField.setLayoutY(130);
	    
	    TextField vitalsField = new TextField(patientAllergiesHealthConcerns);
	    vitalsField.setFont(new Font(12));
	    vitalsField.setLayoutX(250);
	    vitalsField.setLayoutY(160);
	    
	    TextField allergiesHealthConcernsField = new TextField(patientAllergiesHealthConcerns);
	    allergiesHealthConcernsField.setFont(new Font(12));
	    allergiesHealthConcernsField.setLayoutX(250);
	    allergiesHealthConcernsField.setLayoutY(190);
	    
	    TextField immunizationHistoryField = new TextField(patientImmunization);
	    immunizationHistoryField.setFont(new Font(12));
	    immunizationHistoryField.setLayoutX(250);
	    immunizationHistoryField.setLayoutY(220);
	    
	    TextField patientHistoryField = new TextField(patientHistory);
	    patientHistoryField.setFont(new Font(12));
	    patientHistoryField.setLayoutX(250);
	    patientHistoryField.setLayoutY(250);
	    
	    
	    Label contactLabel = new Label("Contact: " + patientContact);
	    contactLabel.setFont(new Font(12));
	    contactLabel.setLayoutX(120);
	    contactLabel.setLayoutY(100);
	    
	    Label emergencyContactLabel = new Label("Emergency Contact: " + patientEmergencyContact);
	    emergencyContactLabel.setFont(new Font(12));
	    emergencyContactLabel.setLayoutX(120);
	    emergencyContactLabel.setLayoutY(130);
	    
	    Label vitalsLabel = new Label("Vitals: " + patientVitals);
	    vitalsLabel.setFont(new Font(12));
	    vitalsLabel.setLayoutX(120);
	    vitalsLabel.setLayoutY(160);
	    
	    Label allergiesHealthConcernsLabel = new Label("Allergies and Health Concerns: " + patientAllergiesHealthConcerns);
	    allergiesHealthConcernsLabel.setFont(new Font(12));
	    allergiesHealthConcernsLabel.setLayoutX(120);
	    allergiesHealthConcernsLabel.setLayoutY(190);
	    
	    Label immunizationHistoryLabel = new Label("Immunization History: " + patientImmunization);
	    immunizationHistoryLabel.setFont(new Font(12));
	    immunizationHistoryLabel.setLayoutX(120);
	    immunizationHistoryLabel.setLayoutY(220);
	    
	    Label patientHistoryLabel = new Label("Patient History: " + patientHistory);
	    patientHistoryLabel.setFont(new Font(12));
	    patientHistoryLabel.setLayoutX(120);
	    patientHistoryLabel.setLayoutY(250);
	    
	    
	    
	    
	    Button add = new Button("+");
	    add.setLayoutX(750);
	    add.setLayoutY(350);
	    add.setOnAction(e -> {
	        patientContact = contactField.getText();
	        patientEmergencyContact = emergencyContactField.getText();
	        patientVitals = vitalsField.getText();
	        patientAllergiesHealthConcerns = allergiesHealthConcernsField.getText();
	        patientImmunization = immunizationHistoryField.getText();
	        patientHistory = patientHistoryField.getText();
	        
	        
	        file.nurseWriteFile(username, patientContact, patientEmergencyContact, patientAllergiesHealthConcerns, patientImmunization, patientHistory, patientVitals);
	       
	    });
	    
	    
	    
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(nurseView());
	    });
	    
	    pane.getChildren().addAll(contactLabel,emergencyContactLabel,contactField,emergencyContactField,pediaSyncLabel,crossGroup,backButton,add,vitalsLabel,allergiesHealthConcernsLabel,immunizationHistoryLabel,patientHistoryLabel,vitalsField,allergiesHealthConcernsField,immunizationHistoryField,patientHistoryField);
	    
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
		
		if(flag == 1) {
			
	        patientContact = information.get(5);
	        patientEmergencyContact = information.get(6);
	        patientAllergiesHealthConcerns = information.get(7);
	        patientImmunization = information.get(8);
	        patientVitals = information.get(9);
	        patientPrescription = information.get(10);this.setScene(patientView());
		}
		else {
			this.setScene(doctorView());
		}

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
	    
	    TextField prescriptionField = new TextField(patientPrescription);
	    prescriptionField.setFont(new Font(12));
	    prescriptionField.setLayoutX(250);
	    prescriptionField.setLayoutY(100);
	    
	    Label prescriptionLabel = new Label("Prescription:");
	    prescriptionLabel.setFont(new Font(12));
	    prescriptionLabel.setLayoutX(250);
	    prescriptionLabel.setLayoutY(100);
	    
	    
	   
	    Button add = new Button("+");
	    add.setLayoutX(750);
	    add.setLayoutY(350);
	    add.setOnAction(e -> {
	        patientPrescription = prescriptionField.getText();
	        
	        flag = 1;
	        
	        file.doctorWriteFile(username, patientPrescription);
	       
	    });
	    
	    
	    
	    
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(doctorView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton,prescriptionLabel,prescriptionField,add);
	    
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

package pediasync;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;


public class ViewsInterface extends Stage
{
	private String username;
	
	//private ArrayList<String> information;
	
	String patientUsername = "";
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
	
	//String date = "4/9/2004";
	
	int counter = 0;
	
	
	private String nurseName = "";
	private String doctorLastName = "";
	
	public Filer file;
	
	
	

	
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
	
//--------------------------------------Patient View----------------------------------------//
	
	private Scene patientView() {
		
		file = new Filer();
		
		ArrayList<String> list = new ArrayList<String>();
		
		list = file.readFile(username, 0);
		
		patientName = list.get(2);
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
		
		file = new Filer();
		
		ArrayList<String> list = new ArrayList<String>();
		
		list = file.readFile(username, 1);

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
	    
	    Label contactLabel = new Label("Contact: ");
	    
	    contactLabel.setScaleX(1.5);
	    
	    contactLabel.setScaleY(1.5);
	    
	    contactLabel.setFont(new Font(12));
	    contactLabel.setLayoutX(334.5);
	    contactLabel.setLayoutY(75);
	    
	    Label emergencyContactLabel = new Label("Emergency Contact: ");
	    
	    emergencyContactLabel.setScaleX(1.5);
	    
	    emergencyContactLabel.setScaleY(1.5);
	    
	    emergencyContactLabel.setFont(new Font(12));
	    emergencyContactLabel.setLayoutX(257.5);
	    emergencyContactLabel.setLayoutY(115);
	    
	    Label vitalsLabel = new Label("Vitals: ");
	    
	    vitalsLabel.setScaleX(1.5);
	    
	    vitalsLabel.setScaleY(1.5);
	    
	    vitalsLabel.setFont(new Font(12));
	    vitalsLabel.setLayoutX(350);
	    vitalsLabel.setLayoutY(155);
	    
	    Label allergiesHealthConcernsLabel = new Label("Allergies & Health Concerns: ");
	    
	    allergiesHealthConcernsLabel.setScaleX(1.5);
	    
	    allergiesHealthConcernsLabel.setScaleY(1.5);
	    
	    allergiesHealthConcernsLabel.setFont(new Font(12));
	    allergiesHealthConcernsLabel.setLayoutX(200);
	    allergiesHealthConcernsLabel.setLayoutY(195);
	    
	    Label immunizationHistoryLabel = new Label("Immunization History: ");
	    
	    immunizationHistoryLabel.setScaleX(1.5);
	    
	    immunizationHistoryLabel.setScaleY(1.5);
	    
	    immunizationHistoryLabel.setFont(new Font(12));
	    immunizationHistoryLabel.setLayoutX(244);
	    immunizationHistoryLabel.setLayoutY(235);
	    
	    Label patientHistoryLabel = new Label("Patient History: ");
	    
	    patientHistoryLabel.setScaleX(1.5);
	    
	    patientHistoryLabel.setScaleY(1.5);
	    
	    patientHistoryLabel.setFont(new Font(12));
	    patientHistoryLabel.setLayoutX(289);
	    patientHistoryLabel.setLayoutY(275);
	    
	    Label prescriptionLabel = new Label("Prescription: ");
	    
	    prescriptionLabel.setScaleX(1.5);
	    
	    prescriptionLabel.setScaleY(1.5);
	    
	    prescriptionLabel.setFont(new Font(12));
	    prescriptionLabel.setLayoutX(308);
	    prescriptionLabel.setLayoutY(315);
	    
	    TextField contactField = new TextField(list.get(0));
	    contactField.setEditable(false);
	    contactField.setFont(new Font(12));
	    contactField.setLayoutX(400);
	    contactField.setLayoutY(73);
	    
	    TextField emergencyContactField = new TextField(list.get(1));
	    emergencyContactField.setEditable(false);
	    emergencyContactField.setFont(new Font(12));
	    emergencyContactField.setLayoutX(400);
	    emergencyContactField.setLayoutY(113);
	    
	    TextField vitalsField = new TextField(list.get(2));
	    vitalsField.setEditable(false);
	    vitalsField.setFont(new Font(12));
	    vitalsField.setLayoutX(400);
	    vitalsField.setLayoutY(153);
	    
	    TextField allergiesHealthConcernsField = new TextField(list.get(3));
	    allergiesHealthConcernsField.setEditable(false);
	    allergiesHealthConcernsField.setFont(new Font(12));
	    allergiesHealthConcernsField.setLayoutX(400);
	    allergiesHealthConcernsField.setLayoutY(193);
	    
	    TextField immunizationHistoryField = new TextField(list.get(4));
	    immunizationHistoryField.setEditable(false);
	    immunizationHistoryField.setFont(new Font(12));
	    immunizationHistoryField.setLayoutX(400);
	    immunizationHistoryField.setLayoutY(233);
	    
	    TextField patientHistoryField = new TextField(list.get(5));
	    patientHistoryField.setEditable(false);
	    patientHistoryField.setFont(new Font(12));
	    patientHistoryField.setLayoutX(400);
	    patientHistoryField.setLayoutY(273);
	    
	    TextField prescription = new TextField(list.get(6));
	    prescription.setEditable(false);
	    prescription.setFont(new Font(12));
	    prescription.setLayoutX(400);
	    prescription.setLayoutY(313);
	    
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(patientView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton,contactLabel,emergencyContactLabel, vitalsLabel, allergiesHealthConcernsLabel,immunizationHistoryLabel,patientHistoryLabel,prescriptionLabel, contactField, emergencyContactField, vitalsField, allergiesHealthConcernsField, immunizationHistoryField, patientHistoryField, prescription);
	    
	    return new Scene(pane, 800, 400);
	    
	}

	// This is the messaging portal class for the patient. It uses a ListView object to
	// display the conversation to the user. The user can send and read new messages here.
	// Conversation data is saved in a text file.
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

		// Scrollable list of the messages
		ListView<String> messageListView = new ListView<>();
		messageListView.setLayoutX(20);
		messageListView.setLayoutY(60);
		messageListView.setPrefSize(760, 280);

		// Text field to send a new message
		TextField messageInputField = new TextField();
		messageInputField.setLayoutX(20.0);
		messageInputField.setLayoutY(350);
		messageInputField.setPrefWidth(760);

		// read in the messaging file
		Filer myFiler = new Filer();

		messageListView.setItems(FXCollections.observableArrayList(myFiler.readMessagingFile(username)));

		//set on action of pressing enter to "send" the message
		messageInputField.setOnAction(event -> {
			String text = messageInputField.getText();
			String message = "Patient: " + text;

			myFiler.writeMessagingFile(username, message);

			messageInputField.clear();
			messageListView.setItems(FXCollections.observableArrayList(myFiler.readMessagingFile(username)));

		});

		pane.getChildren().addAll(pediaSyncLabel, crossGroup, backButton, messageListView, messageInputField);

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
	    
	    
	    Label visitSummaryLabel = new Label(": " + visitSummary);
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
		
		ArrayList<String> list = new ArrayList<String>();
		
		list = file.readFile(username, 0);
		
		nurseName = list.get(3);
		
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
	    Button patientPortalMessagesButton = new Button("Patient Portal Messages");
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
	    
	    TextField patientUsernameField = new TextField();
	    patientUsernameField.setFont(new Font(12));
	    patientUsernameField.setLayoutX(400);
	    patientUsernameField.setLayoutY(73);
	    
	    TextField contactField = new TextField();
	    contactField.setFont(new Font(12));
	    contactField.setLayoutX(400);
	    contactField.setLayoutY(113);
	    
	    TextField emergencyContactField = new TextField();
	    emergencyContactField.setFont(new Font(12));
	    emergencyContactField.setLayoutX(400);
	    emergencyContactField.setLayoutY(153);
	    
	    TextField vitalsField = new TextField();
	    vitalsField.setFont(new Font(12));
	    vitalsField.setLayoutX(400);
	    vitalsField.setLayoutY(193);
	    
	    TextField allergiesHealthConcernsField = new TextField();
	    allergiesHealthConcernsField.setFont(new Font(12));
	    allergiesHealthConcernsField.setLayoutX(400);
	    allergiesHealthConcernsField.setLayoutY(233);
	    
	    TextField immunizationHistoryField = new TextField();
	    immunizationHistoryField.setFont(new Font(12));
	    immunizationHistoryField.setLayoutX(400);
	    immunizationHistoryField.setLayoutY(273);
	    
	    TextField patientHistoryField = new TextField();
	    patientHistoryField.setFont(new Font(12));
	    patientHistoryField.setLayoutX(400);
	    patientHistoryField.setLayoutY(313);
	    
	    Label patient_username = new Label("Patient Username: ");
	    
	    patient_username.setScaleX(1.5);
	    
	    patient_username.setScaleY(1.5);
	    
	    patient_username.setFont(new Font(12));
	    
	    patient_username.setLayoutX(268.5);
	    
	    patient_username.setLayoutY(75);
	    
	    Label contactLabel = new Label("Contact: ");
	    
	    contactLabel.setScaleX(1.5);
	    
	    contactLabel.setScaleY(1.5);
	    
	    contactLabel.setFont(new Font(12));
	    contactLabel.setLayoutX(334.5);
	    contactLabel.setLayoutY(115);
	    
	    Label emergencyContactLabel = new Label("Emergency Contact: ");
	    
	    emergencyContactLabel.setScaleX(1.5);
	    
	    emergencyContactLabel.setScaleY(1.5);
	    
	    emergencyContactLabel.setFont(new Font(12));
	    emergencyContactLabel.setLayoutX(257.5);
	    emergencyContactLabel.setLayoutY(155);
	    
	    Label vitalsLabel = new Label("Vitals: " + patientVitals);
	    
	    vitalsLabel.setScaleX(1.5);
	    
	    vitalsLabel.setScaleY(1.5);
	    
	    vitalsLabel.setFont(new Font(12));
	    vitalsLabel.setLayoutX(350);
	    vitalsLabel.setLayoutY(195);
	    
	    Label allergiesHealthConcernsLabel = new Label("Allergies & Health Concerns: ");
	    
	    allergiesHealthConcernsLabel.setScaleX(1.5);
	    
	    allergiesHealthConcernsLabel.setScaleY(1.5);
	    
	    allergiesHealthConcernsLabel.setFont(new Font(12));
	    allergiesHealthConcernsLabel.setLayoutX(200);
	    allergiesHealthConcernsLabel.setLayoutY(235);
	    
	    Label immunizationHistoryLabel = new Label("Immunization History: ");
	    
	    immunizationHistoryLabel.setScaleX(1.5);
	    
	    immunizationHistoryLabel.setScaleY(1.5);
	    
	    immunizationHistoryLabel.setFont(new Font(12));
	    immunizationHistoryLabel.setLayoutX(244);
	    immunizationHistoryLabel.setLayoutY(275);
	    
	    Label patientHistoryLabel = new Label("Patient History: ");
	    
	    patientHistoryLabel.setScaleX(1.5);
	    
	    patientHistoryLabel.setScaleY(1.5);
	    
	    patientHistoryLabel.setFont(new Font(12));
	    patientHistoryLabel.setLayoutX(289);
	    patientHistoryLabel.setLayoutY(315);
	    
	    Button save = new Button("Save");
	    save.setLayoutX(700);
	    save.setLayoutY(350);
	    save.setPrefSize(75, 30);
	    save.setOnAction(e -> 
	    {	
	    	file = new Filer();
	    	
	    	int i = 0;
	    	
	    	String patient_username_text = patientUsernameField.getText();
	    	
	    	String contact_text = contactField.getText();
	    	
	    	String emergency_contact_text = emergencyContactField.getText();
	    	
	    	String vitals_text = vitalsField.getText();
	    	
	    	String allergies_text = allergiesHealthConcernsField.getText();
	    	
	    	String immunization_text = immunizationHistoryField.getText();
	    	
	    	String history_text = patientHistoryField.getText();
	    	
	    	if(!(patient_username_text.isEmpty() && file.checkUsername(patient_username_text) == 1)) 
	    	{
	    		i++;
	    	}
	    	if(!(contact_text.isEmpty())) 
	    	{
	    		i++;
	    	}
	    	if(!(emergency_contact_text.isEmpty())) 
	    	{
	    		i++;
	    	}
	    	if(!(vitals_text.isEmpty())) 
	    	{
	    		i++;
	    	}
	    	if(!(allergies_text.isEmpty())) 
	    	{
	    		i++;
	    	}
	    	if(!(immunization_text.isEmpty())) 
	    	{
	    		i++;
	    	}
	    	if(!(history_text.isEmpty())) 
	    	{
	    		i++;
	    	}
	    	if(i == 7) 
	    	{
	    		ArrayList<String> list = new ArrayList<String>();
	    		
	    		list = file.readFile(patient_username_text, 0);
	    		
	    		Collections.addAll(list, contact_text, emergency_contact_text, vitals_text, allergies_text, immunization_text, history_text);
	    		
	    		file.writeFile(patient_username_text, list);
	    		
	    		counter++;
	    		
	    		this.setScene(nurseView());
	    	}
	    	else 
	    	{
	    		// Error handling; follow the code I wrote in LoginInterface()
	    	}
	    });
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> 
	    {
	        this.setScene(nurseView());
	    });
	    
	    pane.getChildren().addAll(patient_username, patientUsernameField,contactLabel,emergencyContactLabel,contactField,emergencyContactField,pediaSyncLabel,crossGroup,backButton,save,vitalsLabel,allergiesHealthConcernsLabel,immunizationHistoryLabel,patientHistoryLabel,vitalsField,allergiesHealthConcernsField,immunizationHistoryField,patientHistoryField);
	    
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


	// This is the nurse messaging portal class. It asks the user for the patient ID
	// that they want to message, searches for the message history and displays it to the user
	// Finally, there is a text field where the user can send messages with at the bottom.
	private Scene nurse_portalMessagesScene() {
		Pane pane = new Pane();

		Label promptLabel = new Label("Enter the patient ID to be messaged: ");
		promptLabel.setFont(new Font(18));
		promptLabel.setLayoutX(100);
		promptLabel.setLayoutY(50);

		TextField idInput = new TextField();
		idInput.setLayoutX(100);
		idInput.setLayoutY(80);
		idInput.setPrefWidth(200);

		Button submitButton = new Button("Submit");
		submitButton.setFont(new Font(14));
		submitButton.setLayoutX(600);
		submitButton.setLayoutY(80);

		Button backButton = new Button("<-");
		backButton.setFont(new Font(12));
		backButton.setLayoutX(750);
		backButton.setLayoutY(20);
		backButton.setOnAction(e -> {
			this.setScene(patientView());
		});

		pane.getChildren().addAll(promptLabel, idInput, submitButton, backButton);


		submitButton.setOnAction(f -> {
					String patient_username = idInput.getText();
					pane.getChildren().clear();

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

					ListView<String> messageListView = new ListView<>();
					messageListView.setLayoutX(20);
					messageListView.setLayoutY(60);
					messageListView.setPrefSize(760, 280);

					TextField messageInputField = new TextField();
					messageInputField.setLayoutX(20.0);
					messageInputField.setLayoutY(350);
					messageInputField.setPrefWidth(760);

					Filer myFiler = new Filer();
					messageListView.setItems(FXCollections.observableArrayList(myFiler.readMessagingFile(patient_username)));

					messageInputField.setOnAction(event -> {
						String text = messageInputField.getText();
						String message = "Nurse: " + text;

						myFiler.writeMessagingFile(patient_username, message);

						messageInputField.clear();
						messageListView.setItems(FXCollections.observableArrayList(myFiler.readMessagingFile(patient_username)));

					});
			pane.getChildren().addAll(pediaSyncLabel, crossGroup, backButton, messageListView, messageInputField);
		});

		return new Scene(pane, 800, 400);
	}


	
//--------------------------------------Nurse View----------------------------------------//
	
//--------------------------------------Doctor View----------------------------------------//

	private Scene doctorView() {
		
		//file = new Filer();
		
		//information = file.readFile(username);
		
		//doctorLastName = information.get(3);
		
		file = new Filer();
		
		ArrayList<String> list = new ArrayList<String>();
		
		list = file.readFile(username, 0);
		
		doctorLastName = list.get(3);

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
		
		/*f(flag == 1) {
			
	        patientContact = information.get(5);
	        patientEmergencyContact = information.get(6);
	        patientAllergiesHealthConcerns = information.get(7);
	        patientImmunization = information.get(8);
	        patientVitals = information.get(9);
	        patientPrescription = information.get(10);this.setScene(patientView());
		}
		else {
			this.setScene(doctorView());
		}*/

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
	    
	    TextField patientUsernameField = new TextField();
	    patientUsernameField.setFont(new Font(12));
	    patientUsernameField.setLayoutX(400);
	    patientUsernameField.setLayoutY(73);
	    
	    Label patient_username = new Label("Patient Username: ");
	    
	    patient_username.setScaleX(1.5);
	    
	    patient_username.setScaleY(1.5);
	    
	    patient_username.setFont(new Font(12));
	    
	    patient_username.setLayoutX(268.5);
	    
	    patient_username.setLayoutY(75);
	    
	    TextField prescriptionField = new TextField();
	    prescriptionField.setFont(new Font(12));
	    prescriptionField.setLayoutX(400);
	    prescriptionField.setLayoutY(113);
	    
	    Label prescriptionLabel = new Label("Prescription: ");
	    
	    prescriptionLabel.setScaleX(1.5);
	    
	    prescriptionLabel.setScaleY(1.5);
	    
	    prescriptionLabel.setFont(new Font(12));
	    prescriptionLabel.setLayoutX(307);
	    prescriptionLabel.setLayoutY(115);
	    
	    
	   
	    Button save = new Button("Save");
	    save.setLayoutX(700);
	    save.setLayoutY(350);
	    save.setPrefSize(75, 30);
	    save.setOnAction(e -> 
	    {
	    	file = new Filer();
	    	
	    	int i = 0;
	    	
	    	String patient_username_text = patientUsernameField.getText();
	    	
	    	String prescription_text = prescriptionField.getText();
	    	
	    	if(!(patient_username_text.isEmpty() && file.checkUsername(patient_username_text) == 1)) 
	    	{
	    		i++;
	    	}
	    	if(!(prescription_text.isEmpty())) 
	    	{
	    		i++;
	    	}
	    	if(i == 2) 
	    	{
	    		ArrayList<String> list = new ArrayList<String>();
	    		
	    		list = file.readFile(patient_username_text, 2);
	    		
	    		Collections.addAll(list, prescription_text);
	    		
	    		file.writeFile(patient_username_text, list);
	    		
	    		counter++;
	    		
	    		this.setScene(doctorView());
	    	}
	    	else 
	    	{
	    		// Error handling; follow the code I wrote in LoginInterface()
	    	}
	    });
	    
	    Button backButton = new Button("<-");
	    backButton.setFont(new Font(12));
	    backButton.setLayoutX(20);
	    backButton.setLayoutY(350);
	    backButton.setOnAction(e -> {
	        this.setScene(doctorView());
	    });
	    
	    pane.getChildren().addAll(pediaSyncLabel,crossGroup,backButton,patientUsernameField, patient_username, prescriptionLabel,prescriptionField, save);
	    
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
	    
	    
	    Label visitSummaryLabel = new Label(": " + visitSummary);
	    visitSummaryLabel.setFont(new Font(12));
	    visitSummaryLabel.setLayoutX(100);
	    visitSummaryLabel.setLayoutY(100);
	    
	    TextArea summary = new TextArea();
        summary.setEditable(false);
        summary.setWrapText(true);
        summary.setPrefHeight(200);
        summary.setPrefWidth(500);
        summary.setLayoutX(200);
        summary.setLayoutY(100);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(username + "_VisitSummary.txt"));
            String summaryFile = reader.readLine();
            summary.setText(summaryFile);
        }
        catch (IOException e) {
            e.setStackTrace(null);
        }
	    
	    Button addVisitSummaryButton = new Button("+");
	    addVisitSummaryButton.setLayoutX(750);
	    addVisitSummaryButton.setLayoutY(350);
	    
	    TextArea notes = new TextArea();
        notes.setWrapText(true);
        notes.setPrefHeight(200);
        notes.setPrefWidth(500);
        notes.setLayoutX(200);
        notes.setLayoutY(100);

        TextArea checkUsername = new TextArea();
        checkUsername.setLayoutX(200);
        checkUsername.setLayoutY(50);
        checkUsername.setPrefHeight(1);

        addVisitSummaryButton.setOnAction(e -> {
            try {
                String u = checkUsername.getText();
                Filer filer = new Filer();
                if (filer.checkUsername(u) == 1) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(u + "_VisitSummary"));
                    writer.write(notes.getText());
                    writer.close();
                }
                else
                    checkUsername.clear();
            }
            catch(IOException error) {
                error.printStackTrace();
            }

        }); 

	    
	    
	    
	    
	    
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


	// This is the messaging portal class for the doctor. It is nearly identical to the Nurse one
	private Scene doctor_portalMessagesScene() {
		Pane pane = new Pane();

		Label promptLabel = new Label("Enter the patient ID to be messaged: ");
		promptLabel.setFont(new Font(18));
		promptLabel.setLayoutX(100);
		promptLabel.setLayoutY(50);

		TextField idInput = new TextField();
		idInput.setLayoutX(100);
		idInput.setLayoutY(80);
		idInput.setPrefWidth(200);

		Button submitButton = new Button("Submit");
		submitButton.setFont(new Font(14));
		submitButton.setLayoutX(600);
		submitButton.setLayoutY(80);

		Button backButton = new Button("<-");
		backButton.setFont(new Font(12));
		backButton.setLayoutX(750);
		backButton.setLayoutY(20);
		backButton.setOnAction(e -> {
			this.setScene(patientView());
		});

		pane.getChildren().addAll(promptLabel, idInput, submitButton, backButton);


		submitButton.setOnAction(f -> {
			String patient_username = idInput.getText();
			pane.getChildren().clear();

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

			ListView<String> messageListView = new ListView<>();
			messageListView.setLayoutX(20);
			messageListView.setLayoutY(60);
			messageListView.setPrefSize(760, 280);

			TextField messageInputField = new TextField();
			messageInputField.setLayoutX(20.0);
			messageInputField.setLayoutY(350);
			messageInputField.setPrefWidth(760);

			Filer myFiler = new Filer();
			messageListView.setItems(FXCollections.observableArrayList(myFiler.readMessagingFile(patient_username)));

			messageInputField.setOnAction(event -> {
				String text = messageInputField.getText();
				String message = "Doctor: " + text;

				myFiler.writeMessagingFile(patient_username, message);

				messageInputField.clear();
				messageListView.setItems(FXCollections.observableArrayList(myFiler.readMessagingFile(patient_username)));

			});
			pane.getChildren().addAll(pediaSyncLabel, crossGroup, backButton, messageListView, messageInputField);
		});

		return new Scene(pane, 800, 400);
	}
	
	
	
//--------------------------------------Doctor View----------------------------------------//
}

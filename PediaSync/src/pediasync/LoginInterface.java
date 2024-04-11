package pediasync;

import java.util.ArrayList;
import java.util.Random;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

// Class for handling the sign in and sign up processes
public class LoginInterface extends Stage
{
	private static final int WIDTH = 600;
	
	private static final int HEIGHT = 400;
	
	private String username;
	
	private String password;
	
	private String first_name;
	
	private String last_name;
	
	private String date_of_birth;
	
	private int id;
	
	public Filer file;
	
	// Method for create a five-digit unique ID for the user upon account creation
	private int createID(int flag) 
	{
		Random random_number = new Random();
		
		if(flag == 0) 
		{
			return (10000 + random_number.nextInt(10000));
		}
		else if(flag == 1) 
		{
			return (20000 + random_number.nextInt(10000));
		}
		else
		{
			return(30000 + random_number.nextInt(10000));
		}
	}
	
	// Method that calls the Filer class to create users' system files
	private void createAccount() 
	{
		file = new Filer();
		
		file.createFile(String.valueOf(id), password, first_name, last_name, date_of_birth, username);
	}
	
	// Method for implementing the GUI and its functionality
	public LoginInterface()
	{
		Pane pane = new Pane();
		
		Line line = new Line(275, 0, 275, 400);
		
		Rectangle cross_vertical = new Rectangle(60, 150, 25, 75);
		
		cross_vertical.setFill(Color.RED);
		
		Rectangle cross_horizontal = new Rectangle(35, 175, 75, 25);
		
		cross_horizontal.setFill(Color.RED);
		
		Text name = new Text("PediaSync");
		
		name.setScaleX(2);
		
		name.setScaleY(2);
		
		name.setLayoutX(150);
		
		name.setLayoutY(190);
		
		Group left_side = new Group(line, cross_vertical, cross_horizontal, name);
		
		Text username_text = new Text("Username:");
		
		username_text.setScaleX(1.75);
		
		username_text.setScaleY(1.75);
		
		username_text.setLayoutX(410);
		
		username_text.setLayoutY(75);
		
		TextField username_input = new TextField();
		
		username_input.setLayoutX(365);
		
		username_input.setLayoutY(100);
		
		username_input.setPromptText("Username");
		
		Text password_text = new Text("Password:");
		
		password_text.setScaleX(1.75);
		
		password_text.setScaleY(1.75);
		
		password_text.setLayoutX(410);
		
		password_text.setLayoutY(155);
		
		TextField password_input = new TextField();
		
		password_input.setLayoutX(365);
		
		password_input.setLayoutY(180);
		
		password_input.setPromptText("Password");
		
		Text error = new Text();
		
		error.setScaleX(1);
		
		error.setScaleY(1);
		
		error.setLayoutX(282);
		
		error.setLayoutY(365);
		
		error.setFill(Color.RED);
		
		Button sign_in = new Button("Sign In");
		
		sign_in.setLayoutX(387);
		
		sign_in.setLayoutY(235);
		
		sign_in.setPrefSize(100, 30);
		
		sign_in.setOnAction(e -> 
		{	
			file = new Filer();
			
			String entered_username = username_input.getText();
			
			String entered_password = password_input.getText();
			
			int i = 0;
			
			if(!(entered_username.isEmpty())) 
			{	
				i++;
			}
			if(!(entered_password.isEmpty()) && file.authenticate(entered_username, 1).equals(entered_password)) 
			{
				i++;
			}
			username_input.clear();
			
			password_input.clear();
			
			if(i == 2) 
			{	
				ArrayList<String> user_id = file.readFile(entered_username);
				
				char identifier = user_id.get(0).charAt(0);
				
				String view = "";
				
				if(identifier == '1')
				{
					view = "Patient View";
				}
				if(identifier == '2')
				{
					view = "Nurse View";
				}
				if(identifier == '3') 
				{
					view = "Doctor View";
				}
				pane.getChildren().remove(error);
				
				this.hide();
				
				new ViewsInterface(view, entered_username);
			}
			else 
			{
				error.setText("Error: at least one field is empty or username does not exist");
				
				pane.getChildren().add(error);
			}
		});
		
		Button sign_up = new Button("Sign Up");
		
		sign_up.setLayoutX(387);
		
		sign_up.setLayoutY(300);
		
		sign_up.setPrefSize(100, 30);
		
		Group right_side = new Group(username_text, username_input, password_text, password_input, sign_in, sign_up);
		
		pane.getChildren().addAll(left_side, right_side);
		
		this.setTitle("Login");
		
		sign_up.setOnAction(e -> 
		{	
			right_side.getChildren().clear();
				
			Text first_name_text = new Text("First Name:");
				
			first_name_text.setScaleX(1.75);
				
			first_name_text.setScaleY(1.75);
				
			first_name_text.setLayoutX(408);
				
			first_name_text.setLayoutY(75);
				
			TextField first_name_input = new TextField();
				
			first_name_input.setLayoutX(365);
				
			first_name_input.setLayoutY(100);
				
			first_name_input.setPromptText("First name");
				
			Text last_name_text = new Text("Last Name:");
				
			last_name_text.setScaleX(1.75);
				
			last_name_text.setScaleY(1.75);
				
			last_name_text.setLayoutX(408);
				
			last_name_text.setLayoutY(155);
				
			TextField last_name_input = new TextField();
				
			last_name_input.setLayoutX(365);
				
			last_name_input.setLayoutY(180);
				
			last_name_input.setPromptText("Last name");
				
			Text date_of_birth_text = new Text("Date of Birth:");
				
			date_of_birth_text.setScaleX(1.75);
				
			date_of_birth_text.setScaleY(1.75);
				
			date_of_birth_text.setLayoutX(403);
				
			date_of_birth_text.setLayoutY(235);
				
			TextField date_of_birth_input = new TextField();
				
			date_of_birth_input.setLayoutX(365);
				
			date_of_birth_input.setLayoutY(260);
				
			date_of_birth_input.setPromptText("mm/dd/yyyy");
			
			Button next = new Button("Next");
			
			next.setLayoutX(388);
				
			next.setLayoutY(315);
				
			next.setPrefSize(100, 30);
			
			ToggleGroup user_type = new ToggleGroup();
			
			RadioButton patient_button = new RadioButton("Patient");
			
			patient_button.setToggleGroup(user_type);
			
			patient_button.setLayoutX(405);
			
			patient_button.setLayoutY(220);
			
			RadioButton nurse_button = new RadioButton("Nurse");
			
			nurse_button.setToggleGroup(user_type);
			
			nurse_button.setLayoutX(405);
			
			nurse_button.setLayoutY(250);
			
			RadioButton doctor_button = new RadioButton("Doctor");
			
			doctor_button.setToggleGroup(user_type);
			
			doctor_button.setLayoutX(405);
			
			doctor_button.setLayoutY(280);
			
			Group radiobuttons = new Group(patient_button, nurse_button, doctor_button);
				
			Button create_account = new Button("Create Account");
				
			create_account.setLayoutX(388);
				
			create_account.setLayoutY(315);
				
			create_account.setPrefSize(100, 30);
			
			right_side.getChildren().addAll(first_name_text, first_name_input, last_name_text, last_name_input, date_of_birth_text, date_of_birth_input, next);
			
			this.setTitle("Sign Up");
			
			next.setOnAction(r -> 
			{
				int i = 0;
				
				String entered_first_name = first_name_input.getText();
				
				String entered_last_name = last_name_input.getText();
				
				String entered_date_of_birth = date_of_birth_input.getText();
				
				if(!(entered_first_name.isEmpty())) 
				{
					first_name = entered_first_name;
					
					i++;
				}						
				if(!(entered_last_name.isEmpty())) 
				{
					last_name = entered_last_name;
					
					i++;
				}
				if(!(entered_date_of_birth.isEmpty())) 
				{
					date_of_birth = entered_date_of_birth;
					
					i++;
				}
				first_name_input.clear();
				
				last_name_input.clear();
				
				date_of_birth_input.clear();
				
				if(i == 3) 
				{
					pane.getChildren().remove(error);
					
					right_side.getChildren().clear();
					
					right_side.getChildren().addAll(username_text, username_input, password_text, password_input, radiobuttons, create_account);
					
					create_account.setOnAction(t ->
					{
						file = new Filer();
						
						int j = 0;
						
						int flag = 0;
						
						String entered_username = username_input.getText();
						
						String entered_password = password_input.getText();
						
						if(!(entered_username.isEmpty()) && file.checkUsername(entered_username) == 0) 
						{
							username = entered_username;
							
							j++;
						}
						if(!(entered_password.isEmpty())) 
						{
							password = entered_password;
							
							j++;
						}
						if(patient_button.isSelected()) 
						{
							flag = 0;
							
							j++;
						}
						if(nurse_button.isSelected()) 
						{
							flag = 1;
							
							j++;
						}
						if(doctor_button.isSelected()) 
						{
							flag = 2;
							
							j++;
						}
						username_input.clear();
						
						password_input.clear();
						
						user_type.selectToggle(null);
						
						if(j == 3) 
						{
							pane.getChildren().remove(error);
							
							id = createID(flag);
							
							createAccount();
							
							right_side.getChildren().clear();
							
							right_side.getChildren().addAll(username_text, username_input, password_text, password_input, sign_in, sign_up);
							
							this.setTitle("Login");
						}
						else 
						{
							error.setLayoutX(295);
							
							error.setLayoutY(375);
							
							error.setText("Error: at least one is empty or username already exists");
							
							pane.getChildren().add(error);
						}
					});
				}
				else 
				{
					error.setLayoutX(355);
					
					error.setLayoutY(375);
					
					error.setText("Error: at least one field is empty");
					
					pane.getChildren().add(error);
				}
			});
			
		});
		
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		
		this.setScene(scene);
		
		this.show();
	}
}

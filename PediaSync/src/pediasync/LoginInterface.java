package pediasync;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class LoginInterface extends Stage
{
	private static final int WIDTH = 600;
	
	private static final int HEIGHT = 400;
	
	private String username;
	
	private String password;
	
	private String first_name;
	
	private String last_name;
	
	private String date_of_birth;
	
	public Filer file;
	
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
		
		Button sign_in = new Button("Sign In");
		
		sign_in.setLayoutX(387);
		
		sign_in.setLayoutY(235);
		
		sign_in.setPrefSize(100, 30);
		
		sign_in.setOnAction(e -> {
			
			if(!(username_input.getText().isEmpty())) 
			{
				username = username_input.getText();
			}
			if(!(password_input.getText().isEmpty())) 
			{
				password = password_input.getText();
			}
		});
		
		Button sign_up = new Button("Sign Up");
		
		sign_up.setLayoutX(387);
		
		sign_up.setLayoutY(300);
		
		sign_up.setPrefSize(100, 30);
		
		Group right_side = new Group(username_text, username_input, password_text, password_input, sign_in, sign_up);
		
		pane.getChildren().addAll(left_side, right_side);
		
		sign_up.setOnAction(e -> {
			
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
				
			Button create_account = new Button("Create Account");
				
			create_account.setLayoutX(388);
				
			create_account.setLayoutY(315);
				
			create_account.setPrefSize(100, 30);
			
			right_side.getChildren().addAll(first_name_text, first_name_input, last_name_text, last_name_input, date_of_birth_text, date_of_birth_input, create_account);
				
			create_account.setOnAction(a -> 
			{
				right_side.getChildren().clear();
				
				right_side.getChildren().addAll(username_text, username_input, password_text, password_input, sign_in, sign_up);
				
				int count = 0;
				
				if(!(first_name_input.getText().isEmpty())) 
				{
					first_name = first_name_input.getText();
					
					count++;
				}						
				if(!(last_name_input.getText().isEmpty())) 
				{
					last_name = last_name_input.getText();
					
					count++;
				}
				if(!(date_of_birth_input.getText().isEmpty())) 
				{
					date_of_birth = date_of_birth_input.getText();
					
					count++;
				}
				if(count == 3) 
				{
					System.out.println("Count: " + count);
					
					createAccount();
				}
			});
		});
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		
		this.setScene(scene);
		
		this.show();
	}
	public void createAccount() 
	{
		file = new Filer();
		
		file.createFile(first_name, last_name, date_of_birth);
	}
}

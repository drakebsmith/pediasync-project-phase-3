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
	
	public LoginInterface()
	{
		System.out.println("It worked!");
		
		this.setTitle("Tester");
		
		Pane pane = new Pane();
		
		Scene scene = new Scene(pane, 600, 400);
		
		this.setScene(scene);
		
		this.show();
		
		Button test = new Button("Sign In");
		
		test.setLayoutX(387);
		
		test.setLayoutY(235);
		
		test.setPrefSize(100, 30);
		
		pane.getChildren().add(test);
		
		test.setOnAction(e -> {});
		
		/*Line line = new Line(275, 0, 275, 400);
		
		Rectangle crossVertical = new Rectangle(60, 150, 25, 75);
		
		crossVertical.setFill(Color.RED);
		
		Rectangle crossHorizontal = new Rectangle(35, 175, 75, 25);
		
		crossHorizontal.setFill(Color.RED);
		
		Text name = new Text("PediaSync");
		
		name.setScaleX(2);
		
		name.setScaleY(2);
		
		name.setLayoutX(150);
		
		name.setLayoutY(190);
		
		Group left_side = new Group(line, crossVertical, crossHorizontal, name);
		
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
		
		sign_in.setOnAction(new EventHandler<ActionEvent>() 
		{
			public void handle(ActionEvent event) 
			{
				if(!(username_input.getText().isEmpty())) 
				{
				}
				if(!(password_input.getText().isEmpty())) 
				{
				}
			}
		});
		Button sign_up = new Button("Sign Up");
		
		sign_up.setLayoutX(387);
		
		sign_up.setLayoutY(300);
		
		sign_up.setPrefSize(100, 30);
		
		Group right_side = new Group(username_text, username_input, password_text, password_input, sign_in, sign_up);
		
		pane.getChildren().addAll(left_side, right_side);
		
		sign_up.setOnAction(new EventHandler<ActionEvent>() 
		{
			public void handle(ActionEvent event) 
			{	
				right_side.getChildren().clear();
				
				Text first_name_text = new Text("First Name:");
				
				first_name_text.setScaleX(1.5);
				
				first_name_text.setScaleY(1.5);
				
				first_name_text.setLayoutX(415);
				
				first_name_text.setLayoutY(35);
				
				TextField first_name_input = new TextField();
				
				first_name_input.setLayoutX(370);
				
				first_name_input.setLayoutY(55);
				
				first_name_input.setPromptText("First name");
				
				Text last_name_text = new Text("Last Name:");
				
				last_name_text.setScaleX(1.5);
				
				last_name_text.setScaleY(1.5);
				
				last_name_text.setLayoutX(415);
				
				last_name_text.setLayoutY(110);
				
				TextField last_name_input = new TextField();
				
				last_name_input.setLayoutX(370);
				
				last_name_input.setLayoutY(130);
				
				last_name_input.setPromptText("Last name");
				
				Text date_of_birth_text = new Text("Date of Birth:");
				
				date_of_birth_text.setScaleX(1.5);
				
				date_of_birth_text.setScaleY(1.5);
				
				date_of_birth_text.setLayoutX(410);
				
				date_of_birth_text.setLayoutY(185);
				
				TextField date_of_birth_input = new TextField();
				
				date_of_birth_input.setLayoutX(370);
				
				date_of_birth_input.setLayoutY(205);
				
				date_of_birth_input.setPromptText("mm/dd/yyyy");
				
				Button create_account = new Button("Create Account");
				
				create_account.setLayoutX(395);
				
				create_account.setLayoutY(255);
				
				create_account.setPrefSize(100, 30);
				
				create_account.setOnAction(new EventHandler<ActionEvent>() 
				{
					public void handle(ActionEvent event) 
					{
						if(!(first_name_input.getText().isEmpty())) 
						{
						}
						if(!(last_name_input.getText().isEmpty())) 
						{
						}
						if(!(date_of_birth_input.getText().isEmpty())) 
						{
						}
					}
				});
				right_side.getChildren().addAll(first_name_text, first_name_input, last_name_text, last_name_input, date_of_birth_text, date_of_birth_input, create_account);
			}
		});*/
	}
}

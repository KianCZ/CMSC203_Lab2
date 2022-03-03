package dataElement;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	Button b1,b2,b3,b4,b5;
	HBox h1,h2;
	Label label;
	TextField text1;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager d;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		b1=new Button("Hello");
		b2=new Button("Howdy");
		b3=new Button("Chinese");
		b4=new Button("Clear");
		b5=new Button("Exit");
		label = new Label("Feedback");
		h1=new HBox();
		h2=new HBox();
		text1=new TextField();
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		d=new DataManager();
		h1.setAlignment(Pos.CENTER);
		h1.setMargin(b1, new Insets(10,10,10,10));
		h1.setMargin(b2, new Insets(20,20,20,20));
		h1.setMargin(b3, new Insets(30,30,30,30));
		h1.setMargin(b4, new Insets(20,20,20,20));
		h1.setMargin(b5, new Insets(10,10,10,10));
		h2.setAlignment(Pos.CENTER);
		h2.setMargin(text1, new Insets(0,0,0,15));
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		h1.getChildren().addAll(b1,b2,b3,b4,b5);
		h2.getChildren().addAll(label,text1);
		getChildren().addAll(h1,h2);
		b1.setOnAction(new ButtonHandler());
		b2.setOnAction(new ButtonHandler());
		b3.setOnAction(new ButtonHandler());
		b4.setOnAction(new ButtonHandler());
		b5.setOnAction(new ButtonHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if (event.getTarget()==b1) {
				text1.setText(d.getHello());
			} else if(event.getTarget()==b3){
				text1.setText(d.getChinese());
			}else if(event.getTarget()==b2){
				text1.setText(d.getHowdy());
			}else if(event.getTarget()==b4){
				text1.clear();
			}else if(event.getTarget()==b5){
				Platform.exit();
				System.exit(0);
			}else{
				System.out.println("Not implemented yet");
			}
			
		}
		
	}
}

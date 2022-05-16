package Controle;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import Vue.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ControleurOptio {
	@FXML	
	private Button back;

	@FXML
	private Button close;

	@FXML
	private AnchorPane ecranOP;
	
	@FXML
	private Button Plae;
	
	@FXML
	private Button Poz;
	
	@FXML
	private Slider volu;
	
	@FXML
	private CheckBox AutoSav;
	
	public int volume;

	
	public boolean getAutoSav() {
		return this.AutoSav.isSelected();
	}
	public void initialize() {	
		
		volu.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number>arg0, Number arg1, Number arg2) {
				System.out.println(volu.getValue());
				Main.mediaplay.setVolume(volu.getValue());
			}
			
		});		
		
		Poz.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				Main.mediaplay.pause();				
			}
		});
		
		Plae.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				Main.mediaplay.play();
			}
		});
		
		
		
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println(AutoSav);
				((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
				Stage stage = new Stage();

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/PageOne.fxml"));

				Controleur controlleur = new Controleur();
				loader.setController(controlleur);	

				Parent root;
				try {
					root = loader.load();
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.setFullScreen(true);
					stage.show();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}});
		
		

		close.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {				
					System.exit(0);
System.out.println(AutoSav.isSelected());
				}

			});



		}
	}
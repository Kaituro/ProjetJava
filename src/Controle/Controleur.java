package Controle;

import java.io.IOException;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controleur {
	
	

	@FXML
	private Button play;
	
	@FXML
	private Button options;
	
	@FXML
	private Button howtoplay;
	

	@FXML
    private void initialize() {
	
		play.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("PageJeu.fxml"));
				
				Parent root;
				try {
					root = loader.load();
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				}catch (IOException e1){
					
					e1.printStackTrace();
				}
			}});
		
		options.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("pageoptions.fxml"));

                Parent root;
                try {
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }catch (IOException e1){

                    e1.printStackTrace();
                }
            }});

        howtoplay.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("pagehowtoplay.fxml"));

                Parent root;
                try {
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }catch (IOException e1){

                    e1.printStackTrace();
                }
	


         }});
	
	}
}




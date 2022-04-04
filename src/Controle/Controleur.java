package Controle;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Controleur{
	
	

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
				 
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/PageJeu.fxml"));

	                ControleurJeu cont = new ControleurJeu(); 
	                loader.setController(cont);
	                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	                    @Override
	                    public void handle(WindowEvent e) {
	                        stage.close();

	                    }
	                });	                
	                
	               
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
		
		options.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				 Stage stage = new Stage();

	                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/pageoptions.fxml"));
	                ControleurOptio controlleur = new ControleurOptio();
	    			loader.setController(controlleur);	
	               
	                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	                    @Override
	                    public void handle(WindowEvent e) {
	                        stage.close();

	                    }
	                });	                

	                Parent root;
	                try {
	                    root = loader.load();
	                    Scene scene = new Scene(root);
	                    stage.setScene(scene);
	                    stage.setFullScreen(true);
	                    stage.show();
	                } catch (IOException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }

				
			}});
		
		howtoplay.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				 Stage stage = new Stage();

	                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/pagehowtoplay.fxml"));

	                ControleurHowto conto = new ControleurHowto(); 
	                loader.setController(conto);
	                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	                    @Override
	                    public void handle(WindowEvent e) {
	                        stage.close();

	                    }
	                });	                

	                Parent root;
	                try {
	                    root = loader.load();
	                    Scene scene = new Scene(root);
	                    stage.setFullScreen(true);
	                    stage.setScene(scene);
	                    stage.show();
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                }

				
			}});
	}



	
}




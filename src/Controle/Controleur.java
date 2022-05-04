package Controle;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
	private AnchorPane ecran;
	
	Media media;
	MediaPlayer mediaplay;
	@FXML	
    private void initialize() {
	
		URL Song = getClass().getResource("/Vue/musique.mp3");
		media = new Media(Song.toString());
		mediaplay = new MediaPlayer(media);
		mediaplay.play();
		play.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
				 Stage stage = new Stage();
				 
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/PageJeu.fxml"));

	                ControleurJeu cont = new ControleurJeu(); 
	                loader.setController(cont);                                          
	               
	                Parent root;
	                try {
	                    root = loader.load();
	                    Scene scene = new Scene(root);
	        			scene.getStylesheets().add(getClass().getResource("/Vue/play.css").toExternalForm());	
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
				((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
				 Stage stage = new Stage();

	                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/pageoptions.fxml"));
	                ControleurOptio controlleur = new ControleurOptio();
	    			loader.setController(controlleur);	
	               
	                      

	                Parent root;
	                try {
	          
	                    root = loader.load();
	                    Scene scene = new Scene(root);
	        			scene.getStylesheets().add(getClass().getResource("/Vue/options.css").toExternalForm());	
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
				((Stage)(((Button)arg0.getSource()).getScene().getWindow())).close();
				 Stage stage = new Stage();

	                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/pagehowtoplay.fxml"));

	                ControleurHowto conto = new ControleurHowto(); 
	                loader.setController(conto);
	                Parent root;
	                try {
	                    root = loader.load();
	                    Scene scene = new Scene(root);
	        			scene.getStylesheets().add(getClass().getResource("/Vue/howtoplay.css").toExternalForm());	
	                    stage.setScene(scene);
	                    stage.setFullScreen(true);
	                    stage.show();
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                }

				
			}});
	}



	
}




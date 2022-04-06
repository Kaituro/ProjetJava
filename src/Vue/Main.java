package Vue;
	

import java.awt.Dimension;

import Controle.Controleur;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class Main extends Application {
	
	public static FXMLLoader loader;
	public static Scene scene;
	public static Parent root;
	@Override
	public void start(Stage primaryStage) {
		try {			
			loader = new FXMLLoader(getClass().getResource("PageOne.fxml"));
			Controleur controlleur = new Controleur();
			loader.setController(controlleur);		
			root = loader.load();			
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());					
			primaryStage.setScene(scene);			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

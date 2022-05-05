package Vue;
	

import java.awt.Dimension;
import java.net.URL;
import java.nio.file.Paths;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	
	public static FXMLLoader loader;
	public static Scene scene;
	public static Parent root;
	Media media;
	MediaPlayer mediaplay;
	@Override
	public void start(Stage primaryStage) {
		URL Song = getClass().getResource("/Vue/musique.mp3");
		media = new Media(Song.toString());
		mediaplay = new MediaPlayer(media);
		
		
		mediaplay.play();
		
		try {		
			loader = new FXMLLoader(getClass().getResource("PageOne.fxml"));
			Controleur controlleur = new Controleur();
			loader.setController(controlleur);		
			root = loader.load();			
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
			primaryStage.setScene(scene);	
			primaryStage.setFullScreen(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

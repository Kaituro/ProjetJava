package Controle;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ControleurHowto {

	@FXML
	private Button retour;	
	
	@FXML
	private AnchorPane ecranHow;
	
	
	public void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int longueur = screenSize.width;
		int largeur = screenSize.height;
		
		ecranHow.setPrefSize(longueur, largeur-70);
		retour.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				 Stage stage = new Stage();
				 
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vue/PageOne.fxml"));

	                Controleur controlleur = new Controleur();
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
	                    
	                    stage.show();
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                }

				
			}});
	}
	
}

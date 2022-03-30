package Controle;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map.Entry;

import Modele.Brique;
import Modele.Briques;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class ControleurJeu {
	

	@FXML
	private ListView<String> ListV;
	@FXML 
	private ColorPicker coul;
	@FXML 
	private BorderPane bopa;
	public Briques bri;
	
	@FXML
    private void initialize() {
		/*bri = new Briques();

		Image image1 = new Image("/Modele/brique_rouge1.png",50,50,true,true);
		Image image2 = new Image("/Modele/brique_rouge2.png",50,50,true,true);
		Image image3 = new Image("/Modele/brique_rouge3.png",50,50,true,true);
		Image [] listimg = {image1,image2,image3};*/

		
		coul.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Color c = coul.getValue();
				System.out.println(c);
				//String varcouleur = String.format("#%02x%02x%02x", r,g,b); 
				bopa.setStyle("-fx-background-color: red ;"+ "-fx-bar-fill:red;");
				
				}
	              
	                });	

		
		
	
	}
}

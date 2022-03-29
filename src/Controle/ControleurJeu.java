package Controle;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map.Entry;

import Modele.Brique;
import Modele.Briques;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ControleurJeu {
	

	@FXML
	private ListView<String> ListV;
	public Briques bri;
	
	@FXML
    private void initialize() {
		bri = new Briques();
		Image image1 = new Image("/Modele/brique rouge1.png");
		Image image2 = new Image("/Modele/brique rouge2.png");
		Image image3 = new Image("/Modele/brique rouge3.png");
		Image [] listimg = {image1,image2,image3};
		
		    
	}
}

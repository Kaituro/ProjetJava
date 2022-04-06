package Controle;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map.Entry;

import Modele.Brique;
import Modele.Briques;
import Vue.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
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
	private MenuItem close;
	
	@FXML
	private ImageView imagedroit;
	
	@FXML
    private void initialize() {
		
		
		Image image1 = new Image("file:/Modele/brique_rouge1.png",50,50,true,true);
		Image image2 = new Image(Main.class.getResourceAsStream("/Modele/brique_rouge1.png"));
		
		Image image3 = new Image("file:/Modele/brique_rouge3.png",50,50,true,true);
		ObservableList<String> data = FXCollections.observableArrayList("image1","image2","image3");
		ListV.setItems(data);
				
		
		coul.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Color c = coul.getValue();
				System.out.println(c);
		
				ArrayList<Color> a = new ArrayList<>();
				a.add(c);
				
				
				String hex;
				hex=String.valueOf(c);
				ArrayList<String> b = new ArrayList<>();
				b.add(hex);
				String d="#";
				
				System.out.println("b.get"+b.get(0));
				for(int i=2;i<b.get(0).length()-2;i++) {
					d+=b.get(0).charAt(i);
				}
				
				System.out.println(d);
				bopa.setStyle("-fx-background-color: "+d);
				
				}
			
	              
	                });	

		close.setOnAction(new EventHandler<ActionEvent>() {

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
	                    stage.setFullScreen(true);
	                    stage.show();
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                }

				
			}});
		
	
	}

	
}

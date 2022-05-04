package Controle;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import Modele.Brique;
import Modele.Briques;
import Modele.quadrillage;
import Vue.Main;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.input.MouseEvent;

public class ControleurJeu implements Serializable {
	//méthodes et variables
	private static final long serialVersionUID = 1L;
	@FXML
	private ListView<Image> ListV;
	@FXML 
	private ColorPicker coul;
	@FXML 
	private BorderPane bopa;
	public Briques bri;
	@FXML
	private MenuBar fen;
	@FXML
	private MenuItem close;
	@FXML
	private MenuItem Quitter;
	@FXML
	private ImageView imagedroit;	
	@FXML
	private HBox leHB;
	@FXML
	private ImageView imOn;
	@FXML
	private ImageView imTwo;
	@FXML
	private ImageView imTre;
	public String d;
	public Color c=null;

	public Color geu;

	public File fichier = new File("colo.dat");

	public ArrayList<Color> couleure;

	public Briques b;	
	public List<Brique> brayk;	
	public quadrillage quad;
	public String Taille="1";
	public void grillebas() {
		b= new Briques();
		brayk = new ArrayList<>();
		for(int i =0;i<3;i++) {
			brayk.add(b.get("petit"));
			brayk.add(b.get("moyen"));
			brayk.add(b.get("grand"));
		}		

	}
	 
	//code principal
	@FXML
	private void initialize() throws FileNotFoundException {


		//Sérialisation
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (String)ois.readObject();

			c = Color.valueOf(d);
			this.coul.setValue(c);
			ois.close();
			fis.close();

		}catch (IOException | ClassNotFoundException e){
			//throw new RuntimeException("Lecture des donn�es impossible ou donn�es corrompues");
		}


		//affichage des images

		grillebas();


		//button1.setGraphic(imOn.setImage(brayk.get(0).im));
		//button2.setGraphic(imOn.setImage(brayk.get(1).im));
		//button3.setGraphic(imOn.setImage(brayk.get(2).im));

		imOn.setImage(brayk.get(0).im);		
		imTwo.setImage(brayk.get(1).im);
		imTre.setImage(brayk.get(2).im);

		leHB.setSpacing(50);
		imOn.setFitHeight(imOn.getFitHeight()/2);
		
		
		imOn.setFitWidth(imOn.getFitWidth()/2);
		
		
		//gestion de la grille de jeu
		quad = new quadrillage();


		bopa.setCenter(quad);

		c = coul.getValue();
		System.out.println(c);

		ArrayList<Color> a = new ArrayList<>();
		a.add(c);


		String hex;
		hex=String.valueOf(c);
		ArrayList<String> b = new ArrayList<>();
		b.add(hex);
		d="#";

		System.out.println("b.get"+b.get(0));
		for(int i=2;i<b.get(0).length()-2;i++) {
			d+=b.get(0).charAt(i);
		}

		System.out.println(d);







		coul.setOnAction(new EventHandler<ActionEvent>() {		


			@Override
			public void handle(ActionEvent arg0) {

				c = coul.getValue();
				System.out.println(c);

				ArrayList<Color> a = new ArrayList<>();
				a.add(c);


				String hex;
				hex=String.valueOf(c);
				ArrayList<String> b = new ArrayList<>();
				b.add(hex);
				d="#";

				System.out.println("b.get"+b.get(0));
				for(int i=2;i<b.get(0).length()-2;i++) {
					d+=b.get(0).charAt(i);
				}

				System.out.println(d);

				//	quad.setStyle("-fx-background-color: "+d);



			}


		});	



		close.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				((Stage)((close.getParentPopup().getOwnerWindow()).getScene().getWindow())).close();	

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


			}


		});



		Quitter.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				try {
					FileOutputStream fos = new FileOutputStream(fichier);
					ObjectOutputStream oos = new ObjectOutputStream(fos);


					oos.writeObject(d);
					oos.close();
					fos.close();

				}catch (IOException e1) {
					e1.printStackTrace();
					//throw new RuntimeException("Impossible d'�crire les donn�es");

				}

				System.exit(0);
			}



		});

		quad.setOnMouseClicked((MouseEvent t) -> {

			Rectangle re=new Rectangle(40,40);
			Rectangle re1=new Rectangle(40,40);
			Rectangle re2=new Rectangle(40,40);
			
			Rectangle re11=new Rectangle(40,40);
			Rectangle re22=new Rectangle(40,40);
			
			int x = (int)t.getX();
			
			int y = (int)t.getY();

			
			y=Math.round(y/40);
			x=Math.round(x/40);			
			re.setFill(c);
			re1.setFill(c);
			re2.setFill(c);
			
			re11.setFill(c);
			re22.setFill(c);
			
			if(Taille=="1") {				
				quad.add(re , x, y);
			}
			else if (Taille=="2") {
				if(imTwo.getRotate()==0) {
				
				quad.add(re, x, y);
				quad.add(re1, x+1, y);
				}
				else if ((imTwo.getRotate()/90)%2==1){
					
					quad.add(re, x, y);
					quad.add(re11, x, y+1);
				}
			}
			else if (Taille=="3") {
				
				quad.add(re, x, y);
				quad.add(re1, x+1, y);
				quad.add(re2, x+1, y-1);
			}
			
		});

		
		imOn.setOnMouseClicked((MouseEvent e) -> {
			Taille="1";
			System.out.println(Taille);
			
		});
		imTwo.setOnMouseClicked((MouseEvent e) -> {
			Taille="2";
			System.out.println(Taille);
			
		});
		imTre.setOnMouseClicked((MouseEvent e) -> {
			Taille="3";
			System.out.println(Taille);
			
		});
		
		bopa.setOnKeyPressed(e -> {
	         switch (e.getCode()) {
	        
	         case LEFT:
	        	 if (Taille=="1") {
	        	 imOn.setRotate(imOn.getRotate() - 90); 
	        	 }
	        	 else if (Taille=="2") {
	        		 imTwo.setRotate(imTwo.getRotate() - 90); 
	        	 }
	        	 else if (Taille=="3") {
	        		 imTre.setRotate(imTre.getRotate() - 90); 
	        	 }
	        	 
	            break;
	         case RIGHT:
	        	 if (Taille=="1") {
		        	 imOn.setRotate(imOn.getRotate() + 90); 
		        	 }
		        	 else if (Taille=="2") {
		        		 imTwo.setRotate(imTwo.getRotate() + 90); 
		        	 }
		        	 else if (Taille=="3") {
		        		 imTre.setRotate(imTre.getRotate() + 90); 
		        	 } 

	            break;
	         }
	      });

	}	
}





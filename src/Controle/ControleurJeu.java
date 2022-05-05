package Controle;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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

	public File fichier = new File("colo.xml");

	public ArrayList<Color> couleure;

	public Briques b;	
	public List<Brique> brayk;	
	public quadrillage quad;
	public String Taille="1";

	public Rectangle re;
	public Rectangle re1;
	public Rectangle re2;
		
	public Rectangle re11;
	public Rectangle re22;
	public List<Rectangle> stock;
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
		XMLDecoder decoder =null;
		try {
			FileInputStream fis = new FileInputStream(fichier);
			BufferedInputStream bis = new BufferedInputStream(fis);
			decoder = new XMLDecoder(bis);

			stock = (ArrayList<Rectangle>)decoder.readObject();
			for(int i=0;i<stock.size();i++) {
				stock.get(i).setFill(Color.BLUE);
				quad.add(stock.get(i),(int)stock.get(i).getX(),(int)stock.get(i).getY());
			}



		}catch (Exception e){
			//throw new RuntimeException("Lecture des donn�es impossible ou donn�es corrompues");
		} finally {
			if(decoder !=null)decoder.close();
		}


		//affichage des images

		grillebas();

		URL limaj = getClass().getResource("/Vue/unknown.png");
		Image oumage=new Image(limaj.toExternalForm());
	
		imagedroit.setImage(oumage);
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
				XMLEncoder encoder = null;
				try {
					FileOutputStream fos = new FileOutputStream("colo.xml");
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					encoder =new XMLEncoder(bos);
					encoder.writeObject(stock);
					encoder.flush();


				}catch (final java.io.IOException e1) {
					e1.printStackTrace();
					//throw new RuntimeException("Impossible d'�crire les donn�es");

				}finally {
					if (encoder !=null) encoder.close();
				}

				System.exit(0);
			}



		});

		quad.setOnMouseClicked((MouseEvent t) -> {
			stock = new ArrayList<>();
			re=new Rectangle(30,30);
			re1=new Rectangle(30,30);
			re2=new Rectangle(30,30);

			re11=new Rectangle(30,30);
			re22=new Rectangle(30,30);

			int x = (int)t.getX();

			int y = (int)t.getY();


			y=Math.round(y/30);
			x=Math.round(x/30);			
			re.setFill(c);
			re1.setFill(c);
			re2.setFill(c);

			re11.setFill(c);
			re22.setFill(c);

			if(Taille=="1") {				
				quad.add(re , x, y);
			}
			else if (Taille=="2") {
				if((Math.abs(imTwo.getRotate())/90)%2==0) {
					re.setX(x);
					re.setY(y);
					quad.add(re, x, y);
					re1.setX(x+1);
					re1.setY(y);
					quad.add(re1, x+1, y);
				}
				else if ((Math.abs(imTwo.getRotate())/90)%2==1){
					re.setX(x);
					re.setY(y);
					quad.add(re, x, y);
					re11.setX(x);
					re11.setY(y+1);
					quad.add(re11, x, y+1);
				}
			}
			else if (Taille=="3") {

			
				if((Math.abs(imTre.getRotate())/90)%2==0) {

					re.setX(x);
				re.setY(y);
				quad.add(re, x, y);
				re1.setX(x+1);
				re1.setY(y);
				quad.add(re1, x+1, y);
				re2.setX(x+1);
				re2.setY(y-1);
				quad.add(re2, x+1, y-1); 
				
				}
				else if ((Math.abs(imTwo.getRotate())/90)%2==1){
					
				}
				
				
				}
			stock.add(re1);
			stock.add(re11);
			stock.add(re2);
			stock.add(re);
			stock.add(re22);
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





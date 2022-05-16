package Controle;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import java.net.URL;

import Modele.Brique;
import Modele.Briques;
import Modele.Rectangleu;
import Modele.quadrillage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ControleurJeu implements Serializable {
	//mÃ©thodes et variables
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
	@FXML
	private MenuItem recom;
	public String d;
	public Color c=null;

	public Color geu;

	public File fichier = new File("colo.xml");

	public ArrayList<Color> couleure;

	public Briques b;	
	public List<Brique> brayk;	
	public quadrillage quad;

	public String Taille="1";



	public int compteurfig3 =0;
	public int ancien;
	int rang;
	int max;
	public int rand;

	public ArrayList<Rectangleu> stock= new ArrayList<>();	;
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
		//crÃ©ation de la grille
		quad = new quadrillage();

		bopa.setMaxSize(quad.getWidth(),quad.getHeight());
		bopa.setCenter(quad);

		//DÃ©serialisation
		XMLDecoder decoder =null;
		try {
			FileInputStream fis = new FileInputStream(fichier);
			BufferedInputStream bis = new BufferedInputStream(fis);
			decoder = new XMLDecoder(bis);

			stock =  (ArrayList<Rectangleu>) decoder.readObject();


			for(Rectangleu rekt : stock) {				

				rekt.setFill(Color.valueOf(rekt.getCoulu()));

				quad.add(rekt,(int) rekt.getX(),(int) rekt.getY());
			}


		}catch (Exception e){
			//throw new RuntimeException("Lecture des donnï¿½es impossible ou donnï¿½es corrompues");
		} finally {
			if(decoder !=null)decoder.close();
		}

		if(stock !=null) {
			for (Rectangle ser : stock) {
				System.out.println(ser);
			}
		}

		//affichage des images

		grillebas();
		List<String> modls = new ArrayList<> ();

		modls.add("unknown.png");
		modls.add("pacman.png");
		modls.add("papillon.png");
		modls.add("NFT.png");
		max=3;		
		rang = max+1;
		rand = (int)(Math.random()*rang);
		ancien =rand;

		URL limaj = getClass().getResource("/Vue/"+modls.get(rand));
		Image oumage=new Image(limaj.toExternalForm());
		imagedroit.setFitHeight(450);
		imagedroit.setFitWidth(450);
		imagedroit.setImage(oumage);
		imOn.setImage(brayk.get(0).im);		
		imTwo.setImage(brayk.get(1).im);
		imTre.setImage(brayk.get(2).im);

		leHB.setSpacing(50);
		imOn.setFitHeight(imOn.getFitHeight()/2);


		imOn.setFitWidth(imOn.getFitWidth()/2);


		//gestion de la grille de jeu


		c = coul.getValue();		

		String hex;
		hex=String.valueOf(c);

		d="#";

		System.out.println("b.get"+b.get(0));
		for(int i=2;i<hex.length()-2;i++) {
			d+=hex.charAt(i);
		}


		coul.setOnAction( new EventHandler<ActionEvent>() {		


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
		
		

		//SÃ©rialisation
		Quitter.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if(ControleurOptio.getAutoSav()) {
				System.out.println(stock.toString()); 
				XMLEncoder encoder = null;
				try {
					FileOutputStream fos = new FileOutputStream("colo.xml");
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					encoder =new XMLEncoder(bos);
					encoder.writeObject(stock);
					encoder.flush();


				}catch (final java.io.IOException e1) {
					e1.printStackTrace();
					//throw new RuntimeException("Impossible d'ï¿½crire les donnï¿½es");

				}finally {
					if (encoder !=null) encoder.close();
				}
				Alert dialogC = new Alert(AlertType.CONFIRMATION);
				dialogC.setTitle("Quitter ?");
				dialogC.setHeaderText("Sauvegarde effectuÃ©e");
				dialogC.setContentText("êtes-vous sÃ»r de vouloir quitter ?");

				Optional<ButtonType> answer = dialogC.showAndWait();
				if (answer.get()==ButtonType.OK) {
					System.exit(0);
				}else {
					dialogC.hide();
				}

			}



		});

		recom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {	
				Node node =quad.getChildren().get(0);
				quad.getChildren().clear();
				quad.getChildren().add(0,node);
				
				rand = (int)(Math.random()*rang);

				while (rand ==ancien){				
					rand= (int)(Math.random()*rang);

				}
				ancien =rand;
				URL limaj = getClass().getResource("/Vue/"+modls.get(rand));
				Image oumage=new Image(limaj.toExternalForm());
				imagedroit.setFitHeight(450);
				imagedroit.setFitWidth(450);
				imagedroit.setImage(oumage);

				
			}
		});

		quad.setOnMouseClicked((MouseEvent t) -> {

			int num = t.getClickCount();
			int x = (int)t.getX();

			int y = (int)t.getY();


			y=Math.round(y/30);
			x=Math.round(x/30);	

			if(Taille=="1") {	
				Rectangleu re=new Rectangleu(30,30);
				Rectangleu re1=new Rectangleu(30,30);
				re.setX(x);
				re.setY(y);
				re.coulsauv(c);
				re.setFill(c);
				quad.add(re , x, y);
				System.out.println(re);
				stock.add(re);
			}
			else if (Taille=="2") {
				if((Math.abs(imTwo.getRotate())/90)%2==0) {
					Rectangleu re=new Rectangleu(30,30);
					Rectangleu re1=new Rectangleu(30,30);
					re.setX(x);
					re.setY(y);
					re.coulsauv(c);
					re.setFill(c);
					quad.add(re, x, y);
					if (x-1<0) {
						re1.setX(x+1);
					re1.setY(y);
					re1.coulsauv(c);
					re1.setFill(c);
					quad.add(re1, x+1, y);
					System.out.println(re);
					System.out.println(re1);
					stock.add(re);
					stock.add(re1);
					}else {
						re1.setX(x-1);
						re1.setY(y);
						re1.coulsauv(c);
						re1.setFill(c);
						quad.add(re1, x-1, y);
						System.out.println(re);
						System.out.println(re1);
						stock.add(re);
						stock.add(re1);
					}
					
				}
				else if ((Math.abs(imTwo.getRotate())/90)%2==1){
					Rectangleu re=new Rectangleu(30,30);
					Rectangleu re1=new Rectangleu(30,30);
					re.setX(x);
					re.setY(y);
					re.coulsauv(c);
					re.setFill(c);
					quad.add(re, x, y);
					re1.setX(x);
					re1.setY(y+1);
					re1.coulsauv(c);
					re1.setFill(c);
					quad.add(re1, x, y+1);
					System.out.println(re);
					System.out.println(re1);
					stock.add(re);
					stock.add(re1);
				}
			}
			else if (Taille=="3") {			

				if(compteurfig3 == 0){
					Rectangleu re=new Rectangleu(30,30);
					Rectangleu re1=new Rectangleu(30,30);
					Rectangleu re2=new Rectangleu(30,30);
					if(x-1<0) {						
						re.setY(y);
						re.setX(x);
						re.coulsauv(c);
						re.setFill(c);
						quad.add(re, x, y);
						re1.setX(x-1);
						re1.setY(y);
						re1.coulsauv(c);
						re1.setFill(c);
						quad.add(re1, x-1, y);
						re2.setX(x-1);
						re2.setY(y-1);
						re2.coulsauv(c);
						re2.setFill(c);
						quad.add(re2, x-1, y-1);
						System.out.println(re);
						System.out.println(re1);
						System.out.println(re2);
						stock.add(re);
						stock.add(re1);
						stock.add(re2);
					}else {
						re.setY(y);
						re.setX(x);
						re.coulsauv(c);
						re.setFill(c);
						quad.add(re, x, y);
						re1.setX(x-1);
						re1.setY(y);
						re1.coulsauv(c);
						re1.setFill(c);
						quad.add(re1, x-1, y);
						re2.setX(x);
						re2.setY(y-1);
						re2.coulsauv(c);
						re2.setFill(c);
						quad.add(re2, x, y-1);
						System.out.println(re);
						System.out.println(re1);
						System.out.println(re2);
						stock.add(re);
						stock.add(re1);
						stock.add(re2);
					}
					
				}

				else if(compteurfig3 == 1){
					Rectangleu re=new Rectangleu(30,30);
					Rectangleu re1=new Rectangleu(30,30);
					Rectangleu re2=new Rectangleu(30,30);
					if (x+1>29) {
						re.setY(y);
						re.setX(x-1);
						re.coulsauv(c);
						re.setFill(c);
						quad.add(re, x-1, y);
						re1.setX(x);
						re1.setY(y);
						re1.coulsauv(c);
						re1.setFill(c);
						quad.add(re1, x, y);
						re2.setX(x-1);
						re2.setY(y-1);
						re2.coulsauv(c);
						re2.setFill(c);
						quad.add(re2, x-1, y-1);
						System.out.println(re);
						System.out.println(re1);
						System.out.println(re2);
						stock.add(re);
						stock.add(re1);
						stock.add(re2);
					} else {
						re.setY(y);
						re.setX(x);
						re.coulsauv(c);
						re.setFill(c);
						quad.add(re, x, y);
						re1.setX(x);
						re1.setY(y);
						re1.coulsauv(c);
						re1.setFill(c);
						quad.add(re1, x+1, y);
						re2.setX(x);
						re2.setY(y-1);
						re2.coulsauv(c);
						re2.setFill(c);
						quad.add(re2, x, y-1);
						System.out.println(re);
						System.out.println(re1);
						System.out.println(re2);
						stock.add(re);
						stock.add(re1);
						stock.add(re2);
					}
					
				}

				else if(compteurfig3 == 2){
					Rectangleu re=new Rectangleu(30,30);
					Rectangleu re1=new Rectangleu(30,30);
					Rectangleu re2=new Rectangleu(30,30);
					if(x+1>29) {
						re.setY(y+1);
						re.setX(x-1);
						re.coulsauv(c);
						re.setFill(c);
						quad.add(re, x-1, y+1);
						re1.setX(x);
						re1.setY(y);
						re1.coulsauv(c);
						re1.setFill(c);
						quad.add(re1, x, y);
						re2.setX(x-1);
						re2.setY(y);
						re2.coulsauv(c);
						re2.setFill(c);
						quad.add(re2, x-1, y);
						System.out.println(re);
						System.out.println(re1);
						System.out.println(re2);
						stock.add(re);
						stock.add(re1);
						stock.add(re2);
					}else {
					re.setY(y);
					re.setX(x);
					re.coulsauv(c);
					re.setFill(c);
					quad.add(re, x, y);
					re1.setX(x+1);
					re1.setY(y);
					re1.coulsauv(c);
					re1.setFill(c);
					quad.add(re1, x+1, y-1);
					re2.setX(x);
					re2.setY(y-1);
					re2.coulsauv(c);
					re2.setFill(c);
					quad.add(re2, x, y-1);
					System.out.println(re);
					System.out.println(re1);
					System.out.println(re2);
					stock.add(re);
					stock.add(re1);
					stock.add(re2);
					}
					
				}

				else if (compteurfig3 == 3){
					Rectangleu re=new Rectangleu(30,30);
					Rectangleu re1=new Rectangleu(30,30);
					Rectangleu re2=new Rectangleu(30,30);
					if(x-1<0) {						
						re.setY(y);
						re.setX(x+1);
						re.coulsauv(c);
						re.setFill(c);
						quad.add(re, x+1, y);
						re1.setX(x);
						re1.setY(y);
						re1.coulsauv(c);
						re1.setFill(c);
						quad.add(re1, x, y);
						re2.setX(x+1);
						re2.setY(y+1);
						re2.coulsauv(c);
						re2.setFill(c);
						quad.add(re2, x+1, y+1);
						System.out.println(re);
						System.out.println(re1);
						System.out.println(re2);
						stock.add(re);
						stock.add(re1);
						stock.add(re2);
						
					} else {
					re.setY(y-1);
					re.setX(x);
					re.coulsauv(c);
					re.setFill(c);
					quad.add(re, x, y-1);
					re1.setX(x-1);
					re1.setY(y);
					re1.coulsauv(c);
					re1.setFill(c);
					quad.add(re1, x-1, y-1);
					re2.setX(x);
					re2.setY(y);
					re2.coulsauv(c);
					re2.setFill(c);
					quad.add(re2, x, y);
					System.out.println(re);
					System.out.println(re1);
					System.out.println(re2);
					stock.add(re);
					stock.add(re1);
					stock.add(re2);
					}
					
				}
System.out.println(compteurfig3);
			}




		});


		imOn.setOnMouseClicked((MouseEvent e) -> {
			Taille="1";


		});
		imTwo.setOnMouseClicked((MouseEvent e) -> {
			Taille="2";


		});

		imTre.setOnMouseClicked((MouseEvent e) -> {
			Taille="3";


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
					compteurfig3-=1;
					if(compteurfig3<0) {
						compteurfig3=3;
					}
					if(compteurfig3>3) {
						compteurfig3=0;
					}

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
					compteurfig3+=1;
					if(compteurfig3<0) {
						compteurfig3=3;
					}
					if(compteurfig3>3) {
						compteurfig3=0;
					}

				} 

				break;
			}
		});



	}	
}





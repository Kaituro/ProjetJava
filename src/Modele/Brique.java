package Modele;


import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Brique {
	
Class<?> clazz = this.getClass();

    InputStream input = clazz.getResourceAsStream("../../../Images/Images enregistrées/Nouveau dossier/23032022.png");

    Image image = new Image(input);

    ImageView imageView = new ImageView(image);
    
int taille;

public Brique(Image image, int taille) {
	this.image=image;
	this.taille=taille;
	
	
	
}
	public static void main(String[] args) {
		
		InputStream input = clazz.getResourceAsStream("../../../Images/Images enregistrées/Nouveau dossier/23032022.png");
		Image image = new Image(input);
		Brique a =new Brique(image,30);

	}

}

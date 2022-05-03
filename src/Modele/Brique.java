package Modele;


import java.io.InputStream;
import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Brique {
	
public Image im;
public int t;

public Brique(int tai){
	
	t=tai;
	if (tai==1) {
		URL imageURL = getClass().getResource("/Modele/brique_rouge1.png");
		this.im=new Image(imageURL.toExternalForm());
	}else if (tai==2){
		URL imageURL2 = getClass().getResource("/Modele/brique_rouge2.png");
		this.im=new Image(imageURL2.toExternalForm());
	}else {
		URL imageURL3 = getClass().getResource("/Modele/brique_rouge3.png");
		this.im=new Image(imageURL3.toExternalForm());
	}
}

}

package Modele;


import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Brique {
	
public Image im;
public int t;

public Brique(int tai){
	
	t=tai;
	if (tai==1) {
		this.im=new Image("/brique_rouge1.png");
	}else if (tai==2){
		this.im=new Image("/brique_rouge2.png");
	}else {
		this.im=new Image("/brique_rouge3.png");
	}
}

}

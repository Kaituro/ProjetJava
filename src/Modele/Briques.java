package Modele;

import java.util.HashMap;

public class Briques extends HashMap<String , Brique>{
	
	public Briques() {
		Brique b1=new Brique(1);
		Brique b2=new Brique(2);
		Brique b3=new Brique(3);
		
		this.put("petit", b1);
		this.put("moyen", b2);
		this.put("grand", b3);
		
	}
	




}

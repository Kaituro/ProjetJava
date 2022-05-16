package Modele;

import java.io.Serializable;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rectangleu extends Rectangle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String coulu;
	
	public Rectangleu(int w,int h) {
		super(w,h);		
	}
	
	public Rectangleu() {
		
	}
	
	public void coulsauv(Color c) {
		this.coulu=(String.valueOf(c));		
	}

	public String getCoulu() {
		return coulu;
	}

	public void setCoulu(String coulu) {
		this.coulu = coulu;
	}
}

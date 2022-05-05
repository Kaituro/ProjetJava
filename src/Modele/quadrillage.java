package Modele;


import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class quadrillage extends GridPane{	
	
	public quadrillage()  {
		int ligne = 25;
		int colonne = 30;
		
		for(int i = 0; i < colonne; i++) {
			ColumnConstraints column = new ColumnConstraints(30);
			this.getColumnConstraints().add(column);
		}
		for(int i = 0; i < ligne; i++) {
			RowConstraints row = new RowConstraints(30);
			this.getRowConstraints().add(row);
		}
				
	
		this.setGridLinesVisible(true);
		
		
	}
	
		


}

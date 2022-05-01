package Modele;

import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class quadrillage extends GridPane{	
	
	public quadrillage()  {
		int ligne = 21;
		int colonne = 35;
		
		for(int i = 0; i < colonne; i++) {
			ColumnConstraints column = new ColumnConstraints(40);
			this.getColumnConstraints().add(column);
		}
		for(int i = 0; i < ligne; i++) {
			RowConstraints row = new RowConstraints(40);
			this.getRowConstraints().add(row);
		}

		this.maxWidth(USE_COMPUTED_SIZE);
		this.maxHeight(USE_COMPUTED_SIZE);
		this.setGridLinesVisible(true);
		
		
	}



}

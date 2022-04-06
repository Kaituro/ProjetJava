package Modele;

import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class quadrillage {
	static GridPane grid;
	public quadrillage(final Stage stage) {
		int ligne = 5;
		int colonne = 5;

		grid = new GridPane();
		for(int i = 0; i < colonne; i++) {
			ColumnConstraints column = new ColumnConstraints(40);
			grid.getColumnConstraints().add(column);
		}
		for(int i = 0; i < ligne; i++) {
			RowConstraints row = new RowConstraints(40);
			grid.getRowConstraints().add(row);
		}


		grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
		Scene scene = new Scene(grid, (colonne * 40) + 100, (ligne * 40) + 100, Color.WHITE);
		stage.setScene(scene);
		stage.show();
	}


public static void main(String[] args) {
	// TODO Auto-generated method stub

}
}

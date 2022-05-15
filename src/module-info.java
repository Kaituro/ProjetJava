module ProjetJava {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;
	requires javafx.media;

	opens Vue to javafx.graphics, javafx.fxml;
	opens Controle to javafx.fxml, javafx.graphics, javafx.controls;
	opens Modele to javafx.fxml, javafx.controls, javafx.graphics;
}

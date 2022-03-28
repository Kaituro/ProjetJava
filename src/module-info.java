module ProjetJava {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens Vue to javafx.graphics, javafx.fxml;
	opens Controle to javafx.fxml;
}

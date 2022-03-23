module ProjetJava {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens Controle to javafx.fxml;
}

package application;

import controller.SokobanController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.MyModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// main window fxml
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			BorderPane root = (BorderPane) loader.load();
			MainWindowController view = loader.getController();

			// Records Table Window Loading
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("RecordWindow.fxml"));
			BorderPane root2 = (BorderPane) loader2.load();
			RecordWindowController recordview=loader2.getController();
			

					
			MyModel model = new MyModel();
			SokobanController controller = new SokobanController(model, view);
			view.addObserver(controller);
			model.addObserver(controller);
			
			//
			view.setRc(recordview);

			Scene scene = new Scene(root, 800, 800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

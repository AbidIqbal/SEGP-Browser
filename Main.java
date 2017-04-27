package default1;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	Stage view=null;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Web Browser");
		Parent root = FXMLLoader.load(getClass().getResource("/default1/gui2.fxml"));
		Scene sc = new Scene(root);
//		sc.getStylesheets().add(getClass().getResource("").toExternalForm());
//		sc.getStylesheets().add(arg0)
		stage.setScene(sc);
		stage.show();
		
	}
	
	
	public static void main(String args[]){
		launch(args);
	}
	public void check(){
		System.out.println("back back");
	}
//	public void showhistory() throws IOException{
//		System.out.println("Hy");
////		ListView<String> list = new ListView<String>();
////		ObservableList<String> items =FXCollections.observableArrayList (
////		    "Single", "Double", "Suite", "Family App");
////		list.setItems(items);
//		FXMLLoader load=new FXMLLoader();
//		load.setLocation(Main.class.getResource("/default1/test2.fxml"));
////		Parent root = FXMLLoader.load(getClass().getResource());
//		
//		Scene hist=new Scene(load.load());
//		view.setScene(hist);
//		view.show();
//		
//	}
	

}

package default1;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController implements Initializable {
	ObservableList<history> data=FXCollections.observableArrayList();



	Main main=new Main();
	@FXML public WebView wv = new WebView();
	@FXML private TableView <history> table;
	@FXML private TableColumn<?, ?> Date;
	@FXML private TableColumn<?, ?> Link;

	public WebEngine se;
	public WebHistory history;
	public TextField searchbar;
	public void initialize(URL arg0, ResourceBundle arg1) {

		se = wv.getEngine();
		history = se.getHistory();
		TableColumn< history, String> dateColumn=new TableColumn<>("Date");
		dateColumn.setMinWidth(200);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

		TableColumn< history, String> linkColumn=new TableColumn<>("Link");
		linkColumn.setMinWidth(700);
		linkColumn.setCellValueFactory(new PropertyValueFactory<>("link"));
		table=new TableView<>();
		table.getColumns().addAll(dateColumn,linkColumn);
		table.setTableMenuButtonVisible(true);

	}

	@FXML
	public void showhistory(){
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("History");
		window.setMinWidth(800);
		window.setMinHeight(600);
		Label label=new Label();

		ObservableList<WebHistory.Entry> l = history.getEntries();
		for(int i=1;i<l.size();i++){
			System.out.println(l.get(i).getUrl());
			String date=l.get(i).getLastVisitedDate().toString();
			String link=l.get(i).getUrl();
			data.add(new history(date, link));
			table.setItems(data);
		}


//		table.setItems(getproduct());

		VBox layout=new VBox(10);
		layout.getChildren().addAll(table);
		layout.setAlignment(Pos.CENTER);
		Scene scene=new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

	}
	@FXML
	public void loadspecific(javafx.event.ActionEvent a){
		se.load("file:///D:/Torrents/jar-download.com/javaDoc/com.ui4j/ui4j-api/1.0.1/index.html");
	}


	@FXML
	public void loadSearchbar(javafx.event.ActionEvent event) {
		se.load(searchbar.getText());
	}

	public void goBack(javafx.event.ActionEvent a)
	{    
		ObservableList<WebHistory.Entry> entryList=history.getEntries();
		int currentIndex=history.getCurrentIndex();

		Platform.runLater(new Runnable() { public void run() { history.go(-1); } });
		se.load(entryList.get(currentIndex>0?currentIndex-1:currentIndex).getUrl());
	}

	public void goForward(javafx.event.ActionEvent a)
	{    
		//      final WebHistory history=eng.getHistory();
		ObservableList<WebHistory.Entry> entryList=history.getEntries();
		int currentIndex=history.getCurrentIndex();
		//      Out("currentIndex = "+currentIndex);
		//      Out(entryList.toString().replace("],","]\n"));

		Platform.runLater(new Runnable() { public void run() { history.go(1); } });
		se.load(entryList.get(currentIndex>0?currentIndex-1:currentIndex).getUrl());
	}

	public void reload(javafx.event.ActionEvent a){
		se.reload();
	}
//	public ObservableList<history> getproduct(){
//		ObservableList<history> historydata=FXCollections.observableArrayList();
//		historydata.add(new history("15/04/2016","www.google.com"));
//		historydata.add(new history("16/04/2016","www.facebook.com"));
//		historydata.add(new history("17/04/2016","www.namal.edu.pk"));
//		historydata.add(new history("18/04/2016","www.lums.edu.pk"));
//		historydata.add(new history("19/04/2016","www.nust.edu.pk"));
//		return historydata;
//	}

}

package application;


import java.net.URL;
import java.util.ResourceBundle;



import Hibernate.HibernateUtil;
import Hibernate.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RecordWindowController implements Initializable {

//	@FXML
//	private TextField userSearch;
//	@FXML
//	private TextField levelSearch;
	@FXML
	private TableView<Record> table;
	private ObservableList<Record> data;
	private Stage recordStage;
	
	HibernateUtil util=HibernateUtil.getInstance();

	public RecordWindowController() {
		//data= FXCollections.observableArrayList();
		//table=new TableView<Record>();
		recordStage = new Stage();
		//data.addAll(util.getAllRecords());
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		table =new TableView<>();
		data = FXCollections.observableArrayList();
		table.setEditable(true);

		// Username column
		TableColumn<Record, String> userNamecol = new TableColumn<>("Username");
		userNamecol.setMinWidth(100);
		userNamecol.setCellValueFactory(new PropertyValueFactory<>("userName"));

		// Level name column
		TableColumn<Record, String> levelNameCol = new TableColumn<>("Level name");
		levelNameCol.setMinWidth(100);
		levelNameCol.setCellValueFactory(new PropertyValueFactory<>("levelName"));

		// steps column
		TableColumn<Record, Integer> stepsCol = new TableColumn<>("Steps");
		stepsCol.setMinWidth(100);
		stepsCol.setCellValueFactory(new PropertyValueFactory<>("steps"));

		// time column
		TableColumn<Record, Integer> timeCol = new TableColumn<>("Time");
		timeCol.setMinWidth(100);
		timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));

		table.getColumns().addAll(userNamecol, levelNameCol, stepsCol, timeCol);

		table.setItems(data);
		
		
//		table.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				Record r= table.getSelectionModel().getSelectedItem();
//				
//			}
//		});
		
		table.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub

				Record r = table.getSelectionModel().getSelectedItem();
				if (r != null){
					
					// show user data 
				}
					

			}
		});
		
		
		

	}
	
	public void SaveRecord(String userName, String levelName, int steps, int time){
		Record r= new Record(userName, levelName, steps, time);
		util.addRecord(r);
	}

	
	//Show all records 
	public void displayRecords() {
	
		data.clear();
		Scene scene =new Scene(new Group(table));
		recordStage.setScene(scene);
		recordStage.show();
		data.addAll(util.getAllRecords());
		data.addAll();
	}
	
	//Show single user record
	
	public void DisplayUserRecords(){
		
		
	}

}

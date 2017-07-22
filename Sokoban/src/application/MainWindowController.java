package application;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import Hibernate.HibernateUtil;
import Hibernate.Record;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.data.levels.Level;
import view.view;

public class MainWindowController extends Observable implements Initializable, view {


	@FXML
	Text stepscount;

	@FXML
	Text timer;

	@FXML
	LevelDisplayer leveldisplayer;
	
//Alerts
	Alert alert1 = new Alert(AlertType.CONFIRMATION);
	TextInputDialog dialog = new TextInputDialog("Username");
	Record record;
	//HibernateUtil util=HibernateUtil.getInstance();
  
	String levelName;
	
//record
	RecordWindowController rc;
	
	
	
	private int timerCounter=0;
    private Timer t=new Timer();
//music
    private String mp3path = "./resources/start.mp3";
    private Media mp3 = new Media(new File(mp3path).toURI().toString());
    private MediaPlayer player = new MediaPlayer(mp3);
    private String finishpath="./resources/drake.mp3";
    private Media finish=new Media(new File(finishpath).toURI().toString());
    private MediaPlayer finished=new MediaPlayer(finish);
    
    
	public void Close()
	{
		LinkedList<String>params =new LinkedList<String>();
		params.add("Exit");
		this.setChanged();
		this.notifyObservers(params);
	}

	public void OpenFile()
	{
		FileChooser fc=new FileChooser();
		fc.setTitle("Open Level");
		fc.setInitialDirectory (new File("./resources") );
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"," *.jpeg"),
				new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
				new ExtensionFilter("Object Files", "*.obj"),
				new ExtensionFilter("XML Files", "*.xml"));
		File chosen = fc.showOpenDialog(null);
		if(chosen!=null)
		{
			LinkedList<String>params =new LinkedList<String>();
			params.add("Load");
			params.add(chosen.getPath());
			startTimer();
			System.out.println(chosen.getPath());
			//Getting level name from path
			int index=chosen.getPath().indexOf('.');
			int index2=chosen.getPath().indexOf("level");
			levelName=chosen.getPath().substring(index2,index);
			/////////////////////////////////////////////////////
			player.play();
			timerCounter=0;
			this.setChanged();
			this.notifyObservers(params);
		}	
	}

	public void Save()
	{
		FileChooser fc=new FileChooser();
		fc.setTitle("Save Level");
		fc.setInitialDirectory (new File("./resources") );
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"," *.jpeg"),
				new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
				new ExtensionFilter("Object Files", "*.obj"),
				new ExtensionFilter("XML Files", "*.xml"));
		File chosen = fc.showSaveDialog(null);
		if(chosen!=null)
		{
			LinkedList<String>params =new LinkedList<String>();
			params.add("Save");
			params.add(chosen.getPath());
			this.setChanged();
			this.notifyObservers(params);
		}
	}

	@Override
	public void display(Level level) {
	

		leveldisplayer.setLevel(level);
		String temp = String.valueOf(level.getMovesCount());
		stepscount.setText(temp);	
		if (level.checkIfComplete())
		{
		
			t.cancel();
			int finishtime=timerCounter;
			timerCounter=0;
			player.stop();
			finished.play();
			alert1.setTitle("Confirmation Dialog");
			alert1.setHeaderText("Save score?");
			alert1.setContentText("Press ok to save your score");
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			    	Optional<ButtonType> result= alert1.showAndWait();
			    	if (result.get() == ButtonType.OK){
						dialog.setTitle("Username Input");
						dialog.setHeaderText(" ");
						dialog.setContentText("Please enter your username:");
						Optional<String> result2 = dialog.showAndWait();
						if (result2.isPresent()){
							rc.SaveRecord(result2.get(), levelName, level.getMovesCount(), finishtime);
//						    record = new Record(result2.get(),levelName, level.getMovesCount(), finishtime);
//						    util.addRecord(record);
//							util.close();
							
						}

					} else {
					    
					}
					
			    }
			});
			
			
		}
		
	}

	@Override
	public void displayMessage(String msg) {
	}

	@Override
	public void start() {
		String command = "Display";
		LinkedList<String> params = new LinkedList<String>();
		params.add(command);
		this.setChanged();
		this.notifyObservers(params);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		leveldisplayer.requestFocus();
		LinkedList<String>params=new LinkedList<String>();
		leveldisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED, (e)->leveldisplayer.requestFocus());
		leveldisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) 
			{
				if(event.getCode()== KeyCode.UP)
				{
					params.add("Move");
					params.add("up");
					System.out.println(params);
				}

				else if(event.getCode()== KeyCode.DOWN)
				{
					params.add("Move");
					params.add("down");
					System.out.println(params);
				}

				else if(event.getCode()== KeyCode.LEFT)
				{
					params.add("Move");
					params.add("left");
					System.out.println(params);
				}

				if(event.getCode()== KeyCode.RIGHT)
				{
					params.add("Move");
					params.add("right");
					System.out.println(params);
				}
				else if(event.getCode()== KeyCode.ESCAPE)
				{
					params.add("Exit");
					System.out.println(params);
				}
				setChanged();
				notifyObservers(params);
				params.clear();
			}
		});
	}
	public void startTimer(){
			
			t.scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {
					setTimerCounter(getTimerCounter()+1);
				}
			},0,1000);
		
		
	}

	public int getTimerCounter() {
		return timerCounter;
	}

	public void setTimerCounter(int timerCounter) {
		this.timerCounter = timerCounter;
		String temp = String.valueOf(this.timerCounter);
		timer.setText(temp);
	}
	
	
	public void ShowRecordTable(){
		rc.displayRecords();
	}

	public RecordWindowController getRc() {
		return rc;
	}

	public void setRc(RecordWindowController rc) {
		this.rc = rc;
	}
	
	public void solve(){
		LinkedList<String> params = new LinkedList<String>();
		params.add("Solve");
		this.setChanged();
		this.notifyObservers(params);
		
	}
	
	public void hint(){
		LinkedList<String> params = new LinkedList<String>();
		params.add("Hint");
		this.setChanged();
		this.notifyObservers(params);
		
	}
}
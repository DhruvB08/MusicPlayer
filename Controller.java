package view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

	@FXML Button ADD;
	@FXML Button EDIT;
	@FXML Button DELETE;
	
	@FXML TextField name_of_song_add;
	@FXML TextField artist_add;
	@FXML TextField album_add;
	@FXML TextField year_add;
	
	@FXML TextField artist_else;
	@FXML TextField name_of_song_else;
	@FXML TextField album_else;
	@FXML TextField year_else;
	
	   @FXML         
	   ListView<Songs> listView;                

	   ObservableList<Songs> obsList;              
	   public void start(Stage mainStage) {                
	      // create an ObservableList 
	      // from an ArrayList              
	      obsList = FXCollections.observableArrayList();                                      
	      listView.setItems(obsList);  
	      
	      // select the first item
	      listView.getSelectionModel().select(0);

	      // set listener for the items
	      listView.setCellFactory(param -> new ListCell<Songs>() {
	    	    @Override
	    	    protected void updateItem(Songs song, boolean empty) {
	    	        super.updateItem(song, empty);
	    	        if (empty || song == null || song.getSong() == null) {
	    	            setText(null);
	    	        } else {
	    	            setText(song.getSong());
	    	        }
	    	    }
	    	});
	      }
	     /* listView
	        .getSelectionModel()
	        .selectedIndexProperty()
	        .addListener(
	           (obs, oldVal, newVal) -> 
	               showItemInputDialog(mainStage)); */
	
	 
	   
	   
	   public void addbutton(ActionEvent e){
			String name_of_song_temp;
			String artist_temp;
			String album_temp;
			String year_temp;
			
			name_of_song_temp = name_of_song_add.getText();
			artist_temp = artist_add.getText();
			album_temp = album_add.getText();
			year_temp = year_add.getText();
			
			if(!name_of_song_temp.isEmpty() && !artist_temp.isEmpty()) {
				Songs temp = new Songs(name_of_song_temp, artist_temp, album_temp, year_temp);
				if(TestIfDuplicate(temp)) {
					System.out.println("This is a duplicate :(");
				}
				else{
					System.out.println(temp.song + " " + temp.artist + " " + temp.album + " " + temp.year);
					System.out.println("Add button clicked");
					obsList.add(temp);
				}
			}
			else{
				System.out.println("Name of song and artist needed!!!!");
			}
		}
	   // tests to see whether a song already exists in the list
	   public boolean TestIfDuplicate(Songs temp) {
			for(Songs song : obsList) {
				if(song.getSong().equals(temp.getSong())
				&& song.getArtist().equals(temp.getArtist())
				&& song.getAlbum().equals(temp.getAlbum())
				&& song.getYear().equals(temp.getYear()))
			{
					return true;
				}
			}
			return false;
		}
	   
	   
		//whenever which button is clicked edit or delete will be called
		public void whichbutton(ActionEvent e) {
			Button b = (Button)e.getSource();
		    if(b == EDIT){
				System.out.println("Edit button clicked");
			}
			else{
				System.out.println("Delete button clicked");
			}
		}
		
	
		
		/*
	   private void showItem(Stage mainStage) {                
		   Alert alert = 
				   new Alert(AlertType.INFORMATION);
		   alert.initOwner(mainStage);
		   alert.setTitle("List Item");
		   alert.setHeaderText(
				   "Selected list item properties");

		   String content = "Index: " + 
				   listView.getSelectionModel()
		   .getSelectedIndex() + 
		   "\nValue: " + 
		   listView.getSelectionModel()
		   .getSelectedItem();

		   alert.setContentText(content);
		   alert.showAndWait();
	   }
	   */
	

	}


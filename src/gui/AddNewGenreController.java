package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DB;
import db.DBException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dao.DaoFactory;
import model.dao.impl.GenreDaoJDBC;
import model.entities.Genre;

public class AddNewGenreController implements Initializable{

	@FXML
	private TextField genreName;
	
	@FXML
	private Label messageLabel;
	
	@FXML
	private Button btCancel;
	
	@FXML
	private Button btSave;
	
	private GenreDaoJDBC genreDao = DaoFactory.createGenreDao();
	
	@FXML
	public void onCancelAction() {
		Stage stage = (Stage)this.btCancel.getScene().getWindow();
		DB.closeConnection();
		stage.close();
	}
	
	@FXML
	public void onSaveAction() {
		Genre genre = new Genre();
		genre.setName(this.genreName.getText());
		
		if(this.genreName.getText().length() == 0) {
			messageLabel.setText("The field 'name' can't be empty");
			//throw new DBException("error");
		}else {
			genreDao.insert(genre);
			messageLabel.setText("Genre saved successfully");
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

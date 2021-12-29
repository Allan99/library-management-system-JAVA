package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.dao.DaoFactory;
import model.dao.impl.BookDaoJDBC;
import model.dao.impl.GenreDaoJDBC;
import model.entities.Book;
import model.entities.Genre;

public class AddNewBookController implements Initializable {

	@FXML
	private TextField bookTitle;

	@FXML
	private TextField bookId;

	@FXML
	private TextField author;

	@FXML
	private TextField publisher;

	@FXML
	private TextField bookInternalCode;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	@FXML
	private ComboBox<Genre> genreBox;

	private ObservableList<Genre> obsList;

	private BookDaoJDBC bookDao = DaoFactory.createBookDao();

	@FXML
	public void onSaveNewBook() {
		Book book = new Book();
		book.setBookTitle(this.bookTitle.getText());
		book.setAuthor(this.author.getText());
		book.setPublisher(this.publisher.getText());
		book.setBookInternalId(Integer.parseInt(this.bookInternalCode.getText()));
		Genre genre = genreBox.getSelectionModel().getSelectedItem();// capturing the book genre
		book.setGenre(genre);
		bookDao.insert(book);
	}

	public void onCancel() {

	}
	
	private void cleanFields() {
		this.bookTitle.setText("");
		this.author.setText("");
		this.publisher.setText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Genre> genreList = new ArrayList<>();
		GenreDaoJDBC genreDao = DaoFactory.createGenreDao();
		genreList = genreDao.findAll();

		obsList = FXCollections.observableArrayList(genreList);
		genreBox.setItems(obsList);

		Callback<ListView<Genre>, ListCell<Genre>> factory = lv -> new ListCell<Genre>() {
			@Override
			protected void updateItem(Genre item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		genreBox.setCellFactory(factory);
		genreBox.setButtonCell(factory.call(null));

	}

}

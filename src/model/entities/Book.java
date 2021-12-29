package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer bookId;
	private String bookTitle;
	private String author;
	private String publisher;
	private Integer bookInternalId;
	
	private Genre genre;
	
	public Book() {
	}
	
	public Book(String bookTitle, String author, String publisher, Integer bookInternalId,
			Genre genre) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.bookInternalId = bookInternalId;
		this.genre = genre;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getBookInternalId() {
		return bookInternalId;
	}

	public void setBookInternalId(Integer bookInternalId) {
		this.bookInternalId = bookInternalId;
	}

	public Integer getGenreId() {
		return this.genre.getId();
	}
	
	public void setGenreId(Integer id) {
		this.genre.setId(id);
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, bookInternalId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(bookInternalId, other.bookInternalId);
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", author=" + author + ", publisher=" + publisher
				+ ", bookInternalId=" + bookInternalId + ", genre=" + genre + "]";
	}
	
}


package za.ac.tut.librarybook;

/**
 *
 * @author S. X Mabuza
 */
public class LibraryBook {
    //PRIVATE MEMBERS++++++++++++++++++++++++++++++++++++++++++++
    private String title;
    private String author;
    private String ISBN;

    //GETTERS AND SETTERS+++++++++++++++++++++++++++++++++++++
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    //CONSTRUCTOR++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public LibraryBook(String title, String author, String ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;        
    }
    //PUBLIC METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void displayBookDetails(){
        System.out.println("Book Details");
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.ISBN);
    }
}

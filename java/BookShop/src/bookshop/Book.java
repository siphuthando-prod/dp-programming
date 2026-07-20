
package bookshop;

public class Book {
    //PRIVATE MEMBERS++++++++++++++++++++++++++++++++
    private String name;
    private String title;
    private String isbn;
    private String genre;
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++
    public Book(String name, String title, String isbn, String genre){
        this.name = name;
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
    }
    
    //GETTERS+++++++++++++++++++++++++++++++++++++++++
    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }
    
}

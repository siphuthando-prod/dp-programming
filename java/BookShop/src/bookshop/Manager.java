package bookshop;

//IMPORT STATEMENTS++++++++++++++++++++++++++++
import java.util.ArrayList;

public class Manager {
    //PRIVATE MEMBERS++++++++++++++++++++++++++++++++++
    private String name;
    private String title;
    private String isbn;
    private String genre;
    private ArrayList<Book> books;
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++
    public Manager(String name, String title, String isbn, String genre){
        this.name = name;
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        this.books = new ArrayList<>(5);
    }
    
    //PUBLIC METHODS++++++++++++++++++++++++++++++++++++++++
    public void addBook(String name, String title, String isbn, String genre){
       Book book = new Book(name, title, isbn, genre);
       books.add(book);
    }
    
    public void browseMenu(){
        for (Book book : books) {
            System.out.println("+++++++++++++++++++++++++++");
            System.out.println("Author name: " + book.getName());
            System.out.println("Book title: " + book.getTitle());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Book genre: " + book.getGenre());
            System.out.println("+++++++++++++++++++++++++++");
        }
    }
    
    public String searchBook(String name){
        for (Book book : books) {
            if(book.getName().equalsIgnoreCase(name)){
                return book.getTitle();
            }
        }
        return "Author Not Found";
    }
}

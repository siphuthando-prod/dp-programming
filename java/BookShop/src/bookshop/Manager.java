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
        addBook(name, title, isbn, genre);
    }
    
    //GETTERS
    public ArrayList getBooks(){
        return this.books;
    }
    
    //SETTERS
    public void setBooks(ArrayList<Book> books){
        this.books = books;
    }
    
    //PRIVATE METHODS++++++++++++++++++++++++++++++++++++++++
    private void addBook(String name, String title, String isbn, String genre){
       Book book = new Book(name, title, isbn, genre);
       books.add(book);
    }
    
     //PUBLIC METHODS++++++++++++++++++++++++++++++++++++++++
    public String  browseMenu(){
        String output = "";
        for (Book book : books) {
            output +=  "+++++++++++++++++++++++++++" +
                                                    "\nAuthor name: " + book.getName() +
                                                    "\nBook title: " + book.getTitle()+
                                                    "\nISBN: " + book.getIsbn()+
                                                    "\nBook genre: " + book.getGenre()+
                                                    "\n+++++++++++++++++++++++++++";
        }
        return output;
    }
    
    public String searchBook(String name){
        for (Book book : books) {
            if(book.getName().equalsIgnoreCase(name)){
                return book.getTitle();
            }
        }
        return "Author Not Found";
    }
    
    public void removeBook(String title){
        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)){
                books.remove(book);
            }
            else{
                System.out.println("The book was not found!");
            }
        }
    }
    
    public Book updateDetails(String bookTitle, Book book){
        for (Book book1 : books) {
            if(book1.getName().equalsIgnoreCase(bookTitle)){
                book1 = book;
                return book1;
            }
        }
        
        return null;
    }
}

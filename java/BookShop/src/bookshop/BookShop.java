package bookshop;

//IMPORT STATEMENTS++++++++++++++++++++++++++++++++
import java.util.ArrayList;
import java.util.Scanner;

public class BookShop {
//PRIVATE METHODS++++++++++++++++++++++++++++++++++
    private static String viewMenu(ArrayList<Book> books){
        String list = "";
        for (Book book : books) {
            list += "\n+++++++++++++++++++++++++++++++++++++\n"
                    + book.getTitle() + "\n++++++++++++++++++++++++++++++++++++++++++"
                    + "\nAuthor's name: " + book.getName() 
                    + "\nGenre: " + book.getGenre()
                    + "\nISBN: " + book.getIsbn() ;
        }
        return list;
    }
    
    private static void removeBook(ArrayList<Book> books, String bookTitle) {
        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(bookTitle)){
                books.remove(book);
                System.out.println("Book successfully removed");
            }
        }
    }
    
    private static Book updateDetails(ArrayList<Book> books, String bookTitle, Book newBook){
        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(bookTitle)){
                book = newBook;
                return book;
            }
        }
        return null;
    }
    //PUBLIC METHODS++++++++++++++++++++++++++++++++++
    public static void main(String[] args) {
        //INSTANTIATING VARIBLES++++++++++++++++++++++
        String name = "";
        String title = "";
        String genre = "";
        String isbn = "";
        
        //INSTANTIATING OBJECTS+++++++++++++++++++++++
       ArrayList<Book> books = new ArrayList<>(5);
        Scanner kb = new Scanner(System.in);
        //Manager book = null;
        Book book = null;
        
        for (int k = 0; k < 5; k++) {
            System.out.print("Enter author name: ");
            name = kb.nextLine();
            System.out.print("Enter book title: ");
            title = kb.nextLine();
            System.out.print("Enter book genre: ");
            genre = kb.nextLine();
            System.out.print("Enter ISBN: ");
            isbn = kb.nextLine();
            System.out.println("++++++++++++++++++++++++++");
            
            book = new Book(name, title, isbn, genre);
            books.add(book);
        }
        
        //Adding a new book+++++++++++++++++++++++++++++++++
        System.out.println("Adding a new Book");
        System.out.print("Enter author name: ");
            name = kb.nextLine();
        System.out.print("Enter book title: ");
            title = kb.nextLine();
       System.out.print("Enter book genre: ");
            genre = kb.nextLine();
        System.out.print("Enter ISBN: ");
            isbn = kb.nextLine();
        book = new Book(name, title, isbn, genre);
        books.add(book);
        
        //Veiwing list of books+++++++++++++++++++++++++++++++++
        String bookMenu = viewMenu(books);
        System.out.println(bookMenu);
        
        //Removing book from the list+++++++++++++++++++++++++++++++
        System.out.print("Enter the name of the book you want to delete:");
        String bookTitle = kb.nextLine();
        removeBook(books, bookTitle);
        
        //Changing details of a book+++++++++++++++++++++++++++++++++++
        System.out.print("Enter title of book: ");
        bookTitle = kb.nextLine();
        
        System.out.println("Enter details you want to update");
        System.out.print("Enter author name: ");
            name = kb.nextLine();
        System.out.print("Enter book title: ");
        title = kb.nextLine();
        System.out.print("Enter book genre: ");
            genre = kb.nextLine();
        System.out.print("Enter ISBN: ");
        isbn = kb.nextLine();
        
       book = new Book(name, title, isbn, genre);
        Book updated = updateDetails(books, bookTitle, book);
        if(updated != null){
            System.out.println("+++++++++++++++++++++");
            System.out.println("Info Updated Successfully");
            System.out.println("++++++++++++++++++++++");
            System.out.println("Author name: " + updated.getName());
             System.out.println("Book title: " + updated.getTitle());
            System.out.println("ISBN: " + updated.getIsbn());
            System.out.println("Book genre: " + updated.getGenre());
            System.out.println("+++++++++++++++++++++++++++");
        }
        else{
            System.out.println("Book NOT found!");
        }
        
    }

}

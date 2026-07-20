package bookshop;

//IMPORT STATEMENTS++++++++++++++++++++++++++++++++
import java.util.ArrayList;
import java.util.Scanner;

public class BookShop {

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
            
            Book book = new Book(name, title, isbn, genre);
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
        book = new Manager(name, title, isbn, genre);
        
        //Veiwing list of books+++++++++++++++++++++++++++++++++
        String bookMenu = book.browseMenu();
        System.out.println(bookMenu);
        
        //Removing book from the list+++++++++++++++++++++++++++++++
        System.out.print("Enter the name of the book you want to delete:");
        String bookTitle = kb.nextLine();
        book.removeBook(bookTitle);
        
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
        
       Book book1 = new Book(name, title, isbn, genre);
        Book updated = book.updateDetails(bookTitle, book1);
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
        
    }
    
}

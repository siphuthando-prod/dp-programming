package booksapp;

//IMPORT STATEMENTS++++++++++++++++++++++++++++++++
import java.util.Scanner;
import za.ac.tut.Author;
import za.ac.tut.Book;
import za.ac.tut.BooksManager;

public class BooksApp {

    //PUBLIC METHODS+++++++++++++++++++++++++++++++++++++
    public static void main(String[] args) {
        //DECLARING AND INSTANTIATING BooksManager
        BooksManager bm = new BooksManager();
        
        //Add books to the list++++++++++++++++++++++++++++++++++++++++
        addBooksToList(bm);
        
        //Get all the books+++++++++++++++++++++++++++++++++++++++++++
        Book[] books = bm.getBooks();
        
        //Display the books+++++++++++++++++++++++++++++++++++++++++
        displayBooks(books);
    }
    
    //PRIVATE METHODS+++++++++++++++++++++++++++++++++++
    private static void addBooksToList(BooksManager bm){
        //Declaring variables++++++++++++++++++++++++++++++++++++++++++
        String name, title;
        Author author;
        Book book;
        
        //Instantiate Scanner++++++++++++++++++++++++++++++++++++++++++++
        Scanner kb = new Scanner(System.in);
        
        //Add books++++++++++++++++++++++++++++++++++++++++++++++++
        for(int k = 0; k < 5; k++){
            System.out.print("Please enter name of author " + (k+1) + " : ");
            name = kb.nextLine();
            System.out.print("Please enter book title by " + name + " : ");
            title = kb.nextLine();
            author = new Author();
            author.setName(name);
            book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            
            //Add the book to the list++++++++++++++++++++++++++++++++++++
            bm.addBook(book, k);
        }
    }
    
    private static void displayBooks(Book[] books){
        //Declare +++++++++++++++++++++++++++++++++++++++++++++++++
        String name, title;
        for (int k = 0; k < 5; k++) {
            name = books[k].getAuthor().getName();
            title = books[k].getTitle();
            
            System.out.println((k+1) + " " + name + " " + title);
        }
    }
}

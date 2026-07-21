package za.ac.tut;

public class BooksManager implements BooksManagerInterface {
    //PRIVATE MEMBERS++++++++++++++++++++++++++++++++++
    private Book[] books;
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++
    public BooksManager(){
        this.books = new Book[5];
    }
    
    //PUBLIC METHODS++++++++++++++++++++++++++++++++++
    @Override
    public void addBook(Book book, int index){
        books[index]  = book;
    }
    
    @Override
    public Book[] getBooks(){
        return this.books;
    }
}

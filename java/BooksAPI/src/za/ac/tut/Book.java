package za.ac.tut;

public class Book {
    //PRIVATE MEMBERS++++++++++++++++++++++++++++++++++
    private String title;
    private Author author;
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++
    public Book(){
        this.title = "Java: How to program";
        this.author = new Author();
    }
    
    //GETTERS AND SETTERS+++++++++++++++++++++++++++
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
}

package za.ac.tut;

public class Author {
    //PRIVATE MEMBERS+++++++++++++++++++++++++++++++++++
    private String name;
    
    //CONSTRUCTOR++++++++++++++++++++++++++++++++++++++++++
    public Author(){
        this.name = "Siphuthando Mabuza";
    }
    
    //GETTERS AND SETTERS+++++++++++++++++++++++++++++++
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
}

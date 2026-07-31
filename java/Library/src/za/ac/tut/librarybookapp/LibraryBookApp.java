
package za.ac.tut.librarybookapp;

import za.ac.tut.librarybook.LibraryBook;

/**
 *
 * @author S. X Mabuza
 */
public class LibraryBookApp {

    public static void main(String[] args) {
        // Instantiating books++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        LibraryBook book1 = new LibraryBook("How to read and see the aura", "A. Sandler"
                                                                                                , "1876583684");
        book1.displayBookDetails();
        System.out.println("=======================================");
        
        LibraryBook book2 = new LibraryBook("Osiris", "G. Mohammed", "9807463527");
        book2.displayBookDetails();
    }
    
}

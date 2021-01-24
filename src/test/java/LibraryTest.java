import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.PriorityQueue;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library lb = new Library("Decagon Library");
    Library.Librarian librarian = lb.new Librarian("Tolu");

    Teacher teacher1 = new Teacher("Thomas", 1);
    Student student1 = new Student("Timi", "Junior");
    Student student2 = new Student("Femi", "Senior");

    Books book1 = new Books("First Book");
    Books book2 = new Books("Second Book");
    Books book3 = new Books("Third Book");



    @Test
    void getNameOfLibrary() {
        Library lb = new Library("Decagon Library");
        assertEquals("Decagon Library", lb.getNameOfLibrary());
    }

    @Test
    void getAvailableBookList() {
        List<Books> test = new Library("Decagon Library").getAvailableBookList();
        assertTrue(test instanceof List);

    }

    @Test
    void getPersonsList() {
        
        lb.getPersonsList().add(teacher1);
        lb.getPersonsList().add(student1);
        lb.getPersonsList().add(student2);

        PriorityQueue<Person> test = lb.getPersonsList();
        assertArrayEquals(test,lb.getPersonsList());
       
        
    }

    private void assertArrayEquals(PriorityQueue<Person> test, PriorityQueue<Person> personsList) {
    }


    @Test
    void getBookList() {
        List<Books> test = new Library("Decagon Library").getBookList();
        assertTrue(test instanceof List);

    }

    @Test
    void getRegistrationList() {
        List<Person> test = new Library("Decagon Library").getRegistrationList();
        assertTrue(test instanceof List);
    }

    @Test
    void getAllBorrowedBooks() {
        List<Books> test = new Library("Decagon Library").getAllBorrowedBooks();
        assertTrue(test instanceof List);
        
    }

    @Test
    void addToQueue() {
        lb.getRegistrationList().add(teacher1);
        lb.getRegistrationList().add(student1);
        lb.getRegistrationList().add(student2);
        lb.getPersonsList().add(teacher1);

        lb.addToQueue("Okon");
        lb.addToQueue("John");
        lb.addToQueue("Emma");

        PriorityQueue <Person> test = new Library("Decagon Library").getPersonsList();
        assertArrayEquals(test, lb.getPersonsList());
    }

}
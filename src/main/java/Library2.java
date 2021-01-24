import java.util.*;

public class Library2 {
    private String name;
    private Queue<Person> personsOnQueue = new LinkedList<>(); //Queue
    private List<Books> availableBookList = new ArrayList<>();
    private List<Person> registrationList = new ArrayList<>();
    private List<Books> borrowedBooks = new ArrayList();


    public Library2(String name) {
        this.name = name;
    }


    public Queue<Person> getPersonsList() {
        return personsOnQueue;
    }

    public void setPersonsList(Person personName) {
        personsOnQueue.add(personName);
    }

    public void setBookList(Books book) {
        availableBookList.add(book);
    }

    public List<Books> getBookList() {
        return availableBookList;
    }

    public List<Person> getRegistrationList() {
        return registrationList;
    }

    public List getAllBorrowedBooks() {
        return borrowedBooks;
    }

    public void addToQueue(String name) {
        for (Person person :registrationList) {
            if (person.getName().equalsIgnoreCase(name)) {
                this.personsOnQueue.add(person);
            }

        }

    }
    public void setBook(Books book, int number) {
        for (int i = 0; i<number; i++) {
            availableBookList.add(book);
        }
    }

    class Librarian extends Person {
        public Librarian(String name) {
            super(name, 1);
        }

        public void administerLibrary (String bookSearcher) {
            boolean hold = true;
            for (Books book : availableBookList) {
                if (book.getNameOfBook().matches(bookSearcher.toLowerCase())) {
                    hold = false;
                    availableBookList.remove(book);
                    personsOnQueue.poll();
                    borrowedBooks.add(book);
                    break;
                }
            }

            if (!hold) {
                System.out.println("Take your book");
            } else {
                System.out.println("Book Taken");
            }

        }

        public void returnBook(String bookname) {
            for ( Books books : borrowedBooks) {
                if (books.getNameOfBook().matches(bookname.toLowerCase())) {
                    borrowedBooks.remove(books) ;
                    availableBookList.add(books);
                    System.out.println(bookname+ " is returned.");
                    break;
                }
            }

        }
    }




}

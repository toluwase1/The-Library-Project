import java.util.*;

public class Library {
    private String nameOfLibrary;
    private PriorityQueue<Person> personsOnQueue = new PriorityQueue<>(); //Queue
    private List<Books> availableBookList = new ArrayList<>();
    private List<Person> registrationList = new ArrayList<>();
    private List<Books> borrowedBooks = new ArrayList();




    public Library(String name) {
        this.nameOfLibrary = name;
    }

    public String getNameOfLibrary() {
        return nameOfLibrary;
    }

    public List<Books> getAvailableBookList() {
        return availableBookList;
    }

    public PriorityQueue<Person> getPersonsList() {
        return personsOnQueue;
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


    // method that adds person to queue
    public void addToQueue(String name) {
        for (Person person :registrationList) {
            if (person.getName().equalsIgnoreCase(name)) {
                this.personsOnQueue.add(person);
                break;
            }

        }

    }

    // method adds books to available book list
    public void setBook(Books book, int number) {
        for (int i = 0; i<number; i++) {
            availableBookList.add(book);
        }
    }

    //Librarian attending to queue
    class Librarian extends Person {
        public Librarian(String name) {
            super(name, 1);
        }

        //Enables person to request for book
        public void administerLibrary (String requestedBook) {
            boolean hold = true;
            for (Books book : availableBookList) {
                if (book.getNameOfBook().matches(requestedBook.toLowerCase())) {
                    hold = false;
                    availableBookList.remove(book);
                    personsOnQueue.poll();
                    borrowedBooks.add(book);
                    break;
                }
            }

            if (!hold) {
                System.out.println("Take your requested book");
            } else {
                System.out.println("Book Taken");
            }


        }

        // method ensures return of books
        public void returnBook(String bookname) {
            boolean flag = false;
            for ( Books books : borrowedBooks) {
                if (books.getNameOfBook().matches(bookname.toLowerCase())) {
                    borrowedBooks.remove(books) ;
                    availableBookList.add(books);
                    flag = true;
                    System.out.println(bookname+ " is returned.");

                    break;
                }
            }
            if (flag==false) {
                System.out.println("You did not borrow this book");
            }

        }

    }




}

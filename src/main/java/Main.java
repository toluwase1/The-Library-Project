import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //instantiating the library objects
        Library lb = new Library("Decagon Library");
        Library2 lib = new Library2("University Library");

        //instantiating the librarian
        Library.Librarian librarian = lb.new Librarian("Tolu");
        Library2.Librarian librarian2 = lib.new Librarian("Tolu");

        //creating books
        Books book1 = new Books("First Book");
        Books book2 = new Books("Second Book");
        Books book3 = new Books("Third Book");

        //adding book to library1 the booklist
        lb.setBook(book1, 2);
        lb.setBook(book2, 1);
        lb.setBook(book3, 2);

        //adding book to library2 booklist
        lib.setBook(book1, 2);
        lib.setBook(book2, 1);
        lib.setBook(book3, 2);

        //instantiating the teacher and student object
        Teacher teacher1 = new Teacher("Thomas", 1);
        Student student1 = new Student("Timi", "Junior");
        Student student2 = new Student("Femi", "Senior");

        //library1 registration list
        lb.getRegistrationList().add(teacher1);
        lb.getRegistrationList().add(student1);
        lb.getRegistrationList().add(student2);

        //library2 registration list
        lib.getRegistrationList().add(teacher1);
        lib.getRegistrationList().add(student1);
        lib.getRegistrationList().add(student2);

        //The Library1 Queue
        lb.addToQueue("Thomas");
        lb.addToQueue("Timi");
        lb.addToQueue("Femi");

        //The Library2 Queue
        lib.addToQueue("Thomas");
        lib.addToQueue("Timi");
        lib.addToQueue("Femi");


    //the main logic of the library
        int holder;
        boolean flag = true;
        boolean flag1= true;
        boolean flag2 = true;
        boolean flag4 = true;
        int switchLibrary = 0;

        while (flag) {
            boolean third = true;
            application();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            holder = scan.nextInt();
            scan.nextLine();

            //helps the app receive different inputs (0-9)
            switch (holder) {
                case 0:
                    flag = false;
                    flag4 = false;
                    break;
                case 1:
                    if(flag1){
                    implementation1(lb, librarian);
                    flag1 = false;
                    switchLibrary = 1;
                    break;
                    } else{
                        System.out.println("The Queue is Empty");
                    }

                case 2:
                    if(flag2) {
                        implementation2(lib, librarian2);
                        switchLibrary = 2;
                        flag2 = false;
                        break;
                    }else {
                        System.out.println("The Queue is Empty");
                    }
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    System.out.println("Invalid input, Use Valid inputs");
                    third = false;
                    break;
            }

            //returns book
            if (third) {
                if (flag4) {
                    boolean flag3 = true;
                    application2();
                    while (flag3) {
                        Scanner scanner = new Scanner(System.in);
                        int request = scanner.nextInt();
                        scanner.nextLine();
                        switch (request) {
                            case 0:
                                flag3 = false;
                                break;
                            case 1:if(switchLibrary == 1) {
                                returnBookBorrowed(librarian);
                            }else
                                returnBookBorrowed2(librarian2);
                        }
                    }

                }
            }

        }
            System.out.println("The remaining books in the " + lb.getNameOfLibrary() + " " + " " +lb.getAvailableBookList());
            System.out.println("Here is the list of books in the Library: "+lb.getBookList());
            System.out.println("Here is the list of all borrowed books: "+ lb.getAllBorrowedBooks());
            System.out.println("Here is the list of persons" +lb.getPersonsList());
            System.out.println("Here is the list of registered users: " +lb.getRegistrationList());
        }



//powers the application interface
    private static void application() {
        System.out.println("\n Welcome to Our Library ");
        System.out.println("\n Enter: ");
        System.out.println("\t 0. - To Exit");
        System.out.println("\t 1. - To Test Implementation One");
        System.out.println("\t 2. - To test Implementation Two");


    }

    //powers the inner application interface
    private static void application2() {
        System.out.println("\n Enter: ");
        System.out.println("\t 0 - Return to Main Menu");
        System.out.println("\t 1. - Return Book");


    }


// implements library 1 : checks if people are on list, gets their class and gets their name
    private static void implementation1(Library lb, Library.Librarian librarian) {
        Scanner scanner1 = new Scanner(System.in);
        if (lb.getPersonsList().size() > 0) {
            while (lb.getPersonsList().size() > 0) {
                System.out.println(Objects.requireNonNull(lb.getPersonsList().peek()).getClass().getName() + " "
                        + Objects.requireNonNull(lb.getPersonsList().peek()).getName() + " Enter your requested book.");
                String hold = scanner1.nextLine();
                librarian.administerLibrary(hold);
            }

        }
    }

    //Implements library two
    private static void implementation2(Library2 lib, Library2.Librarian librarian2) {
        Scanner scanner2 = new Scanner(System.in);
        if (lib.getPersonsList().size() > 0) {
            while (lib.getPersonsList().size() > 0) {
                System.out.println(Objects.requireNonNull(lib.getPersonsList().peek()).getClass().getName() + " "
                        + Objects.requireNonNull(lib.getPersonsList().peek()).getName() + " Enter your requested book.");
                String hold = scanner2.nextLine();
                librarian2.administerLibrary(hold);

            }

        }


    }
    // enables borrowers from library 1 to return books
    private static void returnBookBorrowed (Library.Librarian librarian){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of book you want to return");
        String hold = scanner.nextLine();
        librarian.returnBook(hold);
        application2();
    }

//    enables borrowers to from library 2 return books
    private static void returnBookBorrowed2 (Library2.Librarian librarian){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of book you want to return");
        String hold = scanner.nextLine();
        librarian.returnBook(hold);
        application2();
    }
}

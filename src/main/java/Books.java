public class Books {
    private String nameOfBook;

    public Books(String nameOfBook) {
        this.nameOfBook = nameOfBook.toLowerCase();
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    @Override
    public String toString() {
        return nameOfBook;
    }
}

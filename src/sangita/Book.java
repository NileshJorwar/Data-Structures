package src.sangita;

public class Book {
    String name;
    String IFSC;
    String author;
    String issuedBy;
    boolean available;

    public Book(String name, String IFSC, String author, String issuedBy, boolean available) {
        this.name = name;
        this.IFSC = IFSC;
        this.author = author;
        this.issuedBy = issuedBy;
        this.available = available;
    }


}

class Library {


    public String validateIFSC(Book book) throws InvalidIFSCException {
        String ifscCode = book.IFSC;

        if (ifscCode.matches("^\\d{16}$")) {
            return "IFSC is valid";
        } else {
            throw new InvalidIFSCException("IFSC is invalid");
        }
    }

    public String issueBook(Book book, String name) throws BookUnavailableException {
        if (book.available == true) {
            book.available = false;
            book.issuedBy = name;
            return "Book is issued successfully";
        } else {
            throw new BookUnavailableException("Book in unavailable");
        }
    }
}

class InvalidIFSCException extends Exception {
    public InvalidIFSCException(String message) {
        super(message);
    }
}

class BookUnavailableException extends Exception {
    public BookUnavailableException(String message) {
        super(message);
    }
}

class Source4 {
    public static void main(String[] args) throws InvalidIFSCException, BookUnavailableException {
        Book data = new Book("Arthashastra", "9099282828282828", "Sangita", "Shital",
                true);
        Library obj = new Library();

        String ans1 = obj.validateIFSC(data);
        String ans2 = obj.issueBook(data, "Steve");
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
package classes;

public class Person {

    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    // Constructor
    // -------------------------------------------------------------------------
    public Person(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    // Getters
    // -------------------------------------------------------------------------
    public String getName() {return name;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getEmail() {return email;}
    public String getAddress() {return address;}

    // Setters
    // -------------------------------------------------------------------------
    public void setName(String name) {this.name = name;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setEmail(String email) {this.email = email;}
    public void setAddress(String address) {this.address = address;}


    // Methods
    // -------------------------------------------------------------------------
    /**
     * A Person can call to a Book to read its contents.
     *
     * @param book = the book to be read
     */
    public void readBook(Book book) {
        System.out.println(name + " is reading a book");
        // TODO: Actually print the book contents into the terminal. (Stretch goal for more interactive media)
        // TODO: Open file for book in default program for file type.
        // // ^ Call a function inside the "book" to open that file; use the file's path.
    }

}

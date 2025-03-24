package classes;

public abstract class Person {

    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private static int idCounter = 0; // Static counter to generate unique IDs for each Person
    // This is a static variable that will be shared across all instances of Person
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    // Constructors
    // -------------------------------------------------------------------------
    public Person() { this.id = generateId(); } // Default constructor

    public Person(String name, String phoneNumber, String email, String address) {
        this.id = generateId(); // Generate a unique ID for this instance
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    // Getters
    // -------------------------------------------------------------------------
    public int getId() { return id; }
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

    private int generateId() { 
        return ++idCounter; // Increment the static counter and return the new value as the ID
    }
    
    /**
     * A Person can call to a Book to read its contents.
     *
     * @param book = the book to be read
     */
    public void readBook(Book book) {
        System.out.println(name + " is reading a book");
        book.openBook(book.getFilePath()); // Call the read method of the Book class
    }

}

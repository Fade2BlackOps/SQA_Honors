package tests;

import classes.Person;
import classes.Book;
import enums.GENRE;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class PersonTest {

    private Person person;
    private Book book;

    // Mock subclass of Person for testing purposes
    private static class MockPerson extends Person {
        public MockPerson(String name, String phoneNumber, String email, String address) {
            super(name, phoneNumber, email, address);
        }
    }

    @BeforeTest
    public void setUp() {
        person = new MockPerson("John Doe", "123-456-7890", "johndoe@example.com", "123 Main St");
        book = new Book("Test Book", "1234567890", null, null, 100, 19.99f, GENRE.FICTION, "path/to/book.docx");
    }

    @Test(priority = 1)
    public void testPersonConstructor() {
        assertNotNull(person, "Person instance should not be null after construction.");
        assertEquals(person.getName(), "John Doe", "Name should be initialized correctly.");
        assertEquals(person.getPhoneNumber(), "123-456-7890", "Phone number should be initialized correctly.");
        assertEquals(person.getEmail(), "johndoe@example.com", "Email should be initialized correctly.");
        assertEquals(person.getAddress(), "123 Main St", "Address should be initialized correctly.");
        assertTrue(person.getId() > 0, "ID should be a positive integer.");
    }

    @Test(priority = 2)
    public void testSetName() {
        person.setName("Jane Doe");
        assertEquals(person.getName(), "Jane Doe", "Name should be updated correctly.");
    }

    @Test(priority = 3)
    public void testSetPhoneNumber() {
        person.setPhoneNumber("987-654-3210");
        assertEquals(person.getPhoneNumber(), "987-654-3210", "Phone number should be updated correctly.");
    }

    @Test(priority = 4)
    public void testSetEmail() {
        person.setEmail("janedoe@example.com");
        assertEquals(person.getEmail(), "janedoe@example.com", "Email should be updated correctly.");
    }

    @Test(priority = 5)
    public void testSetAddress() {
        person.setAddress("456 Another St");
        assertEquals(person.getAddress(), "456 Another St", "Address should be updated correctly.");
    }

    @Test(priority = 6)
    public void testReadBook() {
        person.readBook(book);
        // This test primarily ensures no exceptions are thrown during execution.
        // You can verify the console output manually if needed.
    }
}

package edu.fgcu.bookstore.models.payment;

import edu.fgcu.bookstore.enums.PAYMENT_TYPE;

public abstract class Card extends Payment {
    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private String cardNumber; // e.g., "1234-5678-9012-3456"
    private String cardHolderName; // e.g., "John Doe"
    private String expirationDate; // e.g., "12/25"
    private String cvv; // e.g., "123"
    private String userName;

    // Constructors
    // ----------------------
    public Card() {
        super(); // Call the default constructor of Payment
    }

    public Card(float paymentAmount, String userName, String cardNumber) {
        super(paymentAmount);
        this.userName = userName;
        this.cardNumber = cardNumber;
    }

    public Card(int orderId, PAYMENT_TYPE paymentMethod, float amount, String cardNumber, String cardHolderName, String expirationDate, String cvv) {
        super(orderId, paymentMethod, amount); // Call the parameterized constructor of Payment
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    // Getters and Setters
    // --------
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getCardHolderName() { return cardHolderName; }
    public void setCardHolderName(String cardHolderName) { this.cardHolderName = cardHolderName; }

    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    
    // Encapsulation: Ensure sensitive data is not exposed
    // e.g., don't expose the CVV or full card number directly
    // Instead, consider providing methods to mask or partially reveal this information
    // e.g., getMaskedCardNumber() to return "****-****-****-3456"
    public String getMaskedCardNumber() {
        if (cardNumber != null && cardNumber.length() > 4) {
            return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        }
        return cardNumber; // Return as is if it's null or too short
    }


    // Methods
    // --------------

    @Override
    public abstract Payment processPayment(int orderId, PAYMENT_TYPE paymentMethod, float amount); // Abstract method to be implemented by subclasses
    
}

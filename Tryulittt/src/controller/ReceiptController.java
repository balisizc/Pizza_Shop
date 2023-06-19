package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReceiptController {
    @FXML
    private Label cardNumberLabel;

    @FXML
    private Label expiryDateLabel;

    @FXML
    private Label cvvLabel;

    @FXML
    private Label cardHolderNameLabel;

    public void initialize(String cardNumber, String expiryDate, String cvv, String cardHolderName) {
        cardNumberLabel.setText("Card Number: " + cardNumber);
        expiryDateLabel.setText("Expiry Date: " + expiryDate);
        cvvLabel.setText("CVV: " + cvv);
        cardHolderNameLabel.setText("Card Holder Name: " + cardHolderName);
    }
}

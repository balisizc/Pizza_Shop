package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentMethodController {

    private Stage primaryStage;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField cardNumberField, cvvField, nameHolderField;

    @FXML
    private CheckBox saveCardDetailsCheckbox;

    @FXML
    private DatePicker expiryDatePicker;

    @FXML
    private Rectangle rect1;

    @FXML
    private Button addCardButton;

    @FXML
    private ImageView img6;

    @FXML
    private ImageView img7;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    public void addCard(ActionEvent event) {
        String cardNumber = cardNumberField.getText();
        String expiryDate = expiryDatePicker.getValue().toString();
        String cvv = cvvField.getText();
        String cardHolderName = nameHolderField.getText();
        boolean saveCardDetails = saveCardDetailsCheckbox.isSelected();

        img6.setImage(new Image("/Images/qr.png"));
        img7.setImage(new Image("/Images/qr.png")); 

        // Validate card number
        if (!isValidCardNumber(cardNumber)) {
            showAlert("Invalid Card Number", "Card number should have 16 digits.");
            return;
        }

        // Validate CVV
        if (!isValidCVV(cvv)) {
            showAlert("Invalid CVV", "CVV should have 3 digits.");
            return;
        }

        // Perform necessary actions with the card details (e.g., store in a database)

        // Show receipt
        showReceipt(cardNumber, expiryDate, cvv, cardHolderName);
    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d{16}");
    }

    private boolean isValidCVV(String cvv) {
        return cvv.matches("\\d{3}");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        clearTextFields(cardNumberField, cvvField, nameHolderField);
        expiryDatePicker.getEditor().clear();
    }

    private void clearTextFields(TextInputControl... fields) {
        for (TextInputControl field : fields) {
            field.clear();
        }
    }

    private void showReceipt(String cardNumber, String expiryDate, String cvv, String cardHolderName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Receipt.fxml"));
            Parent root = loader.load();

            ReceiptController receiptController = loader.getController();
            receiptController.initialize(cardNumber, expiryDate, cvv, cardHolderName);

            Stage receiptStage = new Stage();
            receiptStage.setTitle("PIZZERIA");
            receiptStage.getIcons().add(new Image("/Images/pizzaLogo-removebg-preview 1.png")); // Set application icon
            receiptStage.setScene(new Scene(root));
            receiptStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}






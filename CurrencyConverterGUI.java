import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CurrencyConverterGUI extends JFrame implements ActionListener {

    // Exchange rates (for demonstration, these would ideally be updated dynamically)
    private double usdToEurRate = 0.85;
    private double usdToGbpRate = 0.72;
    private double usdToInrRate = 73.50;

    // GUI Components
    private JTextField usdField;
    private JLabel eurResultLabel;
    private JLabel gbpResultLabel;
    private JLabel inrResultLabel;

    public CurrencyConverterGUI() {
        // Set up the frame
        setTitle("Currency Converter");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // ENTER AMOUNT: Prompt user to enter the amount in USD
        add(new JLabel("Enter amount in USD: "));
        usdField = new JTextField();
        add(usdField);

        // CONVERT CURRENCY: Button to trigger currency conversion
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        add(convertButton);

        // SEE RESULT: Display labels for the converted amounts
        add(new JLabel("Equivalent in EUR: "));
        eurResultLabel = new JLabel("---");
        add(eurResultLabel);

        add(new JLabel("Equivalent in GBP: "));
        gbpResultLabel = new JLabel("---");
        add(gbpResultLabel);

        add(new JLabel("Equivalent in INR: "));
        inrResultLabel = new JLabel("---");
        add(inrResultLabel);

        // Retrieve the latest exchange rates
        retrieveLatestRates();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // ENTER AMOUNT: Read and parse the USD amount from the input field
            double amountInUsd = Double.parseDouble(usdField.getText());

            // CONVERT CURRENCY: Perform conversions using the exchange rates
            double amountInEur = convertCurrency(amountInUsd, usdToEurRate);
            double amountInGbp = convertCurrency(amountInUsd, usdToGbpRate);
            double amountInInr = convertCurrency(amountInUsd, usdToInrRate);

            // SEE RESULT: Display the converted amounts with appropriate currency symbols
            eurResultLabel.setText(String.format("€%.2f", amountInEur));
            gbpResultLabel.setText(String.format("£%.2f", amountInGbp));
            inrResultLabel.setText(String.format("₹%.2f", amountInInr));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Converts the amount based on the provided exchange rate
    private double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    // Simulate retrieving the latest exchange rates (for demonstration)
    private void retrieveLatestRates() {
        // Simulated rates; these would be dynamically updated in a real application
        usdToEurRate = 0.85; // Updated USD to EUR rate
        usdToGbpRate = 0.72; // Updated USD to GBP rate
        usdToInrRate = 73.50; // Updated USD to INR rate

        System.out.println("Exchange rates updated:");
        System.out.println("USD to EUR: " + usdToEurRate);
        System.out.println("USD to GBP: " + usdToGbpRate);
        System.out.println("USD to INR: " + usdToInrRate);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverterGUI converter = new CurrencyConverterGUI();
            converter.setVisible(true);
        });
    }
}

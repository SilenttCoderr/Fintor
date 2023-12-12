package net.codejava;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;


public class InvestmentTracker implements ActionListener {
    private Connection con;
    private Statement stmt;
    private JFrame frame;
    private JTable table;
    private JTextField nameField, amountField, dateField, totalField;
    private JComboBox<String> categoryField;
    private JButton addButton, viewButton, deleteButton, totalInvestmentButton;
    private JLabel totalInvestmentLabel;
    private JComboBox<String> categoryComboBox;

    public InvestmentTracker() {
        String[] categories = {"Futures", "F&O", "SIP", "Stocks", "Mutual Funds","Other"};
        categoryComboBox = new JComboBox<>(categories);
        // Connect to MySQL database
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create GUI
        frame = new JFrame("Investment Tracker");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // Add Investment input fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 100, 20);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 10, 150, 20);
        frame.add(nameField);

        JLabel categoryLabel = new JLabel("Type:");
        categoryLabel.setBounds(10, 40, 100, 20);
        frame.add(categoryLabel);


        categoryField = new JComboBox<>(categories);
        categoryField.setBounds(120, 40, 150, 20);
        frame.add(categoryField);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(10, 70, 100, 20);
        frame.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(120, 70, 150, 20);
        frame.add(amountField);

        JLabel dateLabel = new JLabel("Date (yyyy-mm-dd):");
        dateLabel.setBounds(10, 100, 120, 20);
        frame.add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(120, 100, 150, 20);
        frame.add(dateField);

        // Add buttons
        addButton = new JButton("Add Investment");
        addButton.setBounds(10, 150, 150, 20);
        addButton.addActionListener(this);
        frame.add(addButton);

        viewButton = new JButton("View Investment");
        viewButton.setBounds(170, 150, 150, 20);
        viewButton.addActionListener(this);
        frame.add(viewButton);

        deleteButton = new JButton("Delete Investment");
        deleteButton.setBounds(330, 150, 150, 20);
        deleteButton.addActionListener(this);
        frame.add(deleteButton);

        // Add table
        table = new JTable();
        table.setBounds(10, 200, 560, 150);
        frame.add(table);

        // Add total Investment label
        totalInvestmentLabel = new JLabel("Total Investment: ");
        totalInvestmentLabel.setBounds(300, 30, 150, 20);
        frame.add(totalInvestmentLabel);

        totalField = new JTextField();
		totalField.setBounds(450, 30, 120, 20);
        totalField.setEditable(false);
        frame.add(totalField);

        totalInvestmentButton = new JButton("Total Investment");
        totalInvestmentButton.setBounds(350, 60, 150, 20);
        totalInvestmentButton.addActionListener(this);
        frame.add(totalInvestmentButton);

        // Set frame visibility
        frame.setLayout(null);
        frame.setVisible(true);

        try {
            // Retrieve Investments from database
            String sql = "SELECT * FROM investment";
            ResultSet rs = stmt.executeQuery(sql);
    
            // Create table model
            String[] columns = {"Name", "category", "Amount", "Date"};
            Object[][] data = new Object[100][4];
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("name");
                String category = rs.getString("category");
                double amount = rs.getDouble("amount");
                String date = rs.getString("date");
    
                data[i][0] = name;
                data[i][1] = category;
                data[i][2] = amount;
                data[i][3] = date;
                i++;
            }
            DefaultTableModel model = new DefaultTableModel(data, columns);
    
            // Set table model
            table.setModel(model);
    
        } catch (SQLException ex) {
            System.out.println("Error viewing investment: " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addInvestment();
        } else if (e.getSource() == viewButton) {
            viewInvestments();
        } else if (e.getSource() == deleteButton) {
            deleteInvestment();
        } else if (e.getSource() == totalInvestmentButton){
            calculateTotalInvestment()  ;
        }
    }   
public void addInvestment() {
    String name = nameField.getText();
    String category = categoryComboBox.getSelectedItem().toString();
    double amount;
    if (amountField.getText().isEmpty()) {
        JOptionPane.showMessageDialog(frame, "Please enter an amount.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else {
        amount = Double.parseDouble(amountField.getText());
    }
    String date = dateField.getText();

    try {
        // Insert the Investment into the database
        String sql = "INSERT INTO investment (name, category, amount, date) VALUES ('" + name + "', '" + category + "', " + amount + ", '" + date + "')";
        stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(frame, "Investment added successfully!");
        nameField.setText("");
        amountField.setText("");
        dateField.setText("");
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Error adding Investment to database.");
    }
}// Function to view Investments
public void viewInvestments() {
    try {
        // Retrieve Investments from database
        String sql = "SELECT * FROM investment";
        ResultSet rs = stmt.executeQuery(sql);

        // Create table model
        String[] columns = {"Name", "category", "Amount", "Date"};
        Object[][] data = new Object[100][4];
        int i = 0;
        while (rs.next()) {
            String name = rs.getString("name");
            String category = rs.getString("category");
            double amount = rs.getDouble("amount");
            String date = rs.getString("date");

            data[i][0] = name;
            data[i][1] = category;
            data[i][2] = amount;
            data[i][3] = date;
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(data, columns);

        // Set table model
        table.setModel(model);

    } catch (SQLException ex) {
        System.out.println("Error viewing investment: " + ex.getMessage());
    }
}

// Function to delete an Investment
public void deleteInvestment() {
    // Get selected row index
    int row = table.getSelectedRow();

    // Check if a row is selected
    if (row < 0) {
        JOptionPane.showMessageDialog(frame, "Please select an investment to delete.");
        return;
    }

    // Get Investment name
    String name = (String) table.getValueAt(row, 0);

    try {
        // Delete the Investment from the database
        String sql = "DELETE FROM investment WHERE name='" + name + "'";
        stmt.executeUpdate(sql);

        // Display success message
        JOptionPane.showMessageDialog(frame, "Investment deleted successfully!");

        // Refresh table
        viewInvestments();

    } catch (SQLException ex) {
        System.out.println("Error deleting investment: " + ex.getMessage());
    }
}

public double calculateTotalInvestment() {
    double total = 0;
    try {
        String sql = "SELECT amount FROM investment";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            total += rs.getDouble("amount");
        }
        totalField.setText(String.format("%.2f", total));
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return total;
}
public static void main(String[] args) {
    new InvestmentTracker();
}}

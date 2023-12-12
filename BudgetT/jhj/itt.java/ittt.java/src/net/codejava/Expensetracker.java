package net.codejava;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;


public class Expensetracker implements ActionListener {
    private Connection con;
    private Statement stmt;
    private JFrame frame;
    private JTable table;
    private JTextField nameField, amountField, dateField, totalField;
    private JComboBox<String> categoryField;
    private JButton addButton, viewButton, deleteButton, totalExpenseButton ;
    private JComboBox<String> categoryComboBox;

    public Expensetracker() {
        String[] categories = {"Grocery", "Rent", "Bills", "Entertainment", "Other"};
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
        frame = new JFrame("Expense Tracker");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // Add expense input fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 100, 20);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 10, 150, 20);
        frame.add(nameField);

        JLabel categoryLabel = new JLabel("Category:");
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
        addButton = new JButton("Add Expense");
        addButton.setBounds(10, 150, 150, 20);
        addButton.addActionListener(this);
        frame.add(addButton);

        viewButton = new JButton("View Expenses");
        viewButton.setBounds(170, 150, 150, 20);
        viewButton.addActionListener(this);
        frame.add(viewButton);

        deleteButton = new JButton("Delete Expense");
        deleteButton.setBounds(330, 150, 150, 20);
        deleteButton.addActionListener(this);
        frame.add(deleteButton);

        // Add table
        table = new JTable();
        table.setBounds(10, 200, 560, 150);
        frame.add(table);

        // Add total Expense label
        totalField = new JTextField();
		totalField.setBounds(300, 30, 120, 20);
        totalField.setEditable(false);
        frame.add(totalField);

        totalExpenseButton = new JButton("Total Expense");
        totalExpenseButton.setBounds(300, 0, 150, 20);
        totalExpenseButton.addActionListener(this);
        frame.add(totalExpenseButton);

        

        // Set frame visibility
        frame.setLayout(null);
        frame.setVisible(true);
        try {
            // Retrieve expenses from database
            String sql = "SELECT * FROM expense";
            ResultSet rs = stmt.executeQuery(sql);
    
            // Create table model
            String[] columns = {"Name", "Category", "Amount", "Date"};
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
            System.out.println("Error viewing expense: " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addExpense();
        } else if (e.getSource() == viewButton) {
            viewExpenses();
        } else if (e.getSource() == deleteButton) {
            deleteExpense();
        } else if (e.getSource() == totalExpenseButton){
            calculateTotalExpense();
        } 
    }   
public void addExpense() {
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
        // Insert the expense into the database
        String sql = "INSERT INTO expense (name, category, amount, date) VALUES ('" + name + "', '" + category + "', " + amount + ", '" + date + "')";
        stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(frame, "Expense added successfully!");
        nameField.setText("");
        amountField.setText("");
        dateField.setText("");
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Error adding expense to database.");
    }
}// Function to view expenses
public void viewExpenses() {
    try {
        // Retrieve expenses from database
        String sql = "SELECT * FROM expense";
        ResultSet rs = stmt.executeQuery(sql);

        // Create table model
        String[] columns = {"Name", "Category", "Amount", "Date"};
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
        System.out.println("Error viewing expense: " + ex.getMessage());
    }
}

// Function to delete an expense
public void deleteExpense() {
    // Get selected row index
    int row = table.getSelectedRow();

    // Check if a row is selected
    if (row < 0) {
        JOptionPane.showMessageDialog(frame, "Please select an expense to delete.");
        return;
    }

    // Get expense name
    String name = (String) table.getValueAt(row, 0);

    try {
        // Delete the expense from the database
        String sql = "DELETE FROM expense WHERE name='" + name + "'";
        stmt.executeUpdate(sql);

        // Display success message
        JOptionPane.showMessageDialog(frame, "Expense deleted successfully!");

        // Refresh table
        viewExpenses();

    } catch (SQLException ex) {
        System.out.println("Error deleting expense: " + ex.getMessage());
    }
}

public double calculateTotalExpense() {
    double total = 0;
    try {
        String sql = "SELECT amount FROM expense";
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
    new Expensetracker();
}}

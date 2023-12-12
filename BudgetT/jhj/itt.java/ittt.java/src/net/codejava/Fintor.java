package net.codejava; 
import java.awt.Font;
import javax.swing.*;
import java.awt.*;

public class Fintor extends JFrame {

    public Fintor() {
        setTitle("FINTOR");
    
        
        JFrame frame = new JFrame();

        // this icon i want in the window icon.
        // ImageIcon img = new ImageIcon("icon.png");
        // setIconImage(img.getImage());


        JMenuBar menu = new JMenuBar();
        
        JMenu aboutJMenu = new JMenu("About us");
        JMenu expenseTracker = new JMenu("Expense Tracker");
        JMenu investJMenu = new JMenu("Investment Tracker");
        JMenu savingJMenu = new JMenu("Tax Calculator");
        // JMenu quesJMenu = new JMenu("Questionnaire");
        JMenuItem aboMenuItem = new JMenuItem("Abous Us");
        JMenuItem invItem = new JMenuItem("Investment Tracker");
        JMenuItem savItem = new JMenuItem("Tax Calculator");
        JMenuItem expItem = new JMenuItem("Expense Tracker");
        // JMenuItem qMenuItem = new JMenuItem("Questionnaire");
        menu.add(aboutJMenu);
        menu.add(expenseTracker);
        menu.add(investJMenu);
        menu.add(savingJMenu);
        // menu.add(quesJMenu);
        frame.setJMenuBar(menu);
        investJMenu.add(invItem);
        savingJMenu.add(savItem);
        expenseTracker.add(expItem);
        // quesJMenu.add(qMenuItem);
        aboutJMenu.add(aboMenuItem);
     


        aboMenuItem.addActionListener(e -> { 
            JPanel aboutUsPanel = new JPanel();
            aboutUsPanel.setLayout(new BoxLayout(aboutUsPanel, BoxLayout.Y_AXIS));

            JLabel aboutUsLabel = new JLabel("About Us");
            aboutUsLabel.setFont(new Font("Arial", Font.BOLD, 24));
            aboutUsLabel.setForeground(Color.BLUE);
            aboutUsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            String descriptionText = "<html>The objective of this project is to develop a comprehensive financial management<br>"
                    + "application that will assist users in managing their finances ,the application will<br>"
                    + "include several features ,including a Expense tracker, Tax Calculator and Investment Portfolio<br>"
                    + "portfolio<br></html>";

            JLabel descriptionLabel = new JLabel(descriptionText);
            descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            

            aboutUsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            aboutUsPanel.add(aboutUsLabel);
            aboutUsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            aboutUsPanel.add(descriptionLabel);
            // aboutUsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            // aboutUsPanel.add(imageLabel);
            // JLabel label = new JLabel("<html>Click <a href=\"https://www.example.com\">here</a> to visit our website.</html>");
            // aboutUsPanel.add(label); 
            JOptionPane.showMessageDialog(frame, aboutUsPanel, "About Us", JOptionPane.PLAIN_MESSAGE);
        });

        // add action listeners to the buttons
        invItem.addActionListener(e -> {
            // create a new instance of the ExpenseTracker frame
            new InvestmentTracker();

            // set the size and visibility of the ExpenseTracker frame
        });
        savItem.addActionListener(e -> {
            // create a new instance of the ExpenseTracker frame
            new TaxCalculator();

            // set the size and visibility of the ExpenseTracker frame
        });

        expItem.addActionListener(e -> {
            // create a new instance of the ExpenseTracker frame
            new Expensetracker();

            // set the size and visibility of the ExpenseTracker frame
        });

        // qMenuItem.addActionListener(e -> {
        //     // create a new instance of the ExpenseTracker frame
        //     new fer();

        //     // set the size and visibility of the ExpenseTracker frame
        // });

        // add the buttons to the MainGUI
        JPanel buttonPanel = new JPanel();
       
        getContentPane().add(buttonPanel);


        JLabel headJLabel = new JLabel();
        
        headJLabel.setText("Welcome to Fintor");
        

        headJLabel.setFont(new Font("Arial", Font.BOLD, 40));
       
        headJLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(headJLabel);
        JLabel logo = new JLabel();
         logo.setIcon(new ImageIcon(Fintor.class.getResource("./fotu.jpg")));
         logo.setVerticalAlignment((int) CENTER_ALIGNMENT);
         logo.setHorizontalAlignment((int) CENTER_ALIGNMENT);
         frame.add(logo);
        
        // set the size and visibility of the FintorGUI
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Fintor();
      
            
    } }

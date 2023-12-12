package net.codejava;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.Format.Field;

class fer extends JFrame implements ActionListener {

    private JLabel titleLabel;
    private JLabel subtitleLabel;
    private JLabel question1Label;
    private JLabel question2Label;
    private JLabel question3Label;
    private JLabel question4Label;
    private JLabel question5Label;
    private JLabel question6Label;
    private JLabel question7Label;
    private JLabel question8Label;
    private JLabel question9Label;
    private JLabel question10Label;
    private JLabel question11Label;
    private JLabel question12Label;
    private JLabel question13Label;
    private JLabel question14Label;
    private JLabel question15Label;
    private JLabel question16Label;
    private JLabel question17Label;
    private JLabel question18Label;
    private JLabel question19Label;
    private JLabel question20Label;
    private JLabel question21Label;
    private JTextField question1Field;
    private JTextField question2Field;
    private JTextField question3Field;
    private JTextField question4Field;
    private JTextField question5Field;
    private JTextField question6Field;
    private JTextField question7Field;
    private JTextField question8Field;
    private JTextField question9Field;
    private JTextField question10Field;
    private JTextField question11Field;
    private JTextField question12Field;
    private JTextField question13Field;
    private JTextField question14Field;
    private JTextField question15Field;
    private JTextField question16Field;
    private JTextField question17Field;
    private JTextField question18Field;
    private JTextField question19Field;
    private JTextField question20Field;
    private JTextField question21Field;
    private JButton submitButton;
    private JButton clearButton;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public fer() {
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        // Set up the window
        frame.setTitle("Financial Goals Module");
        frame.setSize(600, 700);
       
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        // Connect to the database
         try {
            Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionnaire", "root", "white");
             stmt = conn.createStatement();
            } catch (Exception e) {
             System.out.println(e);
         }

        // Add the title and subtitle labels
        titleLabel = new JLabel("Financial Goals Questionnaire");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(140, 10, 300, 40);
        frame.add(titleLabel);

        subtitleLabel = new JLabel("Please answer the following questions to help us understand your financial goals and needs.");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitleLabel.setBounds(20, 50, 560, 20);
        frame.add(subtitleLabel);

        // Add the questions and text fields
        question1Label = new JLabel("1. What is your current income?");
        question1Label.setBounds(20, 80, 200, 20);
        frame.add(question1Label);

        question1Field = new JTextField();
        question1Field.setBounds(240, 80, 100, 20);
        frame.add(question1Field);

        question2Label = new JLabel("2. What is your monthly rent/mortgage payment?");
        question2Label.setBounds(20, 110, 300, 20);
        frame.add(question2Label);

        question2Field = new JTextField();
        question2Field.setBounds(320, 110, 100, 20);
        frame.add(question2Field);

        question3Label = new JLabel("3. What is your monthly academic expenses?");
question3Label.setBounds(20, 140, 250, 20);
frame.add(question3Label);

    question3Field = new JTextField();
    question3Field.setBounds(270, 140, 100, 20);
    frame.add(question3Field);

    question4Label = new JLabel("4. What is your monthly credit card payment?");
    question4Label.setBounds(20, 170, 280, 20);
    frame.add(question4Label);

    question4Field = new JTextField();
    question4Field.setBounds(310, 170, 100, 20);
    frame.add(question4Field);

    question5Label = new JLabel("5. What is your current total debt?");
    question5Label.setBounds(20, 200, 200, 20);
    frame.add(question5Label);

    question5Field = new JTextField();
    question5Field.setBounds(240, 200, 100, 20);
    frame.add(question5Field);

    question6Label = new JLabel("6. What is your current net worth?");
    question6Label.setBounds(20, 230, 200, 20);
    frame.add(question6Label);

    question6Field = new JTextField();
    question6Field.setBounds(240, 230, 100, 20);
    frame.add(question6Field);

    question7Label = new JLabel("7. How much do you save each month?");
    question7Label.setBounds(20, 260, 250, 20);
    frame.add(question7Label);

    question7Field = new JTextField();
    question7Field.setBounds(270, 260, 100, 20);
    frame.add(question7Field);

    question8Label = new JLabel("8. What is your target retirement age?");
    question8Label.setBounds(20, 290, 220, 20);
    frame.add(question8Label);

    question8Field = new JTextField();
    question8Field.setBounds(240, 290, 100, 20);
    frame.add(question8Field);

    question9Label = new JLabel("9. What is your estimated retirement income needed?");
    question9Label.setBounds(20, 320, 350, 20);
    frame.add(question9Label);

    question9Field = new JTextField();
    question9Field.setBounds(370, 320, 100, 20);
    frame.add(question9Field);

    question10Label = new JLabel("10. How much do you currently have saved for retirement?");
    question10Label.setBounds(20, 350, 350, 20);
    frame.add(question10Label);

    question10Field = new JTextField();
    question10Field.setBounds(370, 350, 100, 20);
    frame.add(question10Field);

    question11Label = new JLabel("11. What is your target emergency fund amount?");
    question11Label.setBounds(20, 380, 300, 20);
    frame.add(question11Label);

    question11Field = new JTextField();
    question11Field.setBounds(320, 380, 100, 20);
    frame.add(question11Field);

    question12Label = new JLabel("12. How much do you spend on groceries each month?");
question12Label.setBounds(20, 410, 300, 20);
frame.add(question12Label);

        question12Field = new JTextField();
    question12Field.setBounds(320, 410, 100, 20);
    frame.add(question12Field);

    question13Label = new JLabel("13. How much do you spend on dining out each month?");
    question13Label.setBounds(20, 440, 300, 20);
    frame.add(question13Label);

    question13Field = new JTextField();
    question13Field.setBounds(320, 440, 100, 20);
    frame.add(question13Field);

    question14Label = new JLabel("14. How much do you spend on entertainment each month?");
    question14Label.setBounds(20, 470, 320, 20);
    frame.add(question14Label);

    question14Field = new JTextField();
    question14Field.setBounds(320, 470, 100, 20);
    frame.add(question14Field);

    question15Label = new JLabel("15. How much do you spend on transportation each month?");
    question15Label.setBounds(20, 500, 320, 20);
    frame.add(question15Label);

    question15Field = new JTextField();
    question15Field.setBounds(320, 500, 100, 20);
    frame.add(question15Field);

    question16Label = new JLabel("16. How much do you spend on healthcare each month?");
    question16Label.setBounds(20, 530, 300, 20);
    frame.add(question16Label);

    question16Field = new JTextField();
    question16Field.setBounds(320, 530, 100, 20);
    frame.add(question16Field);

    question17Label = new JLabel("17. How much do you spend on insurance each month?");
    question17Label.setBounds(20, 560, 300, 20);
    frame.add(question17Label);

    question17Field = new JTextField();
    question17Field.setBounds(320, 560, 100, 20);
    frame.add(question17Field);

    question18Label = new JLabel("18. How much do you spend on charity each month?");
    question18Label.setBounds(20, 590, 300, 20);
    frame.add(question18Label);

    question18Field = new JTextField();
    question18Field.setBounds(320, 590, 100, 20);
    frame.add(question18Field);

    question19Label = new JLabel("19. How much do you spend on education each month?");
    question19Label.setBounds(20, 620, 300, 20);
    frame.add(question19Label);

    question19Field = new JTextField();
    question19Field.setBounds(320, 620, 100, 20);
    frame.add(question19Field);

    question20Label = new JLabel("20. How much do you spend on travel each year?");
    question20Label.setBounds(20, 650, 300, 20);
    frame.add(question20Label);

    question20Field = new JTextField();
    question20Field.setBounds(320, 650, 100, 20);
    frame.add(question20Field);

    question21Label = new JLabel("21. How much do you spend on other expenses each month?");
    question21Label.setBounds(20, 680, 320, 20);
    frame.add(question21Label);

    question21Field = new JTextField();
    question21Field.setBounds(320, 680, 100, 20);
    frame.add(question21Field);

// Add the submit button
JButton submitButton = new JButton("Submit");
submitButton.setBounds(450, 710, 80, 20);
frame.add(submitButton);
// Add an ActionListener to the submit button
submitButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // retrieve the values of the 21 questions
                String[] answer = new String[21];
        for (int i = 0; i < 21; i++) {
            try {
                // get the field for the ith question
                java.lang.reflect.Field field = getClass().getDeclaredField("question" + (i + 1) + "textfield");
                field.setAccessible(true);

                // get the value of the field
                JTextField textField = (JTextField) field.get(this);
                answer[i] = textField.getText();
            } catch (Exception ex) {
                // handle exceptions
            }
        }

        // connect to the MySQL database
      
        String url = "jdbc:mysql://localhost:3306/questionnaire";
        String user = "root";
        String password = "white";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO questions(answer1, answer2) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "value1");
            pstmt.setString(2, "value2");
            pstmt.executeUpdate();
        } catch (Exception f) {
            f.printStackTrace();
        }
    }
});


// Add the continue button
JButton continueButton = new JButton("Continue");
continueButton.setBounds(550, 710, 100, 20);
frame.add(continueButton);
frame.setSize(1000, 2000);
frame.setVisible(true);

// Add an ActionListener to the continue button
continueButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Move to the next question (e.g. by changing the GUI components)
    
        // ...
    }
    
});}

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    public static void main(String[] args) {
        new fer();
    }
}




package codejava.net;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuFrame extends JFrame implements ActionListener {
   JMenuBar menubar;
   JMenu registrationMenu, loginMenu;
   JMenuItem registerItem, loginItem;
   
   public MenuFrame() {
      JFrame frame = new JFrame("Fintor");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // create the menu bar and menus
      menubar = new JMenuBar();
      registrationMenu = new JMenu("Registration");
      loginMenu = new JMenu("Login");
      
      // create the menu items and add them to the menus
      registerItem = new JMenuItem("Register");
      loginItem = new JMenuItem("Login");
      registrationMenu.add(registerItem);
      loginMenu.add(loginItem);
      
      // add the menus to the menu bar
      menubar.add(registrationMenu);
      menubar.add(loginMenu);
      
      
      // add action listeners to the menu items
      registerItem.addActionListener(this);
      loginItem.addActionListener(this);
    

       // heading 
       JLabel headingLabel = new JLabel("Welcome to Fintor");
       headingLabel.setFont(new Font("Arial", Font.BOLD, 40));
       headingLabel.setForeground(Color.black);
       headingLabel.setHorizontalAlignment(JLabel.CENTER);
       headingLabel.setAlignmentY(CENTER_ALIGNMENT);
      frame.add(headingLabel, BorderLayout.CENTER);
      
       frame.setJMenuBar(menubar);
       frame.setSize(600, 600);
       frame.setVisible(true);
       frame.setLocationRelativeTo(null);
   }
   
   // implement the action performed method for the menu items
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == registerItem) {
         new RegistrationForm();
      } else if (e.getSource() == loginItem) {
         LoginForm Loginform = new LoginForm();
         Loginform.initialize();
         dispose();
      }
   }
   
   
   // main method to run the frame
   public static void main(String[] args) {
      new MenuFrame();
   }
}

class RegistrationForm {

   JLabel label1,label2,label3,label4,label5,label6,
   label7,label8,label9,label10,label11,label12,s1,s2,s3;
   JPanel panel;
   JFrame jf;
   JButton register;
   JTextField textfield1,textfield2,textfield3,textfield4a,
   textfield4b,textfield4c,textfield5,textfield6,textfield7,textfield8,textfield9;
   JPasswordField passwordfield1;

   String name,domain,passwordd,
   mobileNumber,email,college;

   Connection con1;
   Statement st1;
   int index,count;

   
   public RegistrationForm()
   {
   initComponents();
   event();
   
   }
   
   private void event() {
   }

   public void initComponents() {
   jf=new JFrame("Registration Form");
   panel=new JPanel();
   jf.add(panel);
   // panel.setBackground(new Color(191,239,255));
   panel.setLayout(null);
   jf.setSize(700,450);
   jf.show();
   jf.setLocationRelativeTo(null);
   
   label1=new JLabel("Register To Fintor");
   label1.setFont(new Font("Dialog", Font.ITALIC, 30));
   label1.setBounds(170,20,400,40);
   panel.add(label1);
   
   label2=new JLabel("Name");
   label2.setFont(new Font("Dialog", Font.BOLD, 20));
   label2.setBounds(100,80,150,40);
   panel.add(label2);
   

   
   label4=new JLabel("Password");
   label4.setFont(new Font("Dialog", Font.BOLD, 20));
   label4.setBounds(100,140,150,40);
   panel.add(label4);
   

   
   label6=new JLabel("Mobile Number");
   label6.setFont(new Font("Dialog", Font.BOLD, 20));
   label6.setBounds(100,200,150,40);
   panel.add(label6);
   
   label7=new JLabel("E-mail");
   label7.setFont(new Font("Dialog", Font.BOLD, 20));
   label7.setBounds(100,260,150,40);
   panel.add(label7);

   
   textfield1=new JTextField();
   textfield1.setFont(new Font("Dialog", Font.BOLD, 16));
   textfield1.setBounds(350,80,180,30);
   panel.add(textfield1);
   
 

   
   
   
   textfield3=new JPasswordField();
   textfield3.setFont(new Font("Dialog", Font.BOLD, 16));
   textfield3.setBounds(350,140,180,30);
   panel.add(textfield3);
   
   // textfield4a=new JTextField();
   // textfield4a.setFont(new Font("Dialog", Font.BOLD, 16));
   // textfield4a.setBounds(350,200,180,30);
   // panel.add(textfield4a);
   
   textfield5=new JTextField();
   textfield5.setFont(new Font("Dialog", Font.BOLD, 16));
   textfield5.setBounds(350,200,180,30);
   panel.add(textfield5);
   
   textfield6=new JTextField();
   textfield6.setFont(new Font("Dialog", Font.BOLD, 16));
   textfield6.setBounds(350,260,180,30);
   panel.add(textfield6);
   
   // textfield7=new JTextField();
   // textfield7.setFont(new Font("Dialog", Font.BOLD, 16));
   // textfield7.setBounds(350,320,180,30);
   // panel.add(textfield7);
   

   
   register = new JButton("Register");
   register.setFont(new Font("Dialog", Font.BOLD, 16));
   register.setBounds(250,320,100,30);
   panel.add(register);
   
   register.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {

   String name = textfield1.getText();
   String passwordd = textfield3.getText();
   // String domain = textfield4a.getText();
   String email = textfield6.getText();
   String phone = textfield5.getText();
   // String college = textfield7.getText();
   // connect to the database and insert the user information
   try {
      // replace the database_url, username, and password with your own values
      String database_url = "jdbc:mysql://localhost:3306/project";
      String username = "root";
      String password = "";
      
      // load the JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      // create a connection to the database
      Connection conn = DriverManager.getConnection(database_url, username, password);
      
      // create a statement to insert the user information
      String query = "INSERT INTO users (name, password,email, phone) VALUES (?, ?, ?, ?)";
      PreparedStatement statement = conn.prepareStatement(query);
      statement.setString(1, name);
      statement.setString(2, passwordd);
      // statement.setString(3, domain);
      statement.setString(3, email);
      statement.setString(4, phone);
     // statement.setString(6, college);
      int rowsInserted = statement.executeUpdate();
      
      if (rowsInserted > 0) {
          JOptionPane.showMessageDialog(null, "Registration Successful!");
         
      }
      
      // close the connection and statement objects
      statement.close();
      conn.close();
      
   } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "JDBC driver not found!");
   } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
   }
}
   });
}
   
   
   public static void main(String args[]) {
      new RegistrationForm();
      System.out.println("Registration Form");
         }
   }

   class LoginForm extends JFrame {
      final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
      JTextField tfEmail;
      JPasswordField pfPassword;
  
      public void initialize() {
          /*************** Form Panel ***************/
          JLabel lbLoginForm = new JLabel("Login to Fintor", SwingConstants.CENTER);
          lbLoginForm.setFont(mainFont);
  
          JLabel lbEmail = new JLabel("Email");
          lbEmail.setFont(mainFont);
  
          tfEmail = new JTextField();
          tfEmail.setFont(mainFont);
  
          JLabel lbPassword = new JLabel("Password");
          lbPassword.setFont(mainFont);
  
          pfPassword = new JPasswordField();
          pfPassword.setFont(mainFont);
  
          JPanel formPanel = new JPanel();
          formPanel.setLayout(new GridLayout(0, 1, 10, 10));
          formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
          formPanel.add(lbLoginForm);
          formPanel.add(lbEmail);
          formPanel.add(tfEmail);
          formPanel.add(lbPassword);
          formPanel.add(pfPassword);
  
          /*************** Buttons Panel ***************/
          JButton btnLogin = new JButton("Login");
          btnLogin.setFont(mainFont);
         //  new MenuExample().setVisible(true);
         //  btnLogin.addActionListener(new ActionListener() {
  
           
              
         //  });
  
          JButton btnCancel = new JButton("Cancel");
          btnCancel.setFont(mainFont);
          btnCancel.addActionListener(new ActionListener() {
  
              @Override
              public void actionPerformed(ActionEvent e) {
                  // TODO Auto-generated method stub
                  dispose();
              }
              
          });
  
          JPanel buttonsPanel = new JPanel();
          buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
          buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
          buttonsPanel.add(btnLogin);
          buttonsPanel.add(btnCancel);
  
  
  
          /*************** Initialise the frame ***************/
          add(formPanel, BorderLayout.NORTH);
          add(buttonsPanel, BorderLayout.SOUTH);
  
          setTitle("Login Form");
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          setSize(400, 500);
          setMinimumSize(new Dimension(350, 450));
          //setResizable(false);
          setLocationRelativeTo(null);
          setVisible(true);
   
   // implement the action performed method for the login button
   btnLogin.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent e) {
      String email = tfEmail.getText();
      String password = new String(pfPassword.getPassword());
  
      try {
         // connect to the MySQL database
         String url = "jdbc:mysql://localhost:3306/project";
         String user = "root";
         String passwordDB = "";
         Connection con = DriverManager.getConnection(url, user, passwordDB);
         
         // create a statement and execute the query
         Statement stmt = con.createStatement();
         String query = "SELECT * FROM users WHERE email='" + email + "' AND password='" + password + "'";
         ResultSet rs = stmt.executeQuery(query);

         dispose();
         
         // MenuFrame m = new MenuFrame();
         
         // check if the user exists in the database
         if (rs.next()) {
            net.codejava.Fintor mainFrame = new net.codejava.Fintor();
         
            

         } else {
            JOptionPane.showMessageDialog(null, "Invalid Email or Password!");
         }
         
         // close the statement and connection
         stmt.close();
         con.close();
      } catch (SQLException ex) {
         ex.printStackTrace();
      }
      // new MenuExample().setVisible(true);
   }
});
}
public static void main(String[] args) {
   LoginForm form = new LoginForm();
   form.initialize();
}
   }

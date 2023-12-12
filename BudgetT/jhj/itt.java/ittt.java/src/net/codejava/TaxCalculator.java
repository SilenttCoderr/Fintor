package net.codejava;

import javax.swing.*;
import java.awt.event.*;

public class TaxCalculator extends JFrame implements ActionListener {
    private JLabel lblAge, lblSalary, lbl80C, lbl80CCD, lbl80D, lblHRAReceived, lblRentPaid, lblInterestHomeLoan, lblInterestEduLoan, lblTax, lblResult;
    private JComboBox<String> cmbAge;
    private JTextField txtSalary, txt80C, txt80CCD, txt80D, txtHRAReceived, txtRentPaid, txtInterestHomeLoan, txtInterestEduLoan, txtTax;
    private JButton btnCalculate;
    
    public TaxCalculator() {
        // Set up the JFrame
        super("Tax Calculator");
        setSize(500, 600);
        setLocationRelativeTo(null);
        
        // Create the components
        lblAge = new JLabel("Age Bracket:");
		lblAge.setBounds(10, 0, 200, 40);
        lblSalary = new JLabel("Annual Salary:");
		lblSalary.setBounds(10, 50, 200, 40);
        lbl80C = new JLabel("Investment under 80C:");
		lbl80C.setBounds(10, 100, 200, 40);
        lbl80CCD = new JLabel("Investment under 80CCD(1B):");
		lbl80CCD.setBounds(10, 150, 200, 40);
        lbl80D = new JLabel("Medical Insur. Premium u/s 80D:");
		lbl80D.setBounds(10, 200, 200, 40);
        lblHRAReceived = new JLabel("HRA Received:");
		lblHRAReceived.setBounds(10, 250, 200, 40);
        lblRentPaid = new JLabel("Rent Paid:");
		lblRentPaid.setBounds(10, 300, 200, 40);
        lblInterestHomeLoan = new JLabel("Interest on Home Loan:");
		lblInterestHomeLoan.setBounds(10, 350, 200, 40);
        lblInterestEduLoan = new JLabel("Interest on Educational Loan:");
		lblInterestEduLoan.setBounds(10, 400, 200, 40);
        lblTax = new JLabel("Tax to be paid:");
		lblTax.setBounds(10, 450, 200, 40);
        lblResult = new JLabel("");
		lblResult.setBounds(10, 500, 200, 40);
        cmbAge = new JComboBox<>(new String[]{"Up to 60 years", "60 to 80 years", "Above 80 years"});
		cmbAge.setBounds(230, 0, 120, 40);
        txtSalary = new JTextField(10);
		txtSalary.setBounds(230, 50, 120, 40);
        txt80C = new JTextField(10);
		txt80C.setBounds(230, 100, 120, 40);
        txt80CCD = new JTextField(10);
		txt80CCD.setBounds(230, 150, 120, 40);
        txt80D = new JTextField(10);
		txt80D.setBounds(230, 200, 120, 40);
        txtHRAReceived = new JTextField(10);
		txtHRAReceived.setBounds(230, 250, 120, 40);
        txtRentPaid = new JTextField(10);
		txtRentPaid.setBounds(230, 300, 120, 40);
        txtInterestHomeLoan = new JTextField(10);
		txtInterestHomeLoan.setBounds(230, 350, 120, 40);
        txtInterestEduLoan = new JTextField(10);
		txtInterestEduLoan.setBounds(230, 400, 120, 40);
        txtTax = new JTextField(10);
		txtTax.setBounds(230, 450, 120, 40);
        txtTax.setEditable(false);
        btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(15, 500, 450, 40);
        btnCalculate.addActionListener(this);
        
        // Set up the layout
        JPanel panel = new JPanel();
		panel.setLayout(null);
		
        panel.add(lblAge);
        panel.add(cmbAge);
        panel.add(lblSalary);
        panel.add(txtSalary);
        panel.add(lbl80C);
        panel.add(txt80C);
        panel.add(lbl80CCD);
        panel.add(txt80CCD);
        panel.add(lbl80D);
        panel.add(txt80D);
        panel.add(lblHRAReceived);
        panel.add(txtHRAReceived);
        panel.add(lblRentPaid);
        panel.add(txtRentPaid);
        panel.add(lblInterestHomeLoan);
        panel.add(txtInterestHomeLoan);
        panel.add(lblInterestEduLoan);
        panel.add(txtInterestEduLoan);
        panel.add(btnCalculate);
        panel.add(lblResult);
        panel.add(lblTax);
        panel.add(txtTax);
        add(panel);
        
        // Show the JFrame
        setVisible(true);
    }
	public void actionPerformed(ActionEvent e) {
        // Calculate the tax based on the inputs
        double age = cmbAge.getSelectedIndex();
        double salary = Double.parseDouble(txtSalary.getText());
        double investment80C = Double.parseDouble(txt80C.getText());
        double investment80CCD = Double.parseDouble(txt80CCD.getText());
        double medicalPremium = Double.parseDouble(txt80D.getText());
        double HRAReceived = Double.parseDouble(txtHRAReceived.getText());
        double rent = Double.parseDouble(txtRentPaid.getText());
		double InterestHomeLoan = Double.parseDouble(txtInterestHomeLoan.getText());
		double InterestEduLoan = Double.parseDouble(txtInterestEduLoan.getText());

		double tax = 0.0;
        
        if (age==0) {
            if (salary <= 250000) {
                tax = 0.0;
            } else if (salary > 250000 && salary <= 500000) {
                tax = (salary - 250000) * 0.05;
            } else if (salary > 500000 && salary <= 750000) {
                tax = 12500 + (salary - 500000) * 0.1;
            } else if (salary > 750000 && salary <= 1000000) {
                tax = 37500 + (salary - 750000) * 0.15;
            } else if (salary > 1000000 && salary <= 1250000) {
                tax = 75000 + (salary - 1000000) * 0.2;
            } else if (salary > 1250000 && salary <= 1500000) {
                tax = 125000 + (salary - 1250000) * 0.25;
            } else {
                tax = 187000 + (salary - 1500000) * 0.3;
            }
        } else if (age == 1) {
            if (salary <= 300000) {
                tax = 0.0;
            } else if (salary > 300000 && salary <= 500000) {
                tax = (salary - 300000) * 0.05;
            } else if (salary > 500000 && salary <= 1000000) {
                tax = 10000 + (salary - 500000) * 0.2;
            } else {
                tax = 110000 + (salary - 1000000) * 0.3;
            }
        } else {
            if (salary <= 500000) {
                tax = 0.0;
            } else if (salary > 500000 && salary <= 1000000) {
                tax = (salary - 500000) * 0.2;
            } else {
                tax = 100000 + (salary - 1000000) * 0.3;
            }
        }

		if(investment80C<150000){
			tax = tax-investment80C;
		}else{
			tax = tax-150000;
		}

		if(age==0){
			if(medicalPremium<25000){
			tax = tax-medicalPremium;
			}else{
				tax = tax-25000;
			}
		}else if(age==1){
			if(medicalPremium<50000){
				tax = tax-medicalPremium;
			}else{
				tax = tax-50000;
			}
		}

		tax = tax - (rent-(salary*0.1));

		if(InterestHomeLoan<200000){
			tax = tax-InterestHomeLoan;
		}else{
			tax = tax-200000;
		}

		txtTax.setText(String.format("%.2f", tax));


		
	}

	
	public static void main(String[]args) {
		new TaxCalculator();
	}
	
    
}
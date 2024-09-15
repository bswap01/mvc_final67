package mvc2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CowView extends JFrame {
    private CowController controller;
    private JTextField idEntry;
    private JLabel resultLabel;
    private JButton chaseGoatButton; 

    public CowView(CowController controller) {
        this.controller = controller;
        setTitle("Cow Milking System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel idLabel = new JLabel("Cow ID:");
        add(idLabel);

        idEntry = new JTextField(10);
        add(idEntry);

        JButton milkButton = new JButton("Milk");
        milkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milkButtonClicked();
            }
        });
        add(milkButton);

        chaseGoatButton = new JButton("kick Goat");
        chaseGoatButton.setVisible(false); 
        add(chaseGoatButton); 

        chaseGoatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.chaseGoatAway(); 
            }
        });

        resultLabel = new JLabel("");
        add(resultLabel);

        setVisible(true);
    }

    private void milkButtonClicked() {
        String cowId = idEntry.getText();
        controller.processCow(cowId);
    }

    public void showCowResult(int milkProduced, int totalMilk) {
        resultLabel.setText("Milk produced: " + milkProduced + " liters\nTotal milk: " + totalMilk + " liters");
        chaseGoatButton.setVisible(false); 
    }

    public void showGoatResult() {
        resultLabel.setText("This is a goat");
        chaseGoatButton.setVisible(true); 
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void displayReport(String report) {
        resultLabel.setText(report); 
    }
}
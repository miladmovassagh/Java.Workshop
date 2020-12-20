package view;

import controller.StoreController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClothingEdit {
    public static JFrame jFrame;

    public void edit() {
        jFrame = new JFrame("Clothing Edit");
        jFrame.setSize(400, 500);
        Font font = new Font("TimesRoman", Font.PLAIN, 17);
        Font font1 = new Font("TimesRoman", Font.BOLD, 16);
        JLabel lbltext = new JLabel("Enter the code of clothing you want for edit it");
        lbltext.setBounds(10, 20, 400, 20);
        lbltext.setFont(font1);
        lbltext.setVisible(true);
        JLabel lblCode = new JLabel("Code:");
        lblCode.setBounds(30, 70, 100, 30);
        lblCode.setFont(font);
        lblCode.setVisible(true);
        JTextField txtCode = new JTextField();
        txtCode.setBounds(120, 75, 80, 25);
        txtCode.setVisible(true);
        JLabel lbltext1 = new JLabel("Enter new data");
        lbltext1.setBounds(10,120,300,30);
        lbltext1.setFont(font1);
        lbltext1.setVisible(true);
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(30,160,100,30);
        lblName.setFont(font);
        lblName.setVisible(true);
        JTextField txtName = new JTextField();
        txtName.setBounds(100,165,120,25);
        txtName.setVisible(true);
        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, 210, 100, 30);
        lblGender.setFont(font);
        lblGender.setVisible(true);
        String[] gender = {"Male","Female"};
        JComboBox<String> cmBoxGender = new JComboBox<>(gender);
        cmBoxGender.setBounds(120, 210, 100, 30);
        cmBoxGender.setVisible(true);
        JLabel lblSize = new JLabel("Size:");
        lblSize.setBounds(30,260,100,30);
        lblSize.setFont(font);
        lblSize.setVisible(true);
        String[] size = {"Small","Medium","Large","XLarge"};
        JComboBox<String> cmBoxSize = new JComboBox<>(size);
        cmBoxSize.setBounds(120,260,100,30);
        cmBoxSize.setVisible(true);
        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(30,310,100,30);
        lblPrice.setFont(font);
        lblPrice.setVisible(true);
        JTextField txtPrice = new JTextField();
        txtPrice.setBounds(120,315,80,25);
        txtPrice.setVisible(true);
        JButton btnSave = new JButton("Edit");
        btnSave.setBounds(150,380,90,45);
        btnSave.setFont(font);
        btnSave.setVisible(true);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StoreController.getInstance().update(txtName.getText(), Integer.parseInt(txtCode.getText()), cmBoxGender.getSelectedItem().toString(), cmBoxSize.getSelectedItem().toString(), Long.parseLong(txtPrice.getText()));
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        jFrame.add(lbltext);
        jFrame.add(lblCode);
        jFrame.add(txtCode);
        jFrame.add(lbltext1);
        jFrame.add(lblName);
        jFrame.add(txtName);
        jFrame.add(lblGender);
        jFrame.add(cmBoxGender);
        jFrame.add(lblSize);
        jFrame.add(cmBoxSize);
        jFrame.add(lblPrice);
        jFrame.add(txtPrice);
        jFrame.add(btnSave);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}

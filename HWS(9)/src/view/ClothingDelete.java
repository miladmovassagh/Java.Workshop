package view;

import controller.StoreController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClothingDelete {
    public static JFrame jFrame;

    public void delete() {
        jFrame = new JFrame("Clothing Delete");
        jFrame.setSize(400, 300);
        Font font = new Font("TimesRoman", Font.PLAIN, 17);
        Font font1 = new Font("TimesRoman", Font.BOLD, 16);
        JLabel lbltext = new JLabel("Enter the code of clothing you want for delete it");
        lbltext.setBounds(10, 20, 400, 20);
        lbltext.setFont(font1);
        lbltext.setVisible(true);
        JLabel lblCode = new JLabel("Code:");
        lblCode.setBounds(30, 80, 100, 30);
        lblCode.setFont(font);
        lblCode.setVisible(true);
        JTextField txtCode = new JTextField();
        txtCode.setBounds(120, 85, 80, 25);
        txtCode.setVisible(true);
        JButton btnSave = new JButton("Delete");
        btnSave.setBounds(150,180,80,40);
        btnSave.setFont(font);
        btnSave.setVisible(true);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StoreController.getInstance().delete(Integer.parseInt(txtCode.getText()));
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        jFrame.add(lbltext);
        jFrame.add(lblCode);
        jFrame.add(txtCode);
        jFrame.add(btnSave);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}

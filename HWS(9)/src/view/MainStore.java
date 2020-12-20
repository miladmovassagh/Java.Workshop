package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainStore {
    private JFrame jFrame;

    public MainStore() {
        jFrame = new JFrame("Clothing Store");
        jFrame.setSize(400,440);
        Font font = new Font("TimesRoman",Font.BOLD,16);
        Font font1 = new Font("TimesRoman",Font.ITALIC,15);
        JLabel lblWelcome = new JLabel("Welcome");
        lblWelcome.setBounds(150,10,100,30);
        lblWelcome.setVisible(true);
        lblWelcome.setFont(font);
        JLabel lblSelect = new JLabel("Select the option you want");
        lblSelect.setBounds(90,40,300,30);
        lblSelect.setFont(font);
        lblSelect.setVisible(true);
        JButton btnRegistration = new JButton("Registration of clothing");
        btnRegistration.setBounds(0,100,400,100);
        btnRegistration.setFont(font1);
        btnRegistration.setVisible(true);
        btnRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                ClothingRegistration clothingRegistration = new ClothingRegistration();
                clothingRegistration.registration();
            }
        });
        JButton btnEdit = new JButton("Edit clothing");
        btnEdit.setBounds(0,200,400,100);
        btnEdit.setFont(font1);
        btnEdit.setVisible(true);
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                ClothingEdit clothingEdit = new ClothingEdit();
                clothingEdit.edit();
            }
        });
        JButton btnRemove = new JButton("Delete clothing");
        btnRemove.setBounds(0,300,400,100);
        btnRemove.setFont(font1);
        btnRemove.setVisible(true);
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                ClothingDelete clothingDelete = new ClothingDelete();
                clothingDelete.delete();
            }
        });
        jFrame.add(lblWelcome);
        jFrame.add(lblSelect);
        jFrame.add(btnRegistration);
        jFrame.add(btnEdit);
        jFrame.add(btnRemove);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}

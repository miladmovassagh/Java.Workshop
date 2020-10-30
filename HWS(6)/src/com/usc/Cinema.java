package com.usc;

import javax.swing.*;
import java.awt.event.*;

public abstract class Cinema {
    private String cinemaName;
    private String ticketPrice;
    private JFrame jFrame;
    private JDialog jDialog;

    public Cinema() {

    }

    public Cinema(String cinemaName, String ticketPrice) {
        this.cinemaName = cinemaName;
        this.ticketPrice = ticketPrice;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void mainPage() {
        jFrame = new JFrame(cinemaName);
        jFrame.setSize(400, 450);
        JLabel welcomeText = new JLabel("Welcome to the " + cinemaName);
        welcomeText.setBounds(100, 5, 200, 50);
        welcomeText.setVisible(true);
        jFrame.add(welcomeText);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    public void addApplicant(String applicantNumber, String applicantText, int bX, int bY, int bWidth, int bHeight, int tX, int tY, int tWidth, int tHeight) {
        JButton applicantButton = new JButton(applicantNumber);
        applicantButton.setBounds(bX, bY, bWidth, bHeight);
        applicantButton.setVisible(true);
        JLabel applicanttext = new JLabel(applicantText);
        applicanttext.setBounds(tX, tY, tWidth, tHeight);
        applicanttext.setVisible(true);
        applicantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog = new JDialog();
                jDialog.setTitle("Movies Screened");
                jDialog.setSize(350, 400);
                JLabel choiceText = new JLabel("Movies being screened");
                choiceText.setBounds(30, 15, 200, 50);
                choiceText.setVisible(true);
                jDialog.add(choiceText);
                jDialog.setLocationRelativeTo(jFrame);
                jDialog.setLayout(null);
                jDialog.setVisible(true);
                showMoviesScreened();
            }
        });
        jFrame.add(applicantButton);
        jFrame.add(applicanttext);
    }

    public void addMovieScreened(String movieNumber, int bX, int bY, int bWidth, int bHeight, int tX, int tY, int tWidth, int tHeight, String filmName, String genre, String director) {
        JButton filmButton = new JButton(movieNumber);
        filmButton.setBounds(bX, bY, bWidth, bHeight);
        filmButton.setVisible(true);
        JLabel filmText = new JLabel(filmName);
        filmText.setBounds(tX, tY, tWidth, tHeight);
        filmText.setVisible(true);
        filmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFilmInformation(genre, director);
                jDialog.dispose();
            }
        });
        jDialog.add(filmButton);
        jDialog.add(filmText);
    }

    public abstract void showMoviesScreened();

    public void showFilmInformation(String genre, String director) {
        JDialog filmInfo = new JDialog();
        filmInfo.setTitle("Information of Movie");
        filmInfo.setSize(350, 400);
        JLabel genre1 = new JLabel("Genre: " + genre);
        genre1.setBounds(30, 20, 150, 50);
        genre1.setVisible(true);
        JLabel director1 = new JLabel("Director: " + director);
        director1.setBounds(30, 80, 150, 50);
        director1.setVisible(true);
        JLabel price = new JLabel("Price: " + ticketPrice);
        price.setBounds(30, 140, 150, 50);
        price.setVisible(true);
        JButton buyTicket = new JButton("Buy Ticket");
        buyTicket.setBounds(35, 220, 120, 50);
        buyTicket.setVisible(true);
        buyTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyTicket();
                filmInfo.dispose();
            }
        });
        JButton cancelTicket = new JButton("Cancel Ticket");
        cancelTicket.setBounds(175, 220, 120, 50);
        cancelTicket.setVisible(true);
        cancelTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelTicket();
                filmInfo.dispose();
            }
        });
        filmInfo.add(genre1);
        filmInfo.add(director1);
        filmInfo.add(price);
        filmInfo.add(buyTicket);
        filmInfo.add(cancelTicket);
        filmInfo.setLocationRelativeTo(jFrame);
        filmInfo.setLayout(null);
        filmInfo.setVisible(true);
    }

    public void buyTicket() {
        JDialog buyTicket = new JDialog();
        buyTicket.setTitle("Buy Ticket");
        buyTicket.setSize(350, 400);
        JLabel name = new JLabel("enter your name:");
        name.setBounds(30, 40, 125, 35);
        name.setVisible(true);
        JTextField nameField = new JTextField();
        nameField.setBounds(140, 45, 150, 25);
        nameField.setVisible(true);
        JLabel ticketNumber = new JLabel("enter the number of tickets:");
        ticketNumber.setBounds(30, 100, 175, 35);
        ticketNumber.setVisible(true);
        JTextField ticketNumberField = new JTextField();
        ticketNumberField.setBounds(200, 105, 30, 30);
        ticketNumberField.setVisible(true);
        JButton buy = new JButton("Buy Ticket");
        buy.setBounds(110, 200, 100, 50);
        buy.setVisible(true);
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i, temp = 1;
                JDialog answer = new JDialog();
                answer.setTitle("Answer");
                answer.setSize(250, 100);
                JLabel answerText = new JLabel();
                for(i = 0; i < ticketNumberField.getText().length(); i++) {
                    if(!Character.isDigit(ticketNumberField.getText().charAt(i))) {
                        temp = 0;
                        answerText.setText("enter the number of ticket correctly");
                    }
                }
                for(i = 0; i < nameField.getText().length(); i++) {
                    if(!Character.isLetter(nameField.getText().charAt(i)) && !Character.isSpaceChar(nameField.getText().charAt(i))) {
                        temp = 0;
                        answerText.setText("enter the name correctly");
                    }
                }
                if(nameField.getText().isEmpty() && ticketNumberField.getText().isEmpty()) {
                    temp = 0;
                    answerText.setText("enter the information correctly");
                }
                if(temp != 0) {
                    buyTicket.dispose();
                    answerText.setText("Ticket bought");
                }
                answerText.setBounds(30, 40, 80, 30);
                answerText.setVisible(true);
                answer.add(answerText);
                answer.setLocationRelativeTo(buyTicket);
                answer.setVisible(true);
            }
        });
        buyTicket.add(name);
        buyTicket.add(nameField);
        buyTicket.add(ticketNumber);
        buyTicket.add(ticketNumberField);
        buyTicket.add(buy);
        buyTicket.setLocationRelativeTo(jFrame);
        buyTicket.setLayout(null);
        buyTicket.setVisible(true);
    }

    public void cancelTicket() {
        JDialog cancelTicket = new JDialog();
        cancelTicket.setTitle("Cancel Ticket");
        cancelTicket.setSize(350, 400);
        JLabel name = new JLabel("enter your name:");
        name.setBounds(30, 40, 125, 35);
        name.setVisible(true);
        JTextField nameField = new JTextField();
        nameField.setBounds(140, 45, 150, 25);
        nameField.setVisible(true);
        JLabel ticketNumber = new JLabel("enter the number of tickets:");
        ticketNumber.setBounds(30, 100, 175, 35);
        ticketNumber.setVisible(true);
        JTextField ticketNumberField = new JTextField();
        ticketNumberField.setBounds(200, 105, 30, 30);
        ticketNumberField.setVisible(true);
        JButton cancel = new JButton("Cancel Ticket");
        cancel.setBounds(100, 200, 120, 50);
        cancel.setVisible(true);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i, temp = 1;
                JDialog answer = new JDialog();
                answer.setTitle("Answer");
                answer.setSize(250, 100);
                JLabel answerText = new JLabel();
                for(i = 0; i < ticketNumberField.getText().length(); i++) {
                    if(!Character.isDigit(ticketNumberField.getText().charAt(i))) {
                        temp = 0;
                        answerText.setText("enter the number of ticket correctly");
                    }
                }
                for(i = 0; i < nameField.getText().length(); i++) {
                    if(!Character.isLetter(nameField.getText().charAt(i)) && !Character.isSpaceChar(nameField.getText().charAt(i))) {
                        temp = 0;
                        answerText.setText("enter the name correctly");
                    }
                }
                if(nameField.getText().isEmpty() && ticketNumberField.getText().isEmpty()) {
                    temp = 0;
                    answerText.setText("enter the information correctly");
                }
                if(temp != 0) {
                    cancelTicket.dispose();
                    answerText.setText("Ticket canceled");
                }
                answerText.setBounds(30, 40, 80, 30);
                answerText.setVisible(true);
                answer.add(answerText);
                answer.setLocationRelativeTo(cancelTicket);
                answer.setVisible(true);
            }
        });
        cancelTicket.add(name);
        cancelTicket.add(nameField);
        cancelTicket.add(ticketNumber);
        cancelTicket.add(ticketNumberField);
        cancelTicket.add(cancel);
        cancelTicket.setLocationRelativeTo(jFrame);
        cancelTicket.setLayout(null);
        cancelTicket.setVisible(true);
    }
}

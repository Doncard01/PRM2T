package pl.edu.pw.elka.prm2t.lab6.zad1;

import javax.swing.*;
import java.awt.*; //do FlowLayout i GridLayout


public class SprawdzanieNapisu {

    private JTextField textField, userText;
    private String tekst = "";

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public SprawdzanieNapisu() {
        JFrame frame = new JFrame();
        JFrame frame2 = new JFrame();

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();

        JButton button1 = new JButton("Wpisz:");
        button1.addActionListener(
                e -> {
                    userText.setText("");
                    frame2.setVisible(true);
                    frame.setVisible(false);}
        );
        JButton button2 = new JButton("OK");
        button2.addActionListener(e -> {
            String input = userText.getText();
            if (isNumeric(input)) {
                textField.setText(input);
                String message = "Wpisano " + input;
                JOptionPane.showMessageDialog(frame2, message);
                frame2.setVisible(false);
                frame.setVisible(true);
            } else {
                frame2.setVisible(false); //ponowne wyświetlanie
                userText.setText("");
                frame2.setVisible(true);
            }

        });
        JButton button3 = new JButton("Cancel");
        button3.addActionListener(e -> {
            textField.setText("");
            frame2.setVisible(false);
            frame.setVisible(true);
        });

        JLabel label = new JLabel("Wpisz wartość numeryczną:");

        textField = new JTextField(tekst, 20);
        userText = new JTextField(20);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        // panel.setLayout(new GridLayout(0, 2));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.add(button1);
        panel.add(textField);

        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel2.setLayout(new GridLayout(3, 1, 20, 20));
        panel2.add(label);
        panel2.add(userText);
        panel2.add(button2);
        panel2.add(button3);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Testowanie danych wejściowych");
        //frame.setSize(800, 800);
        frame.pack();
        frame.setVisible(true);

        frame2.add(panel2, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Input");
        frame2.pack();
    }


    public static void main(String[] args) {
        new SprawdzanieNapisu();
    }


}

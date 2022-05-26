package pl.edu.pw.elka.prm2t.lab6.zad2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StatystykaLiter {
    private Character[] samo = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', 'y', 'Y'};
    List<Character> samogloski = new ArrayList<>();
    private JTextField textField;
    private String tekst = "";


    public int ileLiter(char[] ch) {
        int ile = 0;
        for (char znak : ch) {
            if (Character.isLetter(znak)) {
                ile++;
            } else if (Character.isWhitespace(znak)) {
                continue;
            } else {
                return -1;
            }
        }
        return ile;
    }
    public int ileSamoglosek(char[] ch) {
        samogloski.addAll(Arrays.asList(samo));
        int ile = 0;
        for (char znak : ch) {
            if (Character.isLetter(znak) && samogloski.contains(znak)) {
                ile++;
            }
        }
        return ile;
    }

    public int ileSpolglosek(char[] ch) {
        samogloski.addAll(Arrays.asList(samo));
        int ile = 0;
        for (char znak : ch) {
            if (Character.isLetter(znak) && !samogloski.contains(znak)) {
                ile++;
            }
        }
        return ile;
    }

    public StatystykaLiter() {
        textField = new JTextField(tekst, 20);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JButton button = new JButton("Check");
        button.addActionListener(e -> {
            char[] ch = (textField.getText()).toCharArray();
            int litery = ileLiter(ch);
            String message;
            if (litery == -1) {
                message =  "Wpisano niepoprawne znaki!";
            } else {
                message = "Liczba liter: " + litery + "\n";
                message += "Liczba spółgłosek: " + ileSpolglosek(ch) + "\n";
                message += "Liczba samogłosek: " + ileSamoglosek(ch) + "\n";
            }
            JOptionPane.showMessageDialog(frame, message);
        });

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.add(button);
        panel.add(textField);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Statystyka liter");
        frame.pack();
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        new StatystykaLiter();
    }
}

import javax.swing.*;
import java.awt.*;

public class TypingRaceGUI {

    public static void startRaceGUI() {
        JFrame frame = new JFrame("Typing Race");

        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel label = new JLabel("Enter passage:");
        panel.add(label);

        JTextField textField = new JTextField(20);
        panel.add(textField);

        JButton startButton = new JButton("Start Race");
        panel.add(startButton);

        startButton.addActionListener(e -> {
            String text = textField.getText();
            label.setText(text);
        });

    public static void main(String[] args) {
        startRaceGUI();
    }
}
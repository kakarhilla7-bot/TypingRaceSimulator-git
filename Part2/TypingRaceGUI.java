import javax.swing.*;
import java.awt.*;

public class TypingRaceGUI {

    public static void startRaceGUI() {
        JFrame frame = new JFrame("Typing Race");

        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        

        JButton startButton = new JButton("New Race");
        panel.add(startButton);

        startButton.addActionListener(e -> {
            System.out.println("button clicked");
            setupRace();
        });
        frame.setVisible(true);
    }

    public static void setupRace() {
        JFrame frame = new JFrame("Setup Race");
        frame.pack();
        JPanel panel = new JPanel();
        frame.add(panel);
        JLabel label = new JLabel("...setting up race...");
        panel.add(label);
        


        JComboBox<String> presetPassages = new JComboBox<>(new String[]{"Short passage", "Medium passage", "Long passage"});
        presetPassages.addActionListener(e -> {
            String selectedPassage = (String) presetPassages.getSelectedItem();
            // Load the selected passage into the text field
        });
        panel.add(presetPassages);
        JTextField customPassageField = new JTextField(20);
        panel.add(customPassageField);

        JComboBox<Integer> seatCount = new JComboBox<>(new Integer[]{2, 3, 4, 5, 6});
        panel.add(seatCount);

        JCheckBox autocorrect = new JCheckBox("Autocorrect");
        panel.add(autocorrect);
        JCheckBox caffeineMode = new JCheckBox("Caffeine Mode");
        panel.add(caffeineMode);
        JCheckBox nightShift = new JCheckBox("Night Shift");
        panel.add(nightShift);

        JButton startRaceButton = new JButton("Start Race");
        panel.add(startRaceButton);

        startRaceButton.addActionListener(e -> {
            String passage;
            if (!customPassageField.getText().isEmpty()) {
                passage = customPassageField.getText();
            }
            else{
                passage = (String) presetPassages.getSelectedItem();
                // Load the selected passage into the text field
            }
            int seats = (Integer) seatCount.getSelectedItem();
            boolean isAutocorrect = autocorrect.isSelected();
            boolean isCaffeineMode = caffeineMode.isSelected();
            boolean isNightShift = nightShift.isSelected();
            label.setText("Passage: " + passage + ", Seats: " + seats + ", Autocorrect: " + isAutocorrect + ", Caffeine Mode: " + isCaffeineMode + ", Night Shift: " + isNightShift);
        
        });
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        startRaceGUI();
    }
    
}
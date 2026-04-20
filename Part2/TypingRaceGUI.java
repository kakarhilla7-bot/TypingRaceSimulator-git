package Part2;
import javax.swing.*;
import java.awt.*;
import Part1.Typist;

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
    
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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
                if (passage.equals("Short passage")){
                    passage = "Once the first fall chill arrives, we're likely to see and hear chickadees around our birdfeeders.";
                }
                else if (passage.equals("Medium passage")){
                    passage = "Again, you'll notice the answers are the same regardless of which method we use. This is because all of the methods discussed are simply different roads to the same destination.";

                }
                else if (passage.equals("Long passage")){
                    passage = "I heard some kids telling me, how they've lost faith in the way. They've been talking world peace, and the wars in the streets. The lines on their faces so deep. A revolution or reach out and touch the day. We're overdue child.";
                }
            }
            int seats = (Integer) seatCount.getSelectedItem();
            boolean isAutocorrect = autocorrect.isSelected();
            boolean isCaffeineMode = caffeineMode.isSelected();
            boolean isNightShift = nightShift.isSelected();
            startRace(frame, passage, seats);
        
        });
        frame.pack();
        frame.setVisible(true);
    }

    public static void startRace(JFrame frame, String passage, int seats) {
        frame.getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);
        JLabel passageLabel = new JLabel("<html>" + passage + "</html>");
        panel.add(passageLabel);

        Typist[] typists = new Typist[seats];
        JLabel[] typistLabels = new JLabel[seats];
        for (int i=0; i<seats; i++){
            typists[i] = new Typist((char)('1'+i),"P"+(i+1),0.7+Math.random()*0.2);
        }
        for(int i=0; i<seats; i++){
            typistLabels[i] = new JLabel("P"+(i+1)+": ");
            panel.add(typistLabels[i]);
        }
        Timer timer = new Timer(500, null);
        timer.addActionListener(e -> {
            for (int i = 0; i < seats; i++) {
                typists[i].typeCharacter();

                int progress = typists[i].getProgress();

                if (progress > passage.length()) {
                    progress = passage.length();
                }

                String typed = passage.substring(0, progress);
                String remaining = passage.substring(progress);

                typistLabels[i].setText("P" + (i+1) + ": " + typed + "|" + remaining);


                if (progress >= passage.length()) {
                    timer.stop();

                    JLabel winnerLabel = new JLabel("Winner: P" + (i+1));
                    panel.add(winnerLabel);

                    frame.revalidate();
                    return; 
                }
            }
        });
        timer.start();
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        startRaceGUI();
    }
    
}
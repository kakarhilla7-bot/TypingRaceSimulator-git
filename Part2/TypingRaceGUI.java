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
            startRace(frame, passage);
        
        });
        frame.pack();
        frame.setVisible(true);
    }

    public static void startRace(JFrame frame, String passage) {
        frame.getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);
        JLabel passageLabel = new JLabel("<html>" + passage + "</html>");
        panel.add(passageLabel);

        Typist t1 = new Typist('1', "P1", 0.8);
        Typist t2 = new Typist('2', "P2", 0.7);
        JLabel t1Label = new JLabel("P1: ");
        JLabel t2Label = new JLabel("P2: ");
     
        int[] progress1 = {0};
        int[] progress2 = {0};
        int totalLength = passage.length();

        new javax.swing.Timer(500, e -> {
            t1.typeCharacter();
            progress1[0] = t1.getProgress();
            t2.typeCharacter();
            progress2[0] = t2.getProgress();

            int done1 = progress1[0];
            int done2 = progress2[0];


            if (done1>totalLength){
                done1 = totalLength;
            }
            if(done2>totalLength){
                done2 = totalLength;
            }

            String bar1 = "";
            for (int i=0; i<done1; i++){
                bar1 += "|";
            }
            for (int i=done1; i<totalLength; i++){
                bar1 += "-";
            }

            String bar2 = "";
            for (int i=0; i<done2; i++){
                bar2 += "|";
            }
            for (int i=done2; i<totalLength; i++){
                bar2 += "-";
            }

            t1Label.setText("P1: " + bar1);
            t2Label.setText("P2: " + bar2);
        }).start();
        panel.add(t1Label);
        panel.add(t2Label);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        startRaceGUI();
    }
    
}
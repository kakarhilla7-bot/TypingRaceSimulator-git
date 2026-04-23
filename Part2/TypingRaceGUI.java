package Part2;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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
            String[] typingStyles = new String[seats];
            String[] keyboardTypes = new String[seats];
            String[] typistColors = new String[seats];
            ArrayList<String>[] accessories = new ArrayList[seats];
            for (int i=0; i<seats; i++){
                accessories[i] = new ArrayList<String>();
            }
            boolean isAutocorrect = autocorrect.isSelected();
            boolean isCaffeineMode = caffeineMode.isSelected();
            boolean isNightShift = nightShift.isSelected();
            customiseTypists(frame, passage, seats, isAutocorrect, isCaffeineMode, isNightShift, typingStyles, keyboardTypes, typistColors, accessories);
        
        });
        frame.pack();
        frame.setVisible(true);
    }

    public static void customiseTypists(JFrame frame, String passage, int seats, boolean isAutocorrect, boolean isCaffeineMode, boolean isNightShift, String[] typingStyles, String[] keyboardTypes, String[] typistColors, ArrayList<String>[] accessories) {
        JFrame customiseFrame = new JFrame("Customise Typists");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        customiseFrame.add(panel);

        String[] typingStyleOptions = {"Touch Typist", "Hunt and Peck", "Phone Thumbs", "Voice to Text"};
        String[] keyboardTypeOptions = {"Mechanical", "Membrane", "Touchscreen", "Stenography"};
        String[] typistColorOptions = {"Red", "Blue", "Green", "Yellow", "Purple", "Cyan"};
        String[] accessoryOptions = {"None", "Wrist Support", "Energy Drink", "Noise-Cancelling Headphones"};
        for (int i=0; i<seats; i++){
            final int playerIndex = i;
            JLabel typistLabel = new JLabel("P"+(i+1));
            panel.add(typistLabel);
            accessories[playerIndex] = new ArrayList<String>();

            typingStyles[playerIndex] = typingStyleOptions[0];
            keyboardTypes[playerIndex] = keyboardTypeOptions[0];
            typistColors[playerIndex] = typistColorOptions[0];

            JComboBox<String> typingStyleDropdown = new JComboBox<>(typingStyleOptions);
            typingStyleDropdown.addActionListener(e -> {
                typingStyles[playerIndex] = (String) typingStyleDropdown.getSelectedItem();
                
            });
            panel.add(typingStyleDropdown);
            JComboBox<String> keyboardTypeDropdown = new JComboBox<>(keyboardTypeOptions);
            keyboardTypeDropdown.addActionListener(e -> {
                keyboardTypes[playerIndex] = (String) keyboardTypeDropdown.getSelectedItem();
            }); 
            panel.add(keyboardTypeDropdown);
            JComboBox<String> typistColorDropdown = new JComboBox<>(typistColorOptions);
            typistColorDropdown.addActionListener(e -> {
                typistColors[playerIndex] = (String) typistColorDropdown.getSelectedItem();
            });
            panel.add(typistColorDropdown);

            JLabel accessoriesLabel = new JLabel("Accessories:");
            panel.add(accessoriesLabel);
            for (int j=0; j<accessoryOptions.length; j++){
                JCheckBox accessoryCheckbox = new JCheckBox(accessoryOptions[j]);
                int accessoryIndex = j;
                accessoryCheckbox.addActionListener(e -> {
                    if (accessoryCheckbox.isSelected()){
                        accessories[playerIndex].add(accessoryOptions[accessoryIndex]);
                    }
                    else{
                        accessories[playerIndex].remove(accessoryOptions[accessoryIndex]);
                    }
                });
                panel.add(accessoryCheckbox);
            }
        }
        JButton startRaceButton = new JButton("Start Race");
        startRaceButton.addActionListener(e -> {
            JFrame raceFrame = new JFrame("Typing Race");
            raceFrame.setSize(800, 400);
            raceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            startRace(frame, passage, seats, isAutocorrect, isCaffeineMode, isNightShift, typingStyles, keyboardTypes, typistColors, accessories);
            customiseFrame.dispose();
        });
        panel.add(startRaceButton);
        customiseFrame.pack();
        customiseFrame.setVisible(true);
    }
        

    public static void startRace(JFrame frame, String passage, int seats, boolean isAutocorrect, boolean isCaffeineMode, boolean isNightShift, String[] typingStyles, String[] keyboardTypes, String[] typistColors, ArrayList<String>[] accessories) {
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
        
        int[] caffeineTurnsRemaining = new int[seats];
        for (int i=0; i<seats; i++){
            caffeineTurnsRemaining[i] = isCaffeineMode ? 10 : 0;
        }

        int[] autocorrectCounter = {0};
        
        Timer timer = new Timer(200, null);
        timer.addActionListener(e -> {
            
            if(isAutocorrect && autocorrectCounter[0] % 4==0){
                for (int i=0; i<seats; i++){
                    typists[i].slideBack(1);
                }
            }
            autocorrectCounter[0]++;


            for(int i=0; i<seats; i++){    
                if (typists[i].isBurntOut()) {
                typists[i].recoverFromBurnout();
                int progress = typists[i].getProgress();
                if (progress > passage.length()) {
                    progress = passage.length();
                }
                String typed = passage.substring(0, progress);
                String remaining = passage.substring(progress);
                typistLabels[i].setText("P" + (i+1) + ": " + typed + "|" + remaining + " [BURNT OUT]");
                continue;
                }
                int progress = typists[i].getProgress();

                double accuracyModifier = 1.0;
                int burnoutModifier = 0;

                String style = typingStyles[i];
                if (style.equals("Touch Typist")) {
                    accuracyModifier = 1.2;  
                    burnoutModifier = -10;   
                } else if (style.equals("Hunt and Peck")) {
                    accuracyModifier = 0.85; 
                    burnoutModifier = 10;    
                } else if (style.equals("Phone Thumbs")) {
                    accuracyModifier = 0.75; 
                    burnoutModifier = 15;    
                } else if (style.equals("Voice-to-Text")) {
                    accuracyModifier = 1.1;  
                    burnoutModifier = 5;     
                }

                String keyboard = keyboardTypes[i];
                if (keyboard.equals("Mechanical")) {
                    accuracyModifier *= 1.1; 
                } 
                else if (keyboard.equals("Touchscreen")) {
                    accuracyModifier *= 0.8;
                } 
                else if (keyboard.equals("Stenography")) {
                    accuracyModifier *= 1.3;
                }


                if (accessories[i].contains("Wrist Support")) {
                    burnoutModifier -= 5;  
                }
                if (accessories[i].contains("Energy Drink")) {
                    if(progress<=passage.length()/2){
                        accuracyModifier *= 1.2;
                    }
                    else{
                        accuracyModifier *= 0.8;
                    }
                    
                }
                if (accessories[i].contains("Noise-Cancelling Headphones")) {
                    accuracyModifier *= 1.15;  
                }

                typists[i].setAccuracy(typists[i].getAccuracy() + accuracyModifier);
                if (burnoutModifier > 0) {
                    typists[i].burnOut(burnoutModifier);
                } else if (burnoutModifier < 0) {
                    for(int j = 0; j < Math.abs(burnoutModifier); j++){
                        typists[i].recoverFromBurnout();
                    }
                }
                if (isCaffeineMode && caffeineTurnsRemaining[i] > 0){
                    typists[i].typeCharacter();
                    typists[i].typeCharacter();
                    caffeineTurnsRemaining[i]--;
                }
                else if (isCaffeineMode && caffeineTurnsRemaining[i] == 0){
                    if (Math.random() <0.3){
                        typists[i].burnOut(3);
                    }
                    typists[i].typeCharacter();
                }
                else{
                    typists[i].typeCharacter();
                }
            
                if (isNightShift){
                    typists[i].setAccuracy(typists[i].getAccuracy() - 0.05);
                }

                progress = typists[i].getProgress();

                if (progress > passage.length()) {
                    progress = passage.length();
                }

                String typed = passage.substring(0, progress);
                String remaining = passage.substring(progress);

                String colorHTML = typistColors[i].toLowerCase();

                typistLabels[i].setText("<html>P" + (i+1) + ": <span style='color: " + colorHTML+ ";'>" + typed + "</span>|" + remaining + "</html>");


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
package cn.edu.ncu.lzc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class GuessWordController {

    @FXML private Label scoreLabel;
    @FXML private Label wordLabel;
    @FXML private TextField guessInput;

    private String[] words = {
        "apple", "banana", "orange", "computer", "window",
        "kitchen", "student", "teacher", "morning", "evening"
    };
    
    private Random random = new Random();
    private int curidx = random.nextInt(words.length);
    private String currentWord = "";
    private int score = 0;

    @FXML
    public void initialize() {
        nextWord();
    }

    @FXML
    public void onSubmit() {
        String guess = guessInput.getText();
        
        if (guess.equals(currentWord)) {
            score++;
            scoreLabel.setText("答对数量: " + score);
            nextWord(); 
        }
        guessInput.clear(); 
    }

    @FXML
    public void nextWord() {
        currentWord = words[curidx++];
        if(curidx == 10) curidx = 0;
        
        int length = currentWord.length();
        int hideCount = length / 2; 
        
        char[] displayChars = currentWord.toCharArray();
        
        int hidden = 0;
        while (hidden < hideCount) {
            int idx = random.nextInt(length);
            if (displayChars[idx] != '_') {
                displayChars[idx] = '_';
                hidden++;
            }
        }
        
        StringBuilder display = new StringBuilder();
        for (char c : displayChars) {
            display.append(c).append(" ");
        }
        
        wordLabel.setText(display.toString().trim());
        guessInput.clear(); 
    }
}

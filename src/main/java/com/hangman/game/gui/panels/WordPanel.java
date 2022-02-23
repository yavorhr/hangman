package com.hangman.game.gui.panels;

import com.hangman.game.gui.frame.HangmanFrame;
import com.hangman.game.service.WordService;
import com.hangman.game.util.Helper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class WordPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private List<JButton> generatedWordList;
    private String generatedWord;
    private int noOfAttempts;

    private final LettersPanel lettersPanel;
    private final ImagesPanel imagesPanel;
    private final WordService wordService;

    private final HangmanFrame hangmanFrame;

    @Lazy
    public WordPanel(LettersPanel lettersPanel, ImagesPanel imagesPanel, WordService wordService, HangmanFrame hangmanFrame) {
        this.lettersPanel = lettersPanel;
        this.imagesPanel = imagesPanel;
        this.wordService = wordService;
        this.hangmanFrame = hangmanFrame;

        //add specific panel properties
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(500, 100));
        this.setBackground(Color.black);
    }

    @PostConstruct
    public JPanel createPanel() {
        generatedWord = wordService.getRandomWord();
        this.generatedWordList = new ArrayList<>();
        noOfAttempts = 0;

        //get first and last letters in the newly generated word
        final char firstLetterInWord = generatedWord.charAt(0);
        final char lastLetterInWord = generatedWord.charAt(generatedWord.length() - 1);

        for (int i = 0; i < generatedWord.length(); i++) {
            // create a button for each letter in the generated word
            final JButton lb = new JButton("_");
            lb.setPreferredSize(new Dimension(60, 60));
            lb.setFont(Helper.FONT);
            //set enabled to not respond to any mouse or click events
            lb.setEnabled(false);
            this.generatedWordList.add(lb);
            this.add(lb);
        }
        // expose first letter to user
        generatedWordList.get(0).setText(Character.toString(firstLetterInWord));

        // expose last character to user
        generatedWordList.get(generatedWord.length() - 1).setText(Character.toString(lastLetterInWord));

        //iterate over the generated word
        for (int i = 0; i < generatedWord.length() - 1; i++) {
            char currentLetter = generatedWord.charAt(i); // get current letter;

            // if current letter is equal to the first or last letter in the generated word -> we expose it to the user
            if (currentLetter == firstLetterInWord || currentLetter == lastLetterInWord) {
                generatedWordList.get(i).setText(Character.toString(currentLetter));
            }
        }
        //disable letters that are initially exposed in the word
        // and the user cannot click on them (disable the first and last letters in the main Letters panel)

        lettersPanel.disableDefaultLetters(firstLetterInWord, lastLetterInWord);

        //return the created panel from this method
        return this;
    }

    // method to check if selected letter is present in the generated word
    public void checkLetter(char letter) {
        boolean letterFound = false;
        for (int i = 0; i < generatedWord.length(); i++) {
            char currentLetter = generatedWord.charAt(i);

            if (currentLetter == letter) {
                generatedWordList.get(i).setText(String.valueOf(letter));
                letterFound = true;
            }
        }

        // check if the entire has been found - on current attempt;
        if (letterFound && checkCompletedWord()) {
            lettersPanel.getLettersMap().forEach((k, v) -> {
                v.setEnabled(false);
            });
            JOptionPane.showMessageDialog(null, "Congratulations! You managed to find the word!");
            hangmanFrame.newGame();
        } else if (!letterFound) {
            // change image from smile -> sad (to identify a missed letter)
            imagesPanel.getImagesList().get(noOfAttempts).setIcon(imagesPanel.scale(Helper.SAD_IMG.getImage()));

            noOfAttempts++;
            // if we reach the maximum allowed attemps
            if (noOfAttempts == imagesPanel.getImagesList().size()) {
                lettersPanel.getLettersMap().forEach((k, v) -> {
                    v.setEnabled(false);
                });
                JOptionPane.showMessageDialog(null, "You were not able to find the word!/n The word was: " + generatedWord);
                hangmanFrame.newGame();
            }
        }
    }

    // check if all letters in the word have been found
    private boolean checkCompletedWord() {
        // if we have at least one _ symbol in the main word -> word not completed
        long noOfLettersNotFound = generatedWordList.stream().filter(button -> button.getText().equals("_")).count();

        if (noOfLettersNotFound > 0) {
            return false;
        }
        return true;
    }

    public void clear() {
        this.removeAll();
        this.createPanel();
    }

}

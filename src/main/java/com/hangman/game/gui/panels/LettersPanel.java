package com.hangman.game.gui.panels;

import com.hangman.game.gui.listeners.ButtonListener;
import com.hangman.game.gui.listeners.MouseListener;
import com.hangman.game.util.Helper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Component
public class LettersPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    //create a map that keeps the kay/value pairs of letter/button
    private Map<String, JButton> lettersMap = new HashMap<>();

    public LettersPanel() {
        this.setLayout(new GridLayout(3, 0));
    }

    @PostConstruct
    public void createPanel() {
        List<String> q_p_list = Arrays.asList("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P");
        List<String> a_l_list = Arrays.asList("A", "S", "D", "F", "G", "H", "J", "K", "L");
        List<String> z_m_list = Arrays.asList("Z", "X", "C", "V", "B", "N", "M");

        JPanel q_p_panel = this.createLettersPanel(q_p_list);
        JPanel a_l_panel = this.createLettersPanel(a_l_list);
        JPanel z_m_panel = this.createLettersPanel(z_m_list);

        this.add(q_p_panel);
        this.add(a_l_panel);
        this.add(z_m_panel);
    }

    // create a letters panel (with a specific letters list)
    private JPanel createLettersPanel(List<String> lettersList) {
        JPanel lettersPanel = new JPanel();
        lettersPanel.setLayout(new FlowLayout());

        ButtonListener buttonListener = new ButtonListener();
        MouseListener mouseListener = new MouseListener();

        //for each letter in the list, create a button and the corresponding data mapped to it
        lettersList.forEach(letter -> {
            JButton letterButton = new JButton(letter);
            letterButton.setPreferredSize(new Dimension(60, 60));
            letterButton.setBackground(Color.getHSBColor(100, 100, 100));
            letterButton.addActionListener(buttonListener);
            letterButton.addMouseListener(mouseListener);
            letterButton.setFont(Helper.FONT);
            lettersPanel.add(letterButton);
            lettersMap.put(letter, letterButton);
        });

        return lettersPanel;
    }

    public void disableDefaultLetters(char firstLetterInWord, char lastLetterInWord) {
        String firstLetter = String.valueOf(firstLetterInWord);
        String lastLetter = String.valueOf(lastLetterInWord);

        // disable first letter
        JButton firstLetterInWordButton = lettersMap.get(firstLetter.toUpperCase());
        firstLetterInWordButton.setEnabled(false);
        firstLetterInWordButton.setBackground(Color.GREEN);

        // disable last letter
        JButton lastLetterInWordButton = lettersMap.get(lastLetter.toUpperCase());
        lastLetterInWordButton.setEnabled(false);
        lastLetterInWordButton.setBackground(Color.green);
    }

    public Map<String, JButton> getLettersMap() {
        return lettersMap;
    }

    public void setLettersMap(Map<String, JButton> lettersMap) {
        this.lettersMap = lettersMap;
    }
}

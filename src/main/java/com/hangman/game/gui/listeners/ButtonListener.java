package com.hangman.game.gui.listeners;

import com.hangman.game.gui.panels.WordPanel;
import com.hangman.game.util.SpringContext;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        // get current button
        JButton button = (JButton) e.getSource();
        button.setEnabled(false);
        button.setBackground(Color.green);

        // get button letter
        char letter = button.getText().toCharArray()[0];

        // get ApplicationContext
        ApplicationContext context = SpringContext.getApplicationContext();

        //get instance of the WordPanel bean
        WordPanel wordPanel = (WordPanel) context.getBean(WordPanel.class);
        wordPanel.checkLetter(letter);
    }
}

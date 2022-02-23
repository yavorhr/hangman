package com.hangman.game.gui.menu;

import com.hangman.game.gui.frame.HangmanFrame;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

@Component
public class Menu extends JMenuBar {

    private static final long serialVersionUID = 1L;

    private final HangmanFrame hangmanFrame;

    @Lazy
    public Menu(HangmanFrame hangmanFrame) {
        this.hangmanFrame = hangmanFrame;
        this.createMenu();
    }

    public void createMenu(){
        JMenu optionsMenu = new JMenu("Options");
        JMenuItem option1 = new JMenuItem("Generate new word");
        JMenuItem option2 = new JMenuItem("Exit");

        // add key listeners => CTRL + N for new game / CTRL + E => Exit

        option1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        option1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               hangmanFrame.newGame();
            }
        });

        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });

        optionsMenu.add(option1);
        optionsMenu.add(option2);
        // add this Menu to the JMenu main component
        this.add(optionsMenu);
    }

}

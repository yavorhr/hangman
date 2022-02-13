package com.hangman.game.gui.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {

    public MouseListener() {
    }

    // handle the case when mouse enters on a button
    public void mouseEntered(MouseEvent e) {
        //the button that triggers the event
        JButton buttonChosen = (JButton) e.getSource();
        if (buttonChosen.isEnabled()) {
            buttonChosen.setBackground(Color.white);
        }
    }

    // handle the case when mouse exists a button
    public void mouseExited(MouseEvent e) {
        JButton buttonChosen = (JButton) e.getSource();
        if (buttonChosen.isEnabled()) {
            buttonChosen.setBackground(Color.getHSBColor(100,100,100));
        }
    }
}

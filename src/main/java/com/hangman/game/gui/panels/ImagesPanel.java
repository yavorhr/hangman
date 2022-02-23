package com.hangman.game.gui.panels;

import com.hangman.game.util.Helper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImagesPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    //to store our images
    private List<JLabel> imagesList;

    public ImagesPanel() {
    }

    //@ PostConstruct is automatically invoked by Spring.
    //Set the images dimensions and JLabel format and add them to the Images panel
    @PostConstruct
    public void createPanel() {
        imagesList = new ArrayList<>();

        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(5, 1));

        for (int i = 0; i < 5; i++) {
            JLabel imageLabel = new JLabel(scale(Helper.SMILE_IMG.getImage()));
            imagesList.add(imageLabel);
            this.add(imageLabel);
        }
    }

    //scale method - changes the SMILE_IMG reference to a specific format, which can be read from the JLabel constructor.
    public ImageIcon scale(Image src) {
        int w = 50;
        int h = 50;
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage dst = new BufferedImage(w, h, type);
        Graphics2D g2 = dst.createGraphics();
        g2.drawImage(src, 0, 0, w, h, this);
        g2.dispose();
        return new ImageIcon(dst);
    }

    public List<JLabel> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<JLabel> imagesList) {
        this.imagesList = imagesList;
    }

    public void clear() {
        this.removeAll();
        this.createPanel();
    }
}

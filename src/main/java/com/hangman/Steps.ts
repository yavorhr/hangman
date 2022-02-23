/*
1. Create EmptyPanel @component
2. Create HangmanFrame @component. EmptyPanel injection + @PostConstruct method for the Frame
3. Create ImagesPanel @component. @PostConstruct createPanel to set the images dimensions.
    - Create Helper component class with reference to the images.
    - scale method to transform the path of the smile.jpg to a JLabel format in order to add to the List<JLabel> images.
    - add ImagesPanel to the main panel in the Hangman Frame
4. SpringContext class - component used to autowire the spring application context inside a non-spring class
5. Implement Button and MouseListener
6. Build LettersPanel and inject it in HangmanFrame main panel
7. Build WordPanel and inject it in HangmanFrame main panel
8. Generate new game process
    8.1  Clear method in ImagesPanel, LettersPanel and WordPanel

        public void clear() {
        this.removeAll();
        this.createPanel();
    }
    8.2 In HangmanFrame -

      public void newGame() {
        this.dispose();
        int x = this.getX();
        int y = this.getY();
        this.clearPanels();
        this.setLocation(x, y);
        this.setVisible(true);
    }

    private void clearPanels() {
        this.lettersPanel.clear();
        this.wordPanel.clear();
        this.imagesPanel.clear();
    }

        public void newGame() {
        this.dispose();
        int x = this.getX();
        int y = this.getY();
        this.clearPanels();
        this.setLocation(x, y);
        this.setVisible(true);
    }
 */
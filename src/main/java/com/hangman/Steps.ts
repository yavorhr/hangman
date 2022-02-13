/*
1. Create EmptyPanel @component
2. Create HangmanFrame @component. EmptyPanel injection + @PostConstruct method for the Frame
3. Create ImagesPanel @component. @PostConstruct createPanel to set the images dimensions.
    - Create Helper component class with reference to the images.
    - scale method to transform the path of the smile.jpg to a JLabel format in order to add to the List<JLabel> images.
    - add ImagesPanel to the main panel in the Hangman Frame
4. SpringContext class - component used to autowire the spring application context inside a non-spring class
5. Implement Button and MouseListener
 */
package brickBreaker; //The package "brickBreaker" contains the classes related to the the game.
import javax.swing.*; //Importing the necessary Java Swing library
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame obj = new JFrame(); //Creates a new JFrame object to represent the game window.
            Gameplay gamePlay = new Gameplay(); //Creates a new Gameplay object, which represents the main game logic.
            obj.setBounds(10, 10, 700, 600); //Sets the dimensions (x, y, width, height) of the game window.
            obj.setTitle("Brick Breaker"); //Sets the title of the game window.
            obj.setResizable(false); //Disables resizing to maintain a fixed size.
            obj.setVisible(true);  //Makes the game window visible.
            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets the default close operation to exit the app when the window is closed.
            obj.add(gamePlay); //Adds the Gameplay object (main game logic) to the game.
        });
    }

}

/**********************************************************************
 * @file Main.java
 * @brief had trouble once finished having it show up so added Swing Utilites
 * @mainteam Liam and Eric
 * @date: 12/8
 * @editors: Robert, Noah
 ***********************************************************************/
package brickBreaker; //The package "brickBreaker" contains the classes related to the  game.
import javax.swing.*; //Importing the necessary Java Swing library
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // Let intellij know that these need to be active at all time, we ran into an issue with the video code as it would not show the screen so we researched what to do.
            JFrame obj = new JFrame(); //Creates a new JFrame object to represent the game window.
            Gameplay gamePlay = new Gameplay(); //Creates a new Gameplay object, which represents the main game logic.
            obj.setBounds(10, 10, 700, 600); //Sets the dimensions (x, y, width, height) of the game .
            obj.setTitle("Brick Breaker"); //Sets the title of the game .
            obj.setResizable(false); //Makes panel a constant size
            obj.setVisible(true);  //Makes the game window visible.
            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit the app when the window is closed.
            obj.add(gamePlay); //Adds the Gameplay object (main game logic) to the game.
        });
    }

}

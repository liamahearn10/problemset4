package brickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Import necessary libraries and packages

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    // Define class variables
private boolean play = false; // check to see if the game is in progress
private int score = 0; // Player's score
private int totalBricks = 21; // Total number of bricks
private Timer timer; // Timer to control game updates
private int delay = 8; // Delay for the timer
private int playerX= 310; // Initial position of the player's paddle
private int ballposX = 120; // Initial x position of the ball
private int ballposY = 350; // Initial y position of the ball
    private int ballXdir = -1; // Ball's x direction
private int ballYdir = -2; // Ball's y direction
private MapGenerator map; //// Object to generate the game map
public Gameplay (){
map = new MapGenerator(3,7); //// Create a map with specified rows and columns from the MapGen class
    addKeyListener(this); // Add key listener to handle user input
    setFocusable(true); // receive key events
    setFocusTraversalKeysEnabled(false); // Disable keys
   timer= new Timer (delay, this); // Initialize a timer for game updates
   timer.start(); // Start the timer
}
    // Method to paint/render the game elements
public void paint (Graphics g){

    // Draw the background
    g.setColor(Color.black);
    g.fillRect(1,1,692,592);

// Drawing map
    map.draw((Graphics2D)g);

    // Draw borders
g.setColor(Color.black);
g.fillRect(0,0,3,592);
g.fillRect(0,0,692,3);
g.fillRect(691,0,3,592);

// Scores
    g.setColor(Color.white);
    g.setFont (new Font ("serif", Font.BOLD, 25));
    g.drawString("" +score, 590,30);

// The paddle
    Color gold = new Color(187, 156, 0); // RGB values for gold color
    g.setColor(gold);
    g.fillRect(playerX, 550,100,8);

    // The ball
    g.setColor(Color.white);
    g.fillOval(ballposX,ballposY,20,20);

    // Check conditions for game over or win and display appropriate messages
    if(totalBricks <= 0){
        play = false;
        ballXdir = 0;
        ballYdir = 0;
        g.setColor(Color.RED);
        g.setFont (new Font ("serif", Font.BOLD, 30));
        g.drawString("You Won: ", 260,300);

        g.setFont (new Font ("serif", Font.BOLD, 20));
        g.drawString("Press Enter to Restart", 230,350);
    }

    // Check conditions for game over or win and display appropriate messages
    if (ballposY > 570){
        play = false;
        ballXdir = 0;
        ballYdir = 0;
        g.setColor(Color.RED);
        g.setFont (new Font ("serif", Font.BOLD, 30));
        g.drawString("Game Over, Scores: ", 190,300);

        g.setFont (new Font ("serif", Font.BOLD, 20));
        g.drawString("Press Enter to Restart", 230,350);
    }
g.dispose(); //// Dispose of the graphics context to start a new
    

}
    // ActionListener implementation for game updates
    @Override
    public void actionPerformed(ActionEvent e) { // Logic for game updates, collision detection, ball movement, etc.
        timer.start(); // Start the timer
        // Check if the game is active
        if(play){ // Check for intersection between the ball and the paddle
            if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8))){
                ballYdir =- ballYdir; // Reverse the ball's Y direction upon intersection with the paddle
            }
        }
        // Loop through the brick map to check for collisions with bricks
    A:    for (int i = 0; i<map.map.length; i++){
            for(int j = 0; j<map.map[0].length; j++){
                if(map.map[i][j]>0){
                    // Calculate brick position and dimensions
                    int brickX = j * map.brickWidth + 80;
                    int brickY = i * map.brickHeight + 50;
                    int brickWidth = map.brickWidth;
                    int brickHeight = map.brickHeight;
                    // Create rectangles for the ball, bricks, and intersection
                    Rectangle rect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                    Rectangle ballRect = new Rectangle(ballposX,ballposY,20,20);
                    Rectangle brickRect = rect;
                    // Check for collision between ball and brick
                    if (ballRect.intersects(brickRect)){
                        map.setBrickValue(0,i,j); // Set collided brick to 0 (destroyed)
                        totalBricks --; // Decrement total bricks
                        score += 10; // Increment score
                        // Adjust ball direction based on collision point
                        if (ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width){
                            ballXdir = -ballXdir;
                        }else {
                            ballYdir = -ballYdir;
                        }
                        break A; // Exit the loop after a collision is to allow for game to continue
                    }
                }
            }

        }
        // Update ball position and direction if the game is active
        if(play) {
            ballposX += ballXdir;
            ballposY += ballYdir;
            // Boundary checking for ball movement (reverses direction if it hits walls)
            if (ballposX < 0) {
                ballXdir = -ballXdir; // Reverse X direction if hitting side walls
            }
            if (ballposY < 0) {
                ballYdir = -ballYdir; // Reverse Y direction if hitting top wall
            }
            if (ballposX > 670) {
                ballXdir = -ballXdir;
            }
        }
        repaint(); // Repaint the panel to reflect the changes
    }
// Auto generated code that must be kept but do not have any conditions
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    // Handle key presses for game controls (paddle movement and game restart)

        // Move the paddle to the right if the right arrow key is pressed
    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
        if(playerX >= 600){
            playerX = 600; // Right bound limit
        }
        else {
            moveRight();
        }
    }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(playerX < 10){
                playerX = 10; // Left bound limit
            }
            else {
                moveLeft();
            }
        }
        // Restart the game if the Enter key is pressed and the game is not active
        if(e.getKeyCode()== KeyEvent.VK_ENTER){
            if (!play){
                play = true;
                // Reset game parameters: ball position, directions, player position, score, bricks
                ballposX = 120;
                ballposY = 350;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 310;
                score = 0;
                totalBricks = 21;
                map = new MapGenerator(3,7); // Generate a new map

                repaint();
            }
        }
    }
    // Paddle movement right
    public void moveRight(){
    play = true; // Set the game to active state
    playerX+=25;// Increment the paddle's position to the right
    }
    // Paddle movement left
    public void moveLeft(){
        play = true; // Set the game to active state
        playerX-=25; //Decrement the paddle's position to the left

    }








}
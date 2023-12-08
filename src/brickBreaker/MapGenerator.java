/**********************************************************************
 * @file MapGenerator.java
 * @brief had trouble making the size of the bricks correlate correctly to the size of the frame and have them all in the corect spot
 * @mainteam Robert and Noah
 * @date: 12/8
 * @editors: Liam and Eric
 ***********************************************************************/
package brickBreaker;

import java.awt.*;

public class MapGenerator { //Creates a 2d array to represent game map
    public int map[][];
    public int brickWidth; //Width of each brick
    public int brickHeight; //Height of each brick
    public MapGenerator(int row, int col){ //Constructor initializes map and sets default values
        map = new int[row][col]; //Initializes map with all bricks present
        for(int i=0;i< map.length;i++){
           for(int j=0;j<map[0].length;j++){
            map[i][j]=1; //Sets all bricks to 1, indicating they are present
           }
        }
       brickWidth = 540/col; //Calculates width of each brick based on total width of map
       brickHeight = 150/row; //Calculates height of each brick based on total height of map
    }
    public void draw(Graphics2D g){ //Method draws the bricks on the screen
        Color gold = new Color(157, 131, 5); // RGB values for gold color
        for(int i=0;i< map.length;i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j]>0){ //Draws the brick if it is present
                    g.setColor(gold); //Set brick color to white
                    g.fillRect(j*brickWidth+80, i*brickHeight+50,brickWidth,brickHeight); //Fills the rectangle representing the brick
                    g.setStroke(new BasicStroke(3)); //Sets stroke width for brick border
                    g.setColor(Color.black); //Sets brick border color to black
                    g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight); //Draws the rectangular border
                }
            }
        }
    }
    public void setBrickValue(int value, int row, int col){
        map[row][col]= value;
    } //Method that sets the value of a specific brick in the map
}

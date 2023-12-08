This code is to create the classic game Brick Breaker. We broke it into three different classes all supporting the main method. The main method is short and creates the inheritance for the Gameplay class, 
it also allows us to import the JFrame 


The purpose of the GamePlay class is to allow for the behavior and creation of the game itself. We implemented rules to allow the ball to exit the screen at the bottom and change
the direction of the movement. In the gameplay class, we created the elements of the board that were there the whole time such as the borders the ball, and the paddle. The GamePlay class also keeps a score.
It creates the movement of the paddle and checks for intersections with bricks to adjust the ball's movement. 
In the gameplay code, we implemented for and while nested loops to help make the behavior of the ball when it goes in a certain direction and how it should act. 
This class also implements methods to end the game as well as restart it at the end if the player would like to play again. 

Our MapGenerator class creates a 2D array to represent the bricks. The bricks are stored at 1, when the ball hits a specific brick it is reset to zero and disappears. 
We created it separately to be able to collaborate with all group members and break down the overall workload, it also allowed for cleaner code in the main method as well as cleaner code in the gameplay class. 


The Pairs in the group were:

Liam and Eric - Worked on the GamePlay class, switched off halfway through, and worked on comments together 

Noah and Rob - Worked on the MapGenerator comments and code as well as error-checked for the GamePlay method when we ran into an issue. 

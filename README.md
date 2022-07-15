# Tic-Tac-Toe
A game where two players take it in turns to draw three of either the O or the X in the gaps of a grid of nine squares to complete a row, column, or diagonal.

Unforunately, right now you can play it on terminal only. I am working on user-interface using Java APIs. 
Right now, for best user and gaming experience, i would suggest to go through this readme file.

## Packages Used: 
    java.util.*

## How to run: 
 ->     Open folder in Terminal
 
 ->     Type javac TicTacToe.java
 
 ->     Then 2 files named  will be created
 
                            TicTacToe.class
                            
                            GameBoard.class

        
 ->     Type java TicTacToe
 
 ## Inputing the data:
 1)When the user will run the program, First the "WELCOME" text will be displayed and then user will be asked the game mode he/she wants to play.

2)If user wants to play in Computer vs Player mode , he/she should enter 0 or if user wants to play in Player vs Player mode he/she should enter 1.

3)If user enters in Comp vs Player mode, he/she will be asked to enter his/her name and then to enter the position of symbol(for user it is 'x)
  to start the game and then game continues in Gameboard.

4)Else if user enters the Player vs Player mode,Both the players will be asked to enter their names one by one and will be assigned with their respective
  symbols and then the player1 will be asked to enter the position of his symbol to start the game and then game continues.

5)How to Enter the symbol in the game board in your preffered position
   User will be asked to enter the position as Row and Column respectively in (0 based indexing).For Example:
   
   Suppose the Gameboard is in the initial situation:

   Enter the Row number out of (0,1,2) :
   
   Suppose the user entered 0
   
   Enter the Column number out of (0,1,2) :
   
   Suppose the user entered 2
   
   
   Then the Gameboard updates to the condition in which symbol is marked at 0th Row and 2nd Column position

6)The game will continue until one player/computer has scored three in a row or all squares have been filled with no winner.

7)After that user will be asked if he/she wants to play another round for which he/she should enter 1 else enter enter any other number to exit the game.

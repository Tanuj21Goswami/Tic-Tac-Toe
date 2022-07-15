import java.util.Scanner;
class GameBoard{
    char[][] board;
    GameBoard()
    {
        board=new char[3][3];
        //Filling with dash
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]='-';
            }
        }
    }
    public static void DrawBoard(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

public class TicTacToe{
    public static void main(String args[])
    {
        Scanner in =new Scanner(System.in);
        while(true)
        {
            System.out.print("******************** WELCOME TO THE WORLD OF ********************\n");
            System.out.print("*********************   TIC TAC TOE 3X3   *********************\n\n");
            System.out.print("If you want to compete in Computer vs Player mode enter 0 or to compete in Player vs Player mode enter 1:\n");
            int a=in.nextInt();
            if(a==0)
            {
                System.out.println("You have entered in Computer Vs Player mode");
                System.out.println("What is your Name.. ? ");
                String player=in.next();
                System.out.println("Ladies n Gentlemen "+player+" in the House....");
                System.out.println("Let see if our player can beat the Computer or not ....");
                GameBoard Playboard=new GameBoard();

                boolean isPlayer=true;//It will keep track whose turn is this
                boolean gameEnded=false;//It will check whether game is ended or not 
                while(!gameEnded)
                {
                    Playboard.DrawBoard(Playboard.board);
                    char symbol;
                    if(isPlayer)
                    {
                        symbol='x';
                    }
                    else
                    {
                        symbol='o';
                    }

                    if(isPlayer)
                    {
                        System.out.println(player+"'s turn (x) :");
                    }
                    else{
                        System.out.println("Computer's turn (o) :");
                    }

                    int Row=0;
                    int Column=0;

                    while(true)//This loop is ensuring whether user has entered correct set of row and column values or not
                    {
                        if(isPlayer)
                        {
                            System.out.println("Enter the Row number out of (0,1,2) :");
                            Row=in.nextInt();
                            System.out.println("Enter the Column number out of (0,1,2) :");
                            Column=in.nextInt();
                            if(Row<0 || Row>2 || Column<0 || Column>2)
                            {
                                System.out.println("Your Row and Column are out of bounds!!");
                            }
                            else if(Playboard.board[Row][Column]!='-')
                            {
                                System.out.println("The place is already occupied!!");
                            }
                            else{
                                Playboard.board[Row][Column]=symbol;
                                break;
                            }
                        }
                        else
                        {
                            Comp(Playboard.board);//Calling the function which plays the computer's turn 
                            break;
                        }
                    }
 
                    //Conditonal statements checking if anybody has win the game or not                    
                    if(hasWon(Playboard.board)=='x')
                    {
                        System.out.println(player+" has won !!");
                        System.out.println("The Final positioning of board is as follows:");
                        Playboard.DrawBoard(Playboard.board);
                        gameEnded=true; 
                    }
                    else if(hasWon(Playboard.board)=='o')
                    {
                        System.out.println("Computer has won !!");
                        System.out.println("The Final positioning of board is as follows:");
                        Playboard.DrawBoard(Playboard.board);
                        gameEnded=true;
                    }
                    else
                    {
                        if(full(Playboard.board))
                        {
                            System.out.println("It's a Tie !!");
                            System.out.println("The Final positioning of board is as follows:");
                            Playboard.DrawBoard(Playboard.board);
                            gameEnded=true;
                        }
                        else
                        {
                            isPlayer=!isPlayer;//Changing the turn
                        }
                    }
                }
            }
            else if(a==1)
            {
                System.out.println("You have entered in Player Vs Player mode");
                System.out.println("Player1 , What's ur Name?");
                String player1=in.next();
                System.out.println("Player2 , What's ur Name?");
                String player2=in.next();
                System.out.println("Let's see, Who will win "+player1+" or "+player2+" .....");
                GameBoard Playboard=new GameBoard();


                boolean isPlayer1=true;//It will keep track whose turn is this
                boolean gameEnded=false;//It will check whether game is ended or not 
                while(!gameEnded)
                {
                    Playboard.DrawBoard(Playboard.board);
                    char symbol;
                    if(isPlayer1)
                    {
                        symbol='x';
                    }
                    else
                    {
                        symbol='o';
                    }

                    if(isPlayer1)
                    {
                        System.out.println(player1+"'s turn (x) :");
                    }
                    else{
                        System.out.println(player2+"'s turn (o) :");
                    }

                    int Row=0;
                    int Column=0;

                    while(true)//This loop is ensuring whether user has entered correct set of row and column values or not
                    {
                        System.out.println("Enter the Row number out of (0,1,2) :");
                        Row=in.nextInt();
                        System.out.println("Enter the Column number out of (0,1,2) :");
                        Column=in.nextInt();
                        if(Row<0 || Row>2 || Column<0 || Column>2)
                        {
                            System.out.println("Your Row and Column are out of bounds!!");
                        }
                        else if(Playboard.board[Row][Column]!='-')
                        {
                            System.out.println("The place is already occupied!!");
                        }
                        else{
                            break;
                        }
                    }

                    Playboard.board[Row][Column]=symbol;
                    
                    //Conditonal statements checking if anybody has win the game or not
                    if(hasWon(Playboard.board)=='x')
                    {
                        System.out.println(player1+" has won !!");
                        System.out.println("The Final positioning of board is as follows:");
                        Playboard.DrawBoard(Playboard.board);
                        gameEnded=true; 
                    }
                    else if(hasWon(Playboard.board)=='o')
                    {
                        System.out.println(player2+" has won !!");
                        System.out.println("The Final positioning of board is as follows:");
                        Playboard.DrawBoard(Playboard.board);
                        gameEnded=true;
                    }
                    else
                    {
                        if(full(Playboard.board))
                        {
                            System.out.println("It's a Tie !!");
                            System.out.println("The Final positioning of board is as follows:");
                            Playboard.DrawBoard(Playboard.board);
                            gameEnded=true;
                        }
                        else
                        {
                            isPlayer1=!isPlayer1;//Changing the turn 
                        }
                    }
                }
            }
            System.out.println("If you want to play another round enter 1 else enter any other number to exit.....");
            int x=in.nextInt();
            if(x==1)
            continue;
            else
            break;
        }
        in.close();

    }

    //This Function will check that any player has won or not 
    //It will return the winning character or will return '-' if game is still on
    public static char hasWon(char[][] board)
    {
        //Row
        for(int i=0;i<3;i++)
        {
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][0]!='-')
            return board[i][0];
        }

        //Column
        for(int j=0;j<3;j++)
        {
            if(board[0][j]==board[1][j] && board[1][j]==board[2][j] && board[0][j]!='-')
            return board[0][j];
        }

        //Diagnols
        if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0]!='-')
        return board[0][0];

        if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[1][1]!='-')
        return board[1][1];

        //Game is still on
        return '-';
    }
    
    //This function will check if there is any empty space on gameboard or not 
    //It will return (true) if all the spaces are occupied else (false)
    public static boolean full(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]=='-')
                return false;
            }
        }
        return true;
    }

    public static void Comp(char[][]board)
    {
        while(true)
        {
            char c='o';
            int row=0;
            int col=0;
            
            //It will first check the conditions such that there is any possibility of computer to  win
            //Horizontally
                for(int i=0;i<3;i++)
                {
                    if(board[i][0]=='o' && board[i][1]=='o' && board[i][2]=='-')
                    {
                        board[i][2]='o';
                        return;
                    }
                    else if(board[i][0]=='o' && board[i][1]=='-' && board[i][2]=='o')
                    {
                        board[i][1]='o';
                        return;
                    }
                    else if(board[i][0]=='-' && board[i][1]=='o' && board[i][2]=='o')
                    {
                        board[i][0]='o';
                        return;
                    }
                }
            //Vertically
                for(int i=0;i<3;i++)
                {
                    if(board[0][i]=='o' && board[1][i]=='o' && board[2][i]=='-')
                    {
                        board[2][i]='o';
                        return;
                    }
                    else if(board[0][i]=='o' && board[1][i]=='-' && board[2][i]=='o')
                    {
                        board[1][i]='o';
                        return;
                    }
                    else if(board[0][i]=='-' && board[1][i]=='o' && board[2][i]=='o')
                    {
                        board[0][i]='o';
                        return;
                    }
                }
            //Diagonally
                if(board[0][0]=='o' && board[1][1]=='o' && board[2][2]=='-')
                {
                    board[2][2]='o';
                    return;
                }
                else if(board[0][0]=='o' && board[1][1]=='-' && board[2][2]=='o')
                {
                    board[1][1]='o';
                    return;
                }
                else if(board[0][0]=='-' && board[1][1]=='o' && board[2][2]=='o')
                {
                    board[0][0]='o';
                    return;
                }

                if(board[0][2]=='o' && board[1][1]=='o' && board[2][0]=='-')
                {
                    board[2][0]='o';
                    return;
                }
                else if(board[0][2]=='o' && board[1][1]=='-' && board[2][0]=='o')
                {
                    board[1][1]='o';
                    return;
                }
                else if(board[0][2]=='-' && board[1][1]=='o' && board[2][0]=='o')
                {
                    board[0][2]='o';
                    return;
                }

            //If there is no such case that computer is winning , we will check the conditions to stop the player from winning 
            //Horizontally
                for(int i=0;i<3;i++)
                {
                    if(board[i][0]=='x' && board[i][1]=='x' && board[i][2]=='-')
                    {
                        board[i][2]='o';
                        return;
                    }
                    else if(board[i][0]=='x' && board[i][1]=='-' && board[i][2]=='x')
                    {
                        board[i][1]='o';
                        return;
                    }
                    else if(board[i][0]=='-' && board[i][1]=='x' && board[i][2]=='x')
                    {
                        board[i][0]='o';
                        return;
                    }
                }
            //Vertically
                for(int i=0;i<3;i++)
                {
                    if(board[0][i]=='x' && board[1][i]=='x' && board[2][i]=='-')
                    {
                        board[2][i]='o';
                        return;
                    }
                    else if(board[0][i]=='x' && board[1][i]=='-' && board[2][i]=='x')
                    {
                        board[1][i]='o';
                        return;
                    }
                    else if(board[0][i]=='-' && board[1][i]=='x' && board[2][i]=='x')
                    {
                        board[0][i]='o';
                        return;
                    }
                }
            //Diagonallly
                if(board[0][0]=='x' && board[1][1]=='x' && board[2][2]=='-')
                {
                    board[2][2]='o';
                    return;
                }
                else if(board[0][0]=='x' && board[1][1]=='-' && board[2][2]=='x')
                {
                    board[1][1]='o';
                    return;
                }
                else if(board[0][0]=='-' && board[1][1]=='x' && board[2][2]=='x')
                {
                    board[0][0]='o';
                    return;
                }

                if(board[0][2]=='x' && board[1][1]=='x' && board[2][0]=='-')
                {
                    board[2][0]='o';
                    return;
                }
                else if(board[0][2]=='x' && board[1][1]=='-' && board[2][0]=='x')
                {
                    board[1][1]='o';
                    return;
                }
                else if(board[0][2]=='-' && board[1][1]=='x' && board[2][0]=='x')
                {
                    board[0][2]='o';
                    return;
                }
                else
                {
                    //If any of the above conditions don't satisfy we will play a random move from computer's side
                    row=(int)((10*Math.random())%3);
                    col=(int)((10*Math.random())%3);
                    if(board[row][col]=='-')
                    {
                        board[row][col]='o';
                        return;
                    }
                }
            
        }
    }
}
import java.util.Scanner;
import javax.sql.RowSetInternal;
import java.io.*;
import java.util.*;

class GameChar {
    int posX = 0;
    int posY = 0;
    GameChar(char[][] board, int row, int column) {
        String command = "";

        //System.out.print(board[posX][posY]);

        while(true){
            Scanner input = new Scanner(System.in);
            command = input.nextLine();
            String[] arrOfStr = command.split(" ");

            if (arrOfStr.length == 2) {
                String direction = arrOfStr[1];
                String firstWord = arrOfStr[0];
                String[] arrOfStr2 = firstWord.split("");
                String firstLetter = arrOfStr2[0];


                switch (direction){
                    case "south":
                        if (posY == row-1){
                            System.out.println("You can't go that far south.");
                            System.out.println("Your location is (" + posX + "," + posY + ")"+ " in terrain " + board[posY][posX]);

                        }
                        else {
                            posY = posY + 1;
                            System.out.println("Your location is (" + posX + "," + posY + ")" + " in terrain " + board[posY][posX]);
                            //System.out.println(posX);
                        }
                        break; //end south

                    case "north":
                        if (posY == 0){
                            System.out.println("You can't go that far north.");
                            System.out.println("Your location is (" + posX + "," + posY + ")"+ " in terrain " + board[posY][posX]);
                        }
                        else {
                            posY = posY - 1;
                            System.out.println("Your location is (" + posX + "," + posY + ")" + " in terrain " + board[posY][posX]);
                        }
                        break; // end north

                    case  "east":
                        if (posX == column-1){
                            System.out.println("You can't go that far east.");
                            System.out.println("Your location is (" + posX + "," + posY + ")" + " in terrain " + board[posY][posX]);
                        }
                        else {
                            posX = posX + 1;
                            System.out.println("Your location is (" + posX + "," + posY + ")" + " in terrain " + board[posY][posX]);
                        }
                        break;

                    case "west":
                        if (posX == 0){
                            System.out.println("You can't go that far west.");
                            System.out.println("Your location is (" + posX + "," + posY + ")" + " in terrain " + board[posY][posX]);

                        }
                        else {
                            posX = posX - 1;
                            System.out.println("Your location is (" + posX + "," + posY + ")" + " in terrain " + board[posY][posX]);
                        }
                        break;
                    //here
                }
                for(int dy= -1; dy <= 1; dy++){
                    for(int dx=-1; dx<=1; dx++){
                        int x = posX + dx;
                        int y = posY + dy;
                        if(0<=x && x< column && 0<=y && x < row) {
                            System.out.print(board[x][y]);
                        }
                        else {
                            System.out.print("x");
                        }
                    }
                    System.out.print("\n");
                }
            }

            else if (arrOfStr.length == 1) {
                String[] x = command.split("");
                String firstLetter = x[0];
                if (firstLetter.equals("i")){
                    System.out.println("You are carrying:");
                    System.out.println("brass lantern");
                    System.out.println("rope");
                    System.out.println("rations");
                    System.out.println("staff");
                    System.out.println("Your location is (" + posX + "," + posY + ")" + " in terrain " + board[posX][posY]);
                }
                else if(firstLetter.equals("q")){
                    System.out.println("Your location is (" + posX + "," + posY + ")" + " in terrain " + board[posX][posY]);
                    System.out.println("Farewell");
                    System.exit(0);
                }

                else {
                    System.out.println("Invalid commment: " + command);
                    System.out.println("Your location is (" + row + "," + column + ")");
                }
            }
        }
    }
}

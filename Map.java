import java.util.Scanner;
import javax.sql.RowSetInternal;
import java.io.*;
import java.util.*;

class Map {
    Map() {
        //char board[][] = new char[10][10];
        //String searchedWord = "";
       System.out.print("Enter a file name: ");
        Scanner fin = null;
        String nm;
        Scanner in = new Scanner(System.in);
        nm = in.next();

        try {
            fin = new Scanner(new File(nm));
        }
        catch (FileNotFoundException x) {
            System.out.println("File open failed.");
            x.printStackTrace();
            System.exit(0);   // TERMINATE THE PROGRAM
        }
        String line;
        //int r = 0;
        //board = new char[10][10];

        // create board
        int count = 0;
        int row = 0;
        int column = 0;


        while (fin.hasNextLine() && count < 1) {
            line = fin.nextLine();
            String[] splited = line.split(" ");
            row = Integer.parseInt(splited[0]);
            column = Integer.parseInt(splited[1]);
            count++;
            //break; 
        }

        //System.out.println(row + " " + column);
        char board[][] = new char[row][column];
        // read in rest of text file to create our board
        int r = 0;
        while(fin.hasNextLine()){
            line = fin.nextLine();
          /*if(line.equals("")){
            break;
          }*/
            //System.out.println("current line is " + line);
            for(int c = 0; c < column; c++){
                board[r][c] = line.charAt(c);
                //System.out.println(line.charAt(c));
            }
            r++;
        }
        //print board
        /*for(int i = 0; i < row; i++){
          for(int j = 0; j < column; j++){
            System.out.print(board[i][j]);
          }
          System.out.print("\n");
        }*/
        GameChar boardh = new GameChar(board, row, column);
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pc.Dell
 */
public class TicTac {

    static ArrayList<Integer> playerposition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuposition = new ArrayList<Integer>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char[][] gameboard = {{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};

        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter your placement(1-9)");
            int playerpos = s.nextInt();
            while (playerposition.contains(playerpos) || cpuposition.contains(playerpos)) {
                System.out.println("position taken int accorect position");
                playerpos = s.nextInt();
            }
            placepiece(gameboard, playerpos, "player");
            String result=checkWinner();
            if (result.length()>0) {
                System.out.println(result);
                printShape(gameboard);
              break;
            }
            Random random = new Random();
            int cpupos = random.nextInt(9) + 1;
            while (playerposition.contains(cpupos) || cpuposition.contains(cpupos)) {
                cpupos = random.nextInt(9) + 1;
            }
            placepiece(gameboard, cpupos, "cpu");
            printShape(gameboard);
              result=checkWinner();
            if (result.length()>0) {
                System.out.println(result);
                printShape(gameboard);
                break;
            }
System.out.println(checkWinner());
        }

    }

    public static String checkWinner() {
        List toprow = Arrays.asList(1, 2, 3);
        List midrow = Arrays.asList(4, 5, 6);
        List botrow = Arrays.asList(7, 8, 9);
        List leftcol = Arrays.asList(1, 4, 7);
        List midcol = Arrays.asList(2, 5, 8);
        List rightcol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);
        
        List<List> winning = new ArrayList<List>();
        winning.add(toprow);
        winning.add(midrow);
        winning.add(botrow);
        winning.add(leftcol);
        winning.add(midcol);
        winning.add(cross1);
        winning.add(cross2);
        
        for (List l : winning) {
            
            if (playerposition.containsAll(l)) {
                return "Congertulations you Win 👍🎈🎈🎈🎈🎉🎉🎉🎉";
            } else if (cpuposition.containsAll(l)) {
                return "cpu win sorry!";
            } else if (playerposition.size() + cpuposition.size() == 9) {

                return "==!";
            }
        }

        return "";
    }

    public static void printShape(char[][] game) {

        for (char[] row : game) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();

        }

    }

    public static void placepiece(char[][] game, int pos, String user) {
        
        char symbole = ' ';
        if (user.equals("player")) {
            symbole = 'X';
            playerposition.add(pos);

        } else if (user.equalsIgnoreCase("cpu")) {

            symbole = 'O';
            cpuposition.add(pos);
        }

        switch (pos) {
            case 1:
                game[0][0] = symbole;
                break;
            case 2:
                game[0][2] = symbole;
                break;
            case 3:
                game[0][4] = symbole;
                break;
            case 4:
                game[2][0] = symbole;
                break;
            case 5:
                game[2][2] = symbole;
                break;
            case 6:
                game[2][4] = symbole;
                break;
            case 7:
                game[4][0] = symbole;
                break;
            case 8:
                game[4][2] = symbole;
                break;
            case 9:
                game[4][4] = symbole;
            default:
                break;
        }
    }

}

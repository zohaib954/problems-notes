package LLD;

import java.util.Scanner;

class GuessGame {
    public static void main(String[] args) {

        int player_1, player_2, player_3;

        Scanner s = new Scanner(System.in);
        while (true) {
            int num = (int) (Math.random() * 10);
            System.out.println("Player 1 Enter number");
            player_1 = s.nextInt();
            System.out.println("Player 2 Enter number");
            player_2 = s.nextInt();
            System.out.println("Player 3 Enter number");
            player_3 = s.nextInt();
            System.out.println("Computer generated number is " + num);
            if (player_1 == num) {
                System.out.println("player 1 is winner: " + player_1);
                break;
            } else if (player_2 == num) {
                System.out.println("Player 2 is winner: " + player_2);
                break;
            } else if (player_3 == num) {
                System.out.println("Player 3 is winner: " + player_3);
                break;
            }
        }
    }
}
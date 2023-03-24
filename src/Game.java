import org.fusesource.jansi.Ansi;

import java.util.Scanner;

public class Game {
    private Grid grid = new Grid(10, 10);
    private Player[] players;
    private Player currentTurn;

    public Game(int players) {
        Scanner scan = new Scanner(System.in);

        Player[] tempPlayers = new Player[players];

        for (int i = 0; i < players; i++) {
            System.out.printf("What is Player %d's name?: ", i + 1);
            String name = scan.nextLine();

            System.out.printf("What is Player %d's color?: ", i + 1);
            String color = scan.nextLine();

            tempPlayers[0] = new Player(name, color);
        }

        this.players = tempPlayers;
    }

    @Override
    public String toString() {
        return grid.toString();
    }
}
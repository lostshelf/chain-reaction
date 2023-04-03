import org.fusesource.jansi.Ansi;

import java.util.Scanner;

public class Game {
    private Grid grid;
    private Player[] players;
    private Player currentTurn;

    public Game(int player_amount) {
        Scanner scan = new Scanner(System.in);

        players = new Player[player_amount];

        for (int i = 0; i < player_amount; i++) {
            System.out.printf("What is Player %d's name?: ", i + 1);
            String name = scan.nextLine();

            System.out.printf("What is Player %d's color?: ", i + 1);
            String color = scan.nextLine();

            players[i] = new Player(name, color.toUpperCase());
        }

        grid = new Grid(10, 10, players);
    }

    @Override
    public String toString() {
        return grid.toString();
    }
}
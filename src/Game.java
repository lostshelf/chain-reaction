import org.fusesource.jansi.Ansi;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private static final HashMap<String, String> scenes = new HashMap<>();

    static {
        scenes.put(
            "main menu",
            """
            Chain Reaction
            """
        );
    }

    private Grid grid;
    private static Player[] players;
    private static Player currentTurn;

    public static Player[] getPlayers() {
        return players;
    }

    public static Player getCurrentTurn() {
        return currentTurn;
    }

    public Game() {
        // Scanner object for user input
        Scanner scan = new Scanner(System.in);

        int playerAmount = 2;
        while (true) {
            // Prompt user for the amount of players
            System.out.print("How many players will be playing? (Maximum: 8 | Default: 2): ");

            // Store input as an integer in a variable for later use
            playerAmount = scan.nextInt();
            // Discard any other characters left in the output
            scan.nextLine();

            if (playerAmount > 8 || playerAmount < 2) {
                System.err.println("Invalid player amount.");
                continue;
            }

            break;
        }

        players = new Player[playerAmount];

        for (int i = 0; i < playerAmount; i++) {
            while (true) {
                System.out.printf("What is Player %d's color?: ", i + 1);
                String color = scan.nextLine();

                try {
                    players[i] = new Player("", color.toUpperCase());
                } catch(Exception e) {
                    System.out.println("Invalid color.");
                    continue;
                }

                break;
            }
        }

        grid = new Grid(10, 10, players);
    }

    @Override
    public String toString() {
        return grid.toString();
    }

    void loop() {

    }
}
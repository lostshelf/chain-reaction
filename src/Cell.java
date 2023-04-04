import java.util.*;

import static org.fusesource.jansi.Ansi.ansi;

public class Cell {
    private HashMap<Player, Integer> orbs;

    public Cell(Player[] players) {
        orbs = new HashMap<>();

        for (int i = 0; i < players.length; i++)
            orbs.put(players[i], 0);
    }

    public void setOrbs(Player player, int amount) {
        orbs.put(player, amount);
    }

    public int getOrbs(Player player) {
        return orbs.get(player);
    }

    public static Cell[][] getCellArray(int rows, int columns, Player[] players) {
        Cell[][] cells = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                    cells[i][j] = new Cell(players);
            }
        }

        return cells;
    }

    @Override
    public String toString() {
        String output = "";

        var players = orbs.keySet();

        for (Player p : players) {
                output = output.concat(" " +
                    ansi()
                        .render(
                            String.format("@|%s %s|@", p.getColor(), orbs.get(p))
                        ).toString()
                    + " "
                );
        }

        return output;
    }

    public int playerCount() {
        int players = orbs.keySet().toArray().length;

        System.out.printf("There are %d players.%n", players);

        return players;

    }
}
import java.util.HashMap;

import static org.fusesource.jansi.Ansi.ansi;

public class Cell {
    private HashMap<Player, Integer> orbs;

    public Cell() {
        orbs = new HashMap<>();
    }

    public void addOrbs(Player player) {
        orbs.put(player, orbs.get(player) + 1);
    }

    @Override
    public String toString() {
        String output = "";

        orbs.forEach((player, amount) -> System.out.printf("%s ", ansi().render(String.format("@|%s %s|&", player.getColor(), amount))));

        return output;
    }
}
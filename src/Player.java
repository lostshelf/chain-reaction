import org.fusesource.jansi.Ansi.Color;
import static org.fusesource.jansi.Ansi.Color.*;

public class Player {
    private String name;
    private Color color;

    public Player(String name, String color) {
        this.name = name;
        this.color = valueOf(color);
    }

    public String getName() { return name; }
    public String getColor() { return color.toString(); }
}
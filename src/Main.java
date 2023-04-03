import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import org.fusesource.jansi.AnsiConsole;

public class Main {
    public static void main(String[] args) {
        AnsiConsole.systemInstall();

        Game game = new Game(1);

        System.out.println(game);
    }
}
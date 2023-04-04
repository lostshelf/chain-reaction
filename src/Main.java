import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import org.fusesource.jansi.AnsiConsole;

public class Main {
    public static void main(String[] args) {
        // Set up the console to use the jansi library
        AnsiConsole.systemInstall();

        // Create the main game client
        Game game = new Game();

        // Start the main game loop
        game.loop();

        // Return console back to normal
        AnsiConsole.systemUninstall();
    }
}
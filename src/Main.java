import org.fusesource.jansi.AnsiConsole;

public class Main {
    public static void main(String[] args) {
        AnsiConsole.systemInstall();

        Game game = new Game(2);
    }
}
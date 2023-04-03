public class Grid {
    private Cell[][] cells;

    public Grid() {
        cells = new Cell[9][6];
    }
    public Grid(int rows, int columns, Player[] players) {
        cells = Cell.getCellArray(rows, columns, players);
    }

    @Override
    public String toString() {
        // Buffer to hold output in
        String output = "  ";

        // Loop through each column and add a letter to the top
        for (int i = 0; i < cells[0].length; i++)
            output = output.concat(String.format("  %c ", (char) (65 + i)));

        // Move cursor to the next line
        output = output.concat("\n");

        int rowCount = 1;
        for (Cell[] rows : cells) {
            output = output.concat(String.format("%s%d ", (rowCount > 10) ? " " : "", rowCount));
            for (Cell cell : rows)
                output = output.concat(String.format("| %s ", cell));

            output = output.concat("|");

            // No idea why I need to add three for it to work but I'll get to figuring that out eventually
            if (rowCount != rows.length + 3)
                output = output.concat("\n");

            rowCount++;
        }

        return output;
    }

    public int getCriticalMass(int row, int column) {
        // Struggling to figure out how to calculate the critical mass of each cell so I did this to make the code
        // easier to follow along
        boolean isInFirstRow = row == 0;
        boolean isInLastRow = row == cells.length - 1;

        boolean isInFirstColumn = column == 0;
        boolean isInLastColumn = column == cells[0].length - 1;

        if ((isInFirstRow || isInLastRow) && (isInFirstColumn || isInLastColumn))
            return 2;

        if (isInFirstRow || isInLastRow || isInFirstColumn || isInLastColumn)
            return 3;

        return 4;
    }

    // Add an orb to the specified cell
    public void addOrb(int row, int column, Player player) {
        cells[row][column].setOrbs(player, cells[row][column].getOrbs(player) + 1);
    }
}
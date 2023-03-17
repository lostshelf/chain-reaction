public class Grid {
    private int[][] cells;

    public Grid() {
        cells = new int[9][6];
    }
    public Grid(int rows, int columns) {
        cells = new int[rows][columns];
    }

    @Override
    public String toString() {
        String output = "";

        for (int[] rows : cells) {
            for (int cell : rows)
                output = output.concat(String.format("| %d ", cell));

            output = output.concat("|\n");
        }

        return output;
    }

    public int getCriticalMass(int row, int column) {
        int adjCells = 0;

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
}
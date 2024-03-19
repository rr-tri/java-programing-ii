
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        int num = 1;
        int row = 0;
        int col = size / 2;

        // Fill in the magic square using the Siamese method algorithm
        while (num <= size * size) {
            square.placeValue(row, col, num);
            // Move diagonally up and to the right
            int nextRow = (row - 1 + size) % size;
            int nextCol = (col + 1) % size;
            // If the next cell is already occupied, move down one cell instead
            if (square.readValue(nextRow, nextCol) != 0) {
                row = (row + 1) % size;
            } else {
                row = nextRow;
                col = nextCol;
            }
            num++;
        }
        return square;
    }

}

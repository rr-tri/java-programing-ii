
public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here

        MagicSquareFactory msFactory = new MagicSquareFactory();
        System.out.println(msFactory.createMagicSquare(5));
        System.out.println("");
        MagicSquare ms = new MagicSquare(3);
        ms.placeValue(0, 0, 8);
        ms.placeValue(0, 1, 3);
        ms.placeValue(0, 2, 4);
        ms.placeValue(1, 0, 1);
        ms.placeValue(1, 1, 5);
        ms.placeValue(1, 2, 9);
        ms.placeValue(2, 0, 6);
        ms.placeValue(2, 1, 7);
        ms.placeValue(2, 2, 2);
        System.out.println(ms.toString());
        System.out.println("sum of rows: " + ms.sumsOfRows());
        System.out.println("sum of columns: " + ms.sumsOfColumns());
        System.out.println("sum of diagonals: " + ms.sumsOfDiagonals());

        MagicSquare ms1 = new MagicSquare(3);

        ms1.placeValue(0, 0, 1);
        ms1.placeValue(0, 1, 4);
        ms1.placeValue(0, 2, 7);
        ms1.placeValue(1, 0, 2);
        ms1.placeValue(1, 1, 5);
        ms1.placeValue(1, 2, 8);
        ms1.placeValue(2, 0, 3);
        ms1.placeValue(2, 1, 6);
        ms1.placeValue(2, 2, 9);
        System.out.println(ms1.toString());
        System.out.println("sum of rows: " + ms1.sumsOfRows());
        System.out.println("sum of columns: " + ms1.sumsOfColumns());
        System.out.println("sum of diagonals: " + ms1.sumsOfDiagonals());
    }
}

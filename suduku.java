
public class suduku {
    // create isSafe function to check the number is safe or not.
    public static boolean isSafe(int arr[][], int row, int col, int n) {
        // row checking.
        for (int i = 0; i < arr.length; i++) {
            if (n == arr[i][col]) {
                return false;
            }
        }
        // column checking.
        for (int i = 0; i < arr.length; i++) {
            if (n == arr[row][i]) {
                return false;
            }
        }
        // grid checking.

        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i + startRow][j + startCol] == n) {
                    return false;
                }
            }
        }

        return true;

    }
    // recursive function

    public static boolean sudukuSolve(int arr[][], int row, int col) {

        if (row == arr.length - 1 && col == arr.length) {

            return true;

        }

        if (col == arr.length) {

            row++;
            col = 0;
        }
        /*
         * check if there is a number already exist or not/
         * if exist then go to next col otherwise place a nimber from 1 to 9
         */

        if (arr[row][col] != 0) {
            return (sudukuSolve(arr, row, col + 1));
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(arr, row, col, i)) {
                arr[row][col] = i;
                if (sudukuSolve(arr, row, col + 1)) {
                    return true;
                }

            }
            /* if the number placed is wrong then simply remove the number and place 0 */
            arr[row][col] = 0;

        }

        return false;

    }
    // print function

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        // int arr[][]=new int[9][9];
        int arr[][] = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

        if (sudukuSolve(arr, 0, 0)) {
            print(arr);
        } else {
            System.out.println("no solution exist");
        }

    }
}

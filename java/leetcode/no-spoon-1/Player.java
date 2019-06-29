import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.IntStream;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {
    public static int width;
    public static int height;
    public static int[][] board;
    public static int[][] transpose;

    public static String[] linesIn = { "..0....", ".......", "..0.0.0", ".......", "0.0.0..", ".......", "....0.." };
    public static int widthIn = 7;
    public static int heightIn = 7;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Player.setWidthAndHeight(in);
        Player.setBoard(in);
        Player.setTranspose();
        in.close();

        print("board:");
        print(Player.board);
        print("");

        print("tranpose:");
        print(Player.transpose);
        print("");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (Player.board[i][j] == 0) {
                    print("Skipping node: (i = " + i + ", j = " + j + ")");
                    continue;
                }

                int rightIdx = findIndex(Player.getRow(i), j + 1);
                int bottomIdx = findIndex(Player.getColumn(j), i + 1);

                int[] right = { i, rightIdx };
                int[] bottom = { bottomIdx, j };

                if (rightIdx == -1)
                    right = new int[] { -1, -1 };

                if (bottomIdx == -1)
                    bottom = new int[] { -1, -1 };

                String result = j + " " + i + " " + right[1] + " " + right[0] + " " + bottom[1] + " " + bottom[0];

                print(result);
                System.out.println(result);
            }

        }
    }

    public static void setTranspose() {
        int[][] transpose = new int[Player.width][Player.height];
        for (int i = 0; i < Player.height; i++) {
            for (int j = 0; j < Player.width; j++) {
                transpose[j][i] = Player.board[i][j];
            }
        }
        Player.transpose = transpose;
    }

    public static void setBoard(Scanner in) {
        Player.board = new int[Player.height][Player.width];
        char[] chars;
        for (int i = 0; i < Player.height; i++) {
            // String line = in.nextLine(); // Width characters, each either 0 or .
            String line = Player.linesIn[i];
            chars = line.toCharArray();

            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '0')
                    Player.board[i][j] = 1;
                else
                    Player.board[i][j] = 0;
            }

            print(line);
        }
        print("");
    }

    public static void setWidthAndHeight(Scanner in) {
        // Player.width = in.nextInt(); // The number of cells on the X axis
        // Player.height = in.nextInt(); // The number of cells on the Y axis

        // if (in.hasNextLine())
        // print(in.nextLine());
        Player.width = Player.widthIn;
        Player.height = Player.heightIn;
    }

    public static void print(String str) {
        System.err.println(str);
    }

    public static void print(int n) {
        System.err.println(n);
    }

    public static void print(int[] arr) {
        print(Arrays.toString(arr));
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            print(Arrays.toString(arr[i]));
    }

    public static int[] getRow(int k) {
        return Player.board[k];
    }

    public static int[] getColumn(int k) {
        return Player.transpose[k];
    }

    public static int findIndex(int arr[], int startIdx) {
        return IntStream.range(startIdx, arr.length) // Choose range of indices
                .filter(i -> 1 == arr[i]) // Filter out those equal to 1
                .findFirst() // First occurence
                .orElse(-1); // No element found
    }
}
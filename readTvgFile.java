import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class readTvgFile {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File(args[0]));
        int row = sc.nextInt();
        int col = sc.nextInt();
        String[][] canvas = new String[row][col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {

                canvas[i][j] = ".";
            }
        }

        while (sc.hasNext()) { // read each character one by one until the end of the file
            // String temp = sc.nextLine();
            // System.out.println(temp);
            // if (temp.length() < 5) {
            // System.out.println("not a sufficient command line");
            // }
            String renderChar = sc.next();
            int r = Integer.parseInt(sc.next());
            int c = Integer.parseInt(sc.next());
            String position = sc.next();
            int length = Integer.parseInt(sc.next());

            if (r < 0) {
                r = 0;
            }
            if (c < 0) {
                c = 0;
            }

            // replace on the canvas
            if (position.equals("h")) {
                System.out.println("hori");

                if (length > col) {
                    for (int i = 0; i < col; ++i) {
                        canvas[r][i] = renderChar;
                    }

                } else {
                    for (int i = 0; i < length; ++i) {
                        System.out.println("check" + i);
                        int increaseRow = c;
                        canvas[r][increaseRow] = renderChar;
                        ++increaseRow;
                    }
                }

            }

            else {
                System.out.println("vert");
                if (length > row) {
                    for (int i = 0; i < row; ++i) {
                        canvas[i][c] = renderChar;
                    }
                }
                else {
                    for (int i = r; i < length; ++i) {
                        canvas[i][c] = renderChar;
                    }
                }
            }
        }
        // close reading the file
        sc.close();

        // prinnt the canvas
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {

                System.out.print(canvas[i][j] + " ");
            }
            System.out.println();
        }
    }

}
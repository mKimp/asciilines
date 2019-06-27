import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class readTvgFile {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File(args[0]));
        int row = sc.nextInt(); // get the row for canvas
        int col = sc.nextInt(); // get the column for the canvas
        // create 2d array
        String[][] canvas = new String[row][col];
        // fill up with "."
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {

                canvas[i][j] = ".";
            }
        }
        // read the file starting on the second line
        while (sc.hasNext()) { // read each character one by one until the end of the file
            
            String renderChar = sc.next();
            int r = sc.nextInt();
            int c = sc.nextInt();
            String position = sc.next();
            int length = sc.nextInt();
            int increaseCol = c;
            int increaseRow = r;

            if (r < 0) {
                r = 0;
            }
            if (c < 0) {
                c = 0;
            }
            // the length of the rendered command line is greater than 0
            if (length > 0) {

                // render the char in the horizontal way, check the column
                if (position.equals("h")) {
                    // make sure if the length is larger than the canvas column, only points inside the canvas are rendered.
                    if (length >= col) {
                        for (int i = c; i < col; ++i) {
                        //    canvas[r][i] = renderChar;
                            canvas[r][i] = renderChar;
                            ++increaseCol;
                        }

                    }
                    // if the length is less than canvas column, only render the points until it hits the
                    else if (length < col) {
                        for (int i = 0; i < length; ++i) {
                            canvas[r][increaseCol] = renderChar;
                            ++increaseCol;
                        }
                    } 
                }

                else {
                    if (length >= row) {
                        for (int i = r; i < row; ++i) {
                            canvas[i][c] = renderChar;
                        }
                    } else if (length < row) {
                        for (int i = 0; i < length; ++i) {
                            
                            canvas[increaseRow][c] = renderChar;
                            ++increaseRow;
                        }
                    }
                }
            }
            // the length in rendered command line is 0 or less
            else {
               System.out.println("Error message: the length of " + "renderChar " + renderChar + " is " + length + " .It will not be rendered in the canvas"); //is/are 0, or negative, so the printed canvas only displays part/none of the correct canvas ");
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
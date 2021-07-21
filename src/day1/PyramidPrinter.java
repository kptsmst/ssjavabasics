package day1;

public class PyramidPrinter {
    public static void main(String[] args) {
        // total number of "pyramids" to print
        int totalPyramids = 4;
        // number of lines per pyramid
        int pyramidHeight = 5;
        // call function to build and print
        buildAndPrintPyramids(totalPyramids, pyramidHeight);
    }

    //builds and prints pyramids with the following pattern
    //every other pyramid is printed upside down
    //every 1st and 2nd pyramid in a set of 4 are not mirrored
    //every 3rd and 4th pyramid in a set of 4 are mirrored and have leading spaces
    //the last line, or biggest row in the pyramid, is always mirrored and never has leading spaces
    //the last line uses . characters
    //every other line uses * characters
    //the base number of characters in a line (before mirror) is the line number +1
    //after mirroring the number of characters is (line number * 2) + 1
    //the last line has #pyramidIndex additional characters

    public static void buildAndPrintPyramids(int totalPyramids, int pyramidHeight) {
        // a loop to make and print each pyramid
        for (int pyramidIndex = 0; pyramidIndex < totalPyramids; pyramidIndex++) {
            // every 2nd pyramid is reversed
            boolean reversed = (pyramidIndex % 2 == 1);
            // array to hold the lines
            String lines[] = new String[pyramidHeight];
            // if it is the 3rd or 4th pyramid per set of 4, add leading spaces to non-last
            // lines
            boolean addLeadingSpaces = (pyramidIndex % 4) > 1;

            // loop to fill the line array with the lines
            for (int lineIndex = 0; lineIndex < pyramidHeight; lineIndex++) {
                // flag to indicate if this line is the "last line"
                boolean lastLine = (lineIndex == pyramidHeight - 1);
                // set line char
                char lineChar = lastLine ? '.' : '*';
                // initialize empty string to build pyramid row on
                String line = "";

                // add leading spaces if required
                if (addLeadingSpaces && !lastLine) {
                    int leadingSpaces = pyramidHeight - lineIndex;
                    for (int spaceIndex = 0; spaceIndex < leadingSpaces; spaceIndex++) {
                        line += " ";
                    }
                }

                /*
                 * TODO refactor string filling loop and last line extra character loop to use a
                 * "charCount" variable and combine them
                 */
                // loop to fill string
                for (int charIndex = 0; charIndex < lineIndex + 1; charIndex++) {
                    line += lineChar;
                    // mirrors non-last lines if the pyramid has leading spaces
                    // always mirrors last line
                    if ((addLeadingSpaces || lastLine) && charIndex != 0) {
                        line += lineChar;
                    }
                }

                // adds #pyramidIndex extra characters to the last line
                if (lastLine) {
                    int extraChars = pyramidIndex;
                    // System.out.println(extraChars);
                    for (int extraCharIndex = 0; extraCharIndex < extraChars; extraCharIndex++) {
                        line += lineChar;
                    }
                }

                // adds completed row to pyramid rows array
                lines[lineIndex] = line;
            }

            // call printing helper
            printPyramid(pyramidIndex, lines, reversed);

        }
    }

    // print lines and also labels pyramid number, prints in reverse if parameter is
    // true
    // pyramidIndex: count for pyramid label
    // lines[]: list of pyramid rows
    // reversed: whether or not to print the pyramid rows in reverse
    public static void printPyramid(int pyramidIndex, String lines[], boolean reversed) {
        // print label
        System.out.println((pyramidIndex + 1) + ")");
        for (int linePrintIndex = 0; linePrintIndex < lines.length; linePrintIndex++) {
            // determine pyramid row index to print based on loop index and reversed flag;
            int indexToPrint = reversed ? lines.length - linePrintIndex - 1 : linePrintIndex;
            // print call
            System.out.println(lines[indexToPrint]);
            // helper print call to count line lengths
            // System.out.println(lines[indexToPrint].length());
        }
    }
}

// alternate pattern for last line could be (line + 1) * 2 + pyramid index
// instead of (line + 1) + total number of lines + pyramid index

// Assignment 1, print the following pattern using loops

// 1)
// * //1 *
// ** //2 *
// *** //3 *
// **** //4 *
// ......... //9 .
// 2)
// .......... //10 .
// **** //4 *
// *** //3 *
// ** //2 *
// * //1 *
// 3)
// * //5 _ 1 *
// *** //4 _ 3 *
// ***** //3 _ 5 *
// ******* //2 _ 7 *
// ........... //0 _ 11 .
// 4)
// ............ //12 . 0 _
// ******* //7 * 2 _
// ***** //5 * 3 _
// *** //3 * 4 _
// * //1 * 5 _

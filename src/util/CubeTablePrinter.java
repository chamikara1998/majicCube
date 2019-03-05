package util;

import java.awt.*;

/**
 * This class for Print Cube Table
 */
public class CubeTablePrinter implements TablePrinter {

    /**
     * This method for print cube table view
     */
    @Override
    public void print2DArray(int value[][], boolean errorMode,int faces) {
        System.out.println();
        String tableLine = "";
        for (int i = 0;i< faces; i++) {
            tableLine = "+";
            String tempString = "| ";
            for (int j = 0; j < faces; j++) {
                tableLine += "-------+";
                tempString += center(String.valueOf(value[i][j]), 5) + " | ";
            }
            if (errorMode) {
                System.err.println(tableLine);
                System.err.println(tempString);
            } else {
                System.out.println(tableLine);
                System.out.println(tempString);
            }
        }
        if (errorMode) {
            System.err.println(tableLine);
        } else {
            System.out.println(tableLine);
        }

    }

//
    /**
     * Center Strings in cube layout
     */
    public static String center(String s, int size) {
        return center(s, size, ' ');
    }

    /**
     * Center Strings in cube layout
     */
    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(pad);
        }
        sb.append(s);
        while (sb.length() < size) {
            sb.append(pad);
        }
        return sb.toString();
    }
}

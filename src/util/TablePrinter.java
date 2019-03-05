package util;

/**
 * This interface for Print  Table
 */
public interface TablePrinter {

    /**
     * This Method for Print Cube Table Layout
     *
     * @param value 2D Array
     * @param errorMode errorMode
     */
    void print2DArray(int value[][],boolean errorMode,int faces);
}

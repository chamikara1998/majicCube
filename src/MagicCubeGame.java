
import exceptions.CubeInputNotValidatedException;
import util.CubeTablePrinter;
import util.TablePrinter;
import validator.CubeFaceValueValidator;
import validator.ValueValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * This class for Magic Cube Game
 */
public class MagicCubeGame implements CubeGame {

    private int cubeValues[][];
    private int faceAmount = 0;

    /**
     * This method is to start Majic Cube Game
     */
    @Override
    public void startGame() {
        System.out.println("\n");
        while (true) {
            try {
                faceAmount = readAmountOfFaces();
                cubeValues= new int[faceAmount][faceAmount];
                break;
            } catch (CubeInputNotValidatedException e){
                continue;
            }
        }


        for (int i = 0; i < faceAmount; i++) {
            for (int j = 0; j < faceAmount; j++) {
                try {
                    int faceNumber = i * faceAmount + j;
                    cubeValues[i][j] = readCubeValue(faceNumber);
                } catch (CubeInputNotValidatedException e) {
                    j -= 1;
                    continue;
                }
            }
        }

        ValueValidator valueValidator = new CubeFaceValueValidator(cubeValues,faceAmount);
        boolean isMagicCube = valueValidator.isMagicCubeValid();
        boolean isLoShuCube = valueValidator.isLoShuCube();
        TablePrinter tablePrinter = new CubeTablePrinter();
        tablePrinter.print2DArray(cubeValues, !(isMagicCube || isLoShuCube),faceAmount);

            if (isMagicCube) {
                System.out.println("\nThis is valid Magic Cube.");
            } else {
                System.err.println("\nThis is not valid Magic Cube. \n");
            }
            if (isLoShuCube) {
                System.out.println("\nThis is valid Lo Shu Cube.");
            }else {
                System.err.println("\nThis is not valid Lo Shu Cube. \n");
            }

            if (!isMagicCube && !isLoShuCube){
                valueValidator.printReasons();
            }

    }

    /**
     * Read Cube Value
     *
     * @param cubeFace Magic Cube's Face
     * @return Readed Value
     * @throws IOException IOException
     */
    private int readCubeValue(int cubeFace) throws CubeInputNotValidatedException {
        int value = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //Get Input From User
            String inputPromptMessage = "Enter Magic cube " + String.valueOf(cubeFace+1) + " face value \t : ";
            System.out.print(inputPromptMessage);
            value = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException e) {
            throw new CubeInputNotValidatedException(e);
        }
        return value;
    }


    /**
     * Read Cube Value
     *

     * @return Readed Value
     * @throws IOException CubeInputNotValidatedException
     */
    private int readAmountOfFaces() throws CubeInputNotValidatedException {
        int value = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //Get Input From User
            String inputPromptMessage = "How many faces are in your cube? \n> " ;
            // Add Single tab and Double Tab to keep Input Start Same alignment
            System.out.print(inputPromptMessage);
            value = Integer.parseInt(br.readLine());
            System.out.println();
        } catch (NumberFormatException | IOException e) {
            throw new CubeInputNotValidatedException(e);
        }
        return value;
    }
}

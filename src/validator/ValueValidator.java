package validator;

/**
 * This Interface for check Values are valid and cube is valid
 */
public interface ValueValidator {

    /**
     * This Method for get Cube is Valid or not
     *
     * @return
     */
    boolean isMagicCubeValid();

    /**
     * This method for print what is the reason that cube is not valid
     */
    void printReasons();

    /**
     * This method for check LoShuCube
     */
    boolean isLoShuCube();

}

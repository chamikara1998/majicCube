package exceptions;

/**
 * This exception for user input is not valid
 */
public class CubeInputNotValidatedException extends Exception{

    public CubeInputNotValidatedException(Exception e){
        super(e);
    }

    public CubeInputNotValidatedException(String message, Exception e){
        super(message,e);
    }
}

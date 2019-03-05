package validator;

import java.util.ArrayList;
import java.util.List;

public class CubeFaceValueValidator implements ValueValidator {

    private int cubeValues[][];
    private int magicNumber = -1;
    private int numberOfFaces = 0;

    private List<String> reasons = new ArrayList<>();

    public CubeFaceValueValidator(int cubeValues[][],int faces){
        this.cubeValues = cubeValues;
        this.numberOfFaces = faces;
    }

    /**
     * Check magic cube is valid
     *
     * @return isMagicCubeValid
     */
    public boolean isMagicCubeValid(){
        boolean isRowValid = this.isLinearValid(true);
        boolean isColumnValid = this.isLinearValid(false);
        boolean isCrossValid = this.isCrossValid();
        return isRowValid && isColumnValid && isCrossValid;
    }

    public boolean isLoShuCube(){
        boolean isRowValid = this.isLinearValid(true);
        boolean isColumnValid = this.isLinearValid(false);
        boolean isCrossValid = this.isCrossValid();
        boolean isDuplicated = this.isDuplicated();
        boolean isValueInRange = this.isValueInRange();
        return isRowValid && isColumnValid && isCrossValid && !isDuplicated && isValueInRange;
    }


    /**
     * Check Linear Validator. Check Row and Column
     *
     * @param isColumnChecking checking row or column
     * @return isLinearValid Linear is valid or not
     */
    private boolean isLinearValid(boolean isColumnChecking){

        for (int i = 0; i<numberOfFaces; i++){
            int nowValue = 0;
            for (int j = 0; j<numberOfFaces; j++){
                if(isColumnChecking)
                    nowValue += cubeValues[j][i];
                else
                    nowValue += cubeValues[i][j];
            }
            if(magicNumber == -1){
                magicNumber = nowValue;
            }else if(magicNumber != nowValue){
                if(isColumnChecking){
                    reasons.add("Horizontal line : " + String.valueOf(i+1) + " failure");
                }else
                {
                    reasons.add("Vertical line : " + String.valueOf(i+1) + " failure");
                }
                return false;
            }
        }
        return true;
    }

    /**
     * Check isCrossValid
     *
     * @return isCrossValid check cross values valid or not
     */
    private boolean isCrossValid(){
        int nowValue = 0;
        for (int i = 0; i<numberOfFaces;i++){
            nowValue += cubeValues[i][i];
        }
        if(nowValue != magicNumber){
            reasons.add("Diagonal line failure");
            return false;
            
        }

        nowValue = 0;

        for (int j =0; j<numberOfFaces; j++){
            nowValue += cubeValues[(numberOfFaces-1)-j][(numberOfFaces-1)-j];
        }

        if(nowValue != magicNumber){
            reasons.add("Diagonal line failure");
            return false;
        }

        return true;
    }

    /**
     * Check whether inputs are duplicated.
     *
     * @return isDuplicated whether input are duplication.
     */
    private boolean isDuplicated(){
        List<Integer> tempList = new ArrayList<>();
        for (int i=0; i<numberOfFaces;i++){
            for(int j =0;j<numberOfFaces;j++){
                int value = cubeValues[i][j];
                if(tempList.contains(value)){
                    reasons.add("Data Duplication Detected.");
                    return true;
                }else {
                    tempList.add(value);
                }
            }
        }
        return false;
    }

    /**
     * Check Value is below Range
     *
     * @return isValueInRange inputs are in range or not
     */
    private boolean isValueInRange(){
        for (int i =0;i<numberOfFaces; i++){
            for (int j= 0;j<numberOfFaces;j++){
                if(cubeValues[i][j] > 10 || cubeValues[i][j] < 1){
                    reasons.add("Value is not in range of 1 to 9.");
                    return false;
                }
            }
        }
        return true;
    }



    /**
     * Print Reason why Cube is not valid.
     */
    public void printReasons(){
      for(String reason : reasons){
          System.err.println("Reason : " + reason);
      }
    }
}

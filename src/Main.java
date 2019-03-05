import util.LogoPrinter;
import util.MagicCubeLogoPrinter;

public class Main {

    /**
     * This is main method
     * @param args
     */
    public static void main(String[] args) {
        ModeReader modeReader = new ModeReader();
        LogoPrinter logoPrinter = new MagicCubeLogoPrinter();
        logoPrinter.printLogo();

        while (true) {
            int mode = modeReader.read();
            if (mode == -1) {
                continue;
            }else if(mode == 1) {
                System.exit(1);
            }
            CubeGame magicCube = new MagicCubeGame();
            magicCube.startGame();
        }
    }
}

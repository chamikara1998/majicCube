package util;

/**
 * This Class for print Magic cube logo
 */
public class MagicCubeLogoPrinter implements LogoPrinter {

    /**
     * This method for Print Magic cube Splash Logo
     */
    @Override
    public void printLogo() {
        System.out.println("\t\t\t  ____                                       \n" +
                "\t\t\t /\\' .\\    _____                             \n" +
                "\t\t\t/: \\___\\  / .  /\\                            \n" +
                "\t\t\t\\' / . / /____/..\\                           \n" +
                "\t\t\t \\/___/  \\'  '\\  /                           \n" +
                "\t\t\t          \\'__'\\/                            ");


        System.out.println("  ___  ___            _        _____       _            \n" +
               "  |  \\/  |           (_)      /  __ \\     | |           \n" +
               "  | .  . | __ _  __ _ _  ___  | /  \\/_   _| |__   ___   \n" +
               "  | |\\/| |/ _` |/ _` | |/ __| | |   | | | | '_ \\ / _ \\  \n" +
               "  | |  | | (_| | (_| | | (__  | \\__/| |_| | |_) |  __/  \n" +
               "  \\_|  |_/\\__,_|\\__, |_|\\___|  \\____/\\__,_|_.__/ \\___   \n" +
               "                 __/ |                                  \n" +
               "                |___/                                   ");
        System.out.println("Author - Chamikara Samarasekara");
        System.out.println("Version - 1.0.1 \n\n");
    }
}

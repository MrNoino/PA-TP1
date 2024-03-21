package tp1.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import tp1.model.User;

/**
 * Class that represents the main program
 */
public class Main {

    private static User loggedUser;

    /**
     * Main function to run the program
     *
     * @param args arguments received via console
     */
    public static void main(String[] args) {

        long startProrgamMilis = System.currentTimeMillis();

        InputReader.openScanner();

        MainViews mainViews = new MainViews();
        mainViews.showNoManagerMenu();
        mainViews.showMainMenu();

        InputReader.closeScanner();

        long endProgramMilis = System.currentTimeMillis();
        Main.printExecutionTime(startProrgamMilis, endProgramMilis);

    }

    /**
     * get the user logged in
     *
     * @return the user logged in
     */
    public static User getLoggedUser() {
        return Main.loggedUser;
    }

    /**
     * Assigns the user that logged in
     *
     * @param loggedUser the user logged in
     */
    public static void setLoggedUserId(User loggedUser) {
        Main.loggedUser = loggedUser;
    }

    /**
     * Logout by print a goodbye message and setting user as null
     */
    public static void logout() {
        if (Main.getLoggedUser() != null) {
            System.out.println("Adeus " + Main.getLoggedUser().getUsername() + "\n");
        }
        Main.setLoggedUserId(null);
    }

    /**
     * Prints the execution time of the program
     *
     * @param startTime the time in miliseconds that the program had when
     * started
     * @param endTime the time in miliseconds that the program had when finished
     */
    public static void printExecutionTime(long startTime, long endTime) {
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("EEEE';' yyyy-MM-dd HH:mm:ss");

        System.out.println("Início do processo: " + datetimeFormat.format(new Date(startTime)));
        System.out.println("Fim do processo: " + datetimeFormat.format(new Date(endTime)));
        long miliseconds = endTime - startTime, seconds = miliseconds / 1000, minutes = seconds / 60, hours = minutes / 60;
        System.out.println("Tempo de execução: " + miliseconds + " Milissegundos (" + seconds + " Segundos; " + minutes + " Minutos; " + hours + " Horas)");
    }

}

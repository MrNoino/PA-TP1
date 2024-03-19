package tp1.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import tp1.controller.ManageAuthors;
import tp1.controller.ManageReviewers;
import tp1.controller.ManageUsers;
import tp1.model.Author;
import tp1.model.DbWrapper;
import tp1.model.Reviewer;
import java.sql.*;
import java.util.ArrayList;
import tp1.controller.ManageLiteracyStyles;
import tp1.controller.ManageManagers;
import tp1.model.LiteraryStyle;
import tp1.model.Manager;
import tp1.model.User;

/**
 *
 * @author Nuno
 */
public class Main {

    private static User loggedUser;

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
     * @return the user logged in
     */
    public static User getLoggedUser() {
        return Main.loggedUser;
    }

    /**
     * Assigns the user that logged in
     * @param loggedUser the user logged in
     */
    public static void setLoggedUserId(User loggedUser) {
        Main.loggedUser = loggedUser;
    }
    
    /**
     * Prints the execution time of the program
     * @param startTime the time in miliseconds that the program had when started
     * @param endTime the time in miliseconds that the program had when finished
     */
    public static void printExecutionTime(long startTime, long endTime){
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("EEEE';' yyyy-MM-dd HH:mm:ss");
        
        System.out.println("\nInício do processo: " + datetimeFormat.format(new Date(startTime)));
        System.out.println("Fim do processo: " + datetimeFormat.format(new Date(endTime)));
        long miliseconds = endTime - startTime, seconds = miliseconds /1000, minutes = seconds /60, hours = minutes /60; 
        System.out.println("Tempo de execução: " + miliseconds + " Milissegundos (" + seconds + " Segundos; " + minutes + " Minutos; " + hours + " Horas)");
    }

}

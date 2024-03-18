package tp1.view;

import java.awt.LayoutManager;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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

        boolean insertedManager = false;
        ManageManagers manageManagers = new ManageManagers();
        
        do{
            
            if(manageManagers.getTotalManagers() == 0){
                System.out.println("Registo de Gestor\n");

                String name = InputReader.readString("Nome: "),
                    username = InputReader.readString("Nome de utilizador: ");
                
                DbWrapper dbWrapper = new DbWrapper();
                dbWrapper.connect();
                ResultSet resultSet = dbWrapper.query("CALL exists_username(?);", new Object[]{username});
                try {
                    if(resultSet != null && resultSet.next()){
                        if(resultSet.getBoolean("exists")){
                            System.out.println("\nNome de utilizador já em uso.\n");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    insertedManager = false;
                    continue;
                }finally{
                    dbWrapper.disconnect();
                }
                String password = InputReader.readString("Palavra Passe: "),
                email = InputReader.readString("Email: ", "\nEmail inválido, tente novamente\n", "[\\w._-]{3,}@[\\w_]{3,}.\\w{2,5}");
                
                resultSet = dbWrapper.query("CALL exists_email(?);", new Object[]{email});
                try {
                    if(resultSet != null && resultSet.next()){
                        if(resultSet.getBoolean("exists")){
                            System.out.println("\nEmail já em uso.\n");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    insertedManager = false;
                    continue;
                }finally{
                    dbWrapper.disconnect();
                }
                
                if(manageManagers.insertManager(new Manager(1,
                                                    name, 
                                                    username,
                                                    password,
                                                    email, 
                                                    insertedManager, 
                                                    insertedManager, 1))){
                    insertedManager = true;
                    System.out.println("\nRegistado com sucesso\n");
                }else{
                    insertedManager = false;
                    System.out.println("\nErro ao registar\n");
                }
            }else{
                insertedManager = true;
            }
            
        }while(!insertedManager);
        
        int option;
        do {
            option = InputReader.readInt("**** LOGIN ****\n"
                    + "1. Iniciar Sessão\n"
                    + "2. Registar Utilizador\n"
                    + "3. Alterar parâmetros de acesso à base de dados\n"
                    + "0. Sair\n\n"
                    + "Escolha: ", "\nOpção inválida, tente novamente\n", 0, 3);

            switch (option) {
                case 1 -> {
                    ManageUsers manageUsers = new ManageUsers();
                    User user = manageUsers.login(InputReader.readString("Nome de utilizador: "), InputReader.readString("Palavra Passe: "));
                    if (user != null) {
                        if(user.isActive()){
                            Main.loggedUser = user;
                            System.out.println("\nBem vindo " + user.getUsername() + "\n");
                        }else{
                            System.out.println("\nUtilizador desativado\n");
                        }
                    }
                }
                case 2 -> {
                    int subOption = InputReader.readInt("\n**** Tipo de Utilizador ****\n\n"
                            + "1. Autor\n"
                            + "2. Revisor\n"
                            + "0. Voltar\n\n"
                            + "Escolha: ", 0, 2);
                    System.out.println();
                    if(subOption != 0) {  
                        String name = InputReader.readString("Nome: "),
                        username = InputReader.readString("Nome de utilizador: ");
                        DbWrapper dbWrapper = new DbWrapper();
                        dbWrapper.connect();
                        ResultSet resultSet = dbWrapper.query("CALL exists_username(?);", new Object[]{username});
                        try {
                            if(resultSet == null || !resultSet.next())
                                continue;
                            
                            if(resultSet.getBoolean("exists")){
                                System.out.println("\nNome de utilizador já em uso.\n");
                                continue;
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally{
                            dbWrapper.disconnect();
                        }
                        String password = InputReader.readString("Palavra Passe: "),
                        email = InputReader.readString("Email: ", "\nEmail inválido, tente novamente\n", "[\\w._-]{3,}@[\\w_]{3,}.\\w{2,5}");
                        resultSet = dbWrapper.query("CALL exists_email(?);", new Object[]{email});
                        try {
                            if(resultSet == null || !resultSet.next())
                                continue;
                            
                            if(resultSet.getBoolean("exists")){
                                System.out.println("\nEmail já em uso.\n");
                                continue;
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally{
                            dbWrapper.disconnect();
                        }
                        String nif = InputReader.readString("NIF: ", "\nNIF inválido, tente novamente\n", "\\d{9}");
                        resultSet = dbWrapper.query("CALL exists_nif(?);", new Object[]{nif});
                        try {
                            if(resultSet == null || !resultSet.next())
                                continue;
                            
                            if(resultSet.getBoolean("exists")){
                                System.out.println("\nNIF já em uso.\n");
                                continue;
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally{
                            dbWrapper.disconnect();
                        }
                        String phone = InputReader.readString("Telemóvel: ", "\nTelemóvel inválido, tente novamente\n", "[239]\\d{8}"),
                        address = InputReader.readString("Morada: ");
                        
                        switch (subOption) {
                            case 1:
                                
                                ManageLiteracyStyles manageLiteracyStyles = new ManageLiteracyStyles();
                                ArrayList<LiteraryStyle> literaryStyles = manageLiteracyStyles.getLiteracyStyles();
                                if(literaryStyles == null){
                                    System.out.println("\nEstilos literários inixestentes.\n");
                                    continue;
                                }
                                String msg = "Estilos Literários\n";
                                for(int i = 0; i < literaryStyles.size(); i++){
                                    msg += (i+1) + ". " + literaryStyles.get(i).getLiteraryStyle() + "\n";
                                }
                                msg += "Escolha: ";
                                
                                int literaryStyleId = literaryStyles.get(InputReader.readInt(msg, 1, literaryStyles.size()) - 1).getId();
                                
                                ManageAuthors manageAuthors = new ManageAuthors();
                                if(manageAuthors.insertAuthor(new Author(-1,
                                                                name,
                                                              username,
                                                              password,
                                                                email,
                                                               false,
                                                              false,
                                                               3,
                                                                 nif,
                                                                phone,
                                                              address,
                                                       new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                                                         literaryStyleId))){
                                    System.out.println("\nRegistado com sucesso\n");
                                }else{
                                    System.out.println("\nErro ao registar\n");
                                }
                                break;
                            case 2:
                                String graduation = InputReader.readString("Formação Académica: "),
                                       specialization = InputReader.readString("Área de especialização: ");
                                
                                ManageReviewers manageReviewers = new ManageReviewers();
                                if(manageReviewers.insertReviewer(new Reviewer(-1,
                                                                        name,
                                                                      username,
                                                                      password,
                                                                        email,
                                                                       false,
                                                                      false,
                                                                       2,
                                                                         nif,
                                                                        phone,
                                                                      address,
                                                                    graduation,
                                                                 specialization))){
                                    System.out.println("\nRegistado com sucesso\n");
                                }else{
                                    System.out.println("\nErro ao registar\n");
                                }
                                break;
                            default:
                                System.out.println("\nOpção inválida, tente novamente\n");
                                break;
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Alterações das propriedades da base de dados\n");
                    DbWrapper dbWrapper = new DbWrapper(InputReader.readString("Host: "),
                            InputReader.readString("Porto: "),
                            InputReader.readString("Nome: "),
                            InputReader.readString("Utilizador: "),
                            InputReader.readString("Palavra Passe: "));
                    if (dbWrapper.saveProperties()) {
                        System.out.println("\nAlterações feitas com sucesso\n");
                    } else {
                        System.err.println("\nErro ao alterar as propriedades\n");
                    }

                }
                case 0 -> {
                    break;
                }
                default ->
                    System.out.println("\nOpção inválida, tente novamente\n");

            }

        } while (option != 0);

        InputReader.closeScanner();
        
        long endProgramMilis = System.currentTimeMillis();
        Main.printExecutionTime(startProrgamMilis, endProgramMilis);

    }

    public static User getLoggedUser() {
        return Main.loggedUser;
    }

    public static void setLoggedUserId(User loggedUser) {
        Main.loggedUser = loggedUser;
    }
    
    public static void printExecutionTime(long startTime, long endTime){
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("EEEE';' yyyy-MM-dd HH:mm:ss");
        
        System.out.println("\nInício do processo: " + datetimeFormat.format(new Date(startTime)));
        System.out.println("Fim do processo: " + datetimeFormat.format(new Date(endTime)));
        long miliseconds = endTime - startTime, seconds = miliseconds /1000, minutes = seconds /60, hours = minutes /60; 
        System.out.println("Tempo de execução: " + miliseconds + " Milissegundos (" + seconds + " Segundos; " + minutes + " Minutos; " + hours + " Horas)");
    }

}

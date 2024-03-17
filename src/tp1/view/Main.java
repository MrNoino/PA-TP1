package tp1.view;

import tp1.controller.ManageManagers;
import tp1.controller.ManageUsers;
import tp1.model.DbWrapper;
import tp1.model.User;

/**
 *
 * @author Nuno
 */
public class Main {
    
    private static User loggedUser;

    public static void main(String[] args) {
        
        InputReader.openScanner();
        
        int option;
        
        do {
            
            option = InputReader.readInt("**** LOGIN ****\n"
                                        + "1. Iniciar Sessão\n"
                                        + "2. Registar Utilizador\n"
                                        + "3. Alterar parâmetros de acesso à base de dados\n"
                                        + "0. Sair\n\n"
                                        + "Escolha: ","\nOpção inválida, tente novamente\n", 0, 3);    
            System.out.println();
            
            switch (option) {
                case 1 -> {
                    
                    /*DbWrapper dbWrapper = new DbWrapper();
                    if(!dbWrapper.saveProperties())
                        System.out.println("Não gravado");
                    ResultSet resultSet = dbWrapper.query("SELECT * FROM get_users;");
                    
                    if(resultSet == null)
                        continue;
                    
                    try {
                        System.out.println("\tUtilizadores\n");
                        while(resultSet.next()){
                            System.out.println("ID: " + resultSet.getLong("id") + "\nNome: " + resultSet.getString("name"));
                        }
                        System.out.println();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally{
                        dbWrapper.closeConnection();
                    }
                    
                    ManageManagers manageManagers = new ManageManagers();
                    System.out.println("Nr. total de gestores: " + manageManagers.getTotalManagers());
                    */
                    
                    
                    ManageUsers manageUsers = new ManageUsers();
                    User user = manageUsers.login(InputReader.readString("Nome de utilizador: "), InputReader.readString("Palavra Passe: "));
                    
                    if(user != null){
                        Main.loggedUser = user;
                        System.out.println("\nBem vindo " + user.getUsername() + "\n");
                    }
                    
                    
                }  
                case 2 -> {
                    int subOption = InputReader.readInt("\tRegistrar-se como:\n\n"
                                                        + "1. Autor\n"
                                                        + "2. Revisor\n"
                                                        + "0. Voltar\n\n"
                                                        + "Escolha: ", 0, 2);
                    System.out.println();
                    
                    switch (subOption) {
                        case 1:
                            
                            break;
                        case 2:
                            
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("\nOpção inválida, tente novamente\n");
                    }
                }
                case 3 -> {
                    System.out.println("Alterações das propriedades da base de dados\n");
                    DbWrapper dbWrapper = new DbWrapper(InputReader.readString("Host: "),
                                                        InputReader.readString("Porto: "),
                                                     InputReader.readString("Nome: "),
                                                        InputReader.readString("Utilizador: "),
                                                     InputReader.readString("Palavra Passe: "));
                    if(dbWrapper.saveProperties())
                        System.out.println("\nAlterações feitas com sucesso\n");
                    else
                        System.err.println("\nErro ao alterar as propriedades\n");
                    
                }
                case 0 -> {
                    System.exit(0);
                }  
                default -> System.out.println("\nOpção inválida, tente novamente\n");
                    
            }
            
        } while (option != 1);
        
        InputReader.closeScanner();
        
        System.out.println("Programa Encerrado");
        
    }
    
    public static User getLoggedUser(){
        return Main.loggedUser;
    }
    
    public static void setLoggedUserId(User loggedUser){
        Main.loggedUser = loggedUser;
    }
    
}

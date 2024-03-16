package tp1.view;

/**
 *
 * @author Nuno
 */
public class TP1 {

    public static void main(String[] args) {
        
        InputReader.openScanner();
        
        int option;
        
        do {
            
            option = InputReader.readInt("**** LOGIN ****\n1. Iniciar Sessão\n2. Registar Utilizador\n3. Alterar parâmetros de acesso à base de dados\n0. Sair\n\nEscolha: ","\nOpção inválida, tente novamente\n", 0, 2);    
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
                    
                    
                }
                
                
                   
                case 2 -> {
                    
                    
                    
                }
                
                case 3 -> {
                    
                    
                    
                }
      
                case 0 -> {
                    
                    
                }
                    
                default -> System.out.println("\nOpção inválida, tente novamente\n");
                    
            }
            
        } while (option != 0);
        
        InputReader.closeScanner();
        
        System.out.println("Programa Encerrado");
        
    }
    
}

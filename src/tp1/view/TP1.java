package tp1.view;

import tp1.model.DbWrapper;

/**
 *
 * @author Nuno
 */
public class TP1 {

    public static void main(String[] args) {
        
        InputReader.initializeScanner();
        
        int option;
        
        do {
            
            option = InputReader.readInt("**** LOGIN ****\n1. Iniciar Sessão\n2. Registar Utilizador\n0. Sair\n\nEscolha: ","\nOpção inválida, tente novamente\n", 0, 2);    
            System.out.println();
            
            switch (option) {
                case 1 -> {
                    
                    DbWrapper dbWrapper = new DbWrapper("localhost", "3306", "pa_tp", "root", "root");
                    
                    dbWrapper.query();
                    
                }
                   
                case 2 -> {
                    
                    
                    
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

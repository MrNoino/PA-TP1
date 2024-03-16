package tp1.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Nuno
 */
public class InputReader {
    
    private static Scanner scanner;
    
    public static void openScanner(){
        scanner = new Scanner(System.in);
    }
    
    public static void closeScanner(){
        scanner.close();
        scanner = null;
    }
    
    public static int readInt(String msg){
        int number = 0;
        boolean validNumber;
        
        do{
            try{
                System.out.print(msg);
                number = scanner.nextInt();
                validNumber = true;
            }catch(InputMismatchException e){
                validNumber = false;
                System.out.println("\nEntrada de tipo inválido, tente novamente\n");
                
            }finally{
                scanner.nextLine();
            }
        }while(!validNumber);
        
        return number;
    }
    
    public static int readInt(String msg, String invalidInputMsg, int min, int max){
        int number = 0;
        boolean validNumber;
        
        do{
            try{
                System.out.print(msg);
                number = scanner.nextInt();
                validNumber = number >= min && number <= max;
                
                if(!validNumber)
                    System.out.println(invalidInputMsg);
            }catch(InputMismatchException e){
                validNumber = false;
                System.out.println("\nEntrada de tipo inválido, tente novamente\n");
                
            }finally{
                scanner.nextLine();
            }
        }while(!validNumber);
        
        return number;
    }
    
    public static long readLong(String msg){
        long number = 0;
        boolean validNumber;
        
        do{  
            try{
                System.out.print(msg);
                number = scanner.nextLong();
                validNumber = true;
            }catch(InputMismatchException e){
                validNumber = false;
                System.out.println("\nEntrada de tipo inválido, tente novamente\n");
            }finally{
                scanner.nextLine();
            }
        }while(!validNumber);
        
        return number; 
    }
    
    public static float readFloat(String msg){
        float number = 0;
        boolean validNumber;
        
        do{
            
            try{
                System.out.print(msg);
                number = scanner.nextFloat();
                validNumber = true;
            }catch(InputMismatchException e){
                validNumber = false;
                System.out.println("\nEntrada de tipo inválido, tente novamente\n");
                
            }finally{
                scanner.nextLine();
            }
        }while(!validNumber);
        
        return number;
    }
    
    public static String readString(String msg){
        System.out.print(msg);
        return scanner.nextLine();
    }
    
    public static String readString(String msg, String invalidInputMsg, String expression){
        String str = "";
        boolean validStr = false;
        
        do{
            System.out.print(msg);
            str = scanner.nextLine();
            
            validStr = str.matches(expression);
            
            if(!validStr)
                System.out.println(invalidInputMsg);
        }while(!validStr);
        
        return str;
    }
}

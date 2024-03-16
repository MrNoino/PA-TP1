package tp1.model;
import java.sql.*;

/**
 *
 * @author Nuno
 */
public class DbWrapper {
    
    private Connection connection;
    
    private String host;
    private String port;
    private String database;
    private String user;
    private String password;

    public DbWrapper(String host, String port, String database, String user, String password) {
        
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
        
    }
    
    
    
    public boolean getConnection(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.user, this.password);
            return true;
        } catch (ClassNotFoundException e) {
            
        } catch (SQLException e) {
            
        }
        
        return false;
        
    }
    
    public boolean closeConnection(){
        
        try {
            this.connection.close();
            return true;
        } catch (SQLException e) {
            
        }
        return false;
    }
    
    public void query(){
        
        this.getConnection();
        
        Statement statement = null;
        
        try {
            statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * FROM get_users;");
            while(resultSet.next()){
                
                System.out.println(resultSet.getInt("id"));
                
            }
        } catch (SQLException e) {
            
        }
        
        try {
            statement.close();
        } catch (SQLException e) {
            
        }
        
        this.closeConnection();
        
    }
    
}

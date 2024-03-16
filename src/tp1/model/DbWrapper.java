package tp1.model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public DbWrapper(String fileName) {
        if(!this.loadProperties(fileName))
            this.setProperties("localhost", "3306", "pa_tp", "root", "root");
    }
    
    public DbWrapper() {
        if(!this.loadProperties())
            this.setProperties("localhost", "3306", "pa_tp", "root", "root");
    }
    
    public boolean loadProperties(String fileName){
        File file  = new File(fileName);

        if(!file.exists())
            return false;

        FileReader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        
        BufferedReader input = new BufferedReader( reader );
        try { 
            this.host = input.readLine();
            this.port = input.readLine();
            this.database = input.readLine();
            this.user = input.readLine();
            this.password = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally{
            try {
                input.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    public boolean loadProperties(){
        return this.loadProperties("db_properties.txt");
    } 
    
    public void setProperties(String host, String port, String database, String user, String password){
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }
    
    public boolean saveProperties(String fileName){
        File file = new File(fileName);
        FileWriter writer;
        try {
            writer = new FileWriter( file );
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        BufferedWriter output = new BufferedWriter( writer );
        try {
            output.write(this.host + "\n" + this.port + "\n" + this.database + "\n" + this.user + "\n" + this.password);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally{
            try {
                output.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            
        return true;
    }
    
    public boolean saveProperties(){
        return this.saveProperties("db_properties.txt");
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
    
    public ResultSet query(String sqlQuery){
        this.getConnection();
        
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            return statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            return null;
        }
    }
    
    public ResultSet query(String sqlQuery, Object[] values){
        this.getConnection();
        
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement(sqlQuery);
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            return null;
        }
    }
    
    public int manipulate(String sqlQuery, Object[] values){
        this.getConnection();
        
        PreparedStatement preparedStatement = null;
        int rowCount = 0;
        try {
            preparedStatement = this.connection.prepareStatement(sqlQuery);
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }
            rowCount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            rowCount = 0;
        }finally{
            if(preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {}
            this.closeConnection();
        }
        return rowCount;
    } 
}

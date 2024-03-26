package tp1.controller;

import java.util.ArrayList;
import tp1.model.DbWrapper;
import tp1.model.LiteraryStyle;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp1.model.Log;
import tp1.view.Main;

/**
 * A class to manage literacy styles on the database
 */
public class ManageLiteracyStyles {

    private ArrayList<LiteraryStyle> literacyStyles;

    public ManageLiteracyStyles() {
        literacyStyles = new ArrayList<LiteraryStyle>();
    }

    /**
     *
     * @return Returns a list of literacy styles
     */
    public ArrayList<LiteraryStyle> getLiteracyStyles() {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("SELECT * FROM get_literary_styles;");
        try {
            if(resultSet == null)
                return null;
            if (Main.getLoggedUser() != null) {
                new ManageLogs().insertLog(new Log(Main.getLoggedUser().getId(),
                        new SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date()),
                        "Listou Estilos Literários"));
            }
            while(resultSet.next())
                this.literacyStyles.add(new LiteraryStyle(resultSet.getInt("id"), resultSet.getString("literary_style")));
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally{
            dbWrapper.disconnect();
        }
        
        return this.literacyStyles;
    }
}

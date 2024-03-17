package tp1.controller;

import java.util.ArrayList;
import tp1.model.DbWrapper;
import tp1.model.LiteraryStyle;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ResultSet resultSet = dbWrapper.query("SELECT * FROM get_literary_styles;");
        try {
            if(resultSet == null || !resultSet.next())
                return null;
            while(resultSet.next())
                this.literacyStyles.add(new LiteraryStyle(resultSet.getInt("id"), resultSet.getString("literary_style")));
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        return this.literacyStyles;
    }

    /**
     * Adds a literacy style
     *
     * @param literacyStyle The literacy style to add to the list
     * @return Confirms if a literacy style was added successfully
     */
    public boolean addLiteracyStyle(LiteraryStyle literacyStyle) {
        return true;
    }

    /**
     * Updates a literacy style
     *
     * @param literacyStyle The literacy style to be updated
     * @return Confirms if a literacy style was updated successfully
     */
    public boolean updateLiteracyStyle(LiteraryStyle literacyStyle) {
        return true;
    }

    /**
     * Deletes a literacy style
     *
     * @param literacyStyle The literacy style to be deleted
     * @return Confirms if a literacy style was deleted successfully
     */
    public boolean deleteLiteracyStyle(LiteraryStyle literacyStyle) {
        return true;
    }
}

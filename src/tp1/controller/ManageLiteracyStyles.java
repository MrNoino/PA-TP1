package tp1.controller;

import java.util.ArrayList;
import tp1.model.LiteracyStyle;

/**
 *
 * @author lighttigerXIV
 */
public class ManageLiteracyStyles {

    private ArrayList<LiteracyStyle> literacyStyles;

    public ManageLiteracyStyles() {
        literacyStyles = new ArrayList<LiteracyStyle>();
    }

    /**
     *
     * @return Returns a list of literacy styles
     */
    public ArrayList<LiteracyStyle> getLiteracyStyles() {
        return this.literacyStyles;
    }

    /**
     * Adds a literacy style
     *
     * @param literacyStyle The literacy style to add to the list
     * @return Confirms if a literacy style was added successfully
     */
    public boolean addLiteracyStyle(LiteracyStyle literacyStyle) {
        return true;
    }

    /**
     * Updates a literacy style
     *
     * @param literacyStyle The literacy style to be updated
     * @return Confirms if a literacy style was updated successfully
     */
    public boolean updateLiteracyStyle(LiteracyStyle literacyStyle) {
        return true;
    }

    /**
     * Deletes a literacy style
     *
     * @param literacyStyle The literacy style to be deleted
     * @return Confirms if a literacy style was deleted successfully
     */
    public boolean deleteLiteracyStyle(LiteracyStyle literacyStyle) {
        return true;
    }
}

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

    public ArrayList<LiteracyStyle> getLiteracyStyles() {
        return this.literacyStyles;
    }

    public boolean addLiteracyStyle(LiteracyStyle literacyStyle) {
        return true;
    }

    public boolean updateLiteracyStyle(LiteracyStyle literacyStyle) {
        return true;
    }

    public boolean deleteLiteracyStyle(LiteracyStyle literacyStyle) {
        return true;
    }
}
